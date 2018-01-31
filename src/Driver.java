import java.util.Random;


public class Driver {
	
	public static void main(String[] args)
	{
		ScoreSheet s1 = new ScoreSheet();
		
		for(int i = 1; i <= 11; ++i){
			Random rand = new Random();
			int firstBall = rand.nextInt(11);
			int secondBall = rand.nextInt(10-firstBall+1);
			s1.nextFrame(firstBall, secondBall);
		}
	}

}
