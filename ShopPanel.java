import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ShopPanel extends JPanel{
    public ShopPanel(BattleSimGUI screen){
        setLayout(new BorderLayout());
        setSize(100, 100);

        JButton goBattle = new JButton("Go to Battle");
        add(goBattle, BorderLayout.SOUTH);
        goBattle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                screen.showBattle();
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Da Shop", 300, 300);
    }
}
