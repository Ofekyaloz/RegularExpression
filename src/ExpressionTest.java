import java.util.Map;
import java.util.TreeMap;

/**
 * @author ofek yaloz
 * ID: 206666729
 */
public class ExpressionTest {

    /**
     * Creates an expression and prints the expression, its evaluate with an assignment,
     * Nandified version, Norified version and simplified version.
     * @param args - none.
     */
    public static void main(String[] args) {
        Expression e = new And(new Xor(new Var("x"), new Var("y")), new Or(new Var("z"), new Var("x")));
        System.out.println(e);
        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        assignment.put("z", false);
        Boolean b = null;
        try {
           b = e.evaluate(assignment);
        } catch (Exception exception) {
            System.out.println("exception: can't evaluate");
        }
        System.out.println(b);
        System.out.println(e.nandify());
        System.out.println(e.norify());
        System.out.println(e.simplify());
    }
}
