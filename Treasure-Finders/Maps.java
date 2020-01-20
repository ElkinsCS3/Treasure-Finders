import static java.lang.System.*;

import java.awt.Color;
//changed maps from being Thing[][] to being Thing[][]
public class Maps
{
	private static Color[][] wallText;
	private static Wall W;//wall
	public int currentmap;
	private static final 	 		Thing l = null;//space

	private static final 		   Portal P = new Portal();//portal
	private static final 	 PortalReturn R = new PortalReturn();//return portal

	private static final 		 BrownKey J = new BrownKey();//key1 //YELLOW KEY
	private static final 		 RedKey   K = new RedKey();//key2 //RED KEY
	private static final 		 BlueKey  L = new BlueKey();//key3 //BLUE KEY
	private static final 		 AllKey   x = new AllKey();//key4 //ONE OF EACH KEYS

	private static final 		BrownDoor D = new BrownDoor();//door1 //YELLOW DOOR
	private static final 	 	RedDoor   B = new RedDoor();//door2 //RED DOOR
	private static final 		BlueDoor  E = new BlueDoor();//door3 //BLUE DOOR

	private static final    GreenTouguai  g = new GreenTouguai();
	private static final      RedTouguai  r = new RedTouguai();
	private static final        Smallbat  b = new Smallbat();
	private static final     SkeletonMan  n = new SkeletonMan();
	private static final     CyanTouguai  c = new CyanTouguai();
	private static final SkeletonSoldier  k = new SkeletonSoldier();
	private static final      JuniorMage  j = new JuniorMage();
	private static final          Bigbat  i = new Bigbat();
	private static final   Animalmaskman  a = new Animalmaskman();
	private static final SkeletonCaptain  p = new SkeletonCaptain();
   private static final StoneFrankenstein f = new StoneFrankenstein();
	private static final        MaiMage   e = new MaiMage();
	private static final    Juniorguard   u = new Juniorguard();
	private static final         Redbat   d = new Redbat();
	private static final     SeniorMage   o = new SeniorMage();
	private static final     StrangeKing  q = new StrangeKing();
	private static final     WhiteKnight  w = new WhiteKnight();
	private static final     GoldGuard    G = new GoldGuard();
	private static final     RedMage      O = new RedMage();
private static final Animalmaskwarrior    C = new Animalmaskwarrior();
	private static final  Plutoguard      M = new Plutoguard();
	private static final Seniorguard      N = new Seniorguard();
	private static final Doubleswordsman  Z = new Doubleswordsman();
	private static final Plutowarrior     I = new Plutowarrior();
	private static final Goldcaptain      V = new Goldcaptain();
	private static final Spiritmage       U = new Spiritmage();


	private static final 		   Potato Q = new Potato();//potato
	private static final 		Bigpotato t = new Bigpotato();//Bigpotato

	private static final 		    Sword S = new Sword();//Sword
	private static final 		   Shield H = new Shield();//Shield

	private static final 	    BossSword s = new BossSword();//BossSword
	private static final 	DiamondShield h = new DiamondShield();

	private static final 		teleport tp = new teleport();

	private static 		 	     FakeWall F = new FakeWall();

	private static final 		    Armor A = new Armor();//Armor
	private static final 	TreasureChest T = new TreasureChest();//TreasureChest

	private static final 		Boss Y = new Boss();

	public Maps(Color[][] tx)
	{
		F = new FakeWall(wallText);
		currentmap=0;
		setWallText();
		W = new Wall(wallText);//wall
	}
	public Thing[][] map1()//clear
	{
		currentmap=1;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,P,l,J,g,r,g,l,l,l,l,l,W},//1
		 {W,W,W,W,W,W,W,W,W,W,W,l,W},//2
		 {W,Q,l,n,D,l,W,Q,J,Q,W,l,W},//3
		 {W,J,n,S,W,l,W,Q,J,Q,W,l,W},//4
		 {W,W,D,W,W,l,W,W,W,c,W,l,W},//5
		 {W,J,k,l,W,l,D,j,g,b,W,l,W},//6
		 {W,H,l,L,W,l,W,W,W,W,W,l,W},//7
		 {W,W,D,W,W,l,l,l,l,l,l,l,W},//8
		 {W,l,k,l,W,W,B,W,W,W,D,W,W},//9
		 {W,Q,t,Q,W,l,x,l,W,J,a,L,W},//10
		 {W,Q,tp,Q,W,l,l,l,W,Q,Q,Q,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[1][1] = new Portal(2,new Position(2,1));

		m[1][4] = new GreenTouguai("GreenTouguai",new Position(4,5),1,20);
		m[1][5] = new RedTouguai("RedTouguai",new Position(4,5),2,15);
		m[1][6] = new GreenTouguai("GreenTouguai",new Position(4,5),1,20);
		m[3][3] = new SkeletonMan("SkeletonMan",new Position(4,5),5,25);
		m[4][2] = new SkeletonMan("SkeletonMan",new Position(4,5),5,25);
		m[5][9] = new CyanTouguai("CyanTouguai",new Position(4,5),10,35);
		m[6][2] = new SkeletonSoldier("SkeletonSoldier",new Position(4,5),20,40);
		m[6][7] = new JuniorMage("JuniorMage",new Position(4,5),25,50);
		m[6][8] = new GreenTouguai("GreenTouguai",new Position(4,5),1,20);
		m[6][9] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[9][2] = new SkeletonSoldier("SkeletonSoldier",new Position(4,5),20,40);
		m[10][10] = new Animalmaskman("Animalmaskman",new Position(4,5),45,75);



		return m;
	}
	public Thing[][] map2()//clear
	{
		currentmap=2;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,R,W,l,V,l,W,S,H,J,K,W,W},//1
		 {W,l,W,H,W,t,W,S,H,J,L,W,W},//2
		 {W,l,W,J,W,J,W,S,H,J,G,W,W},//3
		 {W,l,W,J,W,J,W,W,W,W,D,W,W},//4
		 {W,l,W,l,W,l,l,l,D,l,l,W,W},//5
		 {W,l,W,D,W,W,D,W,W,D,W,W,W},//6
		 {W,l,W,l,G,l,l,W,s,G,h,W,W},//7
		 {W,l,W,D,W,W,E,W,s,W,h,W,W},//8
		 {W,l,W,J,W,t,Q,W,s,W,h,W,W},//9
		 {W,l,W,J,W,t,Q,W,l,l,l,W,W},//10
		 {W,P,W,S,W,t,Q,W,l,P,l,W,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[11][1] = new Portal(3,new Position(11,2));

		m[3][10] = new GoldGuard("GoldGuard",new Position(4,5),200,350);
		m[7][4] = new GoldGuard("GoldGuard",new Position(4,5),200,350);
		m[7][9] = new GoldGuard("GoldGuard",new Position(4,5),200,350);

		m[1][4] = new Goldcaptain("Goldcaptain",new Position(4,5),650,750);

		m[11][9] = new Portal(4,new Position(2,6));

		m[1][1] = new PortalReturn(1,new Position(1,2));

		return m;
	}
	public Thing[][] map3()//clear
	{
		currentmap=3;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,s,r,J,W,l,l,l,W,W,W,W,W},//1
		 {W,r,J,l,W,l,l,l,W,l,b,l,W},//2
		 {W,J,n,l,W,W,D,W,W,l,W,l,W},//3
		 {W,W,D,W,W,l,n,l,W,J,W,r,W},//4
		 {W,l,J,l,W,W,W,l,W,J,W,b,W},//5
		 {W,g,W,l,b,r,b,l,W,J,W,r,W},//6
		 {W,g,W,W,W,W,W,l,l,l,W,l,W},//7
		 {W,l,l,J,l,l,W,W,D,W,W,l,W},//8
		 {W,W,W,W,W,b,W,r,l,r,W,l,W},//9
		 {W,W,l,J,l,l,W,H,b,J,W,l,W},//10
		 {W,R,l,W,W,W,W,S,t,J,W,P,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[11][11] = new Portal(4,new Position(10,11));

		m[1][2] = new RedTouguai("RedTouguai",new Position(4,5),2,15);
		m[2][1] = new RedTouguai("RedTouguai",new Position(4,5),2,15);
		m[2][10] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[3][2] = new SkeletonMan("SkeletonMan",new Position(4,5),5,25);
		m[4][6] = new SkeletonMan("SkeletonMan",new Position(4,5),5,25);
		m[4][11] = new RedTouguai("RedTouguai",new Position(4,5),2,15);
		m[5][11] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[6][1] = new GreenTouguai("GreenTouguai",new Position(4,5),1,20);
		m[6][4] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[6][5] = new RedTouguai("RedTouguai",new Position(4,5),2,15);
		m[6][6] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[6][11] = new RedTouguai("RedTouguai",new Position(4,5),2,15);
		m[7][1] = new GreenTouguai("GreenTouguai",new Position(4,5),1,20);
		m[9][5] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[9][7] = new RedTouguai("RedTouguai",new Position(4,5),2,15);
		m[9][9] = new RedTouguai("RedTouguai",new Position(4,5),2,15);
		m[10][8] = new Smallbat("Smallbat",new Position(4,5),5,20);

		m[11][1] = new PortalReturn(2,new Position(10,1));
		return m;
	}
	public Thing[][] map4()//clear
	{
		currentmap=4;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,l,c,l,W,l,P,l,W,l,c,l,W},//1
		 {W,D,W,D,W,l,l,l,W,D,W,D,W},//2
		 {W,l,W,l,W,W,F,W,W,l,W,l,W},//3
		 {W,b,W,n,W,i,d,i,W,n,W,b,W},//4
		 {W,b,W,Q,W,H,i,H,W,Q,W,b,W},//5
		 {W,r,W,Q,W,W,B,W,W,Q,W,r,W},//6
		 {W,l,W,l,W,a,u,a,W,l,W,l,W},//7
		 {W,l,W,l,W,S,a,S,W,l,W,l,W},//8
		 {W,l,W,l,W,W,D,W,W,l,W,l,W},//9
		 {W,l,W,l,W,J,l,J,W,l,W,l,W},//10
		 {W,P,W,l,c,l,l,l,c,l,W,R,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[11][1] = new Portal(5,new Position(10,1));

		m[1][6] = new Portal(2,new Position(10,9));


		m[1][2] = new CyanTouguai("CyanTouguai",new Position(4,5),10,35);
		m[1][10] = new CyanTouguai("CyanTouguai",new Position(4,5),10,35);

		m[11][8] = new CyanTouguai("CyanTouguai",new Position(4,5),10,35);
		m[11][4] = new CyanTouguai("CyanTouguai",new Position(4,5),10,35);

		m[4][6] = new Redbat("Redbat",new Position(4,5),90,160);

		m[5][6] = new Bigbat("Bigbat",new Position(4,5),30,65);
		m[4][7] = new Bigbat("Bigbat",new Position(4,5),30,65);
		m[4][5] = new Bigbat("Bigbat",new Position(4,5),30,65);

		m[4][3] = new SkeletonMan("SkeletonMan",new Position(4,5),5,25);
		m[4][9] = new SkeletonMan("SkeletonMan",new Position(4,5),5,25);

		m[8][6] = new Animalmaskman("Animalmaskman",new Position(4,5),45,75);
		m[7][7] = new Animalmaskman("Animalmaskman",new Position(4,5),45,75);
		m[7][5] = new Animalmaskman("Animalmaskman",new Position(4,5),45,75);
		m[7][6] = new Juniorguard("Juniorguard",new Position(4,5),90,150);

		m[6][1] = new RedTouguai("RedTouguai",new Position(4,5),2,15);
		m[6][11] = new RedTouguai("RedTouguai",new Position(4,5),2,15);

		m[5][1] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[4][1] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[4][11] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[4][11] = new Smallbat("Smallbat",new Position(4,5),5,20);


		m[11][11] = new PortalReturn(3,new Position(10,11));

		m[3][6] = new FakeWall(wallText);

		return m;
	}
	public Thing[][] map5()//clear
	{
		currentmap=5;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,x,W,Q,W,t,j,l,l,j,J,L,W},//1
		 {W,l,W,s,W,j,l,l,l,l,j,J,W},//2
		 {W,i,W,l,W,k,l,W,W,D,W,W,W},//3
		 {W,l,D,j,W,h,k,W,l,a,k,l,W},//4
		 {W,i,W,l,W,W,W,W,l,l,l,k,W},//5
		 {W,S,W,l,l,l,b,n,J,l,l,l,W},//6
		 {W,H,W,W,c,W,W,W,W,l,l,l,W},//7
		 {W,K,l,W,c,W,l,l,l,a,u,l,W},//8
		 {W,W,W,W,b,W,D,W,E,W,D,W,W},//9
		 {W,l,J,W,l,W,b,W,H,D,l,W,W},//10
		 {W,R,l,b,l,l,l,W,J,W,P,W,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[11][10] = new Portal(6,new Position(10,10));

		m[11][3] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[9][4] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[10][6] = new Smallbat("Smallbat",new Position(4,5),5,20);
		m[6][6] = new Smallbat("Smallbat",new Position(4,5),5,20);

		m[8][4] = new CyanTouguai("CyanTouguai",new Position(4,5),10,35);
		m[7][4] = new CyanTouguai("CyanTouguai",new Position(4,5),10,35);

		m[6][7] = new SkeletonMan("SkeletonMan",new Position(4,5),5,25);

		m[1][9] = new JuniorMage("JuniorMage",new Position(4,5),25,50);
		m[2][10] = new JuniorMage("JuniorMage",new Position(4,5),25,50);
		m[2][5] = new JuniorMage("JuniorMage",new Position(4,5),25,50);
		m[1][6] = new JuniorMage("JuniorMage",new Position(4,5),25,50);
		m[4][3] = new JuniorMage("JuniorMage",new Position(4,5),25,50);

		m[3][1] = new Bigbat("Bigbat",new Position(4,5),30,65);
		m[5][1] = new Bigbat("Bigbat",new Position(4,5),30,65);

		m[4][6] = new SkeletonSoldier("SkeletonSoldier",new Position(4,5),50,90);
		m[3][5] = new SkeletonSoldier("SkeletonSoldier",new Position(4,5),50,90);
		m[5][11] = new SkeletonSoldier("SkeletonSoldier",new Position(4,5),50,90);
		m[4][10] = new SkeletonSoldier("SkeletonSoldier",new Position(4,5),50,90);

		m[4][9] = new Animalmaskman("Animalmaskman",new Position(4,5),45,75);
		m[8][9] = new Animalmaskman("Animalmaskman",new Position(4,5),45,75);
		m[8][10] = new Juniorguard("Juniorguard",new Position(4,5),90,150);


		m[11][1] = new PortalReturn(4,new Position(10,1));

		return m;
	}
	public Thing[][] map6()//clear
	{
		currentmap=6;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,l,p,W,H,W,Q,q,l,W,t,t,W},//1
		 {W,p,J,W,S,W,l,Q,q,W,f,t,W},//2
		 {W,J,d,E,l,E,d,l,Q,W,l,f,W},//3
		 {W,l,l,W,u,W,l,l,l,W,O,l,W},//4
		 {W,W,W,W,B,W,W,W,W,W,D,W,W},//5
		 {W,l,l,o,l,J,J,J,l,o,l,l,W},//6
		 {W,l,W,W,W,W,W,W,W,W,W,W,W},//7
		 {W,l,W,i,D,i,l,l,l,l,l,W,W},//8
		 {W,l,W,D,W,D,W,W,W,W,E,W,W},//9
		 {W,l,W,i,W,l,l,W,W,J,l,W,W},//10
		 {W,l,l,l,W,P,l,D,D,l,R,W,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[11][5] = new Portal(7,new Position(11,6));

		m[8][5] = new Bigbat("Bigbat",new Position(4,5),30,65);
		m[8][3] = new Bigbat("Bigbat",new Position(4,5),30,65);
		m[10][3] = new Bigbat("Bigbat",new Position(4,5),30,65);

		m[6][3] = new SeniorMage("SeniorMage",new Position(4,5),110,200);
		m[6][9] = new SeniorMage("SeniorMage",new Position(4,5),110,200);

		m[4][4] = new Juniorguard("Juniorguard",new Position(4,5),90,150);

		m[2][1] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);
		m[1][2] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);

		m[2][10] = new StoneFrankenstein("StoneFrankenstein",new Position(4,5),65,115);
		m[3][11] = new StoneFrankenstein("StoneFrankenstein",new Position(4,5),65,115);

		m[1][7] = new StrangeKing("StrangeKing",new Position(4,5),125,250);
		m[2][8] = new StrangeKing("StrangeKing",new Position(4,5),125,250);

		m[4][10] = new RedMage("RedMage",new Position(4,5),260,400);

		m[3][2] = new Redbat("Redbat",new Position(4,5),90,160);
		m[3][6] = new Redbat("Redbat",new Position(4,5),90,160);



		m[11][10] = new PortalReturn(5,new Position(10,10));

		return m;
	}
	public Thing[][] map7()
	{
		currentmap=7;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,P,l,l,l,l,l,l,l,W,W,W,W},//1
		 {W,W,W,l,d,W,E,W,p,l,W,W,W},//2
		 {W,W,l,d,H,W,w,W,S,p,l,W,W},//3
		 {W,l,l,W,W,W,W,W,W,W,l,l,W},//4
		 {W,l,l,E,w,F,l,W,w,E,l,l,W},//5
		 {W,l,W,W,W,W,W,W,W,W,W,l,W},//6
		 {W,l,W,Q,S,W,w,W,H,Q,W,l,W},//7
		 {W,l,W,J,Q,W,E,W,Q,J,W,l,W},//8
		 {W,l,W,W,J,J,t,J,J,W,W,l,W},//9
		 {W,l,l,W,W,W,B,W,W,W,l,l,W},//10
		 {W,W,l,L,D,R,l,l,D,l,l,W,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[1][1] = new Portal(8,new Position(2,1));

		m[2][8] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);
		m[3][9] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);

		m[3][3] = new Redbat("Redbat",new Position(4,5),90,160);
		m[2][4] = new Redbat("Redbat",new Position(4,5),90,160);

		m[5][4] = new WhiteKnight("WhiteKnight",new Position(4,5),150,300);
		m[5][8] = new WhiteKnight("WhiteKnight",new Position(4,5),150,300);
		m[3][6] = new WhiteKnight("WhiteKnight",new Position(4,5),150,300);
		m[7][6] = new WhiteKnight("WhiteKnight",new Position(4,5),150,300);



		m[11][5] = new PortalReturn(6,new Position(11,6));

		m[5][5] = new FakeWall(wallText);

		return m;
	}
	public Thing[][] map8()
	{
		currentmap=8;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,R,W,l,l,l,l,W,l,J,p,l,W},//1
		 {W,l,W,l,W,W,D,W,D,W,W,l,W},//2
		 {W,l,W,l,W,l,l,E,l,l,W,S,W},//3
		 {W,l,W,l,W,e,W,W,W,i,W,c,W},//4
		 {W,i,W,l,W,Q,W,P,l,l,W,c,W},//5
		 {W,d,W,H,W,Q,W,W,W,W,W,l,W},//6
		 {W,i,W,c,W,l,l,l,W,l,d,l,W},//7
		 {W,J,W,c,W,W,W,u,W,D,W,W,W},//8
		 {W,L,W,l,p,l,W,p,W,l,l,l,W},//9
		 {W,J,W,W,W,D,W,l,W,W,W,l,W},//10
		 {W,l,l,e,l,l,W,l,q,w,q,K,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[5][7] = new Portal(9,new Position(4,7));

		m[5][1] = new Bigbat("Bigbat",new Position(4,5),30,65);
		m[7][1] = new Bigbat("Bigbat",new Position(4,5),30,65);
		m[4][9] = new Bigbat("Bigbat",new Position(4,5),30,65);

		m[11][3] = new MaiMage("MaiMage",new Position(4,5),70,120);
		m[4][5] = new MaiMage("MaiMage",new Position(4,5),70,120);

		m[8][7] = new Juniorguard("Juniorguard",new Position(4,5),90,150);

		m[1][10] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);
		m[9][4] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);
		m[9][7] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);

		m[11][10] = new StrangeKing("StrangeKing",new Position(4,5),125,250);
		m[11][9] = new WhiteKnight("WhiteKnight",new Position(4,5),150,300);
		m[11][8] = new StrangeKing("StrangeKing",new Position(4,5),125,250);

		m[6][1] = new Redbat("Redbat",new Position(4,5),90,160);
		m[7][10] = new Redbat("Redbat",new Position(4,5),90,160);

		m[4][11] = new CyanTouguai("CyanTouguai",new Position(4,5),10,35);
		m[5][11] = new CyanTouguai("CyanTouguai",new Position(4,5),10,35);
		m[7][3] = new CyanTouguai("CyanTouguai",new Position(4,5),10,35);
		m[8][3] = new CyanTouguai("CyanTouguai",new Position(4,5),10,35);

		m[1][1] = new PortalReturn(7,new Position(1,2));

		return m;
	}
	public Thing[][] map9()
	{
		currentmap=9;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,l,J,J,W,W,W,l,l,l,W,l,W},//1
		 {W,J,J,C,D,l,l,l,l,l,D,p,W},//2
		 {W,W,D,W,W,l,W,W,W,l,W,J,W},//3
		 {W,l,l,l,W,l,W,l,l,l,W,J,W},//4
		 {W,l,l,l,B,l,W,R,W,l,W,Q,W},//5
		 {W,W,E,W,W,l,W,W,W,l,W,W,W},//6
		 {W,H,O,S,W,e,W,P,W,l,W,Q,W},//7
		 {W,W,D,W,W,l,l,l,D,l,W,J,W},//8
		 {W,p,Q,p,W,W,E,W,W,l,W,J,W},//9
		 {W,L,p,Q,W,f,e,f,W,l,D,p,W},//10
		 {W,H,L,p,D,t,f,t,W,l,W,l,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[7][7] = new Portal(10,new Position(7,5));

		m[7][5] = new MaiMage("MaiMage",new Position(4,5),70,120);
		m[10][6] = new MaiMage("MaiMage",new Position(4,5),70,120);

		m[10][5] = new StoneFrankenstein("StoneFrankenstein",new Position(4,5),65,115);
		m[10][7] = new StoneFrankenstein("StoneFrankenstein",new Position(4,5),65,115);
		m[11][6] = new StoneFrankenstein("StoneFrankenstein",new Position(4,5),65,115);

		m[9][1] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);
		m[9][3] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);
		m[10][2] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);
		m[11][3] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);
		m[2][11] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);
		m[10][11] = new SkeletonCaptain("SkeletonCaptain",new Position(4,5),50,90);

		m[2][3] = new Animalmaskwarrior("Animalmaskwarrior",new Position(4,5),330,450);

		m[7][2] = new RedMage("RedMage",new Position(4,5),260,400);

		m[5][7] = new PortalReturn(8,new Position(5,8));

		return m;
	}
	public Thing[][] map10()
	{
		currentmap=10;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,l,W,W,H,C,W,C,S,W,W,l,W},//1
		 {W,l,l,W,W,D,W,D,W,W,l,O,W},//2
		 {W,l,l,l,l,l,W,l,l,l,O,t,W},//3
		 {W,l,W,l,W,W,W,W,W,l,W,W,W},//4
		 {W,i,W,l,l,J,J,J,l,l,W,J,W},//5
		 {W,d,W,l,W,W,W,W,D,W,W,J,W},//6
		 {W,i,W,l,l,l,R,W,l,D,d,J,W},//7
		 {W,l,W,W,W,W,W,W,D,W,W,J,W},//8
		 {W,l,W,J,l,l,W,l,d,l,W,J,W},//9
		 {W,l,W,K,H,S,B,e,W,e,W,J,W},//10
		 {W,P,W,L,H,S,W,l,W,l,W,Q,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[11][1] = new Portal(11,new Position(11,2));

		m[2][11] = new RedMage("RedMage",new Position(4,5),260,400);
		m[3][10] = new RedMage("RedMage",new Position(4,5),260,400);

		m[10][7] = new MaiMage("MaiMage",new Position(4,5),70,120);
		m[10][9] = new MaiMage("MaiMage",new Position(4,5),70,120);

		m[7][10] = new Redbat("Redbat",new Position(4,5),90,160);
		m[9][8] = new Redbat("Redbat",new Position(4,5),90,160);
		m[6][1] = new Redbat("Redbat",new Position(4,5),90,160);

		m[5][1] = new Bigbat("Bigbat",new Position(4,5),30,65);
		m[7][1] = new Bigbat("Bigbat",new Position(4,5),30,65);

		m[1][5] = new Animalmaskwarrior("Animalmaskwarrior",new Position(4,5),330,450);
		m[1][7] = new Animalmaskwarrior("Animalmaskwarrior",new Position(4,5),330,450);

		m[7][6] = new PortalReturn(9,new Position(8,7));

		return m;
	}
	public Thing[][] map11()
	{
		currentmap=11;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,J,W,l,W,l,W,l,W,t,J,t,W},//1
		 {W,t,W,J,W,L,W,K,W,M,N,M,W},//2
		 {W,Q,W,J,W,L,W,K,W,l,M,l,W},//3
		 {W,D,W,D,W,D,W,D,W,W,E,W,W},//4
		 {W,l,l,l,l,l,W,l,l,l,l,l,W},//5
		 {W,D,W,W,E,W,W,W,E,W,W,D,W},//6
		 {W,H,W,l,M,t,Z,t,M,l,W,S,W},//7
		 {W,H,W,C,W,W,W,W,W,C,W,S,W},//8
		 {W,J,W,C,W,l,l,l,W,C,W,J,W},//9
		 {W,W,W,B,W,Q,K,Q,W,B,W,W,W},//10
		 {W,R,l,l,l,l,l,l,l,l,l,P,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[11][11] = new Portal(12,new Position(11,10));

		m[9][3] = new Animalmaskwarrior("Animalmaskwarrior",new Position(4,5),330,450);
		m[9][9] = new Animalmaskwarrior("Animalmaskwarrior",new Position(4,5),330,450);
		m[8][3] = new Animalmaskwarrior("Animalmaskwarrior",new Position(4,5),330,450);
		m[8][9] = new Animalmaskwarrior("Animalmaskwarrior",new Position(4,5),330,450);

		m[2][10] = new Seniorguard("Seniorguard",new Position(4,5),460,560);

		m[7][6] = new Doubleswordsman("Doubleswordsman",new Position(4,5),520,620);

		m[7][4] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[7][8] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[3][10] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[2][9] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[2][11] = new Plutoguard("Plutoguard",new Position(4,5),400,500);


		m[11][1] = new PortalReturn(10,new Position(10,1));

		return m;
	}
	public Thing[][] map12()
	{
		currentmap=12;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,l,H,W,l,G,V,G,l,W,t,l,W},//1
		 {W,S,l,W,l,W,D,W,l,W,h,t,W},//2
		 {W,l,J,W,l,W,V,W,l,W,J,h,W},//3
		 {W,J,Z,W,l,W,J,W,l,W,l,J,W},//4
		 {W,Z,I,W,l,F,J,W,l,W,U,l,W},//5
		 {W,W,E,W,l,W,Q,W,l,W,E,W,W},//6
		 {W,l,l,l,l,W,Q,W,l,l,l,l,W},//7
		 {W,W,W,W,l,W,W,W,l,W,W,W,W},//8
		 {W,H,Z,D,M,M,N,M,M,D,Z,S,W},//9
		 {W,W,W,W,W,W,E,W,W,W,W,W,W},//10
		 {W,P,l,l,l,l,l,l,l,l,l,R,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[11][1] = new Portal(13,new Position(11,2));

		m[1][5] = new GoldGuard("GoldGuard",new Position(4,5),200,350);
		m[1][7] = new GoldGuard("GoldGuard",new Position(4,5),200,350);

		m[1][6] = new Goldcaptain("Goldcaptain",new Position(4,5),650,750);
		m[3][6] = new Goldcaptain("Goldcaptain",new Position(4,5),650,750);


		m[5][10] = new Spiritmage("Spiritmage",new Position(4,5),730,830);

		//5,11 and 5,10 are spiritwarrior

		m[9][6] = new Seniorguard("Seniorguard",new Position(4,5),460,560);

		m[9][4] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[9][5] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[9][7] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[9][8] = new Plutoguard("Plutoguard",new Position(4,5),400,500);

		m[5][2] = new Plutowarrior("Plutowarrior",new Position(4,5),590,680);

		m[5][1] = new Doubleswordsman("Doubleswordsman",new Position(4,5),520,620);
		m[4][2] = new Doubleswordsman("Doubleswordsman",new Position(4,5),520,620);
		m[9][2] = new Doubleswordsman("Doubleswordsman",new Position(4,5),520,620);
		m[9][10] = new Doubleswordsman("Doubleswordsman",new Position(4,5),520,620);

		m[11][11] = new PortalReturn(11,new Position(11,10));

		return m;
	}
	public Thing[][] map13()
	{
		currentmap=13;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,l,l,l,l,l,l,l,W,l,I,l,W},//1
		 {W,l,W,W,W,W,W,D,W,l,W,l,W},//2
		 {W,l,W,l,l,M,l,l,W,l,W,l,W},//3
		 {W,t,W,B,W,W,W,l,W,l,W,l,W},//4
		 {W,G,W,l,l,I,W,M,W,S,W,l,W},//5
		 {W,V,W,l,l,F,W,N,W,S,W,l,W},//6
		 {W,G,W,I,F,l,W,M,W,S,W,H,W},//7
		 {W,l,W,W,W,W,W,l,W,l,W,H,W},//8
		 {W,l,G,l,W,l,l,l,I,l,W,H,W},//9
		 {W,W,W,l,W,t,W,W,W,W,W,l,W},//10
		 {W,R,l,l,E,l,P,W,T,l,D,l,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[11][6] = new Portal(14,new Position(10,6));

		m[6][1] = new Goldcaptain("Goldcaptain",new Position(4,5),650,750);

		//6,4 and 11,9 are plutocaptain

		m[3][5] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[5][7] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[7][7] = new Plutoguard("Plutoguard",new Position(4,5),400,500);

		m[7][3] = new Plutowarrior("Plutowarrior",new Position(4,5),590,680);
		m[5][5] = new Plutowarrior("Plutowarrior",new Position(4,5),590,680);
		m[9][8] = new Plutowarrior("Plutowarrior",new Position(4,5),590,680);
		m[1][10] = new Plutowarrior("Plutowarrior",new Position(4,5),590,680);

		m[6][7] = new Seniorguard("Seniorguard",new Position(4,5),460,560);

		m[5][1] = new GoldGuard("GoldGuard",new Position(4,5),200,350);
		m[7][1] = new GoldGuard("GoldGuard",new Position(4,5),200,350);
		m[9][2] = new GoldGuard("GoldGuard",new Position(4,5),200,350);

		m[11][1] = new PortalReturn(12,new Position(11,2));

		return m;
	}
	public Thing[][] map14()
	{
		currentmap=14;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,W,l,l,x,P,l,l,l,l,l,W,W},//1
		 {W,W,l,t,W,W,W,W,W,t,l,W,W},//2
		 {W,W,l,W,W,W,W,W,W,W,l,W,W},//3
		 {W,W,l,W,W,W,W,W,W,W,l,W,W},//4
		 {W,W,l,W,W,W,l,W,W,W,l,W,W},//5
		 {W,W,l,Q,W,W,I,W,W,W,l,W,W},//6
		 {W,W,l,W,W,W,l,W,W,W,l,W,W},//7
		 {W,W,l,W,W,W,I,W,W,W,l,W,W},//8
		 {W,W,l,W,W,W,E,W,W,W,l,W,W},//9
		 {W,W,M,N,M,E,l,E,M,N,M,W,W},//10
		 {W,W,W,W,W,W,R,W,W,W,W,W,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[1][5] = new Portal(15,new Position(1,4));

		m[8][6] = new Plutowarrior("Plutowarrior",new Position(4,5),590,680);
		m[6][6] = new Plutowarrior("Plutowarrior",new Position(4,5),590,680);

		m[10][3] = new Seniorguard("Seniorguard",new Position(4,5),460,560);
		m[10][9] = new Seniorguard("Seniorguard",new Position(4,5),460,560);

		m[10][2] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[10][4] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[10][8] = new Plutoguard("Plutoguard",new Position(4,5),400,500);
		m[10][10] = new Plutoguard("Plutoguard",new Position(4,5),400,500);

		//1,3 is spiritwarrior
		//7,6 is plutocaptain

		m[11][6] = new PortalReturn(13,new Position(11,5));

		return m;
	}
	public Thing[][] map15()
	{
		currentmap=15;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,l,l,l,l,R,W,P,l,l,l,l,W},//1
		 {W,l,W,W,W,W,W,W,W,W,W,l,W},//2
		 {W,l,W,W,W,W,W,W,W,W,W,l,W},//3
		 {W,l,W,W,W,l,W,l,W,W,W,l,W},//4
		 {W,l,W,W,W,H,W,H,W,W,W,l,W},//5
		 {W,l,W,W,W,S,W,S,W,W,W,l,W},//6
		 {W,l,W,W,W,l,W,l,W,W,W,l,W},//7
		 {W,l,W,W,W,D,W,D,W,W,W,l,W},//8
		 {W,l,W,W,W,l,l,l,W,W,W,l,W},//9
		 {W,l,W,W,W,W,B,W,W,W,W,l,W},//10
		 {W,l,l,l,l,l,l,l,l,l,l,l,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[1][7] = new Portal(16,new Position(9,6));

		m[1][5] = new PortalReturn(14,new Position(1,6));

		return m;
	}
	public Thing[][] map16()
	{
		currentmap=16;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,W,l,l,l,l,l,l,l,l,l,l,W},//1
		 {W,W,l,W,W,W,W,W,W,W,W,l,W},//2
		 {W,W,l,W,l,l,l,l,l,l,l,l,W},//3
		 {W,W,l,W,l,W,W,W,W,W,W,W,W},//4
		 {W,W,l,W,l,W,l,l,l,l,l,W,W},//5
		 {W,W,l,W,l,l,l,W,W,W,l,W,W},//6
		 {W,W,l,W,W,W,W,W,l,l,l,W,W},//7
		 {W,W,l,W,W,W,R,W,l,W,W,W,W},//8
		 {W,W,l,l,l,l,l,W,l,l,l,l,W},//9
		 {W,W,W,W,W,W,W,W,W,W,W,l,W},//10
		 {W,P,l,l,l,l,l,l,l,l,l,l,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[11][1] = new Portal(17,new Position(11,10));

		//9,5 shadowwarrior

		m[8][6] = new PortalReturn(15,new Position(1,8));

		return m;
	}
	public Thing[][] map17()
	{
		currentmap=17;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,l,l,l,l,l,l,l,l,l,l,l,W},//1
		 {W,l,W,l,W,W,W,W,W,l,W,l,W},//2
		 {W,l,W,l,W,W,W,W,W,l,W,l,W},//3
		 {W,l,W,l,W,W,P,W,W,l,W,l,W},//4
		 {W,l,W,l,W,W,l,W,W,l,W,l,W},//5
		 {W,l,W,l,W,W,l,W,W,l,W,l,W},//6
		 {W,l,W,l,W,W,l,W,W,l,W,l,W},//7
		 {W,l,W,l,W,W,l,W,W,l,W,l,W},//8
		 {W,l,W,W,W,W,l,L,W,W,W,l,W},//9
		 {W,l,W,W,W,W,l,W,W,W,W,l,W},//10
		 {W,l,l,l,l,l,l,l,l,l,l,R,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[4][6] = new Portal(18,new Position(5,6));

		m[11][11] = new PortalReturn(16,new Position(11,2));

		return m;
	}
	public Thing[][] map18()
	{
		currentmap=18;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,L,S,l,Q,l,K,l,Q,l,S,l,W},//1
		 {W,t,W,J,W,L,W,L,W,J,W,t,W},//2
		 {W,W,H,l,l,l,l,l,l,l,H,W,W},//3
		 {W,Q,W,J,W,l,R,l,W,J,W,Q,W},//4
		 {W,l,L,l,l,l,l,l,l,l,L,l,W},//5
		 {W,K,W,l,W,l,W,l,W,l,W,K,W},//6
		 {W,l,L,l,l,l,l,l,l,l,L,l,W},//7
		 {W,Q,W,J,W,l,P,l,W,J,W,Q,W},//8
		 {W,W,H,l,L,l,l,l,l,l,H,W,W},//9
		 {W,t,W,J,W,L,W,L,W,J,W,t,W},//10
		 {W,L,S,l,Q,l,K,l,Q,l,S,l,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12

	//sword-S armor-A shield-H

		m[8][6] = new Portal(19,new Position(11,6));

		m[4][6] = new PortalReturn(17,new Position(5,6));

		return m;
	}
	public Thing[][] map19()
	{
		currentmap=19;
		setWallText();
		Thing[][] m = new Thing[][]
		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//1
		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//2
		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//3
		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//4
		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//5
		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//6
		 {W,l,l,l,l,W,Y,W,l,l,l,l,W},//7
		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//8
		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//9
		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//10
		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//11
		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12
		 
		 m[6][6] = new Boss("Boss",new Position(4,5),2000,1500);

	//sword-S armor-A shield-H

//		m[1][6] = new Portal(20,new Position(1,6));

		return m;
	}
//	public Thing[][] map20()
//	{
//		currentmap=19;
//		setWallText();
//		Thing[][] m = new Thing[][]
//		//0 1 2 3 4 5 6 7 8 9 0 1 2 3
//		{{W,W,W,W,W,W,W,W,W,W,W,W,W},//0
//		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//1
//		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//2
//		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//3
//		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//4
//		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//5
//		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//6
//		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//7
//		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//8
//		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//9
//		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//10
//		 {W,l,l,l,l,W,l,W,l,l,l,l,W},//11
//		 {W,W,W,W,W,W,W,W,W,W,W,W,W}};//12
//
//	//sword-S armor-A shield-H
//
//		m[1][6] = new Portal(21,new Position(2,1));
//
//		return m;
//	}
	/*public Thing[][] random()
	{
		setWallText();
		Thing[][] m = new Thing[18][33];

		for(int r = 0; r < m.length; r++)
		{
			for(int c = 0; c < m[r].length; c++)
			{
				double ra = Math.random();
				if(ra < 0.1)
					m[r][c] = l;
				else if(ra < 0.33)
					m[r][c] = W;
				else if(ra < 0.38)
					m[r][c] = l;
				else if(ra < 0.42)
					m[r][c] = l;
				else if(ra < 0.46)
					m[r][c] = w;
				else if(ra < 0.48)
					m[r][c] = l;
				else if(ra < 0.5)
					m[r][c] = l;
				else if(ra < 0.54)
					m[r][c] = H;
				else if(ra < 0.56)
					m[r][c] = h;
				else if(ra < 0.64)
					m[r][c] = F;
				else if(ra < 0.66)
					m[r][c] = J;
				else if(ra < 0.67)
					m[r][c] = K;
				else if(ra < 0.68)
					m[r][c] = L;
				else if(ra < 0.70)
					m[r][c] = D;
				else if(ra < 0.72)
					m[r][c] = s;
				else if(ra < 0.74)
					m[r][c] = l;
				else if(ra < 0.8)
					m[r][c] = h;
				else if(ra < 0.87)
					m[r][c] = A;
				else if(ra < 0.9)
					m[r][c] = T;
				else if(ra < 0.9993)
					m[r][c] = Q;
				else if(ra < 1.0)
					m[r][c] = Y;
			}
		}
		//wall border
		for(int c = 0; c<m[0].length; c++)
		{
			m[0][c] = W;
			m[m.length-1][c] = W;
		}
		for(int r = 0; r < m.length; r++)
		{
			m[r][0] = W;
			m[r][m[r].length-1] = W;
		}
		//portals
		m[2][6] = new Portal(-1,new Position(7,7));
		m[2][7] = l;
		m[8][2] = new Portal(-1,new Position(7,7));
		m[8][3] = l;
		m[13][1] = new Portal(-1,new Position(7,7));
		m[13][2] = l;

		return m;
	}*/
	public Thing[][] doors()
	{
		Thing[][] m = new Thing[18][31];
		for(int r = 0; r < m.length; r++)
		{
			for(int c = 0; c < m[r].length; c++)
			{
				m[r][c] = D;
			}
		}
		for(int c = 0; c<m[0].length; c++)
		{
			m[0][c] = W;
			m[m.length-1][c] = W;
		}
		for(int r = 0; r < m.length; r++)
		{
			m[r][0] = W;
			m[r][m[r].length-1] = W;
		}
		return m;
	}
	public String toString(Thing[][] grid)
	{
		String output = "";
		for(int r = 0; r < grid.length; r++)
		{
	    	for(int c = 0; c < grid[r].length; c++)
	    	{
	    		output+=grid[r][c]+" ";
	    	}
	    	output+="\n";
		}
		return output;
	}
	public String toString()
	{
		String output = "";
		for(int r = 0; r < wallText.length; r++)
		{
			for(int c = 0; c < wallText[r].length; c++)
			{
				output+=wallText[r][c].toString() +"    ";
			}
			output+="\n";
		}
		return output;
	}
	public void setWallText()
	{
		wallText = new Color[9][9];
		for(int r=0;r<9;r++)
    	{
    		for(int c=0;c<9;c++)
    		{
    			int num = (int)(Math.random()*30);
    			wallText[r][c]=new Color(100+num,100+num,100+num);
    		}
    	}
	}
}