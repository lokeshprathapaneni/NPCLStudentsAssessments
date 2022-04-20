package com.sujitmaity.Example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OperationCall {
	@Autowired
	@Qualifier("divide")
	ArathmaticOperations arathmaticOperations;
	
	public void call() {
		arathmaticOperations.operations();
	}

}
