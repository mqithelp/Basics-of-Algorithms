package pro.mqithelp;

public class MqStringList implements StringList {
    private String[] list;
    private int position = 0;
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
        if (position == this.size) {
            incraseArray();
        }
        list[position] = item;
        position++;
        return item;
    }


    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        if (position > this.size || index > this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        if (position == this.size) {
            incraseArray();
            shiftItemsLeft(index);
            list[index] = item;
        } else {
            shiftItemsLeft(index);
            list[index] = item;
        }
        position++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        return null;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
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
private boolean isOkArrayLength(int i){
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
        String[] temp = new String[this.size];
        System.arraycopy(list, 0, temp, 0, this.size);
        System.arraycopy(list, index -1, temp, index, this.size - index);
        temp[index] = null;
        this.list = temp;
    }
}
