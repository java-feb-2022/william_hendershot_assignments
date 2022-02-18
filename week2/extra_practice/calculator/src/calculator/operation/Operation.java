package week2.extra_practice.calculator.src.calculator.operation;

public abstract class Operation implements java.io.Serializable {

    protected static boolean isLeftAssociative;
    protected static short precedence;

    public abstract Number performOperation();

    public Operation() {
    }

    public boolean isLeftAssociative() {
        return isLeftAssociative;
    }

    public short getPrecedence() {
        return precedence;
    }

}
