package com.example.aaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        String jdbcUrl = "jdbc:mysql://localhost:3306/org_correspondence";
        String username = "root";
        String password = "Mirkulafflax3458";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection to the database is established.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

//PMAK-64738a0414f6b700385da727-f72235517744a1be855137b4197f99b515 ---- api key