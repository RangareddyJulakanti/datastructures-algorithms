package com.geeksforgeeks.algorithms.string.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encryption {

    public  Data encript(String primary, String secondary, byte[] text,Integer lastPosition,Integer primayKeyPos,Integer secondaryKeyPos)
    {
        List<Integer> primaryKey = new ArrayList<>();
        List<String> secondaryKey = new ArrayList<>();
        List<byte[]> textArr = new ArrayList<>();
        byte[] extraString ;
        List<Byte> res=new ArrayList<>();

        for(String i:primary.split(""))
        {
            primaryKey.add(Integer.parseInt(i));
        }

        for(String i:secondary.split(""))
        {
            secondaryKey.add(i);
        }
        int chunk=10;
        for (int i = 0; i < text.length; i += chunk) {
            textArr.add(Arrays.copyOfRange(text, i, Math.min(text.length, i + chunk)));
        }
        final int[] lastPostion = {lastPosition.intValue()};
        final int[] secondaryPosition = {secondaryKeyPos.intValue()};
        final int[] primaryPosition = {primayKeyPos.intValue()};

        textArr.forEach( element->

                {
                    List<Byte> myBytes=new ArrayList<>();

                    for(Byte b:element)
                    {
                        myBytes.add(b);
                    }

                    while(lastPostion[0] < myBytes.size())
                    {
                        Byte temp1=new Byte(secondaryKey.get(secondaryPosition[0]));
                        myBytes.add(lastPostion[0],temp1);
                        lastPostion[0] +=1;
                        primaryPosition[0] +=1;
                        secondaryPosition[0] +=1;
                        if (secondaryPosition[0] == secondaryKey.size())
                        {
                            secondaryPosition[0] = 0;
                        }
                        if (primaryPosition[0] == primaryKey.size())
                        {
                            primaryPosition[0] = 0;
                        }

                        lastPostion[0] = lastPostion[0] +primaryKey.get(primaryPosition[0]);

                    }
                    lastPostion[0] = lastPostion[0] -myBytes.size();
                    for(Byte b:myBytes)
                    {
                        res.add(b);
                    }


                }

        );

        return new Data(res,lastPostion[0]);

    }
}
