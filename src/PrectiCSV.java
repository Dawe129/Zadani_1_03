import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrectiCSV {

    public static List<String[]> CSV(String cesta) {
        List<String[]> data = new ArrayList<>();
        String radek;
        int index[];
        String oddelovani = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(cesta))) {
            while ((radek = reader.readLine()) != null) {
                String[] hodnoty = radek.split(oddelovani);
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
            if (radek.length > 6) {
                String[] koordinaty = radek[6].split("[/(\\d{2}\\°\\d{1,2}\\'\\d{1,2}\\.\\d{3}\\\"\\w{1})\\s(\\d{2}\\°\\d{1,2}\\'\\d{1,2}\\.\\d{3}\\\"\\w{1})/gm]");
                try {
                    double stupne = Double.parseDouble(koordinaty[0]);
                    double minuty = Double.parseDouble(koordinaty[1]);
                    double sekundy = Double.parseDouble(koordinaty[2]);

                    double desetinneStupne = stupne + (minuty / 60.0) + (sekundy / 3600.0);
                    radek[6] = String.valueOf(desetinneStupne);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Nelze upravit");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Tento uzivatel nema uvedenou gps");
            }
        } else {
            System.out.println("Uzivatel neni uvedeny");
        }
    }
}
