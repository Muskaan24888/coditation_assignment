
import java.util.*;
public class Muskan_GameLife
{
   
	Scanner sc=new Scanner(System.in);
	int [][] board;
	int rows;
	int columns;
	int k=1;
        
        public void setData(int [][] board,int ROWS,int COLUMNS)//set the data for the cells/arrays
	{
		this.rows=ROWS;
		this.columns=COLUMNS;
		this.board=new int[rows][columns];
		for(int i=0;i<ROWS;i++)
			for(int j=0;j<COLUMNS;j++)
			this.board[i][j]=board[i][j];	
	}
        
        public void getData()//display the data of cells/arrays
	{
		for(int i=0;i<rows;i++)
		{	
			for(int j=0;j<columns;j++)
			System.out.print(board[i][j]);
		
		    System.out.println();
		}
		System.out.println();
	}
        
          public void  CellData()//get the one cell data and iterate one by one and pass to calculation part
	   {
		       for (int i = 0; i < rows; i++)
		      {
	                   for (int j = 0; j < columns; j++)
	                 {
	                    int Cell = board[i][j];
	                   calculate(i,j,Cell);
	                    
	                }
	          }

	           
	   }
          
           
		 public void calculate(int i,int j,int Cell) 
		 {
                int count=0;
			  
			    
	            int V_pre = i - 1;// vertical (row) previous
	            int V_next = i + 1;//vertical(next down side row) next
	            int H_pre = j - 1;//horizontal (column) previous  left side
	            int H_next = j + 1;//horizontal next(right size)
	            
                   //upper side vertical cell
	               if (V_pre >= 0 && board[V_pre][j]==1)
	                 count++; 
	               
	               //Lower side vertical cell
	               if(V_next<rows && board[V_next][j]==1)
	            	count++;
	            	
	            
	            
	              //left side horizontal cell
	               if(H_pre >=0 && board[i][H_pre]==1)
	               count++;
	            	
	            
	               //right side horizontal cell
	               if(H_next <columns && board[i][H_next]==1)
	            	count++;
	            	
	            
	            
	            //lower right side diagonal cell
	            if(j>=0 && j<columns-1 && i>=0 && i<rows-1)
	            {	
	               if(board[V_next][H_next]==1)
	            	   count++;
	                   
	            }
	            
	            //upper left side diagonal cell
	            if(i>0 && i<rows && j>0 && j<columns)
	            {
	            	if(board[V_pre][H_pre]==1)
	            		count++;
	            	    
	            }
	            
	            //lower left side diagonal cell
	            if(j>0 && j<columns && i>=0 && i<rows-1)
	            {
	            	if(board[V_next][H_pre]==1)
	            		count++;
	            	 
	            }
	            
	            //upper right side diagonal cell
	            if(i>0 && i<rows && j>=0 && j<columns-1)
	            {
	            	if(board[V_pre][H_next]==1)
	            	  count++;
	            	  
	            }
	            
	            
	            //if cell is live
	            if(Cell==1)
	            {
	            	
	            //live cell with fewer than two live neighbours dies by loneliness	
	            if(count<2)
	            	board[i][j]=0; //"0" for dead, "1" for live
	            
	            // live cell with more than three live neighbors dies, as if by overcrowding.
	            if(count>3)
	            	board[i][j]=0; //"0" for dead, "1" for live
	            
	            // Any live cell with two or three live neighbors lives, unchanged, to the next generation.
	            if(count==2|| count==3)
	            {
	            	board[i][j]=board[i][j];
	            }
	            }
	            
	            //if cell is dead
	            if(Cell==0)
	            {
	            	//. Any dead cell with exactly three live neighbors comes to life
	            	if(count==3)
	            	board[i][j]=1; //"0" for dead, "1" for live
	            }
	            

	       }
                 
                  public void PrintCellState()//print the status of the cell i.e live or dead
		{
		    int count_cell = 0;
			System.out.println("Enter The Cell position Which You Want To Check ");
			
			System.out.println("enter row position");
			int row_pos=sc.nextInt();
			
			System.out.println("Enter Column position");
			int col_pos=sc.nextInt();
			
			if(row_pos<rows && col_pos<columns)
			{	
			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<columns;j++)
					if(board[row_pos][col_pos]==0)
						count_cell=0;
					else
						count_cell=1;
			}	
			
			
				if(count_cell==0)
					System.out.println("cell status is Dead");
				if(count_cell==1)
					System.out.println("cell status is Live");
				    
			}
			
			
			else
			{
				System.out.println("!!!! Enter Correct Rows And Column!!!");
				PrintCellState();
			}
			
		}
                  
                  
                   public void printState()
	 {
		  
		     if(k<rows)
		     System.out.println("State: "+k++); //print state number
		     System.out.println();
			 for(int i=0;i<rows;i++)
			 {	 
				
				 for(int j=0;j<columns;j++)
					 System.out.print(board[i][j]);//print state
				 
				 System.out.println();
			 }
			 System.out.println();
		 }
                   
                   
                   
                   
                     public void getStates() 
	  {
		  int n;
		 
		 do {
			 
			 System.out.println("Game of LIfe");
				System.out.println(" 1. Get Next State\n 2. Check Cell\n 3. EXIT ");
				System.out.print("Enter choice:");
				int ch=sc.nextInt();
				
				switch(ch)
				{
				case 1:CellData();
				       printState();
				break;
				case 2:CellData();
				       PrintCellState();
				       
				break;
				case 3:System.out.println("THANK YOU");
                                        System.exit(2);
				
				break;
				
				default:
					System.out.println("Wrong Choice...\n!!");

				}
				
				System.out.print("Do you want to continue... enter 1 otherwise enter 0\n");
				 n=sc.nextInt();
		    }while(n!=0);
		
	  }
	
	    

	
	public static void main(String[] args) {
		
		
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Enter The Number Of Rows");
		 int ROWS=sc.nextInt();
		 
		 System.out.println("Enter The Number Of Column");
		 int COLUMN=sc.nextInt();
		 
		 int [][] grid=new int[ROWS][COLUMN];
		 
		 System.out.println( "Enter 1 for live cell .. Enter 0 for Dead cell\n" );
		 
		 for(int i=0;i<ROWS;i++)	 
			 for(int j=0;j<COLUMN;j++)
				 grid[i][j]=sc.nextInt();
		 
		 Muskan_GameLife G_obj=new Muskan_GameLife();
		 G_obj.setData(grid, ROWS, COLUMN);
		 G_obj.getData();
		 G_obj.getStates();
		 
    
}
}