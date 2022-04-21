package orgLibraryApp.Springcore.Prac.BookDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import orgLibraryApp.Springcore.Prac.BookClass.Book;

public interface BookDao extends JpaRepository<Book,Integer> {
	
	public void deleteByBookId(Integer n1);
	
	public List<Book> findByTitleAndAuthorName(String n2, String n3);
	
	
	public void deleteByTitleOrAuthorName(String n4, String n5);

}
