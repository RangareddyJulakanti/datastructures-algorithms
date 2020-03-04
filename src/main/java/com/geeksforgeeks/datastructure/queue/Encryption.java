package com.geeksforgeeks.datastructure.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encryption {

    public  List<Byte> encript(String primary, String secondary, byte[] text)
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
        final int[] lastPostion = {primaryKey.get(0)};
        final int[] secondaryPosition = {0};
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
                  //  lastPostion[0] = lastPostion[0] -myBytes.size();
                    for(Byte b:myBytes)
                    {
                        res.add(b);
                    }


                }

        );

        return res;

    }
}
