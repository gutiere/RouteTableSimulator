import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.StringBuilder;

public class Route {
    DateFormat dateFormat;
    Calendar cal;
    int mySeqNum; // Index in routing table
    String myTime; // Date added
    String myDestAddress; //
    String myPortNumber;
    int myCost; //hops
    String myDevice;


    Route(int theSeqNum) {
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        cal = Calendar.getInstance();
        //myDestAddress = theDest;
        //myCost = theCost;
        //myPortNumber = thePort;
        mySeqNum = theSeqNum;
        myTime = dateFormat.format(cal.getTime());
        //myDevice = theDevice;
    }

    Route(String theDest, int theCost, String thePort, int theSeqNum, String theDevice) {
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        cal = Calendar.getInstance();
        myDestAddress = theDest;
        myCost = theCost;
        myPortNumber = thePort;
        mySeqNum = theSeqNum;
        myTime = dateFormat.format(cal.getTime());
        myDevice = theDevice;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mySeqNum + "\t");
        sb.append(myTime + "\t");
        sb.append(myDestAddress + "\t\t");
        sb.append(myCost + "\t");
        sb.append(myPortNumber + "\t");
        sb.append(myDevice);
        return sb.toString();
    }

}
