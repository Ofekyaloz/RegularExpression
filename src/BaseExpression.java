import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ofek yaloz
 * ID: 206666729
 */
public abstract class BaseExpression implements Expression {
    private Expression e1, e2;

    /**
     * Constructor of Base Expression for BinaryExpression.
     * @param expression1 - first expression.
     * @param expression2 - second expression.
     */
    public BaseExpression(Expression expression1, Expression expression2) {
        this.e1 = expression1;
        this.e2 = expression2;
    }

    /**
     * Constructor of Base Expression for UnaryExpression.
     * @param exp - the expression.
     */
    public BaseExpression(Expression exp) {
        this.e1 = exp;
    }

    /**
     * @return - expression e1.
     */
    protected Expression getE1() {
        return this.e1;
    }

    /**
     * @return - expression e2.
     */
    protected Expression getE2() {
        return this.e2;
    }

    @Override
    public List<String> getVariables() {
        List<String> l = new LinkedList<>();
        l.addAll(this.getE1().getVariables());
        l.addAll(this.getE2().getVariables());
        return l.stream().distinct().collect(Collectors.toList());
    }
}
