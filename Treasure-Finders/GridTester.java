
public class GridTester {

	public static void main(String[] args) 
	{
		GameBoard game = new GameBoard();
		System.out.println(game.board);
		Grid board = new Grid(675/45,675/45);
		int HEIGHT = 675;
		int WIDTH = 675;
		int SCALE = 45;
		//add player
		Position playerPos=new Position(7,13);
		Player player = new Player("Player1",playerPos,7,13);
		board.addActor(player,playerPos);
		
		//add keys
		board.addActor(new BrownKey(),new Position(7,7));
		for(int d=1;d<6;d++)
		{
			board.addActor(new BrownKey(),new Position(d,1));
		}
		
		//add doors
		board.addActor(new BrownDoor(),new Position(1,6));
		board.addActor(new BrownDoor(),new Position(1,8));
		board.addActor(new BrownDoor(),new Position(13,6));
		board.addActor(new BrownDoor(),new Position(13,8));
		
		//add walls
		for(int x=0;x<HEIGHT/SCALE;x++)
		{
			board.addActor(new Wall(),new Position(0,x));
			board.addActor(new Wall(),new Position(x,0));
		}
		for(int y=1;y<HEIGHT/SCALE;y++)
		{
			board.addActor(new Wall(),new Position(14,y));
		}
		for(int i=1;i<HEIGHT/SCALE-1;i++)
		{
			board.addActor(new Wall(),new Position(i,14));
		}
		for(int w=1;w<(HEIGHT/SCALE-1)/2;w++)
		{
			board.addActor(new Wall(),new Position(6,w));
		}
		for(int w2=1;w2<(HEIGHT/SCALE-1)/2;w2++)
		{
			board.addActor(new Wall(),new Position(8,w2));
		}
		for(int w3=8;w3<HEIGHT/SCALE-1;w3++)
		{
			board.addActor(new Wall(),new Position(6,w3));
		}
		for(int w4=8;w4<HEIGHT/SCALE-1;w4++)
		{
			board.addActor(new Wall(),new Position(8,w4));
		}
		for(int w5=2;w5<7;w5++)
		{
			board.addActor(new Wall(),new Position(w5,8));
			board.addActor(new Wall(),new Position(w5,6));
		}
		for(int w6=9;w6<13;w6++)
		{
			board.addActor(new Wall(),new Position(w6,6));
			board.addActor(new Wall(),new Position(w6,8));
		}
		
		System.out.println(board);
		
		char[][] temp = board.getCharCopy();
		for(char[] t : temp)
		{
			for(char c : t)
				System.out.print(c+" ");
			System.out.println();
		}
			
	}

}
