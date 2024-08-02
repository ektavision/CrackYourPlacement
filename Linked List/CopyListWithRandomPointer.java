
class Solution {
    public Node copyRandomList(Node head) {
         if(head == null) return null;
        Map<Node, Node> hm = new HashMap<>();
        Node cur = head;
        hm.put(cur, new Node(cur.val));
        while(cur != null){
            Node curClone = hm.get(cur);
            if(cur.random != null && !hm.containsKey(cur.random)){
                hm.put(cur.random, new Node(cur.random.val));
            }
            Node randomClone = hm.get(cur.random);
            curClone.random = randomClone;
            if(cur.next != null && !hm.containsKey(cur.next)){
                hm.put(cur.next, new Node(cur.next.val));
            }
            Node nexClone = hm.get(cur.next);
            curClone.next = nexClone;
            cur = cur.next;
        }
        return hm.get(head);
    }
}