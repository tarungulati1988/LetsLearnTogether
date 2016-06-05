import java.util.HashMap;
import java.util.Map;

/**
 * Created by tgulati on 5/3/16.
 */
public class LRUCache {

    private Map<String, DoubleLinkedListNode> map = new HashMap<String, DoubleLinkedListNode>();

    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;

    private int capacity;
    private int length;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.length = 0;
    }


    public int get(String key) {
        if(map.containsKey(key)) {
            DoubleLinkedListNode temp = map.get(key);
            removeNode(temp);
            setHead(temp);
            return temp.val;
        } else {
            return -1;
        }
    }

    public void set(String key, int val) {
        if(map.containsKey(key)) {
            DoubleLinkedListNode oldNode = map.get(key);
            oldNode.val = val;
            removeNode(oldNode);
            setHead(oldNode);
        } else {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, val);
            if(length < capacity) {
                setHead(newNode);
                map.put(key, newNode);
                length++;
            } else {
                map.remove(tail.key);
                tail = tail.prev;
                if(tail != null) {
                    tail.next = null;
                }

                setHead(newNode);
                map.put(key, newNode);
            }
        }
    }

    private void setHead(DoubleLinkedListNode temp) {
        temp.next = head;
        temp.prev = null;

        if(head != null) {
            head.prev = temp;
        }

        head = temp;
        if(tail == null) {
            tail = temp;
        }
    }

    private void removeNode(DoubleLinkedListNode temp) {
        DoubleLinkedListNode current = temp;
        DoubleLinkedListNode pre = current.prev;
        DoubleLinkedListNode post = current.next;

        if(pre != null) {
            pre.next = post;
        } else {
            head = post;
        }

        if(post != null) {
            post.prev = pre;
        } else {
            tail = pre;
        }
    }


    class DoubleLinkedListNode {
        int val;
        String key;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;

        DoubleLinkedListNode(String key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
