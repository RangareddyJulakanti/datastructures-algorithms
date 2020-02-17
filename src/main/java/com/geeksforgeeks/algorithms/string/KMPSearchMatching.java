package com.geeksforgeeks.algorithms.string;

public class KMPSearchMatching {
  public   void KPMSearch(char[] str,char[] ptr){
        int N=str.length;
        int M=ptr.length;
        LPS LPS=new LPS();
        int[] lps=new int[M];
        LPS.longestProperPrefix(ptr,lps);
        int i=0;
        int j=0;

        while(i<N){
            if(str[i]==ptr[j]){
                i++;
                j++;
            }

            if(j==M){
                System.out.println("Found pattern @ index"+(i-j));
                j=lps[j-1];
            }else if(i<N&&ptr[j]!=str[i]){
               if(j!=0){
                  j=lps[j-1];
               }else{
                   i=i+1;
               }

            }
        }


    }

}
