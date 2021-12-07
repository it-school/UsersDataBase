package com.itschool.usersdatabase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {
   @FXML
   PasswordField passwordField;

   @FXML
   TextField loginField;

   @FXML
   public void registerClick() {
      String login = loginField.getText();
      String password = passwordField.getText();

      Alert alert = null;
      User user = new User(login, password);
      if (UsersApplication.users.add(user)) {
         alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("User add information");
         alert.setContentText(user + " successfully registered");
      } else {
         alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle("Login information");
         alert.setContentText(user + " doesn't exists in database!");
      }
      alert.show();
   }

   public void cancelClick(ActionEvent actionEvent) {

   }
}
