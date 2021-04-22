package ooaddemo.printer;

public interface Printer {
    public final static int INTERFACE_CONST = 1; // one for all constant

    public abstract void print(String message); // package friendly

    /** DEFENDERS in interface
     *
     */
    public static void CommonMethod(){
        System.out.println("Common");

    }

    default void instMethod(){
        this.toString();
    }
}
