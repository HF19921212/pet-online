package util;

import java.io.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sun.misc.BASE64Encoder;

/**
 * 将图片转换为Base64<br>
 * 将base64编码字符串解码成img图片
 */
public class Img2Base64Util {

    /** 
     * file转base64 
     * @param imgFile 文件 
     * @return        
     */
    public static String getImageBase64one(CommonsMultipartFile file){
        if(file==null||file.equals("")){
            return "";
        }
        InputStream in=null;
        byte[] data=null;

        DiskFileItem fi= (DiskFileItem) file.getFileItem();
        File file1=fi.getStoreLocation();
        try{
            in = new FileInputStream(file1);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }catch(IOException e){
                e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        String code = encoder.encode(data);
        return code;
    }

    /**
     * 对字节数组字符串进行Base64解码并生成图片
     * @param imgStr 图片数据
     * @param imgFilePath 保存图片全路径地址
     * @return
     */
    public static boolean generateImage(String imgStr,String imgFilePath){
        //
        if (imgStr == null) //图像数据为空
            return false;
        try
        {
            //Base64解码
            byte[] b = Base64.decodeBase64(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

}