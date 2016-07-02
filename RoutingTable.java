import java.util.ArrayList;
import java.util.Random;

public class RoutingTable {
    private ArrayList<Route> myRoutes;
    private Random myRandom;
    private int mySequenceNumber;

    public RoutingTable() {
        init();
    }

    private void init() {
        mySequenceNumber = 1;
        myRoutes = new ArrayList<Route>();
        myRoutes.add(new Route("0.0.0.0       ", "E1", mySequenceNumber++));
        myRandom = new Random();
    }

    public void run() {
        while (true) {
            int rand = myRandom.nextInt(12); // 0 to 11
            // Print data to console.
            print();
            if (rand % 3 == 0 && myRoutes.size() > 1) {
                int randomIndex = myRandom.nextInt(myRoutes.size() - 1) + 1;
                int oldSeqNum = myRoutes.get(randomIndex).getSeqNum();
                // Update, the route has now been input again.
    			myRoutes.get(randomIndex).updateTime();
                myRoutes.get(randomIndex).setSeqNum(mySequenceNumber++);
                myRoutes.get(randomIndex).setStatus("Active");
                System.out.println("UPDATING - SEQ#: " + oldSeqNum + " to " + myRoutes.get(randomIndex).getSeqNum());
            } else if (rand % 5 == 0 && myRoutes.size() > 1) {
                // Set a random route to inactive. Excluding the gateway.
                int randomIndex = myRandom.nextInt(myRoutes.size() - 1) + 1;
                myRoutes.get(randomIndex).setStatus("Inactive");
                System.out.println("SETTING INACTIVE - SEQ#: " + myRoutes.get(randomIndex).getSeqNum());
            } else if(rand == 11 && myRoutes.size() > 1){
            	// Remove inactive routes
            	for (int index = 1; index < myRoutes.size(); index++) {
                    if (myRoutes.get(index).getStatus().equals("Inactive")) {
                        System.out.println("REMOVING INACTIVE - SEQ#: " + myRoutes.get(index).getSeqNum());
                        myRoutes.remove(index);
                    }
                }
            } else {
                System.out.println("ADDING NEW ROUTE - SEQ#: " + mySequenceNumber);
                // Add a new route.
                Route r1 = new Route(mySequenceNumber++);
                if (myRoutes.size() == 1) {
                    myRoutes.add(r1);
                } else {
                    boolean bool = true;
                    for (int a = 0; a < myRoutes.size(); a++) {
                        if (myRoutes.get(a).equals(r1)) {
                            bool = bool & false;
                        }
                    }
                    if (bool) myRoutes.add(r1);
                }
            }

            // Delay for visual recognition.
            try {
                Thread.sleep(4000);
            } catch(Exception e) {}
        }
    }

    private void print() {
        System.out.println("\n------------------------------------------------------------------------------------------------");
        System.out.println("Seq # \t\t Time \t\t Destination \t       Metric    Port     Device       Status");
        for (Route r : myRoutes) {
            System.out.println(r);
        }
        System.out.println("------------------------------------------------------------------------------------------------\n");
    }
}
