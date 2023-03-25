

package com.example.login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnLogin;
    @FXML
    private ToggleGroup Maths;

    @FXML
    private Button btnCalculate;
    @FXML
    private Label lblResults;
    @FXML
    private RadioButton rbnAdd;
    @FXML
    private RadioButton rbnDiv;



    @FXML
    private Label lblLogin;

    @FXML
    private Label lblRegister;
    @FXML

    private Label lblDisplay;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;
    @FXML
    private Button btnlogOut;
    @FXML
    private ToggleGroup programmingGroup;

    @FXML
    private RadioButton rbnC;

    @FXML
    private RadioButton rbnJava;

    @FXML
    private RadioButton rbnPython;


    @FXML
    private RadioButton rbnSub;

    @FXML
    private TextField txtFirstNumber;

    @FXML
    private TextField txtSecondNumber;

String oldText="";//get old text from text field
    int oldCursorPosition=0;
    @FXML
    void checkNumbers(KeyEvent event) {
        //get the character on the key typed
        String typedKey=event.getCharacter();
        if(typedKey.matches("[a-z, A-Z,\\-,+,/]+$")){
            txtFirstNumber.setStyle("-fx-border-color:red");
            txtFirstNumber.setText(oldText);
            txtFirstNumber.positionCaret(oldCursorPosition);
            lblResults.setText("Please type numbers only");

        }else {
            txtFirstNumber.setStyle("-fx-border-color:blue");
        }
    }

    @FXML
    void getOldText(KeyEvent event) {
oldText=txtFirstNumber.getText();
        System.out.println(oldText);
        oldCursorPosition=txtFirstNumber.getCaretPosition();
    }
    @FXML
    void onCalculate(ActionEvent event) {
if(txtFirstNumber.getText().equals("")||txtSecondNumber.getText().equals("")){
    lblResults.setText("Please type numbers in the two boxes");
    lblResults.setTextFill(Color.RED);

}else{
    double firstNum= Double.parseDouble(txtFirstNumber.getText());
    double secondNum= Double.parseDouble(txtSecondNumber.getText());
    double results=0;
    if(rbnAdd.isSelected()){
        results=firstNum+secondNum;
        lblResults.setText(String.valueOf(results));
        txtFirstNumber.setText("");
        txtSecondNumber.setText("");
    } else if (rbnSub.isSelected()) {
results=firstNum-secondNum;
lblResults.setText(String.valueOf(results));
        txtFirstNumber.setText("");
        txtSecondNumber.setText("");
    } else if (rbnDiv.isSelected()) {
        results=firstNum/secondNum;
        lblResults.setText(String.valueOf(results));
        txtFirstNumber.setText("");
        txtSecondNumber.setText("");
    }
    else {
        results=firstNum*secondNum;
        lblResults.setText(String.valueOf(results));
        txtFirstNumber.setText("");
        txtSecondNumber.setText("");
    }
}
    }
    @FXML
    void onCancel(ActionEvent event) {
//exit or terminate the program
        Platform.exit();
    }



    @FXML
    void onLogOut(ActionEvent event) throws IOException {
        //hide main

        Stage newGet= (Stage) btnlogOut.getScene().getWindow();
        newGet.hide();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 400);
        Stage stage=new Stage();
        stage.setResizable(false);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void onLogin(ActionEvent event) throws IOException {
String getUser=txtUsername.getText();
String passWord=txtPassword.getText();





        if(getUser.equals("kevin")&&passWord.equals("1234")){


    Stage loginStage= (Stage) btnLogin.getScene().getWindow();
    loginStage.close();

    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainApp.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 620, 400);
    Stage stage=new Stage();
    stage.setResizable(false);
    stage.setTitle("Welcome");
    stage.setScene(scene);
    stage.show();



}
else {
    System.out.println("Wrong credentials");

lblLogin.setText("Wrong Credentials");
lblLogin.setTextFill(Color.RED);

            txtUsername.setText("");
            txtPassword.setText("");
}

    }

    @FXML
    void registerCick(MouseEvent event) {
lblRegister.setText("Student will design this");
    }
    @FXML
    void onSave(ActionEvent event) {
String selectedText="";
if(rbnJava.isSelected()){
selectedText=rbnJava.getText();

} else if (rbnPython.isSelected()) {
    selectedText=rbnPython.getText();
}
else{
    selectedText= rbnC.getText();
}
lblDisplay.setText(selectedText);
    }

}

