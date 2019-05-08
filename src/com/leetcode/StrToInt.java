package com.leetcode;

/**
 * @description 
 * ʵ��һ�� atoi ������ʹ���ܽ��ַ���ת����������
 * ���ȣ��ú����������Ҫ�������õĿ�ͷ�ո��ַ���ֱ��Ѱ�ҵ���һ���ǿո���ַ�Ϊֹ��
 * ������Ѱ�ҵ��ĵ�һ���ǿ��ַ�Ϊ�����߸���ʱ���򽫸÷�����֮���澡���ܶ���������������������Ϊ�������������ţ������һ���ǿ��ַ������֣���ֱ�ӽ�����֮�������������ַ�����������γ�������
 * ���ַ���������Ч����������֮��Ҳ���ܻ���ڶ�����ַ�����Щ�ַ����Ա����ԣ����Ƕ��ں�����Ӧ�����Ӱ�졣
 * ע�⣺������ַ����еĵ�һ���ǿո��ַ�����һ����Ч�����ַ����ַ���Ϊ�ջ��ַ����������հ��ַ�ʱ������ĺ�������Ҫ����ת����
 * ���κ�����£����������ܽ�����Ч��ת��ʱ���뷵�� 0��
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
