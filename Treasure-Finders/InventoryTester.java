import static java.lang.System.*;
public class InventoryTester {

	public static void main(String[] args)
	{
		Inventory inv = new Inventory(7,4);

		inv.add(new Potato(),7);
		inv.add(new BrownKey(),20);
		inv.remove(5,2);
		inv.add(new TreasureChest(),5);
		out.println(inv);
	}

}
