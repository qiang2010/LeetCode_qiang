package qiang.leetcode;

public class NumberOf1Bits191 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(3));
	}
    public static int hammingWeight(int n) {
        int count = 0 ;
       for(int i = 0; i<32;i++){
        	//if((n&1) == 1)count++; // ע���������
        	count+=(n&1); // ע���������
        	n =  n >> 1;
        }
        return count;
    }
}
