import components.stack.Stack;
import components.stack.Stack1L;

public abstract class NaturalNumberSecondary implements NaturalNumber {

    @Override
    public int compareNN(NaturalNumber n1, NaturalNumber n2) {
        String sN1 = n1.getString();
        String sN2 = n2.getString();

        if (sN1.length() > sN2.length()) {
            return 1;
        } else if (sN2.length() > sN1.length()) {
            return -1;
        } else { // strings are same length
            for (int i = 0; i < sN1.length(); i++) {
                int compN1 = Integer
                        .parseInt(Character.toString(sN1.charAt(i))); // num_i of n1
                int compN2 = Integer
                        .parseInt(Character.toString(sN2.charAt(i))); // num_i of n2
                if (compN1 > compN2) {
                    return 1;
                } else if (compN2 > compN1) {
                    return -1;
                }
            }
        }
        return 0; // strings are exactly the same
    }

    @Override
    public void add(NaturalNumber n) {
        //get num digits of bigger number
        int comp = this.compareNN(this, n);
        int numDigitsOfLarger;
        String sum = "";

        if (comp >= 0) {
            numDigitsOfLarger = this.getNumDigits();
        } else {
            numDigitsOfLarger = n.getNumDigits();
        }
        int carry = 0;

        // make copies to destroy
        NaturalNumber thisCopy = new NaturalNumber2();
        thisCopy.copyFrom(this);

        NaturalNumber nCopy = new NaturalNumber2();
        nCopy.copyFrom(n);

        //loop counters, conditions
        boolean cont = true;
        int i = 0;

        while (cont) {
            int thisLast;
            int nLast;

            thisLast = thisCopy.divideBy10();
            nLast = nCopy.divideBy10();

            if (carry == 1) {
                thisLast++;
            }
            carry = 0;

            while (true) {
                int smallSum = thisLast + nLast;

                if (smallSum >= 10) {
                    sum = String.valueOf(smallSum % 10) + sum;
                    carry = 1;
                    break;
                } else {
                    sum = String.valueOf(smallSum) + sum;
                    break;
                }
            }
            i++;
            cont = (i < numDigitsOfLarger) || (carry == 1);
        }

        this.copyFrom(new NaturalNumber2(sum));
    }

    @Override
    public boolean canConvertToInt() {
        if (this.isZero()) {
            return true;
        }
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
        String restore = n.getString();

        //destroy this
        this.clear();

        // copy n
        while (!n.isZero()) {
            int lastDigit = n.divideBy10();
            if (lastDigit == 0) {
                reverseRestore.concatZero();
                reverseCopy.concatZero();
            } else {
                reverseRestore.multiplyBy10(lastDigit);
                reverseCopy.multiplyBy10(lastDigit);
            }
        }

        //use
        while (!reverseCopy.isZero()) {
            int lastDigit = reverseCopy.divideBy10();
            if (lastDigit == 0) {
                this.concatZero();
            } else {
                this.multiplyBy10(lastDigit);
            }
        }

        // restore n
        while (!reverseRestore.isZero()) {
            int lastDigit = reverseRestore.divideBy10();
            if (lastDigit == 0) {
                n.concatZero();
            } else {
                n.multiplyBy10(lastDigit);
            }
        }
    }

    @Override
    public void decrement() {
        this.subtract(new NaturalNumber2(1));
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

    @Override
    public void increment() {
        this.add(new NaturalNumber2(1));
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

    @Override
    public void root(int r) {
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
        this.setFromString(String.valueOf(i));
    }

    @Override
    public void setFromString(String s) {
        this.copyFrom(new NaturalNumber1L(s));
    }

    @Override
    public void subtract(NaturalNumber n) {
        //get num digits of bigger number
        int comp = this.compareNN(this, n);
        int numDigitsOfLarger;
        String diff = "";

        if (comp >= 0) {
            numDigitsOfLarger = this.getNumDigits();
        } else {
            numDigitsOfLarger = n.getNumDigits();
        }
        int owed = 0;

        // make copies to destroy
        NaturalNumber thisCopy = new NaturalNumber2();
        thisCopy.copyFrom(this);

        NaturalNumber nCopy = new NaturalNumber2();
        nCopy.copyFrom(n);

        //loop counters, conditions
        boolean cont = true;
        int i = 0;

        while (cont) {
            int thisLast;
            int nLast;

            thisLast = thisCopy.divideBy10();
            nLast = nCopy.divideBy10();

            if (owed == 1) {
                thisLast--;
            }
            owed = 0;

            while (true) {
                int smallDiff = thisLast - nLast;

                if (smallDiff < 0) {
                    diff = String.valueOf(10 + smallDiff) + diff;
                    owed = 1;
                    break;
                } else {
                    diff = String.valueOf(smallDiff) + diff;
                    break;
                }
            }
            i++;
            cont = (i < numDigitsOfLarger) || (owed == 1);
        }

        this.copyFrom(new NaturalNumber2(diff));
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
