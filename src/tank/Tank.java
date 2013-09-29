package tank;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import tank.message.Message;
import util.Constant;

public class Tank {

	private int x;
	private int y;
	private int dir;
	private int life;
	private int speed;
	private Color color;
	private int r;// 遭受攻击的范围
	private Message message;// 接收坦克外部的信息

	public void setMessage(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

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

	public void shoot() {

	}

	public void dead() {

	}

	/**
	 * 判断是不是越界了，若越界返回true
	 * 
	 * @return
	 */
	public boolean Cross() {
		if (this.getX() > (Constant.getPwithd() - 30) || this.getX() < 0
				|| this.getY() < 0
				|| this.getY() > (Constant.getPhieght() - 30)) {
			return true;
		}
		return false;
	}

	public Rectangle getRectangle() {
		return new Rectangle(this.getX(), this.getY(), this.getR(), this.getR());
	}

	public void recevieOtherTankMessage(List<Tank> tankList) {
		this.message.setOtherTankList(tankList);
	}

	/**
	 * 返回可以移动的方向 用整型表示
	 * 还没写好·
	 * @return
	 */
	public List<Integer> getMoveDir() {
		List<Integer> dirs = new ArrayList<Integer>();
		if (this.getMessage().getOtherTankList().size() == 0) {
			dirs.add(Constant.getDown());
			dirs.add(Constant.getUp());
			dirs.add(Constant.getLeft());
			dirs.add(Constant.getRight());
		} else {
			Tank t ;
			for (int i = 0; i < this.getMessage().getOtherTankList().size(); i++) {
				t = this.getMessage().getOtherTankList().get(i);
				if(this.getRectangle().intersects(t.getRectangle())){
					if(this.getX()<t.getX()){
						dirs.add(Constant.getRight());
					}
				}
			}
		}
		return dirs;
	}

}
