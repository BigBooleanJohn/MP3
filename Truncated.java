package lab.polymorphism;

/*Truncated is a method that truncates a TextBlock onject. It was written By John Miller for mini-project 3:
*/

/*the class Truncated implements TextBlock's methods */
public class Truncated implements TextBlock {
    TextBlock TrunkBlock;
    int TrunkIndex;

    /* Truncated constructor */
    public Truncated(int intInput, TextBlock TBInput) {
        this.TrunkIndex = intInput;
        this.TrunkBlock = TBInput;
    }

    public String row(int i) throws Exception {
        if (i > this.TrunkBlock.height()) {
            throw new Exception("Invalid row " + i);
        } else {
            return this.TrunkBlock.row(i);
        }
    }// row

    public int height() {
        return this.TrunkBlock.height();
    }// height

    public int width() {
        return this.TrunkBlock.width();
    }// width

    /*
     * truncator is a method that refers to a Truncated object, and based on the
     * truncateIndex field of the object, truncates the object to the appropriate
     * length
     * if it is shorter, it will center the object. it will left-justify slightly.
     */
    public TextBlock truncator() {
        String[] stringArr = new String[this.TrunkBlock.height()];
        for (int i = 0; i < this.TrunkBlock.height(); i++) {
            try {
                stringArr[i] = this.row(i);
            } catch (Exception e) {
                System.out.printf("error, String couldn't be parsed from row");
            }
        }
        for (int i = 0; i < stringArr.length; i++) {
            stringArr[i] = TBUtils.newString(stringArr[i]);
            if (stringArr[i].length() > this.TrunkIndex) {
                stringArr[i] = stringArr[i].substring(0, this.TrunkIndex);
            }
        }
        TextBlock returnBlock = new TextLine(stringArr[0]);
        for (int i = 1; i < stringArr.length; i++) {
            returnBlock = new VComposition(returnBlock, new TextLine(stringArr[i]));
        }
        return returnBlock;
    }
}
