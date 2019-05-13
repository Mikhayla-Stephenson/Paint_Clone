//package JonathanDraft;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AnotherFourPanelLayout {

    private JComponent ui = null;

    AnotherFourPanelLayout() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));
        ui.setLocation(3000, 50);
        addComponents(ui);
  //      System.out.println(ui.get());

    }

    public void addComponents(Container contentPane) {
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3, 3, 3, 3);
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 6;
        c.weightx = 0.66;
        c.weighty = 0.66;
        JPanel panel1 = new JPanel();
        addLabel(panel1, c);
        panel1.setBackground(Color.CYAN);
        contentPane.add(panel1, c);

        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 4;
        //c.weightx = 1.1; // logical?
        c.weightx = 0.66;
        c.weighty = 0.33;
        JPanel panel2 = new JPanel();
        addLabel(panel2, c);
        panel2.setBackground(Color.YELLOW);
        contentPane.add(panel2, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.weightx = 0.33;
        c.weighty = 0.33;
        JPanel panel3 = new JPanel();
        addLabel(panel3, c);
        panel3.setBackground(Color.RED);
        contentPane.add(panel3, c);

        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.33;
        c.weighty = 0.66;
        JPanel panel4 = new JPanel();
        addLabel(panel4, c);
        panel4.setBackground(Color.GREEN);
        contentPane.add(panel4, c);

        // hack to fix?
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.01;
        c.weighty = 0.33;
        JPanel panelH1 = new JPanel();
        //addLabel(panelH1, c);
        panelH1.setBackground(Color.MAGENTA);
        contentPane.add(panelH1, c);

        c.gridy = 1;
        JPanel panelH2 = new JPanel();
        //addLabel(panelH2, c);
        panelH2.setBackground(Color.MAGENTA);
      //  contentPane.add(panelH2, c);

        c.gridy = 2;
        JPanel panelH3 = new JPanel();
        //addLabel(panelH3, c);
        panelH3.setBackground(Color.MAGENTA);
       // contentPane.add(panelH3, c);
    }

    private void addLabel(JPanel panel, GridBagConstraints gbc) {
        panel.add(new JLabel(constraintsToString(gbc)));
    }

    private String constraintsToString(GridBagConstraints gbc) {
        StringBuilder sb = new StringBuilder();

        sb.append("<html><table>");
        sb.append(addRowToTable("Grid X", gbc.gridx));
        sb.append(addRowToTable("Grid Y", gbc.gridy));
        sb.append(addRowToTable("Weight X", gbc.weightx));
        sb.append(addRowToTable("Weight Y", gbc.weighty));
        sb.append(addRowToTable("Grid Width", gbc.gridwidth));
        sb.append(addRowToTable("Grid Height", gbc.gridheight));

        return sb.toString();
    }

    private String addRowToTable(String label, double value) {
        StringBuilder sb = new StringBuilder("<tr><td>");

        sb.append(label);
        sb.append("</td><td>");
        sb.append(value);
        sb.append("</td></tr>");


        return sb.toString();
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                AnotherFourPanelLayout o = new AnotherFourPanelLayout();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}