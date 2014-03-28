
public class ListTerm {
	private int data;
	ListTerm next;
	
	public ListTerm(){
		this.data = 0;
		this.next = null;
	}
	public ListTerm(int data){
		this.data = data;
		this.next = null;
	}
	
	public ListTerm(ListTerm term){
		this.data = term.data;
		this.next = term.next;
	}
	
	public int getData(){
		return this.data;
	}
	
	public ListTerm getNextTerm(){
		return this.next;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public void setNexTerm(ListTerm term){
		this.next = term;
	}
	
	public boolean isEqual(ListTerm term){
		return this.data == term.data;		
	} 
	
	public boolean isLarger(ListTerm term){
		return this.data>term.data;
	}
	
	public boolean isSmaller(ListTerm term){
		return this.data<term.data;
	}
	
	public String toString(){
		return this.data+" ";
		
	}
}
