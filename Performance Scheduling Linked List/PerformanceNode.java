/**
 * @author Suheyla Ceyda Iyimaya
 */

/**
 * This class represents a performance node object.
 */
public class PerformanceNode {
    private String performanceName;
    private String leadName;
    private int totalParticipants;
    private int duration;
    private int startTime;
    private int no;
    private PerformanceNode next;
    private PerformanceNode prev;
    /**
     * This is a constructor used to create a new performance node object
     * @param performanceName
     * the name of the performance
     * @param leadName
     * the name of the lead performer
     * @param totalParticipants
     * total number of participants
     * @param duration
     * duration of the performance in minutes
     */
    public PerformanceNode(String performanceName, String leadName, int totalParticipants, int duration){
        next = null;
        prev = null;
        this.performanceName = performanceName;
        this.leadName = leadName;
        this.totalParticipants = totalParticipants;
        this.duration = duration;
        this.startTime = 0;
        this.no = 1;
    }
    /**
     *This method enables access to the position of the performance node
     *
     * @return
     * the position of the performance node
     */
    public int getNo(){
        return this.no;
    }

    /**
     *This method enables access to the performance name
     *
     * @return
     * the name of the performance
     */
    public String getPerformanceName(){
        return this.performanceName;
    }

    /**
     *This method enables access to the lead performer name
     *
     * @return
     * the name of the lead performer
     */
    public String getLeadName(){
        return this.leadName;
    }

    /**
     *This method enables access to total number of participants
     *
     * @return
     * total number of participants
     */
    public int getTotalParticipants(){
        return this.totalParticipants;
    }

    /**
     *This method enables access to the duration of the performance
     *
     * @return
     * the duration of the performance
     */
    public int getDuration(){
        return this.duration;
    }

    /**
     *This method enables access to the start time of the performance
     *
     * @return
     * the start time of the performance
     */
    public int getStartTime(){
        return this.startTime;
    }

    /**
     *This method enables access to the next performance node
     *
     * @return
     * the next performance node
     */
    public PerformanceNode getNext(){
        return this.next;
    }

    /**
     *This method enables access to the previous performance node
     *
     * @return
     * previous performance node
     */
    public PerformanceNode getPrev(){
        return this.prev;
    }

    /**
     * This method changes the position number of the performance node
     */
    public void setNo(){
        if(this.getPrev() != null){
            no = this.getPrev().getNo() + 1;
        }
        else{
            no = 1;
        }
    }

    /**
     *This method changes the performance name
     *
     * @param newPerformanceName
     * The new value for the performance name
     */
    public void setPerformanceName(String newPerformanceName){
        this.performanceName = newPerformanceName;
    }

    /**
     *This method changes the lead performer name
     *
     * @param newLeadName
     * The new value for the name of lead performer
     */
    public void setLeadName(String newLeadName){
        this.leadName = newLeadName;
    }

    /**
     *This method changes the number of participants
     *
     * @param newTotalParticipants
     * The new value for the total number of participants
     */
    public void setTotalParticipants(int newTotalParticipants){
        this.totalParticipants = newTotalParticipants;
    }

    /**
     *This method changes the duration of the performance
     *
     * @param newDuration
     * The new value for duration
     */
    public void setDuration(int newDuration){
        duration = newDuration;
    }

    /**
     * This method changes the start time of the performance node
     */
    public void setStartTime(){
        if(this.getPrev() != null){
            startTime = this.getPrev().getStartTime() + this.getPrev().getDuration();
        }
        else{
            startTime = 0;
        }
    }

    /**
     *This method sets the value of next node
     *
     * @param newNext
     * The new value of next node
     */
    public void setNext(PerformanceNode newNext){
        this.next = newNext;
    }

    /**
     *This method sets the value of previous node
     *
     * @param newPrev
     * The new value of the new previous node
     */
    public void setPrev(PerformanceNode newPrev){
        this.prev = newPrev;
    }

    /**
     *This method returns a String representation of performance node
     *
     * @param n
     * the cursor sign
     */
    public String toString(String n){
        String s = "";
        s+= String.format("%-10s%-5s%-26s%-26s%-15s%-10s%-10s\n", n, this.no,
                this.performanceName, this.leadName, this.totalParticipants,
                this.duration, this.startTime);
        return s;
    }
}
