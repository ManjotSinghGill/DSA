package Stack;

public class Stack {

    public ListNode top;
    public int length;

    private static class ListNode{
        private final int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop(){
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public static String reverse(String string){
        java.util.Stack<Character> stack = new java.util.Stack<>();
        char[] chars = string.toCharArray();
        for(char j : chars){
            stack.push(j);
        }
        for(int i = 0; i < string.length(); i++){
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public static int[] nextGreaterElementArray(int[] arr){
        int[] result = new int[arr.length];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for(int i = arr.length -1; i >= 0; i--){
            if (!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
            }
            if (stack.isEmpty()){
                result[i] = -1;
            }else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(reverse("Hello"));

        int[] arr = {4,5,9,8,11};
        int[] output = nextGreaterElementArray(arr);
        for ( int j: output) {
            System.out.print(j);
        }
    }
}
