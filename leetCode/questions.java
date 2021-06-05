public class questions {
        //leetcode 876
        public ListNode middleNode(ListNode head) {
            if(head == null || head.next == null) return head;
                
            ListNode slow = head, fast = head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
                
            if(fast.next == null){
                return slow;
            }else{
                return slow.next;
            }
                
        }
    
    //19
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        while(n-- > 0){
            fast = fast.next;
        }
        
        if(fast == null){
            return head.next;
            
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
      
        slow.next = slow.next.next;
        
        
        return head;
        
    }
    
}