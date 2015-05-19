package linkedlist;

public class LinkedList{
	
	public LinkedList(){//Creates an instance of the list where first node is null because there is nothing in the list
		first = null;
		size = 0;
	}
	
	private Node first;
	private int size;
	
	private class Node{
		String data;
		Node next;
		
		public Node(){
			data = null;
			next = null;
		}
		public Node(String data){//Creates a new node in the list. However, it does not add it to the list until it passed to the setNext() function.
			this.data = data; 
			next = null;
		}
		
		public Node getNext(){//Gets the next node in the list
			return next;
		}
		
		public void setNext(Node temp){//Sets the next node in the list
			next = temp;
		}
		
		public String getData(){
			return data;
		}
		
	}
	
	public boolean isEmpty(){
		if(first == null){
			return true;
		}
		return false;
	}
	
	public int getSize(){
		return size;
	}
	
	public void insert(String data){//Used to insert data into the LinkedList
		if(isEmpty()){ //If the list is empty we need to add the first node to the list
			first = new Node(data);
			first.setNext(null);
		}else{ //If list is not empty we iterate over the list until we reach a Node where temp.next == null. 
			Node temp = first; //When we reach a temp.next == null, we add the new Node to temp.next
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			Node newNode = new Node(data);
			temp.setNext(newNode);
		}
		size++;
	}
	
	public void insert(String data, int index){//Used to insert data into the LinkedList in a particular position in the list
		if(index < size && index >= 0){//checks if the index entered is valid
			Node curr = first;
			for(int i = 0; i < index; i++){
				curr = curr.getNext();
			}
			Node temp = curr.getNext();//Get the node that the current node points to.
			Node newNode = new Node(data);//Create the new node you want to insert
			newNode.setNext(temp);//Point the newly created node to temp
			curr.setNext(newNode);//Point the current node to new node. Now curr -> newNode -> temp
		}
	}
	
	public void show(){
		if(!isEmpty()){
			Node temp = first;
			System.out.println(temp.getData());
			while(temp.getNext() != null){
				temp = temp.getNext();
				System.out.println(temp.getData());
			}
		}
	}
	
	public void remove(){//Remove the last item in the list
		if(!isEmpty()){
			if(size == 0){//if there is only one node we delete it by setting it to null
					first = null;
			}else{
				Node curr = first;
				for(int i = 0; i < size-1; i++){//iterate over the list until we reach the second to last item
					curr = curr.getNext();
				}
				curr.setNext(null);// the second to last item sets next to null, thus deleting the final item in the list
			}
			size--;//decreases the size of the list
		}
	}
	
	public void remove(int index){//Removes an node in whatever position the user wants
		if(index < size && index >= 0 && !isEmpty()){
			Node curr = first;
			for(int i = 0; i < index; i++){//iterate to the node that is located before the node you want to delete
				curr = curr.getNext();
			}
			Node temp = curr.getNext();//get whatever the node that you want to delete points next
			curr.setNext(temp.getNext()); //set the node that is located before the node you want to delete to temp.
			size--;//before: first -> second - > third. You want to delete;
				  //temp = second -> next
				  //first -> temp.next
		}
	}
	
}
