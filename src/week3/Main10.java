package week3;

public class Main10 {
    public static void main(String[] args) {
        Dict myDict = new Dict();
        myDict.put("test", 3);
        myDict.put("333", 7);
        myDict.put("77", 6);
        System.out.println(myDict.get("test"));
    }
}

class Dict {
    Object[] items;

    public Dict() {
        this.items = new Object[8];
    }

    public void put(String key, int value) {
        int index = Math.abs(key.hashCode()) % items.length;
        this.items[index] = value;
    }

    public Object get(String key) {
        int index = Math.abs(key.hashCode()) % items.length;
        return this.items[index];
    }
}