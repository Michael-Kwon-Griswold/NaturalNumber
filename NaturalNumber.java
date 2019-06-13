
public interface NaturalNumber extends NaturalNumberKernel {
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

    void print();

}