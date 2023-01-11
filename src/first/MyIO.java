package first;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Izabela Almeida, Giovanna Janeiro, Julia Keck, Ann-Katrin Schließus
 * */

public class MyIO {

    private MyIO() {}

    static Scanner scanner = new Scanner(System.in);

    public static String promptAndRead(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static byte readByte(String prompt) {
        while (true) {
            try {
                return Byte.parseByte(promptAndRead(prompt));
            }
            catch (Exception e) {
                writeln("error ... try again");
            }
        }
    }

    public static short readShort(String prompt) {
        while (true) {
            try {
                return Short.parseShort(promptAndRead(prompt));
            }
            catch (Exception e) {
                writeln("error ... try again");
            }
        }
    }

    public static int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(promptAndRead(prompt));
            }
            catch (Exception e) {
                writeln("error ... try again");
            }
        }
    }

    public static long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(promptAndRead(prompt));
            }
            catch (Exception e) {
                writeln("error ... try again");
            }
        }
    }

    public static BigInteger readBigInt(String prompt) {
        while (true) {
            try {
                return new BigInteger(promptAndRead(prompt));
            }
            catch (Exception e) {
                writeln("error ... try again");
            }
        }
    }

    public static float readFloat(String prompt) {
        while (true) {
            try {
                return Float.parseFloat(promptAndRead(prompt));
            }
            catch (Exception e) {
                writeln("error ... try again");
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(promptAndRead(prompt));
            }
            catch (Exception e) {
                writeln("error ... try again");
            }
        }
    }

    public static BigDecimal readBigDecimal(String prompt) {
        while (true) {
            try {
                return new BigDecimal(promptAndRead(prompt));
            }
            catch (Exception e) {
                writeln("error ... try again");
            }
        }
    }

    public static Fraction readFraction(String prompt) {
        while (true) {
            try {
                return new Fraction(promptAndRead(prompt));
            }
            catch (Exception e) {
                writeln("error ... try again");
            }
        }
    }

    public static void write(String s) {
        System.out.print(s);
    }

    public static void writeln(String s) {
        System.out.println(s);
    }
}
