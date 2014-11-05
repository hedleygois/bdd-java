import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class Calculator {
    private final Deque<Number> stack = new LinkedList<Number>();
    private static final List<String> OPS = asList("-", "+", "*", "/");

    public void push(Object elemento) {
        if (OPS.contains(elemento)) {
            Number y = stack.removeLast();
            Number x = stack.isEmpty() ? 0 : stack.removeLast();
            Double val = null;
            if (elemento.equals("-")) {
                val = x.doubleValue() - y.doubleValue();
            } else if (elemento.equals("+")) {
                val = x.doubleValue() + y.doubleValue();
            } else if (elemento.equals("*")) {
                val = x.doubleValue() * y.doubleValue();
            } else if (elemento.equals("/")) {
                val = x.doubleValue() / y.doubleValue();
            }
            push(val);
        } else {
            stack.add((Number) elemento);
        }

    }

    public void PI() {
        push(Math.PI);
    }

    public Number value() {
        return stack.getLast();
    }
}
