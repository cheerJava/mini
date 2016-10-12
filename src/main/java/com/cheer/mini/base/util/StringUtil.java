package com.cheer.mini.base.util;


import java.util.Random;

public class StringUtil {
    
    static int DEFAULT_UUID_LENGTH = 32;

    private static Random randomer = new Random();

    private static char[] QUID_AlphaNumerArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static char[] QUID_AlphaArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 
     * @param length
     * @return
     */
    public static String createQUID(int length) {
        StringBuilder str_builer = new StringBuilder();
        char c = '\0';
        c = QUID_AlphaArray[randomer.nextInt(QUID_AlphaArray.length)];
        str_builer.append(c);
        for (int i = 0; i < length - 1; i++) {
            c = QUID_AlphaNumerArray[randomer.nextInt(QUID_AlphaNumerArray.length)];
            str_builer.append(c);
        }
        return str_builer.toString();
    }

    /**
     * 创建32位UUID字符
     * 
     * @param length
     * @return
     */
    public static String createUUID() {
        return createQUID(DEFAULT_UUID_LENGTH);
    }
    
    /**
     * 判断字段是否为空
     * 
     * @param str
     * @return
     */
    static public boolean isEmpty(String str) {
        if (str == null) return true;
        if ("".equals(str.trim())) return true;
        // ----------------------------------------------------------------------------------
        return false;
    }

    /**
     * 判断字符是否为非空
     * 
     * @param str
     * @return
     */
    static public boolean notEmpty(String str) {
        return !isEmpty(str);
    }
    
    public static void main(String[] args){
    	for(int i=0;i<100;i++){
    		System.out.println(createUUID());
    	}
    }
}
