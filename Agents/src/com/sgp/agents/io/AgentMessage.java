package com.sgp.agents.io;

/**
 * @author cdhan_000
 * The AgentMessage is the high level class for any data being sent to/from an Agent.
 */
public class AgentMessage {

	private Object data;
	private String origin;
	
	/**
	 * Create a new AgentMessage with null data.
	 */
	public AgentMessage(){
		this(null);
	}
	
	/**
	 * Creates a new AgentMessage
	 * @param data The data that the Message contains
	 */
	public AgentMessage(Object data){
		this.data = data;
		this.origin = "unknown";
	}
	
	/**
	 * @return Gets the origin of this Message. TODO: don't use a string, turn into own class
	 */
	public String getOrigin(){
		return this.origin;
	}
	
	/**
	 * @return Gets the data stored inside the message
	 */
	public Object getData(){
		return data;
	}
	
	/**
	 * @return The class of this message. Use this instead of .getClass(). Its possible that one Message may be mascarading as another type.
	 * For example, the ReflectedAgentMessage pretends to be a different message. Calling getClass() on the ReflectedAgentMessage would return 
	 * ReflectedAgentMessage.class, and not the class of the Message it is trying to be.
	 */
	public Class<?> getMessageClass(){
		return this.getClass();
	}
	
	/**
	 * @return The AgentMessage. Reasoning for this method is similar to getAgentClass()
	 */
	public AgentMessage getSelf(){
		return this;
	}
	
	@Override
	public String toString(){
		return "[AgentIO: (" + getMessageClass().getSimpleName()+") ORIGIN=" +getOrigin() + ", DATA=" + getData() + "]";
	}
	
	
}
