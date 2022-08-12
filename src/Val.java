import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ofek yaloz
 * ID: 206666729
 */
public class Val implements Expression {
    private boolean value;

    /**
     * Constructor of Val.
     * @param bool - the value.
     */
    Val(boolean bool)  {
        this.value = bool;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.value;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.value;
    }

    @Override
    public List<String> getVariables() {
        return new LinkedList<>();
    }

    @Override
    public String toString() {
        if (this.value) {
            return "T";
        } else {
            return "F";
        }
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return this;
    }

    @Override
    public Expression nandify() {
        return this;
    }

    @Override
    public Expression norify() {
        return this;
    }

    @Override
    public Expression simplify() {
        return this;
    }
}
