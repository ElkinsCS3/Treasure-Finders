import static java.lang.System.*;
import java.awt.*;
import javax.imageio.ImageIO;
//4/4/14 added getKeyCount()
public class Player extends Actor implements Thing
{
	public Inventory inv;

	protected int keys;
	protected int keys2;
	protected int keys3;
	protected int potatoes;
	protected int teleporter;

	private char direction; //'U', 'D', 'L', or 'R'
	private String type;

	protected int experience;
	protected int gold;
	private int requiregold;
	private int requireexp;
	private int requirelevelexp;
	public int level;
	
	private int tempdamage;
	private int tempdefense;
	
	private int dodge;
	private int dodgelevel;
	
	private double lifesteal;
	private int actual;
	
	public boolean checkdamage;
	public boolean checkdefense;
	
	public boolean enableteleport;
	

	private Image img;

	public boolean dead;
	int olddamage,olddefense,oldcurrenthealth,oldmaxhealth;

    public Player(String n, Position p, int def, int dam)
    {
    	super(n, p, def, dam);
    	requireexp = 30;
    	requirelevelexp = 100;
    	requiregold = 20;
    	level = 1;
    	dodgelevel=1;
    	dodge = (int)(Math.random()*100)+dodgelevel;
    	inv = new Inventory(7,12);
    	setDirection('D');
    	setType("Male");
    	dead = false;
    	checkdamage = true;
    	checkdefense = true;
    }

	public void setDirection(char c)
	{
		direction = c;
	}

	public void setType(String t)
	{
		type = t;
	}

    public void pickupBrownKey()
    {
    	inv.add(new BrownKey(), 1);
    }
    public void pickupRedKey()
    {
    	inv.add(new RedKey(), 1);
    }
    public void pickupBlueKey()
    {
    	inv.add(new BlueKey(), 1);
    }
    public void pickupPotato()
    {
    	inv.add(new Potato(), 1);
    }
    public void pickupBigpotato()
    {
    	inv.add(new Bigpotato(), 1);
    }
    public void pickupBrownKeys(int a)
    {
    	inv.add(new BrownKey(), a);
    }
    public void pickupRedKeys(int a)
    {
    	inv.add(new RedKey(), a);
    }
    public void pickupBlueKeys(int a)
    {
    	inv.add(new BlueKey(), a);
    }
    public void pickupPotatoes(int a)
    {
    	inv.add(new Potato(), a);
    }
    public void pickupTeleport(int a)
    {
    	inv.add(new teleport(), a);
    }
    public String getexperience(int x)
    {
    	experience=experience+x;
//		while(experience>=requireexp)
//		{
//			experience=experience-requireexp;
//			return levelup();
//		}
		return super.getName()+" gained " + x + " experience.";

    }
    public String getgold(int x)
    {
    	gold=gold+x;
//    	if(gold>=requiregold)
//    	{
//    		gold=gold-requiregold;
//    		requiregold++;
//    		return goldattack();
//    		
//    	}
    	return super.getName()+" gained " + x + " gold.";
    }
    public String goldattack()
    {
    	if(gold>=requiregold)
    	{
    		if(requiregold<25)
    		{
    			gold = gold - requiregold;
    			damage+=3;
    			requiregold++;
    			return super.getName()+" gained 3 damage.";
    		}
    		else if(requiregold>=25&&requiregold<50)
    		{
    			gold = gold - requiregold;
    			damage+=7;
    			requiregold=requiregold+2;
    			return super.getName()+" gained 7 damage.";
    		}
    		else if(requiregold>=50&&requiregold<75)
    		{
    			gold = gold - requiregold;
    			damage+=12;
    			requiregold=requiregold+3;
    			return super.getName()+" gained 12 damage.";
    		}
    		else if(requiregold>=75&&requiregold<100)
    		{
    			gold = gold - requiregold;
    			damage+=18;
    			requiregold=requiregold+4;
    			return super.getName()+" gained 18 damage.";
    		}
    		else if(requiregold>=100)
    		{
    			gold = gold - requiregold;
    			damage+=25;
    			requiregold=requiregold+5;
    			return super.getName()+" gained 25 damage.";
    		}
    		return super.getName()+" gold needed for the next item " + requiregold + ".";
    	}
    	return super.getName()+" need " + requiregold + " more gold.";
    }
    public String golddefense()
    {
    	if(gold>=requiregold)
    	{
    		if(requiregold<25)
    		{
    			gold = gold - requiregold;
    			defense+=3;
    			requiregold++;
    			return super.getName()+" gained 3 defense.";
    		}
    		else if(requiregold>=25&&requiregold<50)
    		{
    			gold = gold - requiregold;
    			defense+=7;
    			requiregold=requiregold+2;
    			return super.getName()+" gained 7 defense.";
    		}
    		else if(requiregold>=50&&requiregold<75)
    		{
    			gold = gold - requiregold;
    			defense+=12;
    			requiregold=requiregold+3;
    			return super.getName()+" gained 12 defense.";
    		}
    		else if(requiregold>=75&&requiregold<100)
    		{
    			gold = gold - requiregold;
    			defense+=18;
    			requiregold=requiregold+4;
    			return super.getName()+" gained 18 defense.";
    		}
    		else if(requiregold>=100)
    		{
    			gold = gold - requiregold;
    			defense+=25;
    			requiregold=requiregold+5;
    			return super.getName()+" gained 25 defense.";
    		}
    		return super.getName()+" gold needed for the next item " + requiregold + ".";
    	}
    	return super.getName()+" need " + requiregold + " more gold.";
    }
    public String goldhealth()
    {
    	if(gold>=requiregold)
    	{
    		if(requiregold<25)
    		{
    			gold = gold - requiregold;
    			currentHealth+=800;
    			requiregold++;
    			return super.getName()+" gained 800 Health.";
    		}
    		else if(requiregold>=25&&requiregold<50)
    		{
    			gold = gold - requiregold;
    			currentHealth+=1800;
    			requiregold=requiregold+2;
    			return super.getName()+" gained 1800 Health.";
    		}
    		else if(requiregold>=50&&requiregold<75)
    		{
    			gold = gold - requiregold;
    			currentHealth+=3500;
    			requiregold=requiregold+3;
    			return super.getName()+" gained 3500 Health.";
    		}
    		else if(requiregold>=75&&requiregold<100)
    		{
    			gold = gold - requiregold;
    			currentHealth+=6000;
    			requiregold=requiregold+4;
    			return super.getName()+" gained 6000 Health.";
    		}
    		else if(requiregold>=100)
    		{
    			gold = gold - requiregold;
    			currentHealth+=10000;
    			requiregold=requiregold+5;
    			return super.getName()+" gained 10000 Health.";
    		}
    		return super.getName()+" gold needed for the next item " + requiregold + ".";
    	}
    	return super.getName()+" need " + requiregold + " more gold.";
    }
    public String expattack()
    {
    	if(experience>=requireexp)
    	{
    		if(requireexp<100)
    		{
    			experience = experience - requireexp;
    			damage+=8;
    			requireexp=requireexp+2;
    			return super.getName()+" gained 4 damage.";
    		}
    		else if(requireexp>=100&&requireexp<200)
    		{
    			experience = experience - requireexp;
    			damage+=25;
    			requireexp=requireexp+4;
    			return super.getName()+" gained 10 damage.";
    		}
    		else if(requireexp>=200)
    		{
    			experience = experience - requireexp;
    			damage+=25;
    			requireexp=requireexp+6;
    			return super.getName()+" gained 25 damage.";
    		}	
    		return super.getName()+" exp needed for the next item " + requireexp + ".";
    	}
    	return super.getName()+" need " + requireexp + " more exp.";
    }
    public String expdefense()
    {
    	if(experience>=requireexp)
    	{
    		if(requireexp<100)
    		{
    			experience = experience - requireexp;
    			defense+=4;
    			requireexp=requireexp+2;
    			return super.getName()+" gained 4 defense.";
    		}
    		else if(requireexp>=100&&requireexp<200)
    		{
    			experience = experience - requireexp;
    			defense+=10;
    			requireexp=requireexp+4;
    			return super.getName()+" gained 10 defense.";
    		}
    		else if(requireexp>=200)
    		{
    			experience = experience - requireexp;
    			defense+=25;
    			requireexp=requireexp+6;
    			return super.getName()+" gained 25 defense.";
    		}	
    		return super.getName()+" exp needed for the next item " + requireexp + ".";
    	}
    	return super.getName()+" need " + requireexp + " more exp.";
    }
    public String exphealth()
    {
    	if(experience>=requireexp)
    	{
    		if(requireexp<100)
    		{
    			experience = experience - requireexp;
    			currentHealth+=600;
    			requireexp=requireexp+2;
    			return super.getName()+" gained 600 currentHealth.";
    		}
    		else if(requireexp>=100&&requireexp<200)
    		{
    			experience = experience - requireexp;
    			currentHealth+=2000;
    			requireexp=requireexp+4;
    			return super.getName()+" gained 2000 currentHealth.";
    		}
    		else if(requireexp>=200)
    		{
    			experience = experience - requireexp;
    			currentHealth+=5000;
    			requireexp=requireexp+6;
    			return super.getName()+" gained 5000 currentHealth.";
    		}
    		return super.getName()+" exp needed for the next item " + requireexp + ".";
    	}
    	return super.getName()+" need " + requireexp + " more exp.";
    }
    public String explevelup()
    {
    	if(experience>=requirelevelexp)
    	{
    		if(level<10)
    		{
    			experience = experience - requirelevelexp;
    			currentHealth+=600;
    			maxHealth+=600;
    			damage+=7;
    			defense+=7;
    			requirelevelexp=requirelevelexp+10;
    			level++;
    			return super.getName()+" gained 600 health, 7 attack and 7 defense.";
    		}
    		else if(level>=10&&level<20)
    		{
    			experience = experience - requirelevelexp;
    			currentHealth+=2000;
    			maxHealth+=2000;
    			damage+=20;
    			defense+=20;
    			requirelevelexp=requirelevelexp+50;
    			level++;
    			return super.getName()+" gained 2000 health, 20 attack and 20 defense.";
    		}
    		else if(level>=20)
    		{
    			experience = experience - requirelevelexp;
    			currentHealth+=5000;
    			maxHealth+=5000;
    			damage+=50;
    			defense+=50;
    			requirelevelexp=requirelevelexp+100;
    			level++;
    			return super.getName()+" gained 5000 health, 50 attack and 50 defense.";
    		}	
    		return super.getName()+" exp needed for the next item " + requirelevelexp + ".";
    	}
    	return super.getName()+" need " + requirelevelexp + " more exp.";
    }
    public String powerupattack()
    {
    	tempdamage = damage;
    	damage = (int) (damage * 1.5);
    	checkdamage=false;
    	return super.getName()+" attack is 1.5x";
    }
    public String powerupdefense()
    {
    	tempdefense = defense;
    	defense = (int) (defense * 1.5);
    	checkdefense=false;
    	return super.getName()+" defense is 1.5x";
    }
    public String depowerupattack()
    {
    	//damage = (int) (damage / 1.5);
    	damage = tempdamage;
    	checkdamage=true;
    	return super.getName()+" attack is 1.5x less";
    }
    public String depowerupdefense()
    {
    	//defense = (int) (defense / 1.5);
    	defense= tempdefense;
    	checkdefense=true;
    	return super.getName()+" defense is 1.5x less";
    }
    public String moveupalevel()
    {
    	
    	return "";
    }
    public String movedownalevel()
    {
    	return "";
    }
    public String activateGodMode()
    {
    	olddamage=damage; olddefense=defense; oldcurrenthealth=currentHealth; oldmaxhealth=maxHealth;
    	damage = defense = currentHealth = maxHealth = 100000;
    	setType("Giraffe");
    	name = "God";
    	return "GOD MODE ACTIVATED";
    }
    public String deactivateGodMode()
    {
    	damage=olddamage; defense=olddefense; currentHealth=oldcurrenthealth; maxHealth=oldmaxhealth;
    	name = "Player";
    	setType("Male");
    	return "GOD MODE DEACTIVATED";
    }
    public Player getCopy()
    {
    	Player p = new Player(name,pos,defense,damage);
    	p.setHealth(currentHealth);
    	p.setMaxHealth(maxHealth);
    	return p;
    }

    public int getBrownKeyCount()
    {
    	return keys;
    }
    public int getRedKeyCount()
    {
    	return keys2;
    }
    public int getBlueKeyCount()
    {
    	return keys3;
    }
    public int getPotatoCount()
    {
    	return potatoes;
    }
    public Inventory getInventory()
    {
    	return inv;
    }
    public int getExperience()
    {
    	return experience;
    }
    public int getRequiredExp()
    {
		return requireexp;
    }
    public int getRequiredLevelExp()
    {
		return requirelevelexp;
    }
    public int getLevel()
    {
    	return level;
    }
    public int getGold()
    {
    	return gold;
    }
    public int getlifesteal()
    {
    	return actual;
    }
    public int getTeleport()
    {
    	return teleporter;
    }
    public boolean useBrownKey()
    {
    	Position keyPos = inv.findBrownKey();
    	if(keyPos==null)
    	{
    		return false;
    	}
    	else
    	{
    		inv.remove(keyPos.getRow(),keyPos.getCol());
    		return true;
    	}
    }
    public boolean useRedKey()
    {
    	Position keyPos = inv.findRedKey();
    	if(keyPos==null)
    	{
    		return false;
    	}
    	else
    	{
    		inv.remove(keyPos.getRow(),keyPos.getCol());
    		return true;
    	}
    }
    public boolean useBlueKey()
    {
    	Position keyPos = inv.findBlueKey();
    	if(keyPos==null)
    	{
    		return false;
    	}
    	else
    	{
    		inv.remove(keyPos.getRow(),keyPos.getCol());
    		return true;
    	}
    }
    public String heal()
    {
    	//if(potatoes>0)
    	//{
    		if(currentHealth<=maxHealth)
    		{
	    		//potatoes--;
	    		int oldHealth = currentHealth; //currentHealth/oldHealth = 700
	    		oldHealth+=200+level*50; //oldHealth = 950 //currentHealth = 700
	    		if(currentHealth<oldHealth&&oldHealth<=maxHealth) //if(700<950&&950<=1000)
	    		{
	    			int tempcurrenthealth = currentHealth;
	    			int tempaddhealth= oldHealth - currentHealth;
	    			currentHealth=oldHealth; //700=950
	    			return super.getName()+" healed " + (tempaddhealth) + " life points. ("+tempcurrenthealth+"->"+currentHealth+")";
	    		}
	    		return "already max health";	
	    		
    		}
    		else
    		{
    			return "already max health";
    		}
    	}
		//return "Need more potatoes";
    //}

    public String heal2()
    {
    	Position potatoPos = inv.findPotato();
    	if(potatoPos!=null)
    	{
    		String heal = heal();
    		if(!(heal.equals("already max health")))
    		{	
    			if(currentHealth==maxHealth)
    			{
    				return "already max health";
    			}
    			inv.remove(potatoPos.getRow(),potatoPos.getCol());
				return heal;
    		}
    		return "already max health";
    	}
    	else
    	{
    		return "no potatoes found in inv.";
    	}
    }
    public String heal(int a)
    {
    	if(currentHealth<=Integer.MAX_VALUE-a)
    	{
    		if(currentHealth<maxHealth)
    		{
	    		int oldHealth = currentHealth;
	    		currentHealth+=a;
	    		if(currentHealth>maxHealth)
	    			currentHealth=maxHealth;
	    		return super.getName()+" healed " + (currentHealth-oldHealth) + " life points. ("+oldHealth+"->"+currentHealth+")";
    		}
    		else
    		{
    			return "already max health!";
    		}
    	}
    	else
    	{
    		return "Health cannot be above 2,147,483,647!";
    	}
    }
    public String TripleAttack(Monster a)
    {
    	boolean crit=false;
		boolean dodge=false;
    	int damageDealt=getDamageDealt2(damage,a.defense);
    	
    	lifesteal=damageDealt*.1;

    	actual = (int)lifesteal;

    	if(damageDealt<0)
    		damageDealt=0;
    	if((int)(Math.random()*100)<=1)
    	{
    		damageDealt*=2;
    		crit=true;
    	}
    	if(damageDealt<a.currentHealth)
    	{
    		int damageRecieved=getDamageDealt3(a.damage,defense);
    		if(damageRecieved<0)
    			damageRecieved=0;
    		setHealth(getHealth()+actual);
    		setHealth(getHealth()-(damageRecieved*3));
    		//a.setHealth(a.getHealth()-damageDealt);
    		if((int)(Math.random()*100)>1)
    		{
    			a.setHealth(a.getHealth()-damageDealt);
    		}
    		else
    			dodge=true;
    	}
    	else
    		a.setHealth(0);

    	if(dodge)
    		return super.getName()+"'s attack got dodged";
    	else if(crit)
    		return super.getName()+" dealt "+damageDealt+" critical damage to "+a.getName();
    	else
    		return super.getName()+" dealt "+damageDealt+" damage to "+a.getName();

    }
    public String DoubleAttack(Monster a)
    {
    	boolean crit=false;
		boolean dodge=false;
    	int damageDealt=getDamageDealt2(damage,a.defense);
    	
    	lifesteal=damageDealt*.1;

    	actual = (int)lifesteal;

    	if(damageDealt<0)
    		damageDealt=0;

    	if((int)(Math.random()*100)<=1)
    	{
    		damageDealt*=2;
    		crit=true;
    	}

    	if(damageDealt<a.currentHealth)
    	{
    		int damageRecieved=getDamageDealt3(a.damage,defense);
    		if(damageRecieved<0)
    			damageRecieved=0;
    		setHealth(getHealth()+actual);
    		setHealth(getHealth()-(damageRecieved*2));
    		//a.setHealth(a.getHealth()-damageDealt);
    		if((int)(Math.random()*100)>1)
    		{
    			a.setHealth(a.getHealth()-damageDealt);
    		}
    		else
    			dodge=true;

    	}
    	else
    		a.setHealth(0);

    	if(dodge)
    		return super.getName()+"'s attack got dodged";
    	else if(crit)
    		return super.getName()+" dealt "+damageDealt+" critical damage to "+a.getName();
    	else
    		return super.getName()+" dealt "+damageDealt+" damage to "+a.getName();

    }
    public String normalattack(Monster a)
    {
    	boolean crit=false;
		boolean dodge=false;
    	int damageDealt=getDamageDealt(damage,a.defense);

    	lifesteal=damageDealt*.1;

    	actual = (int)lifesteal;

    	if(damageDealt<0)
    		damageDealt=0;

    	if((int)(Math.random()*100)<=1)
    	{
    		damageDealt*=2;
    		crit=true;
    	}
    	if(damageDealt<a.currentHealth)
    	{
    		int damageRecieved=getDamageDealt(a.damage,defense);
    		if(damageRecieved<0)
    			damageRecieved=0;
    		setHealth(getHealth()+actual);
    		setHealth(getHealth()-damageRecieved);
    		//a.setHealth(a.getHealth()-damageDealt);
    		if((int)(Math.random()*100)>1)
    		{
    			a.setHealth(a.getHealth()-damageDealt);
    		}
    		else
    			dodge=true;
    	}
    	else
    		a.setHealth(0);

    	if(dodge)
    		return super.getName()+"'s attack got dodged";
    	else if(crit)
    		return super.getName()+" dealt "+damageDealt+" critical damage to "+a.getName();
    	else
    		return super.getName()+" dealt "+damageDealt+" damage to "+a.getName();

    }
    public String TrueAttack(Monster a)
    {
    	boolean crit=false;

    	int damageDealt=getDamageDealt(damage,a.defense);
    	
    	lifesteal=damageDealt*.1;

    	actual = (int)lifesteal;

    	if(damageDealt<0)
    		damageDealt=0;

    	if((int)(Math.random()*100)<=1)
    	{
    		damageDealt*=2;
    		crit=true;
    	}

    	if(damageDealt<a.currentHealth)
    	{
    		int damageRecieved=a.damage;
    		setHealth(getHealth()-damageRecieved);
    		setHealth(getHealth()+actual);
    		a.setHealth(a.getHealth()-damageDealt);
    	}
    	else
    		a.setHealth(0); 	
    	if(crit)
    		return super.getName()+" dealt "+damageDealt+" critical damage to "+a.getName();
    	else
    		return super.getName()+" dealt "+damageDealt+" damage to "+a.getName();

    }
    //player damage, monster defense
    public int getDamageDealt(int a,int d)
	{
		double dd;
		if(d<=50)
			dd=Math.sqrt((double)d * 33.3);
		else if(d<=100)
			dd=Math.sqrt((double)d * 50);
		else if(d<=200)
			dd=Math.sqrt((double)d * 66.6);
		else if(d<=900)
			dd=Math.sqrt((double)d * 90);
		else
			dd=Math.sqrt((double)d * 99);
		dd = (1-dd/1000.0)*a;
		return (int)Math.round(dd);
	}
			//player attack, monster defense	
	public int getDamageDealt2(int a,int d)
	{
		int dd2;
		if(a>d)
			dd2=a-d;
		else
			dd2=0;
		
		return dd2;
	}
			//monster attack, player defense
	public int getDamageDealt3(int a2,int d2)
	{
		int dd3;
		if(a2>d2)
			dd3=a2-d2;
		else
			dd3=0;
		
		return dd3;
	}
   	public void draw(Graphics window, int x, int y)
    {
		window.setColor(Color.RED);
    	window.fillRect(x,y,45,9);
    	window.setColor(Color.GREEN);
    	window.fillRect(x,y,(int)((double)currentHealth/(double)(maxHealth)*45),9);
		if(dead)
		{
			try{
	    		img = ImageIO.read(getClass().getResource("Dead.png"));
	    		window.drawImage(img,x,y,45,45,null);
	    		window.setColor(Color.BLACK);
	    		window.setFont(new Font("Britannic Bold", Font.PLAIN, 90));
	    		window.drawString("GAME OVER",65,300);
	    	}catch(Exception e){
		    	window.setColor(Color.RED);
		    	window.fillOval(x+15,y+15,15,15);
	    	}
		}
		else
		{
	    	try{
	    		img = ImageIO.read(getClass().getResource(type+"_"+direction+".png"));
	    		window.drawImage(img,x,y,45,45,null);
	    	}catch(Exception e){
		    	window.setColor(Color.RED);
		    	window.fillOval(x+15,y+15,15,15);
	    	}
		}

    }

     public void draw(Graphics window, int scale, int x, int y)
    {
    	window.setColor(Color.RED);
    	window.fillRect(x,y,scale-1,9*scale/45);
    	window.setColor(Color.GREEN);
    	window.fillRect(x,y,(int)((double)currentHealth/(double)(maxHealth)*(scale-1)),9*scale/45);
    	if(dead)
		{
			try{
	    		img = ImageIO.read(getClass().getResource("Dead.png"));
	    		window.drawImage(img,x,y,scale,scale,null);
	    		window.setColor(Color.BLACK);
	    		window.setFont(new Font("Britannic Bold", Font.PLAIN, 90));
	    		window.drawString("GAME OVER",65,300);
	    	}catch(Exception e){
		    	window.setColor(Color.RED);
		    	window.fillOval(x+15*scale/45,y+15*scale/45,15*scale/45,15*scale/45);
	    	}
		}
		else
		{
	    	try{
	    		img = ImageIO.read(getClass().getResource(type+"_"+direction+".png"));
	    		window.drawImage(img,x,y,scale,scale,null);
	    	}catch(Exception e){
		    	window.setColor(Color.RED);
		    	window.fillOval(x+15*scale/45,y+15*scale/45,15*scale/45,15*scale/45);
	    	}
		}
    }

    public void drawWithoutHealth(Graphics window, int scale, int x, int y)
    {
    	try{
    		img = ImageIO.read(getClass().getResource(type+"_"+direction+".png"));
    		window.drawImage(img,x,y,scale,scale,null);
    	}catch(Exception e){
	    	window.setColor(Color.RED);
	    	window.fillOval(x+15*scale/45,y+15*scale/45,15*scale/45,15*scale/45);
    	}
    }

    public String getType()
    {
    	return "Player";
    }

    public String toString()
    {
		return super.toString()+" damage: "+damage;
    }
}
