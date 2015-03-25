package com.sgp.agents.thoughts;

import com.sgp.agents.io.AgentMessage;
import com.sgp.agents.io.UntypedAgentMessageCollection;

/**
 * @author cdhan_000
 * An AgentThought is like an action to perform on AgentMessages.
 * 
 */
public interface AgentThought {

	/**
	 * inform the thought that its time to start thinking again. 
	 */
	public void prepare();
	
	/**
	 * Add a message to the thought before calculation is done
	 * @param input 
	 */
	public void addMessage(AgentMessage input);
	
	
	/**
	 * @return the result of thinking about all the AgentMessages that were supplied by addMessage()
	 */
	public UntypedAgentMessageCollection think();
}
