package week2.extra_practice.calculator.src.calculator.operation;

public class Addition extends Binary{
    
    private static final short precedence = 2;
    private static final boolean isLeftAssociative = true;

    public Addition() {}

    public Addition(Operation lhs, Operation rhs) {
        super(lhs, rhs);
    }

    @Override
    public Number performOperation() {
        return this.lhs.performOperation().doubleValue() + this.rhs.performOperation().doubleValue();
    }
}
