import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Fractal {
    public static void drawImage(Graphics graphics){
        drawCross(graphics, 0, 0, WIDTH, HEIGHT);
    }

    public static void drawCross(Graphics g, int x, int y, int width, int height) {
        if (Math.min(width, height) < 10) {
            return;
        }
        // vertical
        g.drawLine(x + width / 3, y, x + width / 3, y + height);
        g.drawLine(x + width * 2 / 3, y, x + width * 2 / 3, y + height);

        //horizontal
        g.drawLine(x, y + height / 3, x + width, y + height / 3);
        g.drawLine(x, y + height * 2 / 3, x + width, y + height * 2 / 3);

        //top left
        drawCross(g, x, y, width / 3, height / 3);
        //top right
        drawCross(g, x + width * 2 / 3, y, width / 3, height / 3);
        //bottom left
        drawCross(g, x, y + height * 2 / 3, width / 3, height / 3);
        //bottom right
        drawCross(g, x + width * 2 / 3, y + height * 2 / 3, width / 3, height / 3);
        //center
        drawCross(g, x + width /3, y + height / 3, width / 3, height / 3);
    }

    // Don't touch the code below
    static int WIDTH = 420;
    static int HEIGHT = 420;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            drawImage(graphics);
        }
    }
}