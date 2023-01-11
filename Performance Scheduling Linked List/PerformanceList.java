/**
 * @author Suheyla Ceyda Iyimaya
 */

/**
 * This class represents a PerformanceList.
 */
public class PerformanceList {
    private PerformanceNode head;
    private PerformanceNode tail;
    private PerformanceNode cursor;
    /**
     * This is a constructor used to create a new PerformanceList object.
     */
    public PerformanceList(){
        this.head = null;
        this.tail = null;
        this.cursor = null;
    }
    /**
     * This method adds the new performance node at the end of the
     * PerformanceList
     * @param newPerformance
     * the new performance node to add to the end of the PerformanceList
     *
     * Post-condition: New performance node is added at the end of the
     * PerformanceList. The cursor is now the newly created node.
     */
    public void addToEnd(PerformanceNode newPerformance){
        if(this.cursor == null){
            this.head = newPerformance;
            this.tail = head;
            this.cursor = head;
        }
        else{
            newPerformance.setNext(this.tail.getNext());
            this.tail.setNext(newPerformance);
            newPerformance.setPrev(this.tail);
            newPerformance.setNo();
            newPerformance.setStartTime();
            this.tail = newPerformance;
            this.cursor = this.tail;
        }
        updateStartTime();
    }
    /**
     * This method inserts the new data after the current node in PerformanceList
     * @param newPerformance
     * the new performance node to add to the end of the PerformanceList
     *
     * Post-condition: New performance node is added after the cursor of the
     * PerformanceList. The cursor is now the newly created node.
     */
    public void addAfterCurrent(PerformanceNode newPerformance){
        if(this.cursor == null){
            addToEnd(newPerformance);
        }
        else{
            newPerformance.setNext(this.cursor.getNext());
            this.cursor.setNext(newPerformance);
            newPerformance.setPrev(this.cursor);
            newPerformance.setNo();
            newPerformance.setStartTime();
            if(newPerformance.getNext() != null){
                newPerformance.getNext().setPrev(newPerformance);
            }
            cursor = newPerformance;
            if (cursor.getNext() == null){
                tail = cursor;
            }
        }
        updateStartTime();
    }
    /**
     * This method updates the start time and the position of each node in
     * PerformanceList
     *
     * Post-condition: The start time and the position number is updated
     */
    public void updateStartTime(){
        int m = 0;
        if(cursor != null){
            PerformanceNode headCopy = head;
            while((headCopy.getNext() != null && m ==0) || (headCopy == tail
                    && m == 0)){
                headCopy.setStartTime();
                headCopy.setNo();
                if(headCopy != tail){
                    headCopy = headCopy.getNext();
                }
                else{
                    m = 1;
                }
            }
        }
    }
    /**
     *This method enables access to the current node of the PerformanceList
     *
     * @return
     * the current node(cursor) of the performance list
     */
    public PerformanceNode getCursor(){
        return cursor;
    }
    /**
     * This method removes the current node
     *
     * Post-condition: the cursor of the PerformanceList is removed. New cursor
     * is the one after the previous cursor, if exists. If not, the cursor is
     * the previous node.
     */
    public boolean removeCurrentNode(){
        if(cursor != null){
            if(cursor.getPrev()!=null && cursor.getNext() != null){
                cursor.getPrev().setNext(cursor.getNext());
                cursor.setPrev(cursor.getPrev());
                cursor = cursor.getNext();
                updateStartTime();
                return true;
            }
            else if(cursor.getPrev() == null && cursor.getNext() == null){
                cursor = null;
                head = null;
                tail = null;
                updateStartTime();
                return true;
            }
            else if(cursor.getPrev() == null && cursor.getNext() != null){
                cursor = cursor.getNext();
                cursor.setPrev(null);
                head = cursor;
                updateStartTime();
                return true;
            }
            else if(cursor.getPrev() != null && cursor.getNext() == null){
                cursor.setNext(null);
                cursor = cursor.getPrev();
                tail = cursor;
                updateStartTime();
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    /**
     * This method prints the data in current node in a neatly formatted table.
     */
    public void displayCurrentPerformance(){
        String s = "";
        if(cursor != null){
            s = String.format("%-10s%-5s%-26s%-26s%-15s%-10s%-10s\n", "Current",
                    "No.", "Performance Name", "Lead Performer Name", "Participants"
                    , "Duration", "Start Time");
            s += String.format("%-100s\n","------------------------------"
                    + "----------"+ "-------------------------"
                    + "-------------------------------------");
            s+= cursor.toString("*");
        }
        else{
            s += "Error: there is no current node";
        }
        System.out.println(s);
    }
    /**
     * This method moves the cursor forward
     *
     * @return
     * if it is possible for the cursor to move forward
     *
     * Post-condition: Moves the reference of the current node forward in the
     * list by one position if a node exists after the current one and returns
     * true. If there is no next node, the current node remains the same
     * and returns false.
     */
    public boolean moveCursorForward(){
        if(cursor.getNext() == null){
            return false;
        }
        else{
            cursor = cursor.getNext();
            return true;
        }
    }
    /**
     * This method moves the cursor backwards
     *
     * @return
     * if it is possible for the cursor to move backwards
     *
     * Post-condition: Moves the reference of the current node backwards in the
     * list by one position if a node exists before the current one and returns
     * true. If there is no previous node, the current node remains the same
     * and returns false.
     */
    public boolean moveCursorBackward(){
        if(cursor.getPrev() == null){
            return false;
        }
        else{
            cursor = cursor.getPrev();
            return true;
        }
    }
    /**
     * This method moves the current node to the given position in the
     * PerformanceList
     *
     * @return
     * if it is possible for the cursor to move to the desired position
     *
     * Post-condition: the current node is moved to the given position in the
     * PerformanceList.
     */
    public boolean jumpToPosition(int position){
        PerformanceNode headCopy = head;
        int i = 1;
        if (position <= 0) throw new IllegalArgumentException("Error- position "
                + "is not within the valid range");
        while (i < position && headCopy != null){
            headCopy = headCopy.getNext();
            i++;
        }
        if (headCopy != null){
            cursor = headCopy;
        }
        return (headCopy != null);
    }
    /**
     * This method returns a neatly formatted table of all information for
     * all the scheduled performances in PerformanceList.
     *
     * @return
     * a neatly formatted table of all information for all the
     * scheduled performances.
     */
    public String toString(){
        String s = "";
        int m = 0;
        if(cursor != null){
            s = String.format("%-10s%-5s%-26s%-26s%-15s%-10s%-10s\n", "Current",
                    "No.", "Performance Name", "Lead Performer Name", "Participants"
                    , "Duration", "Start Time");
            s += String.format("%-100s\n","------------------------------------"
                    + "----"+ "--------------------------------------------"
                    + "------------------");
            String n = "";
            PerformanceNode headCopy = head;
            while((headCopy.getNext() != null && m ==0) || (headCopy == tail &&
                    m == 0)){
                if(headCopy == cursor || (headCopy == tail && tail == cursor)){
                    n = "*";
                }
                s += headCopy.toString(n);
                n = "";
                if(headCopy != tail){
                    headCopy = headCopy.getNext();
                }
                else{
                    m = 1;
                }
            }
        }
        else{
            s += "Error: there are no nodes to display";
        }
        return s;
    }
}
