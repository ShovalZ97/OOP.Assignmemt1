package observer;

public class ConcreteMember implements Member {

    private UndoableStringBuilder data;
    private String name1;
    /**
     * A constructor with the StringBuilder values.
     * @param name  Name of the member.
     */
    //sallow copy
    public ConcreteMember(String name) {
        this.data = new UndoableStringBuilder();
        this.name1=name;
    }
//    public ConcreteMember(){
//        this.name1=null;
//        this.data=null;
//    }
    /**
     * Update the pointer of the UndoableStringBuilder to the one from the GroupAdmin.
     * @param usb  pointer to UndoableStringBuilder object
     */
    @Override
    public void update(UndoableStringBuilder usb) {
       this.data = usb;
    }
    /**
     * Get Data
     */
    public UndoableStringBuilder getData() {
        return data;
    }

    @Override
    public String toString() {
        return name1;
    }
}
