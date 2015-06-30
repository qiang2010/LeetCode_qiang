package qiang.tree;

public class CountCompleteTreeNodes222 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countFullBinaryTreeNodesNum(0));
		String pre = "124536";//"12";
		String mid = "425163";//"21";
		TreeNode root = TreeAlg.buildTree(pre, 0, pre.length()-1, mid, 0, mid.length()-1);
		TreeAlg.preOrder(root);
		System.out.println("pre");
		System.out.println(countNodes(root));
	}
	/**
	 *  ������ȫ�������Ľڵ���Ŀ
	 *  1. ����һ����α���������ʱ�临�Ӷ��� O��N�����������з����ǳ�ʱ
	 *  2. �����������������ô֪��������ȣ����� 2^(N+1) - 1�����ǽڵ����
	 *     ��ȫ��������ֻ�����һ���ǲ����ģ��������ǾͿ������������������������
	 *     �Ӹ�һֱ�����ң��ҵ���󣬾��Ǹ���ȫ����������ȣ�����������ͬ�����������Եõ���������ȣ������ͬ����ʾ�������Ĳ���
	 *     ��Ȼ�������������������������Ѿ������������ˣ�ѭ������ȥ��ֱ��Ҷ�� 
	 * @param root
	 * @return
	 */
    public static int countNodes(TreeNode root) {
    	if(root == null)  return 0;
    	int sum = 0;
    	int leftD;
    	int rightD;
        while(true){ 
        	leftD = getDepth(root.left);
            rightD = getDepth(root.right);
            System.out.println(leftD + " " + rightD);
            if(leftD == -1){
            	sum+=1;
            	break;
            }
        	if(rightD == -1){
        		sum +=2;
        		break;
        	}
		     // ���������ͬ����ô��������������������������������
		     if(leftD == rightD){
		    	 if(leftD == 0 ) break;
		     	sum = sum + 1+ countFullBinaryTreeNodesNum(leftD);
		     	root = root.right;
		     }else{
		        // ��ͬ����ô������Ϊ������������������������
		        sum = sum +1 + countFullBinaryTreeNodesNum(rightD);
		        root = root.left;
		        //if(root == null ) break;
		    } 
		     
		}
    	return sum;
    }
    private static int getDepth(TreeNode root){
    	if(root == null) return -1; 
    	if(root.left == null) return 0;
    	int count = 0;
    	TreeNode temp = root.left;
    	while(temp!=null){
    		count++;
    		temp = temp.left;
    	}
    	System.out.println("count " +count);
    	return count;
    }
    private static int countFullBinaryTreeNodesNum(int depth){
    	if(depth == -1) return 0;
    	return  (2<<(depth))  - 1;
    }
}
