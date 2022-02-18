package week2.extra_practice.calculator.src.calculator.operation;

public class Division extends Binary {
    
    private static final short precedence = 3;
    private static final boolean isLeftAssociative = true;

    public Division() {}

    public Division(Operation lhs, Operation rhs) {
        super(lhs, rhs);
    }

    @Override
    public Number performOperation() {
        return this.lhs.performOperation().doubleValue() / this.rhs.performOperation().doubleValue();
    }
}
