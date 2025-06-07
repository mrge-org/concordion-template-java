package spec;

import org.concordion.api.FullOGNL;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.List;

/**
 * Fixture for ConcordionSyntaxReference.md.
 * Add helper methods if/when the specification requires dynamic fixture logic.
 */
@RunWith(ConcordionRunner.class)
@FullOGNL
public class ConcordionSyntaxReferenceFixture {
    // Add fixture methods as needed for dynamic checks or instrumentation.
    class ComplexObject {
        public String firstName;
        public String lastName;
        public String prop;
        ComplexObject(String firstName, String lastName, String prop) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.prop = prop;
        }
    }

    public ComplexObject obj = new ComplexObject("John", "Smith", "propertyValue");

    public ComplexObject complexObject(String prop) {
        return new ComplexObject(null, null, prop);
    }

    public String method() {
        return "method result";
    }

    public String method(String param) {
        return param;
    }

    public String getGreeting() {
        return "Hello!";
    }

    public boolean isReady() {
        return true;
    }

    public boolean isError() {
        return false;
    }

    public String[] getItems() {
        return new String[]{"item1", "item2"};
    }

    public List<String> getUsers() {
        return Arrays.asList("alice", "bob");
    }

    public Result split(String fullName) {
        Result result = new Result();
        String[] words = fullName.split(" ");
        result.firstName = words[0];
        result.lastName = words[1];
        return result;
    }
    class Result {
        public String firstName;
        public String lastName;
    }
}
