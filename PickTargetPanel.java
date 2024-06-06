import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PickTargetPanel extends JPanel {

    public static boolean p1 = false;
    public static boolean p2 = false;
    public static boolean enemy = false;

    public PickTargetPanel(BattlePanel screen){
        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(600, 150));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);

        JButton a = new JButton(Main.p1.getName());
        JButton b = new JButton(Main.p2.getName());
        JButton c = new JButton(Main.enemy.getName());

        add(a);
        add(b);
        add(c);

        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                PC.count = 1;
                p1 = true;
                screen.showWaitPanel();

            }
        });

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                PC.count = 1;
                p2 = true;
                screen.showWaitPanel();

            }
        });

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                PC.count = 1;
                enemy = true;
                screen.showWaitPanel();

            }
        });



    }
}
