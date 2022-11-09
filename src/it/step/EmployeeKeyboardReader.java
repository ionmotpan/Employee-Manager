package it.step;

import java.util.Scanner;

public class EmployeeKeyboardReader {
    static Scanner scanner = new Scanner(System.in);

    public static String readString(String msg) {
        System.out.println(msg);
        return scanner.next();
    }


}
