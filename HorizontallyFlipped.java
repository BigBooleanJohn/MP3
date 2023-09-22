package lab.polymorphism;

/*this is a class that flips the TextBlock field horizontally */
public class HorizontallyFlipped implements TextBlock {
    TextBlock HorizFlipBlock;

    /* Truncated constructor */
    public HorizontallyFlipped(TextBlock TBInput) {
        this.HorizFlipBlock = TBInput;
    }

    public String row(int i) throws Exception {
        if (i > this.HorizFlipBlock.height()) {
            throw new Exception("Invalid row " + i);
        } else {
            return this.HorizFlipBlock.row(i);
        }
    }// row

    public int height() {
        return this.HorizFlipBlock.height();
    }// height

    public int width() {
        return this.HorizFlipBlock.width();
    }// width

    /*
     * HorizFlipper is a method that refers to a HorizontallyFlipped object, and
     * flips the
     * object's rows
     */
    public TextBlock HorizFlipper() {
        String[] stringArr = new String[this.HorizFlipBlock.height()];
        for (int i = 0; i < this.HorizFlipBlock.height(); i++) {
            try {
                stringArr[i] = this.row(i);
            } catch (Exception e) {
                System.out.printf("error, String couldn't be parsed from row");
            }
        }
        for (int i = 0; i < stringArr.length; i++) {
            stringArr[i] = TBUtils.newString(stringArr[i]);
        }
        for (int i = 0; i < stringArr.length; i++) {
            stringArr[i] = new StringBuilder(stringArr[i]).reverse().toString();// reversing the string
        }

        TextBlock returnBlock = new TextLine(stringArr[0]);
        for (int i = 1; i < stringArr.length; i++) {
            returnBlock = new VComposition(returnBlock, new TextLine(stringArr[i]));
        }
        return returnBlock;
    }
}
