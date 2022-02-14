package Test;

import Program.Szolanc;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SzolancTest {
    private Szolanc lanc = new Szolanc();

    /**
     *  Az Stringek eltéréseinek a tesztje
     */
    @Test
    public void testBetweenStrings(){
        assertEquals("1-nek kell lennie", lanc.differenceBetweenTwoString("aba","abb"), 1);
        assertEquals("2-nek kell lennie", lanc.differenceBetweenTwoString("aba","acc"), 2);
        assertEquals("0-nek kell lennie", lanc.differenceBetweenTwoString("aba","aab"), 0);
    }
}

