public class RationalNumber extends RealNumber {
    private int numerator, denominator;
    
    public RationalNumber(int nume, int demo) {
        super(0.0);
        numerator = nume;
        denominator = demo;
    }

    public double getValue() {
        return (double) numerator / denominator;
    }
}
