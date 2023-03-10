import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String N = "check";
        int num = in.nextInt();
        while (!N.equals("done")){

            if ((num >= -300 && num <= 300) || (num >= 1000 && num <= 1600)) {
                System.out.println("The number is: " + num);
                N = "done";
            }
            else {
                System.out.println("Invalid number!");
                num = in.nextInt();
            }
        }
    }
}