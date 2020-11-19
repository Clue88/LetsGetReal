public class Tester {
    public static int ERR = 0;
    public static boolean DEBUG = true;
    public static void main(String[] args) {
        String test = "";

        test = "RealNumber.getValue()";
        try {
            double rand = Math.random() * 1000;
            RealNumber num = new RealNumber(rand);
            check(test, num.getValue(), rand);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "RealNumber.toString()";
        try {
            double rand = Math.random() * 1000;
            RealNumber num = new RealNumber(rand);
            check(test, num.toString(), ""+rand);
        } catch(RuntimeException e) {
            except(test, e);
        }
        
        test = "RealNumber.equals(RealNumber other)";
        try {
            RealNumber num = new RealNumber(1.0);
            RealNumber other = new RealNumber(1.000000001);
            check(test, num.equals(other), true);

            other = new RealNumber(1.1);
            check(test, num.equals(other), false);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "RealNumber.add(RealNumber other)";
        try {
            double rand = Math.random() * 1000;
            double rand1 = Math.random() * 1000;
            RealNumber num = new RealNumber(rand);
            RealNumber other = new RealNumber(rand1);
            check(test, (num.add(other)).toString(), rand+rand1+"");
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "RealNumber.subtract(RealNumber other)";
        try {
            double rand = Math.random() * 1000;
            double rand1 = Math.random() * 1000;
            RealNumber num = new RealNumber(rand);
            RealNumber other = new RealNumber(rand1);
            check(test, (num.subtract(other)).toString(), rand-rand1+"");
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "RealNumber.multiply(RealNumber other)";
        try {
            double rand = Math.random() * 1000;
            double rand1 = Math.random() * 1000;
            RealNumber num = new RealNumber(rand);
            RealNumber other = new RealNumber(rand1);
            check(test, (num.multiply(other)).toString(), rand*rand1+"");
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "RealNumber.divide(RealNumber other)";
        try {
            double rand = Math.random() * 1000;
            double rand1 = Math.random() * 1000;
            RealNumber num = new RealNumber(rand);
            RealNumber other = new RealNumber(rand1);
            check(test, (num.divide(other)).toString(), rand/rand1+"");
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "RationalNumber.getNumerator()";
        try {
            int rand = (int) Math.floor(Math.random() * 1000);
            int rand1 = (int) Math.floor(Math.random() * 1000);
            RationalNumber num = new RationalNumber(rand, rand1);
            check(test, num.getNumerator(), rand);
        } catch (RuntimeException e) {
            except(test, e);
        }

        test = "RationalNumber.getDenominator()";
        try {
            int rand = (int) Math.floor(Math.random() * 1000);
            int rand1 = (int) Math.floor(Math.random() * 1000);
            RationalNumber num = new RationalNumber(rand, rand1);
            check(test, num.getDenominator(), rand1);
        } catch (RuntimeException e) {
            except(test, e);
        }

        test = "RationalNumber.getValue()";
        try {
            int rand = (int) Math.floor(Math.random() * 1000);
            int rand1 = (int) Math.floor(Math.random() * 1000);
            RationalNumber num = new RationalNumber(rand, rand1);
            check(test, num.getValue(), (double) rand / rand1);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "RationalNumber.reciprocal()";
        try {
            int rand = (int) Math.floor(Math.random() * 1000);
            int rand1 = (int) Math.floor(Math.random() * 1000);
            RationalNumber num = new RationalNumber(rand, rand1);
            check(test, num.reciprocal().toString(), (new RationalNumber(rand1, rand)).toString());
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "RationalNumber.equals()";
        try {
            int rand = (int) Math.floor(Math.random() * 1000);
            int rand1 = (int) Math.floor(Math.random() * 1000);
            int rand2 = (int) Math.floor(Math.random() * 1000);
            int rand3 = (int) Math.floor(Math.random() * 1000);
            RationalNumber num = new RationalNumber(rand, rand1);
            RationalNumber other = new RationalNumber(rand, rand1);
            RationalNumber other1 = new RationalNumber(rand2, rand3);
            check(test, num.equals(other), true);
            check(test, num.equals(other1), false);
        } catch(RuntimeException e) {
            except(test, e);
        }

        if (ERR == 0) System.out.println("All good!");
        else if (ERR == 1) System.out.println("Uh oh... 1 error found.");
        else System.out.println("Uh oh... " + ERR + " errors found.");
    }

    public static void check(String test, Object actual, Object expected) {
        if (!actual.equals(expected)) {
            System.out.println("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
            ERR++;
        }
    }

    public static void except(String test, RuntimeException e) {
        System.out.println("Failure on " + test + ": RuntimeException");
        if (DEBUG) System.out.println(e.toString());
        ERR++;
    }
}
