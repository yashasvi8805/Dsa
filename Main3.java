import java.util.*;

public class Main3 {

    static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {
        HashMap<Integer, Node> map = new HashMap<>();

        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);

        int capacity;

        LRUCache(int capacity) {
            this.capacity = capacity;

            head.next = tail;
            tail.prev = head;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        int get(int key) {

            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);

            remove(node);
            addFirst(node);

            return node.value;
        }

        void put(int key, int value) {

            if (map.containsKey(key)) {

                Node node = map.get(key);
                node.value = value;

                remove(node);
                addFirst(node);

                return;
            }

            Node node = new Node(key, value);

            map.put(key, node);
            addFirst(node);

            if (map.size() > capacity) {

                Node last = tail.prev;

                remove(last);
                map.remove(last.key);
            }
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1));

        cache.put(3, 30);

        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}