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

    public MovePanel(BattlePanel screen){
        setLayout(new GridLayout(5, 1));
        setPreferredSize(new Dimension(600, 150));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);

        //updateButtons(Main.turnOrder.get(1));


        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Da Battle", 300, 300);
    }

    public void updateButtons(PC curr){
        removeAll();

        one = new JButton(curr.getMove(0).getName());
        two = new JButton(curr.getMove(1).getName());
        three = new JButton(curr.getMove(2).getName());
        four = new JButton(curr.getMove(3).getName());
        five = new JButton(curr.getMove(4).getName());

    }
}
