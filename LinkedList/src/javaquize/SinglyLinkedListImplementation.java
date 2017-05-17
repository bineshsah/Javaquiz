package javaquize;

/**
 * @author binesh 
 * Implementing singly linkedlist
 */
public class SinglyLinkedListImplementation {
	/**
	 * defining head and tail
	 */
	private Node head;
	private Node tail;

	public void add(int element) {
		Node nd = new Node();
		nd.setValue(element);
		System.out.println("Adding element to the linkedlist: " + element);
		if (head == null) {
			// if there is only one element, both head and tail points to same
			// element
			head = nd;
			tail = nd;
		} else {
			// pointing current tail next link to new node
			tail.setNextNode(nd);
			// point tail as newly created node
			tail = nd;
		}
	}

	public void deleteGraterNode(int checkNode) {
		Node temp = head;
		Node refNode = null;
		while (temp != null) {
			if (temp.compareTo(checkNode) == -1) {
				if (head.compareTo(checkNode) == -1) {
					// deleting node is a head node
					if (temp.getNextNode() == null) {
						head = null;
					} else {
						head = temp.getNextNode();
					}
				} else {
					// deleting nodes which are not a head
					refNode.setNextNode(temp.getNextNode());
					if (refNode.getNextNode() == null) {
						tail = refNode;
					}
				}

			} else {

				refNode = temp;
			}
			temp = temp.getNextNode();
		}

	}

	public void traverse() {
		System.out.println("Traversing the linkedlist");
		Node temp = head;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp.getValue());
			temp = temp.getNextNode();
		}
	}

	public static void main(String a[]) {
		SinglyLinkedListImplementation list = new SinglyLinkedListImplementation();

		list.add(50);
		list.add(5);
		list.add(2);
		list.add(70);
		list.add(40);
		list.add(80);
		list.add(90);
		list.traverse();
		list.deleteGraterNode(32);
		list.traverse();
		list.removeTail();
		list.traverse();

	}

	private void removeTail() {
		Node next = head;
		Node prev = null;
		if (next == null) {
			System.out.println("List is empty");
			return;
		}
		while (next.getNextNode() != null) {
			prev = next;
			next = next.getNextNode();
		}
		prev.setNextNode(null);
	}
}

class Node implements Comparable {

	private int value;
	private Node nextNode;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node ref) {
		this.nextNode = ref;
	}

	@Override
	public int compareTo(Object o) {
		return ((Integer) o).compareTo((Integer) this.value);
	}

}