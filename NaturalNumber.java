
public interface NaturalNumber extends NaturalNumberKernel {
    int compareNN(NaturalNumber n1, NaturalNumber n2);

    int getVal();

    String getString();

    void add(NaturalNumber n);

    boolean canConvertToInt();

    boolean canSetFromString(String s);

    void copyFrom(NaturalNumber n);

    void decrement();

    NaturalNumber divide(NaturalNumber n);

    void increment();

    void multiply(NaturalNumber n);

    void power(int p);

    void root(int r);

    void setFromInt(int i);

    void setFromString(String s);

    void subtract(NaturalNumber n);

    int toInt();

    int getLastDigit();

    int getNumDigits();

    void print();

}
