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

public class Choice extends JPanel{
    public static boolean selection = false;

    public Choice(BattleSimGUI screen){
        setLayout(new GridLayout(1, 2));
        setPreferredSize(new Dimension(600, 150));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);

        JButton Yes = new JButton("Yes");
        JButton No = new JButton("No");

        add(Yes);
        add(No);

        Yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                ShopPanel.battling = false;
                screen.showShop();
            }
        });

        No.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                ShopPanel.battling = true;
                screen.showBattle();
            }
        });

        
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Da Battle", 300, 300);
    }
}
