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
    
    public AnimationPanel(BattlePanel screen){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 450));
        setLocation(400, 200);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);
        try {
            backdrop = ImageIO.read(getClass().getResource("./images/grass.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawImage(backdrop, 0, 0, getWidth(), getHeight(), this);
    }
}

