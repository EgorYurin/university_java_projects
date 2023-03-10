//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        //1.Поезд
//
//        int amount = Integer.parseInt(in.nextLine());
//        int[] passengers = new int[amount];
//        int summa = 0;
//        for (int i = 0; i <= amount - 1; i++) {
//            passengers[i] = Integer.parseInt(in.nextLine());
//            summa = summa + passengers[i];
//        }
//        for (int i = 0; i <= amount - 1; i++) {
//            System.out.print(passengers[i]);
//            if (i < amount - 1) {
//                System.out.print(" ");
//            }
//        }
//        System.out.println();
//        System.out.println(summa);
//    }
//}

        //2.Общие элементы
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        String str1 = in.nextLine();
//        String str2 = in.nextLine();
//        String[] mas1 = str1.split(" ");
//        String[] mas2 = str2.split(" ");
//        String result = "";
//        for (int i = 0; i <= mas2.length - 1; ++i) {
//            for (int j = 0; j <= mas1.length - 1; ++j) {
//                if (mas2[i].equals(mas1[j])) {
//                    result = result.join(" ", result, mas2[i]);
//                }
//            }
//        }
//        System.out.println(result.substring(1));
//    }
//}

        //3.Вращение массива
import java.util.Scanner;
public class Main {
            public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String[] mas1 = str1.split(" ");
        int spin = Integer.parseInt(in.nextLine());
        spin = spin % (mas1.length);
        int a = 0;
        while (spin > a) {
            for (int i = 1; i <= mas1.length - 1; i++) {
                int b = Integer.parseInt(mas1[i - 1]);
                mas1[i - 1] = mas1[i];
                mas1[i] = String.valueOf(b);
            }
            a++;
        }
        for (int i = 0; i <= mas1.length - 1; i++) {
            System.out.print(mas1[i]);
            if (i < mas1.length - 1) {
                System.out.print(" ");
            }
        }
    }
}

        //4.Большие числа
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str1 = in.nextLine();
//        String[] mas1 = str1.split(" ");
//
//        String result = "";
//        int a = 1;
//        for (int i = 0; i <= mas1.length - 1; i++) {
//            int c = 0;
//            for (int j = a; j <= mas1.length - 1; j++) {
//                if (Integer.parseInt(mas1[i]) > Integer.parseInt(mas1[j])) {
//                    c++;
//                }
//            }
//            if (c == mas1.length - a) {
//                result = result.join(" ", result, mas1[i]);
//            }
//            a++;
//        }
//        System.out.println(result.substring(1));
//    }
//}


        //5.Магическая сумма
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str1 = in.nextLine();
//        String[] mas1 = str1.split(" ");
//        int num = Integer.parseInt(in.nextLine());
//        int a = 0;
//        for (int i = 0; i <= mas1.length - 1; i++) {
//            a++;
//            for (int j = a; j <= mas1.length - 1; j++) {
//
//                if (num == Integer.parseInt(mas1[i]) + Integer.parseInt(mas1[j])) {
//                    System.out.println(mas1[i] + " " + mas1[j]);
//                }
//            }
//        }
//    }
//}


