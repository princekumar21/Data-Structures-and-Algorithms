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

    //leetcode 83
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null){
              return head;
          }
          
         ListNode temp = new ListNode();
          temp.val = -1000;
          ListNode dumy = temp;
          ListNode curr = head;
          
         while(curr != null){
            if(dumy.val != curr.val){
              dumy.next = curr;
              dumy = dumy.next;
              
            }
            curr = curr.next;
         }
         dumy.next = null;
         return temp.next;
          
        }
            
        
    }
    //leetcode 206
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode prev = null;
            ListNode curr = head;
            while(curr != null){
                ListNode forw = curr.next;
                
                curr.next = prev;
                prev = curr;
                curr = forw;
                
            }
           
            head = prev;
            return head;
            
        }
    }
    
}