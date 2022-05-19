package orgusermanagementapp.Springcore.Prac.interfaceservice;


import java.util.List;

import orgusermanagementapp.Springcore.Prac.usermanagementmodel.Usermanagemet;

public interface Iservice {
   Usermanagemet getUser(Integer userId);
   String createUser(Usermanagemet user);
   String UpdateUser(Usermanagemet User);
   String UpdateDateOfBirth(Usermanagemet user);
   String deleteUserId(Integer userId);
   List<Usermanagemet> getfirstNameAndCompany(String firstName, String company);
   List<Usermanagemet> getAllUser(Usermanagemet user);
    
}
