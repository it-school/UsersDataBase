package com.itschool.usersdatabase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
   @FXML
   PasswordField passwordField;

   @FXML
   TextField loginField;

   @FXML
   public void registerUser() throws IOException {
      Stage stage = new Stage();
      stage.setTitle("User registration form");
      stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("registrationForm.fxml")), 300, 300));
      stage.show();
   }

   public void loginClick(ActionEvent actionEvent) {
      String login = loginField.getText();
      String password = passwordField.getText();

      Alert alert = null;

      if (UsersApplication.users.contains(login, password)) {
         alert = new Alert(AlertType.INFORMATION);
         alert.setTitle("Login information");
         alert.setContentText(new User(login, password) + " exists in database");
      }
      else
      {
         alert = new Alert(AlertType.WARNING);
         alert.setTitle("Login information");
         alert.setContentText(new User(login, password) + " doesn't exists in database!");
      }
      alert.show();
   }
}