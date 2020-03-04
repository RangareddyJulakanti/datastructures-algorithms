package com.geeksforgeeks.datastructure.queue;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class Parent {

    private void persistFileInDB(MultipartFile multipartFile) throws IOException {
        FileChannel sourceChannel=((FileInputStream)multipartFile.getInputStream()).getChannel();
        int bufferSize=10;
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        try {
            for (int bytesRead = sourceChannel.read(buffer); bytesRead != -1; bytesRead = sourceChannel.read(buffer)) {
                buffer.flip(); // convert the buffer from writing data to buffer from disk to reading mode
                byte[] element=new byte[bufferSize];
                for(int i=0;i<buffer.limit();i++){
                    element[i]=buffer.get();
                }

                //TODO:(byte[] element) Need to persist in mongoDB element its consider as chunk using GridFSTemplate
                buffer.clear();
            }
        }finally {

        }

    }
}
