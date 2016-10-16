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
			newElement.setPrevious(last);
		}
		last = newElement; 
	}

	public List deleteElement(int data){
		List current = first; 
		while (current.getData() != data)
		{
			current = current.getNext();
			if (current == null)
				return null;
		}
		if (current == first)
			first = current.getNext(); 
		else
			current.getPrevious().setNext(current.getNext());

		if (current == last)
			last = current.getPrevious(); 
		else
			current.getNext().setPrevious(current.getPrevious());
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

	public void printLinkedListTail() {
		List current = last;
		while (current != null){
			current.printNode();
			current = current.getPrevious();
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Main list = new Main();

		list.addElement(22);
		list.addElement(44);
		list.addElement(33);
		list.addElement(55);

		list.printLinkedListHead();
		list.printLinkedListTail();

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
	
	public void setPrevious(List previous) {
		this.previous = previous;
	}
	
	public List getPrevious() {
		return this.previous;
	}
	
	public void printNode() {
		System.out.print(data + " ");
	}
}