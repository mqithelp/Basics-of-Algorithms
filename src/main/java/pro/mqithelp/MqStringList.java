package pro.mqithelp;

import java.util.Arrays;

public class MqStringList implements StringList {
    private String[] list;
    private int position = -1;
    private int size = 0;

    public MqStringList(int size) {
        this.size = size;
        this.list = new String[this.size];

    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        position++;
        if (position == this.size) {
            incraseArray();
        }
        list[position] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        if (index > position) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        position++;
        if (position == this.size) {
            incraseArray();
            shiftItemsLeft(index);
            list[index] = item;
        } else {
            shiftItemsLeft(index);
            list[index] = item;
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("Index out: " + index);
        }
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        list[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int findItemIndex;
        findItemIndex = findItem(item);
        if (findItemIndex < 0) {
            throw new IllegalArgumentException("Item not exists: " + item);
        }
        removeItem(findItemIndex);

        return item;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index > position) {
            throw new IndexOutOfBoundsException("Index of bounds: " + index);
        }
        String removeItem = list[index];
        removeItem(index);
        return removeItem;
    }

    @Override
    public boolean contains(String item) {
        return findItem(item) > 0;
    }

    @Override
    public int indexOf(String item) {
        return findItem(item);
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new NullPointerException("Item is null.");
        }
        for (int i = position; i >= 0; i--) {
            if (list[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > position) {
            throw new IndexOutOfBoundsException("Index of bounds: " + index);
        }
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (this == otherList) return true;
        if (otherList == null || getClass() != otherList.getClass()) return false;
        if (this.size() != otherList.size()) return false;

        MqStringList that = (MqStringList) otherList;

        if (size != that.size) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(list, that.list);
    }

    @Override
    public int size() {
        return position;
    }

    @Override
    public boolean isEmpty() {
        return position < 0;
    }

    @Override
    public void clear() {
        position = -1;
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
    }

    @Override
    public String[] toArray() {
        String[] result = new String[position];
        System.arraycopy(list, 0, result, 0, position);
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        int i = 0;
        while (isOkArrayLength(i)) {
            result = result + list[i] + " ";
            i++;
        }
        return result;
    }

    private boolean isOkArrayLength(int i) {
        if (i < this.size) {
            if (this.list[i] != null) return true;
        }
        return false;
    }

    private void incraseArray() {
        String[] temp = new String[this.size + 16];
        System.arraycopy(list, 0, temp, 0, this.size);
        this.size += 16;
        list = temp;
    }

    private void shiftItemsLeft(int index) {
        String[] temp = new String[this.size + 1];
        System.arraycopy(list, 0, temp, 0, this.size);
        System.arraycopy(list, index, temp, index + 1, this.size - index);
        temp[index] = null;
        this.list = temp;
    }

    private int findItem(String item) {
        for (int i = 0; i < this.size; i++) {
            if (list[i] == null) {
                return -1;
            }
            if (list[i].equals(item)) return i;
        }
        return -1;
    }

    private void removeItem(int findItemIndex) {
        String[] temp = new String[this.size];
        list[findItemIndex] = null;
        for (int i = findItemIndex; i < this.size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[position] = null;
        position--;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(list);
    }
}
