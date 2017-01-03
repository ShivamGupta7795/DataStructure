import java.util.ArrayList;;
public class customhash<K,V>{
	int capacity;
	ArrayList<customnode> table = new ArrayList<customnode>();
	public customhash(int capacity){
		this.capacity= capacity;
	}
	
	static class customnode<K,V>{
		customnode next;
		K key;
		V value;
		
		public customnode(K k, V v){
			key = k;
			value = v;
			next = null;
		}
	}
	
	
	public V put(K key,V value){
		int hash = hash(key);
		customnode<K,V> node = new customnode<K,V>(key,value);
		if(table.get(hash)==null){
			table.add(hash,node);
		}
		else{
			customnode<K,V> current = table.get(hash);
			while(current.next!=null){
				if(current.key == node.key){
					current.value = node.value;
					return value;
				}
				current= current.next;
			}	
				current.next= node;
		}
		return value;
	}
	
	public V get(K key){
		int hash = hash(key);
		
		customnode<K,V> current = table.get(hash);
		
		while(current!=null){
			if(current.key==key){
				return current.value;
			}
			current = current.next;
		}	
		return null;
	}
	
	public boolean remove(K deletekey){
		int hash = hash(deletekey);
		
		customnode<K,V> current = table.get(hash);
		customnode<K,V> prev =null;
		
		while(current!=null){
			if(current.key.equals(deletekey)){
				if(prev!=null){
					prev.next = current.next;
					return true;
				}
				else{
					current=current.next;
					return true;
				}
			}	
			prev = current;
			current = current.next;
		}	
		return false;
	}
	
	public int hash(K key){
		return Math.abs(key.hashCode())%capacity;
	}	
}
