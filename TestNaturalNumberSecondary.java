import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestNaturalNumberSecondary {

    @Test
    public void testCanConvertToInt() {
        NaturalNumber n = new NaturalNumber1L(5);
        assertTrue(n.canConvertToInt());
    }

    @Test
    public void testCanConvertToInt_2() {
        NaturalNumber n = new NaturalNumber1L();
        assertTrue(n.canConvertToInt());
    }

    @Test
    public void testCanConvertToInt_3() {
        NaturalNumber n = new NaturalNumber1L(Integer.MAX_VALUE);
        assertTrue(n.canConvertToInt());
    }

    @Test
    public void testCanConvertToInt_4() {
        NaturalNumber n = new NaturalNumber1L("23423237428934");
        assertEquals(false, n.canConvertToInt());
    }

    @Test
    public void testIsZero() {
        NaturalNumber n = new NaturalNumber1L();
        assertTrue(n.isZero());
    }

    @Test
    public void testIsZero2() {
        NaturalNumber n = new NaturalNumber1L(0);
        assertTrue(n.isZero());
    }

    @Test
    public void testIsZero3() {
        NaturalNumber n = new NaturalNumber1L(23);
        assertTrue(!n.isZero());
    }

    @Test
    public void testIsZero4() {
        NaturalNumber n = new NaturalNumber1L(Integer.MAX_VALUE);
        assertTrue(!n.isZero());
    }

    @Test
    public void testEmptyConstructor() {
        NaturalNumber n = new NaturalNumber1L();
        assertEquals(0, n.getVal());
    }

    @Test
    public void testIntConstructor() {
        int val = 3;
        NaturalNumber n = new NaturalNumber1L(val);
        assertEquals(val, n.getVal());
    }

    @Test
    public void testIntConstructor2() {
        int val = 234;
        NaturalNumber n = new NaturalNumber1L(val);
        assertEquals(val, n.getVal());
    }

    @Test
    public void testIntConstructor3() {
        int val = Integer.MAX_VALUE;
        NaturalNumber n = new NaturalNumber1L(val);
        assertEquals(val, n.getVal());
    }

    @Test
    public void testIntConstructor4() {
        int val = 2343245;
        NaturalNumber n = new NaturalNumber1L(val);
        assertEquals(val, n.getVal());
    }

    @Test
    public void testIntConstructor5() {
        int val = 253;
        NaturalNumber n = new NaturalNumber1L(val);
        assertEquals(val, n.getVal());
    }

    @Test
    public void testMultiplyBy10() {
        NaturalNumber n = new NaturalNumber1L();
        n.multiplyBy10(0);
        assertTrue(n.isZero());
    }

    @Test
    public void testMultiplyBy10_2() {
        NaturalNumber n = new NaturalNumber1L();
        n.multiplyBy10(3);
        assertEquals(3, n.getVal());
    }

    @Test
    public void testMultiplyBy10_3() {
        NaturalNumber n = new NaturalNumber1L();
        n.multiplyBy10(13);
        assertEquals(13, n.getVal());
    }

    @Test
    public void testMultiplyBy10_4() {
        NaturalNumber n = new NaturalNumber1L(3);
        n.multiplyBy10(3);
        assertEquals(33, n.getVal());
    }

    @Test
    public void testMultiplyBy10_5() {
        NaturalNumber n = new NaturalNumber1L(234);
        n.multiplyBy10(5);
        assertEquals(2345, n.getVal());
    }

    @Test
    public void testMultiplyBy10_6() {
        NaturalNumber n = new NaturalNumber1L(Integer.MAX_VALUE);
        n.multiplyBy10(3);
        NaturalNumber expected = new NaturalNumber1L("21474836473");
        n.print();
        expected.print();
    }

    @Test
    public void testDivideBy10() {
        NaturalNumber n = new NaturalNumber1L();
        int remainder = n.divideBy10();
        assertEquals(0, remainder);
        assertEquals(0, n.getVal());
    }

    @Test
    public void testDivideBy10_2() {
        NaturalNumber n = new NaturalNumber1L(23);
        int remainder = n.divideBy10();
        assertEquals(3, remainder);
        assertEquals(2, n.getVal());
    }

    @Test
    public void testDivideBy10_3() {
        NaturalNumber n = new NaturalNumber1L(6);
        int remainder = n.divideBy10();
        assertEquals(6, remainder);
        assertEquals(0, n.getVal());
    }

    @Test
    public void testDivideBy10_4() {
        NaturalNumber n = new NaturalNumber1L(Integer.MAX_VALUE);
        int remainder = n.divideBy10();
        assertEquals(7, remainder);
        assertEquals(214748364, n.getVal());
    }

    @Test
    public void testStringConstructor() {
        NaturalNumber n = new NaturalNumber1L("34");
        assertEquals(34, n.getVal());
    }

    @Test
    public void testCanSetFromString() {
        NaturalNumber n = new NaturalNumber1L();
        assertEquals(true, n.canSetFromString("0"));
    }

    @Test
    public void testCanSetFromString_2() {
        NaturalNumber n = new NaturalNumber1L();
        assertTrue(n.canSetFromString("1234124"));
    }

    @Test
    public void testCanSetFromString_3() {
        NaturalNumber n = new NaturalNumber1L();
        assertTrue(n.canSetFromString("123932548325"));
    }

    @Test
    public void testCanSetFromString_4() {
        NaturalNumber n = new NaturalNumber1L();
        assertEquals(false, n.canSetFromString("-123324823"));
    }

    @Test
    public void testCanSetFromString_5() {
        NaturalNumber n = new NaturalNumber1L();
        assertEquals(true, n.canSetFromString("0"));
    }

    @Test
    public void testCanSetFromString_6() {
        NaturalNumber n = new NaturalNumber1L();
        assertEquals(false, n.canSetFromString("00003"));
    }

    @Test
    public void testCanSetFromString_7() {
        NaturalNumber n = new NaturalNumber1L();
        assertEquals(false, n.canSetFromString("sdfsd343234"));
    }

    @Test
    public void testCanSetFromString_8() {
        NaturalNumber n = new NaturalNumber1L();
        assertEquals(false, n.canSetFromString(""));
    }

    @Test
    public void testCanSetFromString_9() {
        NaturalNumber n = new NaturalNumber1L();
        assertEquals(false, n.canSetFromString("     "));
    }

    @Test
    public void testCanSetFromString_10() {
        NaturalNumber n = new NaturalNumber1L();
        assertEquals(false, n.canSetFromString("sdfjksldjf"));
    }

    @Test
    public void testCopyFrom() {
        NaturalNumber n = new NaturalNumber1L();
        NaturalNumber copy = new NaturalNumber1L();
        copy.copyFrom(n);
        assertEquals(n.getVal(), copy.getVal());
    }

    @Test
    public void testCopyFrom_2() {
        NaturalNumber n = new NaturalNumber1L(12353);
        NaturalNumber copy = new NaturalNumber1L();
        copy.copyFrom(n);
        assertEquals(n.getVal(), copy.getVal());
    }

    @Test
    public void testCopyFrom_3() {
        NaturalNumber n = new NaturalNumber1L("23234");
        NaturalNumber copy = new NaturalNumber1L();
        copy.copyFrom(n);
        assertEquals(n.getVal(), copy.getVal());
    }

    @Test
    public void testCopyFrom_4() {
        NaturalNumber n = new NaturalNumber1L("23432904823423");
        NaturalNumber copy = new NaturalNumber1L();
        copy.copyFrom(n);
        assertEquals(n.getString(), copy.getString());
    }

    @Test
    public void testCopyFrom_5() {
        NaturalNumber n = new NaturalNumber1L("8");
        NaturalNumber copy = new NaturalNumber1L();
        copy.copyFrom(n);
        assertEquals(n.getVal(), copy.getVal());
    }

    @Test
    public void testCopyFrom_6() {
        NaturalNumber n = new NaturalNumber1L(27);
        NaturalNumber copy = new NaturalNumber1L(3);
        copy.copyFrom(n);

        NaturalNumber expected = new NaturalNumber1L(27);
        assertEquals(expected.getVal(), copy.getVal());
    }

    @Test
    public void testDecrement() {
        NaturalNumber n = new NaturalNumber1L(15);
        NaturalNumber expected = new NaturalNumber1L(14);
        n.decrement();
        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testDecrement2() {
        NaturalNumber n = new NaturalNumber1L(1);
        NaturalNumber expected = new NaturalNumber1L();
        n.decrement();
        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testIncrement() {
        NaturalNumber n = new NaturalNumber1L(1);
        NaturalNumber expected = new NaturalNumber1L(2);
        n.increment();
        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testIncrement_2() {
        NaturalNumber n = new NaturalNumber1L(Integer.MAX_VALUE);
        NaturalNumber expected = new NaturalNumber1L("2147483648");
        n.increment();
        assertEquals(expected.getString(), n.getString());
    }

    @Test
    public void testDivide() {
        NaturalNumber n = new NaturalNumber1L(34);
        NaturalNumber three = new NaturalNumber1L(3);
        NaturalNumber expected = new NaturalNumber1L(11);
        NaturalNumber exp_rem = new NaturalNumber1L(1);
        NaturalNumber rem = n.divide(three);

        assertEquals(expected.getVal(), n.getVal());
        assertEquals(exp_rem.getVal(), rem.getVal());
    }

    @Test
    public void testDivide_2() {
        NaturalNumber n = new NaturalNumber1L(44);
        NaturalNumber four = new NaturalNumber1L(4);
        NaturalNumber expected = new NaturalNumber1L(11);
        NaturalNumber exp_rem = new NaturalNumber1L(0);
        NaturalNumber rem = n.divide(four);

        assertEquals(expected.getVal(), n.getVal());
        assertEquals(exp_rem.getVal(), rem.getVal());
    }

    @Test
    public void testDivide_3() {
        NaturalNumber n = new NaturalNumber1L(0);
        NaturalNumber three = new NaturalNumber1L(3);
        NaturalNumber expected = new NaturalNumber1L(0);
        NaturalNumber exp_rem = new NaturalNumber1L(0);
        NaturalNumber rem = n.divide(three);

        assertEquals(expected.getVal(), n.getVal());
        assertEquals(exp_rem.getVal(), rem.getVal());
    }

    @Test
    public void testDivide_5() {
        NaturalNumber n = new NaturalNumber1L(11);
        NaturalNumber three = new NaturalNumber1L(3);
        NaturalNumber expected = new NaturalNumber1L(3);
        NaturalNumber exp_rem = new NaturalNumber1L(2);
        NaturalNumber rem = n.divide(three);

        assertEquals(expected.getVal(), n.getVal());
        assertEquals(exp_rem.getVal(), rem.getVal());
    }

    @Test
    public void testSetFromInt() {
        NaturalNumber n = new NaturalNumber1L(3);
        n.setFromInt(81);
        NaturalNumber expected = new NaturalNumber1L(81);
        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testSetFromInt_2() {
        NaturalNumber n = new NaturalNumber1L(3);
        n.setFromInt(811);
        NaturalNumber expected = new NaturalNumber1L(811);
        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testSetFromInt_3() {
        NaturalNumber n = new NaturalNumber1L(0);
        n.setFromInt(100000);
        NaturalNumber expected = new NaturalNumber1L(100000);
        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testSetFromInt_4() {
        NaturalNumber n = new NaturalNumber1L(0);
        n.setFromInt(3);
        NaturalNumber expected = new NaturalNumber1L(3);
        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testMultiply() {
        NaturalNumber n = new NaturalNumber1L(3);
        NaturalNumber six = new NaturalNumber1L(6);
        n.multiply(six);

        NaturalNumber expected = new NaturalNumber1L(18);
        NaturalNumber six_expected = new NaturalNumber1L(6);
        assertEquals(expected.getVal(), n.getVal());
        assertEquals(six_expected.getVal(), six.getVal());
    }

    @Test
    public void testMultiply_2() {
        NaturalNumber n = new NaturalNumber1L();
        NaturalNumber six = new NaturalNumber1L(6);

        n.multiply(six);
        NaturalNumber expected = new NaturalNumber1L();
        NaturalNumber six_expected = new NaturalNumber1L(6);
        assertEquals(expected.getVal(), n.getVal());
        assertEquals(six_expected.getVal(), six.getVal());
    }

    @Test
    public void testPower() {
        NaturalNumber n = new NaturalNumber1L(3);
        n.power(2);
        NaturalNumber expected = new NaturalNumber1L(9);

        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testPower_2() {
        NaturalNumber n = new NaturalNumber1L(3);
        n.power(0);
        NaturalNumber expected = new NaturalNumber1L(1);

        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testRoot() {
        NaturalNumber n = new NaturalNumber1L(9);
        n.root(2);
        NaturalNumber expected = new NaturalNumber1L(3);

        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testRoot_2() {
        NaturalNumber n = new NaturalNumber1L(10);
        n.root(2);
        NaturalNumber expected = new NaturalNumber1L(3);

        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testRoot_3() {
        NaturalNumber n = new NaturalNumber1L(8);
        n.root(3);
        NaturalNumber expected = new NaturalNumber1L(2);

        assertEquals(expected.getVal(), n.getVal());
    }

    @Test
    public void testRoot_4() {
        NaturalNumber n = new NaturalNumber1L(0);
        n.root(3);
        NaturalNumber expected = new NaturalNumber1L(0);

        assertEquals(expected.getVal(), n.getVal());
    }

}
