package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MAX_SIZE = 10;
    private Pair[] storage;
    private int size;

    public StorageImpl() {
        this.size = 0;
        this.storage = new Pair[MAX_SIZE];
    }

    private <K> Pair findPair(K key) {
        for (Pair item : storage) {
            if (item == null) {
                continue;
            }

            if ((key != null && item != null && key.equals(item.key)) || item.key == key) {
                return item;
            }
        }

        return null;
    }

    @Override
    public void put(K key, V value) {
        Pair pair = this.findPair(key);

        if (pair != null) {
            pair.value = value;
            return;
        }

        this.storage[size] = new Pair(key, value);
        this.size++;
    }

    @Override
    public V get(K key) {
        Pair pair = this.findPair(key);

        if (pair == null) {
            return null;
        }

        return (V) pair.value;
    }

    @Override
    public int size() {
        return this.size;
    }
}
