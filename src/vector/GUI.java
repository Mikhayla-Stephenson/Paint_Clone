package vector;

import javax.swing.*;
import java.awt.*;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * GUI class controls the what is output to the window. It contains one canvas object that is read to
 * determine what is printed to the window.
 */
public class GUI {

    JFrame frame;
    JPanel mainPanel;
    VectorCanvas canvas;

    GUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("VectorTool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700+20, 700));
        mainPanel = new JPanel(new BorderLayout());

        showMenuBar();
        showToolPalette();
        showCanvas();

        frame.pack();
        canvas.setSideWidth(Math.min(mainPanel.getWidth(), mainPanel.getHeight()));
        frame.setVisible(true);
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

    private JMenuItem createMenuItem(String text, ActionListener e) {
        JMenuItem newMenuItem = new JMenuItem(text);
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        newMenuItem.addActionListener(e);
        return newMenuItem;
    }

    public void showMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        fileMenu.add(createMenuItem("New", (event) -> newFile()));
        fileMenu.add(createMenuItem("Open", (event) -> open()));
        fileMenu.add(createMenuItem("Save", (event) -> save()));
        fileMenu.add(createMenuItem("Save As...", (event) -> saveAs()));

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
    }

    private Button palletButton() {
        Button output = new Button();
        output.setPreferredSize(new Dimension(20,20));
        return output;
    }

    private void showToolPalette(){

        frame.add(mainPanel);
        JPanel pallet = new JPanel();
        pallet.setBackground(Color.lightGray);
        pallet.setPreferredSize(new Dimension(50, 100));
        pallet.add(palletButton());
        pallet.add(palletButton());
        pallet.add(palletButton());
        pallet.add(palletButton());
        pallet.add(palletButton());
        pallet.add(palletButton());

        mainPanel.add(pallet, BorderLayout.LINE_START);
    }

    private void showCanvas() {
        canvas = new VectorCanvas();
        mainPanel.add(canvas);
    }
}
