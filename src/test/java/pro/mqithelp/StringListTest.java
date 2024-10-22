package pro.mqithelp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void indexOfByItem() {
        int index = 1;
        stringList.add("001");
        stringList.add("002");
        stringList.add("003");
        int result = stringList.indexOf("002");
        assertEquals(1, result);
    }

    @Test
    void indexItemNull() {
        assertThrows(NullPointerException.class, () -> {
            stringList.indexOf(null);
        });
    }

    @Test
    void lastIndexOf() {
        stringList.add("001");
        stringList.add("002");
        stringList.add("003");
        stringList.add("001");
        int result = stringList.lastIndexOf("001");
        assertEquals(3, result);
    }

    @Test
    void lastIndexOfNull() {
        assertThrows(NullPointerException.class, () -> {
            stringList.lastIndexOf(null);
        });
    }

    @Test
    void lastIndexOfNotFound() {
        stringList.add("001");
        int result = stringList.lastIndexOf("002");
        assertEquals(-1, result);
    }

    @Test
    void getItemByIndex() {
        int index = 2;
        stringList.add("000");
        stringList.add("001");
        stringList.add("002");
        stringList.add("003");
        String result = stringList.get(index);
        assertEquals("002", result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 100})
    void getItemByIndexOutofRange(int indexes) {
        stringList.add("000");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stringList.get(indexes);
        });
    }

    @Test
    void testEquals() {
        String itemOne = "001";
        String itemTwo = "002";
        StringList qaz = new MqStringList(10);
        qaz.add(itemOne);
        qaz.add(itemTwo);
        stringList.add(itemOne);
        stringList.add(itemTwo);
        assertTrue(stringList.equals(qaz));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void sizeParam(int index) {
        int i = 0;
        do {
            stringList.add(Integer.toString(i));
        } while (index > i++);
        int result = stringList.size();
        assertEquals(index, result);
        stringList.remove("0");
        result = stringList.size();
        assertEquals(index-1, result);

    }

    @Test
    void size() {
        stringList.add("001");
        stringList.add("002");
        stringList.add("003");
        int result = stringList.size();
        assertEquals(3, result);
//        stringList.remove("002");
//        result = stringList.size();
//        assertEquals(2, result);
    }


    @Test
    void isEmptyAndClear() {
        assertTrue(stringList.isEmpty());
        stringList.add("001");
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    @Test
    void toArray() {
        String[] items;
        String[] testItems  = {"001", "002", "003"};
        stringList.add("001");
        stringList.add("002");
        stringList.add("003");
        items = stringList.toArray();
        assertArrayEquals(testItems, items);

    }
}