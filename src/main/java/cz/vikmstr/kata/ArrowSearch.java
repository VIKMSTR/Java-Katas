package cz.vikmstr.kata;

import java.util.ArrayList;
import java.util.List;

public class ArrowSearch {

    public static int searchArrows(String string) {
        var forwards = ArrowSearch.getAllIndexes(string,'>');
        var backwards = ArrowSearch.getAllIndexes(string,'<');
        var forwardPoints = ArrowSearch.countForward(string, forwards);
        var backwardPoints = ArrowSearch.countBackward(string, backwards);
        return forwardPoints - backwardPoints;
    }

    /** Counts all backward arrows
     * @param string input string
     * @param backwards indexes of all backward arrows
     * @return negative points total
     */
    static int countBackward(String string, List<Integer> backwards) {
        return backwards.stream().map(index -> ArrowSearch.walkRight(index,string)).reduce(0, Integer::sum);
    }

    /** Counts all forward arrows
     * @param string input string
     * @param forwards indexes of all forward arrows
     * @return positive points total
     */
    static int countForward(String string, List<Integer> forwards) {
        return forwards.stream().map(index -> ArrowSearch.walkLeft(index,string)).reduce(0, Integer::sum);
    }

    /** Scans chars rightwards from the arrow
     * @param index starting index in the string
     * @param string input string
     * @return points for one arrow
     */
    private static int walkRight(int index, String string){
        if (index != string.length()-1) {
           var firstSign = string.charAt(index+1);
           return switch (firstSign){
                case '.', '>','<' ->  1;
                default -> scoreRight(index,string,firstSign);
            };
        }else return 1;
    }

    /** Scores points for one arrow in rightward direction
     * @param index starting index in the string
     * @param string input string
     * @param firstSign starting sign for the arrow (-/=)
     * @return points for the one arrow scanned
     */
    private static int scoreRight(int index, String string, char firstSign){
        var points = score(firstSign)*2;
        for(int i = index +2; i <= string.length()-1; i++){
            var currChar = string.charAt(i);
            if (currChar != firstSign) {
                return points;
            }
            points +=score(currChar);
        }
        return points;
    }

    /** Scans chars leftwards from the arrow
     * @param index starting index in the string
     * @param string input string
     * @return points for one arrow
     */
    private static int walkLeft(int index, String string){
        if (index != 0) {
            var firstSign = string.charAt(index-1);
            return switch (firstSign){
                case '.', '>','<' ->  1;
                default -> scoreLeft(index,string,firstSign);
            };
        }else return 1;
    }

    /** Scores points for one arrow in leftward direction
     * @param index starting index in the string
     * @param string input string
     * @param firstSign starting sign for the arrow (-/=)
     * @return points for the one arrow scanned
     */
    private static int scoreLeft(int index, String string, char firstSign){
        var points = score(firstSign)*2;
        for(int i = index -2; i >=0; i--){
            var currChar = string.charAt(i);
            if (currChar != firstSign) {
                return points;
            }
            points +=score(currChar);
        }
        return points;
    }

    /** Scores point based on character
     * @param ch arrow element for scoring
     * @return point for one char
     */
    static int score(char ch){
        return switch (ch) {
            case '-' -> 1;
            case '=' -> 2;
            default -> 0;
        };
    }

    /** Finds all indexes of a char occurrence in input string
     * @param string string to scan
     * @param sign character to find
     * @return list of indexes where the character is located
     */
    static List<Integer> getAllIndexes(String string, Character sign){
        var indexes = new ArrayList<Integer>();
        for (int index = string.indexOf(sign); index >= 0; index = string.indexOf(sign, index + 1))
        {
            indexes.add(index);
        }
        return indexes;
    }

}
