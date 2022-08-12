import java.util.List;
import java.util.Map;

/**
 * @author ofek yaloz
 * ID: 206666729
 */
public interface Expression {

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception is thrown.
     * @param assignment - a map with String and value.
     * @return - if exists the value of the expression (true/false) else throws exception.
     * @throws Exception - if cant evaluate the expression.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * @return - the value of the expression.
     * @throws Exception - if it cant evaluate the expression value (contains var\s).
     */
    Boolean evaluate() throws Exception;

    /**
     * @return - a list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * @return - a string representation of the expression.
     */
    String toString();

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression.
     * @param var - var name.
     * @param expression - the new expression instead the val.
     * @return - new expression.
     */
    Expression assign(String var, Expression expression);

    /**
     * @return - the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    Expression nandify();

    /**
     * @return - the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    Expression norify();

    /**
     * @return - a simplified version of the current expression.
     */
    Expression simplify();

}