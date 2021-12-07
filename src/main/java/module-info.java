module com.itschool.usersdatabase {
   requires javafx.controls;
   requires javafx.fxml;


   opens com.itschool.usersdatabase to javafx.fxml;
   exports com.itschool.usersdatabase;
}