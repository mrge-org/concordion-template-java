package spec;

import org.concordion.api.FullOGNL;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

/**
 * Fixture for ConcordionSyntaxReference.md.
 * Add helper methods if/when the specification requires dynamic fixture logic.
 */
@RunWith(ConcordionRunner.class)
@FullOGNL
public class secondLevelFixture {
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
}
