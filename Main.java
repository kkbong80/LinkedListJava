package linkedlist;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert("Hello");
		list.insert("My");
		list.insert("is");
		list.insert("Muhammad");
		list.insert("Zubair");
		list.insert("Name", 1);
		list.show();
		list.remove(3);
		System.out.println("\n");
		list.show();
		while(!list.isEmpty()){
			list.remove();
			System.out.println("\n");
			list.show();
		}
		
	}

}
