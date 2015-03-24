package com.sgp.agents.thoughts;

import com.sgp.agents.io.AgentIO;

public interface AgentThought {

	public void prepare();
	public void addIO(AgentIO input);
	public AgentIO think();
}
