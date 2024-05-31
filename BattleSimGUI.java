import javax.swing.*;
import java.awt.*;

public class BattleSimGUI {
    private JFrame frame;
    private JPanel panel; 
    private TextPanel text;

    public BattleSimGUI(){
        frame = new JFrame("Unnamed Battle Sim Game");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text = new TextPanel();
        frame.add(text, BorderLayout.WEST);


        //i hate containers
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 30,30));

        TextPrintStream stream = new TextPrintStream(System.out, this);
        System.setOut(stream);
        

        showCharacterSelectionScreen();
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
        frame.add(panel, BorderLayout.CENTER);
        frame.repaint();
        frame.revalidate();
    }

    public void showCharacterSelectionScreen(){
        if(panel != null){
            frame.remove(panel);
        }
        panel = new CharacterPanel(this);
        frame.add(panel, BorderLayout.CENTER);
        frame.repaint();
        frame.revalidate();
    }

    public void addDialogue(String words){
        text.addText(words);
    }
}
