package com.sgp.genetic;

public interface Geno<T extends Geno> {

	void mutate(float amount);
	float getRank();
	T birth(T mate);
	
}
