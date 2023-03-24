package MentoringSessions;

public class Coding3 {
    /*Create a method that takes a string and returns a string in which each character is repeated once.

Examples
doubleChar("String") ➞ "SSttrriinngg"

doubleChar("Hello World!") ➞ "HHeelllloo  WWoorrlldd!!"

doubleChar("1234!_ ") ➞ "11223344!!__  "*/
public String doubleChar(String str){
    String newString = "";
    for(int i=0;i<str.length();i++){
        newString +=str.substring(i,i+1)+str.substring(i,i+1);
    }
    return newString;
}

    public static void main(String[] args) {
        Coding3 obj=new Coding3();
        String example="Welcome Class";
        System.out.println(obj.doubleChar(example));
    }
}
