package com.sgp.agents.thoughts;

import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.UntypedAgentIOCollection;

public interface AgentThought {

	public void prepare();
	public void addIO(AgentIO input);
	public UntypedAgentIOCollection think();
}
