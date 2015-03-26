package com.sgp.genetic;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

import com.sgp.genetic.sample.CloseIntRanker;
import com.sgp.genetic.sample.IntGeno;

public class GeneticSolver {


	public static void main(String[] args){

		System.out.println("gen test");

		GenoPopulation<IntGeno, CloseIntRanker> pop = new GenoPopulation<IntGeno, CloseIntRanker>(new CloseIntRanker());
		pop.add(new IntGeno(new int[]{41, 3}));
		pop.add(new IntGeno(new int[]{31, 7}));
		pop.add(new IntGeno(new int[]{81, 13}));
		pop.add(new IntGeno(new int[]{501, 9}));
		
		

		//pop = pop.evolve(0);
		//pop.display();

		for (int i = 0 ; i < 2000 ; i ++){
			System.out.println("EVOLVE");
			pop = pop.evolve(0);
			pop.display();
		}
		
		
	}

}
