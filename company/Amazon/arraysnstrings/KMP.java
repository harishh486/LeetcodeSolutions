import java.util.*;

class Program {
  public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
    // Write your code here.
		// build a pattern array table witgh indices for sub string only 
		//optimize substring leave abt main string becos we repeat the same seraching many times in substring
		
		int[] pattern = buildPattern(substring);
    return doesMatch(string, substring, pattern);
  }
	public static int[] buildPattern(String substring){
		// create array first
		int  pattern[] = new int[substring.length()];
		int j=0;
		int i=1;
		
		Arrays.fill(pattern, -1);
		//most important take way , when u compare tyhe same things within array , indices will be one less than other
		
		while(i< substring.length()){
			// if both char at different indix match then u write where it matched
			
			//aabcd
			//ji
			if(substring.charAt(i) == substring.charAt(j)){
				pattern[i]=j;
				i++;
				j++;
			}else if(j>0){
				j= pattern[j-1]+1; //go back to previous element in j and get the index of that and compare the next index one
				//|
			//<
				// find index
				//compare next one
				
			}else {
				i++;
			}
			
		}
		return pattern;
	}
  public static boolean doesMatch(String s, String t, int[] pattern){
		//here we wiill compare original and substring and index does not have to be one after the other
		//index can be same
		int i=0;
		int j=0;
		while(i + t.length()-j<= s.length()){
			if(s.charAt(i) == t.charAt(j)){
				if(j == t.length()-1)
					return true;
				i++;
				j++;
			}else if(j >0){
				j=pattern[j-1]+1;
			} else {
				i++;
			}
		}
		return false;
	}
}


class ProgramTest {
    @Test
    public void TestCase1() {
      Utils.assertTrue(Program.knuthMorrisPrattAlgorithm("aefoaefcdaefcdaed", "aefcdaed") == true);
    }
  }


  //T: 0(m+n)// can be improved 
  //no back trcking of index i in string 1 and also j only goes to initial if its worst case
  //Spce: o(m)--m to fill the table
  