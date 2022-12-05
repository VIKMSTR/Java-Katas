package cz.vikmstr.kata;

public class RomanEncoder {
    public String solution(int n) {
        // map digit to roman digit
        //                       0    1    2      3      4    5     6     7       8      9
        String[] thousands =    {"", "M", "MM", "MMM"};
        String[] hundreds =     {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens =         {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones =         {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        // Calculate the individual digits of the number
        int thousand = n / 1000;
        int hundred = n / 100 % 10;
        int ten = n / 10 % 10;
        int one = n % 10;

        // Use the arrays to convert the digits to Roman numerals
        return thousands[thousand] + hundreds[hundred] + tens[ten] + ones[one];
    }
}
