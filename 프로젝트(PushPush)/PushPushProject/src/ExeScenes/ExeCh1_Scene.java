package ExeScenes;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Basic.Model;

import org.lwjgl.input.Mouse;
import Main.ProjectMain;

public class ExeCh1_Scene extends BasicGameState{
	StateBasedGame game;
	GameContainer gc;
	
	protected int ID;
	
	Model model = new Model();
	
	private Image BackGround;
	private Image Start;
	
	public static Sound Target;  //Ÿ������ ����  ����
	
	public ExeCh1_Scene(){
		
	}
	public ExeCh1_Scene(int id){
		this.ID = id;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		game = arg1;
		gc = arg0;
		
		model.setStart_x_y(550, 530);
		
		Target = new Sound("sounds/EnterTarget.wav"); //���� ���� ����
		
		
		BackGround = new Image("rsc/Ch01_ex.png");
		Start = new Image("rsc/Start.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		BackGround.draw(0,0,ProjectMain._width,ProjectMain._height);
		Start.draw(model.getStart_x(),model.getStart_y(),200,200);
		model.set_pos_x_y(Mouse.getX(), Mouse.getY());
		
		g.drawString("x "+model.getPos_x()+"y"+model.getPos_y(), 900, 750);//���콺 ��ǥ ��� why?(�̹��� �Ѹ��� ���� ��ǥã��)
		
		if((model.getPos_x()>552&&model.getPos_x()<742)&&(model.getPos_y()>74&&model.getPos_y()<266)){
			Start.drawFlash(model.getStart_x(), model.getStart_y(),200,200);//���콺 ���ٴ����� ȿ��
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
		Input input = gc.getInput();
		
		if((model.getPos_x()>552&&model.getPos_x()<742)&&(model.getPos_y()>74&&model.getPos_y()<266)){
			if(input.isMouseButtonDown(0)){//0�� ���콺 ���� Ŭ���ǹ�
				Target.play();//Ÿ�ٿ� �����Ͻÿ� �˸���.
				ProjectMain.bg_ex.stop();//����
				ProjectMain.play_bg.loop();//�÷������� 
				game.enterState(ProjectMain._Play);//���� �÷���
			}	//�������� play ȭ�� ����
		}		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
	
	public void keyReleased(int key, char c){
		switch(key){
		case Input.KEY_1:
			game.enterState(ProjectMain._Play);
			break;
		}
	}

}
