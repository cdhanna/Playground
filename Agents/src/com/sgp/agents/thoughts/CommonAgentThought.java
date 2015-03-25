package com.sgp.agents.thoughts;

import com.sgp.agents.io.AgentMessage;
import com.sgp.agents.io.AgentMessageCollection;
import com.sgp.agents.io.AgentMessageCollection.AgentMessageMatcher;
import com.sgp.agents.io.UntypedAgentMessageCollection;

/**
 * @author cdhan_000
 * A default implementation for AgentThought.
 */
public abstract class CommonAgentThought implements AgentThought{


	
	private UntypedAgentMessageCollection inputs;
	
	public CommonAgentThought(){
		this.inputs = new UntypedAgentMessageCollection();
	}
	
	public UntypedAgentMessageCollection getInputCollection(){
		return this.inputs;
	}
	
	@Override
	public void addMessage(AgentMessage input) {
		this.inputs.addAgentIO(input);
		onIOAdded(input);
	}

	@Override
	public void prepare() {
		this.inputs.clear();
	}

	
	public UntypedAgentMessageCollection getInputs(AgentMessageMatcher m){
		return this.getInputCollection().getInputs(m).asUntyped();
	}
	
	public <T extends AgentMessage> AgentMessageCollection<T> getInputs(Class<? extends T> clazz){
		return this.getInputCollection().getInputs(clazz);
	}
	
	public abstract void onIOAdded(AgentMessage input);
	
	@Override
	public abstract UntypedAgentMessageCollection think();
}
