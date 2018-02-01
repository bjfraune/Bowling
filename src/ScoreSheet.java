import java.util.Random;

public class ScoreSheet {

		int[][] byFrame = new int[12][2];
		int frame = 0;
		int pins;
		boolean isFirstThrow = true;
		//

		public void nextFrame(int firstBall, int secondBall) {
			
			if(frame > 9){
				endOfGame();
				return;
			}
			isFirstThrow = true;
			pins = 10;
			int first = firstThrow(firstBall);
			
			if (byFrame[frame][0] != 10)
			{
				isFirstThrow = false;
				secondThrow(secondBall);
				
			}
			System.out.println("Frame: "+ frame + "\nFirstBall: "+ byFrame[frame][0] + "\nSecondBall: "+ byFrame[frame][1] + "\n\n");
			++frame;
		// if first throw is 10, then dont do secondthrow
			
		}
		public int firstThrow(int pinsDown){
			if(pinsDown > 10 || pinsDown < 0) throw new IllegalArgumentException("firstthrow invalid pinsDown");
			byFrame[frame][0]= pinsDown;
			return pinsDown;	
		}
		
		public void secondThrow(int pinsDown){
			int remaining = 10 - byFrame[frame][0];
			if(pinsDown > remaining || pinsDown <0 ) throw new IllegalArgumentException("secondthrow invalid pinsDown");
			byFrame[frame][1]= pinsDown;	
		}
		
		public int getScore(){
			// gets score at any point in game (including the end of game)
			int total=0;
			for(int i =0; i< 10; ++i){
				if(byFrame[i][0] == 10){	
					// special case of a strike
					if(byFrame[i+1][0] == 10){
						// 2 strikes in a row
						total+= 20 + byFrame[i +2][0];
					}
					else{
						total += 10+ byFrame[i+1][0] + byFrame[i+1][1];
					}
				}
				else if(byFrame[i][0] + byFrame[i][1] == 10){	
					// special case of a spare
					total += 10 + byFrame[i+1][0];
					
				}
				else{
					// everything else
					total+= byFrame[i][0]+ byFrame[i][1];
				}
			}
			return total;
		}
		
		public int getFrameScore(int frameNumber){ 
			// put in frame number [1, 10] and it will calculate the score for that frame
			if(frameNumber > 0 && frameNumber <=10) throw new IllegalArgumentException("getFrameScore() invalid frameNumber");
			
			frameNumber --;	// adjustment since array starts at 0
			
			int frameScore = 0;	// initialized to zero
			
			if(byFrame[frameNumber][0] == 10){	
				// special case of a strike
				if(byFrame[frameNumber+1][0] == 10){
					// 2 strikes in a row
					frameScore+= 20 + byFrame[frameNumber +2][0];
				}
				else{
					frameScore += 10+ byFrame[frameNumber+1][0] + byFrame[frameNumber+1][1];
				}
			}
			else if(byFrame[frameNumber][0] + byFrame[frameNumber][1] == 10){	
				// special case of a spare
				frameScore += 10 + byFrame[frameNumber+1][0];
			}
			else{
				// everything else
				frameScore+= byFrame[frameNumber][0]+ byFrame[frameNumber][1];
			}
			return frameScore;
			
		}
		
		public void endOfGame(){
			System.out.println("Total score:"+ getScore() +"\nEnd of Game");
		}
		
//		public static void main(String[] arg){
//			for(int i = 1; i <= 11; ++i){
//				Random rand = new Random();
//				int firstBall = rand.nextInt(11);
//				int secondBall = rand.nextInt(10-firstBall);
//				nextFrame(firstBall, secondBall);
//			}
//		}
//	
	
}
