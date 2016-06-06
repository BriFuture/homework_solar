package objs;

public class Planet {
	/**
	 * 质量
	 */
	protected double mass = 0;
	/**
	 * 星球半径
	 */
	protected double ridus = 0;
	/**
	 * 坐标 x
	 */
	protected double posX = 0;
	/**
	 * 坐标 y
	 */
	protected double posY = 0;
	/**
	 * 坐标 z
	 */
	protected double posZ = 0;

	/**
	 * x 方向的速度
	 */
	protected double speedX = 0;
	/**
	 * y 方向的速度
	 */
	protected double speedY = 0;
	
	
	
	/**
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}
	/**
	 * @param mass the mass to set
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}
	/**
	 * @return the ridus
	 */
	public double getRidus() {
		return ridus;
	}
	/**
	 * @param ridus the ridus to set
	 */
	public void setRidus(double ridus) {
		this.ridus = ridus;
	}
	/**
	 * @return the posX
	 */
	public double getPosX() {
		return posX;
	}
	/**
	 * @param posX the posX to set
	 */
	public void setPosX(double posX) {
		this.posX = posX;
	}
	/**
	 * @return the posY
	 */
	public double getPosY() {
		return posY;
	}
	/**
	 * @param posY the posY to set
	 */
	public void setPosY(double posY) {
		this.posY = posY;
	}
	/**
	 * @return the posZ
	 */
	public double getPosZ() {
		return posZ;
	}
	/**
	 * @param posZ the posZ to set
	 */
	public void setPosZ(double posZ) {
		this.posZ = posZ;
	}

	/**
	 * @return the speedX
	 */
	public double getSpeedX() {
		return speedX;
	}

	/**
	 * @param speedX the speedX to set
	 */
	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	/**
	 * @return the speedY
	 */
	public double getSpeedY() {
		return speedY;
	}

	/**
	 * @param speedY the speedY to set
	 */
	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	
	
}
