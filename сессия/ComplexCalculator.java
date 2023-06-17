package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;




public class ComplexCalculator extends Application {

    private TextField inputField1;
    private TextField inputField2;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Label resultLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Комплексный калькулятор");


        inputField1 = new TextField();
        inputField2 = new TextField();
        addButton = new Button("Сложение");
        subtractButton = new Button("Вычитание");
        multiplyButton = new Button("Умножение");
        resultLabel = new Label();


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(new Label("Комплексное число 1:"), 0, 0);
        grid.add(inputField1, 1, 0);
        grid.add(new Label("Комплексное число 2:"), 0, 1);
        grid.add(inputField2, 1, 1);
        grid.add(addButton, 0, 2);
        grid.add(subtractButton, 1, 2);
        grid.add(multiplyButton, 2, 2);
        grid.add(resultLabel, 0, 3, 3, 1);

        // Назначение обработчиков событий
        addButton.setOnAction(event -> addComplexNumbers());
        subtractButton.setOnAction(event -> subtractComplexNumbers());
        multiplyButton.setOnAction(event -> multiplyComplexNumbers());

        // Создание сцены и отображение окна
        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addComplexNumbers() {
        try {
            double number1 = Double.parseDouble(inputField1.getText());
            double number2 = Double.parseDouble(inputField2.getText());

            ComplexNumber complex1 = new ComplexNumber(number1, 0);
            ComplexNumber complex2 = new ComplexNumber(number2, 0);
            ComplexNumber result = complex1.add(complex2);

            resultLabel.setText("Результат: " + result.toString());
        } catch (NumberFormatException e) {
            resultLabel.setText("Ошибка: неверный формат чисел");
        }
    }

    private void subtractComplexNumbers() {
        try {
            double number1 = Double.parseDouble(inputField1.getText());
            double number2 = Double.parseDouble(inputField2.getText());

            ComplexNumber complex1 = new ComplexNumber(number1, 0);
            ComplexNumber complex2 = new ComplexNumber(number2, 0);
            ComplexNumber result = complex1.subtract(complex2);

            resultLabel.setText("Результат: " + result.toString());
        } catch (NumberFormatException e) {
            resultLabel.setText("Ошибка: неверный формат чисел");
        }
    }

    private void multiplyComplexNumbers() {
        try {
            double number1 = Double.parseDouble(inputField1.getText());
            double number2 = Double.parseDouble(inputField2.getText());

            ComplexNumber complex1 = new ComplexNumber(number1, 0);
            ComplexNumber complex2 = new ComplexNumber(number2, 0);
            ComplexNumber result = complex1.multiply(complex2);

            resultLabel.setText("Результат: " + result.toString());
        } catch (NumberFormatException e) {
            resultLabel.setText("Ошибка: неверный формат чисел");
        }
    }
}