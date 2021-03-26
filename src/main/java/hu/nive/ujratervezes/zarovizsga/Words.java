package hu.nive.ujratervezes.zarovizsga;

public class Words {

    public boolean hasMoreDigits(String s) {
           int countDigits = 0;
           int countOther = 0;

           for(char c : s.toCharArray()){
               if(Character.isDigit(c)){
                   countDigits++;
               }else{
                   countOther++;
               }
           }
    return countDigits-countOther>0;
    }
}
