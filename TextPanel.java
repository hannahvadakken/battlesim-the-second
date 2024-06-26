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
        //setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        //setSize(new Dimension(500, 400));
        setPreferredSize(new Dimension(500, 400));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setVisible(true);

        tarea = new JTextArea();
        tarea.setEditable(false); 
        tarea.setLineWrap(true); 
        tarea.setWrapStyleWord(true);
        tarea.setLayout(new FlowLayout(FlowLayout.CENTER));

        JScrollPane scroll = new JScrollPane();
        add(scroll);
    }

    public void addText(String words){
        tarea.append(words + "\n");
    }


}
