package steps;

import io.cucumber.java.en.When;

public class DatabaseSteps {
    public static String getFnameLnameQuery(){
        String query="select emp_firstname,emp_lastname " +
                "from hs_hr_employees " +
                "where employee_id=";
        return query;
    }

}