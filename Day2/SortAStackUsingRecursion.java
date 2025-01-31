import java.util.Stack;

public class SortAStackUsingRecursion {
  //Instance static  method for sorting stack
  public static void sortStack(Stack<Integer> stack){
    if(!stack.isEmpty()){
      int top = stack.pop();
      sortStack(stack);
      insertSorted(stack, top);
    }
  }

  private static void insertSorted(Stack<Integer> stack, int element) {
    if(stack.isEmpty() || stack.peek() <= element){
      stack.push(element);
      return;
    }
    int top = stack.pop();
    insertSorted(stack,element);
    stack.push(top);
  }

  public static void main(String[] args) {
    //Create a stack
    Stack<Integer> stack = new Stack<>();

    //push element on stack
    stack.push(100);
    stack.push(12);
    stack.push(79);
    stack.push(59);
    stack.push(3);
    stack.push(20);


    //Method to the stack using recursion
    sortStack(stack);

    //Display the sorted stack
    System.out.println(stack);
  }
}