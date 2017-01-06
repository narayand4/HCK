package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DpAlgo {
	/*
     * 5
		110
		53 361 188 665 786 898 447 562 272 123 229 629 670 848 994 54 822 46 208 17 449 302 466 832 931 778 156 39 31 777 749 436 138 289 453 276 539 901 839 811 24 420 440 46 269 786 101 443 832 661 460 281 964 278 465 247 408 622 638 440 751 739 876 889 380 330 517 919 583 356 83 959 129 875 5 750 662 106 193 494 120 653 128 84 283 593 683 44 567 321 484 318 412 712 559 792 394 77 711 977 785 146 936 914 22 942 664 36 400 857
		
		82
		520 862 10 956 498 956 991 542 523 664 378 194 76 90 753 868 837 830 932 814 616 78 103 882 452 397 899 488 149 108 723 22 323 733 330 821 41 322 715 917 986 93 111 63 535 864 931 372 47 215 539 15 294 642 897 98 391 796 939 540 257 662 562 580 747 893 401 789 215 468 58 553 561 169 616 448 385 900 173 432 115 712
		
		199
		761 706 697 212 97 845 151 637 102 165 200 34 912 445 435 53 12 255 111 565 816 632 534 617 18 786 790 802 253 502 602 15 208 651 227 305 848 730 294 303 895 846 337 159 291 125 565 655 380 28 221 549 13 107 166 31 245 308 185 498 810 139 865 370 790 444 27 639 174 321 294 421 168 631 933 811 756 498 467 137 878 40 686 891 499 204 274 744 512 460 242 674 599 108 396 742 552 423 733 79 96 27 852 264 658 785 76 415 635 895 904 514 935 942 757 434 498 32 178 10 844 772 36 795 880 432 537 785 855 270 864 951 649 716 568 308 854 996 75 489 891 331 355 178 273 113 612 771 497 142 133 341 914 521 488 147 953 26 284 160 648 500 463 298 568 31 958 422 379 385 264 622 716 619 800 341 732 764 464 581 258 949 922 173 470 411 672 423 789 956 583 789 808 46 439 376 430 749 151
		
		161
		134 415 784 202 34 584 543 119 701 7 700 959 956 975 484 426 738 508 201 527 816 136 668 624 535 108 1 965 857 152 478 344 567 262 546 953 199 90 72 900 449 773 211 758 100 696 536 838 204 738 717 21 874 385 997 761 845 998 78 703 502 557 47 421 819 945 375 370 35 799 622 837 924 834 595 24 882 483 862 438 221 931 811 448 317 809 561 162 159 640 217 662 197 616 435 368 562 162 739 949 962 713 786 238 899 733 263 781 217 477 220 790 409 383 590 726 192 152 240 352 792 458 366 341 74 801 709 988 964 800 938 278 514 76 516 413 810 131 547 379 609 119 169 370 502 112 448 695 264 688 399 408 498 765 749 925 918 458 913 234 611
		
		51
		512 125 928 381 890 90 512 789 469 473 908 990 195 763 102 643 458 366 684 857 126 534 974 875 459 892 686 373 127 297 576 991 774 856 372 664 946 237 806 767 62 714 758 258 477 860 253 287 579 289 496
     */
    public void dpEqual(){
    	Scanner in = new Scanner(System.in);
    	int T = in.nextInt();
    	int N = in.nextInt();
    	for(int i=0; i<T; i++){
    		List<Integer> list = new ArrayList<Integer>();
    		for(int j=0; j<N; j++){
    			int a = in.nextInt();
    			list.add(a);
    		}
    		Collections.reverse(list);
    		System.out.println(countEqualProcess(list, 0, list.get(0)));
    		//System.out.println(list);
    	}
    }
    private static int countEqualProcess(List<Integer> list, int processCount, int baseLine){
    	if(sumArr(list,baseLine)==list.size())
    		return processCount;    	
    	int count = equal(list, baseLine);
    	return countEqualProcess(list, processCount = processCount+count, baseLine);
    }
    private static int equal(List<Integer> list, int baseLine){
    	int countA = 0, countB = 0, countC = 0, count = 0;
    	int mVal = 0;
    	for(int j=0; j<list.size(); j++){
	    	mVal = getDiff((baseLine-list.get(j)));
	    	if(mVal>=5){
	    		list.set(j, list.get(j)+5);
	    		countA++;
	    	}
    	}
    	for(int j=0; j<list.size(); j++){
    		mVal = getDiff((baseLine-list.get(j)));
    		if(mVal<5 && mVal >= 2){
    			list.set(j, list.get(j)+2);
    			countB++;
    		}
    	}  
    	for(int j=0; j<list.size(); j++){
    		mVal = getDiff((baseLine-list.get(j)));
    		if(mVal<2 && mVal<=1){
    			list.set(j, list.get(j)+1);
    			countC++;
    		}
    	} 
    	if(countA>0)
    		count = count+1;
    	if(countB>0)
    		count = count+1;
    	if(countC>0)
    		count = count+1;
    	System.out.println(list);
    	return count;
    }
    private static int sumArr(List<Integer> list, int baseLine){
    	int sum = 0;
    	for(int i=0; i<list.size(); i++){
    		if((baseLine-list.get(i))==0){
    			sum++;
    		}
    	}
    	return sum;
    }
    private static int getDiff(int diff){
    	int mVal = 0;
    	if(diff>=5)
    		mVal = 5;	    	
    	if(diff<5 && diff >=2)
    		mVal = 2;	    	
    	if(diff<2 && diff >=1)
    		mVal = 1;
    	return mVal;
    }
    
    public void dpCoinChange(){
    	Scanner in = new Scanner(System.in);
    	int M = in.nextInt();
    	int N = in.nextInt();
    	int arr[] = new int[N];
    	for(int i=0; i<N; i++){
    		int a = in.nextInt();
    		arr[i] = a;
    	}
    	int n = arr.length;
    			
    	System.out.println(count( arr, n, M ));
    }
    private static long count( int S[], int m, int n )
    {
        long[] table = new long[n+1]; 
        Arrays.fill(table, 0); 
        table[0] = 1; 
        for (int i=0; i<m; i++){
            for (int j=S[i]; j<=n; j++){
            	table[j] += table[j-S[i]];
            	System.out.println("j: "+j+", i: "+i+", S: "+S[i]+", table: "+table[j]);
            }
            System.out.println("");
        }
        return table[n];
    }
}
