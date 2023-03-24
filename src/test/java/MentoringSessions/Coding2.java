package MentoringSessions;

import java.util.ArrayList;

public class Coding2 {
    //Given an integer n, return a string array answer (1-indexed) where:
    //            - answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    //            - answer[i] == "Fizz" if i is divisible by 3.
    //            - answer[i] == "Buzz" if i is divisible by 5.
    //            - answer[i] == i (as a string) if none of the above conditions are true.
    //
    //    Example 1:
    //    Input: n = 3
    //    Output: ["1","2","Fizz"]
    //    Example 2:
    //    Input: n = 5
    //    Output: ["1","2","Fizz","4","Buzz"]
    //    Example 3:
    //    Input: n = 15
    //    Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]*/


    public ArrayList<String> example (int n){
        ArrayList<String>arr=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0&&i%5==0) {
                arr.add("FizzBuzz");
            }else if(i%3==0) {
                arr.add("Fizz");
            }else if (i%5==0) {
                arr.add("Buzz");
            }else{
                arr.add(Integer.toString(i));

            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Coding2 obj=new Coding2();
        int num=15;
        System.out.println(obj.example(num));
    }
}

