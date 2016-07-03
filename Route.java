import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.StringBuilder;
import java.util.Random;
/**
 * Route class that developes our route table and values:
 * Desintation, sequence number, time, and port number.
 * 
 * @author team 3
 * @version 1
 */
 
public class Route {
    DateFormat dateFormat;
    Calendar cal;
    int mySeqNum; // Index in routing table
    String myTime; // Date added
    String myDestAddress; //
    String myPortNumber;
    int myCost; //hops
    String myDevice;
    Random myRand;
    String myStatus;

/**
 * Countructor that intializes our main variables.
 */
    Route(int theSeqNum) {
        instantiations();

        mySeqNum = theSeqNum;
        myTime = dateFormat.format(cal.getTime());
        myCost = myRand.nextInt(99) + 1;
        myPortNumber = "E3";
        myStatus = "Active";
        do {
            myDevice = ipGenerator();
            myDestAddress = ipGenerator();
        } while (myDevice.equals(myDestAddress));
    }


/**
 * Countructor that intializes our main variables with a random number generator
 * 
 * @param theDest the destination IP address
 * @param thePort number that destination is from
 * @param theSeqNum the number to keep track of the entries
 */
    Route(String theDest, String thePort, int theSeqNum) {
        instantiations();
        myDestAddress = theDest;
        myCost = myRand.nextInt(15);
        myPortNumber = thePort;
        mySeqNum = theSeqNum;
        myTime = dateFormat.format(cal.getTime());
        myDevice = ipGenerator();
        myStatus = "Active";
    }
/**
 * In this method it instantiates the time aspect of our table value.
 */
    private void instantiations() {
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        cal = Calendar.getInstance();
        myRand = new Random();
    }
/**
 * This method randomly generates IP addresses.
 * 
 * @return string of randomaly added IP address
 */
    private String ipGenerator() {
        StringBuilder sb = new StringBuilder();
        sb.append((myRand.nextInt(254) + 1));
        sb.append('.');
        sb.append((myRand.nextInt(254) + 1));
        sb.append('.');
        sb.append((myRand.nextInt(254) + 1));
        sb.append('.');
        sb.append((myRand.nextInt(254) + 1));

        return sb.toString();

        // return "N/A";
    }
/**
 * Determing if the route is already in the table by checking the destination
 * cost, and port number before it gets added to the table.
 * 
 * @param theRoute a certain route
 */
    public boolean equals(Route theRoute) {
        boolean bool = true;
        bool = bool & myDestAddress.equals(theRoute.getDestination());
        bool = bool & (myCost == theRoute.getCost());
        bool = bool & myPortNumber.equals(theRoute.getPort());
        bool = bool & myDevice.equals(theRoute.getMyDevice());
        return bool;
    }
/**
 * This method builds the table using string builder.
 * 
 * @return the string of the table 
 */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mySeqNum + "\t");
        sb.append(myTime + "\t");
        sb.append(myDestAddress + "\t\t");
        sb.append(myCost + "\t");
        sb.append(myPortNumber + "\t");
        sb.append(myDevice+"\t");
        sb.append(myStatus);
        return sb.toString();
    }
//setting the status
    public void setStatus(String theStatus){
    	myStatus = theStatus;
    }
//getting the status

    public String getStatus(){
    	return myStatus;
    }
//getting the destination

    public String getDestination(){
    	return myDestAddress;
    }
//setting the destination

    public void setDestination(String theDestination){
    	myDestAddress = theDestination;
    }
//getting the port
    public String getPort(){
    	return myPortNumber;
    }
//setting the port
    public void setPort(String thePortNumber){
    	myPortNumber = thePortNumber;
    }
//getting the cost
    public int getCost(){
    	return myCost;
    }
//setting the cost
    public void setCost(int theCost){
    	myCost = theCost;
    }
//getting the device
    public String getMyDevice(){
    	return myDevice;
    }
//setting the device
    public void setMyDevice(String theDevice){
    	myDevice = theDevice;
    }
//getting the time
    public String getMyTime(){
    	return myTime;
    }
//setting the time
    public void updateTime(){
    	myTime = dateFormat.format(cal.getTime());
    }
//getting the sequence num
    public int getSeqNum() {
        return mySeqNum;
    }
//setting the sequence number
    public void setSeqNum(int theSeqNum) {
        mySeqNum = theSeqNum;
    }
}
