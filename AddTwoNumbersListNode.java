class AddTwoNumbersListNode {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode answer = new ListNode(0);
        ListNode head = answer;
        
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            answer.next = new ListNode(sum % 10);
            answer = answer.next;
        }
        
        if (sum / 10 == 1) answer.next = new ListNode(1);
        
        return head.next;
    }
}
