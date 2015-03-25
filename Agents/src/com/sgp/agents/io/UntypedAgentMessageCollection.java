package com.sgp.agents.io;

/**
 * @author cdhan_000
 * Similar to the AgentMessageCollection. However, this structure allows any kind of AgentMessage to be in the collection.
 */
public class UntypedAgentMessageCollection extends AgentMessageCollection<AgentMessage>{

	
	public UntypedAgentMessageCollection(){
		super();
	}
	
	public <T extends AgentMessage> UntypedAgentMessageCollection(AgentMessageCollection<T> other){
		super();
		
		for (T o : other.getAll()){
			super.addAgentIO(o);
		}
		
	}
	
	
	/**
	 * Filters messages based on the class given
	 * @param clazz SOme class to filter on
	 * @return A collection of messages that is of the given class.
	 */
	public <T extends AgentMessage> AgentMessageCollection<T> getInputs(Class<? extends T> clazz){
		
		AgentMessageCollection<T> ios = new AgentMessageCollection<T>();
		for (AgentMessage io : this.getAll()){
			if (io.getMessageClass().isAssignableFrom(clazz)){
				ios.addAgentIO((T)io.getSelf());
			}
		}
		return ios;
		
	}
	
	
	
	
}
