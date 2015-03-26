package com.sgp.genetic;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class GeneticSolver {


	public static void main(String[] args){

		System.out.println("gen test");

		List<FloatGeno> genos = new ArrayList<FloatGeno>();
		for (int i = 0 ; i < 6 ; i ++){
			genos.add(new FloatGeno());
		}



		PriorityQueue<FloatGeno> pool = new PriorityQueue<FloatGeno>(new Comparator<FloatGeno>(){
			@Override
			public int compare(FloatGeno g1, FloatGeno g2) {
				if (g2.getRank() > g1.getRank()){
					return 1;
				} else return -1;
			}});

		for (int i = 0 ; i < 3 ; i ++){
			pool.clear();
			for (FloatGeno g : genos){
				g.mutate(1);
				pool.add(g);
			}
			
			//kill the last two things in the genos
			int gIndex = 0;
			int gSize = 6;
			genos.clear();
			while (!pool.isEmpty()){
				FloatGeno g = pool.poll();
				
				if (gIndex < 2){
					//reprodice
					FloatGeno mate = pool.peek();
					genos.add(g.birth(mate));
				}
				
				 if (gIndex < gSize - 2){
					genos.add(g);
				}
				
				gIndex ++;
			}
		}

		for (FloatGeno g : genos){
			System.out.println(g.getRank());
		}


	}

}
