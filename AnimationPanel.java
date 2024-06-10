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
    private Image enemy;
    
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
        inputP1();
        inputP2();
        try {
            enemy = ImageIO.read(getClass().getResource("./images/slime.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawImage(backdrop, 0, 0, getWidth(), getHeight(), this);
        if(Main.p1.getHp() > 0){
            g.drawImage(p1, 30, 140, this);
        }
        if(Main.p2.getHp() > 0){
            g.drawImage(p2, 30, 280, this);
        }
        g.drawImage(enemy, 410, 220, this);
    }

    public void inputP1(){
        if(Main.p1 instanceof Mage){
            try {
                p1 = ImageIO.read(getClass().getResource("./images/mage.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Main.p1 instanceof Brawler){
            try {
                p1 = ImageIO.read(getClass().getResource("./images/brawler.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Main.p1 instanceof Cleric){
            try {
                p1 = ImageIO.read(getClass().getResource("./images/cleric.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Main.p1 instanceof Thief){
            try {
                p1 = ImageIO.read(getClass().getResource("./images/theif.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void inputP2(){
        if(Main.p2 instanceof Mage){
            try {
                p2 = ImageIO.read(getClass().getResource("./images/mage.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Main.p2 instanceof Brawler){
            try {
                p2 = ImageIO.read(getClass().getResource("./images/brawler.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Main.p2 instanceof Cleric){
            try {
                p2 = ImageIO.read(getClass().getResource("./images/cleric.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(Main.p2 instanceof Thief){
            try {
                p2 = ImageIO.read(getClass().getResource("./images/theif.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

