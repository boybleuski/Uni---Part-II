
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestTask2
{
    private static BigInteger zero;
    private static BigInteger one;
    private static BigInteger ten;
    private static BigInteger negative;
    private static BigInteger min;
    private static BigInteger max;
    private static BigInteger oneWord;
    private static BigInteger twoWords;
    private static BigInteger negOneWord;

    public static void main(String[] args) {
        zero = BigInteger.ZERO;
        one = BigInteger.ONE;
        ten = BigInteger.TEN;
        negative = BigInteger.valueOf(-1L);
        min = BigInteger.valueOf(Integer.MIN_VALUE);
        max = BigInteger.valueOf(Integer.MAX_VALUE);
        //creates a BigInteger that is one greater than max value so that (words != null)
        oneWord = BigInteger.valueOf((long) Integer.MAX_VALUE + 1);
        //creates a BigInteger that is 2 times max value + 1 so that (words != null) and ival > 1
        twoWords = BigInteger.valueOf((long) Integer.MAX_VALUE * 2 + 1);
        //creates a BigInteger that is 1 less than min value, so that (words != null) and isNegative()
        negOneWord = BigInteger.valueOf((long) Integer.MIN_VALUE - 1);
    }

        @Test
        public void statementGCD(){
            assertEquals(zero, zero.gcd(zero));          // t1
            assertEquals(one, negative.gcd(negative));   // t2
            assertEquals(one, min.gcd(zero));            // t3
            assertEquals(one, oneWord.gcd(zero));        // t4
            assertEquals(one, oneWord.gcd(oneWord));     // t5
        }

        @Test
        public void decisionGCD() {
            assertEquals(zero, zero.gcd(zero));          // t1
            assertEquals(one, negative.gcd(negative));   // t2
            assertEquals(one, one.gcd(one));             // t3
            assertEquals(one, oneWord.gcd(zero));        // t4
            assertEquals(one, oneWord.gcd(oneWord));     // t5
        }

        @Test
        public void conditionGCD() {
            assertEquals(one, zero.gcd(zero));             // t1
            assertEquals(one, negative.gcd(negative));             // t2
            assertEquals(one, one.gcd(one));         // t3
            assertEquals(one, negative.gcd(oneWord));   // t4
            assertEquals(min.abs(), min.gcd(zero));   // t5
            assertEquals(min.abs(), negOneWord.gcd(negOneWord));   // t6
            assertEquals(min.abs(), negOneWord.gcd(min));   // t7
        }

        @Test
        public void statementModInverse(){
            assertThrows(ArithmeticException.class, () -> zero.modInverse(negative)); //t1
            assertEquals(zero, zero.modInverse(one));           // t2
            assertEquals(one, one.modInverse(ten));             // t3
            assertEquals(one, zero.modInverse(ten));            // t4
            assertEquals(one, negative.modInverse(ten);         // t5
            assertEquals(one, twoWords.modInverse(oneWord);     // t6
            assertEquals(max, negative.modInverse(oneWord));    // t7
        }

        @Test
        public void decisionModInverse(){
            assertThrows(ArithmeticException.class, () -> zero.modInverse(negative)); //t1
            assertEquals(zero, zero.modInverse(one));           // t2
            assertEquals(one, one.modInverse(ten));             // t3
            assertEquals(one, zero.modInverse(ten));            // t4
            assertEquals(one, negative.modInverse(ten);         // t5
            assertEquals(one, twoWords.modInverse(oneWord);     // t6
            assertEquals(max, negative.modInverse(oneWord);     // t7
        }

        @Test
        public void conditionModInverse(){
            assertThrows(ArithmeticException.class, () -> zero.modInverse(negative)); // t1
            assertThrows(ArithmeticException.class, () -> zero.modInverse(zero));     // t2
            assertEquals(zero, zero.modInverse(one));       // t3
            assertEquals(one, one.modInverse(ten));         // t4
            assertEquals(one, negOneWord.modInverse(ten));  // t5
            assertEquals(one, zero.modInverse(ten);         // t6
            assertEquals(one, negative.modInverse(ten));    // t7
            assertEquals(one, twoWords.modInverse(oneWord));    // t8
            assertEquals(max, negative.modInverse(oneWord));    // t9
            assertEquals(one, one.modInverse(oneWord));         // t10
            assertEquals(max, negOneWord.modInverse(oneWord));    // t11
        }

        @Test
        public void statementCompareTo(){
            assertEquals(-1, zero.compareTo(one));              // t1
            assertEquals(-1, negOneWord.compareTo(oneWord));    // t2
            assertEquals(1, negOneWord.compareTo(negative));    // t3
            assertEquals(1, oneWord.compareTo(oneWord));        // t4
        }

        @Test
        public void decisionCompareTo(){
            assertEquals(-1, zero.compareTo(one));              // t1
            assertEquals(1, zero.compareTo(negative));          // t2
            assertEquals(0, zero.compareTo(zero));              // t3
            assertEquals(-1, negOneWord.compareTo(one));        // t4
            assertEquals(1, one.compareTo(negOneWord));         // t5
            assertEquals(1, twoWords.compareTo(oneWord));       // t6
            assertEquals(-1, oneWord.compareTo(twoWords));      // t7
            assertEquals(1, oneWord.compareTo(oneWord));        // t8
        }

        @Test
        public void conditionCompareTo(){
            assertEquals(-1, zero.compareTo(one));             // t1
            assertEquals(1, zero.compareTo(negative));         // t2
            assertEquals(0, zero.compareTo(zero));             // t3
            assertEquals(-1, negOneWord.compareTo(one));       // t4
            assertEquals(1, one.compareTo(negOneWord));        // t5
            assertEquals(1, twoWords.compareTo(oneWord));      // t6
            assertEquals(-1, oneWord.compareTo(twoWords));     // t7
            assertEquals(0, oneWord.compareTo(oneWord));       // t8
        }
}