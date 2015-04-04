
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int numPiles = sc.nextInt();
		int[] piles = new int[numPiles];
		for(int i = 0; i < numPiles; i++)
			piles[i] = sc.nextInt();
		
		int numQuestions = sc.nextInt();
		int[] questions = new int[numQuestions];
		for(int i = 0; i < numQuestions; i++)
			questions[i] = sc.nextInt() - 1; //Convert to 0-based queries
		sc.close();
		
		int totalWorms = 0;
		for(int i = 0; i < numPiles; i++)
			totalWorms += piles[i];
		
		int[] wormLocs = new int[totalWorms];
		int currWorm = 0;
		for(int i = 0; i < numPiles; i++)
		{
			for(int j = 0; j < piles[i]; j++)
			{
				wormLocs[currWorm] = i + 1; //Convert to 1-based piles
				currWorm++;
			}
		}
		
		for(int i = 0; i < numQuestions; i++)
			System.out.println(wormLocs[questions[i]]);
	}
}
