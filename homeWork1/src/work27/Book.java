package work27;

public class Book {
	String bookName;
	
	public Book(){
		
	}
	public Book(String book){
		bookName = book;
	}
	
	@Override
	public String toString(){
		return bookName;
	}
}
