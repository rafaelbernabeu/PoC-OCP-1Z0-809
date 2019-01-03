package advancedClassDesign.nestedClasses;

/**
 * A class designed to check witch statements are valid.
 */

public class TestOutter {

    public static void main(String... args) {


        assert new Outter().publicStaticMemberVariable.publicMSI == null;
        assert new Outter().publicStaticMemberVariable.publicStaticMSI == null;
        assert new Outter().publicStaticMemberVariable.privateMSI == null;
        assert new Outter().publicStaticMemberVariable.privateStaticMSI == null;

        assert new Outter().privateStaticMemberVariable.publicMSI == null;
        assert new Outter().privateStaticMemberVariable.publicStaticMSI == null;
        assert new Outter().privateStaticMemberVariable.privateMSI == null;
        assert new Outter().privateStaticMemberVariable.privateStaticMSI == null;


        assert new Outter().privateStaticMemberVariable == null;

        assert new Outter().publicInstanceMemberVariable == null;
        assert new Outter().privateInstanceMemberVariable == null;


        //Private access tests
        assert new Outter().new PrivateMemberInner().privateMI == null;
        assert new Outter().new PrivateMemberInner().privateMI == null;
        assert new Outter().new PrivateMemberInner().publicMI == null;

        assert new Outter.PrivateMemberStaticInner().privateMSI == null;
        assert new Outter.PrivateMemberStaticInner().publicMSI == null;

        assert new Outter.PrivateMemberStaticInner("").publicMSI == null;
        assert new Outter.PrivateMemberStaticInner("").publicStaticMSI == null;
        assert new Outter.PrivateMemberStaticInner("").privateMSI == null;
        assert new Outter.PrivateMemberStaticInner("").privateStaticMSI == null;
        assert new Outter.PrivateMemberStaticInner().publicMSI == null;
        assert new Outter.PrivateMemberStaticInner().publicStaticMSI == null;
        assert new Outter.PrivateMemberStaticInner().privateMSI == null;
        assert new Outter.PrivateMemberStaticInner().privateStaticMSI == null;


        //Public access tests
        assert new Outter().new PublicMemberInnerClass().privateMI == null;              //private no-args constructor
        assert new Outter().new PublicMemberInnerClass().publicMI == null;              //private no-args constructor
        assert new Outter().new PublicMemberInnerClass("").privateMI == null;
        assert new Outter().new PublicMemberInnerClass("").publicMI == null;

        assert new Outter.PublicMemberStaticInner().privateMSI == null;
        assert new Outter.PublicMemberStaticInner().publicMSI == null;
        assert new Outter.PublicMemberStaticInner("").privateMSI == null;
        assert new Outter.PublicMemberStaticInner("").privateStaticMSI == null;
        assert new Outter.PublicMemberStaticInner("").publicMSI == null;
        assert new Outter.PublicMemberStaticInner("").publicStaticMSI == null;


        assert new Outter.PublicMemberStaticInner("").privateMSI == null;
        assert new Outter.PublicMemberStaticInner("").publicMSI == null;
        assert new Outter.PublicMemberStaticInner("").privateMSI == null;
        assert new Outter.PublicMemberStaticInner("").publicMSI == null;

        assert new Outter.PublicMemberStaticInner("").publicMSI == null;
        assert new Outter.PublicMemberStaticInner("").publicStaticMSI == null;
        assert new Outter.PublicMemberStaticInner("").privateMSI == null;
        assert new Outter.PublicMemberStaticInner("").privateStaticMSI == null;
        assert new Outter.PublicMemberStaticInner().publicMSI == null;
        assert new Outter.PublicMemberStaticInner().publicStaticMSI == null;
        assert new Outter.PublicMemberStaticInner().privateMSI == null;
        assert new Outter.PublicMemberStaticInner().privateStaticMSI == null;

    }

}
