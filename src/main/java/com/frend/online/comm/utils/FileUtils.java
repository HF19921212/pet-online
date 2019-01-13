package com.frend.online.comm.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

    /**
     * 将MultipartFile转化为file并保存到服务器上的某地
     */
    public void saveFileFromInputStream(InputStream stream, String path, String savefile) throws IOException
    {
        FileOutputStream fs=new FileOutputStream( path + "/"+ savefile);
        //System.out.println("------------"+path + "/"+ savefile);
        byte[] buffer =new byte[1024*1024];
        int bytesum = 0;
        int byteread = 0;
        while ((byteread=stream.read(buffer))!=-1)
        {
            bytesum+=byteread;
            fs.write(buffer,0,byteread);
            fs.flush();
        }
        fs.close();
        stream.close();
    }

}
