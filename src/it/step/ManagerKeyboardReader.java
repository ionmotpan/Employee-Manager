package it.step;
import java.util.Scanner;

public class ManagerKeyboardReader {
    Scanner sc = new Scanner(System.in);

    public  String readString(String mess) {
        System.out.println(mess);
        return sc.nextLine();
    }


}













































