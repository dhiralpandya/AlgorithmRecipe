package com.omtlab.algorithmrecipe.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.apache.commons.collections4.KeyValue;

@AllArgsConstructor
public class KeyValueImpl<K, V> implements KeyValue<K, V> {
    private K k;
    private V v;

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }
}
