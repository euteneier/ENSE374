//Programmer: Nathan Euteneier
//Lab 3
//
//I put both classes in one file because i couldn't 
//get the main class to find the list class and 
//couldn't figure out why.

public class Main {
	public List first;

	public List last; 

	public Main() {
		first = null; 
		last = null;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public void addElement(int data){
		List newElement = new List();
		newElement.setData(data);
		if (isEmpty()) 
			first = newElement; 
		else {
			last.setNext(newElement); 
		}
		last = newElement; 
	}

	public List deleteElement(int data){
		List current = first; 
		List LPrevious = new List();
		while (current.getData() != data)
		{
			LPrevious = current;
			current = current.getNext();
			if (current == null)
				return null;
		}
		if (current == first)
			first = current.getNext(); 
		else
			LPrevious.setNext(current.getNext());

		return current;
	}
	
	public List getElement(int data){
		List current = first; 
		while (current.getData() != data)
		{
			current = current.getNext();
			if (current == null)
			{
				System.out.print("Element Doesn't Exist");
				System.out.println("");
				return null;
			}
		}
		current.printNode();
		return current;
	}

	public void printLinkedListHead() {
		List current = first;
		while (current != null)
		{
			current.printNode();
			current = current.getNext();
		}
		System.out.println("");
	}

	public void printLinkedListTail(List node) {
		if (node != null) {
			printLinkedListTail(node.getNext());
			node.printNode();
		}
	}

	public static void main(String[] args) {
		Main list = new Main();

		list.addElement(22);
		list.addElement(44);
		list.addElement(33);
		list.addElement(55);

		list.printLinkedListHead();
		list.printLinkedListTail(list.first);
		System.out.println("");

		list.deleteElement(11);
		list.deleteElement(44);
		list.deleteElement(33);

		list.printLinkedListHead();
		
		list.getElement(44);
		list.getElement(22);
	}
}

class List {
	private List next;
	private List previous;
	private int data;
	
	public List(){
		this.data = 0;
		this.next = null;
		this.previous = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setNext(List next) {
		this.next = next;
	}
	
	public List getNext() {
		return this.next;
	}
	
	public void printNode() {
		System.out.print(data + " ");
	}
}