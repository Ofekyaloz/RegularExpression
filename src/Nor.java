import java.util.Map;

/**
 * @author ofek yaloz
 * ID: 206666729
 */
public class Nor extends BinaryExpression {

    /**
     * Constructor of Nor expression.
     * @param expression1 - first expression.
     * @param expression2 - second expression.
     */
    public Nor(Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !this.getE1().evaluate(assignment) && !this.getE2().evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        return !this.getE1().evaluate() && !this.getE2().evaluate();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Nor(this.getE1().assign(var, expression),  this.getE2().assign(var, expression));
    }

    @Override
    public String toString() {
        return "(" + getE1() + " V " + getE2() + ")";
    }

    @Override
    public Expression nandify() {
        return new Nand(new Nand(new Nand(this.getE1().nandify(), this.getE1().nandify()),
                new Nand(this.getE2().nandify(), this.getE2().nandify())), new Nand(new Nand(this.getE1().nandify(),
                this.getE1().nandify()), new Nand(this.getE2().nandify(), this.getE2().nandify())));
    }

    @Override
    public Expression norify() {
        return new Nor(this.getE1().norify(), this.getE2().norify());
    }

    @Override
    public Expression simplify() {
        Boolean e1, e2;
        Expression tmpE1 = this.getE1().simplify(), tmpE2 = this.getE2().simplify();
        try {
            e1 = tmpE1.evaluate();
        } catch (Exception ex1) {
            try {
                e2 = tmpE2.evaluate();
            } catch (Exception ex2) {
                if (tmpE1.toString().equals(tmpE2.toString())) {
                    return new Not(tmpE1);
                }
                return new Nor(tmpE1, tmpE2);
            }
            if (e2) {
                return new Val(false);
            }
            return new Not(tmpE1);
        }
        try {
            e2 = tmpE2.evaluate();
        } catch (Exception ex2) {
            if (e1) {
                return new Val(false);
            }
            return new Not(tmpE2);
        }
        if (!e1 && !e2) {
            return new Val(true);
        } else {
            return new Val(false);
        }
    }
}
