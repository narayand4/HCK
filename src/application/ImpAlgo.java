package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    protected void minimumDistance(){
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            List<Integer> minList = new ArrayList<Integer>();
            for(int i=0; i<n; i++){
                    int a = in.nextInt();
                    list.add(a);
            }
            for(int i=0; i<list.size(); i++){ 
                    int a = list.get(i);
                    int index = list.indexOf(a);
                    if(index!=i){
                            minList.add(i-index);
                    }
            }
            Collections.sort(minList);
            int result = (minList.size() > 0) ? minList.get(0) : -1;
            System.out.println(result);
    }

    protected void jumpingOnTheCloud(){
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int k = in.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<n; i++){
                    int a = in.nextInt();
                    list.add(a);
            }
            System.out.println(getMove(list, k));
    }
    private int getMove(List<Integer> list, int k){
            int e = 100;
            for(int j=0; j<list.size(); j = (j+k)){
                    if(list.get(j)==0) e = e-1; else e = e-3;
            }
            return e;
    }

    protected void pdfViewer(){
            Scanner in = new Scanner(System.in);
            int n = 26;
            int h[] = new int[n];
    for(int h_i=0; h_i < n; h_i++){
        h[h_i] = in.nextInt();
    }
            String word = in.next();
            HashMap<Character,Integer> alphabets=new HashMap<Character,Integer>();
            int i=0;
            for(char ch='a';ch<='z';ch++){
                    alphabets.put(ch, h[i]);
                    i++;
            }
            int max=0;
            int length=word.length();
            for(int j=0; j<length; j++){
                    int val=alphabets.get(word.charAt(j));
        if(val>max)
            max=val;
            }
            System.out.println(max*length);
    }

    protected void savePrisner(){
            Scanner s = new Scanner(System.in);
            int t = s.nextInt();
            for(int i=0; i<t; i++){
        int p = s.nextInt();
        int m = s.nextInt();
        int id = s.nextInt();
        if((m+id-1)%p==0)
        System.out.println(p);
        else 
        System.out.println((m+id-1)%p);
    }
    }

    protected void beautifulTriplets(){
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int d = in.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<n; i++){
                    int a = in.nextInt();
                    list.add(a);
            }
            int k=0;
            for(int j=0; j<list.size(); j++){
                    int b = list.get(j);
                    int c = b+d;
                    int f = b+2*d;
                    if(list.contains(c) && list.contains(f)) k++;
            }
            System.out.println(k);
    }

    protected void strangeCounter(){
            Scanner in = new Scanner(System.in);
            long n = in.nextLong();
            long a = 3;
            while(n > a){
                    n = n-a;
                    a = a*2;
            }
            System.out.println(a-n+1);		
    }

    protected void flatLandSpace(){
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c[] = new int[m];
        for(int i=0; i<m; i++){
            int ci = in.nextInt();
            c[i] = ci;
        }
        int llist[] = new int[n];
        int j=0;
        while(j<n){
            int minmax[] = new int[m];
            int k = 0;
            for(int e: c){
                int a;
                if(e < j){
                    a = j-e;
                }else{
                    a = e-j;
                }
                minmax[k] = a;                   
                k++;
            }
            int min = Arrays.stream(minmax).min().getAsInt();
            llist[j] = min;
            j++;
        }
        int max = Arrays.stream(llist).max().getAsInt();
        System.out.println(max);
        in.close();*/

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c[] = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        int distance = 0;
        for (int i = 0; i < n; i ++){
            int temp = Math.abs(i - c[0]);
            for (int j = 0; j < m; j++){
                temp = Math.min(temp, Math.abs(i - c[j]));
            }
            distance = Math.max(distance, temp);
        }
        System.out.println(distance); 
    }

    protected void studentsGrade(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0; i<n; i++){
            int grade = in.nextInt();
            System.out.println(grade < 38 || grade % 5 < 3 ? grade : grade + (5 - (grade % 5)));
        }
    }
    
    protected void hurdleRace(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        int max = Arrays.stream(height).max().getAsInt();
        System.out.println((max>k) ? (max-k) : 0);
    }
    
    protected void sequenceEquation(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            map.put(in.nextInt() , i); 
        }
        in.close();
        System.out.println(map);
        for(int i = 1; i <= n; i++){
            System.out.println(map.get(map.get(i)));
        }       
    }
}
