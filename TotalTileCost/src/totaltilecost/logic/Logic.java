package totaltilecost.logic;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
/**
 * This class creates the logic for this program. It takes care of the multiplication,
 * rounding to two decimal spots, and adding the dollar sign to the output 
 * @author vikasshukla
 */
public class Logic {
    
    public Logic(){
        
    }
    // Uses the height, width, and cost values to find the total cost of tiles
    // Returns a string that has a dollar sign in front of the value
    public String findTotalCost(double height, double width, double costPerSquareFeet){
        double area = height * width;
        double cost = area * costPerSquareFeet;
        Locale lc   = new Locale("en", "US");
        
        
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(lc);
        return currencyFormatter.format(round(cost, 2));                        // converts number to string with $ and rounded to 2 places
    }
    
    
    // Takes in a value and rounding places and returns value rounded
    public static double round(double value, int places){
        if(places < 0){
            throw new IllegalArgumentException();         // does not make sense to round to negative decimals
        }
        
        BigDecimal bd = new BigDecimal(value);            // converts to Big Decimal in case need a lot of decimal places
        bd = bd.setScale(places, RoundingMode.HALF_UP);   // rounds on this step
        return bd.doubleValue();                          // converts Big Decimal to double and returns rounded double
    }
    
}
