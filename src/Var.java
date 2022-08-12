import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ofek yaloz
 * ID: 206666729
 */
public class Var implements Expression {
    private String varName;

    /**
     * Constructor of var.
     * @param var - the name of the var.
     */
    Var(String var) {
        this.varName = var;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        Boolean bool = assignment.get(this.varName);
        if (bool == null) {
            throw new Exception();
        }
        return bool;
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception();
    }

    @Override
    public List<String> getVariables() {
        List<String> l = new LinkedList();
        l.add(this.varName);
        return l;
    }

    @Override
    public String toString() {
        return varName;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (var.equals(this.varName)) {
            return expression;
        } else {
           return this;
        }
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
