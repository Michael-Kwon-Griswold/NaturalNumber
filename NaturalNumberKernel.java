import components.standard.Standard;

public interface NaturalNumberKernel extends Standard {
    void multiplyBy10(int n);

    int divideBy10();

    boolean isZero();
}
