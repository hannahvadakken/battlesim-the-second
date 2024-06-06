import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class StatPanel extends JPanel{
    public StatPanel(BattlePanel screen){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(60, 60));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);
    }
}
