package com.sgp.agents.io.common;

import com.sgp.agents.io.TypedAgentMessage;

public class IntIO extends TypedAgentMessage<Integer>{

	public IntIO(){
		super(0);
	}
	
	public IntIO(Integer data) {
		super(data);
	}

	
	
}
