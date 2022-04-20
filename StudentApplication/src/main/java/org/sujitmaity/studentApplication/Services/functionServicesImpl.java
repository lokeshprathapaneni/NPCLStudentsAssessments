package org.sujitmaity.studentApplication.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.sujitmaity.studentApplication.Entities.function;

@Service
public class functionServicesImpl implements functionServices{
	
	List<function> list;
	
	public functionServicesImpl() {
		list=new ArrayList<>();
		list.add(new function(101,"Sujit","Computer"));
		list.add(new function(102,"Saif","Information"));
		list.add(new function(103,"Ram","Electrical"));
		
	}

	@Override
	public List<function> getFunction() {
		
		return list;
	}

}
