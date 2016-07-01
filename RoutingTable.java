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


        System.out.println("\nSeq # \t\t Time \t\t Destination \t       Metric    Port     Device");
        for (Route r : myRoutes) {
            System.out.println(r);
        }

    }
}
