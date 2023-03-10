import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class FinalMenu extends JFrame {


    String[] columnNames = {"Head length", "InsertionSort time (blue)", "BubbleSort (orange)", "QuickSort time (green)", "SelectionSort time (red)", "HeapSort (magenta)"};
    public static Graphic graphic = new Graphic();

    public FinalMenu(int[] headLength, long[] allTimesInsertion, long[] allTimesBubble, long[] allTimesQuick, long[] allTimesSelection, long[] allTimesHeap) {
        JFrame menu = new JFrame("Меню");
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);

    Object[][] data = new Object[headLength.length][columnNames.length];
        ActionListener fileSave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File.fileWrite(allTimesInsertion, allTimesBubble, allTimesQuick, allTimesSelection, allTimesHeap);
            }
        };
        ActionListener fileRead = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(Arrays.toString((File.fileRead())));
            }
        };
        ActionListener generation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.regenerate();
            }
        };

        ActionListener rerun = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.allTimes = Main.allSorts(Main.notSorted);
                menu.dispose();
                graphic.revalidate();

            }
        };

    for ( int i = 0; i<allTimesQuick.length;i++){
        data[i][0] = headLength[i];
        data[i][1] = allTimesInsertion[i]/1000;
        data[i][2] = allTimesBubble[i]/1000;
        data[i][3] = allTimesQuick[i]/1000;
        data[i][4] = allTimesSelection[i]/1000;
        data[i][5] = allTimesHeap[i]/1000;
    }

    menu.add(graphic);
    JTable table = new JTable(data, columnNames);

    JButton saveArr = new JButton("Сохранить массив");
    saveArr.addActionListener(fileSave);

    JButton readArr = new JButton("Считать массив");
    readArr.addActionListener(fileRead);

    JButton runCode = new JButton("Сравнить");
    runCode.addActionListener(rerun);

    JButton generate = new JButton("Сгенерировать новый массив");
    generate.addActionListener(generation);


    table.setBounds(100,100, 500, 240);
    saveArr.setBounds(375,650,150,50);
    readArr.setBounds(675, 650, 150, 50);
    runCode.setBounds(975, 650, 150, 50);
    generate.setBounds(600, 720, 300, 50);
    graphic.setBounds(5, 200, 1550, 450);


    menu.add(saveArr);
    menu.add(readArr);
    menu.add(runCode);
    menu.add(generate);


    menu.add(new JScrollPane(table));

    menu.setSize(1600,820);

    menu.setVisible(true);
    }
}
