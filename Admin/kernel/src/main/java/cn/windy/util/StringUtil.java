package cn.windy.util;

import cn.windy.redis.Counter;

import java.util.regex.Pattern;

public class StringUtil {

    public static boolean isNumber(String str){
        boolean result = false;
        char []chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='0' && chars[i]<='9'){
                result = true;
            }else{
                result = false;
                return result;
            }
        }
        return result;
    }


    public static boolean isBlank(String str){
        if(null == str) return true;
        if("".equals(str.trim())) return true;
        return false;
    }

    /**
     *
     * @param str str的内容是不是 字符串 null，而不是空null
     * @return
     */
    public static boolean isNull(String str){
        if(isBlank(str)) return false;
        if("null".equalsIgnoreCase(str)) return true;
        return false;
    }

    public static String clearNull(String str){
        if(isBlank(str) || "null".equalsIgnoreCase(str)) return "";
        return str.trim();
    }

    /**
     * 转化数据的大小端模式
     * @param hex
     * @return
     */
    public static String hexReverse(String hex){
        StringBuilder stringBuilder = new StringBuilder();
        int size = hex.length()/2;

        for(int i=size;i>0;i--){
            stringBuilder.append(hex.substring((i-1)*2,(i)*2));
        }
        return stringBuilder.toString();
    }

    /**
     * 16进度转化为10进度
     * @param hex
     * @return
     */
    public static long hex2Int(String hex){
        return Long.parseLong(hex,16);
    }

    public static long reverseHex2Int(String hex){
        return hex2Int(hexReverse(hex));
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static String trim0(String str){
        return str.replaceAll("^(0+)", "");
    }

    /**
     * 将手机上的sim号转化
     * 字符串转换成为16进制(无需Unicode编码)
     * @param str
     * @return
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString().trim();
    }

    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

    public static String add0Pre(Long num){
        String str = Long.toHexString(num).toUpperCase();
        int len = str.length();
        for(int i=0;i<8-len;i++){
            str = "0"+str;
        }
        return str;
    }

    public static String getOrderNo(){
        return add0Pre(Counter.get());
    }

    public static String getShortCode(String code,String port){
        code = code.substring(4,6) + code.substring(2,4) + code.substring(0,2);
        int intCode = Integer.parseInt(code,16);
        StringBuilder shortCode = new StringBuilder();
        shortCode.append(intCode);
        shortCode.append(Integer.parseInt(port,16)+1);
        return shortCode.toString();
    }

    public static void main(String[] args) {
        //89860785161770390385
        //8986061703005756834V
        System.out.println(hexStr2Str("3839383630363137303330303537353638333456"));
        System.out.println(getShortCode("C60B0002","00"));
    }
}
