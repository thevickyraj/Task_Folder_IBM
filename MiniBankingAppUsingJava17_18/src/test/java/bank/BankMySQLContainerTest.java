package bank;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
class BankMySQLContainerTest {

    @Container
    static MySQLContainer<?> mysql =
            new MySQLContainer<>("mysql:8.0")
                    .withDatabaseName("bankdb")
                    .withUsername("bankuser")
                    .withPassword("bankpassword");

    @Test
    void shouldConnectToMySQLContainer() throws Exception {

        Connection connection =
                DriverManager.getConnection(
                        mysql.getJdbcUrl(),
                        mysql.getUsername(),
                        mysql.getPassword()
                );

        Statement statement = connection.createStatement();

        statement.executeUpdate("""
                CREATE TABLE customer (
                    id INT PRIMARY KEY,
                    name VARCHAR(100),
                    account_number VARCHAR(50)
                )
                """);

        statement.executeUpdate("""
                INSERT INTO customer
                VALUES (101, 'Vicky', 'BANK10001')
                """);

        ResultSet resultSet =
                statement.executeQuery(
                        "SELECT name FROM customer WHERE id = 101"
                );

        resultSet.next();

        assertEquals("Vicky", resultSet.getString("name"));

        connection.close();
    }
}
