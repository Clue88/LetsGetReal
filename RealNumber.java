public class RealNumber extends Number {
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
