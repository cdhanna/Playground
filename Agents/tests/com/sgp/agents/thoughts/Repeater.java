package com.sgp.agents.thoughts;

import com.sgp.agents.Agent;
import com.sgp.agents.io.AgentMessage;
import com.sgp.agents.io.AgentMessageCollection.AgentMessageMatcher;
import com.sgp.agents.io.UntypedAgentMessageCollection;

public class Repeater extends CommonAgentThought{

	
	Agent repeatIt;
	
	public Repeater(Agent a){
		this.repeatIt = a;
	}
	
	@Override
	public void onIOAdded(AgentMessage input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UntypedAgentMessageCollection think() {
		
		UntypedAgentMessageCollection ios = this.getInputs(new AgentMessageMatcher(){
			@Override
			public boolean is(AgentMessage io) {
				return io.getOrigin().equals(repeatIt.getID());
			}});
		
		
		return ios;
		
		
	}

}
