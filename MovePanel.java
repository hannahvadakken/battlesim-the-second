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

public class MovePanel extends JPanel{
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private Battler current;

    public static boolean OnePress = false;
    public static boolean TwoPress = false;
    public static boolean ThreePress = false;
    public static boolean FourPress = false;
    public static boolean FivePress = false;

    public MovePanel(BattlePanel screen){
        setLayout(new GridLayout(5, 1));
        setPreferredSize(new Dimension(600, 150));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);
        
        if (Main.current instanceof PC) {
            updateButtons((PC) Main.current);
    
            one.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a){
                    // Move move = current.getMove(0);
                    // move.use(current, Main.enemy);

                    screen.showTargetPanel();
                    OnePress = true;
    
                }
            });

            two.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a){
                    // Move move = current.getMove(0);
                    // move.use(current, Main.enemy);

                    screen.showTargetPanel();
                    TwoPress = true;
    
                }
            });

            three.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a){
                    // Move move = current.getMove(0);
                    // move.use(current, Main.enemy);

                    screen.showTargetPanel();
                    ThreePress = true;
    
                }
            });

            four.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a){
                    // Move move = current.getMove(0);
                    // move.use(current, Main.enemy);

                    screen.showTargetPanel();
                    FourPress = true;
    
                }
            });

            five.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a){
                    // Move move = current.getMove(0);
                    // move.use(current, Main.enemy);

                    screen.showTargetPanel();
                    FivePress = true;
    
                }
            });
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Da Battle", 300, 300);
    }

    public void updateButtons(PC current){
        removeAll();
        this.current = current;
        one = new JButton(current.getMove(0).getName());
        two = new JButton(current.getMove(1).getName());
        three = new JButton(current.getMove(2).getName());
        four = new JButton(current.getMove(3).getName());
        five = new JButton(current.getMove(4).getName());

        add(one);
        add(two);
        add(three);
        add(four);
        add(five);

    }
}
