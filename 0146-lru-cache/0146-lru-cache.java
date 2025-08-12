class LRUCache {

    Map<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {

        map=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
        
    }

    public void insert(Node curr){
        curr.next=head.next;
        curr.prev=head;
        head.next=curr;
        curr.next.prev=curr;
    }

    public void delete(Node curr){

        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;

    }
    
    public int get(int key) {

        if(map.containsKey(key)){
            Node curr=map.get(key);
            delete(curr);
            insert(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr=map.get(key);
            curr.val=value;
            delete(curr);
            insert(curr);
        }
        else if(map.size()<capacity){
            map.put(key,new Node(key,value));
            insert(map.get(key));
        } else{
            map.put(key,new Node(key,value));
            map.remove(tail.prev.key);
            delete(tail.prev);
            insert(map.get(key));
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key=key;
        this.val=val;
    }
 }