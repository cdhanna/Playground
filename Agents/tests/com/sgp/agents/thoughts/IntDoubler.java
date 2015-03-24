package com.sgp.agents.thoughts;

import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.UntypedAgentIOCollection;
import com.sgp.agents.io.common.IntIO;

public class IntDoubler extends CommonAgentThought{

	@Override
	public void onIOAdded(AgentIO input) {
	}

	@Override
	public UntypedAgentIOCollection think() {
		
		UntypedAgentIOCollection c = new UntypedAgentIOCollection();
		
		for (IntIO io : this.getInputs(IntIO.class).getAll()){
			c.addAgentIO(new IntIO( io.getData() * 2));
		}
		
		
		return c;
	}

}
