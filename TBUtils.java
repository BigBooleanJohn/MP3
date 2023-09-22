package lab.polymorphism;

import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program
   * operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program
   * operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  static boolean equal(TextBlock t1, TextBlock t2) {
    if (t1.height() != t2.height()) {
      return false;// if the two blocks do not have the same amount of rows, they will be unequal
    } else {
      int height = t1.height();// both heights will be the same, so this will be the height variable
      String[] Block1Contents = new String[height];
      String[] Block2Contents = new String[height];
      for (int i = 0; i < height; i++) {
        try {
          Block1Contents[i] = t1.row(i);
          Block2Contents[i] = t2.row(i);
        } catch (Exception e) {
          System.out.printf("the String could not be parsed from the TextBlock row\n");
        }
      }
      for (int x = 0; x < height; x++) {
        if (Block1Contents[x].compareTo(Block2Contents[x]) != 0) {
          return false;// if the two strings are different, return false
        }
      }
    }
    return true;// if the previous condition was not met, the strings are equal, return true
  }

  /*
   * I wrote this function because in the textblocks, Strings have many
   * space characters in them that make them longer than expected. this method
   * returns the string that is made up of solely made up of alphabetic chars
   */
  public static String newString(String s) {
    String[] parsedArr = s.split(" ");
    return parsedArr[0];
  }

  public boolean eqv(TextBlock t1, TextBlock t2) {
    if (t1.hashCode() == t2.hashCode()) {
      return true;// if the object through which these two TextBlocks are built are the same,
                  // return true
    }
    return false;// if the objects are not built the same way, return false
  }

} // class TBUtils
