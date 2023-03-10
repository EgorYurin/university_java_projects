import javax.swing.*;
import java.awt.*;

public class Graphic extends JPanel {
    private int width;
    private int height;

    public void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2d=(Graphics2D)g;
        Font intFont = new Font( "SansSerif", Font.PLAIN, 14 );
        g2d.setFont(intFont);
        g2d.setColor(Color.BLACK);

        g2d.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
        g2d.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());

        g2d.drawString("0", 25, getHeight()-5);

        // X points
        for (int i = 0; i < Main.headLength.length; i++){
            g2d.drawString(String.valueOf(Main.headLength[i]), 160 + 120*i, getHeight()-5);
        }
        // Y points

        long[] allTimesQuick = (long[]) Main.allTimes[0];

        for (int i = 0; i < 6; i++){
            g2d.drawString(String.valueOf(100+100*i), 1, getHeight()-75-60*i);
        }
        g2d.drawString("МкС", 10, 20);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);  //задаем серый цвет

        for(int x=50; x<width; x+=60){  // до правого края
            g.drawLine(x, 0, x, height);// вертикальная линия

        }
        for(int y=height-20; y>0; y-=60){  // до верхнего края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }
    }

    private void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(50, 0, 50, height);
        g.drawLine(0, height-20, width, height-20);
    }
    private void drawGraphicInsertion(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.BLUE); // устанавливаем цвет графика
        g2d.setStroke(new BasicStroke(4));
        long[] allTimesInsertion = (long[]) Main.allTimes[0];

        int[] y = new int[allTimesInsertion.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = height-20 - (int) (allTimesInsertion[i]/1680);
        }
        int i = 0;
        g.drawLine(50, height-20, 170, y[0]);
        for (int x = 170; x <1350; x+=120) {
            i++;
            g.drawLine(x, y[i-1], x+120, y[i]);
        }
    }
    private void drawGraphicBubble(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.ORANGE); // устанавливаем цвет графика
        g2d.setStroke(new BasicStroke(4));
        long[] allTimesBubble = (long[]) Main.allTimes[1];

        int[] y = new int[allTimesBubble.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = height-20 - (int) (allTimesBubble[i]/1680);
        }
        int i = 0;
        g.drawLine(50, height-20, 170, y[0]);
        for (int x = 170; x <1350; x+=120) {
            i++;
            g.drawLine(x, y[i-1], x+120, y[i]);
        }
    }
    private void drawGraphicQuick(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.GREEN); // устанавливаем цвет графика
        g2d.setStroke(new BasicStroke(4));
        long[] allTimesQuick = (long[]) Main.allTimes[2];

        int[] y = new int[allTimesQuick.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = height-20 - (int) (allTimesQuick[i]/1680);
        }
        int i = 0;
        g.drawLine(50, height-20, 170, y[0]);
        for (int x = 170; x <1350; x+=120) {
            i++;
            g.drawLine(x, y[i-1], x+120, y[i]);
        }
    }
    private void drawGraphicSelection(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.RED); // устанавливаем цвет графика
        g2d.setStroke(new BasicStroke(4));
        long[] allTimesSelection = (long[]) Main.allTimes[3];

        int[] y = new int[allTimesSelection.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = height-20 - (int) (allTimesSelection[i]/1680);
        }
        int i = 0;
        g.drawLine(50, height-20, 170, y[0]);
        for (int x = 170; x <1350; x+=120) {
            i++;
            g.drawLine(x, y[i-1], x+120, y[i]);
        }
    }
    private void drawGraphicHeap(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.MAGENTA); // устанавливаем цвет графика
        g2d.setStroke(new BasicStroke(4));
        long[] allTimesHeap = (long[]) Main.allTimes[4];

        int[] y = new int[allTimesHeap.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = height-20 - (int) (allTimesHeap[i]/1680);
        }
        int i = 0;
        g.drawLine(50, height-20, 170, y[0]);
        for (int x = 170; x <1350; x+=120) {
            i++;
            g.drawLine(x, y[i-1], x+120, y[i]);
        }
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        width = getWidth();
        height = getHeight();

        drawGrid(g);// рисуем сетку
        drawAxis(g); // рисуем оси
        paintComponent(g);
        drawGraphicInsertion(g);
        drawGraphicBubble(g);
        drawGraphicQuick(g);
        drawGraphicSelection(g);
        drawGraphicHeap(g);
    }
}
