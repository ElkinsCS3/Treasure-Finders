import javax.swing.JFrame;


public class Runner extends JFrame implements Runnable
{
	private static final int WIDTH = 1033;//705;
	private static final int HEIGHT = 645;//726;

	public void devversion()
	{
		//version dev1.0 start the project
		//version dev1.1 add player
		//version dev1.2 allowed palyer to move around to grid
		//version dev1.3 added functional walls/borders
		//version dev1.4 added functional doors/keys
		//version dev1.41 improve visual upgrades for doors/keys
		//version dev1.415 layed out top left of the room
		//version dev1.42 change background color to light gray
		//version dev1.5 added cheats
		//version dev1.6 added pointing system
		//version dev1.7 added portal
		//version dev1.8 added functional portal right side only
		//version dev1.9 added 5 new map and 15 temporary map
		//version dev1.91 fixed mouseclick/pointing system
		//version dev1.915 increasing readability for maps
		//version dev1.92 made instance variables into a triangle
		//version dev2.0 added return portal
		//version dev2.05 fixed return portal
		//version dev2.1 added 4 way portal/return portal
		//version dev2.15 fixed and added 5 maps
		//version dev2.20 fixed resolution
		//version dev2.3 added monster/ghost and damage system
		//version dev2.35 change 5 maps and fix portal
		//version dev2.355 fixed map
		//version dev2.4 added combat system, fix grid, graphic updates for portal, character, and keys
		//version dev2.45 added 2 more maps and keys
		//version dev2.455 shortened code a bit (moveDirection() and isWalkable())
		//version dev2.5 added potatoes and ability to heal
		//version dev2.6 moving to alpha.
	}
	public void alphaversion()
	{
		//version alpha1.0 added runescape map, sword, display, visual, reduce lag, reduce game size.
		//version alpha1.1 added sword, armor, boss, fixed heal system
		//version alpha1.2 fixed graphic issue, merge files, and a little bit of this and a little bit of that...
		//version alpha1.3 fixed level system, added shield, and treasure system
		//version alpha1.35 fixed map portal system, still contain graphic issue.
		//version alpha1.4 added inventory system, health bars, message box, still has lag issue.
		//version alpha1.5 fixed lag issue, change damage/defense system, graphic and monster's maximum and current health
		//version alpha1.55 merge file, some data lost, couple graphic error,
		//version alpha1.555 using old graphic, improve visual effect, added display system.
		//version alpha1.6 change 11 maps completely, added bossSword, player direction
		//version alpha1.7 added portal/return portal to first 11 maps, fix damage system, change from yellow key into brown keys
		//version alpha1.8 added 5 new monster and data, fixed portal system fixed dialog system.
		//version alpha1.9 moving to bravo.
	}
	public void bravoversion()
	{
		//version bravo1.0 finish leveling map 1, fixing all slimes damage/defense/health, added diamondshield, added color of rainbow as monster's damage ratio
		//version bravo1.1 added user manual
		//version bravo1.2 fill out 5 maps, added back percentage system for armor, and death punishment
		//version bravo1.3 added 5 new ghost, change god mode into trigger, added true damage.
		//version bravo1.4 fixed exp system, added level changer, and level change system. added critical and dodge system. added couple map items.
		//version bravo1.41 fixed cmd error, simplified code.
		//version bravo1.5 added league of legends feature and many others....
		//version bravo1.51 added missing file....
		//version bravo1.6 moving to charlie.
	}
	public void charlieversion()
	{
		//version charlie1.0 completed game 5/27/2014 by Weizhao Chen, David Espinosa and Ryan Chen. Released on 6/1/2014
		//version charlie1.1 completely change the maps, monsters.
		//version charlie1.11 using item instantly, added bigger potato.
		//version charlie1.12 added first level.
		//version charlie1.2 added auto crafting system, added 4 extra maps. current map 5/24
		//version charlie1.21 added java 8. change map setting.
		//version charlie1.22 fixed bug. fix 5 maps and added 2 new maps. current map 7/24
		//version charlie1.3 fixed bugs and maps. added lifesteal system.
		//version charlie1.4 change nerfhealthattack into change hp. fixed gold/exp system. added 5 new monster. current monster 19/42
		//version charlie1.5 fixed minor error. fixed auto get items. make gameplay harder and playable
		//version charlie1.51 fixed triple attack. fixed minor coding bugs
		//version charlie1.515 fixed minor coding error/bugs
		//version charlie1.6 added different types of character has different start stats
		//version charlie1.61 added New Types of Key
		//version charlie1.7 add up to 20 maps. current map 20/24
		//version charlie1.8 change start status and fix maps. working map 8/24
		//version charlie1.9 fixed minor bugs working map 19/24
		//version charlie1.91 fixed minor bugs working map 19/24
		//version charlie2.0 added 5 new monster. current monster 24/42. fix some minor issue
		//version charlie2.1 added 2 new monster, current monster 26/42 fix some map error/coding
		//version charlie2.2 delete couple maps, 17/24. added monster on many levels, 15/24 fix game code.
		//version charlie2.21 fixed coding. fixed auto status at beginning.
		//version charlie2.3 change cheats into store, remade the shop and experience.
		//version charlie2.4 added incomplete dodge system, fixed explevelup setting.
		//version charlie2.41 fixed map 18 portal.
		//version charlie2.42 fixed game damage, and seniormage damage
		//version charlie2.43 added lifesteal amount and fix minor code
		//version charlie2.44 added wip teleport fixed minor coding
		//version charlie2.441 added errors and addons log
		//version charlie2.5 moving to delta
	}
	public void deltaversion()
	{
		//version delta1.0 playable game release date 12/1/2014 still private
		//version delta1.01 setting up version log
		//version delta1.02 finish game map 20/20.
		//version delta1.1 fixed usage of gold, exp, and level up.
		//version delta1.2 change how exp is gained.
		//version delta1.3 change damage and defense ratio is maximum integer. fixed minor bugs and errors.
		//version delta1.4 added music/sound
		//version delta1.41 fixed minor damage issue.
		//version delta1.5 fixed potato/health bug, added bonus damage system with bugs.
		//version delta1.6 fixed negative exps, bonus damage, and minor bugs.
		//version delta1.61 fixed potato/health bug(kinda).
		//verison delta1.62 fixed increase attack and defense, and decrease in attack and defense.
		//version delta1.621 started floor teleporter still wip.
		//version delta1.63 fixed potatoes.
	}
	public void errors()
	{
		//known errors

		//attacking redmage damage messed up
		//treasure box need to nerf
		//teleport need fix
		//lifesteal need to fix
		//need to simplified codes
		//heal regen messed up
		//switching back from god mode resets character to default icon
		

		//when errors' are fixed, it would be remove from errors.
	}
	public void addons()
	{
		//things about to add into the game

		//increasing map size
		//reduce game file
		//reduce data input
		//improve graphic
		//better combat
		//better mechanicals
		//implement dodge as a skill
		//change to 1920 by 1080
		//copyrights
		//special abilities
		//random events
		//npcs
		//second character
		//moving mobs
		//auto spawning
		//hp regen
		//more items
		//multiplayer
		//more monsters
		//fixing game files
		//respawn timer
		//lean more into mmo than just a game

		//when addons' item added into the game, it would be remove from addons
	}

	public Runner()
	{
		super("Treasure-Finders delta 1.63");
		setSize(WIDTH,HEIGHT);
		getContentPane().add(new GameBoard());
		setVisible(true);


	}

	public void run()
	{
		/*new Runner();
		for(int i=1;i>0;i++)
		{
			Sound.sound1.play();
			try{
				Thread.sleep(125000);
			}
			catch (InterruptedException e) {
			    e.printStackTrace();
			    // handle the exception...
			    // For example consider calling Thread.currentThread().interrupt(); here.
			}

		}*/
	}

	public static void main( String args[] )
	{
		Runner t = new Runner();
    	Thread thread = new Thread(t);
    	thread.start();

	}


}