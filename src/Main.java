import java.util.List;

public class Main {
    public static void main(String[] args) {

        String cesta = "C:\\Users\\Honza\\IdeaProjects\\zadani_1\\aktivace_dm_jaro_2024.csv";
        List<String[]> data = PrectiCSV.CSV(cesta);

        for (String[] radek : data) {
            for (String hodnota : radek) {
                System.out.print(hodnota + " ");
            }
            System.out.println();
        }
    }
}