import java.util.ArrayList;

/**
 * Created by Matthew on 08/08/2017.
 */
public class PaintWizard {
    ArrayList<Paint> paints = new ArrayList<>();
    Room room = new Room(750);
    public static void main(String[] args) {
        PaintWizard paintWizard = new PaintWizard();
        paintWizard.printLeastWaste();
        paintWizard.printCheapestPaint();
    }

    public PaintWizard(){
        paints.add(new Paint("CheapoMax", 19.99, 20, 10));
        paints.add(new Paint("AverageJoes", 17.99, 15, 11));
        paints.add(new Paint("DuluxourousPaints", 25, 10, 20));
        paints.add(new Paint("Test Paint", 15.00, 5, 15));
    }

    public void printLeastWaste() {
        Paint leastWasted = new Paint("", 0, 0, 0);
        double wastes = paints.get(0).getCoverage();
        for (Paint p : paints) {
            //calculate how many paint pots are needed
            double potsNeeded = Math.ceil((room.getSquareMSize() / p.getCoverage()));
            if (wastes > (p.getCoverage() * potsNeeded) - room.getSquareMSize()) {
                wastes = (p.getCoverage() * potsNeeded) - room.getSquareMSize();
                leastWasted = p;
            }
        }
        System.out.println(leastWasted.getName() + " wastes the least with " + wastes + "m2 of paint wasted.");
    }

    public void printCheapestPaint(){
        double bestCost = 0;
        Paint bestCostPaint = new Paint("", 0, 0 ,0);
        for(Paint p:paints){
            //calculate how many paint pots are needed
            double potsNeeded = Math.ceil((room.getSquareMSize() / p.getCoverage()));
            //calculate which would be cheapest
            double cost = potsNeeded * p.getPrice();
            if(bestCost == 0) {
                bestCost = cost;
                bestCostPaint = p;
            }
            if(bestCost > cost){
                bestCost = cost;
                bestCostPaint = p;
            }
        }
        System.out.println(bestCostPaint.getName() + " is the cheapest at £" + bestCost);
    }
}
