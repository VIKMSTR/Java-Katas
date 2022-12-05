package cz.vikmstr.kata;

public class RomanEncoder {
    public String solution(int n) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        // Calculate the individual digits of the number
        int thousand = n / 1000;
        int hundred = n / 100 % 10;
        int ten = n / 10 % 10;
        int one = n % 10;

        // Use the arrays to convert the digits to Roman numerals
        String romanNum = thousands[thousand] + hundreds[hundred] + tens[ten] + ones[one];

        return romanNum;
//        String[] thousands = {"", "M", "MM", "MMM"};
//        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//
//        int thousand = n / 1000;
//        int hundred = n / 100 % 10;
//        int ten = n / 10 % 10;
//        int one = n % 10;
//
//
//        var Ms = n / 1000;
//        var Ds = (n % 1000) / 500;
//        var Cs = ((n % 1000) > 500) ?  (n%1000- 500) / 100 : (n % 1000)/100;
//        var Ls = (n % 100) / 50;
//        var Xs = ((n % 100) > 50) ? (n%100-50)/10: n%100 / 10;
//        var Vs = (n%10) / 5;
//        var Is = (n%10 > 5) ? (n%10) - 5 : n%10;
//
//        var buff = new StringBuffer();
//        buff.append("M".repeat(Math.max(0, Ms)));
//        buff.append("D".repeat(Math.max(0, Ds)));
//        buff.append("C".repeat(Math.max(0, Cs)));
//        buff.append("L".repeat(Math.max(0, Ls)));
//        buff.append("X".repeat(Math.max(0, Xs)));
//        buff.append("V".repeat(Math.max(0, Vs)));
//        buff.append("I".repeat(Math.max(0, Is)));
//
//        var dirty = buff.toString();
//        var sanitized = dirty
//                .replace("DCCCLXXXXVIII","IM")
//                .replace("CCCCLXXXXVIIII","ID")
//                .replace("LXXXXVIIII", "IC")
//                .replace("XXXXVIIII", "IL")
//                .replace("VIIII", "IX")
//                .replace("CCCC","CD")
//                .replace("XXXX","XL")
//                .replace("IIII","IV");
//        return sanitized;
    }
}
