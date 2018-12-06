package totaltilecost.ui;
import javax.swing.*;
import java.awt.event.*;
import totaltilecost.logic.Logic;
/**
 * Gives function to the button to calculate total costs. Takes in value from all text fields
 * and manipulates logic to return the total cost
 * @author vikasshukla
 */
public class CalculateClicker implements ActionListener{
    private JTextField width;
    private JTextField height;
    private JTextField cost;
    private JTextField total;
    private JButton calcButton;
    private Logic logic;
    
    
    // Constructor that takes in every textfield and button
    public CalculateClicker(JTextField width, JTextField height, JTextField cost,
            JTextField total, JButton calcButton ){
        this.width      = width;
        this.height     = height;
        this.cost       = cost;
        this.total      = total;
        this.calcButton = calcButton;
        this.logic      = new Logic();
    }
    
    
    // converts textfields to doubles and uses logic to display total
    public void actionPerformed(ActionEvent ae){
        double width     = Double.parseDouble(this.width.getText());     // converts width to double
        double height    = Double.parseDouble(this.height.getText());    // converts height to double
        double cost      = Double.parseDouble(this.cost.getText());      // converts cost to double
        String totalCost = this.logic.findTotalCost(height, width, cost);// uses logic to find Total Cost
        this.total.setText(totalCost);                                   // sets TextField with the value
    }
}
