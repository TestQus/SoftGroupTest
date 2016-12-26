
public class FourthQuestion {


    public static void main(String[] args) {
        int[] a = new int[50];

        int b = 0;
        for (int i = 1; i <= 99; i+=2) {
            a[b++] = i;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
    }
}
