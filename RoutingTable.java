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


            if (i % 10 == 0) {
                // Update
            } else if (i % 13 == 0) {
                // remove
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
        System.out.println("\nSeq # \t\t Time \t\t Destination \t       Metric    Port     Device");
        for (Route r : myRoutes) {
            System.out.println(r);
        }

    }
}
