package application;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Permission;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
	/*private static boolean flag = true;
	private static int B,H;
	
	static {
		Scanner in = new Scanner(System.in);
		B = in.nextInt();
		H = in.nextInt();
		
		try{
			if(B <= 0 || H <= 0){
				flag = false;
				throw new Exception("Breadth and height must be positive");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		in.close();
	}*/
	
	public static void main(String[] args) {
		q36();
	}
	
	public static void q1(){
		Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            int d = (17-s1.length());
            String formatted = String.format("%03d", x);
            System.out.printf(s1+" %"+d+"s",formatted);
            System.out.println("");
        }
        System.out.println("================================");
	}
	
	public static void q2(){
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<3;i++){
			int a = scan.nextInt();
        	System.out.println(a);
		}
	}
	
	public static void q3(){
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt(); 
		double y = sc.nextDouble(); 
		sc.nextLine();
		String s = sc.nextLine();
		
		System.out.println("String: "+s);
	    System.out.println("Double: "+y);
	    System.out.println("Int: "+x);
	}
	
	public static void q4(){
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt(); 
		for(int i=1;i<=10;i++){
			System.out.printf("%d x %d = %d",x,i,i*x);
			System.out.println("");
		}
	}
	
	public static void q5(){
		DoNotTerminate.forbidExit();
		try {
			Scanner in = new Scanner(System.in);
			int n = in .nextInt();
			in.close();
			String s=Integer.toString(n); //Complete this line below
			if (n == Integer.parseInt(s)) {
				System.out.println("Good job");
			} else {
				System.out.println("Wrong answer.");
			}
		} catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}
	
	public static void q6(){
		Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        String ourDateStr = String.format("%s/%s/%s", day, month, year);
        Date inputDate = null;
		try {
			inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(ourDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        Calendar c = Calendar.getInstance();
        c.setTime(inputDate);
        String dayOfWeek = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
        System.out.println(dayOfWeek);
	}
	
	public static void q7(){
		String temp;
		int n = 2;
		Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        
        String names[] = new String[n];
        names[0] = A;
        names[1] = B;
        
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (names[i].compareTo(names[j])>0){
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        
        int aLen = names[0].length();
        int bLen = names[1].length();
        
        System.out.println(aLen+bLen);
        System.out.println(A.compareTo(B)>0?"Yes":"No");
        System.out.println(upperCaseFirst(A)+" "+upperCaseFirst(B)); 
	}
	
	public static String upperCaseFirst(String value) {
		char[] array = value.toCharArray();
		array[0] = Character.toUpperCase(array[0]);
		return new String(array);
	}
	
	public static void q8(){
		Scanner sc=new Scanner(System.in);
		String temp;
		int n = 0;
		String s1=sc.next();
        int x=sc.nextInt();
        int b=0; 
        n = (int)(s1.length()-x)+1;
        String names[] = new String[n];
        
        for (int i = 0; i <n; i++){
        	names[i] = s1.substring(i,(x+b));
        	b++;
        }
        
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (names[i].compareTo(names[j])>0){
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        
        System.out.println(names[0]);
        System.out.println(names[(names.length-1)]);
	}
	
	//palindrome string
	public static void q9(){
		Scanner sc=new Scanner(System.in);
        String A=sc.next();
		String revstring="";
		 
		for(int i=A.length()-1;i>=0;--i){
			revstring +=A.charAt(i);
		}		 
		if(revstring.equalsIgnoreCase(A)){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
	
	public static void q10(){
		Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	}
	
	public static boolean isAnagram(String s1, String s2){
        //Removing all white spaces from s1 and s2 
        String copyOfs1 = s1.replaceAll("\\s", ""); 
        String copyOfs2 = s2.replaceAll("\\s", ""); 
        
        //Initially setting status as true 
        boolean status = true; 
        if(copyOfs1.length() != copyOfs2.length()){
            //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length 
            status = false;
        }else{
            //Changing the case of characters of both copyOfs1 and copyOfs2 and converting them to char array 
            char[] s1Array = copyOfs1.toLowerCase().toCharArray(); 
            char[] s2Array = copyOfs2.toLowerCase().toCharArray(); 
            
            //Sorting both s1Array and s2Array 
            Arrays.sort(s1Array); 
            Arrays.sort(s2Array); 
            
            //Checking whether s1Array and s2Array are equal 
            status = Arrays.equals(s1Array, s2Array);
        } 
        return status;
    }
	
	private static void q11(){
		Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            for (int j = 0; j<n; j++){
            	a = a + (int)Math.pow(t,j)*b;
                System.out.print(a + "   ");
            }
            System.out.println("");
        }
        in.close();
	}
	
	private static void q12(){
		Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {
            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                
                int in = (int) Math.pow(2, 31);
                long ln = (long) Math.pow(2, 63);
                
                if(x>=-128 && x<=127)System.out.println("* byte");                
                if(x>=-32768 && x<=32768)System.out.println("* short");
                if(x>=-in && x<=in)System.out.println("* int");
                if(x>=-ln && x<=ln)System.out.println("* long");                
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
        }
	}
	
	private static void q14(){
		int i = 1; 
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String line = sc.nextLine();
        	System.out.println(i+" "+line);
			i++;
		}
	}
	
	private static void q16(){
		String regex = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*";
        Pattern p = Pattern.compile(regex, Pattern.MULTILINE+Pattern.CASE_INSENSITIVE);
        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());        
        while (numSentences-- > 0) {
            String input = in.nextLine();            
            Matcher m = p.matcher(input);            
            //Check for subsequences of input that match the compiled pattern
            while (m.find()) {
            	System.out.println("regx: "+m.group());
            	System.out.println("replaced: "+m.group().split(" ")[0]);
                input = input.replaceAll(m.group(), m.group().split(" ")[0]);
            }            
            //Prints the modified sentence.
            System.out.println(input);
        }        
        in.close();
	}
	
	private static void q17(){
		Scanner in = new Scanner(System.in);
	      int testCases = Integer.parseInt(in.nextLine());
	      while(testCases>0){
	         String username = in.nextLine();
	         //String pattern = Complete this line in the editable area below  
	         String pattern = "^[A-Za-z][A-Za-z0-9_]{7,29}$";
	         Pattern r = Pattern.compile(pattern);
	         Matcher m = r.matcher(username);
	          
	         if (m.find( )) {
	            System.out.println("Valid");
	         } else {
	            System.out.println("Invalid");
	         }
	         testCases--;
	      }
	}
	
	private static void q18(){
		Scanner in = new Scanner(System.in);
	      int testCases = Integer.parseInt(in.nextLine());
	      while(testCases>0){
	         String pattern = in.nextLine();
	         try{
	        	 Pattern p = Pattern.compile(pattern);
	        	 System.out.println("Valid");
	         } catch (PatternSyntaxException exception) {
	        	 System.out.println("Invalid");
	         }
	      }
	      in.close();
	}
	
	private static void q19(){
		Scanner in = new Scanner(System.in);
	      while(in.hasNext()){
	          String IP = in.next();
	          System.out.println(IP.matches(new MyRegex().pattern));
	      }
	}
	
	private static void q20(){
		Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        String str = S.substring(start,end);
        System.out.println(str);
        in.close();
	}
	
	private static void q21(){
		Scanner scan = new Scanner(System.in);
		if(!scan.hasNext()) { System.out.print(0);return;}
        String s = scan.nextLine();
        String str = s.trim();
        String regx = "[ .,?!'@_]+";
        String[] tokens = str.split(regx);
        int len = tokens.length;
        if(len<400000){
        	System.out.println(len);
	        for(int i=0; i<len; i++){
	        	System.out.println(tokens[i]);
	        }
        }
        scan.close();
	}
	
	private static void q22(){
		Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        
        NumberFormat USA = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat CHINA = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat FRANCE = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat INDIA = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        
        String us = USA.format(payment);
        String india = INDIA.format(payment); 
        String china = CHINA.format(payment);
        String france = FRANCE.format(payment);
        
        if(payment >= 0 && payment<=(Math.pow(10, 9))){
	        System.out.println("US: " + us);
	        System.out.println("India: " + india);
	        System.out.println("China: " + china);
	        System.out.println("France: " + france);
        }
        scanner.close();
	}
	
	private static void q23(){
		Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            for(int j=1;j<=n;j++){
            	int s = a;
            	int q = 1;
            	for(int k=0;k<j;k++){
            		s += (q*b);
            		q = q*2;
                }
            	System.out.printf("%d ", s);            	
            }
            System.out.println();
        }
        in.close();
	}
	
	private static void q24(){
		/*if(flag){
			int area=B*H;
			System.out.print(area);
		}*/
	}
	
	private static void q25(){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		String regex = "<(.+)>([^<>]+|[^<]+|[^>]+)</\\1>";
        Pattern pattern = Pattern.compile(regex);
		while(testCases>0 && testCases<=100){
			String line = in.nextLine();         
			if(line.length() <= (Math.pow(10, 6))){
				boolean found=false;
	            Matcher m = pattern.matcher(line);	          
	            while(m.find() && m.group(2).length() <= Math.pow(10, 4)){
	            	System.out.println(m.group(2));
	            	found = true;
		        }
	            if(!found){
	        		System.out.println("None");
	        	}
			}
			testCases--;
		}
	}
	
	private static void q26(){
		Scanner in = new Scanner(System.in);
		for(int i=0;i<1;i++){	
			BigInteger sum = in.nextBigInteger();
			BigInteger mul = in.nextBigInteger();			
			System.out.println(sum.add(mul));
			System.out.println(mul.multiply(sum));			
		}
		in.close();
	}
	
	private static void q27(){
		Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]= sc.next();            		
        }
      	sc.close();
      	
      	Arrays.sort(s, 0, n, new Comparator<String>() {
            public int compare(String s1, String s2) {
                BigDecimal bd1 = new BigDecimal(s1);
                BigDecimal bd2 = new BigDecimal(s2);
                return bd1.compareTo(bd2) == 1 ? -1:bd1.compareTo(bd2) == -1 ? 1:0;                
            }
        });
      	
      	//Output
	    for(int i=0;i<n;i++)
	    {
	        System.out.println(s[i]);
	    }
	}
	
	private static void q28(){
		Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        
        long []sumAll = new long[5];
        sumAll[0] = b+c+d+e;
        sumAll[1] = a+c+d+e;
        sumAll[2] = a+b+d+e;
        sumAll[3] = a+b+c+e;
        sumAll[4] = a+b+c+d;
        
        Arrays.sort(sumAll);
        
        System.out.println(sumAll[0]+" "+sumAll[4]);
	}
	
	private static void q29(){
		Scanner in = new Scanner(System.in);
	    BigInteger n = in.nextBigInteger();
	    in.close();
	    if(n.isProbablePrime(1)){
	    	System.out.println("prime");
	    }else{
	    	System.out.println("not prime");
	    }
	}
	
	private static void q30(){
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
       int []a = new int[n];
        for(int i = 0 ; i < n; i++){
            int val = scan.nextInt();
            a[i] = val;
        }
        
        
        scan.close();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
	}
	
	private static void q31(){
		Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        int result[] = new int[16];        
        result[0] = addArrayElement(arr,0,3,0,3);
        result[1] = addArrayElement(arr,0,3,1,4);
        result[2] = addArrayElement(arr,0,3,2,5);
        result[3] = addArrayElement(arr,0,3,3,6);
        
        result[4] = addArrayElement(arr,1,4,0,3);
        result[5] = addArrayElement(arr,1,4,1,4);
        result[6] = addArrayElement(arr,1,4,2,5);
        result[7] = addArrayElement(arr,1,4,3,6);
        
        result[8] = addArrayElement(arr,2,5,0,3);
        result[9] = addArrayElement(arr,2,5,1,4);
        result[10] = addArrayElement(arr,2,5,2,5);
        result[11] = addArrayElement(arr,2,5,3,6);
        
        result[12] = addArrayElement(arr,3,6,0,3);
        result[13] = addArrayElement(arr,3,6,1,4);
        result[14] = addArrayElement(arr,3,6,2,5);
        result[15] = addArrayElement(arr,3,6,3,6);
        
        Arrays.sort(result);
        System.out.println(result[15]);
	}
	
	private static int addArrayElement(int arr[][], int a, int b, int c, int d){
		int result = 0;
		int i = 1;
		for(int k=a; k<b; k++){
			if(i==2){
				result += arr[k][c+1];				
			}else{
				for(int j=c; j<d;j++){        		  
	        		result += arr[k][j];	        		        		
	        	}
			}        	
        	i++;        	   	
        }
		return result;
	}
	
	private static void q32(){
		Scanner sc = new Scanner(System.in);
	    int length = sc.nextInt();
	    int[] arr = new int[length];

	    int first = sc.nextInt();
	    arr[0] = first;
	    int count = first < 0 ? 1 : 0;

	    for (int i = 1; i < length; i++){
	        int num = sc.nextInt();
	        arr[i] = arr[i - 1] + num;

	        if (arr[i] < 0){
	            count++;
	        }

	        for (int j = 0; j < i; j++){
	            int sub_result = arr[i] - arr[j];
	            if (sub_result < 0){
	                count++;
	            }
	        }
	    }

	    System.out.print(count);
	}
	
	private static void q33(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println("n: "+n);
		for(int i=0; i<n+1; i++){
			String lnd = in.nextLine();
			System.out.println("d: "+lnd);
			//ArrayList al = new ArrayList();
		}
		int q = in.nextInt();
		System.out.println("q: "+q);
		for(int j=0; j<q+1; j++){
			String lnq = in.nextLine();
			System.out.println("x,y: "+lnq);
		}
		in.close();
	}
	
	private static void q34(){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		if(T >= 1 && T <= 5000){
			for(int i=0; i<T; i++){
				int n = in.nextInt();
				int m = in.nextInt();				
				if(n >= 2 && n <= 100){
					ArrayList<Integer> am = new ArrayList<Integer>(n);
					if(m >= 0 && m <= 100){
						for(int k=0;k<n;k++){
							int a = in.nextInt();
							if(a==0 || a==1){
								am.add(a);
							}
						}						
					}	
										
					if(isWin(m, am, 0)){
						System.out.println("YES");
					}else{
						System.out.println("NO");
					}
				}
			}
		}
		in.close();
	}
	
	private static boolean isWin(int m, ArrayList<Integer> am, int i) {
		if(i < 0 || am.get(i)==1) 
			return false;
		if(i==am.size()-1 || i+m > am.size())
			return true;		
		am.set(i, 1);
		try {
			return isWin(m, am, i+1) || isWin(m, am, i-1) || isWin(m, am, i+m);
		} catch (Exception e) {
			return true;
		}		
	}
	
	//4675
	private static void q35(){
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();       
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        if((n>=1 && n<=100000) && ((m>=1 && m<=100000) && (m<=n))){
	        for (int i = 0; i < n; i++) {
	        	int num = in.nextInt();
	        	arr.add(num);
	        }
        }
        
        int l = 1;
        for(int j=0; j<arr.size(); j++){
        	Deque deque = new ArrayDeque<>();
        	Deque deque2 = uniqueArr(deque, m, arr, 0, j);
        	int k = 1;
        	if(deque2.size()==m){
        		k = maxDeque(deque2,k);
        		if(k+1==m){
        			l++;
        		}
        	}        	
        }
        System.out.println(l);
	}
	private static Deque uniqueArr(Deque deque, int m, ArrayList<Integer> arr, int i, int j){
		if(i<m && i+j < arr.size()){
			deque.add(arr.get(i+j)); i++;
			return uniqueArr(deque, m, arr, i, j);
		}else
			return deque;
	}
	private static int maxDeque(Deque deque, int i){
		if((deque.size()>1) && (deque.getFirst()!=null) && (deque.getLast()!=null)){
			int firstElement = (int) deque.getFirst();
			int lastElement = (int) deque.getLast();
			deque.removeFirst(); 
			deque.removeLast();
			if(firstElement!=lastElement){
				i++;			
			}			
			return maxDeque(deque, i);
		}else{
			return i;
		}		
	}
	
	private static void q36(){
		Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            
            deque.add(input);
            set.add(input);
            
            if (deque.size() == m) {
                if (set.size() > max) max = set.size();
                int first = deque.remove();
                if (!deque.contains(first)) set.remove(first);
            }
        }
        
        System.out.println(max);
	}
}

class MyRegex{
	String zeroTo255 = "([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])"; 
	public String pattern = zeroTo255+"."+zeroTo255+"."+zeroTo255+"."+zeroTo255;	
}

class DoNotTerminate {
	public static class ExitTrappedException extends SecurityException {
		private static final long serialVersionUID = 1;
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}