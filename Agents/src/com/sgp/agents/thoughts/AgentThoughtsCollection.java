package com.sgp.agents.thoughts;

import java.util.ArrayList;
import java.util.List;

public class AgentThoughtsCollection {

	//like a brain!
	
	private List<AgentThought> thoughts;
	
	public AgentThoughtsCollection(){
		this.thoughts = new ArrayList<AgentThought>();
	}
	
	public void addThought(AgentThought thought){
		this.thoughts.add(thought);
	}
	
	public void removeThought(AgentThought thought){
		this.thoughts.remove(thought);
	}
	
	public List<AgentThought> getThoughts(){
		return this.thoughts; //todo, make return type immutable
	}
	
	
	
}
