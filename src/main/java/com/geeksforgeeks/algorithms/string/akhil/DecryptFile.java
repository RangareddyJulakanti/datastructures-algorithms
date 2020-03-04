package com.geeksforgeeks.algorithms.string.akhil;

import com.google.common.primitives.Bytes;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DecryptFile {
    static  List<Byte> list=new ArrayList<>();
    static {
        list.add((byte)101);
        list.add((byte)2);
        list.add((byte)100);
        list.add((byte)32);
        list.add((byte)3);
        list.add((byte)116);
        list.add((byte)111);
        list.add((byte)32);
        list.add((byte)4);
        list.add((byte)99);
    }
    public static void main(String[] args) throws IOException {
        File fileInput = new File("F:\\projects\\new\\datastructures-algorithms\\target\\classestest.txttest.txt");
        FileChannel sourceChannel = (new FileInputStream(fileInput)).getChannel(); //file channel  read data from a file
        int bufferSize = 261120;
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        File output = new File(new ClassPathResource("/").getFile().getPath() +"decode.txt");
        output.createNewFile();
        int lastPosition=1;
        int primaryKeyPos=0;
        try (FileOutputStream fos = new FileOutputStream(output)) {
            for (int bytesRead = sourceChannel.read(buffer); bytesRead != -1; bytesRead = sourceChannel.read(buffer)) {
                buffer.flip(); // convert the buffer from writing data to buffer from disk to reading mode
                byte[] element = new byte[buffer.remaining()];
                buffer.get(element);
                Data needToWrite =  applyDecodeAlgo("123", element,lastPosition,primaryKeyPos);
                lastPosition=needToWrite.getLastPosition();
                primaryKeyPos=needToWrite.getPrimayKeyPos();
                fos.write(Bytes.toArray(needToWrite.getRes()));
                buffer.clear();
            }

        }
    }
    private static Data applyDecodeAlgo(String primary, byte[] text, Integer lastPosition, Integer primaryPos) {
        List<Integer> primaryKey = new ArrayList<>();
        List<byte[]> textArr = new ArrayList<>();
        List<Byte> res = new ArrayList<>();

        for (String i : primary.split("")) {
            primaryKey.add(Integer.parseInt(i));
        }
        int chunk = 10;
        for (int i = 0; i < text.length; i += chunk) {
            textArr.add(Arrays.copyOfRange(text, i, Math.min(text.length, i + chunk)));
        }
        final int[] lastPostion = {lastPosition.intValue()};
        final int[] primaryPosition = {primaryPos.intValue()};
        textArr.forEach(element ->
                {
                    List<Byte> myBytes = new LinkedList<>();
                    for (Byte b : element) {
                        myBytes.add(b);
                    }
                    if( myBytes.containsAll(list)){
                        System.out.println(Thread.currentThread().getName());
                    }
                    while (lastPostion[0] < myBytes.size()) {
                        myBytes.remove(lastPostion[0]);
                        primaryPosition[0] += 1;
                        if (primaryPosition[0] == primaryKey.size()) {
                            primaryPosition[0] = 0;
                        }
                        lastPostion[0] = lastPostion[0] + primaryKey.get(primaryPosition[0]);
                    }
                    lastPostion[0] = lastPostion[0] - myBytes.size();
                    for (Byte b : myBytes) {
                        if(b.intValue()==2||b.intValue()==3||b.intValue()==4){
                            System.out.println(Thread.currentThread().getName());
                        }
                        res.add(b);
                    }

                }

        );

        Data data = new Data(res, lastPostion[0]);
        data.setPrimayKeyPos(primaryPosition[0]);
        return data;
    }


}
