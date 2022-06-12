public class StringBuilderClear {
    // Java program to demonstrate
    // the delete() Method.

    public static void main(String[] args) {

        // create a StringBuilder object
        // with a String pass as parameter
        StringBuilder str = new StringBuilder("WelcomeGeeks");

        // print string
        System.out.println("Before removal String = "
                + str.toString());

        // remove the substring from index 2 to 8
        // StringBuilder afterRemoval = str.delete(2, 8);

        StringBuilder afterRemoval = str.delete(0, str.length());

        // print string after removal of substring
        System.out.println("After removal String = "
                + afterRemoval.toString());
    }

}
