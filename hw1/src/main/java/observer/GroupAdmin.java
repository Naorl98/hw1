package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {
    private UndoableStringBuilder usb;
    private List<Member> members = new ArrayList<>();
    public GroupAdmin() {
        usb =  new UndoableStringBuilder();
    }
    //methods to register and unregister observers
    @Override
    public void register(Member obj) {
        this.members.add(obj);
    }
    @Override
    public void unregister(Member obj) {
        obj.update(new UndoableStringBuilder());
        this.members.remove(obj);
    }
    //Inserts the string into this character sequence.
    @Override
    public void insert(int offset, String obj) {
        this.usb.insert(offset, obj);
        for(Member member : this.members) {
            member.update(usb);
        }
    }
    // Appends the specified string to this character sequence.
    @Override
    public void append(String obj) {
        this.usb.append(obj);
        for(Member member : this.members) {
            member.update(usb);
        }
    }
    // Removes the characters in a substring of this sequence.
    @Override
    public void delete(int start, int end) {
        this.usb.delete(start, end);
        for(Member member : this.members) {
            member.update(usb);
        }
    }

    // Erases the last change done to the document, reverting
    // it to an older state.
    @Override
    public void undo() {
        this.usb.undo();
        for(Member member : this.members) {
            member.update(usb);
        }
    }
}
