import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
    private JTextArea tarea; 

    public TextPanel(){
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);

        tarea = new JTextArea();
        tarea.setEditable(false); 
        tarea.setLineWrap(true); 
        tarea.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(tarea);
        add(scroll, BorderLayout.CENTER);
    }

    public void addText(String words){
        tarea.append(words + "\n");
    }


}
