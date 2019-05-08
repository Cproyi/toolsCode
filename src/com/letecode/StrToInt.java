package com.letecode;

/**
 * @description 
 * 实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 
 * @author hy
 * @date 2019-05-07
 */
public class StrToInt {
	
	public static int myAtoi(String str) {
        if(str == null){
            return 0;
        }
        String trimStr = str.trim();
        if(trimStr.isEmpty()){
            return 0;
        }
        int length =trimStr.length();
        int start = 0;
        char[] strCharArr = trimStr.toCharArray();
        
        String preffix = "";
        String suffix = "";
        
        if("+-".indexOf(strCharArr[0])>-1){
        	preffix = String.valueOf(strCharArr[0]);
            start = 1;
        }
        boolean isValid = true;
        
        for(int i=start;i<length;i++){
            if(i == 0 && (strCharArr[i]<'0' || strCharArr[i]>'9')){
                isValid = false;
                break;
            }
            if('0'<=strCharArr[i] && strCharArr[i]<='9'){
            	suffix += String.valueOf(strCharArr[i]);
                
            }else{
                break;
            }
        }
        if(!isValid){
            return 0;
        }
        
        if(suffix.length() == 0) {
        	return 0;
        }
        
        while(suffix.startsWith("0")) {
        	suffix = suffix.substring(1, suffix.length());
        }
        
        if(suffix.length() == 0) {
        	return 0;
        }
        
    	String max = String.valueOf(Integer.MAX_VALUE);
    	String minWithMark = String.valueOf(Integer.MIN_VALUE);
    	String min = minWithMark.substring(1, minWithMark.length());
    	
    	if(!preffix.startsWith("-") && 
    			(suffix.length()>max.length() || 
    					((suffix.length() == max.length()) && suffix.compareTo(max)>=0))) {
    		return Integer.MAX_VALUE;
    	}
    	if(preffix.startsWith("-") && 
    			(suffix.length()>min.length() || 
    					((suffix.length() == min.length()) && suffix.compareTo(min)>=0))) {
    		return Integer.MIN_VALUE;
    	}
    	
    	return Integer.parseInt(preffix + suffix);
    }

	public static void main(String[] args) {
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi("-2147483649"));
		System.out.println(myAtoi("-"));
		System.out.println(myAtoi("+"));
		System.out.println(myAtoi("-2147483649"));
		System.out.println(myAtoi("  0000000000012345678"));
		System.out.println(myAtoi("    0000000000000   "));
	}
	
}
