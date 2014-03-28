
public class Queue {
	private final int MAX_NUM = 10000;
	private int[] data;
	private int front;
	private int end;
	
	public Queue(){
		this.init();
	}
	
	public Queue(int[] data){
		this.init();
		for(int i = 0; i<data.length;i++){
			this.data[i] = data[i];
		}
		this.front = -1;
		this.end = data.length-1;
	}
	
	public Queue(Queue q){
		this.init();
		while(!q.isEmpty()){
			this.push(q.pop());
		}		
	}
	
	public int getFront(){
		if(!this.isEmpty())
			return this.data[front+1];
		return (Integer) null;
	}
	
	public void init(){
		this.data = new int[MAX_NUM];
		this.front = -1; 
		this.end = -1;
	}
	
	public int getEnd(){
		if(!this.isEmpty())
			return this.data[end];
		return (Integer) null;
	}
	
	public boolean isEmpty(){
		return this.end == this.front;
	}
	
	public int queueLength(){
		return this.end-this.front;
	}
	
	public void clearQueue(){
		this.front = -1;
		this.end = -1;
	}
	
	public void push(int data){
		this.data[++this.end] = data;
	}
	
	public int pop(){
		return this.data[++this.front];
	}
	
	public String toString(){
		String str = "";
		for(int i = this.front+1; i<=this.end;i++){
			str+=this.data[i]+" ";
		}
		return str;
	}
	public Queue copy(){
		Queue tem = new Queue();
		for(int i = this.front+1, j = 0; i<=this.end;i++,j++){
			tem.data[j] = this.data[i];
		}
		tem.front = -1;
		tem.end = this.queueLength()-1;
		return tem;
	}
	
	public void queueTraverse(){
		for(int i = this.front+1, j=this.end;i<j;i++,j--){
			int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}
	
	public static void main(String args[]){
		int[] data = {12,2,2,3,5678,342,4,5,6,57,7,8,9,90,0,5,0,123,12,2,3,2,3,4123,345,44653463,222,23,123};
		Queue q = new Queue(data);
		System.out.println(q);
		q.pop();
		System.out.println(q);
		q.pop();
		System.out.println(q);
		q.push(1213);
		System.out.println(q);
		q.queueTraverse();
		System.out.println(q);
		
		//Queue p = new Queue(q.copy());
		//System.out.println(p+"asjdajshdj");
		//System.out.println(q+"haha");
		
	}

}
