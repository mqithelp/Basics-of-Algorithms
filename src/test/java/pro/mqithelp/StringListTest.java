package pro.mqithelp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListTest {
    private MqStringList stringList;

    @BeforeEach
    void setUp() {
        stringList = new MqStringList(10);
    }

    @Test
    void addStringItem() {
        String item = "Hello";
        String result = stringList.add(item);
        assertEquals(item, result);
        assertEquals(item, stringList.get(0));
    }

    @Test
    void addNullItem() {
        assertThrows(NullPointerException.class, () -> {
            stringList.add(null);
        });
    }

    @Test
    void addItemByIndex() {
        String item = "Second";
        int index = 0;
        stringList.add("First");
        String result = stringList.add(index, item);
        assertEquals(item, result);
        assertEquals(item, stringList.get(index));
    }

    @Test
    void addIndexOutOfRange() {
        String item = "Second";
        stringList.add("First");
        stringList.add("Second");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stringList.add(-1, "Error");
        });
    }

    @Test
    void setItemByIndex() {
        int index = 0;
        String item = "Second";
        stringList.add("First");
        stringList.set(index, item);
        assertEquals(item, stringList.get(index));
        assertEquals(item, stringList.get(index));
    }

    @Test
    void removeByItem() {
        int index = 0;
        String item = "002";
        stringList.add("001");
        stringList.add(item);
        stringList.add("003");
        String result = stringList.remove(item);
        assertEquals(item, result);
        assertEquals(-1, stringList.indexOf(item));
    }

    @Test
    void removeItemByIndex() {
        int index = 1;
        String item = "002";
        stringList.add("001");
        stringList.add(item);
        stringList.add("003");
        String result = stringList.remove(index);
        assertEquals(item, result);
        assertEquals(-1, stringList.indexOf(item));
    }

    @Test
    void removeItemByIndexWithException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stringList.remove(-1);
        });
    }

    @Test
    void contains() {
        String item = "002";
        stringList.add(item);
        boolean result = stringList.contains(item);
        assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void get() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void toArray() {
    }
}