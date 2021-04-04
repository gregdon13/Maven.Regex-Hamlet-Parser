import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //Given
        hamletParser.setHamletData();

        //Then
        Assert.assertTrue(hamletText.contains("Leon"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        hamletParser.setHamletData();

        //Then
        Assert.assertTrue(hamletText.contains("Tariq"));
        Assert.assertFalse(hamletText.contains("Horatio"));
    }

    @Test
    public void testFindHoratio() {
        //Given
        hamletParser.setHamletData();

        //Then
        Assert.assertFalse(hamletText.contains("Horatio"));
    }

    @Test
    public void testFindHamlet() {
        //Given
        hamletParser.setHamletData();

        //Then
        Assert.assertFalse(hamletText.contains("Hamlet"));
    }
}