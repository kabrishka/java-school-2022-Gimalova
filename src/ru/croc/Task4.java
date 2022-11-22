package ru.croc;

public class Task4 {
    /*
     * Удаление комментариев из строки
     *
     * @param str - исходная строка
     * @return измененная строка без комменатриев
     * */
    public static String removeJavaComments(String str) {
        //использование регулярных выражений
        String s = str.replaceAll("((['\"])(?:(?!\\2|\\\\).|\\\\.)*\\2)|\\/\\/[^\\n]*|\\/\\*(?:[^*]|\\*(?!\\/))*\\*\\/", "");
        return s;
    }

    public static void main(String[] args) {
        String source = "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "  \n" +
                "  /* main method */\n" +
                "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "    // this line prints my first greeting to the screen\n" +
                "    System.out.println(\"Hi!\"); // :)\n" +
                "  }\n" +
                "} // the end\n" +
                "// to be continued...\n";
        String noComments = removeJavaComments(source);
        System.out.println(noComments);
    }
}
