package observer;

import java.util.Stack;
/**
 * a String builder with a undo option
 * @author Naor Ladani
 *
 */
public class UndoableStringBuilder {
    /**
     *  @param opertionList - Stack that save all the string's changes
     *  @param myString - The current string
     */
    private Stack<String> operationList;
    private StringBuilder myString;
    /**
     * The function is a  fast constructor method
     */
    public UndoableStringBuilder() {
        myString = new StringBuilder();
        operationList = new Stack<String>();
    }

    public String toString() {

        return myString.toString();
    }

    /**
     * The function appends the specified string to this character sequence.
     * @param str the new characters
     * @return the StringBuilder object after the changes
     */
    public UndoableStringBuilder append(String str) {
        operationList.push(myString.toString());
        myString.append(str);
        return this;

    }
    /**
     * The function removes the characters in a substring of this sequence.
     * The substring begins at the specified start and extends to
     * the character at index end - 1 or to the end of the sequence
     * if no such character exists. If start is equal to end,
     * no changes are made.
     * @param start Point to the location of the first character.
     * @param end Point to border delete location.
     * @return the StringBuilder object after the changes
     */
    @SuppressWarnings("finally")
    public UndoableStringBuilder delete(int start, int end) {
        operationList.push(myString.toString());
        try {
            myString.delete(start, end);
        }
        catch(StringIndexOutOfBoundsException  e) {
            e.printStackTrace();
            if(start<0)
                System.err.println("Start index is negative");
            else if(start>end)
                System.err.println("Start index bigger than End index");
            else if(start >= myString.length())
                System.err.println("Start index is out of range");
            this.undo();
        }
        finally{
            return this;
        }
    }
    /**
     * The function inserts the string into this character sequence.
     * @param offset Point to the start insert location.
     * @param str The characters that we need to insert.
     * {@code} operationList.push(sentence); - save the main string before the change.
     * @return the StringBuilder object after the changes
     */
    @SuppressWarnings("finally")
    public UndoableStringBuilder insert(int offset, String str)
    {
        operationList.push(myString.toString());
        try{
            myString.insert(offset, str);
        }
        catch(StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.err.println("offset index is out of range");
            this.undo();
        }

        finally {
            return this;
        }
    }
    /**
     * The function replaces the characters in a substring of this sequence
     * with characters in the specified String.
     * The substring begins at the specified start and extends to the character
     * at index end - 1 or to the end of the sequence if no such character exists.
     * First the characters in the substring are removed and then the specified String is inserted at start.
     * (This sequence will be lengthened to accommodate the specified String if necessary).
     * @param start Point to the location of the first delete character
     * @param end Point to border delete location
     * @param str The new characters
     * @throws  NullPointerException when str is null.
     * @return the StringBuilder object after the change.
     */
    @SuppressWarnings("finally")
    public UndoableStringBuilder replace(int start,int end, String str) throws NullPointerException
    {
        if(str == null)
            throw new NullPointerException("Str is null");
        else {
            operationList.push(myString.toString());
            try {
                myString.replace(start, end, str);
            }
            catch(StringIndexOutOfBoundsException  e) {
                e.printStackTrace();
                if(start<0)
                    System.err.println("Start index is negative");
                else if(start>end)
                    System.err.println("Start index bigger than End index");
                else if(start >= myString.length())
                    System.err.println("Start index is out of range");
                this.undo();
            }
            finally {
                return this;
            }
        }
    }
    /**
     * The function causes this character sequence to be replaced by
     * the reverse of the sequence.
     * @return the StringBuilder object after the changes
     */
    public UndoableStringBuilder reverse() {
        operationList.push(myString.toString());
        myString.reverse();
        return this;
    }
    /**
     * The function remove the last string from the stack,
     * and put him in myString
     * @return the StringBuilder object after the changes
     */
    public void undo() {
        try {
            myString = new StringBuilder(operationList.pop());
        }
        catch(Exception e) {
        }
    }
}