package first;

/**
 * @author Izabela Almeida, Giovanna Janeiro, Julia Keck, Ann-Katrin Schließus
 * */

import java.math.BigInteger;
import java.util.Objects;

/**
<<<<<<< HEAD
 * @author Giovanna Janeiro, Ann-Katrin SChließus, Julia Keck, Izabela Almeida;
=======
 * @author Nico Vogel
>>>>>>> f8ac0d7 (Fraction eingefügt)
 * @version 1.0
 */

public class Fraction extends Number implements Comparable<Fraction> {
    public static Fraction ZERO = new Fraction(0, 1);
    public final BigInteger numerator;
    public final BigInteger denominator;

    private static BigInteger ggT(BigInteger x, BigInteger y) {
        return Objects.equals(y, BigInteger.ZERO) ? x : ggT(y, x.mod(y));
    }

    public Fraction(BigInteger numerator, BigInteger denominator) {
        if (denominator.compareTo(BigInteger.ZERO) == 0)
            throw new IllegalArgumentException("Denominator can't be 0");
        if (denominator.compareTo(BigInteger.ZERO) < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }
        BigInteger ggt = ggT(numerator, denominator);
        this.numerator = numerator.divide(ggt);
        this.denominator = denominator.divide(ggt);
    }

    public Fraction(long numerator, long denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    public Fraction(String numerator, String denominator) throws NumberFormatException {
        this(new BigInteger(numerator), new BigInteger(denominator));
    }

    public Fraction(String fraction) {
        String[] strings = fraction.split("/");
        if (strings.length != 2)
            throw new IllegalArgumentException("Fraction is in a wrong format");
        BigInteger numerator = new BigInteger(strings[0]);
        BigInteger denominator = new BigInteger(strings[1]);
        BigInteger ggt = ggT(numerator, denominator);
        this.numerator = numerator.divide(ggt);
        this.denominator = denominator.divide(ggt);
    }

    public Fraction add(Fraction r) {
        BigInteger n1, n2, d;
        n1 = numerator.multiply(r.denominator);
        n2 = r.numerator.multiply(denominator);
        d = denominator.multiply(r.denominator);
        return new Fraction(n1.add(n2), d);
    }

    public Fraction subtract(Fraction r) {
        BigInteger n1, n2, d;
        n1 = numerator.multiply(r.denominator);
        n2 = r.numerator.multiply(denominator);
        d = denominator.multiply(r.denominator);
        return new Fraction(n1.subtract(n2), d);
    }

    public Fraction multiply(Fraction r) {
        return new Fraction(numerator.multiply(r.numerator), denominator.multiply(r.denominator));
    }

    public Fraction divide(Fraction r) {
        return new Fraction(numerator.multiply(r.denominator), denominator.multiply(r.numerator));
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public boolean isInteger() {
        return denominator.compareTo(BigInteger.ONE) == 0;
    }

    @Override
    public int compareTo(Fraction r) {
        BigInteger n1, n2;
        n1 = numerator.multiply(r.denominator);
        n2 = r.numerator.multiply(denominator);
        return n1.compareTo(n2);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Fraction && equals((Fraction) obj);
    }

    public boolean equals(Fraction obj) {
        return numerator.equals(obj.numerator) && denominator.equals(obj.denominator);
    }

    @Override
    public int intValue() {
        return numerator.divide(denominator).intValue();
    }

    @Override
    public long longValue() {
        return numerator.divide(denominator).longValue();
    }

    @Override
    public float floatValue() {
        return numerator.floatValue() / denominator.floatValue();
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }
}
