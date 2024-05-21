
public class Colors {

    public static final String reset = "\u001B[0m";
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36m";
    public static final String white = "\u001B[37m";


    public static String general(String color, String s){
        return color + s + reset;
    }

    public static String black(String s){
        return general(black, s);
    }

    public static String red(String s){
        return general(red, s);
    }

    public static String green(String s){
        return general(green, s);
    }

    public static String yellow(String s){
        return general(yellow, s);
    }

    public static String blue(String s){
        return general(blue, s);
    }

    public static String purple(String s){
        return general(purple, s);
    }

    public static String cyan(String s){
        return general(cyan, s);
    }

    public static String white(String s){
        return general(white, s);
    }



}
