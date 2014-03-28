
public class Stack {
	private final int MAX_NUM = 10000;
	private int[] data = null;
	private int top;
	private int len;
	
	public Stack(){
		this.init();
	}
	
	public Stack(Stack s){
		Stack temp = new Stack();
		while(!s.isEmpty()){
			temp.push(s.pop());
		}
		this.init();
		while(!temp.isEmpty()){
			this.push(temp.pop());
		}
	}
	
	public Stack(int[] data){
		this.init();
		for(int i = 0; i<data.length;i++){
			this.push(data[i]);
		}
		this.len = data.length;
	}
	public void init(){
		this.data = new int[MAX_NUM];
		this.len = 0;
		this.top = -1;
	}
	
	public void clearStack(){
		while(!this.isEmpty()){
			this.pop();
		}
	}
	
	public Stack copy(){
		Stack s = new Stack();
		for(int i = 0; i< this.len; i++){
			s.data[i] = this.data[i];
		}
		s.len = this.len;
		s.top = this.top;		
		return s;
	}
	
	public boolean isEmpty(){
		return this.top == -1;
	}
	
	public int getLength(){
		return this.len;
	}
	
	public int getTop(){
		if(top!=-1){
			return this.data[top];
		}
		return (Integer) null;
	}
	
	public void push(int data){
		this.data[++this.top] = data;
		this.len++;
	}
	
	public int pop(){
		this.len--;
		return this.data[this.top--];		
	}
	
	public void stackTraverse(){
		Stack temp = new Stack();
		while(!this.isEmpty()){
			temp.push(this.pop());
		}
		while(!temp.isEmpty()){
			this.push(temp.pop());
		}
	}
	
	public String toString(){
		String str = "";
		for(int i = 0; i<this.len;i++){
			str+= this.data[i]+" ";
		}
		return str;
	}
	
	public static void main(String args[]){
		int[] data = {12,3,3,24,5,6,7,8,89,8,54,54,3,3,4,23,234,54,5,3,42,34,2,123,12,3,2};
		Stack s = new Stack(data);
		System.out.println(s);
		s.pop();
		System.out.println(s);
		Stack s1 = new Stack(s.copy());
		System.out.println(s1);
		System.out.println(s.copy());

	}
}
