package cz.vikmstr.kata;

import java.util.Arrays;

public class LondonCityHacker {

    /** Contains partial result of summing operation
     * @param lastBus was last line bus or tube
     * @param totalFare accumulated partial result of fare
     */
    record State (boolean lastBus, double totalFare){};
    public static String londonCityHacker(Object[] journey) {
        //code me up baby!
        var result = (State) Arrays.stream(journey)
                .sequential()
                .reduce(new State(false,0.00), LondonCityHacker::computeRide);
        return String.format("£%2.2f", result.totalFare);
        //coded baby!
    }


    /** Reduce method, that accumulates total fare for the whole ride.
     * @param s State object, that accumulates fare and contains info about last ride (partial result)
     * @param o current ride
     * @return Updated state with information from current ride
     */
    static State computeRide(Object s, Object o){
        var state = (State) s;
        if (o instanceof String) { // tube station
            return new State(false, state.totalFare+2.40);
        }
        if (o instanceof Integer){ //bus station
            var fare = state.lastBus ? state.totalFare : state.totalFare+1.50;
            return new State(!state.lastBus,fare);
        }
        return state;
    }
}
