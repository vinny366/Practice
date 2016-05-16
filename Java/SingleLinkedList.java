package Java;

class Node{
	
	int value_of_node;
	Node ptr_to_next;
	
	public Node(int value_to_add) {
		this.value_of_node = value_to_add;
	}

	public Node getNext() {		
		return ptr_to_next;
	}
	
	public void setNext(Node n){
		ptr_to_next = n;
	}
	
	public int getData(){
		return value_of_node;
	}
	public void setData(int val){
		this.value_of_node = val;
	}
	
} // Node close

class LinkedListDS{
	int length_of_list = 0;
	Node head;
	Node tail;
	public void add(int value_to_add){
		
		Node newnode = new Node(value_to_add);
		if(head == null) {
			head = newnode;
			tail = newnode;
		}
		else{
			tail.setNext(newnode);
			tail = newnode;
			length_of_list ++;
		}
		
//		System.out.println("Initial Values head " + head);
//		System.out.println("Initial Values tail " + tail);
	}
	
	public void traverse() {
		Node temp = head;
		while(temp != null){
			System.out.print(temp.getData() + "--->");
			
			temp = temp.getNext();
		}
		System.out.println(" ");
		
	}

	public void deleteAtPos(int postion_to_delete) {
		if(postion_to_delete > length_of_list || postion_to_delete < -1){
			System.out.println("please enter value between 0 and " + length_of_list);
		}
		else{
			Node delptr = head;
			//System.out.println("asb " + delptr);
			if(postion_to_delete == length_of_list){
				
				while(delptr.getNext().getNext() != null){
					delptr = delptr.getNext();
				}
				
				delptr.setNext(null);
				length_of_list --;
				
			}
			
			else if(postion_to_delete == 0){
				head = head.getNext();
				length_of_list-- ;
				
			}
			else{
				System.out.println("Deleting Node at specified position");
				int loopCount =1;
				while(loopCount < postion_to_delete)
				{
					delptr = delptr.getNext();
					loopCount++;
				}
				System.out.println(delptr.getData());
				delptr.setNext(delptr.getNext().getNext());
				length_of_list-- ;
			}
		} // true condition
		
	}

	public void findmidValue() {
		Node singleStep = head;
		Node doubleStep = head;
		
		while(doubleStep.getNext() != null && doubleStep.getNext().getNext() != null){
			singleStep = singleStep.getNext();
			doubleStep = doubleStep.getNext().getNext();
		}
		System.out.println(singleStep.getData());
		
	}

	public void addafterPosition(int value_to_add, int position_to_add) {
		if(position_to_add > length_of_list || position_to_add < -1){
			System.out.println("please enter value between 0 and " + length_of_list);
		}
		else {
				Node addedNode = new Node(value_to_add);
				if(position_to_add == 0){
					addedNode.setNext(head);
					head = addedNode;
					length_of_list++;
				}
				else if(position_to_add == length_of_list){
					add(value_to_add);
					length_of_list++;
				}
				
				else{
					Node tempadd = head;
					int tmp_add_count = 1;
					while(tmp_add_count <= position_to_add){
						tempadd = tempadd.getNext();
						tmp_add_count++;
					}
					addedNode.setNext(tempadd.getNext());
					tempadd.setNext(addedNode);
				}		
		}
	}

	public void sort() {
		
		Node i = head;
		int temp;
		int count =0;
		while(count < length_of_list){
			
			while(i.getNext() != null){
				
				if(i.getData() > i.getNext().getData()){
					temp = i.getNext().getData();	
					i.getNext().setData(i.getData());
					i.setData(temp);
				}
				i = i.getNext();
			}
			count ++;
		}
		System.out.println("Exiting");
		
	}
	
	
} // LinkedList DS close

public class SingleLinkedList {
	public static void main(String[] args) {
		
		LinkedListDS ll = new LinkedListDS();
		ll.add(10);
		ll.add(120);
		ll.add(30);
		ll.add(40);
		ll.add(50);
		ll.add(60);
		//ll.deleteAtPos(2);
		ll.addafterPosition(108, 5);
		System.out.println("Length of list is " + ll.length_of_list);
		//ll.findmidValue();
		//ll.deleteAtPos(0);
		ll.traverse();
		ll.sort();
		ll.traverse();
		
		
	}
	
}
