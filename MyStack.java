/*
 * 
 */
public class MyStack {

	/*
	 * 
	 */
	public static class Node {
		
		// **** class members ****
		public int 	val;
		public int	min;
		public Node	next;
		
		/*
		 * Constructor
		 */
		public Node(int val, int min) {
			this.val 		= val;
			this.min 		= min;
			this.next 		= null;
		}		
	}
	
	// **** top of stack ****
	private Node top 		= null;
	
	// **** min value in stack ****
	private int	minVal 		= Integer.MAX_VALUE;
		
	/*
	 * Constructor
	 */
	public MyStack() {
		this.top = null;
	}
	
	/*
	 * Push the value into the stack.
	 */
	public void push(int val) {
		
		// **** check and set the min val ****
		if (val < minVal) {
			minVal 	= val;
		}
		
		// **** allocate a node ****
		Node node = new Node(val, minVal);
		
		// **** set the next field in the node ****
		node.next = top;
				
		// **** push the node into the stack ****
		top = node;
	}
	
	/*
	 * Pop the value from the stack.
	 */
	public int pop() throws Exception {
		
		// **** check if stack is empty ****
		if (top == null)
			throw new Exception("pop <<< stack is empty");
		
		// **** point to top node in the stack ****
		Node node = top;
		
		// **** update the top of the stack ****
		top = top.next;
		
		// **** return the value popped from the stack ****
		return node.val;
	}
	
	/*
	 * Min
	 */
	public int min() throws Exception {
		
		// **** check if stack is empty ****
		if (top == null)
			throw new Exception("min <<< stack is empty");
		
		// **** return the min value in the stack ****
		return top.min;
	}
	
	/*
	 * Check if the stack is empty
	 */
	public boolean isEmpty() {
		return top == null;
	}
	
	/*
	 * Test scaffolding.
	 */
	public static void main(String[] args) throws Exception {

		// **** instantiate a stack ****
		MyStack stack = new MyStack();
		
		// **** push some values into the stack ****
		for (int i = 7; i > 0; i--) {
//		for (int i = 0; i < 7; i++) {
			stack.push(i);
		}
		
		// **** pop all values from the stack ****
		while (!stack.isEmpty()) {
			System.out.println("main <<<        stack.min: " + stack.min());
			System.out.println("main <<<        stack.pop: " + stack.pop());
			System.out.println();
		}
	}

}
