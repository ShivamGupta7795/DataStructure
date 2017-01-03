
public class linkedlist {
	int data;
	linkedlist next;
	
	public linkedlist(int d){
		data = d;
	}
		
	public void insert(int d){
		linkedlist newnode = new linkedlist(d);
		newnode.data = d;	
		linkedlist current = this;
		
		while(current.next!=null){
			current= current.next;
		}
		current.next = newnode;
	}
	
	public int size(linkedlist list){
		int count=0;
		while(list!=null){
			count++;
			list = list.next;
		}
		return count;
	}
	
	public void display(){
		linkedlist current = this;
		
		while(current!=null)
		{System.out.println(current.data);
		current= current.next;}
	}
	
	public boolean delete(int d){
		linkedlist prev= this;
		linkedlist current = this;
		
		
		while(current!=null){
			if(current.data==d) {
				if(prev!=null){
					prev.next=current.next;
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
	
	public void rmduplicate(linkedlist list){
		boolean[] b = new boolean[128];
		linkedlist current = this;
		linkedlist prev = this;
		while(current!=null){
			if(b[current.data]){
				prev.next = current.next;
				current= current.next;
			}
			else{
			b[current.data] = true;
			prev = current;
			current= current.next;
			}
		}
	}
	
	public int findk(linkedlist list, int k){
		linkedlist current = this;
		linkedlist prev = this;
		int count=0;
		while(current!=null){
			if(count>k){
				prev=prev.next;
			}
			current = current.next;
			count++;
			
		}
		return prev.data;
	}
	
	public linkedlist concat(linkedlist list, int k){
		linkedlist beforefirst = null;
		linkedlist beforelast= null;
		linkedlist afterfirst = null;
		linkedlist afterlast = null;
		
		while(list!=null){
			linkedlist next = list.next;
			//System.out.println("next: "+next.data);
			//list.next= null;
			if(list.data<k){
				if(beforefirst == null){
					beforefirst = list;
					beforelast = beforefirst;
				}	
			else{
				beforelast.next= list;
				beforelast=list;
			}
		}
			else{
				if(afterfirst == null){
					afterfirst = list;
					afterlast = afterfirst;
				}
				else{
					afterlast.next = list;
					afterlast = list;
				}
			}
			list = next;
		}
		beforelast.next = afterfirst;
		return beforefirst;
	}
	
	public linkedlist listsum(linkedlist list1, linkedlist list2){
		
		linkedlist result = new linkedlist(0);

		while(list1!=null && list2!=null){
			int i = list1.data+list2.data;
			System.out.println("i: "+i);
			if(i>9){
				if(list1.next!=null)
					{list1.next.data+=1;
					result.insert(i-10);
					}
				else
					{result.insert(i-10);
					result.next.insert(1);}
			}
			else{				
				result.insert(i);;
			}
			list1= list1.next;
			list2= list2.next;	
		}
		
		return result;
	}
	
	public linkedlist reverse(linkedlist list){
		linkedlist forward = null;
		linkedlist prev =null;
		linkedlist current = list;
		while(list!=null){
			forward = list.next;
			list.next = prev;
			prev = list;
			list = forward;	
			System.out.println("prev:"+prev.data);
		}
		
		return prev;
	}
	
	public boolean detectloop(linkedlist list){
		if(list==null)
			return false;
		
		linkedlist fast = list;
		linkedlist slow = list;
		while(true){
		if(fast.next!=null){
			fast = fast.next.next;
		}
		else{return false;}
		
		if(slow != null || fast!=null){
			slow= slow.next;
		}
		else{return false;}
		
		if(slow==fast){
			return true;
		}
		}
		
	}
	public static void main(String ar[]){
		
		linkedlist ob = new linkedlist(2);
		linkedlist ob1 = new linkedlist(0);
		
		
		ob.insert(3);
		ob.insert(4);
		ob1.insert(9);
		ob1.insert(9);
		
		
	
//		ob.display();
		
//		if(ob.delete(1)){
//			System.out.println("delete successful");
//			ob.display(ob);
//		}
//		ob.rmduplicate(ob);
//		int i= ob.findk(ob, 4);
//		ob.display(ob);
		
//		System.out.println("i= "+i);
		
//		linkedlist l = ob.concat(ob, 6);
//		l.display(l);
		
//		linkedlist sum = ob1.listsum(ob, ob1);
//		sum.display();
		
//		linkedlist reverse = ob.reverse(ob);
//		reverse.display();
		
//		linkedlist current = ob;
//		
//		while(ob.next!=null)
//			ob = ob.next;
//		
//		ob.next = current;
//		
//		boolean i = ob.detectloop(ob);
//		System.out.println(i);
		
		
		
	}
}
