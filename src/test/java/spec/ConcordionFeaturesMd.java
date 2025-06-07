package spec;

import org.concordion.api.FullOGNL;
import org.concordion.api.extension.Extensions;
import org.concordion.api.option.ConcordionOptions;
//import org.concordion.ext.ScreenshotExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
@FullOGNL
@ConcordionOptions(declareNamespaces = {"ext", "urn:concordion-extensions:2010"})
//@Extensions(ScreenshotExtension.class)
public class ConcordionFeaturesMd {


    public Result split(String fullName) {
        Result result = new Result();
        String[] words = fullName.split(" ");
        result.firstName = words[0];
        result.lastName = words[1];
        return result;
    }

    public String greet() {
        // Simple greeting method
        return("Hello!");
    }

    public String methodName(String text) {
        // Return the text passed in
        return text;
    }

    public String methodName() {
        // Return a default value
        return "method result";
    }

    public String getGreeting(String fullName) {
        return "Hello, " + fullName + "!";
    }
    
    public String getGreetingSmall(String name) {
        return "Hello, " + name + "!";
    }

    public void greetPerson(String name) {
        System.out.println("Greeting: " + getGreeting(name));
    }

    class Result {
        public String firstName;
        public String lastName;
    }
}