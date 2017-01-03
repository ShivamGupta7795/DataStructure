import java.util.ArrayList;
import java.util.Stack;

public class stack {
linkedlist top;
int count=0;
//stack min = new stack();
minstack min = new minstack();

	public linkedlist pop(){
		if(top!=null){
			if(min.top.data==top.data)
				min.pop();
			top = top.next;
			count--;
			return top;
		}
		else
			return null;
	}
	
	public void push(int d){
		linkedlist node = new linkedlist(d);
		if(top==null){	
			min.push(node.data);
			top = node;
			count++;
		}
		else{
		node.next = top;
		top = node;
		count++;
		if(top.data<min.top.data){
			min.push(top.data);
		}
		}
	}
	
	public linkedlist display(){
		if(min.top!=null){
			return min.top;
		}
		else
			return null;
	}
	
	public int size(){
		return count;
	}
	
	public static void main(String ar[]){

		stack s = new stack();
		s.push(5);
		s.push(2);
		s.push(4);
		s.push(3);
		s.push(1);
		linkedlist min = s.display();
		System.out.println(min.data);
		s.pop();
		s.pop();
		min = s.display();
		System.out.println(min.data);
		
		SetofStack set = new SetofStack();
		
		set.push(1);
		set.push(2);
		set.push(3);
		set.push(4);
		set.push(5);
		set.push(6);
		set.push(7);
		set.push(8);
		set.push(9);
		set.push(11);
		set.push(12);
		set.push(13);
		set.push(14);
		set.display();
		System.out.println("popped element: "+set.pop());
		System.out.println("popped element: "+set.pop());
		System.out.println("popped element: "+set.pop());
		
		queueviastack ob = new queueviastack();
		ob.enqueue(1);
		ob.enqueue(2);
		ob.enqueue(3);
		ob.peek();
		ob.dequeue();
		ob.peek();
		ob.dequeue();
		ob.peek();
		ob.dequeue();
	
	}

}
 
 class minstack{
	linkedlist top;
	public void push(int i){
		linkedlist node = new linkedlist(i);
		if(top==null){
			top = node;
		}
		else{
			node.next = top;
			top = node;
		}
	}
	public linkedlist pop(){
		if(top!=null){
			linkedlist i = top;
			top = top.next;
			return i;
		}
		else{
			return null;
		}
	}
}

 
class SetofStack{
	
	ArrayList<Stack> al = new ArrayList<Stack>();
	
	
	public Stack getLastStack(){
		if(al.isEmpty()){
			return null;
		}
		else{
			return al.get(al.size()-1);		
		}
	}
	
	public void push(int i){
		Stack laststack = getLastStack();
		
		if(laststack!=null && laststack.size()<4){	
				laststack.push(i);				
		}		
		
		else{
			Stack s = new Stack();
			s.push(i);
			al.add(s);
		}	
	}
	public int pop(){
		Stack laststack = getLastStack();
		if(!laststack.isEmpty()){
			int i = (int)laststack.pop();
			return i;
		}
		else{
			al.remove(laststack);
			laststack = getLastStack();
			int i = (int)laststack.pop();
			return i;
		}
	}
	
	public void display(){
		for(int i=0;i<al.size();i++){
			Stack s= al.get(i);
			System.out.println("stack top: "+(int)s.peek()+"\narraylist size: "+al.size()+"\nstack size: "+s.size());
		}
	}
}
class queue{
	linkedlist last;
	linkedlist first;
	public void enqueue(int d){
		linkedlist node = new linkedlist(d);
		if(first==null){
			last = node;
			first = last;
		}
		else{
			last.next = node;
			last = node;
		}	
	}
	public linkedlist dequeue(){
		if(first !=null){
			linkedlist item = first;
			first = first.next;
			return item;
		}
		return null;
	}
}

class queueviastack{
	Stack in = new Stack();
	Stack out = new Stack();
	
	public void enqueue(int i){
		in.push(i);
	}
	public void dequeue(){
		shiftinout();
		out.pop();
	}
	public void peek(){
		shiftinout();
		System.out.println(out.peek());
	}
	public void shiftinout(){
		if(out.isEmpty()){
			while(!in.isEmpty()){
				out.push(in.pop());
			}
		}
	}
}
