package com.developer.geeksforgeeks.algorithms.string;

import com.geeksforgeeks.algorithms.string.LPS;
import org.junit.Test;

public class LPSTest {
    @Test
    public void lpsTest(){
        LPS lpsObj=new LPS();
        char[] chars={'A','A','A','B','A','A','A','A','C'};
        int[] lps=new int[chars.length];
        lpsObj.longestProperPrefix(chars,lps);
        for (int k:lps) {
            System.out.println(k);
        }
    }
}
