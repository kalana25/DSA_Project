
public class Node<K,V> {
	public Node<K,V> left;
	public Node<K,V> right;
	private V element;
	public K key;
	
	public void setElement(K k,V v){
		element=v;
		key=k;
	}
	public V getElement(){
		return element;
	}
}
