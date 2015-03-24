package com.sgp.agents.thoughts;

import com.sgp.agents.Agent;
import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.UntypedAgentIOCollection;

public class Repeater extends CommonAgentThought{

	
	Agent repeatIt;
	
	public Repeater(Agent a){
		this.repeatIt = a;
	}
	
	@Override
	public void onIOAdded(AgentIO input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UntypedAgentIOCollection think() {
		
		UntypedAgentIOCollection ios = this.getInputs(new AgentIOMatcher(){
			@Override
			public boolean is(AgentIO io) {
				return io.getOrigin().equals(repeatIt.getID());
			}});
		
		
		return ios;
		
		
	}

}
