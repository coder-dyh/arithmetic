package com.dyh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 * <p>
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lru-cache-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Mianshi1625_LRUCache {

    private Map<Integer, ListNode> map;
    // head dummy node
    private ListNode head;
    // tail dummy node
    private ListNode tail;

    private int capacity;


    /**
     * 作者：jerry_nju
     * 链接：https://leetcode.cn/problems/lru-cache-lcci/solution/linkedhashmap-shuang-lian-biao-hashmap-dan-lian-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param capacity
     */
    public Mianshi1625_LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new ListNode(0, 0);
        this.tail = new ListNode(1, 1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        // 先删除该节点，再接到尾部
        node.pre.next = node.next;
        node.next.pre = node.pre;
        moveToTail(node);
        return node.val;
    }

    /**
     * 作者：jerry_nju
     * 链接：https://leetcode.cn/problems/lru-cache-lcci/solution/linkedhashmap-shuang-lian-biao-hashmap-dan-lian-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param key
     * @param value
     */
    public void put1(int key, int value) {
        // 直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        // 若不存在，new一个出来,如果超出容量，把头去掉
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        moveToTail(node);

        if (map.size() > capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        moveToTail(node);
        if (capacity < map.size()) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }


    }

    public void moveToTail(ListNode node) {
        /*node.next.pre = node.pre;
        node.pre.next = node.next;
        node.next = tail;
        node.pre = tail.pre;*/

        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }


    // 定义双向链表节点
    private class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }
}