package vector;

import vector.util.CanvasMouse; // Assessing interface for mouse event handlers
import vector.util.Tool;
import vector.util.VectorColor;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.awt.Color.*;

/**
 * GUI class controls the what is output to the window. It contains one canvas object that is read to
 * determine what is printed to the window.
 */
public class GUI extends CanvasMouse  {

    JFrame frame;
    JPanel mainFrame;
    VectorCanvas canvas;
    boolean penPressed = false;
    boolean fillPressed = false;
    boolean quickSelect = false;

    GUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("VectorTool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700+20, 800));
        frame.setLocation(970,50);
        frame.getContentPane().setLayout(new BorderLayout());

        showMenuBar();
        showToolPalette();
        showCanvas();

        frame.pack();
        frame.setVisible(true);
    }

    //Opens File Chooser - Open Dialog
    //Currently chooses a file then prints out the directory path
    private void open() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println(file.toString());
        }
    }

    //Opens new blank window
    //Currently not very useful, if you close one window, all close
    private void newFile() {
        canvas = new VectorCanvas();
        GUI untitled = new GUI();
        System.out.println("new");

    }

    //Opens File Chooser - Save Dialog
    //Currently allows the user to insert a file name then prints out the directory path
    private void save() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println(file.toString());
        }

    }

    //Opens File Chooser - Save Dialog
    //Currently allows the user to insert a file name then prints out the directory path
    private void saveAs() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println(file.toString());
        }

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
    public JButton addListener(JButton button, ActionListener e){
        button.addActionListener(e);
        return button;
    }
    public void colourButtonPressed(ArrayList<JButton> buttonArrayList){
        for (JButton button : buttonArrayList){
            addListener(button, (event) -> colourButtonFunctions(button));
        }
    }
    public void shapeButtonPressed(HashMap<Tool, JButton> buttonArray){
        for (Tool tool : buttonArray.keySet()){
            addListener(buttonArray.get(tool), (event) -> shapeButtonFunctions(tool));
        }
    }
    public void colourButtonFunctions(JButton button){
        System.out.println(button.getName());

        Color colour = button.getBackground();
        int r = colour.getRed();
        int g = colour.getGreen();
        int b = colour.getBlue();
        int rgb = (r*65536)+(g*256)+b;

        if(button.getName().equals("pen")){
            penPressed = true;
            quickSelect = true;
        }
        else if(button.getName().equals("fill")){
            fillPressed = true;
            quickSelect = true;
        }
        else{
            // error message to till user to click pen or fill first
        }
        if (quickSelect) {
            if(!button.getName().equals("pen")&& !button.getName().equals("fill")){

                canvas.setSelectedPenColor(new VectorColor(rgb));
                System.out.println(canvas.getSelectedPenColor().toString());
              //  penPressed = false;
            }
            else if( fillPressed && !button.getName().equals("fill")&& !button.getName().equals("pen")){
              //  canvas.setSelectedFillColor(new VectorColor(rgb));
                System.out.println(canvas.getSelectedFillColor().toString());
               // fillPressed = false;
            }
        }
       // quickSelect = false;
    }


    public void shapeButtonFunctions(Tool tool){
        canvas.selectTool(tool);
        System.out.println(canvas.getselectTool());
    }

    private JButton palletButton() {
        JButton output = new JButton("");
        output.setPreferredSize(new Dimension(20,20));
        return output;
    }

    private HashMap<Tool, JButton> shapeButton(){
        HashMap<Tool, JButton> buttons = new HashMap<>();
        for (Tool name : Tool.values()) {
            buttons.put(name, new JButton(name.name()));
        }

        shapeButtonPressed(buttons);
        return buttons;
    }
    private JButton[] toolButton(){
        JButton zoomPlus = new JButton("PLUS");
      //  zoomPlus.setPreferredSize(new Dimension(45,55));
        JButton zoomMinus = new JButton("MINUS");
       // zoomMinus.setPreferredSize(new Dimension(45,55));
        JButton undo = new JButton("UNDO");
      //  undo.setPreferredSize(new Dimension(45,55));
        return new JButton[]{zoomPlus, zoomMinus, undo};
    }
    public ArrayList<JButton> colourButton(){
        Color[]colourBackground = { RED, BLUE, GREEN, WHITE, BLACK, YELLOW, ORANGE, PINK, CYAN, GRAY};//, blue, green, white, black, yellow, orange, pink, cyan, clear};

        JButton pen = new JButton("PEN");
        pen.setName("pen");
       // pen.setPreferredSize(new Dimension(45,20));
        JButton fill = new JButton("FILL");
        fill.setName("fill");
      //  fill.setPreferredSize(new Dimension(45,20));
        JButton picker = new JButton("PICKER");
        picker.setName("picker");
      //  picker.setPreferredSize(new Dimension(45,20));
        JButton red = new JButton();
        JButton blue = new JButton();
        JButton green = new JButton();
        JButton white = new JButton();
        JButton black = new JButton();
        JButton yellow = new JButton();
        JButton orange = new JButton();
        JButton pink = new JButton();
        JButton cyan= new JButton();
        JButton clear = new JButton();

        JButton[] colourButtonNames = {red, blue, green, white, black, yellow, orange, pink, cyan, clear};
        String[] colourNames = {"red","blue", "green", "white", "black", "yellow", "orange", "pink", "cyan", "clear"};
        ArrayList<JButton> colourButtonArrayList = new ArrayList<>(Arrays.asList(pen,fill,picker));

        int counter = 0;
        for(JButton i : colourButtonNames){
            i.setPreferredSize(new Dimension(20,20));
            i.setBackground(colourBackground[counter]);
            i.setName(colourNames[counter]);
            colourButtonArrayList.add(i);
            counter ++;
        }
        colourButtonPressed(colourButtonArrayList);

        return colourButtonArrayList;
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
        colourPallet.setBackground(RED);
        //colourPallet.setLayout(new GridLayout(3,1));

        for(JButton button : shapeButton().values()){
            shapePallet.add(button);
        }
        for(JButton button : toolButton()){
            toolPallet.add(button);
        }
        for (JButton button : colourButton()){
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
        mainFrame = new JPanel(new SpringLayout());
        canvas.setBackground(WHITE);
        canvas.setBorder(new LineBorder(BLACK));

        canvas.setPreferredSize(new Dimension(500, 500));
        mainFrame.add(canvas);
        frame.add(mainFrame);
//        canvas.setSideWidth(500);
        attachCanvas(canvas); // specify canvas to be used
        canvas.addMouseListener(mouseEvent); // listen for still mouse events
        canvas.addMouseMotionListener(mouseEvent); // listen for moving mouse events

    }
}
