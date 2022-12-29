package observer;
import java.util.Stack;
/*
Use the class you've implemented in previous assignment
 */
public class UndoableStringBuilder {
    private final Stack<String> s;
    private StringBuilder sb;

    /**
     *Constructs a string builder with no characters in it and an initial capacity of 16 characters.
     */
    UndoableStringBuilder() {
        sb = new StringBuilder();
        s = new Stack<>();
    }
    /**
     *Constructs a string builder initialized to the contents of the specified string. The initial capacity of the string builder is 16 plus the length of the string argument
     * @param str
     * throws NullPointerException if str is null
     */
    UndoableStringBuilder(String str) {
        sb = new StringBuilder(str);
        s = new Stack<>();
    }

    /**
     * Appends the specified string to this character sequence
     *
     * @param str
     * @return this object
     */
    public UndoableStringBuilder append(String str) {
        if (null == str)
            str = "null";
        s.push(sb.toString());
        sb.append(str);
        return this;
    }

    /**
     * Removes the characters in a substring of this sequence.
     * The substring begins at the specified start and extends to the character at index end-1 or to the end of the sequence if no character exists.
     * if start is equal to end,no changes are made.
     *
     * @param start
     * @param end
     * @return this object;
     */
    public UndoableStringBuilder delete(int start, int end) {
        s.push(s.toString());
        sb.delete(start, end);
        return this;
    }

    /**
     * Inserts the string into this character sequence
     *
     * @param offset
     * @param str
     * @return sb
     */
    public StringBuilder insert(int offset, String str) {
        if (str == null)
            str = "null";
        s.push(sb.toString());
        sb.insert(offset, str);
        return sb;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in the specified String.
     * The substring begins at the specified start and extends to the character at index end-1 or to the end of the sequence if no such character exists/
     * First the characters in the substring are removed and then the specified string is inserted at start.
     *
     * @param start
     * @param end
     * @param str
     * @return this object
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        s.push(sb.toString());
        sb.replace(start, end, str);
        return this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the sequence
     *
     * @return this object
     */
    public UndoableStringBuilder reverse() {
        s.push(sb.toString());
        sb.reverse();
        return this;
    }

    /**
     * Show us what was before
     */
    public void undo() {
//        try {
        sb.replace(0, sb.length(), s.pop());
//        }
//        catch (EmptyStackException e) {
//            sb.replace(0, sb.length(), "");
//        }
    }

    /**
     * Print string
     *
     * @return curr
     */
    public String toString() {
        return sb.toString();
    }

    public static void main(String[] args) {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("to be or not to be");
        System.out.println(usb);
        usb.replace(3, 5, "eat");
        System.out.println(usb);
        usb.replace(17, 19, "eat");
        System.out.println(usb);
        usb.reverse();
        System.out.println(usb);
        System.out.println();
        usb.undo();
        System.out.println(usb);
        usb.undo();
        System.out.println(usb);
        usb.undo();
        System.out.println(usb);
    }


}
