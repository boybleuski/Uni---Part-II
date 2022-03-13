package testing;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class TestTask2A {

    @Test // test cases
    public void testTask2AValid()
    {
    	 
    }
        /*
         * Tests to create valid positive, negative and zero outputs
         * various magnitude arrays and radix values are used to produce various outputs
         * all valid test cases outlined in Task 1 are tested
         
        byte[] magnitude1 = {64,64,64,64,64,64};
        byte[] magnitude2 = {0,0,0,0,0};
        byte[] magnitude3 = {-64,-64,-64,-64,-64,-64};
        byte[] magnitude4 = {1,2,3,4,5,6};
        byte[] magnitude5 = {-1,-2,-3,-4,-5,-6};

        //BigInteger(int signum, byte[] magnitude)
        //Equivalence Partitioning - Valid
        BigInteger ep1 = new BigInteger(1, magnitude1);
        BigInteger ep2 = new BigInteger(-1, magnitude1);
        BigInteger ep3 = new BigInteger(0, magnitude2);
        BigInteger ep4 = new BigInteger(1, magnitude3);
        BigInteger ep5 = new BigInteger(-1, magnitude3);
        BigInteger ep6 = new BigInteger(1, magnitude2);
        BigInteger ep7 = new BigInteger(-1, magnitude2);

        //Boundary Value Analysis - Valid
        BigInteger bva1 = new BigInteger(-1, magnitude4);
        BigInteger bva2 = new BigInteger(1, magnitude5);
        BigInteger bva3 = new BigInteger(0, magnitude2);
        BigInteger bva4 = new BigInteger(1, magnitude2);
        BigInteger bva5 =  new BigInteger(-1, magnitude2);

        //BigInteger(String val, int radix)
        //Equivalence Partitioning - Valid
        BigInteger ep8 = new BigInteger("4407760", 9);
        BigInteger ep9 = new BigInteger("9880260", 20);
        BigInteger ep10 = new BigInteger("7628923746920", 35);
        BigInteger ep11 = new BigInteger ("-976249020", 12);
        BigInteger ep12 = new BigInteger("-1092837401834", 30);
        BigInteger ep13 = new BigInteger("-4407760", 8);
        BigInteger ep14 = new BigInteger("0", 2);

        //Boundary Value Analysis - Valid
        BigInteger bva6 = new BigInteger("4407760", 9);
        BigInteger bva7 = new BigInteger("4407760", 36);
        BigInteger bva8 = new BigInteger("9880260", 10);
        BigInteger bva9 = new BigInteger("9880260", 36);

        //compareTo(BigInteger val)
        //Equivalence Partitioning - Valid
        BigInteger BigInt1 = new BigInteger("123456789");
        BigInteger BigInt2 = new BigInteger("123456789");
        BigInteger BigInt3 = new BigInteger("987654321");

        int compare1, compare2, compare3; //ints to store the comparison integer
        compare1 = BigInt1.compareTo(BigInt2); //output = 0
        compare2 = BigInt2.compareTo(BigInt3); //output = -1
        compare3 = BigInt3.compareTo(BigInt2); //output = 1


    }
    @Test //invalid test cases
    public void testTask2AInvalid(){
        //test the invalid partitions and boundary value analysis
        //all tests in this method are invalid tests and will trigger test failure
        byte[] magnitude1 = {64,64,64,64,64,64};
        byte[] magnitude2 = {-64,-64,-64,-64,-64,-64};
        byte[] magnitude3 = {1,1,1,1,1,};
        byte[] magnitude4 = {-1,-1,-1,-1,-1};
        //BigInteger(int signum, byte[] magnitude)
        //Equivalence Partitioning - Invalid
        BigInteger ep1 = new BigInteger(-3, magnitude1);
        BigInteger ep2 = new BigInteger(0, magnitude1);
        BigInteger ep3 = new BigInteger(3, magnitude1);
        BigInteger ep4 = new BigInteger(0, magnitude2);

        //Boundary Value Analysis - Invalid
        BigInteger bva1 = new BigInteger(-2, magnitude1);
        BigInteger bva2 = new BigInteger(2, magnitude1);
        BigInteger bva3 = new BigInteger (0, magnitude3);
        BigInteger bva4 = new BigInteger(0, magnitude4);

        //BigInteger(String val, int radix)
        //Equivalence Partitioning - Invalid
        BigInteger ep5 = new BigInteger("440 7760", 9);
        BigInteger ep6 = new BigInteger("4407760", 40);
        BigInteger ep7 = new BigInteger("4407760", -5);
        BigInteger ep8 = new BigInteger ("12345h", 9);

        //Boundary Value Analysis - Invalid
        BigInteger bva5 = new BigInteger("4407760", 2);
        BigInteger bva6 = new BigInteger("4407760", 37);
        BigInteger bva7 = new BigInteger("4407760", 1);
        BigInteger bva8 = new BigInteger("123 456", 9);

        //compareTo(BigInteger val)
        //Equivalence Partitioning - Invalid
        BigInteger BigInt1 = new BigInteger("1234 56789");
        BigInteger BigInt2 = new BigInteger("123456789");
        BigInteger BigInt3 = new BigInteger("987654321");

        int compare1, compare2, compare3;
        compare1 = BigInt1.compareTo(BigInt2);
        compare2 =  BigInt2.compareTo(BigInt1);
        compare3 = BigInt3.compareTo(BigInt1);
    }*/
}
