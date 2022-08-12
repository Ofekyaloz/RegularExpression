import java.util.Map;

/**
 * @author ofek yaloz
 * ID: 206666729
 */
public class Not extends UnaryExpression {

    /**
     * Constructor of Not expression.
     * @param expression - first expression.
     */
    public Not(Expression expression) {
        super(expression);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !this.getE().evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        return !this.getE().evaluate();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Not(this.getE().assign(var, expression));
    }

    @Override
    public String toString() {
        return "~(" + this.getE() + ")";
    }

    @Override
    public Expression nandify() {
        return new Nand(this.getE().nandify(), this.getE().nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(this.getE().norify(), this.getE().norify());
    }

    @Override
    public Expression simplify() {
        Boolean e;
        Expression tmpE1 = this.getE1().simplify();
        try {
            e = tmpE1.evaluate();
        } catch (Exception ex) {
            return new Not(tmpE1);
        }
        if (e) {
            return new Val(false);
        } else {
            return new Val(true);
        }
    }
}
