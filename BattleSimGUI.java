import javax.swing.*;
import java.awt.*;

public class BattleSimGUI {
    private JFrame frame;
    private JPanel panel; 

    public BattleSimGUI(){
        frame = new JFrame("Unnamed Battle Sim Game");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        showBattle();
    }

    public void showBattle(){
        if(panel != null){
            frame.remove(panel);
        }
        panel = new BattlePanel(this);
        frame.add(panel);
        frame.repaint();
    }

    public void showShop(){
        if(panel != null){
            frame.remove(panel);
        }
        panel = new BattlePanel(this);
        frame.add(panel);
        frame.repaint();
    }
}
