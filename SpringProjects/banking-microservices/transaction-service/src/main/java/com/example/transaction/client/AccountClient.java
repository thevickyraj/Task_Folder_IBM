package com.example.transaction.client;

import com.example.transaction.dto.AccountDto;
import com.example.transaction.exception.AccountServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Talks to account-service directly (host:port from config). In a full setup this
 * would instead call through the gateway or use service discovery (Eureka/Consul) -
 * kept simple here for local development.
 */
@Component
public class AccountClient {

    private final RestTemplate restTemplate;
    private final String accountServiceUrl;

    public AccountClient(RestTemplate restTemplate,
                          @Value("${services.account-service.url}") String accountServiceUrl) {
        this.restTemplate = restTemplate;
        this.accountServiceUrl = accountServiceUrl;
    }

    public AccountDto getAccount(Long accountId) {
        try {
            return restTemplate.getForObject(accountServiceUrl + "/account/{id}", AccountDto.class, accountId);
        } catch (HttpClientErrorException.NotFound e) {
            throw new AccountServiceException("Account not found: " + accountId);
        } catch (ResourceAccessException | HttpServerErrorException e) {
            throw new AccountServiceException("account-service is unavailable");
        }
    }

    public AccountDto credit(Long accountId, BigDecimal amount) {
        return exchangeBalance(accountId, amount, "credit");
    }

    public AccountDto debit(Long accountId, BigDecimal amount) {
        return exchangeBalance(accountId, amount, "debit");
    }

    private AccountDto exchangeBalance(Long accountId, BigDecimal amount, String operation) {
        try {
            HttpEntity<Map<String, BigDecimal>> entity = new HttpEntity<>(Map.of("amount", amount));
            var response = restTemplate.exchange(
                    accountServiceUrl + "/account/{id}/" + operation,
                    HttpMethod.PUT,
                    entity,
                    AccountDto.class,
                    accountId
            );
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new AccountServiceException("Account not found: " + accountId);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new AccountServiceException("Insufficient balance in account " + accountId);
        } catch (ResourceAccessException | HttpServerErrorException e) {
            throw new AccountServiceException("account-service is unavailable");
        }
    }
}
