package orgusermanagementapp.Springcore.Prac.userdao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import orgusermanagementapp.Springcore.Prac.usermanagementmodel.Usermanagemet;

@Repository
public interface UserDao extends JpaRepository<Usermanagemet, Integer> {

	public void deleteByUserId(Integer userId);
	public List<Usermanagemet> findByFirstNameAndUserCompany(String firstName,String company);

	
}