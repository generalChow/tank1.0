/**
 * 
 */
package tank;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tank.weapon.Bullet;
import util.Constant;

/**
 * @author �ܴ�˧
 *
 * @email 463734522@qq.com
 * 2013��9��27��
 */
public class Enemy extends Tank{
	
	private int speed;
	
	private List<Bullet> bullets = new ArrayList<Bullet>();
	
	

	public List<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(List<Bullet> bullets) {
		this.bullets = bullets;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/* (non-Javadoc)
	 * @see tank.Tank#move()
	 */
	@Override
	public void move() {
		// TODO Auto-generated method stub
		Random ran = new Random();
		int rate = ran.nextInt(10);
		if(rate<1){//�����ȡ�ǲ�����Ҫ�ı䷽�� 10%��Ҫ��
		int num = ran.nextInt(4);
		this.setDir(num+37);
		}
		//System.out.println(this.toString()+":"+num);
		if (this.Cross()) {
			if (this.getX() < 0 && this.getDir() == Constant.getLeft()) {
				return;
			} else if (this.getX() > (Constant.getPwithd()-30)
					&& this.getDir() == Constant.getRight()) {
				
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
	}
	
	/**
	 * 
	 */
	public Enemy() {
		// TODO Auto-generated constructor stub
		Random ran =  new Random();
		int x = ran.nextInt(400);
		int y = ran.nextInt(200);
		this.setColor(Color.YELLOW);
		this.speed=3;
		this.setDir(Constant.getDown());
		this.setX(x);
		this.setY(y);
		this.setLife(100);
		this.setR(30);
		
	}
	
	public void shoot(int index,Color color,int power,int r,int speed){
		Bullet b = this.bullets.get(index);
		b.setDir(this.getDir());
		b.setX(this.getX());
		b.setY(this.getY());
		b.setPower(power);
		b.setR(r);
		b.setType("hero");
		b.setColor(color);
		b.setSpeed(speed);
	}
	/**
	 * ��Ҫ�Ǹ��о�ʹ�õ�
	 * @param b
	 * @param color
	 * @param power
	 * @param r
	 * @param speed
	 * @return
	 */
	public Bullet shootOne(Bullet b,Color color,int power,int r,int speed){
		b.setDir(this.getDir());
		b.setX(this.getX());
		b.setY(this.getY());
		b.setPower(power);
		b.setR(r);
		b.setType("enemy");
		b.setSpeed(speed);
		b.setColor(color);
		b.setUse(true);
		return b;
	}
	
	public boolean isFire(){
		//System.out.println("�ж��ǲ��Ƿ����ӵ�");
		Random ran = new Random();
		int num = ran.nextInt(10);
		if(num<1){
		//	System.out.println("�����ӵ�");
		return true;
		}else{
			return false;
		}
	}
	
	
	

}
