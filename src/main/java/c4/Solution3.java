package c4;

public class Solution3 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next=new ListNode(5);

        ListNode listNode2 = new ListNode(2);
        listNode2.next=new ListNode(6);

        Solution3 solution3 = new Solution3();
       ListNode listNode = solution3.mergeTwoLists(listNode1, listNode2);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}
