package com.itschool.usersdatabase;

import java.util.Random;

public class Password {
   public static final int MIN_PASSWORD_LENGTH = 8;
   /*
   прописная буква, 65..90
   строчная буква,  97..122
   цифра,           48..58
   не буква и не цифра 32..47, 59..64
*/
   public static String uppercaseLetters = "";
   public static String lowercaseLetters = "";
   public static String digits = "0123456789";
   public static String otherSymbols = "";

   static {
      for (int i = 65; i <= 90; i++) {
         uppercaseLetters += (char) i;
      }

      for (int i = 97; i <= 122; i++) {
         lowercaseLetters += (char) i;
      }

      for (int i = 32; i <= 64; i++) {
         if (i >= 48 && i <= 58)
            continue;

         otherSymbols += (char) i;
      }
   }

   public static boolean isValidPassword(String password) {
      if (password.length() < Password.MIN_PASSWORD_LENGTH)
         return false;

      boolean containsUpperCase = false, containsLowerCase = false, containsDigit = false, containsOther = false;

      for (int i = 0; i < password.length(); i++) {
         if (!containsUpperCase && Password.uppercaseLetters.contains(password.charAt(i) + ""))
            containsUpperCase = true;
         if (!containsLowerCase && Password.lowercaseLetters.contains(password.charAt(i) + ""))
            containsLowerCase = true;
         if (!containsDigit && Password.digits.contains(password.charAt(i) + ""))
            containsDigit = true;
         if (!containsOther && Password.otherSymbols.contains(password.charAt(i) + ""))
            containsOther = true;

         if (containsUpperCase && containsLowerCase && containsDigit && containsOther)
            return true;
      }

      return false;
   }

   /**
    * Generates random password, length - 8 chars
    *
    * @return generated password
    */
   public static String generatePassword() {
      String password = "";

      Random random = new Random();
      for (int i = 0; i < 2; i++) {
         password += Password.uppercaseLetters.charAt(random.nextInt(Password.uppercaseLetters.length()));
         password += Password.lowercaseLetters.charAt(random.nextInt(Password.lowercaseLetters.length()));
         password += Password.digits.charAt(random.nextInt(Password.digits.length()));
         password += Password.otherSymbols.charAt(random.nextInt(Password.otherSymbols.length()));
      }

      StringBuilder passwordBuilder = new StringBuilder(password);
      int pos1, pos2;
      char c;
      for (int i = 0; i < 100; i++) {
         pos1 = random.nextInt(password.length());
         c = passwordBuilder.charAt(pos1);
         passwordBuilder.deleteCharAt(pos1);
         passwordBuilder.append(c);
      }

      return passwordBuilder.toString();
   }
}
