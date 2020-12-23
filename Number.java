public abstract class Number {
    public abstract double getValue();

    public int compareTo(Number other) {
        if (getValue() > other.getValue()) return 1;
        else if (getValue() < other.getValue()) return -1;
        else return 0;
    }

    public boolean equals(Number other) {
        if (getValue() == 0 || other.getValue() == 0) {
            return getValue() == other.getValue();
        }
        return Math.abs((other.getValue() - getValue()) / getValue()) < 0.00001; 
    }
}
