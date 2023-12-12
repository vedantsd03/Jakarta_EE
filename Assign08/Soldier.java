package mypack;

public class Soldier {
	private Weapon weapon;

	Soldier(Weapon weapon) {
		this.weapon = weapon;
	}
	void perform()
	{
		weapon.attack();
	}
	
}
