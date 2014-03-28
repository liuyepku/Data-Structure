
public class Triplet {
	private int[] data;
	private static int length = 3;
	
	public Triplet()
	{
		this.data = new int[length];
		for(int i = 0; i < length; i++)
		{
			this.data[i] = 0;
		}
		
	}
	public Triplet(int [] data){
		for(int i = 0; i < length; i++)
		{
			this.data[i] = data[i];
		}
	}
	
	public int getTerm(int index){
		return this.data[index];
	}
	
	public void setTerm(int index, int value){
		this.data[index] = value;
	}
	
	public boolean isAscending(){
		return (this.data[0]<=this.data[1])&&(this.data[1]<=this.data[2]);
	}
	
	public boolean isDescending(){
		return (this.data[0]>=this.data[1])&&(this.data[1]>=this.data[2]);
	}
	
	public int maxValue(){
		int temp = this.data[0]>this.data[1]?this.data[0]:this.data[1];
		return this.data[2]>temp?this.data[2]:temp;
	}
	public int minValue(){
		int temp = this.data[0]<this.data[1]?this.data[0]:this.data[1];
		return this.data[2]<temp?this.data[2]:temp;
	}
	
	public String toString(){
		return "0 data: "+ this.data[0]+" 1 data: "+ this.data[1]+" 2 data: "+this.data[2];
	}
	
	public static void main(String [] args){
		Triplet triplet = new Triplet();
		System.out.println(triplet);
		triplet.setTerm(1, 10);
		triplet.setTerm(2, 3);
		triplet.setTerm(0, 1);
		System.out.println(triplet);
		System.out.println(triplet.minValue());

		
	}
}
