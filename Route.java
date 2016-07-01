import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.StringBuilder;
import java.util.Random;

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


    Route(int theSeqNum) {
        instantiations();

        mySeqNum = theSeqNum;
        myTime = dateFormat.format(cal.getTime());
        myCost = myRand.nextInt(99) + 1;
        myPortNumber = "E3";

        do {
            myDevice = ipGenerator();
            myDestAddress = ipGenerator();
        } while (myDevice.equals(myDestAddress));
    }



    Route(String theDest, String thePort, int theSeqNum) {
        instantiations();
        myDestAddress = theDest;
        myCost = myRand.nextInt(15);
        myPortNumber = thePort;
        mySeqNum = theSeqNum;
        myTime = dateFormat.format(cal.getTime());
        myDevice = ipGenerator();
    }

    private void instantiations() {
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        cal = Calendar.getInstance();
        myRand = new Random();
    }

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
