/*
package Testy;

import org.junit.Test;
import org.junit.Before;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class PrectiCSVTest {

    private File docasnySoubor;

    @Before
    public void setUp() throws IOException {
        // Vytvoř dočasný soubor s testovacími daty
        docasnySoubor = File.createTempFile("test", ".csv");
        docasnySoubor.deleteOnExit();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(docasnySoubor))) {
            writer.write("a,b,c,d,e,f,40°30'30.0\"N 74°00'30.0\"W\n");
            writer.write("1,2,3,4,5,6,50°40'40.0\"N 75°10'40.0\"W\n");
        }
    }

    @Test
    public void testCSV() {
        // Zavolej metodu CSV
        List<String[]> vysledek = PrectiCSV.CSV(docasnySoubor.getAbsolutePath());

        // Ověř výsledky
        assertNotNull(vysledek);
        assertEquals(2, vysledek.size());
        assertArrayEquals(new String[]{"a", "b", "c", "d", "e", "f", "40°30'30.0\"N 74°00'30.0\"W"}, vysledek.get(0));
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6", "50°40'40.0\"N 75°10'40.0\"W"}, vysledek.get(1));
    }

    @Test
    public void testUpravRadek() {
        // Připrav testovací data
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"a", "b", "c", "d", "e", "f", "40°30'30.0\"N 74°00'30.0\"W"});

        // Zavolej metodu upravRadek
        PrectiCSV.upravRadek(data, 0);

        // Ověř výsledky
        String[] upravenyRadek = data.get(0);
        assertEquals("40.50833333333333", upravenyRadek[6]);
    }

    @Test
    public void testUpravRadekBezGPS() {
        // Připrav testovací data
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"a", "b", "c", "d", "e", "f"});

        // Zavolej metodu upravRadek
        PrectiCSV.upravRadek(data, 0);

        // Ověř, že nedošlo ke změně
        String[] upravenyRadek = data.get(0);
        assertArrayEquals(new String[]{"a", "b", "c", "d", "e", "f"}, upravenyRadek);
    }

    @Test
    public void testUpravRadekIndexMimoMeze() {
        // Připrav testovací data
        List<String[]> data = new ArrayList<>();

        // Zavolej metodu upravRadek s indexem mimo meze
        PrectiCSV.upravRadek(data, 1);

        // Ověř, že nedošlo k výjimce ani změně
        assertEquals(0, data.size());
    }
}
 */


