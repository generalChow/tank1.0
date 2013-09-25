package tank;

import java.util.ArrayList;
import java.util.List;

import tank.weapon.Bullet;
import util.Constant;

public class Hero extends Tank {

	private List<Bullet> bullets = new ArrayList<Bullet>();

	public List<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(List<Bullet> bullets) {
		this.bullets = bullets;
	}

	@Override
	public void shoot(int x, int y, int dir) {
		// TODO Auto-generated method stub
		super.shoot(x, y, dir);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
//		int x = this.getX();
//		int y = this.getY();
		if (this.Cross()) {
			if (this.getX() < 0 && this.getDir() == Constant.getLeft()) {
				return;
			} else if (this.getX() > (Constant.getPwithd()-30)
					&& this.getDir() == Constant.getRight()) {
				System.out.println("sjs");
				return;
			} else if (this.getY() < 0 && this.getDir() == Constant.getUp()) {
				return;
			} else if (this.getY() > (Constant.getPhieght() - 10)
					&& this.getDir() == Constant.getDown()) {
				return;
			}
		}
		switch (this.getDir()) {
		case 37:
			this.setX(this.getX() - this.getSpeed());
			break;
		case 38:
			this.setY(this.getY() - this.getSpeed());
			break;
		case 39:
			this.setX(this.getX() + this.getSpeed());
			break;
		case 40:
			this.setY(this.getY() + this.getSpeed());
			break;

		default:
			break;
		}
//		if(this.Cross()){
//		  this.setX(x);
//		  this.setY(y);
//		}
	}

	public void reloadBullet() {
		for (int i = 0; i < 20; i++) {
			Bullet b = new Bullet();
			this.bullets.add(b);
		}
	}

	public Hero(int x, int y, int dir, int speed) {
		// TODO Auto-generated constructor stub
		this.setX(x);
		this.setY(y);
		this.setDir(dir);
		this.setSpeed(speed);
		for (int i = 0; i < 20; i++) {
			Bullet b = new Bullet();
			this.bullets.add(b);
		}
	}

}
