import java.util.*;

class Node {
    int key;
    int val;
    int freq = 1;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    Node removeLast() {
        if (tail.prev == head) return null;
        Node last = tail.prev;
        removeNode(last);
        return last;
    }

    boolean isEmpty() {
        return head.next == tail;
    }
}

class LFUCache {
    Map<Integer, Node> cache;
    Map<Integer, DoublyLinkedList> freqList;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqList = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            if (cache.size() == capacity) {
                DoublyLinkedList minList = freqList.get(minFreq);
                Node toRemove = minList.removeLast();
                cache.remove(toRemove.key);
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            freqList.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
            minFreq = 1;
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        DoublyLinkedList list = freqList.get(freq);
        list.removeNode(node);

        if (list.isEmpty() && freq == minFreq) {
            minFreq++;
        }

        node.freq++;
        freqList.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addNode(node);
    }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */