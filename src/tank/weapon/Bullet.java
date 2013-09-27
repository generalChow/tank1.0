package tank.weapon;

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
}
