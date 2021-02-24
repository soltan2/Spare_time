import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;
public class Solution {
    
    
    static List<List<String>> threeKeywordSuggestions(int numreviews, List<String> repository,String customerQuery)
    {
	
	List<List<String>> outputs = new ArrayList<>();
	List<String> matchedWords=new ArrayList<>();
	
	for(int i=0;i<customerQuery.length();i++) {
	    matchedWords.clear();
	    for (String element : repository) {
		if(customerQuery.substring(0,i+1).equals(element.substring(0,i+1))) {
		    matchedWords.add(element);
		    if(matchedWords.size()==3) {
			break;
		    }
		}   
	    }	
	//    System.out.println(matchedWords.toString());
	    outputs.add(matchedWords); 
	   
	    
	}

	return outputs;

    }
    
    static int finalInstances(int instances, int[] averageUtil) {
        
        
	for (int i = 0; i < averageUtil.length; i++) { 
	  
         if(averageUtil[i]<25 && instances>1){
             double ins= instances/2;
             instances=(int)Math.ceil(ins);
              i=+10;
         }
         else if(averageUtil[i]>60 && instances<(10^8)){
	          
         instances=2*instances;
          i=+10;
        }
     }
	        
	return instances;
	        
    }
    
    static List<String> uniqueDeviceNames(int num,List<String> deviceNames){
	
	List<String> outputs=new ArrayList<String>();
	HashMap<String, Integer> hs = new HashMap<String, Integer>(); 
	
	System.out.println("device names input: "+deviceNames.toString());
	
	for(int i=0;i<num;i++) {
	   // System.out.println(deviceNames.get(i));
	    
	    if (hs.containsKey(deviceNames.get(i))) { 
		outputs.add(deviceNames.get(i)+hs.get(deviceNames.get(i)));
		hs.put(deviceNames.get(i), hs.get(deviceNames.get(i)) + 1); 
		
	        } 
	    	else { 
	    	 outputs.add(deviceNames.get(i));   
	         hs.put(deviceNames.get(i), 1); 
	        } 
	   }
		 
	return outputs;
    }
    
    static String higherScore(int limit, String original) {
	
	String result="";
	StringBuilder sb = new StringBuilder();
	sb.append(original);
	char max=original.charAt(0);
	int j=0,limit2=0;
	int size=original.length();
	
	for(int k=0;k<size;k++) {
	    
        	for(int i=1;i<original.length();i++) {
        	    if(original.charAt(i)>max) {
        		max=original.charAt(i);
        		j=i;
        	    }
        	} 
        	 
        	  result+=max; 
        	  sb.deleteCharAt(j);
        	  original = sb.toString();
        	  if(original.equals("")) {
        	      break;
        	  }
        	  max=original.charAt(0);
        	  j=0;
        	 
	}
	char s=result.charAt(0);
	for(int i=1;i<result.length();i++) {
	    if(s==result.charAt(i)) {
		limit2++;
	    }
	    if(limit2==limit) {
		System.out.println("result "+result);
		System.out.println("i is"+ i);
		   StringBuilder sb2 = new StringBuilder(); 
		   sb2.append(result);
		   sb2.setCharAt(i, result.charAt(i+1)); 
		   sb2.setCharAt(i+1, result.charAt(i)); 
	           result = sb2.toString();
	           limit2=0;
		
	    }
	}
	
	return result;
    }

    
    // split literature text, loop over each word, maintain a dict about how often used 
    // do not count any word in wordsToExclude
    static List<String> retrieveMostFrequentlyUsedWords( String literatureText,List<String> WordsToExclude) {
	
	List<String> outputs=new ArrayList<String>();
	List<String> words=new ArrayList<String>();
	HashMap<String, Integer> hs = new HashMap<String, Integer>(); 
	String[] arr = literatureText.split(" ");    
	for ( String ss : arr) {
	    words.add(ss);
	}
	for (int i = 0; i < arr.length; i++) { 
	    // If word already exist in HashMap then increase its count by 1 else add it to the hs
	    if (hs.containsKey(arr[i])) { 
		hs.put(arr[i], hs.get(arr[i]) + 1); 
	        } 
	    	else { 
	         hs.put(arr[i], 1); 
	        } 
	   }
	 String key = ""; 
	 int maxValue = 0; 
	        int maxValueInMap=(Collections.max(hs.values()));  // This will return max values in the Hashmap
	        for (Map.Entry<String, Integer> entry : hs.entrySet()) {  // Iterate through hashmap
	            if (entry.getValue()==maxValueInMap & !WordsToExclude.contains(entry.getKey()) ) {
	        	outputs.add(entry.getKey());
	            }
	        }
	        System.out.println(outputs.toString());
	 
	return outputs;
    }
    
    
 
    

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	int numreviews=5;
	List<String> repository = asList("mobile","mouse","moneypot","monitor","mousepad");
	String customerQuery="mouse";
	threeKeywordSuggestions(numreviews,repository, customerQuery);
	//System.out.println(threeKeywordSuggestions(numreviews,repository, customerQuery).toString());
	
	String literatureText="jack and jill went to the market to buy bread and cheese cheese is jack favorite food";
	List<String> wordsToExclude=asList("and","he","the","to","is");
	
	//retrieveMostFrequentlyUsedWords(literatureText,wordsToExclude);
	int num = 6;
	List<String> devicenames = asList("switch", "tv", "switch", "tv","switch", "tv");
	
	//System.out.println(uniqueDeviceNames(num,devicenames).toString());
	System.out.println(higherScore(2,"cbddd"));
	
	

    
    }
}
