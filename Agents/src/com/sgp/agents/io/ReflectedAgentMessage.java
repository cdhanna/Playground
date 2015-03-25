package com.sgp.agents.io;

/**
 * @author cdhan_000
 * The ReflectedAgentMessage is used for repurposing Messages. It follows the decorater pattern.
 * Essentially, it pretends to be a different AgentMessage. 
 * This is useful when the Agent backend is setting the origin of messages, internally. 
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
