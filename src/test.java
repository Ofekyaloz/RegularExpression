import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class test {
    public static void main(String[] args) {
        List<Expression> expressions = new ArrayList<>();
        Var x = new Var("x");
        Var y = new Var("y");
        Var z = new Var("z");
        Map<String, Boolean> ass = new TreeMap<>();
        ass.put("y", true);
        ass.put("z", false);
        expressions.add(new And(x, y));
        expressions.add(new Or(x, y));
        expressions.add(new Xor(x, y));
        expressions.add(new Nand(x, y));
        expressions.add(new Nor(x, y));
        expressions.add(new Xnor(x, y));
        expressions.add(new Not(x));
        expressions.add(new Not(new Xor(new And(new Val(true), new Or(new Var("x"), new Var("y"))), new Var("x"))));

        for (int i = 0; i < expressions.size(); i++) {
            Expression e = expressions.get(i);
            if (i != 0) {
                System.out.println();
            }
            System.out.println(i + ":\n");
            System.out.println(e + "\n");
            System.out.println(e.nandify() + "\n");
            System.out.println(e.nandify().simplify() + "\n");
            System.out.println(e.norify() + "\n");
            System.out.println(e.norify().simplify() + "\n");
            Expression tmp = e.assign("x", new Xnor(z, new Val(false)));
            System.out.println(tmp + "\n");
            try {
                System.out.println(tmp.evaluate(ass));
            } catch (Exception ex) {
                System.out.println("exception: can't evaluate");
            }

        }

    }

    //    public static void main(String[] args) throws Exception {
//
//        Expression e9 = new Not(
//                new Xor(
//                        new And(
//                                new Val(true),
//                                new Or(
//                                        new Var("x"),
//                                        new Var("y")
//                                )
//                        ),
//                        new Var("x")
//                )
//        );
//
//        Expression e2 = new Xor(new And(new Var("x"), new Var("y")), new Val(true));
//
//        Expression e4 = new Not(new And(new Val(true), new Val(true)));
//        boolean bool = e4.evaluate();
//        System.out.println(bool);
//
//
//        String s = e2.toString();
//        System.out.println(s);
//
//        List<String> vars = e2.getVariables();
//        for (String v : vars) {
//            System.out.println(v);
//        }
//
//        Expression e3 = e2.assign("y", e2);
//        System.out.println(e3);
//// ((x & ((x & y) ^ T)) ^ T)
//        e3 = e3.assign("x", new Val(false));
//        System.out.println(e3);
//// ((F & ((F & y) ^ T)) ^ T)
//
//
//        Map<String, Boolean> assignment = new TreeMap<>();
//        assignment.put("x", true);
//        assignment.put("y", false);
//        Boolean value = e2.evaluate(assignment);
//        System.out.println("The result is: " + value);
//
//        Expression e = new Nor(new Var("x"), new Var("y"));
//        System.out.println(e.nandify());
//        System.out.println(e.norify());
//
//        Expression end = new And(new Var("x"),new Var("x"));
//        end = end.simplify();
//        System.out.println(e.evaluate());
//    }
}
