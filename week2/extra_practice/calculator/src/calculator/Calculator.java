package week2.extra_practice.calculator.src.calculator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import week2.extra_practice.calculator.src.calculator.operation.*;

public class Calculator {

    private static final List<String> OPERATIONS = Arrays.asList("+", "-", "*", "/", "=");

    private Queue<Operation> infixQueue;
    private boolean isFunctionComplete;

    public Calculator() {
        this.infixQueue = new LinkedList<Operation>();
        this.isFunctionComplete = false;
    }

    public void performOperation(Object operation) {
        if (operation instanceof Number) {
            if (this.isFunctionComplete) {
                this.infixQueue.clear();
                this.isFunctionComplete = false;
            }
            Operation number = new Operand(operation);
            this.infixQueue.add(number);
        } else if (operation instanceof String && ((String) operation).length() == 1
                && OPERATIONS.contains((String) operation)) {
            switch ((String) operation) {
                case "+":
                    infixQueue.add(new Addition());
                    break;
                case "-":
                    infixQueue.add(new Subtraction());
                    break;
                case "/":
                    infixQueue.add(new Division());
                    break;
                case "*":
                    infixQueue.add(new Multiplication());
                    break;
                case "=":
                    infixQueue.add(new Equals());
                    this.isFunctionComplete = true;
                    break;
            }
        }
    }

    /*
     * Using Shunting-Yard https://en.wikipedia.org/wiki/Shunting-yard_algorithm
     */
    public Number getResults() {

        Queue<Operation> postfix = convertToPostFix();
        Stack<Operation> output = new Stack<Operation>();

        while (!postfix.isEmpty()) {
            Operation op = postfix.remove();
            if (op instanceof Binary){
                ((Binary) op).setRhs(output.pop());
                ((Binary) op).setLhs(output.pop());
                output.add(new Operand(op.performOperation()));
            } else if (op instanceof Unary){
                ((Unary) op).setOperand(output.pop());
                output.add(new Operand(op.performOperation()));
            } else if (op instanceof Operand) {
                output.add(op);
            }
        }
        this.infixQueue.add(output.peek());
        return output.pop().performOperation();
    }

    private Queue<Operation> convertToPostFix () {
        Queue<Operation> output = new LinkedList<Operation>();
        Stack<Operation> operations = new Stack<Operation>();
        while (this.infixQueue.size() > 0) {
            Operation op = this.infixQueue.remove();
            if (op instanceof Operand) {
                output.add(op);
            } else if (op instanceof Function) {
                operations.add(op);
            } else if (op instanceof Binary || op instanceof Unary) {
                if (!operations.isEmpty()) {
                    Operation op2 = operations.peek();
                    while (op2 != null &&
                            (op2.getPrecedence() > op.getPrecedence() ||
                                (op2.getPrecedence() == op.getPrecedence() && op.isLeftAssociative()))) {
                        output.add(operations.pop());
                        op2 = operations.peek();
                    }
                }
                operations.add(op);
            }
        }
        while (!operations.isEmpty()) {
            output.add(operations.pop());
        }
        return output;
    }
}

class SortByPrecendence implements Comparator<Operation> {
    public int compare(Operation a, Operation b) {
        return b.getPrecedence() - a.getPrecedence();
    }
}