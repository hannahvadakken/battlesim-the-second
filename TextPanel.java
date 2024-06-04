import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class TextPanel extends JPanel {
    private JLabel tarea; 
    private JTextArea test;

    public TextPanel(){
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    
        //tarea = new JLabel();
        test = new JTextArea();

        // tarea.setVerticalAlignment(SwingConstants.TOP);
        // tarea.setHorizontalAlignment(SwingConstants.LEFT);
        // tarea.setPreferredSize(new Dimension(600, 600));
        // add(tarea, BorderLayout.CENTER);

        test.setEditable(false); 
        test.setLineWrap(true); 
        test.setWrapStyleWord(true);
        //add(test, BorderLayout.CENTER);
    

        //tarea.setLayout(new FlowLayout(FlowLayout.CENTER));
        setVisible(true);

        JScrollPane scroll = new JScrollPane(test);
        add(scroll, BorderLayout.CENTER);
    }

    public void addText(String words){
        test.append(words);
        //test.append("\n");
        // String currentText = tarea.getText();
        // tarea.setText(currentText + words);
    }


}
