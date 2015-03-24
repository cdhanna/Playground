package com.sgp.agents.io;

import java.util.ArrayList;
import java.util.List;

public class AgentIOCollection<T extends AgentIO> {

	private List<T> io;
	
	public AgentIOCollection(){
		this.io = new ArrayList<T>();
	}
	
	public void addAgentIO(AgentIOCollection<T> ios){
		for (T io : ios.getAll()){
			this.addAgentIO(io);
		}
	}
	
	public void addAgentIO(T io){
		this.io.add(io);
	}
	
	public void removeAgentIO(T io){
		this.io.remove(io);
	}
	
	public List<T> getAll(){
		return this.io; //todo, make return list immutable
	}

	public void clear() {
		this.io.clear();
	}
	
	
	
}
