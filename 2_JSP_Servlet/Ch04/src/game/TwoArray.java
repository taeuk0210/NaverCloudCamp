package game;

public class TwoArray {
	public int mapSize = 4;
	public int[][] map = new int[mapSize][mapSize];
	/* direction code
	   1 : top(w)
	   2 : bottom(s)
	   3 : left(a)
	   4 : right(d)  
	*/
	
	public int findScore() {
		int score = 0;
		for (int i=0; i<mapSize; i++) {		
			for (int j=0; j<mapSize; j++) {
				if (score < map[i][j]) {
					score = map[i][j];
				}
			}
		}
		return score;
	}
	
	
	// Summation between two rows.
	
	public void moveLeft(TwoArray game) {
		for (int i=0; i<mapSize; i++) {
			map[i] = game.summation(map[i]);
		}
	}
	
	public void moveRight(TwoArray game) {
		for (int i=0; i<mapSize; i++) {
			int[] invLine = new int[mapSize];
			for (int j=0; j<mapSize; j++) {
				invLine[j] = map[i][mapSize-1-j];
			}
			invLine = game.summation(invLine);
			for (int j=0; j<mapSize; j++) {
				map[i][mapSize-1-j] = invLine[j];
			}
		}
	}
	
	public void moveTop(TwoArray game) {
		for (int i=0; i<mapSize; i++) {
			int[] Line = new int[mapSize];
			for (int j=0; j<mapSize; j++) {
				Line[j] = map[j][i];
			}
			Line = game.summation(Line);
			for (int j=0; j<mapSize; j++) {
				map[j][i] = Line[j];
			}
		}
	}
	
	public void moveBottom(TwoArray game) {
		for (int i=0; i<mapSize; i++) {
			int[] invLine = new int[mapSize];
			for (int j=0; j<mapSize; j++) {
				invLine[j] = map[mapSize-1-j][i];
			}
			invLine = game.summation(invLine);
			for (int j=0; j<mapSize; j++) {
				map[mapSize-1-j][i] = invLine[j];
			}
		}
	}
	
	
	// summation using stack
	
	public int[] summation(int[] input) {
		int[] output = new int[mapSize];
		int top=0, idx=0;
		
		for (int i=0; i<mapSize; i++) {
			output[i] = 0;
		}
		while (idx < mapSize) {
			if (input[idx] != 0) {
				if (top == 0) {
					output[top] = input[idx++];
					top++;
				} else if (output[top-1] != 0 && output[top-1] == input[idx]) {
					output[top-1] += input[idx++];
				} else {
					output[top] = input[idx++];
					top++;
				}
			} else {
				idx++;
			}
		}
		return output;
	}


	// Show full game map.
	
	public void showMap() {
		for (int i=0; i<mapSize; i++) {
			for (int j=0; j<mapSize; j++) {
				System.out.printf("%4d", map[i][j]);
				System.out.print("  ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	
	// generate 2 and 4.
	
	public int[] randomGen(int n) {
		int[] randomNums = new int[n];
		for (int i=0; i<n; i++) {
			randomNums[i] = (Math.random() > 0.5) ? 2 : 4 ;
		}
		return randomNums;
	}
	
	
	// generate position of numbers.
	
	public int[][] positionGen(int n) {
		int[][] randomPos = new int[n][2];
		for (int i=0; i<n; i++) {
			randomPos[i][0] = (int) (Math.random() * (mapSize - 1));
			randomPos[i][1] = (int) (Math.random() * (mapSize - 1));
		}
		return randomPos;
	}
	
	
	// input numbers on the map.
	
	public void updateMap(int n, TwoArray game) {
		int[] randomNums;
		int[][] randomPos;
		
		randomNums = game.randomGen(n);
		randomPos = game.positionGen(n);
		for (int i=0; i<n; i++) {
			if (map[randomPos[i][0]][randomPos[i][1]] == 0) {
			map[randomPos[i][0]][randomPos[i][1]] = randomNums[i];
			}
		}
	}
}