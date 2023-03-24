package MentoringSessions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Coding1 {
   /* Write a function that takes a string name and a number num (either 0 or 1) and return "Hello" + name if num is 1, otherwise return "Bye" + name.

            Examples
    sayHelloBye("alon", 1) ➞ "Hello Alon"

    sayHelloBye("Tomi", 0) ➞ "Bye Tomi"

    sayHelloBye("jose", 0) ➞ "Bye Jose"*/



   public String Greetings(String name, int num) {
      String str = null;
      if (num == 1) {
         str= ("Hello " + name);
      } else if (num == 0) {
         str=("Bye " + name);
      }
      return str;
   }
   public static void main(String[] args) {
      Coding1 obj=new Coding1();
      System.out.println(obj.Greetings("Waad", 0));
   }
      }
