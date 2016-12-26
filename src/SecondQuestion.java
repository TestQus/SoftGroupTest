import java.math.BigInteger;

public class SecondQuestion {

    public static void main(String[] args) {

        System.out.println(factorial(5));
    }

    public static String factorial(int n)
    {
        BigInteger integer = BigInteger.valueOf(1);

        for (int i = 1; i <= n; i++) {

            integer = integer.multiply(BigInteger.valueOf(i));
        }

        return integer.toString();
    }
}
