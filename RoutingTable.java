import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class RoutingTable extends JPanel {
    private  ArrayList<Route> myRoutes;
    private GridLayout myGrid;
    private JScrollPane myScroller;
    private JLabel myLabel;

    public RoutingTable() {
        init();
    }

    private void init() {
        myRoutes = new ArrayList<Route>();
        myRoutes.add(new Route("0.0.0.0       ", "E1", myRoutes.size() + 1));



        // GUI stuff

        this.setPreferredSize(new Dimension(600, 400));
        myGrid = new GridLayout(2, 6);
        myLabel = new JLabel();
        myScroller = new JScrollPane(myLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        myScroller.setSize(new Dimension(600, 400));
        this.add(myScroller);
    }


    public void run() {
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

    private void print() {
        // GUI stuff

        // StringBuilder sb = new StringBuilder();
        // sb.append("<html>");
        // sb.append("<br>Seq # \t\t Time \t\t Destination \t       Metric    Port     Device<br>");
        // for (Route r : myRoutes) {
        //     sb.append(r + "<br>");
        // }
        // sb.append("</html>");
        // myLabel.setText(sb.toString());


        System.out.println("\nSeq # \t\t Time \t\t Destination \t       Metric    Port     Device       Status");
        for (Route r : myRoutes) {
            System.out.println(r);
        }
    }
}
