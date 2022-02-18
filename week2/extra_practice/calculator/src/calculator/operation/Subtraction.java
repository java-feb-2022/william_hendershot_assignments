package week2.extra_practice.calculator.src.calculator.operation;

public class Subtraction extends Binary{
    
    private static final short precedence = 2;
    private static final boolean isLeftAssociative = true;

    public Subtraction() {}

    public Subtraction(Operation lhs, Operation rhs) {
        super(lhs, rhs);
    }

    @Override
    public Number performOperation() {
        return this.lhs.performOperation().doubleValue() - this.rhs.performOperation().doubleValue();
    }
}
