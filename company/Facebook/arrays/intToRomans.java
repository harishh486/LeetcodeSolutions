class Solution {
    public String intToRoman(int num) {
        
        // normal values I,V,X,L,C,D,M // 1,5,10,50,100,500,1000
        
        // SPL VALUES IX,IV, XL,XC,CD,DM// 4,9,40,90,400,900
        //INITIALIZE ARrray with decresing prder of seq
        int []arabicnums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        String []romans = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        //main logic is sub orignal num with all the values within aravics and check if result>0 and add that respective subratcted version of roman into result ...continue till it reacges zero
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i< arabicnums.length;i++){
            
            while(num -arabicnums[i] >= 0 ) {
                
                sb.append(romans[i]); //append 
                num = num - arabicnums[i]; //sub
                
            }
            
        }
        
        return sb.toString();
        
    }
}


//Accepted
// we need to maintain a dict to have all and spl values : one int array for arabics and string array for romans
//both shud be in decreasing order: key here is maintain the same index structure in both of this arrays 
// use sb to append strings since strings sre immutabale
// for num, iteracte over each aravic num and if its greater than or eq to 0 append correspendin  roman value to sb

//append before sub
