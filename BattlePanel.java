import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BattlePanel extends JPanel{
    public BattlePanel(BattleSimGUI screen){
        setLayout(new BorderLayout());
        setSize(100, 100);

        JButton goShop = new JButton("Go to Shop");
        add(goShop, BorderLayout.SOUTH);

        goShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                screen.showShop();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Da Battle", 300, 300);
    }
}
