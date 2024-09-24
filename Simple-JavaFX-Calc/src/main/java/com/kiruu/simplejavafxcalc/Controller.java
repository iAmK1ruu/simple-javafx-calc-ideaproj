package com.kiruu.simplejavafxcalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    @FXML
    private Button btnplus, btnminus, btnmultiply, btndivide, btnac, btnequals;
    @FXML
    private Label label_output;

    private String firstOperand = ""; // Stores the first operand
    private String operator = "";     // Stores the operator (+, -, *, /)
    private String secondOperand = ""; // Stores the second operand

    // Handles number and operator button clicks
    public void getButtonValue(ActionEvent e) {
        String currentText = label_output.getText();
        Button sourceButton = (Button) e.getSource();
        String value = sourceButton.getText();

        // Check if the value is an operator or a number
        if (value.matches("[0-9]")) {
            label_output.setText(currentText + value);
        } else if (value.matches("[+\\-*/]")) {
            firstOperand = currentText;
            operator = value;
            label_output.setText(""); // Clear for the next operand
        }
    }

    // Clear button to reset the calculator
    public void clearConsole(ActionEvent e) {
        label_output.setText("");
        firstOperand = "";
        operator = "";
        secondOperand = "";
    }

    // Equals button logic
    public void calculateResult(ActionEvent e) {
        secondOperand = label_output.getText(); // Get the second operand
        double result = 0.0;

        // Convert strings to double for calculation
        double num1 = Double.parseDouble(firstOperand);
        double num2 = Double.parseDouble(secondOperand);

        // Perform the operation based on the operator
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    label_output.setText("Error"); // Handle division by zero
                    return;
                }
                break;
            default:
                break;
        }

        // Display the result
        label_output.setText(String.valueOf(result));

        // Reset operands and operator for next calculation
        firstOperand = "";
        secondOperand = "";
        operator = "";
    }
}
