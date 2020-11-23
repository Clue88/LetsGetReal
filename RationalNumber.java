public class RationalNumber extends RealNumber {
    private int numerator, denominator;
    
    public RationalNumber(int nume, int deno) {
        super((double) nume/deno);
        numerator = nume;
        denominator = deno;
        if (denominator == 0) {
            numerator = 0;
            denominator = 1;
        }
        reduce();
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public RationalNumber reciprocal() {
        return new RationalNumber(getDenominator(), getNumerator());
    }

    public boolean equals(RationalNumber other) {
        return getNumerator() == other.getNumerator() && getDenominator() == other.getDenominator();
    }

    public String toString() {
        if (getDenominator() == 1) return ""+getNumerator();
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

    public RationalNumber add(RationalNumber other) {
        return new RationalNumber(getNumerator()*other.getDenominator() + other.getNumerator()*getDenominator(), getDenominator() * other.getDenominator());
    }

    public RationalNumber subtract(RationalNumber other) {
        return new RationalNumber(getNumerator()*other.getDenominator() - other.getNumerator()*getDenominator(), getDenominator() * other.getDenominator());
    }
}
