    //1.Поиск минимального значения

//import java.util.Scanner;
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int n = Integer.parseInt(in.nextLine());
//        int m = Integer.parseInt(in.nextLine());
//
//        String[] elems = in.nextLine().split(" ");
//        String[][] matrix = new String[n][m];
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                matrix[i][j] = elems[i * m + j];
//                if (Integer.parseInt(matrix[i][j])<min){
//                    min = Integer.parseInt(matrix[i][j]);
//                }
//                System.out.print(matrix[i][j]);
//                if (j != m - 1) {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
//        System.out.println(min);
//    }
//}

    //2.Поезд
//
//import java.util.Scanner;
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        int m = 3;
//        String[][] matrix = new String[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                matrix[i][j] = Integer.toString(in.nextInt());
//            }
//        }
//        int sum = 0;
//        int num = in.nextInt();
//        int k = 0;
//        for (int i = 0; i < n; i++){
//            if (num == Integer.parseInt(matrix[i][0])) {
//                sum += Integer.parseInt(matrix[i][2]);
//                k+=1;
//            }
//        }
//        if (k == 0) {
//            System.out.println("Error");
//        } else {
//            System.out.println(sum);
//        }
//    }
//}

    //3.Дублирование элементов относительно главной диагонали

//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        String[][] matrix = new String[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = Integer.toString(in.nextInt());
//            }
//        }
//        for (int i = 0; i<n; i++){
//            for (int j=0; j<n; j++){
//                if (j==i || matrix[j][i].equals(matrix[i][j])){
//                    break;
//                }
//                else{
//                    matrix[i][j] = matrix[j][i];
//                }
//            }
//        }
//        for (int i = 0; i<n; i++){
//            for (int j = 0; j<n; j++){
//                System.out.print(matrix[i][j]);
//                if (j != n - 1) {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
//    }
//}

    //4.Определитель матрицы размерностью 2х2

//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = 2;
//        String[][] matrix = new String[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = Integer.toString(in.nextInt());
//            }
//        }
//        int opr = (Integer.parseInt(matrix[0][0]))*(Integer.parseInt(matrix[1][1]))-(Integer.parseInt(matrix[0][1]))*(Integer.parseInt(matrix[1][0]));
//        System.out.println(opr);
//    }
//}

    //5.Определитель квадратной матрицы

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println(det(matrix));
    }
    public static int det(int[][] matrix) {
        int n = matrix.length;
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        }
        int der = 0;
        for (int i = 0; i < n; i++) {
            int[][] minor = new int[n - 1][n - 1];
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < n - 1; k++) {
                    minor[k][j] = matrix[k + 1][j];
                }
            }
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < n - 1; k++) {
                    minor[k][j - 1] = matrix[k + 1][j];
                }
            }
            if (i % 2 == 0) {
                der += matrix[0][i] * det(minor);
            } else {
                der -= matrix[0][i] * det(minor);
            }
        }
        return der;
    }
}
