package com.geeksforgeeks.algorithms.string.akhil;

import com.geeksforgeeks.datastructure.queue.Parent;
import com.google.common.primitives.Bytes;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class EncryptFile {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        File f= new File("test.txt");
        prepareAlgoAndSave("123","456",f);
    }
    private static void prepareAlgoAndSave(String primaryKey, String secondaryKey, File multipartFile) throws IOException, ExecutionException, InterruptedException {
        Encryption e=new Encryption();
        FileChannel sourceChannel = (new FileInputStream(multipartFile)).getChannel(); //file channel  read data from a file
        int bufferSize = 1024 * 200;
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        File file=new File(new ClassPathResource("/").getFile().getPath()+ multipartFile.getName()+"test.txt");
        file.createNewFile();
        try (FileOutputStream fos = new FileOutputStream(file)) {
            Integer lastPosition=1;
            Integer primayKeyPos=0;
            Integer secondaryKeyPos=0;
            for (int bytesRead = sourceChannel.read(buffer); bytesRead != -1; bytesRead = sourceChannel.read(buffer)) {
                buffer.flip(); // convert the buffer from writing data to buffer from disk to reading mode
                byte[] element = new byte[buffer.remaining()];
                buffer.get(element);
                Data needToWrite =applyAlgo(primaryKey, secondaryKey, element,lastPosition,primayKeyPos,secondaryKeyPos);
                lastPosition= needToWrite.getLastPosition();
                primayKeyPos=needToWrite.getPrimayKeyPos();
                secondaryKeyPos=needToWrite.getSecondaryKeyPos();
                fos.write(Bytes.toArray(needToWrite.getRes()));
                buffer.clear();
            }
        }catch(IOException ioException){

            throw new RuntimeException("exception is raised while processing data");
        }finally {
           // file.delete();
        }

    }


    private static Data applyAlgo(String primary, String secondary, byte[] text,Integer lastPosition,Integer primaryKeyPos,Integer secondaryKeyPos) {
        List<Integer> primaryKey = new ArrayList<>();
        List<String> secondaryKey = new ArrayList<>();
        List<byte[]> textArr = new ArrayList<>();
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
        final int[] primaryPosition = {primaryKeyPos.intValue()};

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
        Data data=new Data(res,lastPostion[0]);
        data.setPrimayKeyPos(primaryKeyPos);
        data.setSecondaryKeyPos(secondaryKeyPos);
        return  data;

    }
}
