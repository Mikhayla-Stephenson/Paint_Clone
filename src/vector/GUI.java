package vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.EventListener;

public class GUI {

    JFrame frame;

    GUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("VectorTool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 500));
        showMenuBar();
        frame.pack();
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

    private void showToolpalette(){

    }

    private void showCanvase() {

    }
}
