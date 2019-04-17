import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {

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

        public static int[] stringToIntegerArray(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return new int[0];
            }

            String[] parts = input.split(",");
            int[] output = new int[parts.length];
            for (int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }

        public static ListNode stringToListNode(String input) {
            // Generate array from the input
            int[] nodeValues = stringToIntegerArray(input);

            // Now convert that list into linked list
            ListNode dummyRoot = new ListNode(0);
            ListNode ptr = dummyRoot;
            for (int item : nodeValues) {
                ptr.next = new ListNode(item);
                ptr = ptr.next;
            }
            return dummyRoot.next;
        }

        public static String listNodeToString(ListNode node) {
            if (node == null) {
                return "[]";
            }

            String result = "";
            while (node != null) {
                result += Integer.toString(node.val) + ", ";
                node = node.next;
            }
            return "[" + result.substring(0, result.length() - 2) + "]";
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                ListNode l1 = stringToListNode(line);
                line = in.readLine();
                ListNode l2 = stringToListNode(line);

                ListNode ret = new Solution().addTwoNumbers(l1, l2);

                String out = listNodeToString(ret);

                System.out.print(out);
            }
        }
    }

