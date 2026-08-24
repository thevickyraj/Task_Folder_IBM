# banking-microservices

A minimal microservices skeleton with three Spring Boot modules:

| Service             | Port | Responsibility                                      |
|----------------------|------|------------------------------------------------------|
| gateway-service       | 8080 | Routes requests, validates JWTs, circuit-breaker fallbacks |
| account-service       | 8082 | Account CRUD, credit/debit, balance                  |
| transaction-service    | 8083 | Deposit / withdraw / transfer, calls account-service  |

Each service has its own in-memory H2 database and runs independently.

## Build everything

```bash
mvn clean install
```

## Run each service (separate terminals)

```bash
cd account-service     && mvn spring-boot:run
cd transaction-service && mvn spring-boot:run
cd gateway-service     && mvn spring-boot:run
```

Start `account-service` and `transaction-service` before the gateway, since
gateway routes forward there.

## Quick smoke test

```bash
# Create an account directly (bypassing the gateway/JWT for a quick check)
curl -X POST http://localhost:8082/account \
  -H "Content-Type: application/json" \
  -d '{"accountHolderName":"Asha Rao","accountType":"SAVINGS","initialBalance":1000}'

# Deposit into it via transaction-service
curl -X POST http://localhost:8083/transaction/deposit \
  -H "Content-Type: application/json" \
  -d '{"accountId":1,"amount":500,"remarks":"Salary"}'

# Through the gateway (needs a valid Bearer JWT signed with the secret
# in JwtAuthFilter, or hit /auth/login once an auth-service exists)
curl http://localhost:8080/account/1 -H "Authorization: Bearer <token>"
```

## Notes / next steps

- `gateway-service`'s `JwtAuthFilter` currently expects tokens signed with a
  hard-coded HMAC secret — wire this up to a real `auth-service` and move the
  secret to config/secret storage before using this beyond local dev.
- `transaction-service` calls `account-service` directly over HTTP
  (see `services.account-service.url` in its `application.yml`). Swap this
  for service discovery (Eureka/Consul) or route through the gateway if you
  add those later.
- `transfer` does a debit-then-credit with a manual compensating refund if
  the credit leg fails — not a full saga/distributed transaction, but keeps
  the example dependency-free. For production use, consider an outbox
  pattern or a saga orchestrator.
- No `auth-service` module yet — `/auth/login` and `/auth/register` are
  listed as public paths in `JwtAuthFilter` but nothing serves them yet.
