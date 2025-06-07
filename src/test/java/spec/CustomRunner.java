package spec;

import org.concordion.api.*;
import org.concordion.internal.SummarizingResultRecorder;
import org.concordion.integration.junit4.ConcordionRunner;
import org.concordion.Concordion;
import org.concordion.internal.ConcordionBuilder;
import org.concordion.internal.FileTarget;
import org.concordion.internal.ClassPathSource;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

import java.io.File;

/**
 * CustomRunner demonstrates how to implement the Concordion Runner interface.
 * <p>
 * This is useful for advanced scenarios where you need to customize:
 * <ul>
 *   <li>How specifications are located</li>
 *   <li>How fixtures are instantiated</li>
 *   <li>How results are recorded</li>
 *   <li>Adding pre/post processing to specifications</li>
 * </ul>
 * <p>
 * For simple cases, use the standard Concordion approach:
 * <code>[Link Text](SpecificationFile.md "c:run")</code>
 */
public class CustomRunner implements Runner {

    /**
     * This method is called when the c:run=spec.CustomRunner command is used
     * in a Concordion specification.
     *
     * @param resource the Concordion Resource from which this runner is being invoked
     * @param href the link to the specification to be run
     * @return a ResultSummary containing the execution result
     * @throws Exception if any error occurs during execution
     */
    @Override
    public ResultSummary execute(Resource resource, String href) throws Exception {
        System.out.println("CustomRunner executing: " + href + " (from " + resource + ")");
        
        // Initialize the results recorder
        SummarizingResultRecorder recorder = new SummarizingResultRecorder();
        
        try {
            // The simplest approach: delegate to JUnit to run the specification
            // This is recommended for most use cases as it ensures consistent behavior
            System.out.println("Running " + SplittingNamesFixture.class.getName() + " via JUnit");
            Result junitResult = JUnitCore.runClasses(SplittingNamesFixture.class);
            
            if (junitResult.wasSuccessful()) {
                System.out.println("JUnit test completed successfully");
                recorder.record(org.concordion.api.Result.SUCCESS);
            } else {
                System.out.println("JUnit test failed: " + junitResult.getFailureCount() + " failures");
                recorder.record(org.concordion.api.Result.FAILURE);
            }
            
            /*
             * ALTERNATIVE APPROACHES (commented out)
             * 
             * The following demonstrate alternative ways to execute specifications.
             * These are useful for more advanced customization scenarios.
             */
            
            /*
             * Option 2: Run test using JUnit Request
             * Useful when you need more control over test execution
             *
             * Request request = Request.classWithoutSuiteMethod(SplittingNamesFixture.class);
             * new JUnitCore().run(request);
             */
            
            /*
             * Option 3: Direct Concordion Processing
             * Most flexible approach, allows complete customization
             * 
             * // Create a fixture instance
             * SplittingNamesFixture fixture = new SplittingNamesFixture();
             * 
             * // Get the output directory
             * String outputPath = System.getProperty("concordion.output.dir", "target/concordion");
             * File outputDir = new File(outputPath);
             * 
             * // Create a Concordion builder with the fixture
             * ConcordionBuilder builder = new ConcordionBuilder()
             *     .withFixture(fixture)  // For newer Concordion versions
             *     .withSource(new ClassPathSource())
             *     .withTarget(new FileTarget(outputDir));
             *     
             * // Process the specification
             * Resource specResource = resource.getParent().getRelativeResource(href);
             * builder.build().process(specResource);
             */
            
            return recorder;
        } catch (Exception e) {
            System.err.println("Error in CustomRunner: " + e.getMessage());
            e.printStackTrace();
            recorder.record(org.concordion.api.Result.FAILURE);
            return recorder;
        }
    }
    
    /**
     * NOTE: For most cases, you don't need a custom runner.
     * The standard approach is simpler and more maintainable:
     * 
     * In your specification markdown:
     * [Link Text](SpecificationFile.md "c:run")
     */
}
