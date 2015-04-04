
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args)
	{
		//Read input
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();

		ArrayList<Integer> heavyList = findAll(s, "heavy");
		ArrayList<Integer> metalList = findAll(s, "metal");
		
		long heavyCount = 0; //total occurrences of 'heavy'
		long total = 0; //total substrings found
		int heavyPoint = 0;
		int metalPoint = 0;
		while(heavyPoint < heavyList.size() && metalPoint < metalList.size())
		{
			//If metal comes before heavy, we shift the metal pointer and
			//add the previous counts of heavy
			if(heavyList.get(heavyPoint) > metalList.get(metalPoint))
			{
				total += heavyCount;
				metalPoint += 1;
			}
			//If heavy comes before metal, we pop from the heavy list and
			//increment the counts of heavy
			else if(metalList.get(metalPoint) > heavyList.get(heavyPoint))
			{
				heavyCount += 1;
				heavyPoint += 1;
			}
		}
		total += heavyCount*(metalList.size() - metalPoint);
		System.out.println(total);
	}
	
	public static ArrayList<Integer> findAll(String s, String sub)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		int currLoc = 0;
		while(true)
		{
			int loc = s.indexOf(sub, currLoc);
			if(loc >= 0)
			{
				result.add(loc);
				currLoc = loc + 1;
			}
			else break;
		}
		
		return result;
	}
}
