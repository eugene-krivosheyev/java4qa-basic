package demo;

public class EnumDemo {
    public static void main(String[] args) {
        SeverityEnum level1 = SeverityEnum.DEBUG;
        SeverityClass level2 = SeverityClass.DEBUG;
        level2 = null;
        level1 = null;

        //logic:
//        switch (level1) {
//            case WARN: break;
//            case ERROR: break;
//            case DEBUG: break;
//            default:
//        }

        SeverityEnum.valueOf("WARN");

        System.out.println(SeverityEnum.values());
    }
}

enum SeverityEnum {
    ERROR(3), WARN(5), DEBUG(9);

    int field;
    SeverityEnum(int field) {
        this.field = field;
    }
}

final class SeverityClass {
    public static final SeverityClass WARN = new SeverityClass(1);
    public static final SeverityClass ERROR = new SeverityClass(2);
    public static final SeverityClass DEBUG = new SeverityClass(3);

    //========================= new
    private int ordinal;
    private SeverityClass(int ordinal) {
        this.ordinal = ordinal;
    }

    public int ordinal() {
        return ordinal;
    }
}