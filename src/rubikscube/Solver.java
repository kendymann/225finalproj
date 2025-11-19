package rubikscube;

import java.lang.invoke.MethodHandles;

public class Solver {
	public static void main(String[] args) {
//		System.out.println("number of arguments: " + args.length);
//		for (int i = 0; i < args.length; i++) {
//			System.out.println(args[i]);
//		}

		if (args.length < 2) {
			System.out.println("File names are not specified");
			System.out.println("usage: java " + MethodHandles.lookup().lookupClass().getName() + " input_file output_file");
			return;
		}
		
		
		// TODO
		//File input = new File(args[0]);
		// solve...
		//File output = new File(args[1]);

	}
	private static class SearchNode implements Comparable<SearchNode> {
		
		int Cost; // F = G + H
		int DistFromStart; // G
		int Heuristic; // H
		RubiksCube CurrState; // This is state of the cube
		String path; // Stores the instructions that it took to get to this specific state

		public SearchNode( int DistFromStart, int Heuristic, RubiksCube Curr_State, String path){
			this.DistFromStart = DistFromStart;
			this.Heuristic = Heuristic;
			this.CurrState = Curr_State;
			this.path = path;
			Cost = DistFromStart + Heuristic;
		}

		public int compareTo( SearchNode other ){
			if( this.Cost > other.Cost ) return 1; // The 1 represents true that our cost is greater than the other cost
			else if ( this.Cost < other.Cost ) return -1; // The -1 represents that the other cost function is greater than this cost
			else return 0; // The zero represents equals 
		}
	}
}
