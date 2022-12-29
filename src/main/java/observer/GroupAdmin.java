package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender {
    private ArrayList<Member> memberList;
    private UndoableStringBuilder current;
    /**
     * A constructor with the StringBuilder values.
     * And create new array list of members
     */
    public GroupAdmin()
    {
        this.current= new UndoableStringBuilder();
        this.memberList = new ArrayList<>();
    }
    /**
     * add member to the list
     * @param obj pointer of member
     */
    @Override
    public void register(Member obj) {
            if (!memberList.contains(obj))
            {
                this.memberList.add(obj);
                System.out.println("Added member.");
            }
    }
    /**
     * Unregister member from the list
     * @param obj pointer of member
     */
    @Override
    public void unregister(Member obj) {
        if(memberList.contains(obj)){
            memberList.remove(obj);
            System.out.println("member was remove");
        }
    }
    /**
     * Insert the string into this character sequence.
     * And notify the change of notifyMembers
     * @param offset the offset
     * @param obj  the string
     */
    @Override
    public void insert(int offset, String obj) {
        current.insert(offset, obj);
        notifyMembers();
    }
    /**
     * append the string to character sequence
     * And notify the change of notifyMembers
     * @param obj  the string
     */
    @Override
    public void append(String obj) {
        current.append(obj);
        notifyMembers();

    }
    /**
     * Removes the characters in a substring of this sequence.
     * The substring begins at the specified start and extends to the character at index end-1 or to the end of the sequence if no character exists.
     * if start is equal to end,no changes are made.
     *And notify the change of notifyMembers
     * @param start
     * @param end
     * @return this object;
     */
    @Override
    public void delete(int start, int end) {
        current.delete(start, end);
        notifyMembers();
    }
    /**
     * Show us what was before
     * And notify the change of notifyMembers
     */
    @Override
    public void undo() {
        current.undo();
        notifyMembers();
    }
    /**
     * Notify and update all members about the change that has been made
     */
    public void notifyMembers() {
        for (Member member : memberList) {
            member.update(current);
        }
    }
    public String getCurrentData(){
        return current.toString();
    }

    public String toStringData(){
        String name="";
        for (Member member : this.memberList) {
            name+=member.toString()+" "+current.toString()+" ";
        }
        return name;
    }

    public ArrayList<Member> getMembers(){
        return memberList;
    }


}
