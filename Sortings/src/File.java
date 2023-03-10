import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class File {

    public static int [] arrRead = new int [Main.notSorted.length];

    public static void fileWrite(long[] allTimesInsertion, long[] allTimesBubble, long[] allTimesQuick, long[] allTimesSelection, long[] allTimesHeap){
        try(
                FileWriter writer = new FileWriter("times.txt", false))
        {
            for (int i = 0; i < Main.notSorted.length; i++){
                writer.write(Main.notSorted[i] + " ");
        }
            writer.write("\n" + Arrays.toString(allTimesInsertion) + "\n");
            writer.write(Arrays.toString(allTimesBubble) + "\n");
            writer.write(Arrays.toString(allTimesQuick) + "\n");
            writer.write(Arrays.toString(allTimesSelection) + "\n");
            writer.write(Arrays.toString(allTimesHeap));
            writer.flush();
        }
        catch(
                IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static int[] fileRead(){
        try {
            Scanner scanner = new Scanner(new FileReader("times.txt"));
            int i = 0;
            while(scanner.hasNextInt()){
                arrRead[i++] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arrRead;
    }
}
