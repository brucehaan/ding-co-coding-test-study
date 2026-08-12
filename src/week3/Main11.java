package week3;


import java.util.ArrayList;
import java.util.List;

class DictChaining {
    static class LinkedTuple {
        private List<KeyValuePair> items;

        public LinkedTuple() {
            this.items = new ArrayList<>();
        }

        public void add(String key, Object value) {
            this.items.add(new KeyValuePair(key, value));
        }

        public Object get(String key) {
            for (KeyValuePair pair : items) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }
            return null;
        }
    }

    static class KeyValuePair {
        String key;
        Object value;

        public KeyValuePair(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}


public class Main11 {
    public static void main(String[] args) {
        DictChaining.LinkedTuple linkedTuple = new DictChaining.LinkedTuple();
        linkedTuple.add("333", 7);
        linkedTuple.add("77", 6);
        System.out.println(linkedTuple.get("333"));
    }
}