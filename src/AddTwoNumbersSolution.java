import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class addTwoNumbers {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, current = result;
        int carry = 0;

        while (p != null || q != null) {
            // calculate the digit
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + carry;

            // update carry
            carry = sum / 10;

            current.next = new ListNode(sum % 10);

            // update pointer
            current = current.next;

            if (p != null) {p = p.next;}
            if (q != null) {q = q.next;}
        }

        if (carry > 0) {current.next = new ListNode(carry);}

        return result.next;
    }
}



