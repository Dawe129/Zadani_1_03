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
                        // Nejprve potřebuji souřadnice rozdělit na lat a long. Odděluje je mezera to je ten první split. Teoreticky bych to ohl udělat celé najednou ale...
                        String[] lat_long = radek[6].split(" ");
                        // Pak už vezmu tu jednu část a z ní vyparsuju jednotlivé komponenty. POZOR pro W a S je třeba vynásobit -1, ale jelikož jsme na severní polokouli tak asi dobrý
                        String[] koordinaty = lat_long[0].split("[°'\"]");
                        // mít tady >=  je špatně. Je jen jeden správný formát souřadnic, která skončí rozdělení na přesně 6 pložek. Ten split to nedělí 100% ale funguje to :)
                        if (koordinaty.length == 6) {
                            double stupne = Double.parseDouble(koordinaty[1]);
                            double minuty = Double.parseDouble(koordinaty[2]);
                            double sekundy = Double.parseDouble(koordinaty[3]);

                            double desetinneStupne = stupne + (minuty / 60.0) + (sekundy / 3600.0);
                            // teď je upravena polovina souřadnic, takže teď ještě druhá. To jsme ti už nepsal. Doporučuji to přepsat do metody co budu volat. Ale nechám na tobě
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
