package com.itschool.usersdatabase;

import java.util.Objects;

public class User {
   private String login;
   private String password;

   public User(String login) {
      this.setLogin(login);
      this.password = Password.generatePassword();
   }

   public User(String login, String password) {
      this.setLogin(login);
      if (Password.isValidPassword(password))
         this.setPassword(password);
      else
         this.setPassword(Password.generatePassword());
   }

   public boolean checkUser(final String login, final String password) {
      return this.password.equals(password) && this.login.equalsIgnoreCase(login.strip());
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login.strip().toLowerCase();
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof User)) return false;
      User user = (User) o;
      return Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getLogin(), getPassword());
   }

   @Override
   public String toString() {
      return "\nUser('" + login + "', '" + password + "')";
   }
}
