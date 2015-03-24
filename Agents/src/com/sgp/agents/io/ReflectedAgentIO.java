package com.sgp.agents.io;

public class ReflectedAgentIO extends AgentIO{

	private AgentIO original;
	private String origin;
	
	public ReflectedAgentIO(String origin, AgentIO original){
		super(original.getData());
		this.original = original;
		this.origin = origin;
		
	}
	
	@Override
	public String getOrigin(){
		return this.origin;
	}
	
	@Override
	public Class<?> getIOClass(){
		return this.original.getClass();
	}
	
	
}
