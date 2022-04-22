package orgLibrary.Springcore.Prac.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import orgLibrary.Springcore.Prac.Book.Book;
@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
    public void deleteByBookId(Integer n1);
    public List<Book> findByTitleAndAuthorName(String s1,String S2);
    public void deleteByTitleOrAuthorName(String n1,String n2);
}
