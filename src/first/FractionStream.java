package first;

/**
 * @author Izabela Almeida, Giovanna Janeiro, Julia Keck, Ann-Katrin Schließus
 * */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Izabela ALmeida, Giovanna Janeiro, Julia Keck, Ann-Katrin Schließus
 */

public class FractionStream {
    public static void main(String[] args) {
        List<Fraction> fractions;
        {
            List<Fraction> tempList = new ArrayList<>();
            IntStream.range(-9, 20).forEach(nom -> IntStream.range(-9, 20).forEach(denom -> {
                if (denom == 0)
                    return;
                Fraction newFrac = new Fraction(nom, denom);
                if (!tempList.contains(newFrac))
                    tempList.add(newFrac);
            }));
            tempList.sort(Fraction::compareTo);
            fractions = tempList.stream().distinct().toList();
        }
        List<Fraction> fractionsSorted = new ArrayList<>(fractions);
        fractionsSorted.sort(Fraction::compareTo);
        List<Fraction> fractionsShuffled = new ArrayList<>(fractions);
        Collections.shuffle(fractionsShuffled);
        List<Double> asDoubleSin;
        {
            List<Double> tempList = new ArrayList<>();
            fractions.forEach(x -> tempList.add(Math.sin(x.doubleValue())));
            tempList.sort(Double::compareTo);
            asDoubleSin = tempList.stream().distinct().toList();
        }
        MyIO.writeln("Sorted and Doubled:");
        fractionsSorted.forEach(x -> MyIO.writeln(x.multiply(new Fraction(2, 1)).toString()));
        MyIO.writeln("\nSorted and Squared:");
        fractionsSorted.forEach(x -> MyIO.writeln(x.multiply(x).toString()));
        MyIO.writeln("\nShuffeled and Prime");
        fractionsShuffled.forEach(x -> {
            if (isPrime(x.numerator) && isPrime(x.denominator))
                MyIO.writeln(x.toString());
        });
        MyIO.writeln("\nIntegers sorted");
        fractionsSorted.forEach(x -> {
            if (x.isInteger())
                MyIO.writeln(x.toString());
        });
        MyIO.writeln("\nSin Values Sorted");
        asDoubleSin.forEach(x -> MyIO.writeln(x.toString()));
    }

    public static boolean isPrime(BigInteger n) {
        if (n.compareTo(new BigInteger(String.valueOf(2L))) < 0) return false;
        for (BigInteger i = n.subtract(BigInteger.ONE); i.compareTo(BigInteger.valueOf(1)) > 0; i = i.subtract(BigInteger.ONE)) {
            if (n.mod(i).compareTo(BigInteger.ZERO) == 0) {
                return false;
            }
        }
        return true;
    }
}