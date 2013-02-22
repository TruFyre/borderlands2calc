package cmd.borderLands2Calc;

public class Calculator {
	
	
//	This method calculates the dps of a weapon without consideration of reload times.
	public float dps(float damage, float fireRate)
	throws IllegalArgumentException
	{
		float dps = 0;
		
		if(damage < 0 || fireRate < 0){
			throw new IllegalArgumentException("One or more arguments were less than zero.");
		}
		
		dps = damage * fireRate;
		
		return dps;
		
	}
	
/*	This method calculates the dps of a weapon while also considering time spent reloading.  It gives a more accurate picture of how much damage you will do
	from clip to clip.
*/	
	public float trueDps(float damage, float fireRate, float reloadTime, float clipSize, float ammoPerShot)
	throws IllegalArgumentException
	{
		
		if (ammoPerShot <= 0 || fireRate <= 0){
			throw new IllegalArgumentException("Divide by zero error.  One or more divisors were zero.");
		}
		
		if(damage < 0 || fireRate < 0 || reloadTime < 0 || clipSize < 0 || ammoPerShot < 0){
			throw new IllegalArgumentException("One or more arguments were less than zero.");
		}
		
		float dps = 0;
		
		//Some weapons use more than one unit of ammo per round.  We need to see how many times the weapon can actually fire before making any other calculation.
		float numberOfShots = clipSize / ammoPerShot;
		
		//first you need an idea of how much damage can be done by what's in the magazine.  I'm calling this the total damage potential.
		float damagePotential = damage*numberOfShots;
		
		//then, you need an idea of how long it takes to empty the magazine and reload.  I'm calling this the total fire-cycle time.
		float totalFireCycleTime = numberOfShots/fireRate + reloadTime;
		
		//finally, you divide the total potential damage by the total fire-cycle time.
		dps = damagePotential / totalFireCycleTime;
		
		return dps;
	}

}
