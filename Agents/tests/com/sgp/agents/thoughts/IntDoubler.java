package com.sgp.agents.thoughts;

import com.sgp.agents.io.AgentMessage;
import com.sgp.agents.io.UntypedAgentMessageCollection;
import com.sgp.agents.io.common.IntIO;

public class IntDoubler extends CommonAgentThought{

	@Override
	public void onIOAdded(AgentMessage input) {
	}

	@Override
	public UntypedAgentMessageCollection think() {
		
		UntypedAgentMessageCollection c = new UntypedAgentMessageCollection();
		
		for (IntIO io : this.getInputs(IntIO.class).getAll()){
			c.addAgentIO(new IntIO( io.getData() * 2));
		}
		
		
		return c;
	}

}
