package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAlgo {
	public void camelCase(){
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String regex = "([A-Z])";
		Pattern pt = Pattern.compile(regex);
		Matcher m = pt.matcher(str);
		int count = 1;
		while(m.find()){
			count++;			
		}
		System.out.println(count);
	}
	
	public void sosMessage(){
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String regex = "(?<=\\G...)";
		String [] strArr = str.split(regex);
		int count = 0;
		for(int i=0; i<strArr.length; i++){
			if(!strArr[i].equals("SOS")){
				String[] sArr = strArr[i].split("");
				if(!sArr[0].equals("S"))
					count++;
				if(!sArr[1].equals("O"))
					count++;
				if(!sArr[2].equals("S"))
					count++;
			}
		}
		System.out.println(count);	
	}
	
	public void stringAppend(){
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
        	Set newStr = new HashSet<>();
            String s = in.next();
            char[] c = s.toCharArray();
            for(char ch: c){
            	newStr.add(ch);
            }
            System.out.println(newStr.size());
        }
	}
}
