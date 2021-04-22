import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.String;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SodaSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nInsira a sequência completa separada por espaços:");
        String rawSodaList = scanner.nextLine();
        String[] list = rawSodaList.split("[ ]+");
        List<String> sodaList = Arrays.stream(list).collect(Collectors.toList());

        List<String> boxes = new ArrayList<>();
        int cQuantity = 0;
        int gQuantity = 0;
        int fQuantity = 0;

        for (String soda : sodaList) {
            switch (soda) {
                case "C" -> cQuantity++;
                case "G" -> gQuantity++;
                case "F" -> fQuantity++;
                default -> System.out.println("Lata ignorada!");
            }
            if (boxes.size() == 5) {
                break;
            }
            if (cQuantity == 4) {
                cQuantity = 0;
                boxes.add("C");
            } else if (gQuantity == 4) {
                gQuantity = 0;
                boxes.add("G");
            } else if (fQuantity == 4) {
                fQuantity = 0;
                boxes.add("F");
            }
        }
        if (boxes.size() < 5) {
            int number = 5 - boxes.size();
            for (int i = 0; i < number; i++) {
                boxes.add("-");
            }
        }
        System.out.println(boxes.toString());
    }
}
