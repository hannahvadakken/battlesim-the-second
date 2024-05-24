import javax.swing.*;
import java.awt.*;

public class BattleSimGUI {
    private JFrame frame;
    private JPanel panel; 

    public BattleSimGUI(){
        frame = new JFrame("Unnamed Battle Sim Game");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30,30));
        //frame.getContentPane().setLayout(null);

        showBattle();
    }

    public void showBattle(){
        if(panel != null){
            frame.remove(panel);
        }
        panel = new BattlePanel(this);
        frame.add(panel, BorderLayout.CENTER);
        frame.repaint();
        frame.revalidate();
    }

    public void showShop(){
        if(panel != null){
            frame.remove(panel);
        }
        panel = new ShopPanel(this);
        frame.add(panel);
        frame.repaint();
        frame.revalidate();
    }
}
