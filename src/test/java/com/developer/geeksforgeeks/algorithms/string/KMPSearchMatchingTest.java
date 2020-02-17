package com.developer.geeksforgeeks.algorithms.string;

import com.geeksforgeeks.algorithms.string.KMPSearchMatching;
import org.junit.Test;

public class KMPSearchMatchingTest {
    @Test
    public void testKMPSearch(){
        KMPSearchMatching kmp=new KMPSearchMatching();
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        kmp.KPMSearch(txt.toCharArray(),pat.toCharArray());
    }
}
