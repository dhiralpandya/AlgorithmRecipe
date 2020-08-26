package com.omtlab.algorithmrecipe.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following 
 * operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 -> capacity );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.put(4,4);    // evicts key 1
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
 */
public class LC146 {

    /**
     * Below solution is only for your understanding, 
     * DO NOT use as final solution in interview, 
     * for interview we will use actual linkedList implementation. 
     */

    /**
     * What is load factor here ?
     * An instance of HashMap has two parameters that affect its performance: initial capacity and load factor.
     * The capacity is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is created.
     * The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased.
     * When the number of entries in the hash table exceeds the product of the load factor and the current capacity,
     * the hash table is rehashed (that is, internal data structures are rebuilt)
     * so that the hash table has approximately twice the number of buckets.
     *
     * As a general rule, the default load factor (.75) offers a good tradeoff between time and space costs.
     * Higher values decrease the space overhead but increase the lookup cost
     * (reflected in most of the operations of the HashMap class,including get and put).
     * The expected number of entries in the map and its load factor should be taken into account when setting its initial capacity,
     * so as to minimize the number of rehash operations.
     * If the initial capacity is greater than the maximum number of entries divided by the load factor, no rehash operations will ever occur.
     */
    public static class LRUCacheSimpleQuick {
        private final int capacity;
        private LinkedHashMap<Integer,Integer> linkedHashMap = null;
        public LRUCacheSimpleQuick(int capacity) {
           this.capacity = capacity;
           linkedHashMap = new LinkedHashMap<Integer,Integer>(capacity,1.0f){
               @Override
               protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                   return linkedHashMap.size() > capacity;
               }
           };
           
        }

        public int get(int key) {
            return linkedHashMap.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            linkedHashMap.put(key,value);
        }
    }


    /**
     * Here we will use linkedList with node linked to next and previous node. 
     * Like this
     * [HEAD]<->[2]<->[3]<->[1]<->[TAIL]
     * you just have to remove and add node each time when we access it.
     */
    static class LinkNode{
        LinkNode next;
        LinkNode pre;
        int value;
        int key;

        LinkNode(){
            
        }

        LinkNode(LinkNode next, LinkNode pre){
            this.next = next;
            this.pre = pre;
        }
    }
    
    
    public static class LRU{
        Map<Integer,LinkNode> mapIdNode = new HashMap<>();
        int capacity; 
        int currentCount;
        LinkNode head = new LinkNode();
        LinkNode tail = new LinkNode();
        
        public LRU(int capacity){
            this.capacity =capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key){
            
            if(mapIdNode.containsKey(key)){
                LinkNode node = mapIdNode.get(key);
                
                remove(node);
                add(node);
                
                return node.value;
            }
            
            return -1;
        }
        
        
        

        public void put(int key, int value) {
            
            if(mapIdNode.containsKey(key)){
                LinkNode node = mapIdNode.get(key);
                node.value = value;
                remove(node);
                add(node);
            }else {

                if (currentCount >= capacity) {
                    mapIdNode.remove(tail.pre.key);
                    remove(tail.pre);
                    currentCount--;
                }

                LinkNode node = new LinkNode();
                node.value = value;
                node.key = key;
                mapIdNode.put(key, node);
                add(node);

                currentCount++;
            }
        }

            void remove(LinkNode remove){
            
            LinkNode next = remove.next;
            LinkNode pre = remove.pre;
            pre.next = next;
            next.pre = pre; 
            
        }

        void add(LinkNode add){
           LinkNode next = head.next;
           head.next = add;
           add.next = next;
           add.pre = head; 
           next.pre = add;
        }
    }
    
    
}
