package com.sgp.agents.io;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cdhan_000
 * The AgentMessageCollection is an abstraction for a collection of AgentMessages. 
 * In this collection, all of the included AgentMessages must all be of the same type. 
 * For example, if there is a subclass of AgentMessage called TurkeyMessage, and there is then a
 * AgentMessageCollection<TurkeyMessage>, then every AgentMessage in the collection would be a TurkeyMessage
 * @param <T>
 */
public class AgentMessageCollection<T extends AgentMessage> {

	private List<T> io;
	
	public AgentMessageCollection(){
		this.io = new ArrayList<T>();
	}
	
	/**
	 * Copy-constructor. Doesn't clone the individual messages, just clones the list.
	 * @param ios
	 */
	public void addAgentIO(AgentMessageCollection<T> ios){
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
