import java.util.ArrayList;
class MitProgram{
    public static void main(String[]args){
        int antal = 10000000;

        ArrayList<Integer> liste = new ArrayList<Integer>();
        for (int i = 1;i<=antal;i++) {
            liste.add(i);
        }

        long timeBefore = System.currentTimeMillis();
        int Index = findNummer(liste,antal);
        long timeAfter = System.currentTimeMillis();
        long timePassed = timeAfter-timeBefore;

        long timeBefore2 = System.currentTimeMillis();
        int Index2 = binarysearch(liste,antal);
        long timeAfter2 = System.currentTimeMillis();
        long timePassed2 = timeAfter2-timeBefore2;

        System.out.println("Lineær tog " + timePassed + " millisekunder.");
        System.out.println("Svaret er " + Index);
        System.out.println("Binær tog " + timePassed2 + " millisekunder.");
        System.out.println("Svaret er " + Index2);
    }


    static int findNummer(ArrayList<Integer> liste, int tal){
        for (int i = 0;i < liste.size() ;i++) {
            if (liste.get(i)== tal) {
                return i;
            }
        }
        return -1;
    }


    static int binarysearch(ArrayList<Integer> liste, int tal){
        int lowerBound = 1;
        int upperBound = liste.size();
        while (true){
            if (upperBound < lowerBound){
                return -1;
            }
            int midPoint = lowerBound + (upperBound - lowerBound)/2;
            if (liste.get(midPoint) < tal){
                lowerBound = midPoint + 1;
            }
            if (liste.get(midPoint) > tal){
                upperBound = midPoint - 1;
            }
            if (liste.get(midPoint) == tal){
                return midPoint;
            }
        }
    }
}
