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

    private JPanel subpanel;
    private JPanel aniPanel;

    public BattlePanel(BattleSimGUI screen){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.BLUE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);

        JButton goShop = new JButton("Go to Shop");
        add(goShop, BorderLayout.NORTH);

        showActionPanel();
        showStatPanel();

        goShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                screen.addDialogue("Going to shop...");
                screen.showShop();
            }
        });
    }

    public void showStatPanel(){
        aniPanel = new AnimationPanel(this);
        this.add(aniPanel, BorderLayout.NORTH);
    }

    public void showActionPanel(){
        if(subpanel != null){
            this.remove(subpanel);
        }
        subpanel = new ActionPanel(this);
        this.add(subpanel, BorderLayout.SOUTH);
        this.repaint();
        this.revalidate();
    }

    public void showMovePanel(){
        if(subpanel != null){
            this.remove(subpanel);
        }
        subpanel = new MovePanel(this);
        this.add(subpanel, BorderLayout.SOUTH);
        this.repaint();
        this.revalidate();
    }

    public void showTargetPanel(){
        if(subpanel != null){
            this.remove(subpanel);
        }
        subpanel = new PickTargetPanel(this);
        this.add(subpanel, BorderLayout.SOUTH);
        this.repaint();
        this.revalidate();
    }

    public void showWaitPanel(){
        if(subpanel != null){
            this.remove(subpanel);
        }
        subpanel = new WaitPanel(this);
        this.add(subpanel, BorderLayout.SOUTH);
        this.repaint();
        this.revalidate();
    }

    public void showBagPanel(){
        if(subpanel != null){
            this.remove(subpanel);
        }
        subpanel = new BagPanel(this);
        this.add(subpanel, BorderLayout.SOUTH);
        this.repaint();
        this.revalidate();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("Da Battle", 300, 300);
    }
}
