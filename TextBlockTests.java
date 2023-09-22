package lab.polymorphism;

import java.io.PrintWriter;

/*this is a program that tests cases and edge cases for them different classes in the project. Writted by John Miller*/
public class TextBlockTests {

    /* test1: this tests the truncated method */
    public static boolean test1_TruncateTest() {
        PrintWriter pen = new PrintWriter(System.out, true);
        TextBlock test = new TextLine("TestLine");
        Truncated tBlock = new Truncated(5, test);
        TextBlock result = tBlock.truncator();
        TextBlock myPrediction = new TextLine("TestL");
        if (TBUtils.equal(myPrediction, result) == true) {
            pen.printf("the two TextBlocks are equal, test passed\n");
            return true;
        } else {
            pen.printf("the two TextBlocks are NOT equal, test failed\n");
            return false;
        }
    }

    /* test2: this test test the centered java file */
    public static boolean test2_CenteredTest() {
        PrintWriter pen = new PrintWriter(System.out, true);
        TextBlock test = new TextLine("TestLine");
        Centered tBlock = new Centered(10, test);
        TextBlock result = tBlock.Centerer();
        TextBlock myPrediction = new TextLine(" TestLine ");
        if (TBUtils.equal(myPrediction, result) == true) {
            pen.printf("the two TextBlocks are equal, test passed\n");
            return true;
        } else {
            pen.printf("the two TextBlocks are NOT equal, test failed\n");
            return false;
        }
    }

    /* this tests rightAligned method */
    public static boolean test3_RightAlignedTest() {
        PrintWriter pen = new PrintWriter(System.out, true);
        TextBlock test = new TextLine("TestLine");
        RightJustified RBlock = new RightJustified(10, test);
        TextBlock result = RBlock.RightJustifier();
        TextBlock myPrediction = new TextLine("  TestLine");
        if (TBUtils.equal(myPrediction, result) == true) {
            pen.printf("the two TextBlocks are equal, test passed\n");
            return true;
        } else {
            pen.printf("the two TextBlocks are NOT equal, test failed\n");
            return false;
        }
    }

    /* this program tests the horizontal flip method */
    public static boolean test4_HorizFlipTest() {
        PrintWriter pen = new PrintWriter(System.out, true);
        TextBlock test = new TextLine("TestLine");
        HorizontallyFlipped HBlock = new HorizontallyFlipped(test);
        TextBlock result = HBlock.HorizFlipper();
        TextBlock myPrediction = new TextLine("eniLtseT");
        if (TBUtils.equal(myPrediction, result) == true) {
            pen.printf("the two TextBlocks are equal, test passed\n");
            return true;
        } else {
            pen.printf("the two TextBlocks are NOT equal, test failed\n");
            return false;
        }
    }

    /* this tests the verticallyFlipped method */
    public static boolean test5_VertFlipTest() {
        PrintWriter pen = new PrintWriter(System.out, true);
        VerticallyFlipped VBlock = new VerticallyFlipped(
                new VComposition(new TextLine("TopRow"), new TextLine("BottomRow")));
        TextBlock result = VBlock.VerticalFlipper();
        TextBlock myPrediction = new VComposition(new TextLine("BottomRow"), new TextLine("TopRow"));
        if (TBUtils.equal(myPrediction, result) == true) {
            pen.printf("the two TextBlocks are equal, test passed\n");
            return true;
        } else {
            pen.printf("the two TextBlocks are NOT equal, test failed\n");
            return false;
        }
    }

    /* This tests the test6 file */
    public static boolean test6_VertHorizFlipTest() {
        PrintWriter pen = new PrintWriter(System.out, true);
        ReversedAndFlipped RFBlock = new ReversedAndFlipped(
                new VComposition(new TextLine("TopText"), new TextLine("BottomText")));
        TextBlock result = RFBlock.BothFlipper();
        TextBlock prediction = new VComposition(new TextLine("txeTmottoB"), new TextLine("txeTpoT"));
        if (TBUtils.equal(prediction, result) == true) {
            pen.printf("the two TextBlocks are equal, test passed\n");
            return true;
        } else {
            pen.printf("the two TextBlocks are NOT equal, test failed\n");
            return false;
        }
    }

    public static void main(String[] args) {
        test1_TruncateTest();
        test2_CenteredTest();
        test3_RightAlignedTest();
        test4_HorizFlipTest();
        test5_VertFlipTest();
        test6_VertHorizFlipTest();
    }
}
