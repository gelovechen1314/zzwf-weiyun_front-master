package cn.windy.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 序列化与反序列化
 */
public class SerializeUtil {

    private static Logger log = LoggerFactory.getLogger(SerializeUtil.class);
    //序列化
    public static byte [] serialize(Object obj){
        ObjectOutputStream obi=null;
        ByteArrayOutputStream bai=null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt=bai.toByteArray();
            return byt;
        } catch (IOException e) {
            log.error("序列化异常:",e);
        }finally{
            try {
                bai.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                obi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //反序列化
    public static Object unserizlize(byte[] byt){
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            Object obj=oii.readObject();
            return obj;
        } catch (Exception e) {
            log.error("反序列化异常:",e);
        }finally{
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oii.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
