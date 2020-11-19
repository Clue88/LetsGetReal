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
}
