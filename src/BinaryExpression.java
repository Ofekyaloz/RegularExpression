/**
 * @author ofek yaloz
 * ID: 206666729
 */
public abstract class BinaryExpression extends BaseExpression {

    /**
     * Constructor of BinaryBase.
     * @param expression1 - first expression.
     * @param expression2 - second expression.
     */
    public BinaryExpression(Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }
}