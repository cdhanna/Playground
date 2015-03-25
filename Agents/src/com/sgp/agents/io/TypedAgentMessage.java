package com.sgp.agents.io;

public class TypedAgentMessage<T> extends AgentMessage{
	
	private T typedData;
	
	public TypedAgentMessage(T data){
		super(data);
		this.typedData = data;
	}
	
	@Override
	public T getData(){
		return (T)this.typedData;
	}
	

	
}
