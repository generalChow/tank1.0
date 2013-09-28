package tank.weapon;

import java.awt.Rectangle;

import tank.Tank;
import util.Constant;

public class Bullet extends Weapon {
	private int speed;
	
	private String type;
	
	
	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getSpeed() { 
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public void move() {
		switch (this.getDir()) {
		case 37:
          this.setX(this.getX()-this.getSpeed());
			break;
		case 38:
          this.setY(this.getY()-this.getSpeed());
			break;
		case 39:
			this.setX(this.getX()+this.getSpeed());
			break;
		case 40:
			this.setY(this.getY()+this.getSpeed());
			break;


		default:
			break;
		}
	}
	/**
	 * 判断是不是越界了，若越界返回true
	 * @return
	 */
	public boolean Cross(){
		if(this.getX()>Constant.getPwithd()||this.getX()<0||this.getY()<0||this.getY()>Constant.getPhieght()){
			return true;
		}
		return false;
	}
	
	public boolean hitTank(Tank t){
		System.out.println("判断是不是击中坦克");
		if(this.getRectangle().intersects(t.getRectangle())){
			System.out.println("hit tank!");
			t.setLife(0);
			this.setUse(false);
		}
		return true;
	}
	public Rectangle getRectangle(){
		return new Rectangle(this.getX() , this.getY(), this.getR(), this.getR());
	}
}
