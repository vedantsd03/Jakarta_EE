package mypack;

public class Gun implements Weapon{

	@Override
	public void attack() {
		System.out.println("Gun is empty i need ammo..!");
	}
	
}
