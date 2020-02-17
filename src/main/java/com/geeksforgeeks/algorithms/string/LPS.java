package com.geeksforgeeks.algorithms.string;

/**
 * Longest proper prefix suffix
 */
public class LPS {
    /**
     * Pi table for pattern matching algorithm(RPM)
     */
    public void longestProperPrefix(char str[],int lps[]){
        int n=lps.length;
        int len=0;
        int i=1;

        while(i<n){
            if(str[i]==str[len]){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len==0){
                    lps[i]=0;
                    i++;
                }else{
                    len=lps[len-1];
                }

            }
        }

    }
}
