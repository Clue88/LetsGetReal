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
