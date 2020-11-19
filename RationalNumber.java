public class RationalNumber extends RealNumber {
    private int numerator, denominator;
    
    public RationalNumber(int nume, int demo) {
        super(0.0);
        numerator = nume;
        denominator = demo;
        reduce();
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

    private static int gcd(int a, int b) {
        if (a < b) {
            int c = a;
            a = b;
            b = c;
        }

        if (b == 0) return a;
        if (a % b == 0) return b;

        int r = a % b;
        while (r != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    private void reduce() {
        int gcd = gcd(getNumerator(), getDenominator());
        numerator = getNumerator() / gcd;
        denominator = getDenominator() / gcd;
    }

    public RationalNumber multiply(RationalNumber other) {
        return new RationalNumber(getNumerator()*other.getNumerator(), getDenominator()*other.getDenominator());
    }
    
    public RationalNumber divide(RationalNumber other) {
        return new RationalNumber(getNumerator()*other.getDenominator(), getDenominator()*other.getNumerator());
    }
}
