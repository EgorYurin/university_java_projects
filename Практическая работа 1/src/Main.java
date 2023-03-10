import java.util.Locale;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        double sum = 0;
        int kol = 0;
        int min = 2147483647;
        int n = in.nextInt();
        int [] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = in.nextInt();
            sum+=arr[i];
        }
        double srA = sum/n;
        for (int i=0; i<n; i++){
            if (arr[i]<srA){
                kol++;
            }
            if (arr[i]>0 && arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println(kol);
        System.out.println(min);
    }
}

