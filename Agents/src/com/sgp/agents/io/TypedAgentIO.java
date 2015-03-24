package com.sgp.agents.io;

public class TypedAgentIO<T> extends AgentIO{
	
	private T typedData;
	
	public TypedAgentIO(T data){
		super(data);
		this.typedData = data;
	}
	
	@Override
	public T getData(){
		return (T)this.typedData;
	}
	

	
}
