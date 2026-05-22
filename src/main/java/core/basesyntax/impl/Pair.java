package core.basesyntax.impl;

public class Pair<K, V> {
    protected K key;
    protected V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
