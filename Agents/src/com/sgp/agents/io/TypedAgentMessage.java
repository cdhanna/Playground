package com.sgp.agents.io;


/**
 * @author cdhan_000
 * A type of AgentMessage. The regular AgentMessage contains an Object for data, but this class
 * specifies that to be a T for data. 
 * @param <T> some type
 */
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
