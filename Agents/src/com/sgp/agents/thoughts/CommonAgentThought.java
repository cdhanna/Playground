package com.sgp.agents.thoughts;

import com.sgp.agents.io.AgentMessage;
import com.sgp.agents.io.AgentMessageCollection;
import com.sgp.agents.io.UntypedAgentMessageCollection;

/**
 * @author cdhan_000
 * A default implementation for AgentThought.
 */
public abstract class CommonAgentThought implements AgentThought{

	public interface AgentIOMatcher {
		boolean is(AgentMessage io);
	}
	
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

	
	public UntypedAgentMessageCollection getInputs(AgentIOMatcher m){
		UntypedAgentMessageCollection ios = new UntypedAgentMessageCollection();
		for (AgentMessage io : this.getInputCollection().getAll()){
			if (m.is(io)){
				ios.addAgentIO(io.getSelf());
			}
		}
		return ios;
	}
	
	public <T extends AgentMessage> AgentMessageCollection<T> getInputs(Class<? extends T> clazz){
		
		AgentMessageCollection<T> ios = new AgentMessageCollection<T>();
		for (AgentMessage io : this.getInputCollection().getAll()){
			if (io.getMessageClass().isAssignableFrom(clazz)){
				ios.addAgentIO((T)io.getSelf());
			}
		}
		return ios;
		
	}
	
	public abstract void onIOAdded(AgentMessage input);
	
	@Override
	public abstract UntypedAgentMessageCollection think();
}
