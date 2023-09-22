package lab.polymorphism;

/*This vertically flips a TextBlock; that is, it flips row by row*/
public class VerticallyFlipped implements TextBlock {
    TextBlock FlipBox;

    /* Truncated constructor */
    public VerticallyFlipped(TextBlock TBInput) {
        this.FlipBox = TBInput;
    }

    public String row(int i) throws Exception {
        if (i > this.FlipBox.height()) {
            throw new Exception("Invalid row " + i);
        } else {
            return this.FlipBox.row(i);
        }
    }// row

    public int height() {
        return this.FlipBox.height();
    }// height

    public int width() {
        return this.FlipBox.width();
    }// width

    /*
     * VerticalFlipper is a method that takes a VerticallyFlipped
     * object and flips the rows in the text field so that theyre vertically flipped
     */
    public TextBlock VerticalFlipper() {
        String[] stringArr = new String[this.FlipBox.height()];
        for (int i = 0; i < this.FlipBox.height(); i++) {
            try {
                stringArr[i] = this.row(i);
            } catch (Exception e) {
                System.out.printf("error, String couldn't be parsed from row");
            }
        }
        for (int i = 0; i < stringArr.length; i++) {
            stringArr[i] = TBUtils.newString(stringArr[i]);
        }
        int max = stringArr.length - 1;
        int min = 0;
        while (min < max) {
            String temp = stringArr[min];
            stringArr[min] = stringArr[max];
            stringArr[max] = temp;
            max--;
            min++;
        }
        TextBlock returnBlock = new TextLine(stringArr[0]);
        for (int i = 1; i < stringArr.length; i++) {
            returnBlock = new VComposition(returnBlock, new TextLine(stringArr[i]));
        }
        return returnBlock;
    }
}
