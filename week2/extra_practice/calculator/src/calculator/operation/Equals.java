package week2.extra_practice.calculator.src.calculator.operation;

public class Equals extends Unary{

    public Equals() {}

    public Equals(Operation operand) {
        this.operand = operand;
    }

    @Override
    public Number performOperation() {
        return this.operand.performOperation();
    }
}
