package tank;

import util.Constant;

public class Tank {

	private int x;
	private int y;
	private int dir;
	private int life;
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void move() {

	}

	public void shoot(int x, int y, int dir) {

	}

	public void dead() {

	}
	/**
	 * 判断是不是越界了，若越界返回true
	 * @return
	 */
	public boolean Cross() {
		if (this.getX() > (Constant.getPwithd()-30) || this.getX() < 0
				|| this.getY() < 0 || this.getY() >( Constant.getPhieght()-30)) {
			return true;
		}
		return false;
	}
}
