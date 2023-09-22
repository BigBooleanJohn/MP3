package lab.polymorphism;

/*the class Truncated implements TextBlock's methods */
public class RightJustified implements TextBlock {
    TextBlock RightBlock;
    int RightIndex;

    /* Truncated constructor */
    public RightJustified(int intInput, TextBlock TBInput) {
        this.RightIndex = intInput;
        this.RightBlock = TBInput;
    }

    public String row(int i) throws Exception {
        if (i > this.RightBlock.height()) {
            throw new Exception("Invalid row " + i);
        } else {
            return this.RightBlock.row(i);
        }
    }// row

    public int height() {
        return this.RightBlock.height();
    }// height

    public int width() {
        return this.RightBlock.width();
    }// width

    /*
     * I wrote this function because in the textblocks, Strings have many
     * space characters in them that make them longer than expected. this method
     * returns the string that is made up of solely made up of alphabetic chars
     */
    public static String newString(String s) {
        int i = 0;
        if (s.contains(" ") == false) {
            return s;
        } else {
            while (s.toCharArray()[i] != ' ') {
                i++;
            }
            String NewS = s.substring(0, i - 1);
            return NewS;
        }
    }

    /*
     * RightJustifier is a method that refers to a RightJustified object, and based
     * on
     * the RightIndex field of the object, it will justify it to the right if the
     * string
     * is shorter than the RightIndex field of the object
     */
    public TextBlock RightJustifier() {
        String[] stringArr = new String[this.RightBlock.height()];// getting an array fof the rows of strings
        for (int i = 0; i < this.RightBlock.height(); i++) {
            try {
                stringArr[i] = this.row(i);// setting the string array to be the different rows
            } catch (Exception e) {
                System.out.printf("error, String couldn't be parsed from row");
            }
        }
        for (int i = 0; i < stringArr.length; i++) {
            stringArr[i] = TBUtils.newString(stringArr[i]);// removing the extra spaces in each stringg, if they are
                                                           // there
            if (stringArr[i].length() < this.RightIndex) {
                int spaceNeeded = this.RightIndex - stringArr[i].length();
                stringArr[i] = TBUtils.spaces(spaceNeeded) + stringArr[i];
            } else {
                stringArr[i] = stringArr[i].substring(0, this.RightIndex);
            }
        }
        TextBlock returnBlock = new TextLine(stringArr[0]);
        for (int i = 1; i < stringArr.length; i++) {
            returnBlock = new VComposition(returnBlock, new TextLine(stringArr[i]));
        }
        return returnBlock;
    }
}
