class Solution {
    public String intToRoman(int num) {
        
        String ones[] = {"","I", "II", "III", "IV", "V", "VI", "VII","VIII", "IX"};
        
        String tens[] = {"","X","XX","XXX", "XL", "L", "LX", "LXX","LXXX", "XC"};
        
        String hundreds[] = {"","C","CC","CCC", "CD", "D", "DC", "DCC","DCCC","CM"};
        
        String thous[] = {"","M","MM","MMM"}; //remember onlu 3999 roman 
        
        
        
        //1345        1 =M             345 and  3=> ccc         45 and 4=>XL.   
         return thous[num/1000] + hundreds[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
        
        
    }
}


// 1356
// 1                   345, 3            45,5 
// return num/1000  +() num%1000)/100 +  num/%100/10 + num%10