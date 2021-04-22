package sandbox;

public strictfp class PrimitivesDemo {
    public strictfp static void main(String[] args) {
        //region char
//        char c = '\uABCD'; // 2 bytes used,unsigned
        char c = '\b';
        int charCode = c;
        System.out.println(">>> Code of a " + charCode);
        //l10n and i18n
        //endregion

        //region wrappers
        System.out.println(Short.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
        //endregion
    }
}
