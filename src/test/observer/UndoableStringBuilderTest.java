package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UndoableStringBuilderTest {
    @Test
    void append() {
        UndoableStringBuilder msb = new UndoableStringBuilder();
        msb.append("to eat or not to eat");
        assertEquals("to eat or not to eat", msb.toString());
        msb.append(null);
        assertEquals("to eat or not to eatnull", msb.toString());
    }

    @Test
    void delete() {
        UndoableStringBuilder msb = new UndoableStringBuilder();
        msb.append("Hello World");
        msb.delete(1, 4);
        assertEquals("Ho World", msb.toString());
    }

    @Test
    void insert() {
        UndoableStringBuilder msb = new UndoableStringBuilder();
        msb.append("Shalom");
        msb.insert(1, "d");
        assertEquals("Sdhalom", msb.toString());
        msb.insert(3, null);
        assertEquals("Sdhnullalom", msb.toString());
    }

    @Test
    void replace() {
        UndoableStringBuilder msb = new UndoableStringBuilder();
        msb.append("Shoval Zohar");
        msb.replace(1, 2, "ov");
        assertEquals("Sovoval Zohar", msb.toString());
    }

    @Test
    void reverse() {
        UndoableStringBuilder st = new UndoableStringBuilder();
        st.append("shovali");
        st.reverse();
        assertEquals("ilavohs", st.toString());
    }

    @Test
    void undo() {
        UndoableStringBuilder msb = new UndoableStringBuilder();
        msb.append("to be or not to be");
        msb.replace(3, 5, "eat");
        // "to eat or not to be"
        msb.replace(17, 19, "eat");
        // "to eat or not to eat"
        msb.reverse();
        // "tae ot ton ro tae ot"
        msb.undo();
        assertEquals("to eat or not to eat", msb.toString());
        msb.undo();
        assertEquals("to eat or not to be", msb.toString());
        msb.undo();
        assertEquals("to be or not to be", msb.toString());
        msb.undo();
//        System.out.println(msb.s.peek());
        assertTrue(msb.toString().isEmpty());
    }
}
