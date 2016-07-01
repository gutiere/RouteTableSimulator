import javax.swing.JFrame;

public class Main {
    public static void main(String[] theArgs) {
        JFrame myFrame = new JFrame("Routing Table Simulator");
        RoutingTable myTable = new RoutingTable();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(myTable);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        myTable.run();
    }
}
