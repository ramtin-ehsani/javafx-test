import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (string.matches("^[a-z09A-Z][a-z0-9A-Z]*@[a-z0-9]*\\.[a-z]*")){
            System.out.println("ok");
        }
    }
}
