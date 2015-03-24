package com.sgp.agents.io;

import java.util.ArrayList;
import java.util.List;

public class AgentIOCollection {

	private List<AgentIO> io;
	
	public AgentIOCollection(){
		this.io = new ArrayList<AgentIO>();
	}
	
	public void addAgentIO(AgentIO io){
		this.io.add(io);
	}
	
	public void removeAgentIO(AgentIO io){
		this.io.remove(io);
	}
	
	public List<AgentIO> getAll(){
		return this.io; //todo, make return list immutable
	}

	public void clear() {
		this.io.clear();
	}
	
}
