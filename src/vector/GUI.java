package vector;

import javax.swing.*;
import java.awt.*;
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
        frame.setLocation(970,50);
        frame.getContentPane().setLayout(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());

        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

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
        Button output = new Button("");
        output.setPreferredSize(new Dimension(20,20));
        return output;
    }

    private Button[] shapeButton(){

        Button plot = new Button("p");
        plot.setPreferredSize(new Dimension(20,20));
        Button line = new Button("l");
        plot.setPreferredSize(new Dimension(20,20));
        Button rectangle = new Button("r");
        plot.setPreferredSize(new Dimension(20,20));
        Button ellipse = new Button("e");
        plot.setPreferredSize(new Dimension(20,20));
        Button polygon = new Button("pn");
        plot.setPreferredSize(new Dimension(20,20));
        Button[] shapeButtonArray = {plot, line, rectangle, ellipse, polygon};
       return shapeButtonArray;
    }
    private Button[] toolButton(){
        Button zoom = new Button("z");
        zoom.setPreferredSize(new Dimension(20,20));
        Button undo = new Button("u");
        undo.setPreferredSize(new Dimension(20,20));
        Button[] toolButtonArray = {zoom, undo};
        return toolButtonArray;
    }
    private Button[] colourButton(){
        Button pen = new Button("p");
        pen.setPreferredSize(new Dimension(20,20));
        Button fill = new Button("f");
        fill.setPreferredSize(new Dimension(20,20));
        Button[] colourButtonArray = {pen, fill};
        return colourButtonArray;
    }


    private void showToolPalette(){

        //frame.add(mainPanel);
        JPanel pallet = new JPanel();
        JPanel shapePallet = new JPanel();
        JPanel toolPallet = new JPanel();
        JPanel colourPallet = new JPanel();
JButton x = new JButton(new ImageIcon("octagon.png"));

        pallet.setBackground(Color.lightGray);
        pallet.setLayout(new GridBagLayout());
        GridBagConstraints palletConstraints = new GridBagConstraints();
        //palletConstraints.fill = GridBagConstraints.HORIZONTAL;

        pallet.setPreferredSize(new Dimension(55, 100));
       // pallet.setSize(new Dimension(500,100));
    //    shapePallet.setPreferredSize(new Dimension(50,100));
        shapePallet.setBackground(Color.BLACK);
       // toolPallet.setPreferredSize(new Dimension(50,300));
        toolPallet.setBackground(Color.GREEN);
       // colourPallet.setPreferredSize(new Dimension(50,300));
        colourPallet.setBackground(Color.RED);











        for(Button button : shapeButton()){
            shapePallet.add(button);
        }


        for(Button button : toolButton()){
            toolPallet.add(button);
        }


        for(Button button : colourButton()){
            colourPallet.add(button);
        }

        JButton xx = new JButton();
        JButton y = new JButton();
        JButton z = new JButton();


        palletConstraints.fill = GridBagConstraints.VERTICAL;
        palletConstraints.gridx =0;
        palletConstraints.gridy =0 ;
        palletConstraints.gridwidth = 40;
        palletConstraints.gridheight = 30;
        palletConstraints.weighty =0.5;
        pallet.add(shapePallet, palletConstraints);

        palletConstraints.fill = GridBagConstraints.VERTICAL;
        palletConstraints.gridx = 0;
        palletConstraints.gridy = 50;
        palletConstraints.weighty = 0.5;
        palletConstraints.gridwidth = 50;
        palletConstraints.gridheight = 30;
        pallet.add(toolPallet, palletConstraints);

        palletConstraints.fill = GridBagConstraints.VERTICAL;
        palletConstraints.gridx = 0;
        palletConstraints.gridy = 700;
        palletConstraints.weighty = 0.5;
        palletConstraints.gridwidth = 50;
        palletConstraints.gridheight = 30;
        pallet.add(colourPallet, palletConstraints);

/*     pallet.add(palletButton());
        pallet.add(palletButton());
        pallet.add(palletButton());
        pallet.add(palletButton());
        pallet.add(palletButton());
        pallet.add(palletButton());*/
        frame.getContentPane().add(pallet, BorderLayout.WEST);
        //mainPanel.add(pallet, BorderLayout.EAST);
    }

    private void showCanvas() {
        canvas = new VectorCanvas();
        mainPanel.add(canvas);
    }
}
