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
     * The methodInserts the string into this character sequence,
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
     * The
     * and send update to the members that in the list.
     * @param offset Point to the start insert location.
     * @param str The characters that we need to insert.
     */
    @Override
    public void append(String obj) {
        this.usb.append(obj);
        for(Member member : this.members) {
            member.update(usb);
        }
    }
    // Removes the characters in a substring of this sequence.
    //send update to the members that in the list.
    @Override
    public void delete(int start, int end) {
        this.usb.delete(start, end);
        for(Member member : this.members) {
            member.update(usb);
        }
    }

    // Erases the last change done to the document, reverting
    // it to an older state.
    //send update to the members that in the list.

    @Override
    public void undo() {
        this.usb.undo();
        for(Member member : this.members) {
            member.update(usb);
        }
    }
}
