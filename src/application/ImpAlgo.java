package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ImpAlgo {
	public void sockMerchent(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			list.add(in.nextInt());
		}
		Collections.sort(list);
		System.out.println(getPairsCount(list, 0, 0));
	}
	
	private static int getPairsCount(List<Integer> list, int i, int count){
		if(count>=list.size()-1)
			return i;
		if(list.get(count)==list.get(count+1)){
			i = i+1;
			count = count+1;
		}
		count = count+1;
		return getPairsCount(list, i, count);
	}
	
	public void equalArray(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			int a = in.nextInt();
			list.add(a);
		}
		Collections.sort(list);
		System.out.println(getMaxArrayCount(list));
	}
	private static int getMaxArrayCount(List<Integer> list){
		int preEle = 0, sumEqualEle = 1;
		HashMap<Integer,Integer> eqArr=new HashMap<Integer,Integer>();  
		for(int i=0; i<list.size(); i++){
			int ele = list.get(i);
			if(ele==preEle)
				sumEqualEle++;
			else
				sumEqualEle = 1;			
			eqArr.put(ele,sumEqualEle);			
			preEle = ele;
		}
		int maxValueInMap=(Collections.max(eqArr.values()));
		return (maxValueInMap>0) ? (list.size() - maxValueInMap) : 0;
	}
	
	public void repetedString(){
		Scanner in = new Scanner(System.in);
	    String s = in.next();
	    long n = in.nextLong();
	    long count =0;
	    for(char c : s.toCharArray())
	        if(c == 'a')
	        count++;

	     long factor = (n/s.length());
	     long rem = (n%s.length());
	     count =  factor*count  ;
	    for(int i=0;i<rem;i++)
	        if(s.charAt(i)=='a')
	                count++;        
	    System.out.println(count);
	}
}
