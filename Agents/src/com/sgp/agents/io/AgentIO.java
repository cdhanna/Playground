package com.sgp.agents.io;

public class AgentIO {

	private Object data;
	private String origin;
	
	public AgentIO(){
		this(null);
	}
	
	public AgentIO(Object data){
		this.data = data;
		this.origin = "unknown";
	}
	
	public String getOrigin(){
		return this.origin;
	}
	
	public Object getData(){
		return data;
	}
	
	public Class<?> getIOClass(){
		return this.getClass();
	}
	
	@Override
	public String toString(){
		return "[AgentIO: (" + getIOClass().getSimpleName()+") ORIGIN=" +getOrigin() + ", DATA=" + getData() + "]";
	}
	
	
}
