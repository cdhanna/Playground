package com.sgp.agents.thoughts;

import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.AgentIOCollection;
import com.sgp.agents.io.UntypedAgentIOCollection;

public abstract class CommonAgentThought implements AgentThought{

	public interface AgentIOMatcher {
		boolean is(AgentIO io);
	}
	
	private UntypedAgentIOCollection inputs;
	
	public CommonAgentThought(){
		this.inputs = new UntypedAgentIOCollection();
	}
	
	public UntypedAgentIOCollection getInputCollection(){
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

	
	public UntypedAgentIOCollection getInputs(AgentIOMatcher m){
		UntypedAgentIOCollection ios = new UntypedAgentIOCollection();
		for (AgentIO io : this.getInputCollection().getAll()){
			if (m.is(io)){
				ios.addAgentIO(io.getSelf());
			}
		}
		return ios;
	}
	
	public <T extends AgentIO> AgentIOCollection<T> getInputs(Class<? extends T> clazz){
		
		AgentIOCollection<T> ios = new AgentIOCollection<T>();
		for (AgentIO io : this.getInputCollection().getAll()){
			if (io.getIOClass().isAssignableFrom(clazz)){
				ios.addAgentIO((T)io.getSelf());
			}
		}
		return ios;
		
	}
	
	public abstract void onIOAdded(AgentIO input);
	
	@Override
	public abstract UntypedAgentIOCollection think();
}
