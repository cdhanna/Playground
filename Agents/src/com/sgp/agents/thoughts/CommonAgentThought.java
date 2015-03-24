package com.sgp.agents.thoughts;

import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.AgentIOCollection;

public abstract class CommonAgentThought implements AgentThought{

	private AgentIOCollection inputs;
	
	public CommonAgentThought(){
		this.inputs = new AgentIOCollection();
	}
	
	public AgentIOCollection getInputs(){
		return this.inputs;
	}
	
	@Override
	public void addIO(AgentIO input) {
		this.inputs.addAgentIO(input);
		onIOAdded(input);
	}

	@Override
	public void prepare() {
		this.inputs.clear();
	}

	public abstract void onIOAdded(AgentIO input);
	
	@Override
	public abstract AgentIO think();
}
