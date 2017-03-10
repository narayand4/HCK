/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Scanner;

/**
 *
 * @author durgesh
 */
public class BitManuplationAlgo {
    protected void sumVsXor(){
        Scanner in = new Scanner(System.in);
	long n = in.nextLong();
        long count = 0;
        while(n>0){
            if((n&0x1)==0){
                count++;
            }
            n>>=1;
        }          
        System.out.println(String.format("%.0f",Math.pow(2, (double) count)));
    }
}
