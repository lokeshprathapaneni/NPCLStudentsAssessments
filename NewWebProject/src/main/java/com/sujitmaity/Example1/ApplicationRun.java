package com.sujitmaity.Example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRun implements ApplicationRunner{
	@Autowired
	OperationCall all;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		all.call();
	}

}
