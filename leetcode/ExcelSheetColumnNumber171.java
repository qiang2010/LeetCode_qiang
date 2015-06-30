package qiang.leetcode;

import java.awt.image.ConvolveOp;
import java.awt.image.TileObserver;

public class ExcelSheetColumnNumber171 {

	/**
	 *  �� 168 ���Ӧ
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(titleToNumber("AB"));
		int i = 26*5;
		for(;i<710;i++)
		System.out.println(i+" "+convertToTitle(i));
	}
	
	/**
	 *  �൱�� 10���� ת��Ϊ 26 ���ƣ�ֻ����A - Z��ʾ
	 * @param n
	 * @return
	 */
	public static String convertToTitle(int n) {
		StringBuilder result = new StringBuilder();
		//n-=1;
		int remender;
		while(n != 0 ){
			//if(n==0)remender +=1;
			
			remender = (n-1)%26;
			n=(n-1)/26;
			result.append((char)(remender+'A'));
		}
		return result.reverse().toString();
	}
	
//	StringBuilder result = new StringBuilder();
//	//n-=1;
//	int remender = n%26;
//	n /= 26;
//	
//	while(n != 0 || remender!= 0){
//		//if(n==0)remender +=1;
//		result.append((char)(remender+'A'));
//		remender = n%26;
//		n/=26;
//	}
	
	
    public static int titleToNumber(String s) {
    	s = s.toUpperCase();
        int len = s.length();
        int cur ;
        int result= 0;
        int a = 26;
        int b = 1;
        for(int i = len-1;i>=0;i--){  // java �ַ���λ�ã� 0 - len-1����������Ҫ��len-1��ʼ
        	cur = s.charAt(i)-'A'+1; // java ��char ��int Ҳ�ǿ����໥ת����
        	result = result + cur*b; 
        	b *=a;
        }
    	return result;
    }
}
