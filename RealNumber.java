public class RealNumber {
    private double value;

    public RealNumber(double v) {
        value = v;
    }

    public double getValue() {
        return value;
    }

    public String toString() {
        return "" + getValue();
    }

    public boolean equals(RealNumber other) {
        if (getValue() == 0 || other.getValue() == 0) {
            return getValue() == other.getValue();
        }
        return Math.abs((other.getValue() - getValue()) / getValue()) < 0.00001; 
    }

    public RealNumber add(RealNumber other) {
        return new RealNumber(getValue() + other.getValue());
    }

    public RealNumber subtract(RealNumber other) {
        return new RealNumber(getValue() - other.getValue());
    }

    public RealNumber multiply(RealNumber other) {
        return new RealNumber(getValue() * other.getValue());
    }

    public RealNumber divide(RealNumber other) {
        return new RealNumber(getValue() / other.getValue());
    }
}
