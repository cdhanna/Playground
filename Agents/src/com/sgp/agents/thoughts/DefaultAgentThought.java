package com.sgp.agents.thoughts;

import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.EmptyAgentIO;

public class DefaultAgentThought implements AgentThought{

	@Override
	public AgentIO thinkOn(AgentIO input) {
		return new EmptyAgentIO();
	}
	
}
