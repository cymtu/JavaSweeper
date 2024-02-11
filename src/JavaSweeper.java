import sweeper.Box;
import sweeper.Coord;
import sweeper.Ranges;

import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {

    private final int COLS = 15;
    private final int ROWS = 2;
    private final int IMAGE_SIZE = 50;
    private JPanel panel;
    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper(){
        Ranges.setSize(COLS, ROWS);
        setImages();
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for(Box box : Box.values()) {
                    Coord coord = new Coord(box.ordinal(), 0);
                    g.drawImage((Image) box.image, coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE, this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(Ranges.getSize().x * IMAGE_SIZE, Ranges.getSize().y * IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    private void setImages() {
        for(Box box : Box.values()){
            box.image = getImage(box.name().toLowerCase());
        }
    }

    private Image getImage(String name) {
        String filename = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }

}