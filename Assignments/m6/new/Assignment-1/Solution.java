
import java.util.Scanner;
class LinkedListStack {
    protected Node top ;
    protected int size ;

    public LinkedListStack() {
        top = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    public int getSize() {
        return size;
    }
    public void listPush(int data) {
        Node nptr = new Node (data, null);
        if (top == null)
            top = nptr;
        else {
            nptr.setLink(top);
            top = nptr;
        }
        size++ ;
    }
    public int listPop() {
        Node ptr = top;
        top = ptr.getLink();
        size-- ;
        return ptr.getData();
    }
    public String display() {
        String str = "";
        Node ptr = top;
        while (ptr != null) {
            str += "" + ptr.getData();
            ptr = ptr.getLink();
        }
        return str;
    }
}

class AddLargeNumbers {

    public static LinkedListStack numberToDigits(String number) {
        LinkedListStack li = new LinkedListStack();
        String[] list = number.split("");
        for (int i = 0; i < list.length; i++) {
            li.listPush(Integer.parseInt(list[i]));
        }
        // System.out.println(li);
        return li;
    }

    public static String digitsToNumber(LinkedListStack list) {
        String str = "";
        // return str;
        str = list.display();
        // System.out.println(str + "str");
        StringBuilder st = new StringBuilder();
        st.append(str);
        // System.out.println(st + "st");
        str = "" + st.reverse();
        // System.out.println(str + "final");
        return str;
    }

    public static LinkedListStack addLargeNumbers(LinkedListStack list1, LinkedListStack list2) {
        LinkedListStack ans = new LinkedListStack();
        int s1 = list1.getSize();
        int s2 = list2.getSize();
        
        int sum = 0;
        int rem = 0;
        int temp = 0;
       
        Node ptr1 = list1.top;
        Node ptr2 = list2.top;
        while (ptr2 != null || ptr1 != null) {
            sum = ptr1.getData() + ptr2.getData();
            // System.out.println("////////////////sum =" + sum);
            if (sum < 9) {
                // System.out.println("<9");
                ans.listPush(sum);
                ptr1 = ptr1.getLink();
                ptr2 = ptr2.getLink();
            } else if (sum > 9) {
                if (sum % 10 == 0) {
                    rem = sum % 10;
                    ans.listPush(rem);
                    ptr1 = ptr1.getLink();
                    ptr2 = ptr2.getLink();
                    int dt = ptr1.getData();
                    temp = ( dt ) + ((sum - rem) / (10));
                    // temp = 11;

                    ptr1.setData(temp);
                    // System.out.println("dt " + ptr1.getData());
                    // System.out.println("((sum - rem) / (10)) = " + ((sum - rem) / (10)));
                    // System.out.println("temp = " + temp);
                    // System.out.println("after ptr1.getData()" + ptr1.getData());

                } else {

                    rem = sum % 10;
                    // System.out.println(">9");
                    // System.out.println("rem =" + rem);
                    ans.listPush(rem);
                    // System.out.println("ptr1.getData() " + ptr1.getData());
                    // System.out.println("((sum - rem) / (10)) = " + ((sum - rem) / (10)));
                    // System.out.println("temp = " + temp);
                    // v
                    //

                    ptr1 = ptr1.getLink();
                    ptr2 = ptr2.getLink();
                    try {
                        temp = ptr1.getData() + ((sum - rem) / (10));

                    } catch (Exception e) {
                        // ans(ans.top.getData() + ((sum - rem) / (10)));
                        // Node ansptr = ans.top;
                        // ansptr.setdata(ansptr.getData() + ((sum - rem) / (10)));
                        break;
                    }

                    ptr1.setData(temp);
                    // System.out.println("after ptr1.getData()" + ptr1.getData());
                }
            }

        }
        // }
        // else {
        //     Node ptr1 = list1.top;
        //     Node ptr2 = list2.top;
        //     while (ptr1 != null) {
        //         sum = ptr1.getData() + ptr2.getData();
        //         if (sum < 9) {
        //             ptr1 = ptr1.getLink();
        //             ptr2 = ptr2.getLink();
        //             ans.listPush(sum);
        //         } else if (sum > 9) {
        //             rem = sum % 10;
        //             ans.listPush(rem);
        //             ptr1 = ptr1.getLink();
        //             ptr2 = ptr2.getLink();
        //             temp = ptr2.getData() + ((sum - rem) / (10));
        //             ptr2.setData(temp);

        //         }

        //     }
        // }




        return ans;
    }
}




/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedListStack pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedListStack qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            // System.out.println(qDigits + " imqSS");
            LinkedListStack result
                = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default :
        }
    }

}