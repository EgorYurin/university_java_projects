//////////5//////////

//import java.util.Scanner;
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        //int n = Integer.parseInt(in.nextLine());
//        int[] arr = {1, 1, 1, 1, 2, 2, 3, 3};
//        int counter = 0;
//        int maxCounter = 0;
//        int mostCommon = 0;
//        for (int i = 0; i<arr.length; i++){
//            for (int j = 0; j<arr.length; j++){
//                if (arr[i]==arr[j]){
//                    counter++;
//                }
//                if (counter > maxCounter){
//                    maxCounter = counter;
//                    mostCommon = arr[i];
//                }
//                counter = 0;
//            }
//        }
//        System.out.println(mostCommon);
//    }
//}
//////////7//////////
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 7, 10, 2, 2929, 3};
        int[] arr2 = {3, 3, 10, 6};
        int ending = arr.length-1;
        for (int i = arr2.length-1; i>=0; i--){
            for (int j = 0; j< arr.length; j++){
                if (arr2[i]==j){
                    int n = arr[ending];
                    arr[ending] = arr[j];
                    arr[j] = n;
                    ending--;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
//////////8//////////
//import java.util.Arrays;
//import java.util.Scanner;
//public class Main {
//
//    public static void main(String[] args) {
//    }
//}