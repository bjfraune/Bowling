

	public class ScoreSheet {

		int[] byFrameTotal = new int[10];
		int[] cumTotal = new int[10];
		int frame = 0;
		int pins;
		
		public void nextFrame(int firstBall, int secondBall) {
			++frame;
			if(frame > 9){
				endOfGame();
				return;
			}
			pins = 10;
			int first =firstThrow(firstBall);
			
			if (first != 10)
			{
				int second = secondThrow(secondBall);
			}
			
			
			
		// if first throw is 10, then dont do secondthrow
			
		}
		public int firstThrow(int pinsDown){
			if(pinsDown >10 || pinsDown <0) throw new IllegalArgumentException("no can do");
			return pinsDown;	
		}
		
		public int secondThrow(int pinsDown){
			
		}
		
		public int getScore(){
			int total=0;
			for(int i =0; i< 10; ++i)
			{
				total += byFrameTotal[i];
			}
			return total;
		}
		
		public int getFrameScore(int frame){
	//TODO
			return 0;
			
		}
		
		public void endOfGame(){
			System.out.println("Total score:"+ getScore() +"\nEnd of Game");
		}
		
		public static void main(){
			
			// run the game here
		
			
		}
	
	
}
