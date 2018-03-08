package advancedClassDesign.nestedClasses;

/**
 * @author Rafael Bernabeu
 * @date 08/03/18 - 16:03
 *
 * Definition:
 *
 * A top level class is a class that is not a nested class.
 * A nested class (member class) is any class whose declaration occurs within the body of another class or interface.
 * An inner class is a nested class that is not explicitly or implicitly declared static.
 *
 * The modifier static pertains only to member classes, not to top level or local or anonymous classes.
 * That is, only classes declared as members of top-level classes can be declared static.
 * Package member classes, local classes (i.e. classes declared in methods) and anonymous classes cannot be declared static.
 *
 *
 * Questions that you have be able to answer:
 *
 * 1) Which variables declared in the encapsulating class or in the method, can an inner class access if the inner class is defined in a static method of encapsulating class?
 * 2) Which variables of the encapsulating class can an inner class access, if the inner class is defined in an instance method of the encapsulating class?
 * 3) An inner class can extend its outer class?
 * 4) What classes can a non-static nested class extend ?
 *
 * TIPS:
 *
 * When you create an anonymous class for an interface, it extends from Object.
 * But if you make an anonymous class from another class then it extends from that class. For example, consider the following class:
 *
 * A static nested class can contain non-static member variables.
 *
 */
public class Outter {
    
    private String instanceMemberVariable;
    private static String staticMemberVariable;

    private static class MemberStaticInner {

        private String privateMSI;
        private static String privateStaticMSI;

        public String publicMSI;
        public static String publicStaticMSI;

        private MemberStaticInner(){}
        public MemberStaticInner(String s){}

    }

    private class MemberInner {

        private String privateMI;
        private /*static*/ String privateStaticMI; /*Inner classes cannot have static declarations.*/

        public String publicMI;
        public /*static*/ String publicStaticMI; /*Inner classes cannot have static declarations.*/

        private MemberInner(){}
        public MemberInner(String s){}

    }

    public static void main(String... args) {

        assert          new Outter().new MemberInner().privateMI            == null;
        assert          new Outter().new MemberInner().publicMI             == null;

        assert          new Outter.MemberStaticInner().privateMSI           == null; //can access private members of private static member class
        assert          new MemberStaticInner().privateMSI                  == null; /* is the same as the upper line */

        assert          new Outter.MemberStaticInner("")                 == null;
        assert          new MemberStaticInner().privateMSI                  == null;

    }

}
