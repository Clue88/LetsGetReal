public abstract class Number {
    public abstract double getValue();

    public int compareTo(Number other) {
        return (int) Math.round(getValue() - other.getValue());
    }

    public boolean equals(Number other) {
        if (getValue() == 0 || other.getValue() == 0) {
            return getValue() == other.getValue();
        }
        return Math.abs((other.getValue() - getValue()) / getValue()) < 0.00001; 
    }
}
