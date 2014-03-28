
public class FindMax {
	private final int MAX_NUM = 10000;
	private int num;
	private int[] data;
	private static int count = 0;
	
	public FindMax(){
		this.data = new int[MAX_NUM];
		this.num = 0;		
	}
	public FindMax(int [] data){
		this.data = new int[MAX_NUM];
		for(int i = 0; i< data.length;i++){
			this.data[i] = data[i];
		}
		this.num = data.length;			
	}
	
	public int maxValue(int start, int end){
		if(start == end){
			return this.data[start];
		}
		int mid = (end-start)/2;
		//System.out.println("end " + end +"start " + start + "mid "+ mid);
		int a = maxValue(start, start+mid);
		int b = maxValue(start+mid+1, end);
		this.count++;
		return a>b?a:b;
		
	}
	
	public static void main(String args[]){
		int[] data = {1,2,3,4,5,6,7,8,9,99,2,3,4,5,65,231,213,3,44,5,6,12,21,312,3,43,41,213,23,123,4354,5,21312,2,12,31,23,123131};
		FindMax m = new FindMax(data);
		System.out.println("data length  "+ data.length);
		int r = m.maxValue(0,data.length-1);
		System.out.println(r);
		System.out.println(m.count);
		System.out.println(1%100);
	}

}
