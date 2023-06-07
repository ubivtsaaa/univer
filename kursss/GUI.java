package com.example.aaa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import javafx.scene.layout.GridPane;
import java.time.format.DateTimeFormatter;







import javafx.stage.Stage;

public class GUI extends Application {
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

        Button personalButton = new Button("Personal");
        personalButton.setOnAction(e -> createMessagesWindow("Personal"));

        Button businessButton = new Button("Requests");
        businessButton.setOnAction(e -> createMessagesWindow("Requests"));

        Button ordersButton = new Button("Orders");
        ordersButton.setOnAction(e -> createMessagesWindow("Orders"));

        vbox.getChildren().addAll(personalButton, businessButton, ordersButton);

        Scene scene = new Scene(vbox, 200, 200);
        categoriesStage.setScene(scene);
        categoriesStage.show();
    }

    private void createMessagesWindow(String category) {
        Stage messagesStage = new Stage();
        messagesStage.setTitle(category + " Messages");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        messagesListView = new ListView<>();

        Button addButton = new Button("Add Message");
        addButton.setOnAction(e -> createAddMessageWindow(category));

        Button deleteButton = new Button("Delete Message");
        deleteButton.setOnAction(e -> deleteSelectedMessage());

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            messagesStage.close();
            createMessageCategoriesWindow();
        });

        grid.add(messagesListView, 0, 0, 3, 1);
        grid.add(addButton, 0, 1);
        grid.add(deleteButton, 1, 1);
        grid.add(backButton, 2, 1);

        updateMessagesListView(category);

        Scene scene = new Scene(grid, 400, 300);
        messagesStage.setScene(scene);
        messagesStage.show();
    }

    private void createAddMessageWindow(String category) {
        Stage addMessageStage = new Stage();
        addMessageStage.setTitle("Add Message");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Label senderLabel = new Label("Sender:");
        TextField senderTextField = new TextField();

        Label recipientLabel = new Label("Recipient:");
        TextField recipientTextField = new TextField();

        Label categoryLabel = new Label("Category:");
        TextField categoryTextField = new TextField();
        categoryTextField.setText(category);
        categoryTextField.setEditable(false);

        Label messageLabel = new Label("Message:");
        TextArea messageTextArea = new TextArea();

        Button addButton = new Button("Add Message");
        addButton.setOnAction(e -> {
            String sender = senderTextField.getText();
            String recipient = recipientTextField.getText();
            String message = messageTextArea.getText();

            if (sender.isEmpty() || recipient.isEmpty() || message.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Incomplete Message", "Please fill in all fields.");
            } else {
                Message newMessage = new Message(sender, recipient, LocalDateTime.now(), message, category);
                messages.add(newMessage);
                showAlert(Alert.AlertType.INFORMATION, "Message Added", "The message has been added successfully.");
                updateMessagesListView(category);
                addMessageStage.close();
            }
        });

        grid.add(senderLabel, 0, 0);
        grid.add(senderTextField, 1, 0);
        grid.add(recipientLabel, 0, 1);
        grid.add(recipientTextField, 1, 1);
        grid.add(categoryLabel, 0, 2);
        grid.add(categoryTextField, 1, 2);
        grid.add(messageLabel, 0, 3);
        grid.add(messageTextArea, 0, 4, 2, 1);
        grid.add(addButton, 0, 5, 2, 1);

        Scene scene = new Scene(grid, 400, 300);
        addMessageStage.setScene(scene);
        addMessageStage.show();
    }

    private void updateMessagesListView(String category) {
        List<Message> categoryMessages = new ArrayList<>();

        for (Message message : messages) {
            if (message.getCategory().equals(category)) {
                categoryMessages.add(message);
            }
        }

        messagesListView.getItems().setAll(categoryMessages);
    }

    private void deleteSelectedMessage() {
        int selectedIndex = messagesListView.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            messagesListView.getItems().remove(selectedIndex);
            messages.remove(selectedIndex);
            showAlert(Alert.AlertType.INFORMATION, "Message Deleted", "The message has been deleted successfully.");
        } else {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a message to delete.");
        }
    }

    private boolean isUserExists(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPasswordCorrect(String name, String password) {
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class User {
        private String name;
        private String password;

        public User(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }
    }

    private static class Message {
        private String sender;
        private String recipient;
        private LocalDateTime dateTime;
        private String content;
        private String category;

        public Message(String sender, String recipient, LocalDateTime dateTime, String content, String category) {
            this.sender = sender;
            this.recipient = recipient;
            this.dateTime = dateTime;
            this.content = content;
            this.category = category;
        }

        public String getSender() {
            return sender;
        }

        public String getRecipient() {
            return recipient;
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }

        public String getContent() {
            return content;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDateTime = dateTime.format(formatter);

            return "Sender: " + sender + "\nRecipient: " + recipient + "\nDate/Time: " + formattedDateTime + "\nContent: " + content;
        }
    }
}