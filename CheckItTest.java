import static org.junit.Assert.*;
import org.junit.*;

public class CheckItTest {

    // Predicate Coverage
    @Test
    public void testPredicateTrue() {
        assertTrue(CheckIt.checkIt(true, false, false));
    }

    @Test
    public void testPredicateFalse() {
        assertFalse(CheckIt.checkIt(false, false, false));
    }

    // Clause Coverage
    @Test
    public void testClauseA() {
        assertTrue(CheckIt.checkIt(true, false, false));
        assertFalse(CheckIt.checkIt(false, true, true));
    }

    @Test
    public void testClauseB() {
        assertFalse(CheckIt.checkIt(false, false, true));
        assertTrue(CheckIt.checkIt(false, true, false));
    }

    @Test
    public void testClauseC() {
        assertFalse(CheckIt.checkIt(false, true, false));
        assertTrue(CheckIt.checkIt(true, true, true));
    }

    // CACC
    @Test
    public void testCACC() {
        assertTrue(CheckIt.checkIt(true, false, true));
        assertFalse(CheckIt.checkIt(false, false, true));
        assertTrue(CheckIt.checkIt(false, true, true));
        assertFalse(CheckIt.checkIt(false, true, false));
    }

    // RACC
    @Test
    public void testRACC() {
        // Test each pair with the third clause as true
        assertTrue(CheckIt.checkIt(true, false, true));
        assertTrue(CheckIt.checkIt(false, true, true));
        assertFalse(CheckIt.checkIt(false, false, true));

        // Test each pair with the third clause as false
        assertTrue(CheckIt.checkIt(true, false, false));
        assertFalse(CheckIt.checkIt(false, true, false));
        assertFalse(CheckIt.checkIt(false, false, false));
    }

}
