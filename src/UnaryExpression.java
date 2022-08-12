import java.util.List;

/**
 * @author ofek yaloz
 * ID: 206666729
 */
public abstract class UnaryExpression extends BaseExpression {

    /**
     * Constructor of UnaryExpression.
     * @param expression - first expression.
     */
    public UnaryExpression(Expression expression) {
        super(expression);
    }

    /**
     * @return - returns the expression.
     */
    protected Expression getE() {
        return this.getE1();
    }

    @Override
    public List<String> getVariables() {
        return this.getE().getVariables();
    }
}
