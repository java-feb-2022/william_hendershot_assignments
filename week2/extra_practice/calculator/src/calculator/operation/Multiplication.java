package week2.extra_practice.calculator.src.calculator.operation;

public class Multiplication extends Binary{
    
    private static final short precedence = 3;
    private static final boolean isLeftAssociative = true;

    public Multiplication() {}

    public Multiplication(Operation lhs, Operation rhs) {
        super(lhs, rhs);
    }

    @Override
    public Number performOperation() {
        return this.lhs.performOperation().doubleValue() * this.rhs.performOperation().doubleValue();
    }
}
