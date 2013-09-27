package main;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import tank.Enemy;
import tank.Hero;
import tank.weapon.Bullet;
import util.Constant;
import util.Panel;

public class GameMain extends KeyAdapter {

	private Panel p;
	private JFrame jf;
	private long  mills=0;

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}

	public Panel getP() {
		return p;
	}

	public void setP(Panel p) {
		this.p = p;
	}

	public static void main(String a[]) {
		GameMain g = new GameMain();
		g.jf.addKeyListener(g);

	}

	@Override
	public void keyPressed(KeyEvent key) {// ����panel���߳���˯��50�������ػ�������ֻҪ���ϸı�xy���о��ͻᶯ����
		// TODO Auto-generated method stub
		// super.keyPressed(key);
		// left 37,up 38,right 39,down 40,�ո�� 32
		
		long timeTemp = System.currentTimeMillis();
		
		Hero h1;
		Bullet b;
		if (key.getKeyCode() >= KeyEvent.VK_LEFT
				&& key.getKeyCode() <= KeyEvent.VK_DOWN) {
			this.getP().getH1().setDir(key.getKeyCode());
			this.getP().getH1().move();

		} else if (key.getKeyCode() == 32) {
			if (this.getP().getH1().getBullets().size() > 0&&((timeTemp-this.mills>500||this.mills==0))) {
				b = this.getP().getH1().getBullets().get(0);
				this.getP().getH1().shoot(0, Color.BLUE, 10, 5, 6);//����--�����ӵ�������
				this.getP().getHb().add(b);//���ӵ���ӵ�����
				this.getP().getH1().removeBullet(0);//���ӵ����ӵ����ó���
				this.p.getH1().getBullets().remove(0);
				this.mills=timeTemp;
			} else if(this.getP().getH1().getBullets().size()==0) {
				
				System.out.println("����û���ӵ���");
			}
		}else if(key.getKeyChar()=='u'||key.getKeyChar()=='U'){
			this.p.getH1().reloadBullet();
		}else if(key.getKeyChar()=='p'||key.getKeyChar()=='P'){//p||P�ǳ����˵�̹�˵�
			if(this.getP().getEnemyList().size()==0){//�ж�̹���ǲ��ǻ��� û�о�new ����
				for(int i = 0;i<Constant.getEnemyNum();i++){
					this.p.getEnemyList().add(new Enemy());
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
	}

	public GameMain() {
		// TODO Auto-generated constructor stub
		this.p = new Panel(Constant.getEnemyNum());
		this.jf = new JFrame();
		this.jf.setLayout(null);
		this.jf.add(this.p);
		this.jf.setVisible(true);
		this.jf.setSize(500, 500);
		this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jf.setBackground(Color.black);
		// this.jf.setResizable(false);
		new Thread(p).start();

	}

}
