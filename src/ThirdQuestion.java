import java.math.BigInteger;

public class ThirdQuestion {
    public static void main(String[] args) {
        //one
        int i = 1;
        while (i <= 99)
        {
            System.out.println(i);
            i+=2;
        }

        System.out.println();

        //two
        System.out.println(factorial(5));
    }


    public static String factorial(int n)
    {
        BigInteger integer = BigInteger.valueOf(1);

        int i = 1;
        while(i <= n) {
            integer = integer.multiply(BigInteger.valueOf(i++));
        }

        return integer.toString();
    }
}
