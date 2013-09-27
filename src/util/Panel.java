package util;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import tank.Enemy;
import tank.Hero;
import tank.Tank;
import tank.weapon.Bullet;

public class Panel extends JPanel implements Runnable {
	
	private Hero h1;
	private List<Bullet> hb;//英雄的子弹
	private List<Enemy> enemyList;//敌军坦克
	
	
	
	
	public List<Enemy> getEnemyList() {
		return enemyList;
	}

	public void setEnemyList(List<Enemy> enemyList) {
		this.enemyList = enemyList;
	}

	public List<Bullet> getHb() {
		return hb;
	}

	public void setHb(List<Bullet> hb) {
		this.hb = hb;
	}

	public Hero getH1() {
		return h1;
	}

	public void setH1(Hero h1) {
		this.h1 = h1;
	}



	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		drawHero(g, h1);
		drawBullet(g);
	    drawEnemies(g);
	}
	
	public void drawHero(Graphics g,Tank h){
		
		g.setColor(h.getColor());
				switch(h.getDir()){
				case 38://方向向上
					g.fill3DRect(h.getX(), h.getY(), 5, 30, false);
					g.fill3DRect(h.getX()+15, h.getY(), 5, 30, false);
					g.fill3DRect(h.getX()+5, h.getY()+5, 10, 20, false);
					g.fillOval(h.getX()+6, h.getY()+11, 8, 8);
					g.drawLine(h.getY()+10, h.getY()+15, h.getX()+10, h.getY());
					break;
				case 39://right
					g.fill3DRect(h.getX(), h.getY(), 30, 5, false);
					g.fill3DRect(h.getX(), h.getY()+15, 30, 5, false);
					g.fill3DRect(h.getX()+5, h.getY()+5, 20, 10, false);
					g.fillOval(h.getX()+11, h.getY()+6, 8, 8);
					g.drawLine(h.getX()+15, h.getY()+10, h.getX()+30, h.getY()+10);
					break;
				case 40://down
					g.fill3DRect(h.getX(), h.getY(), 5, 30, false);
					g.fill3DRect(h.getX()+15, h.getY(), 5, 30, false);
					g.fill3DRect(h.getX()+5, h.getY()+5, 10, 20, false);
					g.fillOval(h.getX()+6, h.getY()+11, 8, 8);
					g.drawLine(h.getX()+10, h.getY()+15, h.getX()+10, h.getY()+30);
					break;
				case 37://left
					g.fill3DRect(h.getX(), h.getY(), 30, 5, false);
					g.fill3DRect(h.getX(), h.getY()+15, 30, 5, false);
					g.fill3DRect(h.getX()+5, h.getY()+5, 20, 10, false);
					g.fillOval(h.getX()+11, h.getY()+6, 8, 8);
					g.drawLine(h.getX()+15, h.getY()+10, h.getX(), h.getY()+10);
					break;
					default:
						break;
				}
	}
	
	public void drawBullet(Graphics g){
		
		if(this.hb.size()>0){
			Bullet b ;
			g.setColor(Color.BLUE);
			for(int i = 0;i<this.hb.size();i++){
				b = this.hb.get(i);
			g.fill3DRect(b.getX(), b.getY(), b.getR(), b.getR(), false);
			
			}
		}
	}
	
	
	public void drawEnemies(Graphics g){
		setEnemiesXAY();//设置下一秒 敌军坦克xy
		Enemy e ;
		for(int i =0;i<this.enemyList.size();i++){
			e = this.enemyList.get(i);
			drawHero(g, e);
		}
	}
	

	public Panel(int enemyNum) {
		// TODO Auto-generated constructor stub
		this.h1 =  new Hero(0, 0, 38,3,Color.CYAN);
		this.setSize(Constant.getPwithd(), Constant.getPhieght());
		this.setBackground(Color.black);
		System.out.println(this.getHeight());
		this.hb = new ArrayList<Bullet>();
		this.enemyList = new ArrayList<Enemy>();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			try {
				Thread.sleep(50);
				for(int i=0;i<hb.size();i++){
					hb.get(i).move();
					if(hb.get(i).Cross()){
						hb.remove(hb.get(i));
						//System.out.println("删除一课子弹");
						//System.out.println("还剩下"+hb.size());
					}
				}
				
				repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 设置run之后的敌军各个坦克的方向
	 */
	private void setEnemiesXAY() {
		// TODO Auto-generated method stub
		for(int i = 0;i<this.enemyList.size();i++){
			this.enemyList.get(i).move();
		}
	}
}
