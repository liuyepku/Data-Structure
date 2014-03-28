
public class List {
	private int [] data;
	private int front;
	private static int MAX_LENGTH = 10000;
	
	public List(){
		this.data = new int [MAX_LENGTH];
		this.front = 0;
	}
	public List(int len){
		this.data = new int[len];
		this.front = 0;
	}
	
	public List(int [] data){
		int len = data.length;
		this.data = new int[MAX_LENGTH];
		for(int i = 0; i<len;i++){
			this.data[i] = data[i];
		}
		this.front = len;			
	}
	
	public void ClearList(){
		this.front = 0;
	}
	
	public boolean isEmpty(){
		return this.front == 0;
	}
	
	public int ListLength(){
		return this.front;
	}
	
	public int getTerm(int index){
		if(index >= 0 && index < this.front){
			return this.data[index];
		}
		return -1;
	}
	
	public int LocateTerm(int query){
		for(int i = 0; i<this.front; i++){
			if(this.data[i] == query)
				return i;
		}
		return -1;
	}
	
	public int priorTerm(int query){
		if(this.data[0] != query){
			for(int i = 1; i<this.front; i++){
				int temp = this.data[i-1];
				if(this.data[i] == query)
					return temp;
			}				
		}
		return -1;			
	}
	
	public int nextTerm(int query){
		if(this.data[this.front-1] != query){
			for(int i = 0; i<this.front-1; i++){
				int temp = this.data[i+1];
				if(this.data[i] == query){
					return temp;
				}
			}
		}
		return -1;			
	}
	
	public boolean insertTerm(int index, int data){
		if(index>=0 && index<this.front+1){
			for(int i = this.front+1; i>=index+1; i--){
				this.data[i] = this.data[i-1];
			}
			this.data[index] = data;
			this.front++;
			return true;
		}
		return false;
	}
	
	public int deleteTerm(int index){
		if(index>=0&&index<this.front){
			int temp = this.data[index];
			for(int i = index; i<this.front-1;i++){
				this.data[i] = this.data[i+1];
			}
			this.front--;
			return temp;
		}
		return -1;
	}
	
	public void listTraverse(){
		for(int i=0; i<this.front/2;i++){
			int temp = this.data[i];
			this.data[i] = this.data[this.front-i-1];	
			this.data[this.front-i-1] = temp;
		}			
	}
	
	public String toString(){
		String temp = "list terms";
		for(int i =0; i<this.front; i++){
			temp += " "+this.data[i];}
		return temp;
	} 
	
	public List union(List list){
		for(int i = this.front, j = 0; i< this.front + list.ListLength(); i++, j++){
			this.data[i] = list.data[j];
		}
		this.front += list.ListLength();
		return this;	
	}
	
	public void bubbleSort(){
		for(int i = this.front-1; i>=0; i--)
			for(int j = 0; j<i;j++){
				if(this.data[j]>this.data[j+1]){
					int temp = this.data[j];
					this.data[j] = this.data[j+1];
					this.data[j+1] = temp;
				}
			}			
	}
	
	public void insertSort(){
		for(int i = 1; i<this.front; i++){
			int soldior = this.data[i];
			for(int j = i-1; j>=0; j--){
				if(soldior<this.data[j]){
					this.data[j+1] = this.data[j];
				}else{
					this.data[j+1] = soldior;
					break;
				}
				if(j==0){
					this.data[j] = soldior;
				}
			}			
		}				
	}
	
	public List mergeList(List list){
		this.bubbleSort();
		list.bubbleSort();
		
		List merged = new List();
		int i = 0, j = 0;
		int k = 0;
		while(i<this.ListLength()&&j<list.ListLength()){
			if(this.data[i]<list.data[j]){
				merged.insertTerm(k++, this.data[i++]);
			}else{
				merged.insertTerm(k++, list.data[j++]);
			}
		}
		while(i<this.ListLength()){
			merged.insertTerm(k++, this.data[i++]);
		}
		while(j<list.ListLength()){
			merged.insertTerm(k++, list.data[j++]);
		}
		merged.front = k;
		return merged;
	}
	
	
	public static void main(String [] args){
		List list = new List();
		System.out.println(list);
		list.insertTerm(0, 10);
		list.insertTerm(1, 12);
		list.insertTerm(0, 8);
		list.insertTerm(2, 38);
		list.listTraverse();
		System.out.println(list);
		System.out.println(list.priorTerm(38));
		int[] data = {1,2,3,4,5,6,7,8,9,10,11};
		List list1 = new List(data);
		System.out.println(list1);
		List list2 = list.union(list1);
		System.out.println(list2);

		//list2.bubbleSort();
		list2.insertSort();
		System.out.println(list2);
		int [] data3 =  {9,2,2,4,5,6,6,7,78,9,900,9890};
		List list3 = new List(data3);
		System.out.println(list3);
		List listmerged = list2.mergeList(list3);
		System.out.println(listmerged);
	}
	
	
}
