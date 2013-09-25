package tank.weapon;

public class Weapon {

	private int x;
	private int y;
	private int power;
	private boolean use;
	private int dir;
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	private int r;//¹¥»÷·¶Î§
	
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public boolean isUse() {
		return use;
	}
	public void setUse(boolean use) {
		this.use = use;
	}
	
}
