package week2.extra_practice.calculator;

import java.util.ArrayList;

import week2.extra_practice.calculator.src.calculator.Calculator;
import week2.extra_practice.calculator.src.calculator.operation.*;

public class TestCalculator {
    
    public static void main(String[] args) {
        
        System.out.println("----Test Operands---");
        Operand testOperand_1 = new Operand(5);
        Operand testOperand_2 = new Operand(5.23);
    
        System.out.println(testOperand_1);
        System.out.println(testOperand_2);

        ArrayList<Operand> testOperands = new ArrayList<Operand>();

        testOperands.add(testOperand_1);
        testOperands.add(testOperand_2);

        System.out.println(testOperands);

        System.out.println("----Test Addition---");
        Operation testAddition = new Addition(testOperand_1, testOperand_2);
        System.out.println(testAddition.getClass().getSimpleName());
        System.out.println(testAddition.performOperation());
        
        System.out.println("----Test Calculator---");
        Calculator myCalc = new Calculator();
        myCalc.performOperation(10.5);
        myCalc.performOperation("+");
        myCalc.performOperation(5.2);
        System.out.println(myCalc.getResults());
        myCalc.performOperation("-");
        myCalc.performOperation(5);
        System.out.println(myCalc.getResults());
        myCalc.performOperation("*");
        myCalc.performOperation(10);
        System.out.println(myCalc.getResults());
        myCalc.performOperation("=");
        System.out.println(myCalc.getResults());

        myCalc.performOperation(10.5);
        myCalc.performOperation("+");
        myCalc.performOperation(5.2);
        myCalc.performOperation("*");
        myCalc.performOperation(10);
        myCalc.performOperation("=");
        System.out.println(myCalc.getResults());

    }
}
