//package week8;
package JonathanDraft;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
public class yeet {//extends JFrame{

    */
/**
 * Create the GUI and show it. For thread safety, this method should be
 * invoked from the event-dispatching thread.
 *//*

    JFrame frame = new JFrame("yeet");


    private yeet() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.

        //Create the menu bar.  Make it have a cyan background.
        JMenuBar cyanMenuBar = new JMenuBar();
        cyanMenuBar.setOpaque(true);
        cyanMenuBar.setBackground(Color.cyan);
        cyanMenuBar.setPreferredSize(new Dimension(200, 20));
        JMenu menuItem = new JMenu("File");
        cyanMenuBar.add(menuItem);

        // Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");

        frame.getContentPane().add(label);
      //  frame.setJMenuBar(cyanMenuBar);
        // Display the window.
        frame.setPreferredSize(new Dimension(300, 100));
        frame.setLocation(new Point(200, 200));
        frame.pack();
        frame.setVisible(true);
        JTabbedPane pane = new JTabbedPane();
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Tab 1"));
        JPanel panel2 = new JPanel();
        panel2.add(new JButton("Tab 2"));

        pane.add("This tab has a label", panel1);
        pane.add("This tab has a button", panel2);
      //  getContentPane().add(pane);
       */
/* setPreferredSize(new Dimension(300, 200));
        setLocation(new Point(100, 100));
        pack();
        setVisible(true);*//*







    }
*/


public class GUI extends  JFrame {

    JFrame frame = new JFrame("paint 2.0");

    JPanel sideBar = new JPanel( new BorderLayout());
    JPanel shapes = new JPanel(new BorderLayout());
    JPanel tools = new JPanel(new BorderLayout());
    JPanel colour_pallet = new JPanel(new BorderLayout());

    // Buttons to shows locations tools on side bar
    JButton Shapes = new JButton("shapes");
    JButton Tools = new JButton("tools");
    JButton Colour_pallet = new JButton("colour_pallet");
    GUI(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        shapes.add(Shapes);
        tools.add(Tools);
        colour_pallet.add(Colour_pallet);

        sideBar.add(shapes, BorderLayout.NORTH);
        sideBar.add(tools, BorderLayout.CENTER);
        sideBar.add(colour_pallet, BorderLayout.SOUTH);
        frame.getContentPane().add(sideBar, BorderLayout.WEST);




        frame.setSize(400,400);
        frame.setLocation(1000,100);


        frame.setVisible(true);

        // BorderLayout is a container so must use .getContentPane
  //      frame.getContentPane().setLayout(new BorderLayout());
       // frame.getContentPane().add(pallet, BorderLayout.WEST);



    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true); // looks like ass
                new GUI();
                // new TabbedPaneDemo();
            }
        });
    }
}