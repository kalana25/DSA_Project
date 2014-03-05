
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
	
	public Node<Integer,Book> search(int key){
		Node<Integer,Book> current=root;
		while(current.key!=key){
			if(current.key>key){
				current=current.left;
			}else{
				current=current.right;
			}
			if(current==null){
				return null;
			}
		}
		return current;
	}

	public void PrintByKeyword(Node<Integer,Book> node,String keyword){
		if(node.left!=null){
			PrintByKeyword(node.left,keyword);	
		}
		if(findString(node.getElement().getTitle(), keyword)!=-1){
			System.out.println(node.getElement().getTitle());
		}
		if(node.right!=null){
			PrintByKeyword(node.right,keyword);
		}		
	}
	
	public void InOrderTraverse(Node<Integer,Book> node){
		String format = "%-30s%-15s%-15s%s%n";
		if(node.left!=null){
			InOrderTraverse(node.left);	
		}
		System.out.printf(format,node.getElement().getTitle(),node.getElement().getIsbn(),node.getElement().getAuthorName(),node.getElement().getAuthorSurname());
		if(node.right!=null){
			InOrderTraverse(node.right);
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
