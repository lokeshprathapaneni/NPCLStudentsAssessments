package orgAdmin.Springcore.Prac.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import orgAdmin.Springcore.Prac.Entity.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin,Integer>{

}
