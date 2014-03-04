
public class BinarySearchTree {
	public Node<Integer,Book> root;
	
	public void addNode(int key,Book e){
		Node<Integer,Book> newNode=new Node<>();
		newNode.setElement(key, e);
		
		if(root==null){
			root=newNode;
		}else{
			Node<Integer,Book> focusNode=root;
			Node<Integer,Book> parentNode;
			while(true){
				parentNode=focusNode;
				if(key<focusNode.key){
					focusNode=focusNode.left;
					if(focusNode==null){
						parentNode.left=newNode;
						break;
					}
				}else{
					focusNode=focusNode.right;
					if(focusNode==null){
						parentNode.right=newNode;
						break;
					}
				}
			}
		}
	}

}
