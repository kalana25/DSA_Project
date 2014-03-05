import java.io.*;
public class TestDrive {

	public static void main(String[] args) {

		Book b1=new Book("Java",20,"kathy","sierra");
		Book b2=new Book("php",18,"Beart","Bart");
		Book b3=new Book("Head First Java",23,"Jim","Carter");
		Book b4=new Book("Head First PHP",17,"Noel","Kokrith");
		Book b5=new Book("Java in Nutshell",21,"Steeven","Stweurt");
		Book b6=new Book("PHP in Nut shell",19,"Samhe","Abdela");
		Book b7=new Book("Java For PHP developers",25,"Samas","Esiste");
		
		BinarySearchTree bst=new BinarySearchTree();
		bst.addNode(20, b1);
		bst.addNode(18, b2);
		bst.addNode(23, b3);
		bst.addNode(17, b4);
		bst.addNode(21, b5);
		bst.addNode(19, b6);
		bst.addNode(25, b7);
		
		System.out.println("Books are stored...");
		System.out.println();
		System.out.println("1. Add a new node.");
		System.out.println("2. Delete a Node.");
		System.out.println("3. Search Books by keyword");
		System.out.println("4. Print Books.");
		System.out.println("5. Exit");
		System.out.println();
		int option;
		
		do{
			System.out.println();
			String opt=getInput("Please Enter your Option..");
			option=Integer.parseInt(opt);
			switch (option) {
			case 1:
				Book b=createBook();
				bst.addNode(b.getIsbn(), b);
				break;
			case 2:
				String key=getInput("Please enter key to delete... ");
				if(bst.delete(Integer.parseInt(key)))
					System.out.println("Node "+Integer.parseInt(key)+" Deleted successfully..");
				else
					System.out.println("Node "+Integer.parseInt(key)+" Not found..");
				break;
			case 3:
				String keyword=getInput("Please enter your search keyword...");
				bst.PrintByKeyword(bst.root, keyword);
				break;
			case 4:
				String format = "%-30s%-15s%-15s%s%n";
				System.out.printf(format,"Book Name","ISBN","Author","Surename"+"\n");
				bst.InOrderTraverse(bst.root);
				break;
			default:
				break;
			}
		}while(option!=5);
		
		
	}

	public static String getInput(String prompt){
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		System.out.println(prompt);
		System.out.flush();
		try {
			return stdin.readLine();
		} catch (Exception e) {
			return "Error" + e.getMessage();
		}
	}

	public static Book createBook(){
		String title=getInput("Please enter book name..");
		int isbn=Integer.parseInt(getInput("Please enter ISBN.."));
		String name=getInput("Please enter author name..");
		String sname=getInput("Please enter surname..");
		Book b8=new Book(title, isbn, name, sname);
		return b8;
	}
}
