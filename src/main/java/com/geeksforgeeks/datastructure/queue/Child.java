package com.geeksforgeeks.datastructure.queue;

import com.google.common.primitives.Bytes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Child extends Parent {
    public static void main(String[] args) {
        Encryption e=new Encryption();
        int chunk = 10; // chunk size to divide
        byte[] text= "rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakantiv&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakantiv&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti&rangareddyjulakanti".getBytes();
        List<byte[]> textArr=new ArrayList<>();
        for (int i = 0; i < text.length; i += chunk) {
            textArr.add(Arrays.copyOfRange(text, i, Math.min(text.length, i + chunk)));
        }

        for(byte[] textA:textArr){
            List<Byte> bytes= e.encript("234","769",textA);
            Decryption decryption=new Decryption();
            bytes= decryption.decript("234",Bytes.toArray(bytes));
            System.out.println(new String(Bytes.toArray(bytes)));
        }



    }
}
