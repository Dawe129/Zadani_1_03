import java.util.List;

public class Main {
    public static void main(String[] args) {

        String cesta = "C:\\Users\\Honza\\IdeaProjects\\zadani_1_03\\aktivace_dm_jaro_2024_original.csv";
        List<String[]> data = PrectiCSV.CSV(cesta);
        PrectiCSV csv = new PrectiCSV();

        for (String[] radek : data) {
            for (String hodnota : radek) {
                System.out.print(hodnota + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
}