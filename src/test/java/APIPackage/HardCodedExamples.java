package APIPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
//to change the order of execution, we use FixMethodOrder since it executes top to
//bottom approach, not good in this 'cause since we need to create employee then get employee
//this method sorter will execute my methods in ascending order alphabetically
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    //one thing to remember
    //base uri-base url
    //end when using 'when' keyword, we will send the end point
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    //we need to perform CRUD operations
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzQwODc4ODEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDEzMTA4MSwidXNlcklkIjoiNTAzMyJ9.d-UloXbwKfi8HJ3-XGV9FntKUflyuLPua5tk0sck7K8";
    static String employee_id;

    @Test
    public void BgetOneEmployee() {
        //prepare the request
        //to prepare the request, we use request specification
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "Application/json")
                .queryParam("employee_id", employee_id);

        //to hit the end point/to make the request which will return response
        Response response = request.when().get("/getOneEmployee.php");
        //System.out.println(response.asString());//not common, pretty print is common
        response.prettyPrint();//pretty keyword used to print all the step definitions in the console

//verifying the status code
        response.then().assertThat().statusCode(200);

        String firstName = response.jsonPath().getString("employee.emp_firstname");
        System.out.println(firstName);

        //first way of assertions
        Assert.assertEquals(firstName, "Waad");
        //second way of assertion to verify the value in response body using hamcrest matchers
        response.then().assertThat().body("employee.emp_firstname", equalTo("Waad"));
    }
@Test
    public void AcreateEmployee() {
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"emp_firstname\": \"Waad\",\n" +
                        "  \"emp_lastname\": \"Ayoub\",\n" +
                        "  \"emp_middle_name\": \"K\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2023-01-18\",\n" +
                        "  \"emp_status\": \"active\",\n" +
                        "  \"emp_job_title\": \"manager\"\n" +
                        "}");
        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();
        //verifying the status code which is 201
        response.then().assertThat().statusCode(201);
        //getting the employee id from the response and use it as static one
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
        response.then().assertThat().body("Employee.emp_lastname",equalTo("Ayoub"));
    response.then().assertThat().body("Employee.emp_middle_name",equalTo("K"));
    //verify the console header
    response.then().assertThat().header("Server",  "Apache/2.4.39 (Win64) PHP/7.2.18");

    }
    @Test
    public void cupdateEmployee(){
        RequestSpecification request=given().header("Authorization", token)
                .header("Content-TYpe","application/json").
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Winnie\",\n" +
                        "  \"emp_lastname\": \"The\",\n" +
                        "  \"emp_middle_name\": \"Pooh\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2023-01-15\",\n" +
                        "  \"emp_status\": \"unactive\",\n" +
                        "  \"emp_job_title\": \"manager\"\n" +
                        "}");
        Response response=request.when().put("/updateEmployee.php");
        response.prettyPrint();
               //verification
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    }
    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "Application/json")
                .queryParam("employee_id", employee_id);

        //to hit the end point/to make the request which will return response
        Response response = request.when().get("/getOneEmployee.php");
        //System.out.println(response.asString());//not common, pretty print is common
        response.prettyPrint();//pretty keyword used to print all the step definitions in the console

//verifying the status code
        response.then().assertThat().statusCode(200);
response.then().assertThat().body("employee.emp_job_title",equalTo("Manager") );


    }
}