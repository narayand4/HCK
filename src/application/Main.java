package application;

import java.security.Permission;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static boolean flag;
	static int B, H;
	
	public static void main(String[] args) {
		q16();
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
	
	private static void q15(){
		if(flag){
			int area=B*H;
			System.out.print(area);
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