
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		//Read input
		Scanner sc = new Scanner(System.in);
		int numPiles = sc.nextInt();
		int[] piles = new int[numPiles];
		for(int i = 0; i < numPiles; i++)
			piles[i] = sc.nextInt();
		
		int numQuestions = sc.nextInt();
		int[] questions = new int[numQuestions];
		for(int i = 0; i < numQuestions; i++)
			questions[i] = sc.nextInt();
		sc.close();
		
		//Relabel piles by number of worms seen
		int[] wormSums = new int[numPiles];
		wormSums[0] = piles[0];
		for(int i = 1; i < numPiles; i++)
			wormSums[i] = piles[i] + wormSums[i - 1];
		
		//Binary search for worm index
		for(int i = 0; i < numQuestions; i++)
		{
			int loc = binarySearch(wormSums, questions[i], 0, numPiles) + 1; //Convert to 1-based piles
			System.out.println(loc);
		}
	}
	
	//Uses a binary search to find the first index i such that arr[i] >= num
	public static int binarySearch(int[] arr, int num, int start, int end)
	{
		//System.out.println(Integer.toString(num) + ", " + Integer.toString(start) + ", " + Integer.toString(end));
		if(start == end)
			return start;
		else
		{
			int currLoc = (start + end)/2;
			if(arr[currLoc] < num)
				return binarySearch(arr, num, currLoc + 1, end);
			else
				return binarySearch(arr, num, start, currLoc);
		}
	}

}
