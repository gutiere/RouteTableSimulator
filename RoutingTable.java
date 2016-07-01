import java.util.ArrayList;
import javax.swing.JPanel;

public class RoutingTable extends JPanel {
    private static ArrayList<Route> myRoutes;

    public RoutingTable() {
        init();
    }

    private static void init() {
        myRoutes = new ArrayList<Route>();
        myRoutes.add(new Route("0.0.0.0       ", "E1", myRoutes.size() + 1));
    }


    public static void run() {
        for (int i = 0; i < 1000; i++) {
        	Route r1 = new Route(myRoutes.size()+1);
            if (i % 10 == 0) {
                // Update
            	for(int a = 0; a < myRoutes.size();a++){
            		if(myRoutes.size() > i){
            			if(myRoutes.get(i).getDestination.equal(r1.getDestination && 
            					myRoutes.get(i).getPort().equal(r1.getPort() &&
            							myRoutes.get(i).getMyDevice.equal(r1.getMyDevice)))) {
            				
            				myRoutes.get(i).setTime(r1.getMyTime());
            				myRoutes.get(i).setCost(r1.getCost());
            				myRoutes.get(i).setStatus("Active");
            				break;
            			}
            		}
            	}
            } else if (i % 13 == 0) {
                // setinactive for the status
            	if(myRoutes.size()>i){
            		myRoutes.get(i).setStatus("Inactive");
            	}
            } else if(i %19 == 0){
            	//remove inactive link
            	if(myRoutes.size() > i && myRoutes.get(i).getStatus.equal("Inactive")){
            		myRoutes.remove(i);
            	}
            } else {
                // add
                myRoutes.add(new Route(myRoutes.size() + 1)); //Random add
            }

            print();
            try {
                Thread.sleep(2000);
            } catch(Exception e) {}
        }
    }


    private static void print() {
        System.out.println("\nSeq # \t\t Time \t\t Destination \t       Metric    Port     Device       Status");
        for (Route r : myRoutes) {
            System.out.println(r);
        }

    }
}
