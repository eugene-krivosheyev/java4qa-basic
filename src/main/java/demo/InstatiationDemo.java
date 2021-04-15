package demo;

public class InstatiationDemo {
    public static void main(String[] args) {
//        StringMessage message = new StringMessage("message");
        final StringMessage message = StringMessage.getInstance();
        System.out.println(message.getBody());

//        new Dummy(field);
        new Dummy();
    }
}

/**
 * Immutable
 */
class StringMessage {
    private String body;
    private static StringMessage singleton = new StringMessage();

    /**
     * Factory Method [GoF]
     */
    public static StringMessage getInstance() {
        return singleton;
    }

    public StringMessage(final String body) {
        this.body = body;
    }

    public StringMessage() {
        this(""); //Constructor Overloading
    }

    public String getBody() {
        return body;
    }
}

class Dummy {
    private int field;

    {
        System.out.println("hello :)");
    }

    Dummy(int field) {
        this.field = field;
    }

    Dummy() {
        this(0); // 1st!!!!
    }

    /**
     * Default constructor
     */
//    Dummy() {
//
//    }
}