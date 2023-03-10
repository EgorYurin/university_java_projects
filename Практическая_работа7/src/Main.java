// 1.Cars
//
// import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = 2;
//        Car[] cars =new Car[n];
//        for (int i = 0; i<n; i++) {
//            Car car = new Car();
//            car.setMake(in.next());
//            car.setModel(in.next());
//            car.setHorsePower(in.nextInt());
//            cars[i] = car;
//        }
//        for (int i =0; i<n; i++){
//            System.out.println(cars[i].getInfo());
//        }
//    }
//}
// 2. Конструкторы car
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter(" ");
        int n = Integer.parseInt(in.nextLine());
        Car[] cars =new Car[n];

        for (int i = 0; i<n; i++) {
            String[] vvod = in.nextLine().split(" ");
            Car car = new Car(vvod[0], vvod[1], Integer.parseInt(vvod[2]));
            cars[i] = car;
        }
        for (int i =0; i<n; i++){
            System.out.println(cars[i].getInfo());
        }
    }
}