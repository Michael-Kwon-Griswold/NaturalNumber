
public class NaturalNumber1L extends NaturalNumberSecondary {
    private String val;

    public NaturalNumber1L() {
        this.val = "" + 0;
    }

    public NaturalNumber1L(int i) {
        this.val = "" + i;
    }

    // s must be a number, cannot initialize with useless zeroes at beginning
    public NaturalNumber1L(String s) {
        this.val = s;
    }

    //bug: only works for 0<= i <= 9
    @Override
    public void multiplyBy10(int i) {
        // if zero
        if (this.isZero()) {
            this.val = this.val.valueOf(i); // if zero, then val = i
        } else {
            this.val = this.val.concat(this.val.valueOf(i)); // if nonzero, i added to end of string
        }
    }

    @Override
    public int divideBy10() {
        if (this.val.length() == 1) {
            int remainder = Integer.parseInt(this.val);
            this.val = "0";
            return remainder;
        } else {
            String nString = this.val.substring(0, this.val.length() - 1);
            String remainder = this.val.substring(this.val.length() - 1);
            this.val = nString;
            return Integer.parseInt(remainder);
        }

    }

    @Override
    public boolean isZero() {
        return this.val.equals("0");
    }

    @Override
    public int getLastDigit() {
        return Integer.parseInt(
                this.val.substring(this.val.length() - 1, this.val.length()));
    }

    @Override
    public int getNumDigits() {
        return this.val.length();
    }

    // val must not be over Integer.MAX_VALUE
    @Override
    public int getVal() {
        return Integer.parseInt(this.val);
    }

    @Override
    public String getString() {
        return this.val;
    }

    @Override
    public void print() {
        System.out.println(this.val);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public Object newInstance() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void transferFrom(Object source) {
        // TODO Auto-generated method stub

    }

}
