
public class LinkList {
	private int len;
	ListTerm head;
	ListTerm tail;
	
	public LinkList(){
		this.len = 0;
		this.head = new ListTerm();		
		this.tail = new ListTerm();
		this.head.next = null;
		this.tail.next = null;
	}
	
	public LinkList(LinkList list){
		int length = list.getLength();
		this.head = new ListTerm();		
		this.tail = new ListTerm();
		ListTerm term = this.head;
		for(int i = 1; i< length; i++){
			term.next = new ListTerm(list.getTerm(i));
			term = term.next;			
		}
		term.next = new ListTerm(list.getTerm(length));
		this.tail.next = term;
		this.len = length;
		
	}
	
	public ListTerm getHead(){
		return this.head;
	}
	
	public ListTerm getTail(){
		return this.tail;
	}
	
	public int getLength(){
		return this.len;
	}
	
	public void listApend(LinkList list){
		ListTerm p = this.tail;
		ListTerm q = list.head.next;
		p.next = q;
	}
	
	public ListTerm getTerm(int index){
		if(index>this.len||index<0){
			System.out.println("out of index!!!!!!!");
			return null;
		}
		
		ListTerm term = this.head;
		//System.out.println(term.next);
		for(int i = 1; i<=index; i++){
			term = term.next;
			//System.out.println(term);
		}
		return term;		
	}
	
	public boolean insertTerm(int index, ListTerm insertterm){
		if(this.head.next== null){
			this.head.next = new ListTerm(insertterm);
			this.tail.next = this.head.next;
			this.len++;
			return true;
		}
		if(index>this.len+1|| index < 0){
			System.out.println("out of index!!!!!!!!!");
			System.out.println("index "+ index);
			return false;
		}
		ListTerm term = this.head;
		for(int i = 1; i<=index-1; i++){
			term = term.next;
			//System.out.println("haha "+ term+"index "+ index);
		}
		//System.out.println("haha "+ term.next);
				
		insertterm.next = term.next;
		term.next = insertterm;
		if(index > this.len){
			this.tail.next = insertterm;
		}
		this.len++;
		return true;
	}
	
	public ListTerm getPriorTerm(ListTerm term){
		ListTerm p = this.head;
		for(int i = 0; i<=this.len;i++){
			p = p.next;
			if(p.next.isEqual(term)){
				return p;
			}
		}
		return null;
	}
	
	public ListTerm getPriorTerm(int data){
		ListTerm p = this.head;
		for(int i = 0; i<=this.len;i++){
			p = p.next;
			if(p.next.isEqual(new ListTerm(data))){
				return p;
			}
		}
		return null;
	}
	
	public ListTerm getNextTerm(ListTerm term){
		ListTerm p = this.head;
		for(int i =1; i<=this.len;i++){
			p = p.next;
			if(p.isEqual(term)){
				return p.next;
			}
		}
		return null;
	}
	
	
	public ListTerm getNextTerm(int data){
		ListTerm p = this.head;
		for(int i =1; i<=this.len;i++){
			p = p.next;
			if(p.isEqual(new ListTerm(data))){
				return p.next;
			}
		}
		return null;
	}
	
	public boolean isEmpty(){
		return this.len == 0;
	}
	
	public int locateTerm(ListTerm term){
		ListTerm p = this.head;
		for(int i = 1; i<=this.len;i++){
			p = p.next;
			if(p.isEqual(term)){
				return i;
			}
		}
		return -1;
	}
	
	public int locateTerm(int data){
		ListTerm p = this.head;
		for(int i = 1; i<=this.len;i++){
			p = p.next;
			if(p.isEqual(new ListTerm(data))){
				return i;
			}
		}
		return -1;
	}
	
	public boolean deleteTerm(ListTerm term){
		ListTerm p = this.head;
		for(int i = 1; i<=this.len;i++){
			p = p.next;
			if(p.isEqual(term)){
				p.next = p.next.next;
				this.len--;
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteTerm(int index){
		ListTerm p = this.head;
		if(index>this.len||index<0){
			System.out.println("out of index!!!!!");
			return false;
		}
		for(int i = 1; i<index; i++){
			p = p.next;
		}
		p.next = p.next.next;
		if(index == this.len){
			this.tail.next = p;
		}
		this.len--;
		return true;
		
	}
	
	public void clearList(){
		this.head.next = null;
		this.tail.next = null;
	}
	
	public void listTraverse(){
		ListTerm p = this.head.next;
		ListTerm p_prev = null;
		ListTerm p_next = p.next;
		this.tail.next = p;
		while(p_next!=null){
			p.next = p_prev;
			p_prev = p;
			p = p_next;
			p_next = p_next.next;			
		}
		p.next = p_prev;
		this.head.next = p;
	}
	
	public void bubbleSort(){
		ListTerm p = this.head.next;
		ListTerm q = null;
		while(p!=q){
			if(p.isLarger(p.next)){
				int temp = p.next.getData();
				p.next.setData(p.getData());
				p.setData(temp);
			}
			p = p.next;
			if(p.next == q){
				q = p;
				p = this.head.next;
			}
			//System.out.println(this);
		}
	}
	
	public void insertSort(){
		ListTerm p = this.head;
		ListTerm q = p.next;
		ListTerm sortedEnd = q;
		q = q.next;
		while(q!=null){
			p = this.head;
			while(p.next.isSmaller(q)&&!p.equals(sortedEnd)){
				p = p.next;
			}
			if(p.equals(sortedEnd)){
				sortedEnd = q;
				q = q.next;
			}else{
				sortedEnd.next = q.next;
				q.next = p.next;
				p.next = q;		
				q = sortedEnd.next;		
			}			
		}
	}
	
	public LinkList mergeList(LinkList list){
		this.insertSort();
		list.insertSort();
		ListTerm p = this.head.next;
		ListTerm q = list.head.next;
		
		LinkList r = new LinkList();
		ListTerm r_point = r.head;
		while(p != null && q != null){
			if(p.isSmaller(q)){
				ListTerm temp = new ListTerm(p);
				r_point.next = temp;
				r_point = r_point.next;
				p = p.next;
			}else{
				ListTerm temp = new ListTerm(q);
				r_point.next = temp;
				r_point = r_point.next;
				q = q.next;
			}
		}
		while(p!=null){
			ListTerm temp = new ListTerm(p);
			r_point.next = temp;
			r_point = r_point.next;
			p = p.next;
		}
		while(q!=null){
			ListTerm temp = new ListTerm(q);
			r_point.next = temp;
			r_point = r_point.next;
			q = q.next;
		}
		
		return r;
	}
	
	public String toString(){
		String str = "";
		ListTerm p = this.head;
		while(p.next!=null){
			str+=p.next.getData()+" ";
			p = p.next;
		}
		return str;
	}
	
	public static void main(String args[]){
		LinkList list = new LinkList();
		list.insertTerm(1, new ListTerm(1));
		System.out.println(list.tail.next);
		list.insertTerm(2, new ListTerm(3));
		System.out.println(list.tail.next);
		list.insertTerm(3, new ListTerm(5));
		System.out.println(list.tail.next);
		list.insertTerm(0, new ListTerm(4));
		System.out.println(list.tail.next);
		list.insertTerm(0, new ListTerm(13));
		list.insertTerm(1, new ListTerm(10));
		list.insertTerm(2, new ListTerm(23));
		list.insertTerm(5, new ListTerm(66));
		list.insertTerm(5, new ListTerm(219));
		list.insertTerm(2, new ListTerm(12));
		list.insertTerm(5, new ListTerm(89));
		
		System.out.println(list);

		//System.out.println(list.getTerm(8));
		LinkList list2 = new LinkList(list);
		
		System.out.println(list2);
		
		list.insertSort();
		System.out.println(list);
		
		System.out.println(list.locateTerm(23));
		list.deleteTerm(list.getLength());
		//System.out.println("tail "+list.tail.next);
		System.out.println(list);
		//list.listTraverse();
		//System.out.println(list+"haha");
		System.out.println("");
		//list.bubbleSort();
		list.insertSort();
		System.out.println(list+"\n");
		//System.out.println(list.getNextTerm(4));
		//System.out.println(list.getPriorTerm(4));
		
		LinkList list3 = list.mergeList(list2);
		System.out.println(list3);
		
		
	}
	
}
