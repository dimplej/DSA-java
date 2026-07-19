class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
class addtwonumbers{
    public ListNode addtwo(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        int carry=0;
        while(l1!=null || l2!= null || carry!=0){
            int digit1=(l1!=null)? l1.val:0;
            int digit2=(l2!= null)?l2.val:0;
            int sum=digit1+digit2+carry;
            carry = sum/10;
            int digit=sum%10;
            tail.next=new ListNode(digit);
            tail = tail.next;

            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }
        return dummy.next;

        }
        public static void printList(ListNode head){
            while(head != null){
                System.out.print(head.val);
                if(head.next != null){
                    System.out.print(" -> ");
                }
                head = head.next;
            }   
            System.out.println();
        }
        public static void main(String[] args){
            addtwonumbers obj=new addtwonumbers();
            ListNode n1=new ListNode(2);
            ListNode n2=new ListNode(3);
            ListNode n3=new ListNode(1);
            n1.next=n2;
            n2.next=n3;
            ListNode n4=new ListNode(1);
            ListNode n5=new ListNode(2);
            ListNode n6=new ListNode(3);
            n4.next=n5;
            n5.next=n6;
            ListNode result=obj.addtwo(n1,n4);
            System.out.println(result);
            printList(result);
        }
    }