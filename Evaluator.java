/*
 * Author: George Sigety - sigetyg@bc.edu
 */
import java.util.Scanner;

public class Evaluator {
  ListBasedStack<Integer> stack;

  public Evaluator() {
    this.stack = new ListBasedStack<>();
  }

  public int executeOperation(char op) throws UnsupportedOperationException {
    Integer malls = stack.pop();
    Integer balls = stack.pop();
    if (balls == null || malls == null) {
      throw new UnsupportedOperationException("Not enough operands for operator: " + op);
    }
    switch (op) {
      case '+':
      stack.push(balls + malls);
      return (balls + malls);
      case '-':
      stack.push(balls - malls);
      return (balls - malls);
      case '/':
      stack.push(balls / malls);
      return (balls / malls);
      case '*':
      stack.push(balls * malls);
      return (balls * malls);
      default: throw new UnsupportedOperationException("Unsupported operation: " + op);
    }
  }

  public int evaluate(String input){
    Scanner scanner = new Scanner(input);
    while (scanner.hasNext()) {
      while (scanner.hasNextInt()) {
        stack.push(scanner.nextInt());
      }
      if (scanner.hasNext()) {
        String str = scanner.next();
        char lete = str.charAt(0);
        executeOperation(lete);
      }
    }
    int man = (Integer) stack.pop();
    stack.clear();
    return man;
  }

  public void printEvaluation(String input) {
    try {
      System.out.println(evaluate(input));
      stack.clear();
    } catch (UnsupportedOperationException e) {
      System.out.println(e.getMessage());
      stack.clear();
    }
  }

  public static void main(String[] args) {
    String input;
    Evaluator evaluator = new Evaluator();
    System.out.println("Please enter an arithmetic expression in postfix notation with spaces between tokens.");
    System.out.println("Enter \"quit\" to quit.");
    System.out.print("> ");
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      input = scanner.nextLine();
      if (!input.contains("quit")) {
        evaluator.printEvaluation(input);
        System.out.print("> ");
      } else {
        break;
      }
    }
  }
}
