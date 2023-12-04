package com.example.lv6;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField display;

    @FXML
    private double prviOperand = 0.0;

    @FXML
    private String operator = "";

    @FXML
    private String trenutniUnos = "";

    private void updateDisplay(){
        display.setText(trenutniUnos);
    }

    @FXML
    protected void numberButtonClicked(ActionEvent actionEvent){
       Button button = (Button) actionEvent.getSource();
       trenutniUnos = trenutniUnos + button.getText();

       updateDisplay();
    }

    @FXML
    protected void operatorButtonClicked(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        operator = button.getText();
        prviOperand = Double.parseDouble(trenutniUnos);
        trenutniUnos = "";
    }

    @FXML
    protected void equalsButtonClicked(ActionEvent actionEvent){
        double drugiOperand = Double.parseDouble(trenutniUnos);

        switch(operator){
            case "+":
                trenutniUnos = String.valueOf(prviOperand + drugiOperand);
                break;
            case "-":
                trenutniUnos = String.valueOf(prviOperand - drugiOperand);
                break;
            case "*":
                trenutniUnos = String.valueOf(prviOperand * drugiOperand);
                break;
            case "/":
                if(drugiOperand != 0)
                trenutniUnos = String.valueOf(prviOperand / drugiOperand);
                else trenutniUnos = "Error!";
                break;
        }

        updateDisplay();
    }

    @FXML
    protected void decimalButtonClicked(ActionEvent actionEvent){
        if (!trenutniUnos.contains(".")) {
            trenutniUnos += ".";
        }

        updateDisplay();
    }

    @FXML
    protected void clearButtonClicked(ActionEvent actionEvent){
        trenutniUnos = "";
        prviOperand = 0.0;
        operator = "";

        updateDisplay();
    }

}