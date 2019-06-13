import components.stack.Stack;
import components.stack.Stack1L;

public abstract class NaturalNumberSecondary implements NaturalNumber {
    // bugs, no carryover

    // 1234     34
    // 340
    // 123434
    @Override
    public void add(NaturalNumber n) {
        n.multiplyBy10(0);
        this.multiplyBy10(n.toInt());
        this.divideBy10();
    }

    @Override
    public boolean canConvertToInt() {
        Stack<Integer> nn = new Stack1L<Integer>();
        Stack<Integer> copy = new Stack1L<Integer>();
        int firstLastDigit = this.divideBy10();
        int lastDigit = firstLastDigit;
        while (!this.isZero()) {
            nn.push(lastDigit);
            copy.push(lastDigit);
            lastDigit = this.divideBy10();
        }

        // restore NaturalNumber

        for (int i = 0; i < nn.length(); i++) {
            this.multiplyBy10(copy.pop());
        }

        if (nn.length() < 10) { // if contains less digits than max int
            return true;
        } else if (nn.length() > 10) { // if more digits
            return false;
        } else if (firstLastDigit < 7) { // last digit of maxval
            return true;
        } else { // > 7
            return false;
        }
    }

    @Override
    public boolean canSetFromString(String s) {
        if (s.isEmpty()) {
            return false;
        }
        boolean isNegative = s.charAt(0) == '-';
        boolean containsUnnecessaryZeroes = false;
        boolean allNumbers = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.length() != 1) {
                containsUnnecessaryZeroes = true;
            }
            if (!Character.isDigit(s.charAt(i))) {
                allNumbers = false;
            }
        }
        return (!isNegative && !containsUnnecessaryZeroes && allNumbers);
    }

    @Override
    public void copyFrom(NaturalNumber n) {
        NaturalNumber reverseRestore = new NaturalNumber1L();
        NaturalNumber reverseCopy = new NaturalNumber1L();

        //destroy this
        while (!this.isZero()) {
            this.divideBy10();
        }

        // copy n
        while (!n.isZero()) {
            int lastDigit = n.divideBy10();
            reverseRestore.multiplyBy10(lastDigit);
            reverseCopy.multiplyBy10(lastDigit);
        }

        //use
        while (!reverseCopy.isZero()) {
            int lastDigit = reverseCopy.divideBy10();
            this.multiplyBy10(lastDigit);
        }

        // restore n
        while (!reverseRestore.isZero()) {
            int lastDigit = reverseRestore.divideBy10();
            n.multiplyBy10(lastDigit);
        }
    }

    // TODO works for carryover?
    @Override
    public void decrement() {
        int lastDigit = this.divideBy10();
        this.multiplyBy10(lastDigit - 1);
    }

    @Override
    public NaturalNumber divide(NaturalNumber n) {
        if (n.isZero()) {
            return this; // can't divide by zero
        }

        int result = this.getVal() / n.getVal();
        int remainder = this.getVal() % n.getVal();
        this.setFromInt(result);
        return new NaturalNumber1L(remainder);
    }

    //TODO works for carryover?
    @Override
    public void increment() {
        int lastDigit = this.divideBy10();
        this.multiplyBy10(lastDigit + 1);
    }

    @Override
    public void multiply(NaturalNumber n) {
        int result = this.getVal() * n.getVal();
        this.setFromInt(result);
    }

    @Override
    public void power(int p) {
        if (p == 0) {
            this.copyFrom(new NaturalNumber1L(1));
        } else {
            NaturalNumber thisval = new NaturalNumber1L();
            thisval.copyFrom(this);
            for (int i = 1; i <= p - 1; i++) { // since already starts out with this^1
                this.multiply(thisval);
            }
        }
    }

    // this = 9
    // root = 2

    @Override
    public void root(int r) {
        // approximate roots using incrementing loop, to inf?
        // case: exact match - return value
        // otherwise: last one must be lower. This one must be higher. Choose last one
        int i = 0;
        int lastGuess = 0;
        int thisGuess = 0;
        while (true) {
            lastGuess = thisGuess;
            thisGuess = (int) Math.pow(i, r);
            if (thisGuess == this.getVal()) {
                break;
            } else if (lastGuess < this.getVal() && thisGuess > this.getVal()) {
                i--; // choose smaller of two
                break;
            }
            i++;
        }
        this.copyFrom(new NaturalNumber1L(i));
    }

    @Override
    public void setFromInt(int i) {
        int tens = i / 10;
        int remainder = i % 10;

        while (!this.isZero()) {
            this.divideBy10();
        }

        if (tens != 0) {
            this.multiplyBy10(1); // this val = 1
            this.setFromInt(tens);
        }
        this.multiplyBy10(remainder);
    }

    @Override
    public void setFromString(String s) {
        // construct nn
        NaturalNumber set = new NaturalNumber1L(s);
        this.copyFrom(set);
    }

    // 1242352
    // 124235 2

    @Override
    public void subtract(NaturalNumber n) {
    }

    @Override
    public int toInt() {
        return this.getVal();
    }

    @Override
    public void print() {
        System.out.println(this.getString());
    }

}
