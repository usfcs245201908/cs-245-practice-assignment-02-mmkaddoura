public class NQueens{

	int[][]board;
	int rowLength;


	public NQueens(int n){

		board=new int[n][n];
		rowLength=n;

	}


	public boolean placeNQueens(int row){
		if(row==rowLength)
			return true;
		for(int col=0;col<rowLength;col++){
			if(!isAttacked(row,col)){
				board[row][col]=1;
				if(placeNQueens(row+1))
					return true;
			else
				board[row][col]=0;
			}

		}
		return false;

	}

	public boolean placeNQueens() throws Exception{
		if(rowLength<1)
			throw new Exception("n cannot be smaller than one");
		return placeNQueens(0);
	}


	public boolean isAttacked(int rPosition,int cPosition){
		for (int i=0;i<rPosition;i++){ //down
			if(board[i][cPosition]==1)
				return true;
		}
		for (int i=rowLength-1;i>rPosition;i--){ //up
			if(board[i][cPosition]==1)
				return true;
		}
		for(int i=0;i<cPosition;i++){ //left
			if(board[rPosition][i]==1)
				return true;
		}
		for(int i=rowLength-1;i>cPosition;i--){ //right
			if(board[rPosition][i]==1)
				return true;
		}
		//diagonals...
		for(int i=rPosition, j=cPosition;i<rowLength && j<rowLength;i++,j++){ //down right
			if(board[i][j]==1)
				return true;
		}
		for(int i=rPosition, j=cPosition;i>=0 && j>=0;i--,j--){ //up left
			if(board[i][j]==1)
				return true;
		}
		for(int i=rPosition, j=cPosition;i>=0 && j<rowLength;i--,j++){ //up right
			if(board[i][j]==1)
				return true;
		}
		for(int i=rPosition, j=cPosition;i<rowLength && j>=0;i++,j--){ //down left
			if(board[i][j]==1)
				return true;
		}
		return false;
	}

	public void printToConsole() throws Exception{
		if(rowLength<1)
			throw new Exception("n cannot be smaller than one");
		if(placeNQueens()){
			for(int i=0;i<rowLength;i++){
				for(int j=0;j<rowLength;j++)
					if(board[i][j]==0)
						System.out.print("-");
					else
						System.out.print("Q");
				System.out.println();
			}

		}
		else
			System.out.println("Not successful.");
	}



}