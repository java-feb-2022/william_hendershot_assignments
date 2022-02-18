package week2.extra_practice.calculator.src.calculator.operation;


public class Operand extends Operation {
    
    private Number value;

    public Operand(Object value) {
        if (value instanceof Number) {
            this.value = (Number) value;
        } else {
            throw new IllegalArgumentException("Given value is not an instance of type Number");
        }
    }

    @Override
    public Number performOperation() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
