public class RationalNumber extends RealNumber {
    private int numerator, denominator;
    
    public RationalNumber(int nume, int demo) {
        super(0.0);
        numerator = nume;
        denominator = demo;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double getValue() {
        return (double) getNumerator() / getDenominator();
    }

    public RationalNumber reciprocal() {
        return new RationalNumber(getDenominator(), getNumerator());
    }

    public boolean equals(RationalNumber other) {
        return getNumerator() == other.getNumerator() && getDenominator() == other.getDenominator();
    }

    public String toString() {
        return getNumerator() + "/" + getDenominator();
    }
}
