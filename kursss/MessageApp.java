package com.example.aaa;
//PMAK-64738a0414f6b700385da727-f72235517744a1be855137b4197f99b515 ---- api key
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class MessageApp extends Application {
    private List<User> users;
    private List<Message> messages;
    private Stage primaryStage;
    private ListView<Message> messagesListView;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        users = new ArrayList<>();
        messages = new ArrayList<>();

        createLoginWindow();
    }

    private void createLoginWindow() {
        Stage loginStage = new Stage();
        loginStage.setTitle("Login");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Label nameLabel = new Label("Username:");
        TextField nameTextField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> createRegisterWindow());

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String name = nameTextField.getText();
            String password = passwordField.getText();

            if (name.isEmpty() || password.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Incomplete Login", "Please fill in all fields.");
            } else if (!isUserExists(name)) {
                showAlert(Alert.AlertType.WARNING, "Invalid Username", "The username does not exist.");
            } else if (!isPasswordCorrect(name, password)) {
                showAlert(Alert.AlertType.WARNING, "Invalid Password", "The password is incorrect.");
            } else {
                createMessageCategoriesWindow();
                loginStage.close();
            }
        });

        grid.add(nameLabel, 0, 0);
        grid.add(nameTextField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(registerButton, 0, 2);
        grid.add(loginButton, 1, 2);

        Scene scene = new Scene(grid, 300, 200);
        loginStage.setScene(scene);
        loginStage.show();
    }

    private void createRegisterWindow() {
        Stage registerStage = new Stage();
        registerStage.setTitle("Register");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Label nameLabel = new Label("Username:");
        TextField nameTextField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> {
            String name = nameTextField.getText();
            String password = passwordField.getText();

            if (name.isEmpty() || password.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Incomplete Registration", "Please fill in all fields.");
            } else if (isUserExists(name)) {
                showAlert(Alert.AlertType.WARNING, "Duplicate Username", "The username already exists.");
            } else {
                users.add(new User(name, password));
                showAlert(Alert.AlertType.INFORMATION, "Registration Successful", "You have been registered successfully.");
                registerStage.close();
            }
        });

        grid.add(nameLabel, 0, 0);
        grid.add(nameTextField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(registerButton, 0, 2, 2, 1);

        Scene scene = new Scene(grid, 300, 200);
        registerStage.setScene(scene);
        registerStage.show();
    }

    private void createMessageCategoriesWindow() {
        Stage categoriesStage = new Stage();
        categoriesStage.setTitle("Message Categories");

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));

        Button allMessagesButton = new Button("All Messages");
        allMessagesButton.setOnAction(e -> displayMessagesWindow("All"));

        Button myMessagesButton = new Button("My Messages");
        myMessagesButton.setOnAction(e -> displayMessagesWindow(getCurrentUserName()));

        vbox.getChildren().addAll(allMessagesButton, myMessagesButton);

        Scene scene = new Scene(vbox, 200, 150);
        categoriesStage.setScene(scene);
        categoriesStage.show();
    }

    private void displayMessagesWindow(String category) {
        Stage messagesStage = new Stage();
        messagesStage.setTitle("Messages");

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));

        messagesListView = new ListView<>();
        populateMessagesListView(category);

        Button composeButton = new Button("Compose");
        composeButton.setOnAction(e -> createComposeMessageWindow());

        vbox.getChildren().addAll(messagesListView, composeButton);

        Scene scene = new Scene(vbox, 400, 300);
        messagesStage.setScene(scene);
        messagesStage.show();
    }

    private void createComposeMessageWindow() {
        Stage composeStage = new Stage();
        composeStage.setTitle("Compose Message");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Label recipientLabel = new Label("Recipient:");
        TextField recipientTextField = new TextField();

        Label contentLabel = new Label("Content:");
        TextArea contentTextArea = new TextArea();

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            String recipient = recipientTextField.getText();
            String content = contentTextArea.getText();

            if (recipient.isEmpty() || content.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Incomplete Message", "Please fill in all fields.");
            } else if (!isUserExists(recipient)) {
                showAlert(Alert.AlertType.WARNING, "Invalid Recipient", "The recipient does not exist.");
            } else {
                messages.add(new Message(getCurrentUserName(), recipient, content, LocalDateTime.now()));
                showAlert(Alert.AlertType.INFORMATION, "Message Sent", "Your message has been sent successfully.");
                composeStage.close();
            }
        });

        grid.add(recipientLabel, 0, 0);
        grid.add(recipientTextField, 1, 0);
        grid.add(contentLabel, 0, 1);
        grid.add(contentTextArea, 1, 1);
        grid.add(sendButton, 0, 2, 2, 1);

        Scene scene = new Scene(grid, 400, 250);
        composeStage.setScene(scene);
        composeStage.show();
    }

    private void populateMessagesListView(String category) {
        messagesListView.getItems().clear();

        if (category.equals("All")) {
            messagesListView.getItems().addAll(messages);
        } else {
            for (Message message : messages) {
                if (message.getSender().equals(category) || message.getRecipient().equals(category)) {
                    messagesListView.getItems().add(message);
                }
            }
        }
    }

    private boolean isUserExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPasswordCorrect(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private String getCurrentUserName() {
        // Assuming only one user can be logged in at a time
        return users.get(0).getUsername();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}