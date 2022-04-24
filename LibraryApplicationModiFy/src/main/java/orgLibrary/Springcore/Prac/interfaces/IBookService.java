package orgLibrary.Springcore.Prac.interfaces;

import java.util.List;

import orgLibrary.Springcore.Prac.Book.Book;

public interface IBookService {
	public Book getBook(Integer bookId);
	public String createLib(Book bo);
	public String updateBook(Book book);
	public String updateAuthorAddress(Book book);
	public String deleteBookId(Integer bookId);
	public List<Book>getTitleAndAuthor(String title,String authorName);
	public String deleteBookId(String title,String authorName);

}
