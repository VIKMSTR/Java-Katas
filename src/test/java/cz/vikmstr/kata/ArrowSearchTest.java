package cz.vikmstr.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrowSearchTest {

    @Test
    void searchArrows() {
        assertEquals(1, ArrowSearch.searchArrows(">."));
        assertEquals(2, ArrowSearch.searchArrows("->"));
        assertEquals(-3, ArrowSearch.searchArrows("<--.."));
        assertEquals(-2, ArrowSearch.searchArrows("><=><--"));
        assertEquals(11, ArrowSearch.searchArrows(">===>->"));
        assertEquals(0, ArrowSearch.searchArrows("......"));
        assertEquals(0, ArrowSearch.searchArrows("<-->"));
        assertEquals(3, ArrowSearch.searchArrows("-->"));
        assertEquals(0, ArrowSearch.searchArrows("<>"));
        assertEquals(-8, ArrowSearch.searchArrows("<==="));
    }
}

/*
private static int walkRight(int index, String string) {
        var points = 0;
        if (index != string.length()-1) {
            var firstSign = string.charAt(index +1);
            if (firstSign =='.' || firstSign == '>' || firstSign == '<'){
                return 1;
            }else{
                points += score(firstSign)*2;
                for(int i = index +2; i <= string.length()-1; i++){
                    var currChar = string.charAt(i);
                    if (currChar != firstSign) {
                        return points;
                    }
                    points +=score(currChar);
                }
            }
        }else{
            return 1;
        }
        return points;
    }

    private static int walkLeft(int index, String string) {
        var points = 0;
        if (index != 0) {
            var firstSign = string.charAt(index -1);
            if (firstSign =='.' || firstSign == '>' || firstSign == '<'){
                return 1;
            }else{
                points += score(firstSign)*2;
                for(int i = index -2; i >=0; i--){
                    var currChar = string.charAt(i);
                    if (currChar != firstSign) {
                        return points;
                    }
                    points +=score(currChar);
                }
            }
        }else{
            return 1;
        }
        return points;
    }
 */