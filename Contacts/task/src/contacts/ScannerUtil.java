package contacts;

import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner in = new Scanner(System.in);

    public static String readAnswer(String question) {
        System.out.println(question);
        return readInput();
    }

    public static String readInput() {
        return in.nextLine();
    }
}
