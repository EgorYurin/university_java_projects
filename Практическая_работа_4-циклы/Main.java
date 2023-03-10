import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int num = Integer.parseInt(in.nextLine());
        for (int i = 1; i < N; i++){
            int num2 = Integer.parseInt(in.nextLine());;

            if (num2 > num ){
                num = num2

                System.out.println(num)
            }
        }
    }
}