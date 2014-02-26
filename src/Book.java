
public class Book {

	private int isbm; 			//book ISBM
	private String bName; 		//Book Title
	private String authorFname; //Author's First name
	private String authorSname; //Author's Surname name
	
	//constructor 
	public Book (String book, int is, String afname, String asname){
		this.isbm=is;
		this.bName=book;
		this.authorFname=afname;
		this.authorSname=asname;
		
	}
	
	
	//setting values
	public void setisbm (int is){
		this.isbm=is;
	}
	
	public void setbName (String book){
		this.bName=book;
	}
	
	public void setauthorFname (String afname){
		this.authorFname=afname;
	}
	
	public void setauthorLname (String asname){
		this.authorSname=asname;
	}
	
	
	//getting values
	public int getisbm(){
		return this.isbm;
	}
	
	public String getbName(){
		return this.bName;
	}
	
	public String getauthorFname(){
		return this.authorFname;
	}
	
	public String getauthorLname(){
		return this.authorSname;
	}
	
}
