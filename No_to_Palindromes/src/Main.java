
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		String s = sc.next();
		sc.close();
		String next;
		
		if(p == 1)
		{
			System.out.println("NO");
		}
		else if(p == 2)
		{
			if(s.equals("a"))
				System.out.println("b");
			else if(s.equals("b"))
				System.out.println("NO");
			if(s.equals("ab"))
				System.out.println("ba");
			else if(s.equals("ba"))
				System.out.println("NO");
		}
		else
		{
			//We try incrementing the last character, then the second-to-last character, etc.
			//If we cannot increment the first character, we know there is no solution.
			boolean found = false;
			for(int i = s.length() - 1; i >= 0 && !found; i--)
			{
				//System.out.println("Next index: " + Integer.toString(i));
				char c = s.charAt(i);
				while( (int) c - (int) 'a' < p - 1 && !found)
				{
					c = nextLetter(c);
					//System.out.println(c + ", " + Integer.toString((int) c - (int) 'a'));
					if(i == 0 || (i == 1 && c != s.charAt(i - 1)) ||
							(i >= 2 && c != s.charAt(i - 1) && c != s.charAt(i - 2)))
					{
						next = fill(s, i, c);
						if(next.length() > 0)
						{
							System.out.println(next);
							found = true;
						}
					}
				}
			}
			
			if(!found)
				System.out.println("NO");
		}
	}
	
	public static char nextLetter(char c)
	{
		int val = (int) c;
		return (char) (val + 1);
	}
	
	public static String fill(String s, int index, char c)
	{
		//System.out.println("Filling string: " + s);
		StringBuilder next;
		if(index > 0)
			next = new StringBuilder(s.substring(0, index));
		else
			next = new StringBuilder("");
		next.append(c);
		
		//System.out.println(next);
		for(int i = index + 1; i < s.length(); i++)
		{
			//System.out.println(i);
			//System.out.println(next.charAt(i - 2) + ", " + next.charAt(i - 1));
			//If neither of the previous two characters is an a, we use that next.
			if((i == 1 || next.charAt(i - 2) != 'a') && next.charAt(i - 1) != 'a')
				next.append('a');
			//Otherwise, if neither of the previous two characters is a b, we use that next.
			else if((i == 1 || next.charAt(i - 2) != 'b') && next.charAt(i - 1) != 'b')
				next.append('b');
			//Otherwise, the previous two characters are a and b, so we add a c.
			else
				next.append('c');
		}
		
		return next.toString();
	}
}
