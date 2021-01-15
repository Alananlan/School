package Quiz9b;
/*
Alan Ly
Prof. Iverson
CS211
13 January 2021
 */

public class IPhone implements Asset {

    public static final double annualDepreciation = 0.2;
    private double originalCost;
    private int currentAge;

    public IPhone(double originalCost, int currentAge) {
        this.originalCost = originalCost;
        this.currentAge = currentAge;
    }

    public IPhone() {

        this(0,0);

    }

    public double getProfit() {
        if (currentAge == 0) {
            return 0.0;
        }
        return (originalCost * Math.pow((1 - annualDepreciation), currentAge)) - originalCost;
    }
    public double getMarketValue(){
       if (currentAge == 0) {
           return originalCost;
       }
        return originalCost + getProfit();
    }


    public String toString() {
        return "IPhone ( " + currentAge + " years old )";

    }
}
