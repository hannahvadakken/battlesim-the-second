import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WaitPanel extends JPanel {
    private Timer timer;

    public WaitPanel(BattlePanel screen){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 150));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);
        timer = new Timer(20, e -> {
            if (PC.finished) {
                timer.stop();
                screen.showActionPanel();
                PC.finished = false;
            }
        });

        //timer.restart();
        timer.start();
        
    }

    // private boolean checkFin(){
    //     while(PC.finished = false){
    //         return false;
    //     }
    //     return true;
    // }
    


    
}
