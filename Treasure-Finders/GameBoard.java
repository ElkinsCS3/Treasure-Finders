import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class GameBoard extends Canvas implements KeyListener, MouseListener, Runnable
{
	public Grid board;
	private final static int SCALE = 46;
	private final static int INV_SCALE = 30;
	private final static Color BACKGROUND_COLOR = new Color(214,214,214);
	private int width, height, invX, invY, invWidth, invHeight;
	private int mouseX, mouseY;
	private int currentMap;
	private Player player;

	private GreenTouguai greentouguai;
	private RedTouguai redtouguai;
	private Smallbat smallbat;
	private SkeletonMan skeletonman;
	private CyanTouguai cyantouguai;
	private SkeletonSoldier skeletonsoldier;
	private JuniorMage juniormage;
	private Bigbat bigbat;
	private Animalmaskman animalmaskman;
	private SkeletonCaptain skeletoncaptain;
	private StoneFrankenstein stonefrankenstein;
	private MaiMage maimage;
	private Juniorguard juniorguard;
	private Redbat redbat;
	private SeniorMage seniormage;
	private StrangeKing strangeking;
	private WhiteKnight whiteknight;
	private GoldGuard goldguard;
	private RedMage redmage;
	private Animalmaskwarrior animalmaskwarrior;
	private Plutoguard plutoguard;
	private Seniorguard seniorguard;
	private Doubleswordsman doubleswordsman;
	private Plutowarrior plutowarrior;
	private Goldcaptain goldcaptain;
	private Spiritmage spiritmage;

	private Boss boss;

	private Color[][] wallText;
	private String path;
	private Maps maps;
	private Position playerPos;
	private Position startPos;
	private ArrayList<Thing[][]> mapList;
	private ArrayList<String> messages;
	private int howManyTimePaintHasBeenCalled;
	private Graphics graphics;
	private Monster monster;
	private boolean shift;
	private boolean godmode;

	private boolean dead;
	private int numDeath;
	private boolean bossDefeated;

	private int screen;
	private int test;

	private int testing = 1;
	public GameBoard()
	{


		dead=false;
		numDeath=0;
		screen = 1;
		bossDefeated = false;

		System.out.println("GameBoard() has been called");
		howManyTimePaintHasBeenCalled = 0;

		board = new Grid();

		this.addMouseListener(this);
		this.addKeyListener(this);

		new Thread(this).start();
		setVisible(true);
		setBackground(Color.BLACK);

		//graphics = this.getGraphics();

		messages = new ArrayList<String>();
		messages.add("Welcome to Treasure Finders!");
		messages.add("Use the arrow keys or click anywhere on the map.");
		messages.add("Hold shift and click on a monster to see its stats.");
		messages.add("Click on an item from your inventory to use it.");
		messages.add("The goal is to find the final boss monster and kill it!.");
		wallText = new Color[9][9];
		for(int r=0;r<9;r++)
    	{
    		for(int c=0;c<9;c++)
    		{
    			int num = (int)(Math.random()*30);
    			wallText[r][c]=new Color(100+num,100+num,100+num);
    		}
    	}
		path="";
		maps = new Maps(wallText);
		mapList = new ArrayList<Thing[][]>();
		mapList.add(maps.map1()); //0
		mapList.add(maps.map2()); //1
		mapList.add(maps.map3()); //2
		mapList.add(maps.map4()); //3
		mapList.add(maps.map5()); //4
		mapList.add(maps.map6()); //5
		mapList.add(maps.map7()); //6
		mapList.add(maps.map8()); //7
		mapList.add(maps.map9()); //8
		mapList.add(maps.map10()); //9
		mapList.add(maps.map11()); //10
		mapList.add(maps.map12()); //11
		mapList.add(maps.map13()); //12
		mapList.add(maps.map14()); //13
		mapList.add(maps.map15()); //14
		mapList.add(maps.map16()); //15
		mapList.add(maps.map17()); //16
		mapList.add(maps.map18()); //17
		mapList.add(maps.map19()); //18
		//mapList.add(maps.map20()); //19

		/*mapList.add(maps.finalMap()); //20
		mapList.add(maps.random()); //21*/


		board.grid = mapList.get(0); currentMap = 1;
		//board.grid = mapList.get(10); currentMap = -1;
		height = board.getHeight()*SCALE;
		width = board.getWidth()*SCALE;

		startPos = new Position(11,6);
		playerPos = startPos;

		test = (int)(Math.random()*4);

		if(test==1)
		{
			player = new Player("Player",playerPos,15,10); //player name,player position, player attack, player defense
			board.addActor(player,playerPos);
		}
		else if(test==2)
		{
			player = new Player("Player",playerPos,10,15); //player name,player position, player attack, player defense
			board.addActor(player,playerPos);
		}
		else if(test==3)
		{
			player = new Player("Player",playerPos,13,13); //player name,player position, player attack, player defense
			board.addActor(player,playerPos);
		}
		else
		{
			player = new Player("Player",playerPos,15,15); //player name,player position, player attack, player defense
			board.addActor(player,playerPos);
		}
		invWidth = player.getInventory().getNumRows()*INV_SCALE;
		invHeight = player.getInventory().getNumCols()*INV_SCALE;
		invX = height+25;
		invY = width - invWidth - 20;

		System.setProperty("sun.java2d.opengl","True");

		/*player.getInventory().add(new Potato(), 5);*/
	}

	public void mouseReleased(MouseEvent e)
   	{
		System.out.println("mouseReleased(MouseEvent e) has been called");
		System.out.println("\n--------------------------");
   		mouseX = e.getX();
   		mouseY = e.getY();
   		if(screen == 2) //game screen
   		{
	   		if(mouseX>height||mouseY>width) //clicked outside of board
	   		{
	   			if(mouseX>=invX && mouseX<=invX+invHeight && mouseY>=invY && mouseY <= invY+invWidth) //clicked inside of inventory
	   			{
	   				int row = (mouseY-invY)/INV_SCALE;
	   				int col = (mouseX-invX)/INV_SCALE;
	   				Item item = player.getInventory().get(row, col);
	   				if(item == null) return;

	   				if(e.getButton() == MouseEvent.BUTTON2)
	   					if(player.getInventory().remove(row, col))
	   					{
	   						messages.add(item.getType()+" was deleted.");
	   						repaint();
	   						return;
	   					}

	   				if(item.getType().equals("Potato"))
	   				{
	   					messages.add(player.heal2());
	   					if(!(messages.get(messages.size()-1).equals("already max health")))
	   						player.getInventory().remove(row,col);
	   					repaint();
	   				}
	   				if(item.getType().equals("BossSword"))
	   				{
	   					player.damage+=10;
						messages.add(player.getName()+" gained "+10+" damage.");
						player.getInventory().remove(row,col);
						repaint();
	   				}
	   				else if(item.getType().equals("Sword"))
	   				{
						player.damage+=3;
						messages.add(player.getName()+" gained "+3+" damage.");
						player.getInventory().remove(row,col);
						repaint();
	   				}
	   				else if(item.getType().equals("Armor"))
	   				{
	   					player.maxHealth+=500;
	   					player.currentHealth+=500;
	   					player.defense+=5;
	   					messages.add(player.getName()+" gained "+5+" defense.");
	   					messages.add(player.getName()+" gained "+500+" Health.");
						player.getInventory().remove(row,col);
						repaint();
	   				}
	   				else if(item.getType().equals("Shield"))
	   				{
						player.defense+=3;
						messages.add(player.getName()+" gained "+3+" defense.");
						player.getInventory().remove(row,col);
						repaint();
	   				}
	   				else if(item.getType().equals("DiamondShield"))
	   				{
						player.defense+=10;
						messages.add(player.getName()+" gained "+10+" defense.");
						player.getInventory().remove(row,col);
						repaint();
	   				}
	   				else if(item.getType().equals("teleport"))
	   				{
	   					player.enableteleport=true;
	   					messages.add(player.getName()+" picked up teleport.");
	   					player.getInventory().remove(row,col);
						repaint();
	   				}
	   			}
	   		}
	   		else if(mouseX<height && mouseY<width) //clicked on board
	   		{
		   		int row = mouseY/SCALE;
		   		int col = mouseX/SCALE;

		   		if(board.get(row,col) instanceof Monster && shift)
		   		{
		   			//display monster stats on side panel
		   			graphics = this.getGraphics();

					Monster mon = (Monster) board.get(row, col);
					monster = mon;
					graphics.setColor(Color.GRAY);
					graphics.fillRect(invX + 270, invY - 130, 90, 120);
					mon.draw(graphics, mon instanceof Boss? 40 : 80, invX + 275, invY - 125);
					graphics.setColor(Color.BLACK);
					graphics.setFont(new Font("TAHOMA",Font.BOLD,12));
		   			graphics.drawString("H: "+mon.getHealth() + "/" + mon.getMaxHealth(), invX + 273, invY - 130 + 90);
		   			graphics.drawString("Damage: "+mon.getDamage(), invX + 273, invY - 130 + 90+14);
		   			graphics.drawString("Defense: "+mon.getDefense(), invX + 273, invY - 130 + 90+14+14);
					graphics.drawRect(invX + 270, invY - 130, 90, 120);
					return;
		   		}
		   		else if(board.get(row,col) instanceof Actor)
		   		{
		   			graphics = this.getGraphics();

					Actor mon = (Actor) board.get(row, col);
					graphics.setColor(Color.GRAY);
					graphics.fillRect(invX + 270, invY - 130, 90, 120);
					mon.draw(graphics, 80, invX + 275, invY - 125);
					graphics.setColor(Color.BLACK);
					graphics.setFont(new Font("TAHOMA",Font.BOLD,12));
		   			graphics.drawString("H: "+mon.getHealth() + "/" + mon.getMaxHealth(), invX + 273, invY - 130 + 90);
		   			graphics.drawString("Damage: "+mon.getDamage(), invX + 273, invY - 130 + 90+14);
		   			graphics.drawString("Defense: "+mon.getDefense(), invX + 273, invY - 130 + 90+14+14);
					graphics.drawRect(invX + 270, invY - 130, 90, 120);
					return;
		   		}
		   	 	path=Pathfinder.findPath(board.getCharCopy(), playerPos.getRow(), playerPos.getCol(), row, col);
	   		}
   		}
   		else if(screen == 1) //starting screen
   		{
   			if(mouseY < 520 && mouseY > 420)
	   			if(mouseX > 197 && mouseX < 297)
	   			{
	   				player.setType("Male");
	   				screen = 2;
	   				repaint();
	   			}
	   			else if(mouseX > 297 && mouseX < 397)
	   			{
	   				player.setType("Female");
	   				screen = 2;
	   				repaint();
	   			}
	   			else if(mouseX > 397 && mouseX < 497)
	   			{
	   				player.setType("Giraffe");
	   				screen = 2;
	   				repaint();
	   			}
   		}
   	}

	public void keyReleased(KeyEvent e) {shift=false;}
	public void keyPressed(KeyEvent e)
	{
		System.out.println("keyPressed(KeyEvent e) has been called");
		System.out.println("--------------------------");

		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			moveDirection(0,-1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_D)
		{
			moveDirection(0,+1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_W)
		{
			moveDirection(-1,0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_S)
		{
			moveDirection(+1,0);
		}
		else if(e.getKeyCode()==KeyEvent.VK_H)
		{
			messages.add(player.heal2());
		}
		//shops
		else if(e.getKeyCode()==KeyEvent.VK_1)
		{
			messages.add(player.goldhealth());
		}
		else if(e.getKeyCode()==KeyEvent.VK_2)
		{
			messages.add(player.goldattack());
		}
		else if(e.getKeyCode()==KeyEvent.VK_3)
		{
			messages.add(player.golddefense());
		}
		else if(e.getKeyCode()==KeyEvent.VK_4)
		{
			messages.add(player.exphealth());
		}
		else if(e.getKeyCode()==KeyEvent.VK_5)
		{
			messages.add(player.expattack());
		}
		else if(e.getKeyCode()==KeyEvent.VK_6)
		{
			messages.add(player.expdefense());
		}
		else if(e.getKeyCode()==KeyEvent.VK_7)
		{
			messages.add(player.explevelup());
		}
		else if(e.getKeyCode()==KeyEvent.VK_J)
		{
			if(player.checkdamage==true&&player.checkdefense==true)
			{
				messages.add(player.powerupattack());
			}
			else if(player.checkdamage==true&&player.checkdefense==false)
			{
				messages.add(player.depowerupdefense());
				messages.add(player.powerupattack());
			}
			else
			{
				messages.add("damage is already 1.5x");
			}
		}
		else if (e.getKeyCode()==KeyEvent.VK_K)
		{
			if(player.checkdamage==true&&player.checkdefense==true)
			{
				messages.add(player.powerupdefense());
			}
			else if(player.checkdefense==true&&player.checkdamage==false)
			{
				messages.add(player.depowerupattack());
				messages.add(player.powerupdefense());
			}
			else
			{
				messages.add("defense is already 1.5x");
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_G)
		{
			if(!godmode)
			{
				messages.add(player.activateGodMode());
				godmode = true;
			}
			else
			{
				messages.add(player.deactivateGodMode());
				godmode = false;
			}

		}
		else if(player.enableteleport==true)
		{
			if(e.getKeyCode()==KeyEvent.VK_O)
			{
				messages.add(player.moveupalevel());
			}
			else if(e.getKeyCode()==KeyEvent.VK_P)
			{
				messages.add(player.movedownalevel());
			}
		}
		//CHEATS
		/*
		else if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			player.setHealth(player.getHealth()-100 < 0 ? 0 : player.getHealth()-100);
		}
		else if(e.getKeyCode()==KeyEvent.VK_1)
		{
			player.pickupBrownKey();
		}

		else if(e.getKeyCode()==KeyEvent.VK_2)
		{
			player.pickupRedKey();
		}
		else if(e.getKeyCode()==KeyEvent.VK_3)
		{
			player.pickupBlueKey();
		}
		else if(e.getKeyCode()==KeyEvent.VK_Q)
		{
			player.pickupPotato();
		}
		else if(e.getKeyCode()==KeyEvent.VK_W)
		{
			player.getInventory().add(new Armor(), 1);
		}
		else if(e.getKeyCode()==KeyEvent.VK_E)
		{
			player.getInventory().add(new Shield(), 1);
		}
		else if(e.getKeyCode()==KeyEvent.VK_R)
		{
			player.getInventory().add(new Sword(), 1);
		}
		else if(e.getKeyCode()==KeyEvent.VK_5)
		{
			messages.add(player.heal(1000));
		}
		else if(e.getKeyCode()==KeyEvent.VK_PERIOD)
		{
			board.removeActor(playerPos.getRow(),playerPos.getCol());
			enterPortal(21,new Position(1,2));
			currentMap = 21;
		}
		else if(e.getKeyCode()==KeyEvent.VK_SCROLL_LOCK)
		{
			player.damage=9999;
			messages.add(player.getName()+" used 9999 damage hack.");
		}
		*/
		/*else if(e.getKeyCode()==KeyEvent.VK_G)
		{
			if(!godmode)
			{
				messages.add(player.activateGodMode());
				godmode = true;
			}
			else
			{
				messages.add(player.deactivateGodMode());
				godmode = false;
			}

		}

		else if(e.getKeyCode()==KeyEvent.VK_Z)
		{
			board.removeActor(playerPos.getRow(),playerPos.getCol());
			enterPortal(1,startPos);
		}

		else if(e.getKeyCode()==KeyEvent.VK_Z && bossDefeated)
		{
			board.removeActor(playerPos.getRow(),playerPos.getCol());
			enterPortal(1,startPos);
			currentMap = 1;
		}
		else if(e.getKeyCode()==KeyEvent.VK_R && bossDefeated)
		{
			board.removeActor(playerPos.getRow(),playerPos.getCol());
			enterPortal(-1,new Position(2,2));
			currentMap = -1;
		}
		else if(e.getKeyCode()==KeyEvent.VK_C && bossDefeated)
		{
			messages.add("Game created by: David, Weizhao, and Ryan.");
		}
		else if(e.getKeyCode()==KeyEvent.VK_SHIFT)
		{
			shift = true;
		}
		else if(e.getKeyCode()==KeyEvent.VK_PERIOD)
		{
			board.removeActor(playerPos.getRow(),playerPos.getCol());
			enterPortal(21,new Position(1,2));
			currentMap = 21;
		}*/

		repaint();
	}

	public Boss findBoss()
	{
		for(int r = 0; r < board.getWidth(); r++)
		{
			for(int c = 0; c < board.getHeight(); c++)
			{
				if(board.get(r,c) instanceof Boss)
				{
				System.out.println(currentMap);

					return (Boss) board.get(r,c);
				}
			}
		}
		return null;
	}
	public Position findBossPosition()
	{
		for(int r = 0; r < board.getWidth(); r++)
		{
			for(int c = 0; c < board.getHeight(); c++)
			{
				if(board.get(r,c) instanceof Boss)
					return new Position(r,c);
			}
		}
		return null;
	}

	public void moveDirection(int v, int h)
	{
		if(!dead)
		{
			     if(v == -1 && h == 0)	player.setDirection('U');
			else if(v == +1 && h == 0)	player.setDirection('D');
			else if(v == 0  && h == -1)	player.setDirection('L');
			else if(v == 0  && h == +1)	player.setDirection('R');
			else System.out.println("moveDirection() called incorrectly.");

			int currRow = playerPos.getRow();
			int currCol = playerPos.getCol();

			int newRow =  currRow + v;
			int newCol =  currCol+ h;

			try
			{
				if(board.get(currRow+1,currCol-1) instanceof Boss && v == +1
				|| board.get(currRow,currCol-2) instanceof Boss && h == -1
				|| board.get(currRow-1,currCol-2) instanceof Boss && h == -1
				|| board.get(currRow-2,currCol-1) instanceof Boss && v == -1
				|| board.get(currRow-2,currCol) instanceof Boss && v == -1
				|| board.get(currRow-1,currCol+1) instanceof Boss && h == +1)
				{
					boss = (Boss) findBoss();
					if(boss == null) return;

					if(boss.currentHealth>0)
					{
						messages.add(player.normalattack(boss));
					}
					if(boss.currentHealth<=0)
					{
						bossDefeated = true;
						messages.add("Congratulations! You defeated the final boss!");
						messages.add("Press \"z\" if you want to leave the boss room.");
						messages.add("Otherwise, press \"r\" to enter the abyss.");
						Position pos = findBossPosition();
						board.removeActor(pos.getRow(),pos.getCol());
						messages.add(player.getexperience(48));
						messages.add(player.getgold(100));
						if(board.get(newRow, newCol)==null)
						{
							board.set( board.get(currRow, currCol), newRow, newCol );
							player = (Player)(board.get(currRow, currCol));
							board.removeActor(currRow, currCol);
							player.setPos(new Position(newRow, newCol));
							playerPos = new Position(newRow, newCol);
						}
					}
					path = "";

					return;
				}
			}
			catch(ArrayIndexOutOfBoundsException error) {System.out.println("out of bounds"); }


			Thing thing = board.get(newRow, newCol);
			if(thing instanceof Wall)
				return;

			if(thing != null && thing instanceof Monster)
	   		{
	   			//display monster stats on side panel
	   			graphics = this.getGraphics();

				monster = (Monster) thing;
				graphics.setColor(Color.GRAY);
				graphics.fillRect(invX + 270, invY - 130, 90, 120);
				thing.draw(graphics, monster instanceof Boss? 40 : 80, invX + 275, invY - 125);
				graphics.setColor(Color.BLACK);
				graphics.setFont(new Font("TAHOMA",Font.BOLD,12));
	   			graphics.drawString("H: "+monster.getHealth() + "/" + monster.getMaxHealth(), invX + 273, invY - 130 + 90);
	   			graphics.drawString("Damage: "+monster.getDamage(), invX + 273, invY - 130 + 90+14);
	   			graphics.drawString("Defense: "+monster.getDefense(), invX + 273, invY - 130 + 90+14+14);
				graphics.drawRect(invX + 270, invY - 130, 90, 120);
	   		}

			if(thing != null)
			{
				switch(thing.getType())
				{
					case "Potato":
					{
						board.removeActor(newRow,newCol);
						player.pickupPotato();
						//player.potatoes++;
						messages.add(player.getName()+" picked up a Potato");
					}
					break;
					case "Bigpotato":
					{
						board.removeActor(newRow,newCol);
						player.currentHealth+=400;
    					player.maxHealth+=400;
    					messages.add(player.getName()+" picked up a Bigpotato");
					}
					break;
					case "FakeWall":
					{
						board.removeActor(newRow,newCol);
					}
					break;
					case "GreenTouguai":
					{
						if(path.length()>1){path = ""; return;}
						greentouguai = (GreenTouguai) board.get(newRow, newCol);

						monster = greentouguai;

						if(greentouguai.currentHealth>0)
						{
							messages.add(player.normalattack(greentouguai));
						}
						if(greentouguai.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(1));
							messages.add(player.getgold(1));
						}
					}
					break;
					case "RedTouguai":
					{
						if(path.length()>1){path = ""; return;}
						redtouguai = (RedTouguai) board.get(newRow, newCol);

						monster = redtouguai;

						if(redtouguai.currentHealth>0)
						{
							messages.add(player.normalattack(redtouguai));
						}
						if(redtouguai.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(2));
							messages.add(player.getgold(2));
						}
					}
					break;
					case "Smallbat":
					{
						if(path.length()>1){path = ""; return;}
						smallbat = (Smallbat) board.get(newRow, newCol);

						monster = smallbat;

						if(smallbat.currentHealth>0)
						{
							messages.add(player.normalattack(smallbat));
						}
						if(smallbat.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(3));
							messages.add(player.getgold(3));
						}
					}
					break;
					case "SkeletonMan":
					{
						if(path.length()>1){path = ""; return;}
						skeletonman = (SkeletonMan) board.get(newRow, newCol);

						monster = skeletonman;

						if(skeletonman.currentHealth>0)
						{
							messages.add(player.normalattack(skeletonman));
						}
						if(skeletonman.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(4));
							messages.add(player.getgold(5));
						}
					}
					break;
					case "CyanTouguai":
					{
						if(path.length()>1){path = ""; return;}
						cyantouguai = (CyanTouguai) board.get(newRow, newCol);

						monster = cyantouguai;

						if(cyantouguai.currentHealth>0)
						{
							messages.add(player.normalattack(cyantouguai));
						}
						if(cyantouguai.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(5));
							messages.add(player.getgold(5));
						}
					}
					break;
					case "SkeletonSoldier":
					{
						if(path.length()>1){path = ""; return;}
						skeletonsoldier = (SkeletonSoldier) board.get(newRow, newCol);

						monster = skeletonsoldier;

						if(skeletonsoldier.currentHealth>0)
						{
							messages.add(player.normalattack(skeletonsoldier));
						}
						if(skeletonsoldier.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(6));
							messages.add(player.getgold(8));
						}
					}
					break;
					case "JuniorMage":
					{
						if(path.length()>1){path = ""; return;}
						juniormage = (JuniorMage) board.get(newRow, newCol);

						monster = juniormage;

						if(juniormage.currentHealth>0)
						{
							messages.add(player.TrueAttack(juniormage));
						}
						if(juniormage.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(7));
							messages.add(player.getgold(10));
						}
					}
					break;
					case "Bigbat":
					{
						if(path.length()>1){path = ""; return;}
						bigbat = (Bigbat) board.get(newRow, newCol);

						monster = bigbat;

						if(bigbat.currentHealth>0)
						{
							messages.add(player.normalattack(bigbat));
						}
						if(bigbat.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(8));
							messages.add(player.getgold(10));
						}
					}
					break;
					case "Animalmaskman":
					{
						if(path.length()>1){path = ""; return;}
						animalmaskman = (Animalmaskman) board.get(newRow, newCol);

						monster = animalmaskman;

						if(animalmaskman.currentHealth>0)
						{
							messages.add(player.normalattack(animalmaskman));
						}
						if(animalmaskman.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(10));
							messages.add(player.getgold(13));
						}
					}
					break;
					case "SkeletonCaptain":
					{
						if(path.length()>1){path = ""; return;}
						skeletoncaptain = (SkeletonCaptain) board.get(newRow, newCol);

						monster = skeletoncaptain;

						if(skeletoncaptain.currentHealth>0)
						{
							messages.add(player.normalattack(skeletoncaptain));
						}
						if(skeletoncaptain.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(12));
							messages.add(player.getgold(15));
						}
					}
					break;
					case "StoneFrankenstein":
					{
						if(path.length()>1){path = ""; return;}
						stonefrankenstein = (StoneFrankenstein) board.get(newRow, newCol);

						monster = stonefrankenstein;

						if(stonefrankenstein.currentHealth>0)
						{
							messages.add(player.normalattack(stonefrankenstein));
						}
						if(stonefrankenstein.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(15));
							messages.add(player.getgold(15));
						}
					}
					break;
					case "MaiMage":
					{
						if(path.length()>1){path = ""; return;}
						maimage = (MaiMage) board.get(newRow, newCol);

						monster = maimage;

						if(maimage.currentHealth>0)
						{
							messages.add(player.TrueAttack(maimage));
						}
						if(maimage.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							player.setHealth(player.getHealth()-100);
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(17));
							messages.add(player.getgold(20));
						}
					}
					break;
					case "Juniorguard":
					{
						if(path.length()>1){path = ""; return;}
						juniorguard = (Juniorguard) board.get(newRow, newCol);

						monster = juniorguard;

						if(juniorguard.currentHealth>0)
						{
							messages.add(player.normalattack(juniorguard));
						}
						if(juniorguard.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(19));
							messages.add(player.getgold(22));
						}
					}
					break;
					case "Redbat":
					{
						if(path.length()>1){path = ""; return;}
						redbat = (Redbat) board.get(newRow, newCol);

						monster = redbat;

						if(redbat.currentHealth>0)
						{
							messages.add(player.TripleAttack(redbat));
						}
						if(redbat.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(20));
							messages.add(player.getgold(25));
						}
					}
					break;
					case "SeniorMage":
					{
						if(path.length()>1){path = ""; return;}
						seniormage = (SeniorMage) board.get(newRow, newCol);

						monster = seniormage;

						if(seniormage.currentHealth>0)
						{
							messages.add(player.normalattack(seniormage));
						}
						if(seniormage.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(25));
							messages.add(player.getgold(30));
						}
					}
					break;
					case "StrangeKing":
					{
						if(path.length()>1){path = ""; return;}
						strangeking = (StrangeKing) board.get(newRow, newCol);

						monster = strangeking;

						if(strangeking.currentHealth>0)
						{
							messages.add(player.normalattack(strangeking));
						}
						if(strangeking.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(30));
							messages.add(player.getgold(32));
						}
					}
					break;
					case "WhiteKnight":
					{
						if(path.length()>1){path = ""; return;}
						whiteknight = (WhiteKnight) board.get(newRow, newCol);

						monster = whiteknight;

						if(whiteknight.currentHealth>0)
						{
							messages.add(player.normalattack(whiteknight));
						}
						if(whiteknight.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							player.setHealth(player.getHealth()/4);
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(35));
							messages.add(player.getgold(40));
						}
					}
					break;
					case "GoldGuard":
					{
						if(path.length()>1){path = ""; return;}
						goldguard = (GoldGuard) board.get(newRow, newCol);

						monster = goldguard;

						if(goldguard.currentHealth>0)
						{
							messages.add(player.normalattack(goldguard));
						}
						if(goldguard.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(40));
							messages.add(player.getgold(45));
						}
					}
					break;
					case "RedMage":
					{
						if(path.length()>1){path = ""; return;}
						redmage = (RedMage) board.get(newRow, newCol);

						monster = redmage;

						if(redmage.currentHealth>0)
						{
							messages.add(player.TrueAttack(redmage));
						}
						if(redmage.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							player.setHealth(player.getHealth()-300);
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(45));
							messages.add(player.getgold(47));
						}
					}
					break;
					case "Animalmaskwarrior":
					{
						if(path.length()>1){path = ""; return;}
						animalmaskwarrior = (Animalmaskwarrior) board.get(newRow, newCol);

						monster = animalmaskwarrior;

						if(animalmaskwarrior.currentHealth>0)
						{
							messages.add(player.normalattack(animalmaskwarrior));
						}
						if(animalmaskwarrior.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(50));
							messages.add(player.getgold(50));
						}
					}
					break;
					case "Plutoguard":
					{
						if(path.length()>1){path = ""; return;}
						plutoguard = (Plutoguard) board.get(newRow, newCol);

						monster = plutoguard;

						if(plutoguard.currentHealth>0)
						{
							messages.add(player.normalattack(plutoguard));
						}
						if(plutoguard.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(55));
							messages.add(player.getgold(55));
						}
					}
					break;
					case "Seniorguard":
					{
						if(path.length()>1){path = ""; return;}
						seniorguard = (Seniorguard) board.get(newRow, newCol);

						monster = seniorguard;

						if(seniorguard.currentHealth>0)
						{
							messages.add(player.normalattack(seniorguard));
						}
						if(seniorguard.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(60));
							messages.add(player.getgold(60));
						}
					}
					break;
					case "Doubleswordsman":
					{
						if(path.length()>1){path = ""; return;}
						doubleswordsman = (Doubleswordsman) board.get(newRow, newCol);

						monster = doubleswordsman;

						if(doubleswordsman.currentHealth>0)
						{
							messages.add(player.DoubleAttack(doubleswordsman));
						}
						if(doubleswordsman.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(75));
							messages.add(player.getgold(65));
						}
					}
					break;
					case "Plutowarrior":
					{
						if(path.length()>1){path = ""; return;}
						plutowarrior = (Plutowarrior) board.get(newRow, newCol);

						monster = plutowarrior;

						if(plutowarrior.currentHealth>0)
						{
							messages.add(player.normalattack(plutowarrior));
						}
						if(plutowarrior.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(65));
							messages.add(player.getgold(70));
						}
					}
					break;
					case "Goldcaptain":
					{
						if(path.length()>1){path = ""; return;}
						goldcaptain = (Goldcaptain) board.get(newRow, newCol);

						monster = goldcaptain;

						if(goldcaptain.currentHealth>0)
						{
							messages.add(player.normalattack(goldcaptain));
						}
						if(goldcaptain.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(70));
							messages.add(player.getgold(77));
						}
					}
					break;
					case "Spiritmage":
					{
						if(path.length()>1){path = ""; return;}
						spiritmage = (Spiritmage) board.get(newRow, newCol);

						monster = spiritmage;

						if(spiritmage.currentHealth>0)
						{
							messages.add(player.normalattack(spiritmage));
						}
						if(spiritmage.currentHealth<=0)
						{
							player.experience=player.experience+monster.defense;
							player.setHealth(player.getHealth()/3);
							board.removeActor(newRow, newCol);
//							messages.add(player.getexperience(70));
							messages.add(player.getgold(80));
						}
					}
					break;
					case "Sword":
					{
						board.removeActor(newRow, newCol);
						player.getInventory().add(new Sword(),1);
						 /*player.damage+=3;
						 messages.add(player.getName()+"'s damage +3");*/
					}
					break;
					case "BossSword":
					{
						board.removeActor(newRow, newCol);
//						player.getInventory().add(new BossSword(),1);
						 player.damage+=10;
						 messages.add(player.getName()+"'s damage + 10");
					}
					break;
					case "Armor":
					{
						board.removeActor(newRow, newCol);
						player.getInventory().add(new Armor(),1);
					}
					break;
					case "Shield":
					{
						board.removeActor(newRow, newCol);
						player.getInventory().add(new Shield(),1);
						 /*player.defense+=3;
						 messages.add(player.getName()+"'s defense + 3");*/
					}
					break;
					case "DiamondShield":
					{
						board.removeActor(newRow, newCol);
//						player.getInventory().add(new DiamondShield(),1);
						 player.defense+=10;
						 messages.add(player.getName()+"'s defense + 10");
					}
					break;
					case "BrownKey":
					{
						board.removeActor(newRow, newCol);
						player.pickupBrownKey();
						messages.add(player.getName()+" picked up a Brown key");
					}
					break;
					case "RedKey":
					{
						board.removeActor(newRow, newCol);
						player.pickupRedKey();
						messages.add(player.getName()+" picked up a Red key");
					}
					break;
					case "BlueKey":
					{
						board.removeActor(newRow, newCol);
						player.pickupBlueKey();
						messages.add(player.getName()+" picked up a Blue key");
					}
					break;
					case "Teleport":
					{
						board.removeActor(newRow, newCol);
						player.pickupTeleport(1);
						messages.add(player.getName()+" picked up a teleporter");
					}
					break;
					case "AllKey":
					{
						board.removeActor(newRow, newCol);
						player.pickupBrownKey();
						player.pickupBlueKey();
						player.pickupRedKey();
						messages.add(player.getName()+" picked up one of each key");
					}
					break;
					case "BrownDoor":
					{
						if(player.useBrownKey())
						{
							board.removeActor(newRow,newCol);
							messages.add(player.getName()+" open a BrownDoor");
						}
						else
						{
							messages.add("No brown keys found in inventory.");
							path = "";
							return;
						}
					}
					break;

					case "RedDoor":
					{
						if(player.useRedKey())
						{
							board.removeActor(newRow,newCol);
							messages.add(player.getName()+" open a RedDoor");
						}
						else
						{
							messages.add("No red keys found in inventory.");
							path = "";
							return;
						}
					}
					break;

					case "BlueDoor":
					{
						if(player.useBlueKey())
						{
							board.removeActor(newRow,newCol);
							messages.add(player.getName()+" open a BlueDoor");
						}
						else
						{
							messages.add("No blue keys found in inventory.");
							path = "";
							return;
						}
					}
					break;

					case "TreasureChest":
					{
						if(player.useBrownKey())
						{
							board.removeActor(newRow, newCol);
							int ran = (int)(Math.random()*100)+1;
							if(ran<=5)
							{
								player.damage+=10;
								messages.add(player.getName()+"'s damage + 10");
							}
							else if(ran>5 && ran<=10)
							{
								player.damage+=20;
								messages.add(player.getName()+"'s damage + 20");
							}
							else if(ran>10 && ran<=15)
							{
								player.damage+=30;
								messages.add(player.getName()+"'s damage + 30");
							}
							else if(ran>15 && ran<=20)
							{
								player.damage+=40;
								messages.add(player.getName()+"'s damage + 40");
							}
							else if(ran>20 && ran<=25)
							{
								player.damage+=50;
								messages.add(player.getName()+"'s damage + 50");
							}
							else if(ran>25 && ran<=30)
							{
								player.damage+=60;
								messages.add(player.getName()+"'s damage + 60");
							}
							else if(ran>30 && ran<=35)
							{
								player.damage+=70;
								messages.add(player.getName()+"'s damage + 70");
							}
							else if(ran>35 && ran<=40)
							{
								player.damage+=80;
								messages.add(player.getName()+"'s damage + 80");
							}
							else if(ran>40 && ran<=45)
							{
								player.damage+=90;
								messages.add(player.getName()+"'s damage + 90");
							}
							else if(ran>45 && ran<=50)
							{
								player.damage+=100;
								messages.add(player.getName()+"'s damage + 100");
							}
							else if(ran>50 && ran<=55)
							{
								player.defense+=10;
								messages.add(player.getName()+"'s defense + 10");
							}
							else if(ran>55 && ran<=60)
							{
								player.defense+=20;
								messages.add(player.getName()+"'s defense + 20");
							}
							else if(ran>60 && ran<=65)
							{
								player.defense+=30;
								messages.add(player.getName()+"'s defense + 30");
							}
							else if(ran>65 && ran<=70)
							{
								player.defense+=40;
								messages.add(player.getName()+"'s defense + 40");
							}
							else if(ran>70 && ran<=75)
							{
								player.defense+=50;
								messages.add(player.getName()+"'s defense + 50");
							}
							else if(ran>75 && ran<=80)
							{
								player.defense+=60;
								messages.add(player.getName()+"'s defense + 60");
							}
							else if(ran>80 && ran<=85)
							{
								player.defense+=70;
								messages.add(player.getName()+"'s defense + 70");
							}
							else if(ran>85 && ran<=90)
							{
								player.defense+=80;
								messages.add(player.getName()+"'s defense + 80");
							}
							else if(ran>90 && ran<=95)
							{
								player.defense+=90;
								messages.add(player.getName()+"'s defense + 90");
							}
							else if(ran>95 && ran<=100)
							{
								player.defense+=100;
								messages.add(player.getName()+"'s defense + 100");
							}
//							if(ran<=5)
//							{
//								board.addActor(new BossSword(),new Position(newRow,newCol));
//								messages.add(player.getName()+" found a BossSword!");
//								player.damage+=10;
//								messages.add(player.getName()+"'s damage + 10");
//							}
//							else if(ran>5 && ran<=10)
//							{
//								board.addActor(new DiamondShield(),new Position(newRow,newCol));
//								messages.add(player.getName()+" found a DiamondShield!");
//								player.defense+=10;
//								messages.add(player.getName()+"'s defense + 10");
//							}
//							else if(ran>60 && ran<=95)
//							{
//								board.addActor(new Potato(),new Position(newRow,newCol));
//								messages.add(player.getName()+" found a potato!");
//							}
						}
					}
					break;

					case "Portal":
					{
						board.removeActor(currRow, currCol);
						Portal portal = (Portal) board.get(newRow, newCol);
						enterPortal(portal.getPortalNum(), portal.getNextPos());
						path = "";
						return;
					}

					case "PortalReturn":
					{
						board.removeActor(currRow, currCol);
						PortalReturn returnPortal = (PortalReturn) board.get(newRow, newCol);
						enterReturnPortal(returnPortal.getPortalNum(), returnPortal.getNextPos());
						path = "";
						return;
					}

					case "Boss":
					{
						path = "";
						boss = (Boss) board.get(newRow, newCol);

						if(boss.currentHealth>0)
						{
							messages.add(player.normalattack(boss));
						}
						if(boss.currentHealth<=0)
						{
							bossDefeated = true;
							messages.add("Congratulations! You defeated the final boss!");
							messages.add("Press \"z\" if you want to leave the boss room.");
							messages.add("Otherwise, press \"r\" to explore a randomized map.");

							board.removeActor(newRow,newCol);
							messages.add(player.getexperience(10000));
							messages.add(player.getgold(10000));
						}
					}
					break;

					default:
					{
						System.out.println("That item isnt on the list.");
					}
					break;
				}

			}

			if(board.get(newRow, newCol)==null)
			{
				board.set( board.get(currRow, currCol), newRow, newCol );
				player = (Player)(board.get(currRow, currCol));
				board.removeActor(currRow, currCol);
				player.setPos(new Position(newRow, newCol));
				playerPos = new Position(newRow, newCol);
			}
		}
	}

	public void moveThePlayer(char c)
	{
		if(!dead)
		{
		   	if(c=='N')
			{
				moveDirection(-1,0); //up
			}
		   	else if(c=='S')
			{
				moveDirection(+1,0); //down
			}
		   	else if(c=='E')
			{
				moveDirection(0,+1); //right
			}
		   	else if(c=='W')
			{
				moveDirection(0,-1); //left
			}
		   	else if(c=='!')
			{
		   		System.out.println("Something out of bounds.");
			}
		   	else if(c=='F')
			{
		   		System.out.println("Could not find path to that location.");
			}
		}
	}

	public void enterPortal(int portalNum, Position pos)
	{
		System.out.println("enterPortal(int portalNum, Position pos) has been called");
		if(portalNum == 12345) //specific number for the portal in final map
		{
			board.removeActor(playerPos.getRow(),playerPos.getCol());
			playerPos = pos;
			player.setPos(playerPos);
			board.addActor(player,playerPos);
			repaint();
			return;
		}
		/*else if(portalNum<0||portalNum>mapList.size()+1)
		{
			board.grid =  maps.random();
			currentMap--;
			System.out.println("Player entered map a randomized map");
		}*/
		else
		{
			maps.setWallText();
			board.grid = mapList.get(portalNum-1);
			currentMap = portalNum;
			System.out.println("Player entered map "+portalNum);
		}
		height = board.getHeight()*SCALE;
		width = board.getWidth()*SCALE;
		invX = height + 25;
		invY = width - invWidth - 20;
		playerPos = pos;
		player.setPos(playerPos);
		board.addActor(player,playerPos);
		repaint();
	}
	public void enterReturnPortal(int portalNum, Position pos)
	{
		System.out.println("enterReturnPortal(int portalNum, Position pos) has been called");
		if(!(portalNum>0&&portalNum<mapList.size()))
		{
			System.out.println("COULD NOT FIND THAT MAP");
			return;
		}
		board.grid = mapList.get(portalNum-1);
		currentMap = portalNum;
		System.out.println("Player entered map "+portalNum);
		height = board.getHeight()*SCALE;
		width = board.getWidth()*SCALE;
		invX = height + 25;
		invY = width - invWidth - 20;
		playerPos = pos;
		player.setPos(playerPos);
		board.addActor(player,playerPos);
		repaint();
	}

	public void update(Graphics g)
   	{
		System.out.println("update() has been called");
		Graphics offgc;
		Image offscreen = null;
		Dimension d = size();

		// create the offscreen buffer and associated Graphics
		offscreen = createImage(d.width, d.height);
		offgc = offscreen.getGraphics();
		// clear the exposed area
		offgc.setColor(getBackground());
		offgc.fillRect(0, 0, d.width, d.height);
		offgc.setColor(getForeground());
		// do normal redraw
		paint(offgc);
		// transfer offscreen to window
		g.drawImage(offscreen, 0, 0, this);
   	}
	public void paint(Graphics window)
	{
		if(screen == 1)
		{
			window.setColor(BACKGROUND_COLOR);
			window.fillRect(0,0,700,width);
			try{
    			Image img = ImageIO.read(getClass().getResource("Treasure_Finders_Screen_1.png"));
    			window.drawImage(img,0,0,700,600,null);
    		}catch(Exception e){
				window.setColor(Color.BLACK);
				window.setFont(new Font("TAHOMA",Font.BOLD,52));
				window.drawString("Treasure Finders",120,120);
				window.drawRect(110,70,460,60);
    		}
			window.setFont(new Font("TAHOMA",Font.BOLD,32));
			window.setColor(Color.black);
			window.drawString("Select character",217,393);
			player.setType("Male");
			player.drawWithoutHealth(window, 100, 197, 420);
			player.setType("Female");
			player.drawWithoutHealth(window, 100, 297, 420);
			player.setType("Giraffe");
			player.drawWithoutHealth(window, 100, 397, 420);
		}
		else if(screen == 2)
		{
			graphics = window;

			System.out.println("paint() has been called " + ++howManyTimePaintHasBeenCalled + " times.");
			window.setFont(new Font("TAHOMA",Font.BOLD,12));

			//background of game board
			window.setColor(BACKGROUND_COLOR);
			window.fillRect(0, 0, height, width);

			//draw every item in the game board
			for(int r=0;r<board.getWidth();r++)
			{
				for(int c=0;c<board.getHeight();c++)
				{
					if(board.get(r,c)!=null)
					{
						Thing th=(Thing)board.get(r,c);
						th.draw(window, SCALE, c*SCALE, r*SCALE);
					}
				}
			}

			drawSidePanel(window, height, 0);
		}
	}

	public void drawSidePanel(Graphics window, int x, int y)
	{
		System.out.println("drawSidePanel() has been called.");

		//background of side interface
		window.setColor(new Color(230,230,230));
		window.fillRect(x+=10, 0, 400, width);

		//draw the side interface stats
		window.setColor(Color.black);
		window.setFont(new Font("TAHOMA",Font.BOLD,12));

		x+=10;
		window.drawString("Map "+currentMap, x, y+=20);

		window.setColor(Color.RED);
		window.fillRect(x-4, y+=14, 370, 46);
		double health = (double)player.getHealth()/(double)player.getMaxHealth();
		//window.setColor(new Color(0, 135+(int)(health*120) ,0));
		window.setColor(health<0.2 ? Color.YELLOW : Color.GREEN);
		window.fillRect(x-4, y, (int) (health*370), 46);
		window.setColor(Color.BLACK);
		window.drawString("Health: "+player.getHealth() + "/" + player.maxHealth, x, y+=14);
		window.drawString("Damage: "+player.damage, x, y+=14);
		window.drawString("Defense: "+player.defense, x, y+=14);


//		window.fillRect(x-4, y+15, 370, 46);
//		try{
//			window.setColor( new Color( player.getLevel()*50, player.getLevel()*40, 255-player.getLevel()*20 ) ); //error if color number is <0 or >255
//		}catch(IllegalArgumentException e){
//			window.setColor(Color.RED);
//		}
//		window.fillRect(x-4, y+15, (int)(((double)player.getExperience()/(double)player.getRequiredExp())*370), 46);
		window.setColor(Color.black);
		window.drawString("Experience: "+player.getExperience(), x, y+=28);
//		window.drawString("XP required for level "+(player.getLevel()+1)+": "+player.getRequiredExp(), x, y+=14);
		window.drawString("Level: "+player.getLevel(), x, y+=14);
		window.drawString("lifesteal amount: "+player.getlifesteal(), x, y+=14);

		window.drawString("+ Damage", x, y+14);
		window.drawString("+ Defense", x+70, y+14);
		window.drawString("+ Health", x+140, y+14);

		window.setColor(Color.black);
		int liveLeft=3-numDeath;
		window.drawString("Lives: "+liveLeft+"/3", x, y+=28);
		window.drawString("Gold: "+player.getGold(), x, y+=14);

		//draw the messages in the side interface
		window.setColor(Color.black);
		window.drawString("------------------------------------------",x,y+=16);
		if(messages.size()>0)
		{
			if(messages.size()>10)
				for(int q = 0; q < messages.size()-10; q++)
					messages.remove(0);

			for(int i = 0; i < messages.size(); i++)
			{
				window.drawString(messages.get(i),x,y+=14);
			}
		}
		window.drawString("------------------------------------------",x,y+=14);

		//INVENTORY
		window.setColor(Color.GRAY);
		window.fillRect(invX, invY, invHeight, invWidth);
		window.setColor(Color.BLACK);
		window.drawRect(invX, invY, invHeight, invWidth);

		for(int r2=0; r2<player.inv.getNumRows(); r2++)
		{
			for(int c2=0; c2<player.inv.getNumCols(); c2++)
			{
				if(player.inv.get(r2,c2)!=null)
				{
					Item it = (Item) player.getInventory().get(r2,c2);
					it.draw(window, INV_SCALE, invX + c2*INV_SCALE, invY + r2*INV_SCALE);
				}
			}
		}

		if(monster != null)
		{
			window.setColor(Color.GRAY);
			window.fillRect(invX + 270, invY - 130, 90, 120);
			monster.draw(window, monster instanceof Boss? 40 : 80, invX + 275, invY - 125);
			window.setColor(Color.BLACK);
			window.drawString("H: "+monster.getHealth() + "/" + monster.getMaxHealth(), invX + 273, invY - 130 + 90);
			window.drawString("Damage: "+monster.getDamage(), invX + 273, invY - 130 + 90+14);
			window.drawString("Defense: "+monster.getDefense(), invX + 273, invY - 130 + 90+14+14);
			window.drawRect(invX + 270, invY - 130, 90, 120);
		}

	}

   public void run()
   {
	   System.out.println("run() has been called");
	   try
	   {
	   	while(true)
	   	{
	   		Thread.currentThread().sleep(2);
	   		if(path.length()>0)
	   		{
		   		for(int i = 0; i < path.length(); i++)
		   	 	{

		   	 		if(path.charAt(i)=='N')
			   			moveThePlayer('N');
		   	 		else if(path.charAt(i)=='E')
			   			moveThePlayer('E');
		   	 		else if(path.charAt(i)=='S')
			   			moveThePlayer('S');
		   	 		else if(path.charAt(i)=='W')
			   			moveThePlayer('W');
		   	 		else if(path.charAt(i)=='!')
			   			path = "";
			   		Thread.currentThread().sleep(95);

		   			repaint();
		   	 	}
		   		path="";
	   		}

	   		if(player!=null && player.getHealth()<=0)
	   		{
	   			numDeath++;
	   			if(numDeath>3)
	   				numDeath=3;
	   			if(numDeath<3)
	   			{
		   			player.currentHealth=player.maxHealth/2;
//		   			if(player.damage>=15)
		   				player.damage /=2;
//		   			if(player.defense>=15)
		   				player.defense /=2;
		   			board.removeActor(playerPos.getRow(), playerPos.getCol());
		   			System.out.print(player.getHealth());
		   			enterPortal(1, startPos);
		   			messages.add(player.getName() + " has respawned! " + (3 - numDeath == 1? "1 life left." :  (3 - numDeath) + " lives left."));
	   			}
	   			else
	   			{
	   				if(!dead)
	   				{
	   					messages.add(player.getName()+" died!");
	   					messages.add("GAME OVER!");
	   					player.dead=true;repaint();
	   				}
					dead=true;


	   			}
	   		}
	   	}

	   }
	   catch(Exception e)
	   {
		   System.out.println("run() ISNT RUNNING ANYMORE");
	   }
	}

	public void keyTyped(KeyEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseClicked(MouseEvent e) { }
}