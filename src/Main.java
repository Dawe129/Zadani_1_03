import java.util.List;

public class Main {
    public static void main(String[] args) {

        String cesta = "C:\\Users\\Honza\\IdeaProjects\\zadani_1_03\\aktivace_dm_jaro_2024_original.csv";
        List<String[]> data = PrectiCSV.CSV(cesta);

        for (int i = 0; i < data.size(); i++) {
            try {
                System.out.println("=======================================");
                PrectiCSV.upravRadek(data, i);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Chyba u řádku " + i + ": " + e.getMessage());
            }
        }
    }
}
