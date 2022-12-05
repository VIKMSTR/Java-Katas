package cz.vikmstr.kata;

public class LondonCityHacker {
    public static String londonCityHacker(Object[] journey) {
        //code me up baby!
        var lastBus = false;
        var totalFare = 0.00;
        for(Object o: journey){
           if (o instanceof String) {
               totalFare += 2.40;
               lastBus = false;
           }else if (o instanceof Integer){
               if (!lastBus) {
                    totalFare += 1.50;
               }
               lastBus = !lastBus;
            }
        }
        return String.format("£%2.2f", totalFare);
    }
}
