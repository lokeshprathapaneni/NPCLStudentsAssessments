package org.sujitmaity.studentApp;

import java.util.HashMap;

import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentAppDataRunner implements ApplicationRunner{
	
	//Collection Map to put Data of Student
	Map<Integer, String> mp= new HashMap<>();
	

	public StudentAppDataRunner(Map<Integer, String> mp) {
		super();
		this.mp = mp;
	}
	
	


	public Map<Integer, String> getMp() {
		return mp;
	}




	public void setMp(Map<Integer, String> mp) {
		this.mp = mp;
	}




	@Override
	public void run(ApplicationArguments args) throws Exception {
		mp.put(101, "Don");
		mp.put(102, "Mohabbtain");
		mp.put(103, "Veer-Zara");
		mp.put(104, "Kal Ho Na Ho");
		mp.put(105, "Kabhi Khushi Kabhi Gum");
		mp.put(106, "Main Hoon Na");
		mp.put(107, "Dilwale");
		
	}

}
