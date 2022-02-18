package week2.extra_practice.calculator.src.calculator.operation;

public abstract class Binary extends Operation {

    protected Operation lhs;
    protected Operation rhs;

    public Binary() {
    }

    public Binary(Operation lhs, Operation rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public Operation getLhs() {
        return lhs;
    }

    public void setLhs(Operation lhs) {
        this.lhs = lhs;
    }

    public Operation getRhs() {
        return rhs;
    }

    public void setRhs(Operation rhs) {
        this.rhs = rhs;
    }
}
