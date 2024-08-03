
class Solution {
    
    static int find_size(Node n) {
		int size = 0;

		while (n != null) {
			n = n.next;
			++size;
		}

		return size;
	}
	
	static Node reverse(Node n) {
		Node prev = null;
		Node curr = n;

		while (curr != null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		return prev;
	}
	static Node remove_leading_zeroes(Node node) {
	    while (node != null && node.data == 0)
	        node = node.next;
	   
	   return node;
	}
    public Node subLinkedList(Node head1, Node head2) {
        // code here
          head1 = remove_leading_zeroes(head1);
        head2 = remove_leading_zeroes(head2);
        
		int n1 = find_size(head1);
		int n2 = find_size(head2);

		boolean head2_is_greater = false;
		int skip = 0;

		Node temp1 = head1, temp2 = head2;
		
		if (n2 > n1)
		    head2_is_greater = true;
		else if (n1 == n2) {
			while (temp1 != null) {
				if (temp2.data > temp1.data) {
					head2_is_greater = true;
					break;
				}
				else if (temp1.data == temp2.data)
					++skip;
				else
				    break;
				
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			
			if (skip == n1)
				return new Node(0);
		}
		
		skip = Math.max(n1, n2) - skip;
		
		Node res = new Node(-1);

		head1 = reverse(head1);
		head2 = reverse(head2);

		int diff, c = 0;
		Node temp_res = res;
		temp1 = head1; temp2 = head2;
		
		if (head2_is_greater) {
			temp1 = head2; temp2 = head1;
		}

		while ((temp1 != null || temp2 != null) && skip > 0) {
			diff = -c;
			
			if (temp1 != null) {
			    diff += temp1.data;
			    temp1 = temp1.next;
			}
			if (temp2 != null) {
			    diff -= temp2.data;
			    temp2 = temp2.next;
			}
			
			if (diff >= 0)
				c = 0;
			else {
				diff += 10;
				c = 1;
			}
			
			temp_res.next = new Node(diff);
			temp_res = temp_res.next;
			--skip;
		}

		res = reverse(res.next);
		
 		while (res != null && res.data == 0)
 		    res = res.next;

		return res;
    }
}
        
