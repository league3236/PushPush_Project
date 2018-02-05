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

//먼저 PLAYSCENE을 만들고 추후에 BASICSCENE을 만들어 필요한부분만 상속받아 간단하게고칠 예정.WHY?STAGE나누기 위해서.
public class PlayScene extends BasicGameState {
	StateBasedGame game;
	GameContainer gc;
	
	protected int ID; // BasicGameState로 들어오기 위한 ID
	
	private Control control=new Control();
	private Model model=new Model(); ;
	
	private Sound kenzi_feel;
	private Sound Excellent;

	private ArrayList<Circle> balls; // 위에서 떨어지는 공들
	private ArrayList<Circle> balls_2; // 아래서 올라가는 공들
	
	private Image BackSpace;//게임 기본배경
	private Image PushLogo;// 지구행성 추가
	private Image PushLogo1; // 달 추가
	private Image Hero; // 게임 메인 케릭터
	private Image Car; // 화물
	private Image Car_Destination; // 화물 목적지
	private Image Continue; // herolife가 0이되면 출력
	private Image Feel;//궁극기 이미지 띄우기
	private Image Feel2;//궁극기 이미지 띄우기
	private Image Kenzy_Enerzy_0;//에너지 다 떨어졌을때.
	private Image Kenzy_Enerzy_1;
	private Image Kenzy_Enerzy_2;
	private Image Kenzy_Enerzy_3;//에너지 최대치 (추후에 애니메이션으로 바꿀예정.)
	
	private Random random;//balls 소환하기 위한 random함수.
	
	private int TimePassed; // 시간 지정
	long starttime = System.currentTimeMillis();//게임 시작시간
	long endtime; //끝나는시간

	long starttime1;//궁극기 시작시간
	long endtime1; //궁극기끝나는시간
    
    public PlayScene(){
		
	}
	public PlayScene(int id){
		this.ID = id;//ID지정
	}
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		game = arg1;
		gc = arg0;
		//초기 좌표값지정
		model.setHero_x_y(950,200);
		model.setCar_x_y(900,200);
		model.setCar_Des_x_y(30,450);
		model.setMenu_x_y(1100,50);
		//소리지정
		kenzi_feel = new Sound("sounds/kenzi_feel.wav");
		Excellent = new Sound("sounds/excellent.wav");
		//이미지 지정
		Hero = new Image("rsc/kenzi.png");
		BackSpace = new Image("rsc/BackPlay.png"); //배경화면
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
		//이미지 정의 종료
		balls = new ArrayList<Circle>();  //위에서 내려오는 balls
		balls_2 = new ArrayList<Circle>(); //아래서 올라가는 balls
		TimePassed = 0;
		random = new Random(); //랜덤으로 볼 소환하기위하여
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		//이미지 관리
		BackSpace.draw(0,0,ProjectMain._width,ProjectMain._height);//기본 배경출력
		PushLogo.draw(870,170,180,180);//Car 출발 손바닥
		PushLogo1.draw(10,420,120,120);//Car 목적지 손바닥
		Car.draw(model.getCar_x(),model.getCar_y(),60,60);
		Hero.draw(model.getHero_x(),model.getHero_y(),80,60);
		Car_Destination.draw(model.getCar_Des_x(),model.getCar_Des_y(),60,60);
		//이미지 끝
		//메뉴화면 구성넘어가는 부분
		g.setColor(Color.white);//글자 색상 흰색 지정
		g.drawString("STAGE 2", model.getMenu_x(), model.getMenu_y());
		g.drawString("Your ID : "+ProjectMain._name, model.getMenu_x(), model.getMenu_y()+40);
		g.drawString("TIME : "+endtime, model.getMenu_x(), model.getMenu_y()+80);
		g.drawString("SCORE : "+(ProjectMain.score/100), model.getMenu_x(), model.getMenu_y()+120);
		g.drawString("Life : "+model.getHeroLife(), model.getMenu_x(), model.getMenu_y()+160);
		if(model.getHeroLife()>=3){Kenzy_Enerzy_3.draw(model.getMenu_x()-15,model.getMenu_y()+220,200,200);}
		if(model.getHeroLife()==2){Kenzy_Enerzy_2.draw(model.getMenu_x()-15,model.getMenu_y()+220,200,200);}
		if(model.getHeroLife()==1){Kenzy_Enerzy_1.draw(model.getMenu_x()-15,model.getMenu_y()+220,200,200);}
		if(model.getHeroLife()<=0){Kenzy_Enerzy_0.draw(model.getMenu_x()-15,model.getMenu_y()+220,200,200);}
		//추후에 애니매이션으로 만들까 구상중.
		//메뉴화면 구성 끝
		
		model.set_pos_x_y(Mouse.getX(), Mouse.getY());//마우스 X,Y좌표
		g.drawString("x "+model.getPos_x()+"y"+model.getPos_y(), model.getMenu_x(), 710);//마우스 좌표 출력 why?(이미지 뿌리기 위해 좌표찾기)
		g.drawString("Hero_x "+model.getHero_x()+"Hero_y"+model.getHero_y(), model.getMenu_x(), 750);
		
		for(Circle c : balls){
			g.fill(c);
		}
		for(Circle c2 : balls_2){
			g.fill(c2);
		}
		if(model.getHeroLife()<=0){
			Continue.draw(250,200,700,250); //계속하시겠습니까 출력
			Input input = arg0.getInput(); //키입력받기 Y면 라이프3으로 세팅후 실해 N이면 메뉴화면 되돌아감.
			if(input.isKeyDown(Input.KEY_Y)){model.setHeroLife(3);}
			if(input.isKeyDown(Input.KEY_N)){game.enterState(ProjectMain._Menu);}
		}
		//heroLife 1일때 궁극기 사용가능
		if(model.getHeroLife()==1){
			Input input = arg0.getInput();
			if(input.isKeyDown(Input.KEY_SPACE)){//space누르면 궁극기 발동
				starttime1=System.currentTimeMillis();
				kenzi_feel.play();
				model.trueFeel();model.setHero_v(2);model.setCar_v(2);}//궁극기시 속도도 빨라짐
			if(model.getFeel()){
				if((endtime1-starttime1)/10<50)
				Feel.draw(model.getHero_x()-20, model.getHero_y()-40,100,100);//궁극기 그림 출력
				if((endtime1-starttime1)/10>200)
					Feel2.draw(model.getHero_x()-10, model.getHero_y()-10,110,80);//궁극기 그림 출력
				if((endtime1-starttime1)/10>800){//8초뒤에 궁극기 소모
					model.falseFeel();
					model.setHero_v(1);model.setCar_v(1);//원래 속도로 돌아옴.
			}
			}
		}
	}
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
		// TODO Auto-generated method stub
		//메인화면 꾸며주기 위한 update
		//걸린시간 체크
		if((model.getHeroLife()>0)){
		endtime = System.currentTimeMillis();//게임시간
		endtime1 = System.currentTimeMillis();//궁극기 시간
		endtime = (endtime-starttime)/1000;
		ProjectMain.score-=endtime/5;}
		
		// 메인 케릭터 입력값.
		// 메인 꾸며주기 끝.
		// 키입력받기 시작
		Input input = arg0.getInput();
		control.controller(input,model);
	        //피타고라스의 정리 이용하여 부딪히면공이 없어지거나 화물이동할수있도록 설정함.
	        float Hero_Car = model.Target(model.getHero_x(),model.getHero_y(), model.getCar_x(),model.getCar_y());//영웅과 화물의 현재거리
	        float Hero_Car_Max = model.Target_Max(25,25);//영웅과 화물의 최대거리
	       control.controller_car(input, model, Hero_Car, Hero_Car_Max);//화물 컨트롤
	       //화물운송 완료
	        float Car_Des_Car = model.Target(model.getCar_Des_x(),model.getCar_Des_y(),model.getCar_x(),model.getCar_y());//화물과 도착지의 현재거리
	        float Car_Des_Car_Max = model.Target_Max(25,25);//화물과 도착지간의 최대거리
	        
	        float Ball_Max = model.Target_Max(15,15);//공과 케릭터간의 최대거리
	        
	        
	        TimePassed += arg2;
	        if(TimePassed > 500){
	        	TimePassed = 0;
	        	balls.add(new Circle(20+random.nextInt(880),0,10)); //X의 값 200부터 700사이. 렌덤하게 BALL출력
	        	balls_2.add(new Circle(20+random.nextInt(880),630,10));
	        }
	        //Y값이 증가하는 공
	        for(Circle c: balls){
	        	c.setCenterY(c.getCenterY()+(arg2/5));
	        }
	        //Y값이 떨어지는 공.
	        for(Circle c2: balls_2){
	        	c2.setCenterY(c2.getCenterY()-(arg2/5));
	        }
	        
	        for(int i=balls.size()-1;i>= 0; i--){
	        	Circle c = balls.get(i);
	        	float e = model.Target(model.getHero_x(),model.getHero_y(),c.getX(), c.getY());//공과 영웅간의 거리
	        	//Y값 특정이상이면 제거
	        	if(c.getCenterY()>610){
	        		balls.remove(i);
	        		
	        	}else if(e<Ball_Max){//메인케릭터와 부딪히면 BALL소멸
	        		balls.remove(i);
	        		if(model.getFeel()!=true)//궁극기 상태가 아니면
	        		model.minusHeroLife();
	        		ProjectMain.score-=10000; //heroLife깍이면 점수 100점 감점.
	        	}
	        	
	        }
	        
	        for(int i=balls_2.size()-1;i>= 0; i--){
	        	Circle c2 = balls_2.get(i);
	        	float f1 = model.Target(model.getHero_x(),model.getHero_y(),c2.getX(), c2.getY());//공과 영웅간의 거리
	        	if(c2.getCenterY()<10){
	        		balls_2.remove(i);
	        		
	        	}else if(f1<Ball_Max){
	        		balls_2.remove(i);
	        		if(model.getFeel()!=true)//궁극기 상태가 아니면
	        			model.minusHeroLife();
	        	}
	        }
	        
	        if(Car_Des_Car<Car_Des_Car_Max){//만약 CAR와 CAR_목적지 닿게되면 CAR가 그자리 대신하게끔 만듬.
	        	model.setCar_x_y(model.getCar_Des_x(),model.getCar_Des_y());//목적지에 화물이 들어감.
	        	Car_Destination.getGraphics();//원래잇던 목적지 덮어씌우기
	        	Excellent.play();
	        	ProjectMain.play_bg.stop();//플레이음악 중지
	        	ProjectMain.bg_ex.loop();//설명음악 시작
	        	game.enterState(ProjectMain._Exe1);//다음게임으로 넘어감.
	        }
	        //마우스 클릭효과 설정.
	        //비행기 클릭시 초기 위치로 이동
	        if((model.getPos_x()>440&&model.getPos_x()<530)&&(model.getPos_y()>37&&model.getPos_y()<69)){
				if(input.isMouseButtonDown(0)){//0은 마우스 왼쪽 클릭의미
					model.setHero_x_y(950,200);
					model.setCar_x_y(900,200);
				}
			}
	        //오른쪽 화살표 클릭시 다음게임 진행
	        if((model.getPos_x()>344&&model.getPos_x()<410)&&(model.getPos_y()>16&&model.getPos_y()<77)){
				if(input.isMouseButtonDown(0)){//0은 마우스 왼쪽 클릭의미
					game.enterState(ProjectMain._Play1);//다음게임넘어감.
				}
			}
	        //?메뉴 클릭시 게임안내판으로 넘어감.
	        if((model.getPos_x()>564&&model.getPos_x()<620)&&(model.getPos_y()>16&&model.getPos_y()<86)){
				if(input.isMouseButtonDown(0)){//0은 마우스 왼쪽 클릭의미
					ProjectMain.play_bg.stop();//플레이음악 중지
		        	ProjectMain.bg_ex.loop();//설명음악 시작
					game.enterState(ProjectMain._Exe);//게임안내판으로 넘어감.
				}
			}
	        //맨우측 메뉴클릭시 메인화면으로 이동함.
	        if((model.getPos_x()>667&&model.getPos_x()<744)&&(model.getPos_y()>10&&model.getPos_y()<80)){
				if(input.isMouseButtonDown(0)){//0은 마우스 왼쪽 클릭의미
					ProjectMain.play_bg.stop();//플레이음악 중지
					ProjectMain.bg_music.loop();//메인노래 진입.
					game.enterState(ProjectMain._Menu);//메뉴화면으로 넘어감.
				}
			}

	}

	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
	//F1키 누르면 바로메인화면 빠져나오게 만들어봄. 추후 변경할 예정.
	public void keyReleased(int key, char c){
		switch(key){
		case Input.KEY_F1:
			game.enterState(ProjectMain._Menu);
			break;
		}
	}
}
