public class LC_86_Partition_List {
    public class ListNode {
      int val;
      ListNode next;
 ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    }
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(-1);
        ListNode firsthead = first;
        ListNode sec = new ListNode(-1);
        ListNode secHead = sec;


        ListNode temp  = head;
        ListNode prev = null;
        while(head != null){
            //
            if(head.val < x){

                prev = head;
                head= head.next;
                prev.next = null;

                first.next = prev;

                //  head= head.next;
                first = first.next;

            }else{
                prev = head;
                head= head.next;
                prev.next = null;
                sec.next = prev;
                // head= head.next;
                sec = sec.next;
            }



        }
        if(secHead.next != null ) first.next = secHead.next;
        return firsthead.next;

    }

}
