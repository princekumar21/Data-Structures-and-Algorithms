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
    
    
}