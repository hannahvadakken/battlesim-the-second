import java.io.OutputStream;
import java.io.PrintStream;

public class TextPrintStream extends PrintStream {
    private BattleSimGUI gui;

    public TextPrintStream(OutputStream out, BattleSimGUI gui){
        super(out);
        this.gui = gui;
    }

    @Override
    public void println(String s){
        gui.addDialogue(s);
    }


    @Override
    public void println(Object obj) {
        gui.addDialogue(String.valueOf(obj));
    }

    @Override
    public void print(String s) {
        gui.addDialogue(s);
    }

    @Override
    public void print(Object obj) {
        gui.addDialogue(String.valueOf(obj));
    }
}
