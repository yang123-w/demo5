package c4;

public class Solution4 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;

        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        //连接后续非空的数据
//        pre.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode111 = new ListNode(5);
        listNode1.next=listNode111;
        listNode111.next = new ListNode(10);

//        while (listNode1!=null){
//            System.out.print(listNode1.val+",");
//            listNode1 = listNode1.next;
//        }

        ListNode listNode2 = new ListNode(2);
        listNode2.next=new ListNode(6);

        Solution4 solution4 = new Solution4();
        ListNode listNode = solution4.mergeTwoLists(listNode1, listNode2);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
