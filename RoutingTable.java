import java.util.ArrayList;

public class RoutingTable {

    private static String HostName;
    private static ArrayList<Route> myRoutes;

    public static void main(String[] theArgs) {
        init();
        run();
    }

    private static void init() {
        HostName = "OurRouter";

        myRoutes = new ArrayList<Route>();
        myRoutes.add(new Route("0.0.0.0       ", 5, "E1", myRoutes.size() + 1, "93.12.45.75"));
        myRoutes.add(new Route("2.4.6.120/24", 3, "E3", myRoutes.size() + 1, "3.14.25.10"));
        myRoutes.add(new Route("20.10.48.66/20", 8, "E3", myRoutes.size() + 1, "5.14.35.10"));
        myRoutes.add(new Route("19.20.21.128/15", 1, "E3", myRoutes.size() + 1, "3.24.25.19"));
        myRoutes.add(new Route("10.35.68.20/19", 12, "E3", myRoutes.size() + 1, "7.64.24.16"));
        myRoutes.add(new Route("129.16.80.72/18", 100, "E3", myRoutes.size() + 1, "1.29.5.70"));
        myRoutes.add(new Route("88.62.113.91/6", 50, "E3", myRoutes.size() + 1, "67.34.25.90"));
        myRoutes.add(new Route("38.42.121.48/10", 7, "E3", myRoutes.size() + 1, "6.18.65.40"));
        myRoutes.add(new Route("4.18.10.16/21", 18, "E3", myRoutes.size() + 1, "3.34.85.14"));
        myRoutes.add(new Route("1.30.151.64/23", 32, "E3", myRoutes.size() + 1, "3.24.55.60"));
        myRoutes.add(new Route("8.132.64.57/12", 91, "E3", myRoutes.size() + 1, "9.74.26.80"));
    }


    private static void run() {
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
                Thread.sleep(1000);
            } catch(Exception e) {}
        }
    }


    private static void print() {
        System.out.println("Seq # \t\t Time \t\t Destination \t       Cost    Port     Device");
        for (Route r : myRoutes) {
            System.out.println(r);
        }

    }
}
