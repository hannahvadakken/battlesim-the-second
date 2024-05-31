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

public class CharacterPanel extends JPanel{
    public CharacterPanel(BattleSimGUI screen){
        setLayout(new GridLayout());
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.BLUE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);

        JButton brawler = new JButton("Brawler");
        JButton cleric = new JButton("Cleric");
        JButton mage = new JButton("Mage");
        JButton thief = new JButton("Thief");

        add(brawler);
        add(cleric);
        add(mage);
        add(thief);

        brawler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                PC character = new Brawler();
            }
        });

        cleric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                PC character = new Cleric();
            }
        });

        mage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                PC character = new Mage();
            }
        });

        thief.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                PC character = new Thief();
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