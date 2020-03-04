package com.geeksforgeeks.algorithms.string.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Decryption {

    public  Data decript(String primary,byte[] text,Integer lastPosition)
    {
        List<Integer> primaryKey = new ArrayList<>();
        List<byte[]> textArr = new ArrayList<>();
        List<Byte> res=new ArrayList<>();

        for(String i:primary.split(""))
        {
            primaryKey.add(Integer.parseInt(i));
        }
        int chunk=10;
        for (int i = 0; i < text.length; i += chunk) {
            textArr.add(Arrays.copyOfRange(text, i, Math.min(text.length, i + chunk)));
        }
        final int[] lastPostion = {lastPosition.intValue()};
        final int[] primaryPosition = {0};
        textArr.forEach( element->
                {
                    List<Byte> myBytes=new ArrayList<>();
                    for(Byte b:element)
                    {
                        myBytes.add(b);
                    }
                    while(lastPostion[0] < myBytes.size())
                    {
                        myBytes.remove(lastPostion[0]);
                        primaryPosition[0] +=1;
                        if (primaryPosition[0] == primaryKey.size())
                        {
                            primaryPosition[0] = 0;
                        }
                        lastPostion[0] = lastPostion[0] +primaryKey.get(primaryPosition[0]);
                    }
                    lastPostion[0]=lastPostion[0]-myBytes.size();
                    for(Byte b:myBytes)
                    {
                        res.add(b);
                    }
                }

        );


        return new Data(res,lastPostion[0]);
    }

}
