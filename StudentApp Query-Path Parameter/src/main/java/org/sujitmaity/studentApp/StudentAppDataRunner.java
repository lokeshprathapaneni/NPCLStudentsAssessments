package org.sujitmaity.studentApp;

import java.util.HashMap;

import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.sujitmaity.studentApp.ObjectData.StudentObjectData;

@Component
public class StudentAppDataRunner implements ApplicationRunner{

	//Collection Map to put Data of Student
	Map<Integer, StudentObjectData> mp= new HashMap<>();


	public StudentAppDataRunner(Map<Integer, StudentObjectData> mp) {
		super();
		this.mp = mp;
	}


	//Object data pass

	public Map<Integer, StudentObjectData> getMp() {
		return mp;
	}


	public void setMp(Map<Integer, StudentObjectData> mp) {
		this.mp = mp;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		//Object Creation for Class StudentObjectData
		StudentObjectData sd1 = new StudentObjectData(10, "Sujit", "UPI");
		StudentObjectData sd2 = new StudentObjectData(11, "Saif", "Rupay");
		StudentObjectData sd3 = new StudentObjectData(12, "Ram", "Visa");

		//Put Object data of class StudentObjectData to Collection Map
		mp.put(101,sd1);
		mp.put(102,sd2);
		mp.put(103,sd3);

	}


	@Override
	public String toString() {
		return "StudentAppDataRunner [mp=" + mp + "]";
	}
}


































/* Quary and Path Parameters Fild

//	public StudentAppDataRunner(Map<Integer, String> mp) {
//		super();
//		this.mp = mp;
//	}

//	public Map<Integer, String> getMp() {
//		return mp;
//	}

//	public void setMp(Map<Integer, String> mp) {
//		this.mp = mp;
//	}

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
 */
