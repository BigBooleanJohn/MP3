package lab.polymorphism;

/*the class Centered implements TextBlock's methods */
public class Centered implements TextBlock {
    TextBlock CenteredBlock;
    int CenteredIndex;

    /* Centered constructor */
    public Centered(int intInput, TextBlock TBInput) {
        this.CenteredBlock = TBInput;
        this.CenteredIndex = intInput;
    }

    public String row(int i) throws Exception {
        if (i > this.CenteredBlock.height()) {
            throw new Exception("Invalid row " + i);
        } else {
            return this.CenteredBlock.row(i);
        }
    }// row

    public int height() {
        return this.CenteredBlock.height();
    }// height

    public int width() {
        return this.CenteredBlock.width();
    }// width

    /*
     * Centerer is a method that refers to a Centered object
     * if it is shorter than the centered Index at which it should
     * center, it will center the object. it will left-justify slightly.
     */
    public TextBlock Centerer() {
        String[] stringArr = new String[this.CenteredBlock.height()];
        for (int i = 0; i < this.CenteredBlock.height(); i++) {
            try {
                stringArr[i] = this.row(i);
            } catch (Exception e) {
                System.out.printf("error, String couldn't be parsed from row");
            }
        }
        for (int i = 0; i < stringArr.length; i++) {
            stringArr[i] = TBUtils.newString(stringArr[i]);
            if (stringArr[i].length() < this.CenteredIndex) {
                int spaceNeeded = (this.CenteredIndex - stringArr[i].length()) / 2;
                stringArr[i] = TBUtils.spaces(spaceNeeded) + stringArr[i] + TBUtils.spaces(spaceNeeded);
            } else {
                stringArr[i] = stringArr[i].substring(0, this.CenteredIndex);// truncating if it is too long
            }
        }
        TextBlock returnBlock = new TextLine(stringArr[0]);
        for (int i = 1; i < stringArr.length; i++) {
            returnBlock = new VComposition(returnBlock, new TextLine(stringArr[i]));
        }
        return returnBlock;
    }
}
