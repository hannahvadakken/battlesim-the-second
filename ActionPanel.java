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

public class ActionPanel extends JPanel{
    public ActionPanel(BattlePanel screen){
        setLayout(new GridLayout(1, 2));
        setPreferredSize(new Dimension(600, 150));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);

        JButton move = new JButton("Moves");
        JButton bag = new JButton("Bag");

        add(move);
        add(bag);

        move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                screen.showMovePanel();
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
