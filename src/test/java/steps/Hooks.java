package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.poi.ddf.EscherChildAnchorRecord;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    //use io.cucumber.java to import this hook
    @Before
    public void preCondition(){
        openBrowserAndLaunchApplication();
    }
//here we use special class from Cucumber, because it holds complete info of your execution
    @After
    public void postCondition(Scenario scenario){
        byte[] pic;
        if(scenario.isFailed()){
            //failed screenshot will be available inside failed folder
          pic=  takeScreenshot("failed/"+ scenario.getName());
        }else{
            pic=takeScreenshot("passed/"+scenario.getName());
        }

//to attach the screenshot in our report
      scenario.attach(pic,"image/png", scenario.getName());

        closeBrowser();
    }

}
