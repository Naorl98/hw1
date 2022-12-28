package observer;

public class ConcreteMember implements Member{
    private UndoableStringBuilder usb;
    public ConcreteMember() {
        usb = new UndoableStringBuilder();
    }
    @Override
    public void update(UndoableStringBuilder usb) {
        this.setUsb(usb);
    }
    public UndoableStringBuilder getUsb(){
        return this.usb;
    }
    public void setUsb(UndoableStringBuilder usb) {
        this.usb = usb;
    }

}
