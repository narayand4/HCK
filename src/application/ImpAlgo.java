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
	
	public void repetedStringbck(){
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
	
	public void repetedString(){
		Scanner in = new Scanner(System.in);
	    String s = in.next();
	    long n = in.nextLong();
	    String[] arrStr = s.split("");
	    String finalString = getConcatString(arrStr, n, 0,"");
	    long count =0;
	    for(char c : finalString.toCharArray())
	        if(c == 'a')
	        	count++;
	    System.out.println(count);
	}
	private static String getConcatString(String[] arrStr, long n, long count, String finalString){
		if(count==n) return finalString;
		for(int i=0; i<arrStr.length; i++){
			finalString += arrStr[i];
			count = count+1;
			if(count==n) break;
		}
		return getConcatString(arrStr, n, count,finalString);
	}
	
	protected void advertise(){
		Scanner in = new Scanner(System.in);
		int days = in.nextInt();
		long noofPerson = 5, totalPerson = 0;
		for(int i=0; i<days; i++){ 
			if(i>0) noofPerson = (long) (Math.floor(noofPerson/2) * 3);		
			totalPerson += (noofPerson/2);
		}
		System.out.println(totalPerson);
	}
	
	protected void cloudJump(){
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int i=0; i < n; i++){
            c[i] = in.nextInt();
        }
        int count = -1;
        for (int i = 0; i < n; i++, count++) {
            if (i<n-2 && c[i+2]==0) i++;
        }
        System.out.println(count);
	}
	
	protected void beautifulDays(){
		Scanner in = new Scanner(System.in);
		int daysStart = in.nextInt();
		int daysEnd = in.nextInt();
		int k = in.nextInt();
		int sum = 0;
		for(int i=daysStart; i<=daysEnd; i++){
			int input = reversedNumber(i);
			double mod = (((input>i) ? (input-i) : (i-input)) % k);
			if(mod==0) sum++;
		}		
		System.out.println(sum);
	}
	private static int reversedNumber(int n){
		int reverse = 0;
		 while( n != 0 )
	      {
	          reverse = reverse * 10;
	          reverse = reverse + n%10;
	          n = n/10;
	      }
		 return reverse;
	}
	
	protected void minimumDays(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0; i<n; i++){
			int a = in.nextInt();
		}
	}
}
