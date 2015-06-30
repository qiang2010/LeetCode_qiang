package qiang.tree;

public class TreeAlg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String first = "abdegcfh";
		String mid = "dbgeafhc";
		//TreeAlg  treeAlg = new TreeAlg();
		TreeNode root = TreeAlg.buildTree(first, 0, first.length()-1, mid, 0, mid.length()-1);
		TreeAlg.postOrder(root);
		System.out.println();
		TreeAlg.preOrder(root);
		System.out.println();
		TreeAlg.minOrder(root);
	}

	
	/**
	 * �����ȸ����и���������������
	 *  
	 * @param list
	 * @return
	 */
	public static  TreeNode buildTree(String first,int fb,int fe, String mid,int mf,int me){
		if(fb>fe || mf> me) return null;
		char rootCont = first.charAt(fb);
		// ���и������У����ҵ�ǰ��
		int rootIndex = 0;
		for(int k = mf; k <= me ;k++){
			if(rootCont == mid.charAt(k)){
				rootIndex = k;
				break;
			}
		}
		// 
		TreeNode rootTreeNode = new TreeNode();
		rootTreeNode.val = rootCont;
		int leftSize = rootIndex - mf;
		rootTreeNode.left = buildTree(first,fb+1,fb+leftSize,mid,mf,rootIndex-1);
		rootTreeNode.right = buildTree(first,fb+1+leftSize,fe,mid,rootIndex+1,me);
		//System.out.println("depth");
		return rootTreeNode;
	}
	
	public static void postOrder(TreeNode root){
		if(root == null ) return ;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val+" ");
	} 
	public static void preOrder(TreeNode root){
		if(root == null) return;
		System.out.print(root.val+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void  minOrder(TreeNode root){
		if(root == null)  return ;
		minOrder(root.left);
		System.out.print(root.val+" ");
		minOrder(root.right);
	}
}
class TreeNode {
	TreeNode left,right;
	int  val;
	TreeNode(){
		left = right = null;
		val = -1;
	}
	
}
