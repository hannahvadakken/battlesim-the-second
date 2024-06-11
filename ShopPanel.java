import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ShopPanel extends JPanel{
    public static boolean battling = true;
    public ShopPanel(BattleSimGUI screen){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.BLUE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);

        JButton goBattle = new JButton("Go to Battle");
        add(goBattle, BorderLayout.NORTH);

        goBattle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                screen.addDialogue("Going to battle...");
                screen.showBattle();
                battling = true;
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Da Shop", 300, 300);
    }
}
