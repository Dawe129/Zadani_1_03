import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrectiCSV {

    public static List<String[]> CSV(String cesta) {
        List<String[]> data = new ArrayList<>();
        String radek;
        String oddelovac = ";";

        try (BufferedReader reader = new BufferedReader(new FileReader(cesta))) {
            while ((radek = reader.readLine()) != null) {
                String[] hodnoty = radek.split(oddelovac);
                data.add(hodnoty);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void upravRadek(List<String[]> data, int indexRadku) {
        if (indexRadku < 0 || indexRadku >= data.size()) {
            System.out.println("Uživatel není uveden.");
            return;
        }

        String[] radek = data.get(indexRadku);
        if (radek == null) {
            System.out.println("Řádek není definován.");
            return;
        }

        System.out.println("Informace z řádku:");
        for (String hodnota : radek) {
            System.out.println(hodnota);
        }

        if (radek.length <= 6) {
            System.out.println("Tento řádek nemá uvedenou GPS.");
            return;
        }

        try {
            String[] latLong = radek[6].split(" ");
            if (latLong.length != 2) {
                System.out.println("Špatný formát souřadnic.");
                return;
            }

            double latitude = prevedSouradnice(latLong[0]);
            double longitude = prevedSouradnice(latLong[1]);

            System.out.printf("Převedené souřadnice: " + latitude + "N, " + longitude + "E " + "\n");
        } catch (NumberFormatException e) {
            System.out.println("Chyba při převodu souřadnic: " + e.getMessage());
        }
    }

    private static double prevedSouradnice(String souradnice) {
        String[] koordinaty = souradnice.split("[°'\"]");
        if (koordinaty.length == 6) {
            try {
                double stupne = Double.parseDouble(koordinaty[1]);
                double minuty = Double.parseDouble(koordinaty[2]);
                double sekundy = Double.parseDouble(koordinaty[3]);
                return stupne + (minuty / 60.0) + (sekundy / 3600.0);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Chyba při převodu: " + e.getMessage());
            }
        } else {
            return Double.NaN;
        }
    }
}
