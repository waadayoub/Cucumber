package utils;

import com.google.common.io.Files;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Paths;

public class APIPayloadConstants {
    public static String createEmployeePayload() {
        String createEmployeePayload =
                "{\n" +
                        "  \"emp_firstname\": \"silly\",\n" +
                        "  \"emp_lastname\": \"cat\",\n" +
                        "  \"emp_middle_name\": \"kitty\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2023-01-19\",\n" +
                        "  \"emp_status\": \"sleeping\",\n" +
                        "  \"emp_job_title\": \"retired\"\n" +
                        "}";

        return createEmployeePayload;
    }

    //a method to create json object and returning the value as string
    //below is what we call domain specific language (DSL) using java method (put) to pass json format
    public static String createEmployeeJsonBody() {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "silly");
        obj.put("emp_lastname", "cat");
        obj.put("emp_middle_name", "kitty");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "2023-01-19");
        obj.put("emp_status", "sleeping");
        obj.put("emp_job_title", "retired");
        return obj.toString();


    }
//values are being passed as parameters
    public static String createEmployeeDynamic(String firstname, String lastname, String middlename, String gender, String dob, String empStatus, String jobTitle) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstname);
        obj.put("emp_lastname", lastname);
        obj.put("emp_middle_name", middlename);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title", jobTitle);
        return obj.toString();
    }

    public static String adminPayload() {
        String adminPayload = "{\n" +
                "\"name\":\"Batch14\",\n" +
                "\"email\":\"testingAPI@hotmail.com\",\n" +
                "\"password\":\"Test@123\"\n" +
                "}";
        return adminPayload;
    }

    //to read payload from the file (added by Moazzam)
  //  public static String readPayloadFile(String filePath)throws IOException{
  //      String data="";
    //    data=new String(Files.readAllBytes(Paths.get(filePath)));
    //    return data;
    }
