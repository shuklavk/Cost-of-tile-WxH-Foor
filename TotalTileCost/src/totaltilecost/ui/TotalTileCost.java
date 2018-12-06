package totaltilecost.ui;
import javax.swing.SwingUtilities;
/**
 * Program takes input of height, width, and cost per square foot to return the total
 * cost of the tiles. Contains 4 text fields, where 3 are interactive. There is also
 * one button to start the program.
 * @author vikasshukla
 */
public class TotalTileCost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new UserInterface());
    }
    
}
