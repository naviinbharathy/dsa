package assignment.oct14;

public class HashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private float loadFactor;
    private int size;
    private Entry<K, V>[] table;

    public HashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = (Entry<K, V>[]) new Entry[capacity];
    }

    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int hash(K key) {
        return (key == null) ? 0 : (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        Entry<K, V> newEntry = new Entry<>(key, value, table[index]);
        table[index] = newEntry;
        size++;

        if (size > capacity * loadFactor) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        Entry<K, V> prev = null;

        while (entry != null) {
            if (entry.key.equals(key)) {
                if (prev == null) {
                    table[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return;
            }
            prev = entry;
            entry = entry.next;
        }
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[newCapacity];

        for (int i = 0; i < capacity; i++) {
            Entry<K, V> entry = table[i];
            while (entry != null) {
                Entry<K, V> next = entry.next;
                int newIndex = (entry.key == null) ? 0 : (entry.key.hashCode() & 0x7FFFFFFF) % newCapacity;
                entry.next = newTable[newIndex];
                newTable[newIndex] = entry;
                entry = next;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        map.put("Six", 6);

        System.out.println("Current size: " + map.size);
        System.out.println("Value for 'Three': " + map.get("Three"));
        System.out.println("Value for 'Six': " + map.get("Six"));

        map.remove("Three");

        // Trying to retrieve the removed key
        System.out.println("Value for 'Three': " + map.get("Three"));

        System.out.println("trigger resizing:");
        for (int i = 7; i <= 20; i++) {
            map.put("Key" + i, i);
        }

        System.out.println("Current size after adding more elements: " + map.size);
    }
}
