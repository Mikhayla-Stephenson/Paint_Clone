/*
 * GridBagLayoutDemo.java is a 1.4 application that requires no other files.
 */
package JonathanDraft;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
public class GridBagLayoutDemo {


    public static void addComponentsToPane(Container pane) {


        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        button = new JButton("Button 1");

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 9;
        c.gridy = 5;
        pane.add(button, c);


    }


    private static void createAndShowGUI() {
//Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Set up the content pane.
        addComponentsToPane(frame.getContentPane());

//Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}