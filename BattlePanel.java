import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BattlePanel extends JPanel{
    public BattlePanel(BattleSimGUI screen){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        //setLocation(100, 100);
        setBackground(Color.BLUE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);

        JButton goShop = new JButton("Go to Shop");
        add(goShop, BorderLayout.SOUTH);

        goShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                screen.addDialogue("Going to shop...");
                screen.showShop();
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
