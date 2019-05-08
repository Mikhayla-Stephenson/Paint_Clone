
package JonathanDraft;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class guiResize {

    JFrame frame = new JFrame("paint 2.0");


    JPanel mainPanel;

    JPanel sideBar = new JPanel( new BorderLayout());
    JPanel shapes = new JPanel(new BorderLayout());
    JPanel tools = new JPanel(new BorderLayout());
    JPanel colour_pallet = new JPanel(new BorderLayout());

    // Buttons to shows locations tools on side bar
    JButton Shapes = new JButton("shapes");
    JButton Tools = new JButton("tools");
    JButton Colour_pallet = new JButton("colour_pallet");




    guiResize(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());


        showSideBar();




        frame.setSize(400,400);
        frame.setLocation(1000,100);
        //  canvas.setSideWidth(Math.min(mainPanel.getWidth(), mainPanel.getHeight()));
        frame.setVisible(true);
    }
    private JMenuItem createMenuItem(String text, ActionListener e) {
        JMenuItem newMenuItem = new JMenuItem(text);
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        newMenuItem.addActionListener(e);
        return newMenuItem;
    }

    private void open() {
        System.out.println("New");
    }

    private void newFile() {

    }

    private void save() {

    }

    private void saveAs() {

    }



    private void showSideBar(){
        sideBar.add(shapes, BorderLayout.NORTH);
        sideBar.add(tools, BorderLayout.CENTER);
        sideBar.add(colour_pallet, BorderLayout.SOUTH);
        shapeButtons();
        toolButtons();
        colorButtons();
        frame.getContentPane().add(sideBar, BorderLayout.WEST);

    }
    private void shapeButtons(){
        shapes.add(Shapes);
    }
    private void toolButtons(){
        tools.add(Tools);
    }
    private void colorButtons(){
        colour_pallet.add(Colour_pallet);
    }



   public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's guiResize.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true); // looks like ass
                new guiResize();

            }
        });
    }
}