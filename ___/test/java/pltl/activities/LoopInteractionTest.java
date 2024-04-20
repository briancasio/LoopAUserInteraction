package pltl.activities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class LoopInteractionTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    public void testLoopInteraction() {
        // Define input
        String input = "5\nTuring\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture output
        LoopInteraction.main(null);
        String actualOutput = outputStreamCaptor.toString().trim();

        String expectedOutput = "n: Name: for: Turing Turing Turing Turing Turing \nwhile: Turing Turing Turing Turing Turing \ndo while: Turing Turing Turing Turing Turing";

        System.out.println("Input:");
        System.out.println(input);
        System.out.println("Expected Output:");
        System.out.println(expectedOutput);
        System.out.println("Actual Output:");
        System.out.println(actualOutput);

        assertEquals(expectedOutput, actualOutput);
    }
}
