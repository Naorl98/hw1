package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {
    private UndoableStringBuilder usb;
    private List<Member> members = new ArrayList<>(); // save all the members that listen to him.
    public GroupAdmin() { 
        usb =  new UndoableStringBuilder();
    }
    
    /**
     * The method add member to the Members list.
     * @param obj the new member
     */
    @Override
    public void register(Member obj) {
        this.members.add(obj);
    }
     /**
     * The method remove the member from Members list.
     * @param obj the new member
     */
    
    @Override
    public void unregister(Member obj) {
        obj.update(null);// set his string to null.
        this.members.remove(obj);
    }
     /**
     * The function inserts the string into this character sequence,
     * and send update to the members that in the list.
     * @param offset Point to the start insert location.
     * @param str The characters that we need to insert.
     */

    @Override
    public void insert(int offset, String obj) {
        this.usb.insert(offset, obj);
        for(Member member : this.members) {
            member.update(usb);
        }
    }
     /**
     * The function appends the specified string to this character sequence'
     * and send update to the members that in the list.
     * @param str the new characters
     * @return the StringBuilder object after the changes
     */
    @Override
    public void append(String obj) {
        this.usb.append(obj);
        for(Member member : this.members) {
            member.update(usb);
        }
    }
    /**
     * The function removes the characters in a substring of this sequence.
     * The substring begins at the specified start and extends to
     * the character at index end - 1 or to the end of the sequence
     * if no such character exists. If start is equal to end,
     * no changes are made.
     * send update to the members that in the list.
     * @param start Point to the location of the first character.
     * @param end Point to border delete location.
     */
    @Override
    public void delete(int start, int end) {
        this.usb.delete(start, end);
        for(Member member : this.members) {
            member.update(usb);
        }
    }
    /**
    * Erases the last change done to the document, reverting
    * it to an older state,
    * and send update to the members that in the list.
    */
    @Override
    public void undo() {
        this.usb.undo();
        for(Member member : this.members) {
            member.update(usb);
        }
    }
}
