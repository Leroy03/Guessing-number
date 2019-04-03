import java.util.Scanner;
import java.util.Random;
public class Problem_3 {

	public static int[] rand_array()		// create a 4 number for guessing by random
	{
		int[] num = new int [4];
		Random rand = new Random();
		for(int i = 0;i < 4; i++)
		{
			num[i] = rand.nextInt(9);
		}
		
		return num;
	}
	public static boolean Judge(int[] num,int[] guess)			//check out the guessing is correct to the answer
	{
		int A = 0;
		int B = 0;
		String result = "";
		//System.out.print(guess[0]);
		for(int i = 0;i < num.length; i++)
		{
			if(num[i] == guess[i])					//same number and same position
				A++;
			else
			{
				for(int j =0;j < num.length; j++)
					if(guess[i] == num[j] && guess[j] != num[j])			//same number but wrong position
					{
						B++;
						break;
					}
				
			}
		}
		result = A+" A "+B+" B ";
		System.out.println(result);
		if(A == 4)
			return false;
		return true;
		
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int []guess = new int [4];			// guessing	number set
		int []ans = new int [4];			// answer number set
		String tmp = "";
		System.out.println("Enter your guessing");
		tmp = scan.nextLine();				// scan in string
		for(int i = 0;i < 4;i++)
			guess[i]= tmp.charAt(i)-48;			// change string into integer array
		
		ans = Problem_3.rand_array();			// get random number array
		while(Problem_3.Judge(ans, guess))		// loop until guess right
		{
			System.out.println("Enter your guessing");
			tmp = scan.nextLine();
			for(int i = 0;i < 4;i++)
			{
				guess[i]= tmp.charAt(i)-48;		// change string into integer array
				//System.out.print(ans[i]);
			}
		}
		System.out.println("Congradulation !");
	}
}
