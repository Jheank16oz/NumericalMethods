import javax.swing.*;
import java.awt.*;

public class Presentation {
    private JPanel panel1;
    private JButton pruebaButton;

    JFrame mainJFrame;

    public Presentation() {
        this.mainJFrame = new JFrame("App");
    }

    public void display(){
        mainJFrame.setContentPane(panel1);
        mainJFrame.setMinimumSize(new Dimension(800,800));
        mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainJFrame.pack();
        mainJFrame.setVisible(true);
    }


}
