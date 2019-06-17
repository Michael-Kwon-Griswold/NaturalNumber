import components.stack.Stack;
import components.stack.Stack1L;

public class NaturalNumber2 extends NaturalNumberSecondary {
    Stack<Integer> num;

    public NaturalNumber2() {
        this.num = new Stack1L<Integer>();
    }

    public NaturalNumber2(int n) {
        this.num = new Stack1L<Integer>();
        if (n != 0) {
            Integer nInt = n;
            String nString = nInt.toString();

            for (int i = 0; i < nString.length(); i++) {
                String last = Character.toString(nString.charAt(i));
                this.num.push(Integer.parseInt(last));
            }
        }
    }

    public NaturalNumber2(String s) {
        this.num = new Stack1L<Integer>();
        for (int i = 0; i < s.length(); i++) {
            String last = Character.toString(s.charAt(i));
            this.num.push(Integer.parseInt(last));
        }
    }

    @Override
    public int getVal() {
        Stack<Integer> restore = new Stack1L<Integer>();

        int length = this.num.length();
        int val = 0;
        for (int i = 0; i < length; i++) {
            Integer pop = this.num.pop();
            restore.push(pop);
            val = val + ((int) Math.pow(10, i)) * pop;
        }

        for (int i = 0; i < length; i++) {
            this.num.push(restore.pop());
        }

        return val;
    }

    @Override
    public String getString() {
        Stack<Integer> restore = new Stack1L<Integer>();

        int length = this.num.length();
        String val = "";
        for (int i = 0; i < length; i++) {
            Integer pop = this.num.pop();
            restore.push(pop);
            val = pop + val;
        }

        for (int i = 0; i < length; i++) {
            this.num.push(restore.pop());
        }

        return val;
    }

    @Override
    public int getLastDigit() {
        if (this.isZero()) {
            return 0;
        } else {
            return this.num.top();
        }
    }

    @Override
    public int getNumDigits() {
        if (this.isZero()) { // if value is zero
            return 1;
        } else {
            return this.num.length();
        }
    }

    @Override
    public void multiplyBy10(int n) {
        if (n != 0) {
            this.num.push(n);
        }
    }

    @Override
    public int divideBy10() {
        if (this.isZero()) {
            return 0;
        } else {
            return this.num.pop();
        }
    }

    @Override
    public boolean isZero() {
        return this.num.length() == 0;
    }

    @Override
    public void clear() {
        this.num.clear();
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
