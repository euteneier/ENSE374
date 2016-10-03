
public class List {
	private List next;
	private List previous;
	private int data;
	
	public List()
	{
		this.data = 0;
		this.next = null;
		this.previous = null;
	}
	
	/**
	 * @param data
	 * an integer to be stored in the node
	 * @return
	 * None
	**/
	public void setData ( int data ) {
		this.data = data;
	}
	
	public int getData ( ) {
		return this.data ;
	}
}
