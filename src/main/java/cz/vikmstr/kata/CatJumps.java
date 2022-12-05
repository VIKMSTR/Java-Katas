package cz.vikmstr.kata;

public class CatJumps {
    public static int solution(int start, int finish)
    {
        var jumps = 0;
        var i = start;
        while( i < finish){
           jumps++;
           if (i+1 <= finish){
               i++;
               if (i+2 <= finish){
                   i+=2;
               }
           }
       }
        return jumps;
        //int diff = (finish - start);
        //return diff/3 + diff % 3;
    }

}
