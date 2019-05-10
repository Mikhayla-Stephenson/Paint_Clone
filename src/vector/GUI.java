package vector;

import vector.util.CanvasMouse; // Assessing interface for mouse event handlers

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * GUI class controls the what is output to the window. It contains one canvas object that is read to
 * determine what is printed to the window.
 */
public class GUI extends CanvasMouse {

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
        Button plot = new Button("PLOT");
        plot.setPreferredSize(new Dimension(45,35));
        Button line = new Button("LINE");
        line.setPreferredSize(new Dimension(45,35));
        Button rectangle = new Button("BOX");
        rectangle.setPreferredSize(new Dimension(45,35));
        Button ellipse = new Button("CIRCLE");
        ellipse.setPreferredSize(new Dimension(45,35));
        Button polygon = new Button("POLY");
        polygon.setPreferredSize(new Dimension(45,35));
        Button[] shapeButtonArray = {plot, line, rectangle, ellipse, polygon};
       return shapeButtonArray;
    }
    private Button[] toolButton(){
        Button zoomPlus = new Button("PLUS");
        zoomPlus.setPreferredSize(new Dimension(45,55));
        Button zoomMinus = new Button("MINUS");
        zoomMinus.setPreferredSize(new Dimension(45,55));
        Button undo = new Button("UNDO");
        undo.setPreferredSize(new Dimension(45,55));
        Button[] toolButtonArray = {zoomPlus, zoomMinus, undo};
        return toolButtonArray;
    }
    private Button[] colourButton(){
        Button pen = new Button("PEN");
        pen.setPreferredSize(new Dimension(45,20));
        Button fill = new Button("FILL");
        fill.setPreferredSize(new Dimension(45,20));
        Button picker = new Button("PICKER");
        picker.setPreferredSize(new Dimension(45,20));
        Button[] colourButtonArray = {pen, fill, picker};
        return colourButtonArray;
    }

    private void showToolPalette(){

        //frame.add(mainPanel);
        JPanel pallet = new JPanel(new GridLayout(3,1));
        JPanel shapePallet = new JPanel(  );
        //shapePallet.setMaximumSize(new Dimension(500,100));
        JPanel toolPallet = new JPanel();
        JPanel colourPallet = new JPanel();

        pallet.setBackground(Color.lightGray);
      //  pallet.setLayout(new GridBagLayout());
        GridBagConstraints palletConstraints = new GridBagConstraints();
        pallet.setPreferredSize(new Dimension(50, 100));


        //shapePallet.setPreferredSize(new Dimension(50,100));
        shapePallet.setBackground(Color.BLACK);
     //   shapePallet.setLayout(new GridLayout(5,1));
       // toolPallet.setPreferredSize(new Dimension(50,300));
        toolPallet.setBackground(Color.GREEN);
      //  toolPallet.setLayout(new GridLayout(3,1));
       // colourPallet.setPreferredSize(new Dimension(50,300));
        colourPallet.setBackground(Color.RED);
        //colourPallet.setLayout(new GridLayout(3,1));

JButton x = new JButton();
        JButton y = new JButton();
        JButton z = new JButton();
//shapePallet.add(x);
//        toolPallet.add(y);
//        colourPallet.add(z);

        for(Button button : shapeButton()){
            shapePallet.add(button);
        }
        for(Button button : toolButton()){
            toolPallet.add(button);
        }
        for(Button button : colourButton()){
            colourPallet.add(button);
        }
      //  shapePallet.setPreferredSize(new Dimension(50,20));
        palletConstraints.fill = GridBagConstraints.VERTICAL;
        palletConstraints.gridx =0;
        palletConstraints.gridy =0 ;
      //  palletConstraints.ipady = 2;
       // palletConstraints.weighty =0.5;
//        palletConstraints.gridwidth = 50;
      //  palletConstraints.gridheight = 2;
        pallet.add(shapePallet, palletConstraints);

      //  toolPallet.setPreferredSize(new Dimension(50,60));
      //  palletConstraints.gridheight = 10;
        palletConstraints.gridx = 0;
        palletConstraints.gridy = 1;
       // palletConstraints.gridheight = 2;
        pallet.add(toolPallet, palletConstraints);
     //   colourPallet.setPreferredSize(new Dimension(70,20));
        palletConstraints.gridx = 0;
        palletConstraints.gridy = 2;
     //   palletConstraints.gridheight = 2;
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

    public void showCanvas() {
        CanvasMouse mouseEvent = new CanvasMouse(); // interface for mouse events
        canvas = new VectorCanvas();
        mainPanel.add(canvas);
        attachCanvas(canvas); // specify canvas to be used
        canvas.addMouseListener(mouseEvent); // listen for still mouse events
        canvas.addMouseMotionListener(mouseEvent); // listen for moving mouse events

    }
}
