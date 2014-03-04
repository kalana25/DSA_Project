
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

	public void inOrderTravers(Node<Integer,Book> node,String keyword){
		if(node.left!=null){
			inOrderTravers(node.left,keyword);	
		}
		if(findString(node.getElement().getbName(), keyword)!=-1){
			System.out.println(node.getElement().getbName());
		}
		if(node.right!=null){
			inOrderTravers(node.right,keyword);
		}		
	}
	
	public int findString(String str, String key){
		int pos=str.indexOf(key);
		return pos;
	}
	
	public boolean delete(int key){
		Node<Integer,Book>current=root;
		Node<Integer,Book>parent=root;
		boolean isALeftChild=true;
		while(current.key!=key){
			parent=current;
			if(current.key>key){
				isALeftChild=true;
				current=current.left;
			}else{
				isALeftChild=false;
				current=current.right;
			}
			if(current==null)
				return false;
		}
		//either root or leaf node
		if(current.left==null && current.right==null){
			if(current==root)
				root=null;
			else if(isALeftChild)
				parent.left=null;
			else
				parent.right=null;
		}else if(current.right==null){
			if(current==root)
				root=current.left;
			else if(isALeftChild)
				parent.left=current.left;
			else
				parent.right=current.left;
		}else if(current.left==null){
			if(current==root)
				root=current.right;
			else if(isALeftChild)
				parent.left=current.right;
			else
				parent.right=current.right;
		}else{
			Node<Integer,Book> succ=getSuccessor(current);
			if(current==root)
				root=succ;
			else if(isALeftChild)
				parent.left=succ;
			else
				parent.right=succ;
			succ.left=current.left;
		}
		return true;
	}
	
	public Node<Integer,Book> getSuccessor(Node<Integer,Book> delNode){		
		Node<Integer,Book> successorPare=delNode;
		Node<Integer,Book> successor=delNode;
		Node<Integer,Book> curr=delNode.right;
		while(curr!=null){
			successorPare=successor;
			successor=curr;
			curr=curr.left;
		}
		if(successor!=delNode.right){
			successorPare.left=successor.right;
			successor.right=delNode.right;
		}
		return successor;
	}

}
