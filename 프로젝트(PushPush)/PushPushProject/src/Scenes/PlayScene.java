package Scenes;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Basic.Control;
import Basic.Model;
import Main.ProjectMain;

import org.newdawn.slick.Input;
import org.newdawn.slick.Image;

//���� PLAYSCENE�� ����� ���Ŀ� BASICSCENE�� ����� �ʿ��Ѻκи� ��ӹ޾� �����ϰ԰�ĥ ����.WHY?STAGE������ ���ؼ�.
public class PlayScene extends BasicGameState {
	StateBasedGame game;
	GameContainer gc;
	
	protected int ID; // BasicGameState�� ������ ���� ID
	
	private Control control=new Control();
	private Model model=new Model(); ;
	
	private Sound kenzi_feel;
	private Sound Excellent;

	private ArrayList<Circle> balls; // ������ �������� ����
	private ArrayList<Circle> balls_2; // �Ʒ��� �ö󰡴� ����
	
	private Image BackSpace;//���� �⺻���
	private Image PushLogo;// �����༺ �߰�
	private Image PushLogo1; // �� �߰�
	private Image Hero; // ���� ���� �ɸ���
	private Image Car; // ȭ��
	private Image Car_Destination; // ȭ�� ������
	private Image Continue; // herolife�� 0�̵Ǹ� ���
	private Image Feel;//�ñر� �̹��� ����
	private Image Feel2;//�ñر� �̹��� ����
	private Image Kenzy_Enerzy_0;//������ �� ����������.
	private Image Kenzy_Enerzy_1;
	private Image Kenzy_Enerzy_2;
	private Image Kenzy_Enerzy_3;//������ �ִ�ġ (���Ŀ� �ִϸ��̼����� �ٲܿ���.)
	
	private Random random;//balls ��ȯ�ϱ� ���� random�Լ�.
	
	private int TimePassed; // �ð� ����
	long starttime = System.currentTimeMillis();//���� ���۽ð�
	long endtime; //�����½ð�

	long starttime1;//�ñر� ���۽ð�
	long endtime1; //�ñرⳡ���½ð�
    
    public PlayScene(){
		
	}
	public PlayScene(int id){
		this.ID = id;//ID����
	}
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		game = arg1;
		gc = arg0;
		//�ʱ� ��ǥ������
		model.setHero_x_y(950,200);
		model.setCar_x_y(900,200);
		model.setCar_Des_x_y(30,450);
		model.setMenu_x_y(1100,50);
		//�Ҹ�����
		kenzi_feel = new Sound("sounds/kenzi_feel.wav");
		Excellent = new Sound("sounds/excellent.wav");
		//�̹��� ����
		Hero = new Image("rsc/kenzi.png");
		BackSpace = new Image("rsc/BackPlay.png"); //���ȭ��
		PushLogo = new Image("rsc/PushLogo.png");  
		PushLogo1 = new Image("rsc/PushLogo1.png");
		Car = new Image("rsc/Logo.png");
		Car_Destination = new  Image("rsc/Logo_Destination.png");
		Continue = new Image("rsc/Continue.png");
		Feel = new Image("rsc/kenzi_feel.png");
		Feel2 = new Image("rsc/kenzi_feel2.png");
		Kenzy_Enerzy_0 = new Image("rsc/kenzi_energy_0.png");
		Kenzy_Enerzy_1 = new Image("rsc/kenzi_energy_1.png");
		Kenzy_Enerzy_2 = new Image("rsc/kenzi_energy_2.png");
		Kenzy_Enerzy_3 = new Image("rsc/kenzi_energy_3.png");
		//�̹��� ���� ����
		balls = new ArrayList<Circle>();  //������ �������� balls
		balls_2 = new ArrayList<Circle>(); //�Ʒ��� �ö󰡴� balls
		TimePassed = 0;
		random = new Random(); //�������� �� ��ȯ�ϱ����Ͽ�
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		//�̹��� ����
		BackSpace.draw(0,0,ProjectMain._width,ProjectMain._height);//�⺻ ������
		PushLogo.draw(870,170,180,180);//Car ��� �չٴ�
		PushLogo1.draw(10,420,120,120);//Car ������ �չٴ�
		Car.draw(model.getCar_x(),model.getCar_y(),60,60);
		Hero.draw(model.getHero_x(),model.getHero_y(),80,60);
		Car_Destination.draw(model.getCar_Des_x(),model.getCar_Des_y(),60,60);
		//�̹��� ��
		//�޴�ȭ�� �����Ѿ�� �κ�
		g.setColor(Color.white);//���� ���� ��� ����
		g.drawString("STAGE 2", model.getMenu_x(), model.getMenu_y());
		g.drawString("Your ID : "+ProjectMain._name, model.getMenu_x(), model.getMenu_y()+40);
		g.drawString("TIME : "+endtime, model.getMenu_x(), model.getMenu_y()+80);
		g.drawString("SCORE : "+(ProjectMain.score/100), model.getMenu_x(), model.getMenu_y()+120);
		g.drawString("Life : "+model.getHeroLife(), model.getMenu_x(), model.getMenu_y()+160);
		if(model.getHeroLife()>=3){Kenzy_Enerzy_3.draw(model.getMenu_x()-15,model.getMenu_y()+220,200,200);}
		if(model.getHeroLife()==2){Kenzy_Enerzy_2.draw(model.getMenu_x()-15,model.getMenu_y()+220,200,200);}
		if(model.getHeroLife()==1){Kenzy_Enerzy_1.draw(model.getMenu_x()-15,model.getMenu_y()+220,200,200);}
		if(model.getHeroLife()<=0){Kenzy_Enerzy_0.draw(model.getMenu_x()-15,model.getMenu_y()+220,200,200);}
		//���Ŀ� �ִϸ��̼����� ����� ������.
		//�޴�ȭ�� ���� ��
		
		model.set_pos_x_y(Mouse.getX(), Mouse.getY());//���콺 X,Y��ǥ
		g.drawString("x "+model.getPos_x()+"y"+model.getPos_y(), model.getMenu_x(), 710);//���콺 ��ǥ ��� why?(�̹��� �Ѹ��� ���� ��ǥã��)
		g.drawString("Hero_x "+model.getHero_x()+"Hero_y"+model.getHero_y(), model.getMenu_x(), 750);
		
		for(Circle c : balls){
			g.fill(c);
		}
		for(Circle c2 : balls_2){
			g.fill(c2);
		}
		if(model.getHeroLife()<=0){
			Continue.draw(250,200,700,250); //����Ͻðڽ��ϱ� ���
			Input input = arg0.getInput(); //Ű�Է¹ޱ� Y�� ������3���� ������ ���� N�̸� �޴�ȭ�� �ǵ��ư�.
			if(input.isKeyDown(Input.KEY_Y)){model.setHeroLife(3);}
			if(input.isKeyDown(Input.KEY_N)){game.enterState(ProjectMain._Menu);}
		}
		//heroLife 1�϶� �ñر� ��밡��
		if(model.getHeroLife()==1){
			Input input = arg0.getInput();
			if(input.isKeyDown(Input.KEY_SPACE)){//space������ �ñر� �ߵ�
				starttime1=System.currentTimeMillis();
				kenzi_feel.play();
				model.trueFeel();model.setHero_v(2);model.setCar_v(2);}//�ñر�� �ӵ��� ������
			if(model.getFeel()){
				if((endtime1-starttime1)/10<50)
				Feel.draw(model.getHero_x()-20, model.getHero_y()-40,100,100);//�ñر� �׸� ���
				if((endtime1-starttime1)/10>200)
					Feel2.draw(model.getHero_x()-10, model.getHero_y()-10,110,80);//�ñر� �׸� ���
				if((endtime1-starttime1)/10>800){//8�ʵڿ� �ñر� �Ҹ�
					model.falseFeel();
					model.setHero_v(1);model.setCar_v(1);//���� �ӵ��� ���ƿ�.
			}
			}
		}
	}
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
		// TODO Auto-generated method stub
		//����ȭ�� �ٸ��ֱ� ���� update
		//�ɸ��ð� üũ
		if((model.getHeroLife()>0)){
		endtime = System.currentTimeMillis();//���ӽð�
		endtime1 = System.currentTimeMillis();//�ñر� �ð�
		endtime = (endtime-starttime)/1000;
		ProjectMain.score-=endtime/5;}
		
		// ���� �ɸ��� �Է°�.
		// ���� �ٸ��ֱ� ��.
		// Ű�Է¹ޱ� ����
		Input input = arg0.getInput();
		control.controller(input,model);
	        //��Ÿ����� ���� �̿��Ͽ� �ε�������� �������ų� ȭ���̵��Ҽ��ֵ��� ������.
	        float Hero_Car = model.Target(model.getHero_x(),model.getHero_y(), model.getCar_x(),model.getCar_y());//������ ȭ���� ����Ÿ�
	        float Hero_Car_Max = model.Target_Max(25,25);//������ ȭ���� �ִ�Ÿ�
	       control.controller_car(input, model, Hero_Car, Hero_Car_Max);//ȭ�� ��Ʈ��
	       //ȭ����� �Ϸ�
	        float Car_Des_Car = model.Target(model.getCar_Des_x(),model.getCar_Des_y(),model.getCar_x(),model.getCar_y());//ȭ���� �������� ����Ÿ�
	        float Car_Des_Car_Max = model.Target_Max(25,25);//ȭ���� ���������� �ִ�Ÿ�
	        
	        float Ball_Max = model.Target_Max(15,15);//���� �ɸ��Ͱ��� �ִ�Ÿ�
	        
	        
	        TimePassed += arg2;
	        if(TimePassed > 500){
	        	TimePassed = 0;
	        	balls.add(new Circle(20+random.nextInt(880),0,10)); //X�� �� 200���� 700����. �����ϰ� BALL���
	        	balls_2.add(new Circle(20+random.nextInt(880),630,10));
	        }
	        //Y���� �����ϴ� ��
	        for(Circle c: balls){
	        	c.setCenterY(c.getCenterY()+(arg2/5));
	        }
	        //Y���� �������� ��.
	        for(Circle c2: balls_2){
	        	c2.setCenterY(c2.getCenterY()-(arg2/5));
	        }
	        
	        for(int i=balls.size()-1;i>= 0; i--){
	        	Circle c = balls.get(i);
	        	float e = model.Target(model.getHero_x(),model.getHero_y(),c.getX(), c.getY());//���� �������� �Ÿ�
	        	//Y�� Ư���̻��̸� ����
	        	if(c.getCenterY()>610){
	        		balls.remove(i);
	        		
	        	}else if(e<Ball_Max){//�����ɸ��Ϳ� �ε����� BALL�Ҹ�
	        		balls.remove(i);
	        		if(model.getFeel()!=true)//�ñر� ���°� �ƴϸ�
	        		model.minusHeroLife();
	        		ProjectMain.score-=10000; //heroLife���̸� ���� 100�� ����.
	        	}
	        	
	        }
	        
	        for(int i=balls_2.size()-1;i>= 0; i--){
	        	Circle c2 = balls_2.get(i);
	        	float f1 = model.Target(model.getHero_x(),model.getHero_y(),c2.getX(), c2.getY());//���� �������� �Ÿ�
	        	if(c2.getCenterY()<10){
	        		balls_2.remove(i);
	        		
	        	}else if(f1<Ball_Max){
	        		balls_2.remove(i);
	        		if(model.getFeel()!=true)//�ñر� ���°� �ƴϸ�
	        			model.minusHeroLife();
	        	}
	        }
	        
	        if(Car_Des_Car<Car_Des_Car_Max){//���� CAR�� CAR_������ ��ԵǸ� CAR�� ���ڸ� ����ϰԲ� ����.
	        	model.setCar_x_y(model.getCar_Des_x(),model.getCar_Des_y());//�������� ȭ���� ��.
	        	Car_Destination.getGraphics();//�����մ� ������ ������
	        	Excellent.play();
	        	ProjectMain.play_bg.stop();//�÷������� ����
	        	ProjectMain.bg_ex.loop();//�������� ����
	        	game.enterState(ProjectMain._Exe1);//������������ �Ѿ.
	        }
	        //���콺 Ŭ��ȿ�� ����.
	        //����� Ŭ���� �ʱ� ��ġ�� �̵�
	        if((model.getPos_x()>440&&model.getPos_x()<530)&&(model.getPos_y()>37&&model.getPos_y()<69)){
				if(input.isMouseButtonDown(0)){//0�� ���콺 ���� Ŭ���ǹ�
					model.setHero_x_y(950,200);
					model.setCar_x_y(900,200);
				}
			}
	        //������ ȭ��ǥ Ŭ���� �������� ����
	        if((model.getPos_x()>344&&model.getPos_x()<410)&&(model.getPos_y()>16&&model.getPos_y()<77)){
				if(input.isMouseButtonDown(0)){//0�� ���콺 ���� Ŭ���ǹ�
					game.enterState(ProjectMain._Play1);//�������ӳѾ.
				}
			}
	        //?�޴� Ŭ���� ���Ӿȳ������� �Ѿ.
	        if((model.getPos_x()>564&&model.getPos_x()<620)&&(model.getPos_y()>16&&model.getPos_y()<86)){
				if(input.isMouseButtonDown(0)){//0�� ���콺 ���� Ŭ���ǹ�
					ProjectMain.play_bg.stop();//�÷������� ����
		        	ProjectMain.bg_ex.loop();//�������� ����
					game.enterState(ProjectMain._Exe);//���Ӿȳ������� �Ѿ.
				}
			}
	        //�ǿ��� �޴�Ŭ���� ����ȭ������ �̵���.
	        if((model.getPos_x()>667&&model.getPos_x()<744)&&(model.getPos_y()>10&&model.getPos_y()<80)){
				if(input.isMouseButtonDown(0)){//0�� ���콺 ���� Ŭ���ǹ�
					ProjectMain.play_bg.stop();//�÷������� ����
					ProjectMain.bg_music.loop();//���γ뷡 ����.
					game.enterState(ProjectMain._Menu);//�޴�ȭ������ �Ѿ.
				}
			}

	}

	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
	//F1Ű ������ �ٷθ���ȭ�� ���������� ����. ���� ������ ����.
	public void keyReleased(int key, char c){
		switch(key){
		case Input.KEY_F1:
			game.enterState(ProjectMain._Menu);
			break;
		}
	}
}
