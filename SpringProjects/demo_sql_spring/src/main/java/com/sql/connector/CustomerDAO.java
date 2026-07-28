package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class CustomerDAO {

    @Autowired
    private DataSource dataSource;

    public void selectAllRows() {

        try (
                Connection con = dataSource.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM CustomerInfo");
        ) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("customerId") + " "
                                + rs.getString("customerName") + " "
                                + rs.getDouble("customerFees") + " "
                                + rs.getString("custAddress")
                );

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}