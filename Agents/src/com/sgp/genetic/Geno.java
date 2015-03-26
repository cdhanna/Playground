package com.sgp.genetic;

public interface Geno<T extends Geno<T>> {

	
	void mutate(float amount);
	
	T reproduce(T mate);
	
	T replicate();
	
	String display();
	
}
