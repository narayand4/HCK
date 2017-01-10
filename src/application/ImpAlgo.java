package application;

import java.util.ArrayList;
import java.util.Collections;
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
		System.out.println(list);
		System.out.println(popUnEqual(list, list.size(), 0, 0));
	}
	//78
	//24 29 70 43 12 27 29 24 41 12 41 43 24 70 24 100 41 43 43 100 29 70 100 43 41 27 70 70 59 41 24 24 29 43 24 27 70 24 27 70 24 70 27 24 43 27 100 41 12 70 43 70 62 12 59 29 62 41 100 43 43 59 59 70 12 27 43 43 27 27 27 24 43 43 62 43 70 29
	//63
	private static int popUnEqual(List<Integer> list, int i, int count, int index){
		if(i==0) return count;
		if(list.size()==1) return 0;
		System.out.println(list);
		index = index+1;
		if(list.get(index)!=list.get(index+1)){
			//System.out.println("sadasd");
			//list.remove(0);
			count = count+1;
			//index = index-1;
		}
		return popUnEqual(list, (i = i-1), count, index);
	}
}
