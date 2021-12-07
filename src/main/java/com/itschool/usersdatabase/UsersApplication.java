package com.itschool.usersdatabase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UsersApplication extends Application {
   public static Users users;

   @Override
   public void start(Stage stage) throws IOException {
      FXMLLoader fxmlLoader = new FXMLLoader(UsersApplication.class.getResource("mainForm.fxml"));
      Scene scene = new Scene(fxmlLoader.load(), 320, 240);
      stage.setTitle("Hello!");
      stage.setScene(scene);
      stage.show();
   }

   public static void main(String[] args) {
      users = new Users();
      launch();
   }
}