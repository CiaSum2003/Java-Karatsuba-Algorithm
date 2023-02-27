import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;
import java.util.Scanner;

public class Multiplication {
    private long x;
    private long y;
    private long result;

    public Multiplication(int digits) {
        int size = Size(digits);
        this.x = RandomNumber(size);
        this.y = RandomNumber(size);
        this.result = Karatsuba(x,y);
    }

    public static int Size(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Number of digits must be positive");
        }
        return n;
    }

    public static long RandomNumber(int n) {
        long min = (long) Math.pow(10, n - 1);
        return ThreadLocalRandom.current().nextLong(min, min * 10);
    }
    public long Karatsuba(long x, long y){
        if (x < 10 || y < 10) {
            return x * y;
        }
    
        String xStr = Long.toString(x);
        String yStr = Long.toString(y);
        int n = Math.max(xStr.length(), yStr.length());
        int mid = (n + 1) / 2;
    
        long a = x / (long) Math.pow(10, mid);
        long b = x % (long) Math.pow(10, mid);
        long c = y / (long) Math.pow(10, mid);
        long d = y % (long) Math.pow(10, mid);
    
        long ac = Karatsuba(a, c);
        long bd = Karatsuba(b, d);
        long acbd = Karatsuba(a+b,c+d) - ac - bd;
    
        long tenToN = (long) Math.pow(10, 2*mid);
        long tenToNOver2 = (long) Math.pow(10, mid);
    
        long result = tenToN * ac + tenToNOver2 * acbd + bd;
    
        return result;
      }
    

    public String toString() {
        return "The numbers the computer chose are " + x + " and " + y + ". The result is  " + result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of digits: ");
        int digits = in.nextInt();
        in.close();

        Multiplication multiplication = new Multiplication(digits);
        System.out.println(multiplication);
    }
}
