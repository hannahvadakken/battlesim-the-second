import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AnimationPanel extends JPanel{
    private Image backdrop;
    private Image p1;
    private Image p2;
    
    public AnimationPanel(BattlePanel screen){
        setLayout(null);
        setPreferredSize(new Dimension(600, 450));
        //setLocation(400, 200);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);
        try {
            backdrop = ImageIO.read(getClass().getResource("./images/grass.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputCharacters();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawImage(backdrop, 0, 0, getWidth(), getHeight(), this);
        if(Main.p1.getHp() > 0){
            g.drawImage(p1, 200, 200, this);
        }
    }

    public void inputCharacters(){
        if(Main.p1 instanceof Mage){
            try {
                p1 = ImageIO.read(getClass().getResource("./images/mage.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

