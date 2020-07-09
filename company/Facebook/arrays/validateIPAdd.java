class Solution {
    public String validIPAddress(String IP) {
        //Testcase
        //leading zero
        //ipv6 :
        //ipv4 .
        //ending . shud not be in ipv4
        //no leading 0 in ipv6 as well
        // only 3 digits 0-255
        //only 4 difits numbers and alph

        
        int count = 0;
        
        if(IP.indexOf(':') == -1){ //meaning IPV4
            for (String s: IP.split("\\.")){
                ++count;
                if(count > 4 || s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0') || s.length() > 3)
                    return "Neither";
                for (char c : s.toCharArray()){
                    if(c < '0' || c > '9')
                        return "Neither";
                }
                int val = Integer.parseInt(s);
                if(val < 0 || val >255)
                    return "Neither";
                
            }
            return (count==4 && IP.charAt(IP.length()-1) != '.') ?"IPv4" :"Neither";
            
        }
        else{ // meaning IPV6
            
             for (String p: IP.split(":")){
                ++count;
                if(count > 8 || p.isEmpty() || p.length() > 4)
                    return "Neither";
                for (char c : p.toCharArray()){
                    if(!(c >= '0' && c <='9') && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F'))
                        return "Neither";
                }
                
            }
            return (count==8 && IP.charAt(IP.length() - 1) != ':') ? "IPv6" :"Neither";
        }
    }
}



// // Test cases
// 1. Check if it : or .( based on that if and else // indexOf() == -1)
// 2. maintain count (4 or 8) depnds on ipv4or 6
// 3. For IPv4  check count>4 or leading zro if more difits than one or more than three digits , then check if every charcater within string is < '0 ||c >'9
//       Also convert string to Int using INteger.parseInt and check if val is <0 and val > 255 for invalid


// 4. for ipv6, check count > 8, and length of difits greater than 4
// and charcater check for hex decimal

T: o((length of string)
S: 0(1))