Anonymous class

--class to be used by only one time

1. How would you declare a class to be used only once?  —anonymous class

A a = new A(){
    Private show(){
        sops(Hi)
    }
}
a.show()

2. Single tone:
The purpose of the Singleton class is to control object creation,
 limiting the number of objects to only one. The singleton allows only one entry point to create the new instance of the class.

 public class SingletonClass {

    private static volatile SingletonClass sSoleInstance = new SingletonClass();

    //private constructor.
    private SingletonClass(){}

    public static SingletonClass getInstance() {
        return sSoleInstance;
    }
}

In eager initialization, the instance of Singleton Class is created at the time of class loading,
 this is the easiest method to create a Singleton class.


By making the constructor as private you are not allowing other class to create a new instance of the class you want to create the Singleton. 


public class SingletonClass {

    private static SingletonClass sSoleInstance;

    private SingletonClass(){}  //private constructor.

    public static SingletonClass getInstance(){
        if (sSoleInstance == null){ //if there is no instance available... create new one
            sSoleInstance = new SingletonClass();
        }

        return sSoleInstance;
    }
}Instead, you are creating one public static method (commonly name as for getInstance()) 
to provide the single entry point to create the new instance of the class.

Note:
Singleton pattern is used for logging, drivers objects, caching and thread pool.


3. print 3 greatest numbers in array in descending

void print3largest(int arr[], int arr_size) 
{ 
    int i, first, second, third; 
   
    /* There should be atleast three elements */
    if (arr_size < 3) 
    { 
        printf(" Invalid Input "); 
        return; 
    } 
   
    third = first = second = INT_MIN; 
    for (i = 0; i < arr_size ; i ++) 
    { 
        /* If current element is greater than first*/
        if (arr[i] > first) 
        { 
            third = second; 
            second = first; 
            first = arr[i]; 
        } 
   
        /* If arr[i] is in between first and second then update second  */
        else if (arr[i] > second) 
        { 
            third = second; 
            second = arr[i]; 
        } 
   
        else if (arr[i] > third) 
            third = arr[i]; 
    } 
   
    printf("Three largest elements are %d %d %d\n", first, second, third); 
} 

4: how to identify the duplicates elements in list:

static ArrayList<String> getDuplicates2(List<String> input){
        
    HashMap<String, Integer> duplicates = new HashMap<String, Integer>();
    ArrayList<String> result = new ArrayList<String>();
     
    for(String s : input){
         
        if(duplicates.containsKey(s)){
            duplicates.put(s, duplicates.get(s) + 1);
        }else{
            duplicates.put(s, 1);
        }
         
    }
     
    for(Map.Entry<String, Integer> entry : duplicates.entrySet()){
         
        if(entry.getValue() > 1){
            result.add(entry.getKey());
        }
         
    }
     
    return result;
}

0(N)


4: hub --
Hub Vs. Switch

A hub works on the physical layer (Layer 1) of OSI model while Switch works on the data link layer (Layer 2).
 Switch is more efficient than the hub. A switch can join multiple computers within one LAN, 
 and a hub just connects multiple Ethernet devices together as a single segment. 
 Switch is smarter than hub to determine the target of the forwarding data. 
 Since switch has a higher performance, its cost will also become more expensive


 Switch Vs. Router

 In the OSI model, router is working on a higher level of network layer (Layer 3) than switch. 
 Router is very different from the switch because it is for routing packet to other networks. 
 It is also more intelligent and sophisticated to serve as an intermediate destination to connect multiple area networks together. 
 A switch is only used for wired network, yet a router can also link with the wireless network. With much more functions, 
 a router definitely costs higher than a switch


 There are two computers connected to the network. Explain how they communicate each other.  


 LAN--local area nwt--comunicate within network wifi
 WAN and VPN- connect with two lan and establish communication
 faster process
 CDN- to make a fastest route possible



6:
 How two computert talks:

 browesr- cache, os, router and isp cache--isp initiate a dns query to dns servers sitting in the network to find an ip 
 once find ip..
 tcp handshake
 http req
 depnds on result




 7:
 Both MAC Address and IP Address are used to uniquely identify a machine on the internet. ... 
 MAC Address ensure that physical address of the computer is unique. 
 IP Address is a logical address of the computer and is used to uniquely locate computer connected via a network.


 8:

 permutation:

    // Function to print all the permutations of str 
    static void printPermutn(String str, String combination) 
    { 
  
        // If string is empty 
        if (str.length() == 0) { 
            System.out.print(combination + " "); 
            return; 
        } 
  
        for (int i = 0; i < str.length(); i++) { 
  
            // ith character of str 
            char ch = str.charAt(i); 
  
            // Rest of the string after excluding  
            // the ith character 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); 
  
            // Recurvise call 
            printPermutn(ros, combination + ch); 
        } 
    } 
  ABC --
  ch = A
  ros = A + BC
  per(ABC, A)
  ch  = A
  roos =A+BC
  perm(ABC, AA)
    // Driver code 
    public static void main(String[] args) 
    { 
        String s = "abb"; 
        printPermutn(s, ""); 
    } 
} 



6: hexadecimal to binary

String hex:
int decimal = Integer.parseInt(hex, 16)
String binary = Integer.toBinaryString(decimal)
String ctal = Integer.toOctalString(decimal)


0r 
static void HexToBin(char hexdec[]) 
{ 
    int i = 0; 

    while (hexdec[i] != '\u0000') { 

        switch (hexdec[i]) { 
        case '0': 
            System.out.print("0000"); 
            break; 
        case '1': 
            System.out.print("0001"); 
            break; 
        case '2': 
            System.out.print("0010"); 
            break; 
        case '3': 
            System.out.print("0011"); 
            break; 
        case '4': 
            System.out.print("0100"); 
            break; 
        case '5': 
            System.out.print("0101"); 
            break; 
        case '6': 
            System.out.print("0110"); 
            break; 
        case '7': 
            System.out.print("0111"); 
            break; 
        case '8': 
            System.out.print("1000"); 
            break; 
        case '9': 
            System.out.print("1001"); 
            break; 
        case 'A': 
        case 'a': 
            System.out.print("1010"); 
            break; 
        case 'B': 
        case 'b': 
            System.out.print("1011"); 
            break; 
        case 'C': 
        case 'c': 
            System.out.print("1100"); 
            break; 
        case 'D': 
        case 'd': 
            System.out.print("1101"); 
            break; 
        case 'E': 
        case 'e': 
            System.out.print("1110"); 
            break; 
        case 'F': 
        case 'f': 
            System.out.print("1111"); 
            break; 
        default: 
            System.out.print("\nInvalid hexadecimal digit " + hexdec[i]); 
        } 
        i++; 
    } 
}




First non repeating charcater-

class Solution {
    public int firstUniqChar(String s) {
        
     // first we need a character count of each character in a stroing, no matter what we need to travesre entire string
        //HashMap
        HashMap<Character, Integer>  hm = new HashMap();
        
        for (int i=0; i< s.length();i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0) +1);
        }
        
        for (int i=0; i<s.length(); i++){
            if(hm.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
        
    }
}


// Build hashmap 
// and traverse the hashmap with value ==1 then return index

// Time O(N) since we go through the string of length N two times.
// Space O(1) 0(n) ~0(26) alphabets ~ 0(1)  constant time


Shuffle the deck:

import java.util.ArrayList;

public class Test {
    private static final int DECK_SIZE = 52;

    public static void main(String args[]) {
        ArrayList<Integer> deck = new ArrayList<Integer>();

        for (int i = 0; i < DECK_SIZE; ++i) {
            deck.add(i);
        }

        ArrayList<Integer> shuffledDeck = new ArrayList<Integer>();

        while (deck.size() > 0) {
            int index = (int) (Math.random() * deck.size());
            shuffledDeck.add(deck.remove(index));
        }

        System.out.println(shuffledDeck.toString());
    }
}

or 


for(int i=0;i< deck.size();i++){

    int index = (int)Math.random *(deck.size())
    int temp = d[i]
    d[i] = d[index]
    d[iindex] =temp
}


0r 



import java.util.ArrayList;
import java.util.Collections;

public class Test {
    private static final int DECK_SIZE = 52;

    public static void main(String args[]) {
        ArrayList<Integer> deck = new ArrayList<Integer>();

        for (int i = 0; i < DECK_SIZE; ++i) {
            deck.add(i);
        }

        Collections.shuffle(deck);

        System.out.println(deck);
    }
}


Challenges of distributed syetem:

1. Heterogenity --different syetem in n/want
2. opennness --extendoing the ntwk like internet add/delete
2. scalability--- how to address scaling whne large users are added
4. Security: -in transit and rest securiity
5.Failure handling --how to handle the failures
6: high availabilty --
7: concurrency 
8. Transpaarncy --rules abt server, who shud contact how to contact efficient




How Http works:
--it is application layer protocol that allows web based applicat to communicate and exchange data
--computers on web which communicates via http shud speak http protocol
--stateless (dont know each other prior , they need to provide info abt each other)
    and connection less(after making req two computer disconnect from each other) and can dleiiver any data(images, audio, video etc)
--tcp/ip based protocool


client and server --speaks both http protocol
www.google.com --connecting to server dns things etc

Http message:  start line Header and body based on request and response
Http request --GEt /products,uri, host and language
Http response-- status code, body and headeer

Http uses tcp--reliable, flow control, error control

port: 80

web server -i sserver on internet which serves web pages like fb and ggogle

Http verbs: get post put delete


How Https Works:
=============

Browser communicates with server using Asymmentric and symetric containsKey

server sends a public key in first re to client and then clinet send sits symm key and ecnrypt with public key of server and cleinet validates server using ca 
cert created by CA authority,since browsers have thos public key they can verify them


SSl and TLS:
secure t\http protects the data using one of the protoocols called sssl and TLS--ensure security on internet
http over tls, ssl, and secure
if your website is using HTTPS, all the information will be encrypted by SSL/TLS certificates.



finbonocii:
============
//recursive
static int fibo(int n){
    if(n <= 1){
        return n;

    }
    return fibo(n-1) +fibo(n-2);
}

T(n) = T(n-1) + T(n-2) + 1 = 2n = O(2n)
//iterative:
static int fibo(int n){
    int fibo[] = new int[n+1];
    fibo[o]=0;
    fibo[1]=1;

    for( int i=2;  i< n+1;i++){

        fibo[i] = fibo[i-1]+fibo[i-2];

    }
    return fibo[n];

}

T: 0(n) and space :o(n)


Design patterns:
single tion 
factory--one parent class and u eant to teryun diff sub classes based on imput
Builder pattern for return attributes of minimuma nd return the object



UDP:
User Datagram Protocol
User Datagram Protocol is a connectionless protocol.
Used for streaming video, gaming, VoIP, live broadcasts
Faster and requires fewer resources
Packets do not necessarily arrive in order
Allows missing packets; sender cannot know whether a packet has been received

DNS, DHCP

No handshake



TCP:
Transmission Control Protocol
a connection-oriented protocol.
Most widely used protocol on the internet
TCP guarantees no packets are missing and all data sent makes it to the recipient
TCP sends packets in order so they can be easily stitched back together
Slower and requires more resources

HTTP, HTTPs,  
error checking

flow control
SYN, SYN-ACK, ACK



Swap: 
 x=10,
 y=5;
without swaping:
 x= x+y
 y = x-y
 x = x-y

 with swaping
 int a=1, b=2;

 int temp = a;
 a=b;
 b=temp


 Sorting algorithm:
 =====================


Insertion Sort--
     Best times to use this algorithm:
     1. When data set is relatively small
     2. When items in the data set are semi-sorted already
     ** Note: Some more advanced algorithms that are much better at sorting large data sets,
      will use insertion sort if they break down the data set into smaller data sets using recursion. 
     They utilize Insertion Sort once the data set has been broken down to be a relatively small data set

     Note: Best to use when the list is small and/or almost totally sorted. It takes a long time but it does have some pluses in stability and space. Be sure to mention this as an alternative to the above two sorts if the situation calls for stability/space


     Worst case performance: O(n²) — So if you have 100 elements in your array, at worst, this algorithm will do 10,000 comparisons. 
                                This is when your data set is sorted completely opposite of how you wish to sort the data.
    Average case performance: O(n²) — The average case won’t quite be 10,000 comparisons, but it will be higher than O(n) or O(nlogn) time.
     Best case performance: O(n) — The best case performance is when the data set is already sorted and it only needs to iterate each item 
                                  in the array and do one comparison for each item in the data set.
Bubble Sort

    Best times to use this algorithm:
    1.When data set is relatively small
    2.When items in the data set are semi-sorted already

    Worst case performance: O(n²) — So if you have 100 elements in your array, at worst, this algorithm will do 10,000 comparisons. 
                               This is when your data set is sorted completely opposite of how you wish to sort the data.
    Average case performance: O(n²) — The average case won’t quite be 10,000 comparisons, but it will be higher than O(n) or O(nlogn) time.
    Best case performance: O(n) — The best case performance is when the data set is already sorted and it only needs to iterate each item 
                      in the array and do one comparison for each item in the data set.

Selection Sort
    Best times to use this algorithm:
    1. When data set is relatively small
    Note: This algorithm is not advised on any large data sets. It is very similar to Insertion Sort in many ways,
     but Insertion Sort would still be more optimal as it has the possibility of fewer comparisons than Selection Sort. 
    However, Selection Sort does have the advantage of fewer writes/swaps than Insertion Sort.

    Worst case performance: O(n²) — The worst case is the same as both worst case, and best case. This algorithm will still need to do O(n²) comparisons to make sure everything is in order. Which is one disadvantage of this particular algorithm.
    Average case performance: O(n²) — The average case is the same as both worst case, and best case. This algorithm will still need to do O(n²) comparisons to make sure everything is in order. Which is one disadvantage of this particular algorithm.
    Best case performance: O(n²) — The best case performance is the same as both worst case, and average case. This algorithm will still need to do O(n²) comparisons to make sure everything is in order. Which is one disadvantage of this particular algorithm.
      
Merge sort

    Best times to use this algorithm:
    1.Larger data sets
    2.When there are not memory or storage constraints, as the most common implementations of merge sort uses a secondary list using the same amount of space as original list to help with sorting.
    3.When items in the data set can be accessed sequentially
    Note: If two arrays are already sorted, it is especially easy to merge them. This algorithm takes apart an unsorted array to take advantage of this fact. Also worth mentioning is that the space complexity of merge sort is good at O(n), so if you come across an interviewer who asks you to prioritize space, this would be a good sort to pick

    Worst case performance: O(nlogn) — The worst case is the same as both worst case, and best case.
Average case performance: O(nlogn) — The average case is the same as both worst case, and best case.
Best case performance: O(nlogn) — The best case performance is the same as both worst case, and average case.

Quick Sort
        Large data sets
        When the ordering of equal elements is not important. Quicksort is not a stable algorithm, which means that once the data set is ordered, that elements whose values are equal, are not guaranteed to be in the same ordering as the initial data set.
        Note: There are plenty of edge cases where it is less successful, but it is usually considered the all around best if you had to guess what to use. You can avoid most worst case scenarios by choosing the pivot wisely (the closest to the median possible). You can also mention 3-way quick sort/Dutch National Flag as an alternative to quick sort for repetitive inputs.
        Fun Fact: Ruby uses quick sort for its .sort method.
        Running time complexity:
    Worst case performance: O(n²) — For Quicksort, n² running time complexity is rare. So this should not be very worrisome.
    Average case performance: O(nlogn) — The average case is the same as best case.
   Best case performance: O(nlogn) — The best case performance is the same as average case.

Heap Sort:
   Time complexity: All cases are O(nlogn).
Note: This is not used for efficiency, because quick and merge are much better in almost all aspects.
 However, the heap data structure is important to know and understand 
 for lots of different applications and it might be worth demonstrating that you know about it 
 because it allows for the worst case scenario to maintain its efficiency. It utilized the information stored 
 in the binary tree rather than the information in the list itself to do the sorting, which makes it quicker in edge cases.

Order:

A logarithmic algorithm — O(logn)
Runtime grows logarithmically in proportion to n.
A linear algorithm — O(n)
Runtime grows directly in proportion to n.
A superlinear algorithm — O(nlogn)
Runtime grows in proportion to n.
A polynomial algorithm — O(nc)
Runtime grows quicker than previous all based on n.
A exponential algorithm — O(cn)
Runtime grows even faster than polynomial algorithm based on n.
A factorial algorithm — O(n!)
Runtime grows the fastest and becomes quickly unusable for even
small values of n.




Number: prime 
public class Main {

    public static void main(String[] args) {

        int num = 29;
        boolean flag = false;
        for(int i = 2; i <= num/2; ++i)
        {
            // condition for nonprime number
            if(num % i == 0)
            {
                flag = true;
                break;
            }
        }

        if (!flag)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
    }
} 
    
}