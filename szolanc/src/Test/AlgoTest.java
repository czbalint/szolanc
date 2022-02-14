package Test;

import Program.Szolanc;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AlgoTest {
    private Szolanc lanc = new Szolanc();

    /**
     * test inicializálás
     */
    @Before
    public void setup(){
        lanc.inputStrings = new ArrayList<>(){{
            add("A01");
            add("1000");
            add("ABC");
            add("101");
            add("A0C");
            add("1001");
            add("ABD");
            add("AB");
        }};
    }

    /**
     * algoritmus teszt
     */
    @Test
    public void algoTest(){
        var testArray = lanc.Run();
        assertEquals("Az elso elem: 1000", testArray.get(0), "1000");
        assertEquals("Az utolso elem: ABD", testArray.get(7), "ABD");
    }

}
