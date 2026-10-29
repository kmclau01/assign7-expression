package assignment;

public class Driver {
    public static void main(String[] args) {
      Stack stack = new Stack();
      Expression exp = new Expression();
      
      String math = "(5 + 3)/(2 + 2)";
      math = exp.infixToPostfix(math);
      System.out.println(math);
      
      
    }
}

