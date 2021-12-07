package com.itschool.usersdatabase;

import java.util.ArrayList;

public class Users {
   private ArrayList<User> database;

   public Users() {
      database = new ArrayList<>();
   }

   public boolean add(final User user) {
      return addIfNoSuchUserInDatabase(user);
   }

   public boolean add(final String login, final String password) {
      User user = new User(login, password);

      return addIfNoSuchUserInDatabase(user);
   }

   public void remove(final String login)
   {
      for (User tempUser : database) {
         if (tempUser.getLogin().equalsIgnoreCase(login.strip())) ;
      }
   }

   public boolean contains(final String login, final String password)
   {
      User user = new User(login, password);

      for (User tempUser : database) {
         if (tempUser.equals(user))
            return true;
      }

      return false;
   }

   private boolean addIfNoSuchUserInDatabase(User user) {
      for (User tempUser : database) {
         if (tempUser.equals(user))
            return false;
      }
      this.database.add(user);

      return true;
   }

}
