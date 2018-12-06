package totaltilecost.ui;
import javax.swing.*;
import java.awt.*;

/**
 * UserInterface for the program. Uses the flexible SpringLayout
 * @author vikasshukla
 */
public class UserInterface implements Runnable{
    private JFrame frame;
    
    public void run(){
        this.frame = new JFrame("Cost of Tiles");                          // Creates frame with title
        this.frame.setPreferredSize(new Dimension(300,200));               // Sets dimension of window
        
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// Makes sure program closes properly
        createComponents(this.frame.getContentPane());                     // Places the components 
        
        this.frame.pack();                                                 // Packs everything tidy
        this.frame.setVisible(true);
    }
    
    public void createComponents(Container container){
        // Creates SpringLayout and sets it 
        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);
        
        // Creates the height label
        JLabel height = new JLabel("Height (in feet): ");
        container.add(height);
        layout.putConstraint(SpringLayout.WEST, height, 25, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, height, 9, SpringLayout.NORTH, container);
        
        // Creates the interactive height text field 
        JTextField heightValue = new JTextField("0");
        container.add(heightValue);
        layout.putConstraint(SpringLayout.WEST, heightValue, 5, SpringLayout.EAST, height);
        layout.putConstraint(SpringLayout.NORTH, heightValue, 5, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.EAST, container, 25, SpringLayout.EAST, heightValue);
        
        // Creates the width label
        JLabel width = new JLabel("Width   (in feet): ");
        container.add(width);
        layout.putConstraint(SpringLayout.WEST, width, 25, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, width, 15, SpringLayout.SOUTH, height);
        
        // Creates the interactive width text field 
        JTextField widthValue = new JTextField("0");
        container.add(widthValue);
        layout.putConstraint(SpringLayout.WEST, widthValue, 3, SpringLayout.EAST, width);
        layout.putConstraint(SpringLayout.NORTH, widthValue, 5, SpringLayout.SOUTH, heightValue);
        layout.putConstraint(SpringLayout.EAST, widthValue, -25, SpringLayout.EAST, container);
        
        // Creates the price per square foot label
        JLabel pricePerSquare = new JLabel("Cost per Square Ft: ");
        container.add(pricePerSquare);
        layout.putConstraint(SpringLayout.WEST, pricePerSquare, 4, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, pricePerSquare, 15, SpringLayout.SOUTH, width);
        
        // Creates the interactive price per sqft field
        JTextField priceValue = new JTextField("0");
        container.add(priceValue);
        layout.putConstraint(SpringLayout.WEST, priceValue, 3, SpringLayout.EAST, width);
        layout.putConstraint(SpringLayout.NORTH, priceValue, 5, SpringLayout.SOUTH, widthValue);
        layout.putConstraint(SpringLayout.EAST, priceValue, -25, SpringLayout.EAST, container);
        
        // Creates the total cost label
        JLabel totalPrice = new JLabel("Total Cost: ");
        container.add(totalPrice);
        layout.putConstraint(SpringLayout.WEST, totalPrice, 54, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, totalPrice, 15, SpringLayout.SOUTH, pricePerSquare);
        
        // Creates the interactive total value field 
        JTextField totalValue = new JTextField("0");
        totalValue.setEnabled(false);
        container.add(totalValue);
        layout.putConstraint(SpringLayout.WEST, totalValue, 3, SpringLayout.EAST, width);
        layout.putConstraint(SpringLayout.NORTH, totalValue, 5, SpringLayout.SOUTH, priceValue);
        layout.putConstraint(SpringLayout.EAST, totalValue, -25, SpringLayout.EAST, container);
        
        // Creates the interactive button to calculate total cost
        JButton calculateButton = new JButton("Calculate");
        container.add(calculateButton);
        layout.putConstraint(SpringLayout.WEST, calculateButton, 150, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, calculateButton, 5, SpringLayout.SOUTH, totalValue);
        
        // Gives function to the button
        CalculateClicker clicker = new CalculateClicker(widthValue, heightValue, priceValue, totalValue, calculateButton);
        calculateButton.addActionListener(clicker);
    }
    
    
    
}
