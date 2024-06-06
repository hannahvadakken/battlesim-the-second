import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BagPanel extends JPanel{
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;

    public static boolean OnePress = false;
    public static boolean TwoPress = false;
    public static boolean ThreePress = false;
    public static boolean FourPress = false;
    public static boolean FivePress = false;

    public BagPanel(BattlePanel screen){
        setLayout(new GridLayout(Main.inventory.size(), 1));
        setPreferredSize(new Dimension(600, 150));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);

        updateInvButtons(Main.inventory);

        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                // Move move = current.getMove(0);
                // move.use(current, Main.enemy);

                screen.showTargetPanel();
                OnePress = true;
                PC.itemSel = true;

            }
        });

        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                // Move move = current.getMove(0);
                // move.use(current, Main.enemy);

                screen.showTargetPanel();
                TwoPress = true;
                PC.itemSel = true;

            }
        });

        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                // Move move = current.getMove(0);
                // move.use(current, Main.enemy);

                screen.showTargetPanel();
                ThreePress = true;
                PC.itemSel = true;

            }
        });

        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                // Move move = current.getMove(0);
                // move.use(current, Main.enemy);

                screen.showTargetPanel();
                FourPress = true;
                PC.itemSel = true;

            }
        });

        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                // Move move = current.getMove(0);
                // move.use(current, Main.enemy);

                screen.showTargetPanel();
                FivePress = true;
                PC.itemSel = true;

            }
        });
    }
    

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Da Battle", 300, 300);
    }

    public void updateInvButtons(Inventory inv){
        removeAll();

        one = new JButton(inv.get(0).getName());
        two = new JButton(inv.get(1).getName());
        three = new JButton(inv.get(2).getName());
        four = new JButton(inv.get(3).getName());
        five = new JButton(inv.get(4).getName());

        add(one);
        add(two);
        add(three);
        add(four);
        add(five);

    }
}
