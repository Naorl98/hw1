package observer;

public class ConcreteMember implements Member{
    private UndoableStringBuilder usb;
    public ConcreteMember() {
        usb = new UndoableStringBuilder();
    }
    /**
    * The function update the usb variable to the new usb variable.
    * @param usb the new UndoableStringBuilder.
    */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
    }
    /**
    * Get function.
    * @return usb.
    */
    public UndoableStringBuilder getUsb(){
        return this.usb;
    }
}
