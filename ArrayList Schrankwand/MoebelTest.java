import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse MoebelTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MoebelTest
{
    Zeichnung zeichnung=Zeichnung.gibZeichnung();
    private void warte(int dauer) {zeichnung.warte(dauer);}

    /**
     * Konstruktor fuer die Test-Klasse MoebelTest
     */
    public MoebelTest()
    {        
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testSchrankwand()
    {
        Schrankwand sw1 = new Schrankwand(4);
        sw1.zeige();
        warte(300);
        sw1.hinzufügenSchrank(0,0,60,60,0,"blau");    
    }
}

