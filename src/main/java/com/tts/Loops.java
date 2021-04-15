package com.tts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        int sum=0;
        int mult=1;
        int max=0;
        int min=0;
        int[] myarr= new int[5];
        Scanner scanner1=new Scanner(System.in);
        for(int i=0;i<5;i++){
            myarr[i]=scanner1.nextInt();
        }
        max=myarr[0];
        min=myarr[0];
        for(int i=0;i<5;i++){
            if(myarr[i]>max){
                max=myarr[i];
            }
            if(myarr[i]<min){
                min=myarr[i];
            }
            sum=myarr[i]+sum;
            mult=mult*myarr[i];
        }
        System.out.println("The max number of your entered numbers is:"+max);
        System.out.println("The min number of your entered numbers is:"+min);
        System.out.println("The sum of your entered numbers is:"+sum);
        System.out.println("The product of your entered numbers is:"+mult);
    }

    }




