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
        if (indexRadku >= 0 && indexRadku < data.size()) {
            String[] radek = data.get(indexRadku);
            if (radek != null) {
                System.out.println("Informace z řádku:");
                for (String hodnota : radek) {
                    System.out.println(hodnota);
                }
                if (radek.length > 6 && radek[6] != null && !radek[6].isEmpty()) {
                    try {
                        String[] koordinaty = radek[6].split("[/(\\d{2}\\°\\d{1,2}\\'\\d{1,2}\\.\\d{3}\\\"\\w{1})\\s(\\d{2}\\°\\d{1,2}\\'\\d{1,2}\\.\\d{3}\\\"\\w{1})/gm]");
                        if (koordinaty.length >= 3) {
                            double stupne = Double.parseDouble(koordinaty[0]);
                            double minuty = Double.parseDouble(koordinaty[1]);
                            double sekundy = Double.parseDouble(koordinaty[2]);

                            double desetinneStupne = stupne + (minuty / 60.0) + (sekundy / 3600.0);
                            System.out.println("Souřadnice úspěšně upraveny: " + desetinneStupne);
                        } else {
                            System.out.println("Špatný formát souřadnic.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Chyba při převodu souřadnic: " + e.getMessage());
                    }
                } else {
                    System.out.println("Tento řádek nemá uvedenou GPS.");
                }
            } else {
                System.out.println("Řádek není definován.");
            }
        } else {
            System.out.println("Uživatel není uveden.");
        }
    }
}
