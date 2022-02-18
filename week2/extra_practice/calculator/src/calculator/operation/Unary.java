package week2.extra_practice.calculator.src.calculator.operation;

public abstract class Unary extends Operation {

    protected Operation operand;

    public Unary(){}

    public Unary(Operation operand) {
        this.operand = operand;
    }

    public Operation getOperand() {
        return operand;
    }

    public void setOperand(Operation operand) {
        this.operand = operand;
    }

}
