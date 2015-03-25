package com.sgp.agents.io;

/**
 * @author cdhan_000
 * The ReflectedAgentMessage
 */
public class ReflectedAgentMessage extends AgentMessage{

	private AgentMessage original;
	private String origin;
	
	public ReflectedAgentMessage(String origin, AgentMessage original){
		super(original.getData());
		this.original = original;
		this.origin = origin;
		
	}
	
	@Override
	public String getOrigin(){
		return this.origin;
	}
	
	@Override
	public Class<?> getMessageClass(){
		return this.original.getClass();
	}
	
	@Override
	public AgentMessage getSelf(){
		return this.original;
	}
	
}
