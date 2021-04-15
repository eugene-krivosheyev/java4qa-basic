package ooaddemo.printer;

public class FilePrinter implements Printer {
    private String file;

    public FilePrinter(String file) {
        this.file = file;
    }

    @Override
    public void print(String message) {
        System.out.println("to file: " + file + " > " + message);
    }
}
