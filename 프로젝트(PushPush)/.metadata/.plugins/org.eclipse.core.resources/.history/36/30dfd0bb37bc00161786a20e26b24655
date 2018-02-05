package Scenes;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import Main.ProjectMain;

import org.newdawn.slick.Input;
import org.newdawn.slick.Image;

public class PlayScene1 extends BasicGameState {
	StateBasedGame game;
	GameContainer gc;
	protected int ID;
	private Random random; //random
	private Sound Hero_Bullet_Sound; // 총소리 사운드
	private Sound Rusiu_Skill;	//루시우 궁극기 사운드
	private Image Rusiu_Skill_Effect;	// 루시우 스킬 이펙트 이미지
	private Image BackSpace;	//배경 이미지
	private Image LeftHero;		//좌를 본 주인공 모습 이미지
	private Image RightHero;	//우를 본 주인공 모습 이미지
	private Image Car;			//옮겨야 할 차 이미지
	private Image Car2;
	private Image Car_Destination;	//차의 목적지
	private Image Car2_Destination;
	private Image Continue;		//사망시 계속 할 것인지 이미지
	private Image Enemy;		//적 이미지
	private Image Enemy_Bullet;	//적 화살 이미지
	private Image Hero_Bullet_Left;	//솔져 총알 좌측 방향 이미지
	private Image Hero_Bullet_Right;//솔져 총알 우측 방향 이미지
	private Image Rusiu_Image_Left;	//루시우 좌측 이미지
	private Image Rusiu_Image_Right;//루시우 우측 이미지
	private Image Enemy_Skilled;	// 루시우의 궁극기가 써진 적의 이미지

	long ClearTime;		//게임 종료 시간을 종료시 까지 업데이트
	long ClearTime2;		//게임 종료 시간을 종료시 까지 업데이트
	long SkillTime = 10;	// 스킬 시전 시간
	long SkillTime2;		// 스킬 계산 시간
	long StartTime = System.currentTimeMillis(); // 게임 시작 시간
	int Hero_Jump = 0;		//HeroJump 시간
	int heroLife = 1;		//Hero 목숨
	int Hero_Direction = 0;	//Hero가 바라보는 방향이 좌인지 우인지
	int Hero_x = 1170;		//Hero의 X좌표
	int Hero_y = 90;		//Hero의 Y좌표
	int Hero_v = 2;			//Hero의 속도

	int Rusiu_x[] = { 1030, 780 };	//Rusiu의 X좌표
	int Rusiu_y[] = { 376, 532 };	//Rusiu의 Y좌표
	int Rusiu_Life[] = { 1, 1 };	//Rusiu의 목숨 수
	int Rusiu_Direction[] = { 0, 0 };	// Rusiu의 좌우 바라보는 방향
	int Rusiu_Speed = 2;				// Rusiu의 이동 속도
	int Rusiu_Jump[] = { 0, 0 };		// Rusiu의 점프 여부
	int Rusiu_Skill_Count[] = { 0, 0 };	// Rusiu의 스킬 여부 (0이면 미사용 1이면 사용)
	int Rusiu_Skill_X_Y[] = { 0, 0 };	// Rusiu의 스킬 출력을 위한 XY좌표
	int Rusiu_SKill_Range = 0;			// Rusiu의 스킬이미지를 늘려줄 크기
	int Car_Destination_Count = 0;		// 도착점이 채워 졌는지 안채워 졌는지
	int Car2_Destination_Count = 0;

	int Car_Count = 0; //차가 목적지에 도달했는지
	int Car2_Count = 0;

	int Car_v = 2; // 차의 이동속도

	int Car_x = 1050; // 차의 X좌표
	int Car_y = 90;		//차의 Y좌표

	int Car2_x = 800;
	int Car2_y = 552;

	int Car_Des_x = 66;	//도착지의 x좌표
	int Car_Des_y = 690;	//도착지의 y좌표

	int Car2_Des_x = 1100;
	int Car2_Des_y = 690;
	int Enemy_Life[] = { 3, 3, 3, 3, 3 };	//적의 목숨 수
	int Enemy_x[] = { 78, 300, 150, 530, 150 };	//적의 x좌표
	int Enemy_y[] = { 376, 228, 376, 376, 670 };	//적의 Y좌표
	int Enemy_Bullet_x[] = { 128, 350, 200, 550, 200 };	//적 화살의 x좌표
	int Enemy_Bullet_y[] = { 406, 258, 406, 406, 700 };	//적 화살의 y좌표
	int Enemy_Bullet_Speed[] = { 2, 3, 3, 4, 4 };	//적 화살의 스피드

	int Hero_Bullet_Speed = 4;	//Hero 총알 속도
	int Hero_Bullet_x[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }; //Hero총알 x좌표
	int Hero_Bullet_y[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };	//Hero총알 y좌표
	int Hero_Bullet_Fire[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0 };
	int Hero_Bullet_Count = 0;	//Hero총알 발사 여부
	int Hero_Bullet_Direction[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // Hero총알 의 방향
			0, 0 };

	public PlayScene1(int id) {
		this.ID = id;
	}

	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		game = arg1;
		gc = arg0;
		Rusiu_Image_Left = new Image("rsc/Rusiu_Image_Left.png");
		Rusiu_Image_Right = new Image("rsc/Rusiu_Image_Right.png");
		Hero_Bullet_Sound = new Sound("sounds/Hero_Bullet_Sound.wav");
		Rusiu_Skill = new Sound("sounds/Rusiu_Skill.wav");
		BackSpace = new Image("rsc/Stage1BackGround.png");
		LeftHero = new Image("rsc/Ch_01.png");
		RightHero = new Image("rsc/Ch_02.png");
		Car = new Image("rsc/Logo.png");
		Car_Destination = new Image("rsc/Logo_Destination.png");
		Car2 = new Image("rsc/Logo.png");
		Car2_Destination = new Image("rsc/Logo_Destination.png");
		Continue = new Image("rsc/Continue.png");
		Enemy = new Image("rsc/Enemy_Image.png");
		Enemy_Bullet = new Image("rsc/Enemy_Bullet_Right.png");
		Hero_Bullet_Left = new Image("rsc/Hero_Bullet_Left.png");
		Hero_Bullet_Right = new Image("rsc/Hero_Bullet_Right.png");
		Rusiu_Skill_Effect = new Image("rsc/Rusiu_Skill_Effect.png");
		Enemy_Skilled = new Image("rsc/Enemy_Skilled_Image.png");
		random = new Random();
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		BackSpace.draw(0, 0, ProjectMain._width, ProjectMain._height); // 배경 출력

		for (int i = 0; i < 2; ++i) {
			if (Rusiu_Life[i] > 0) {
				if (Rusiu_Direction[i] == 0) {
					Rusiu_Image_Left.draw(Rusiu_x[i], Rusiu_y[i], 100, 100);
				} else if (Rusiu_Direction[i] == 1) {
					Rusiu_Image_Right.draw(Rusiu_x[i], Rusiu_y[i], 100, 100);
				}
			} //Rusiu가 생존해 있을시 좌우 방향에 따른 이미지 출력

			if (Rusiu_Life[0] > 0 && Rusiu_Direction[0] == 0)
				Car.draw(Rusiu_x[0], Rusiu_y[0] + 40, 30, 30);
			if (Rusiu_Life[1] > 0 && Rusiu_Direction[1] == 0)
				Car2.draw(Rusiu_x[1], Rusiu_y[1] + 40, 30, 30);
			if (Rusiu_Life[0] > 0 && Rusiu_Direction[0] == 1)
				Car.draw(Rusiu_x[0] + 75, Rusiu_y[0] + 40, 30, 30);
			if (Rusiu_Life[1] > 0 && Rusiu_Direction[1] == 1)
				Car2.draw(Rusiu_x[1] + 75, Rusiu_y[1] + 40, 30, 30);
			if (Rusiu_Life[0] == 0)
				Car.draw(Car_x, Car_y, 60, 60);
			if (Rusiu_Life[1] == 0)
				Car2.draw(Car2_x, Car2_y, 60, 60); // Rusiu가 생존해 있을경우 차를 루시우가 들고 다니게 하고 Rusiu가 죽을 경우 그 위치에 차를 이미지로 출력
		}
		for (int i = 0; i < 5; ++i) {
			if (Enemy_Life[i] > 0) {
				Enemy.draw(Enemy_x[i], Enemy_y[i], 100, 100);
				Enemy_Bullet.draw(Enemy_Bullet_x[i], Enemy_Bullet_y[i], 60, 30);
			}//적이 생존해 있을경우 한명당 한화면에 1발 출력
		}

		if (Hero_Direction == 0) {
			LeftHero.draw(Hero_x, Hero_y, 60, 60);
		} else if (Hero_Direction == 1) {
			RightHero.draw(Hero_x, Hero_y, 60, 60);
		}//Hero 좌우 방향에 맞춰서 이미지 출력

		if (Car_Des_x == Car_x && Car_Des_y == Car_y) {
			Car_Count = 1;
			Car_Destination_Count = 1;
		}
		if (Car2_Des_x == Car_x && Car2_Des_y == Car_y) {
			Car_Count = 1;
			Car2_Destination_Count = 1;
		}
		if (Car_Des_x == Car2_x && Car_Des_y == Car2_y) {
			Car2_Count = 1;
			Car_Destination_Count = 1;
		}
		if (Car2_Des_x == Car2_x && Car2_Des_y == Car2_y) {
			Car2_Count = 1;
			Car2_Destination_Count = 1;
		}
		if (Car_Destination_Count == 0) {
			Car_Destination.draw(Car_Des_x, Car_Des_y, 60, 60);
		}

		if (Car2_Destination_Count == 0) {
			Car2_Destination.draw(Car2_Des_x, Car2_Des_y, 60, 60);
		}
		//차와 목적지를 출력하고 목적지에 차가 도달할 경우 차만 출력
		for (int i = 0; i < 30; ++i) {
			if (Hero_Bullet_Fire[i] == 1) {
				if (Hero_Bullet_Direction[i] == 1) {
					Hero_Bullet_Left.draw(Hero_Bullet_x[i], Hero_Bullet_y[i], 30, 15);
				} else if (Hero_Bullet_Direction[i] == 2) {
					Hero_Bullet_Right.draw(Hero_Bullet_x[i], Hero_Bullet_y[i], 30, 15);
				}
			}
		}//화살의 방향에 맞게 화살의 이미지 출력
		if (heroLife <= 0) {
			Continue.draw(300, 250, 700, 250);
			Input input = arg0.getInput();
			if (input.isKeyDown(Input.KEY_Y)) {
				heroLife = 1;
			}
			if (input.isKeyDown(Input.KEY_N)) {
				game.enterState(ProjectMain._Menu);
			}
		}//Hero가 적 화살에 맞을 경우 Y N키를 입력해 Y를 누를경우 히어로 HP를 1 늘려주고 N을 누를경우 메뉴로 돌아감.
		if (Rusiu_Skill_Count[0] == 1 || Rusiu_Skill_Count[1] == 1) {
			if ((ClearTime - SkillTime) > 10) {
				Rusiu_Skill_Effect.draw(Rusiu_Skill_X_Y[0] - (Rusiu_SKill_Range / 2),
						Rusiu_Skill_X_Y[1] - (Rusiu_SKill_Range / 2), 100 + Rusiu_SKill_Range,
						100 + (((float) 0.8) * Rusiu_SKill_Range));
				SkillTime = ClearTime;
				Rusiu_SKill_Range += 20;
			}
		}//Skill 을 사용할 경우 스킬 이미지가 사용한 곳을 기점으로 점점 넓어지게 출력
		if((ClearTime-SkillTime2)<10000)
		{
			for (int i = 0; i < 5; ++i) {
				if (Enemy_Life[i] > 0) {
					Enemy_Skilled.draw(Enemy_x[i], Enemy_y[i], 100, 100);
					Enemy_Bullet.draw(Enemy_Bullet_x[i], Enemy_Bullet_y[i], 60, 30);
					Enemy_Life[i]=3;
				}
			}
		}//Rusiu가 스킬을 사용할 경우 적들이 스킬을 맞은 이미지로 출력하며 무적이 됨.
		else
		{
			for (int i = 0; i < 5; ++i) {
				if (Enemy_Life[i] > 0) {
					Enemy.draw(Enemy_x[i], Enemy_y[i], 100, 100);
					Enemy_Bullet.draw(Enemy_Bullet_x[i], Enemy_Bullet_y[i], 60, 30);
				}
			}
		}//평시의 적들을 이미지 출력
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		if (Rusiu_Life[0] == 0 && Rusiu_Life[1] == 1 && Rusiu_Skill_Count[1] == 0) {
			Rusiu_Skill_X_Y[0] = Rusiu_x[1];
			Rusiu_Skill_X_Y[1] = Rusiu_y[1];
			Rusiu_Skill_Count[1] = 1;
			Rusiu_Skill.play();
			SkillTime = System.currentTimeMillis();
			SkillTime2 = System.currentTimeMillis();
		}//1번째 루시우가 죽을 경우 2번째 루시우가 Skill을 사용함
		if (Rusiu_Life[0] == 1 && Rusiu_Life[1] == 0 && Rusiu_Skill_Count[0] == 0) {
			Rusiu_Skill_X_Y[0] = Rusiu_x[0];
			Rusiu_Skill_X_Y[1] = Rusiu_y[0];
			Rusiu_Skill_Count[0] = 1;
			Rusiu_Skill.play();
			SkillTime = System.currentTimeMillis();
			SkillTime2 = System.currentTimeMillis();
		}//2번째 루시우가 죽을 경우 1번째 루시우가 Skill을 사용함
		if (Car_x < 66 || Car_x > 1174)
			Car_x = 600;
		if (Car2_x < 66 || Car2_x > 1174)
			Car2_x = 600;
		//차 두대가 겹치는 현상을 방지하기 위해서 서로 겹쳐지게되면 서로 밀어냄.
		if (Car2_Destination_Count == 1 && Car_Destination_Count == 1) {
			game.enterState(ProjectMain._Ranking);
		}//차를 모두 넣을경우 Ranking창으로 넘어감
		for (int i = 0; i < 2; ++i) {
			if (Rusiu_Life[i] > 0) {
				if (Rusiu_Direction[i] == 0) {
					Rusiu_x[i] -= Rusiu_Speed;
				} else if (Rusiu_Direction[i] == 1) {
					Rusiu_x[i] += Rusiu_Speed;
				}
				if (Rusiu_x[i] < 200) {
					Rusiu_Direction[i] = 1;
				} else if (Rusiu_x[i] > 1100) {
					Rusiu_Direction[i] = 0;
				}

			}//Rusiu가 생존해 있을경우 루시우가 수평방향으로 자동적으로 이동함.
			if (Rusiu_y[i] == 70 && Rusiu_x[i] > 752) {
			} else if (Rusiu_y[i] == 70 && Rusiu_x[i] < 502) {
			} else if (Rusiu_y[i] == 670) {
			} else if (Rusiu_y[i] == 228 && Rusiu_x[i] < 994 && Rusiu_x[i] > 260) {
			} else if (Rusiu_y[i] == 376 && Rusiu_x[i] < 390) {
			} else if (Rusiu_y[i] == 376 && Rusiu_x[i] < 748 && Rusiu_x[i] > 495) {
			} else if (Rusiu_y[i] == 376 && Rusiu_x[i] > 864) {
			} else if (Rusiu_y[i] == 532 && Rusiu_x[i] < 922 && Rusiu_x[i] > 675) {
			} else if (Rusiu_y[i] == 532 && Rusiu_x[i] < 574 && Rusiu_x[i] > 327) {
			} else if (Rusiu_Jump[i] == 0) {
				Rusiu_y[i] += 2;
			}//루시우가 바닥에 있을경우를 제외한 경우에 밑으로 떨어지게 함
			if (Rusiu_Jump[i] > 0) {
				Rusiu_y[i] -= 4;
				Rusiu_Jump[i]++;
				if (Rusiu_Jump[i] == 50)
					Rusiu_Jump[i] = 0;
			} // 루시우가 점프키를 받을 경우 천천히 점프를 하고 50이되면 점프를 멈춤
			if (random.nextInt(300) > 297
					&& (Rusiu_y[i] == 376 || Rusiu_y[i] == 228 || Rusiu_y[i] == 670 || Rusiu_y[i] == 532)) {
				Rusiu_Jump[i] = 1;
			}// random변수를 받으 0~299중 298이나 299가 나올경우 루시우가 점프를 함

		}

		if (Rusiu_Life[0] > 0) {
			Car_x = Rusiu_x[0];
			Car_y = Rusiu_y[0];
		}//루시우가 살아있을경우 차를 들고다니게 함
		if (Rusiu_Life[1] > 0) {
			Car2_x = Rusiu_x[1];
			Car2_y = Rusiu_y[1];
		}//루시우가 살아있을경우 차를 들고다니게 함
		for (int i = 0; i < 30; ++i) {
			if (Hero_Bullet_Fire[i] == 1) {//Hero의 총알이 발사될경우 좌우 벽에 부딪히면 총알이 사라짐.
				if (Hero_Bullet_x[i] < 66 || Hero_Bullet_x[i] > 1214) {
					Hero_Bullet_Fire[i] = 0;
				}
				if (Hero_Bullet_Direction[i] == 1) {
					for (int j = 0; j < 5; ++j) {
						if ((Hero_Bullet_x[i] > Enemy_x[j]) && (Hero_Bullet_x[i] < Enemy_x[j] + 80)
								&& (Hero_Bullet_y[i] > Enemy_y[j] + 15) && (Hero_Bullet_y[i] < Enemy_y[j] + 70)) {
							if (Enemy_Life[j] > 0) {
								Enemy_Life[j]--;
								Hero_Bullet_Fire[i] = 0;
							}
							Hero_Bullet_x[i] -= Hero_Bullet_Speed;
						} else {
							Hero_Bullet_x[i] -= Hero_Bullet_Speed;
						}
					}//총알이 우측에서 좌측으로 날아가고 적에 피격할 경우 적의 피를 깍고  총알을 삭제시킴
					for (int j = 0; j < 2; ++j) {
						if ((Hero_Bullet_x[i] > Rusiu_x[j]) && (Hero_Bullet_x[i] < Rusiu_x[j] + 80)
								&& (Hero_Bullet_y[i] > Rusiu_y[j] + 15) && (Hero_Bullet_y[i] < Rusiu_y[j] + 70)) {
							if (Rusiu_Life[j] > 0) {
								Rusiu_Life[j]--;
								Hero_Bullet_Fire[i] = 0;
							}
							Hero_Bullet_x[i] -= Hero_Bullet_Speed;
						} else {
							Hero_Bullet_x[i] -= Hero_Bullet_Speed;
						}//총알이 우측에서 좌측으로 날아가고 루시우에 피격할 경우 루시우의 피를 깍고  총알을 삭제시킴
					}
				} else if (Hero_Bullet_Direction[i] == 2) 
					for (int j = 0; j < 5; ++j) {
					if ((Hero_Bullet_x[i] > Enemy_x[j]) && (Hero_Bullet_x[i] < Enemy_x[j] + 80)
							&& (Hero_Bullet_y[i] > Enemy_y[j] + 15) && (Hero_Bullet_y[i] < Enemy_y[j] + 70)) {
						if (Enemy_Life[j] > 0) {
							Enemy_Life[j]--;
							Hero_Bullet_Fire[i] = 0;
						}
						Hero_Bullet_x[i] += Hero_Bullet_Speed;
					} else {
						Hero_Bullet_x[i] += Hero_Bullet_Speed;
					}
				}//총알이 좌측에서 우측으로 날아가고 적에 피격할 경우 적의 피를 깍고  총알을 삭제시킴
				for (int j = 0; j < 2; ++j) {
					if ((Hero_Bullet_x[i] > Rusiu_x[j]) && (Hero_Bullet_x[i] < Rusiu_x[j] + 80)
							&& (Hero_Bullet_y[i] > Rusiu_y[j] + 15) && (Hero_Bullet_y[i] < Rusiu_y[j] + 70)) {
						if (Rusiu_Life[j] > 0) {
							Rusiu_Life[j]--;
							Hero_Bullet_Fire[i] = 0;
						}
						Hero_Bullet_x[i] += Hero_Bullet_Speed;
					} else {
						Hero_Bullet_x[i] += Hero_Bullet_Speed;
					}
				}//총알이 좌측에서 우측으로 날아가고 루시우에 피격할 경우 루시우의 피를 깍고  총알을 삭제시킴
			}
		}
		for (int i = 0; i < 5; ++i) {

			if (Enemy_Life[i] > 0) {
				if (Enemy_Bullet_y[i] > Hero_y && Enemy_Bullet_y[i] < Hero_y + 20 && Enemy_Bullet_x[i] > Hero_x - 60
						&& Enemy_Bullet_x[i] < Hero_x) {
					Enemy_Bullet_x[i] = Enemy_x[i] + 50;
					heroLife--;
					ProjectMain.score -= 100;
				} else if (Enemy_Bullet_y[i] > Car_y && Enemy_Bullet_y[i] < Car_y + 40 && Enemy_Bullet_x[i] > Car_x - 60
						&& Rusiu_Life[0] == 0) {
					Enemy_Bullet_x[i] = Enemy_x[i] + 50;
				} else if (Enemy_Bullet_y[i] > Car2_y && Enemy_Bullet_y[i] < Car2_y + 40
						&& Enemy_Bullet_x[i] > Car2_x - 60 && Rusiu_Life[1] == 0) {
					Enemy_Bullet_x[i] = Enemy_x[i] + 50;
				} else if (Enemy_Bullet_x[i] > 1174) {
					Enemy_Bullet_x[i] = Enemy_x[i] + 50;
				} else {
					Enemy_Bullet_x[i] += Enemy_Bullet_Speed[i];
				}
			}//적의 화살이 Hero를 맞출경우 Hero의 Life를 깍고 화살이 벽에 부딪히거나 차에 부딪히면 화살이 사라지고 다시 발사됨.
		}
		if (Hero_y == 90 && Hero_x > 752) {
		} else if (Hero_y == 90 && Hero_x < 502) {
		} else if (Hero_y == 690) {
		} else if (Hero_y == 248 && Hero_x < 994 && Hero_x > 260) {
		} else if (Hero_y == 396 && Hero_x < 390) {
		} else if (Hero_y == 396 && Hero_x < 748 && Hero_x > 495) {
		} else if (Hero_y == 396 && Hero_x > 864) {
		} else if (Hero_y == 552 && Hero_x < 922 && Hero_x > 675) {
		} else if (Hero_y == 552 && Hero_x < 574 && Hero_x > 327) {
		} else if (Hero_Jump == 0) {
			Hero_y += 2;
		}
		if (Hero_Jump > 0) {
			if (Hero_y < 30)
				Hero_Jump = 49;
			Hero_y -= 4;
			Hero_Jump++;
			if (Hero_Jump == 50)
				Hero_Jump = 0;
		}//Hero가 바닥이 없는 곳에 설경우 밑으로 떨어지고 점프가 입력될 경우 점프를 함
		if (Car_y == 90 && Car_x > 752) {
		} else if (Car_y == 90 && Car_x < 502) {
		} else if (Car_y == 690) {
		} else if (Car_y == 248 && Car_x < 994 && Car_x > 260) {
		} else if (Car_y == 396 && Car_x < 390) {
		} else if (Car_y == 396 && Car_x < 748 && Car_x > 495) {
		} else if (Car_y == 396 && Car_x > 864) {
		} else if (Car_y == 552 && Car_x < 922 && Car_x > 675) {
		} else if (Car_y == 552 && Car_x < 574 && Car_x > 327) {
		} else {
			Car_y += 2;
		}
		if (Car2_y == 90 && Car2_x > 752) {
		} else if (Car2_y == 90 && Car2_x < 502) {
		} else if (Car2_y == 690) {
		} else if (Car2_y == 248 && Car2_x < 994 && Car2_x > 260) {
		} else if (Car2_y == 396 && Car2_x < 390) {
		} else if (Car2_y == 396 && Car2_x < 748 && Car2_x > 495) {
		} else if (Car2_y == 396 && Car2_x > 864) {
		} else if (Car2_y == 552 && Car2_x < 922 && Car2_x > 675) {
		} else if (Car2_y == 552 && Car2_x < 574 && Car2_x > 327) {
		} else {
			Car2_y += 2;
		}//Car가 바닥이 없는 곳에 설 경우 밑으로 떨어짐.
		if (Car2_y == Car_y && Car2_x < Car_x + 50 && Car2_x > Car_x - 50) {
			if (Car2_x > Car_x) {
				Car2_x += Car_v;
			} else if (Car2_x < Car_x) {
				Car2_x -= Car_v;
			}
		}//차끼리 겹쳐지는 것을 방지하기 위해 차끼리 다가갈경우 서로 밀어냄
		Input input = arg0.getInput();
		if ((heroLife > 0)) {
			ClearTime=System.currentTimeMillis(); // 게임 종료 시간 계속 update
			ClearTime2 = (ClearTime2-StartTime)/1000;
			ProjectMain.score-=ClearTime2/5; //점수를 계산해서 main의 score에 점수 업로드
			if (input.isKeyDown(Input.KEY_LEFT) && Hero_x > 66) {
				Hero_x -= Hero_v;
				Hero_Direction = 0;
			} //좌측 키보드 입력시 hero좌측으로 이동
			if (input.isKeyDown(Input.KEY_RIGHT) && Hero_x < 1176) {
				Hero_x += Hero_v;
				Hero_Direction = 1;
			} //우측 키보드 입력시 hero우측으로 이동
			if (input.isKeyPressed(Input.KEY_SPACE)
					&& (Hero_y == 248 || Hero_y == 396 || Hero_y == 552 || Hero_y == 690 || Hero_y == 90)) {
				Hero_Jump = 1;
			} //space bar 입력시 점프를 실행하기위해 Hero점프를 1로 올려줌.
			if (input.isKeyPressed(Input.KEY_LCONTROL)) {
				Hero_Bullet_Sound.play();
				Hero_Bullet_y[Hero_Bullet_Count] = Hero_y + 15;
				Hero_Bullet_Fire[Hero_Bullet_Count] = 1;
				if (Hero_Direction == 0) {
					Hero_Bullet_x[Hero_Bullet_Count] = Hero_x - 30;
					Hero_Bullet_Direction[Hero_Bullet_Count] = 1;
				} else if (Hero_Direction == 1) {
					Hero_Bullet_x[Hero_Bullet_Count] = Hero_x + 60;
					Hero_Bullet_Direction[Hero_Bullet_Count] = 2;
				}
				Hero_Bullet_Count += 1;
				if (Hero_Bullet_Count == 30) {
					Hero_Bullet_Count = 0;
				}
			}// 좌측 Ctrl키를 입력하면 총알이 발사됨.

			if (Hero_y == Car_y && Car_Count == 0 && Rusiu_Life[0] == 0) {
				if (Hero_x > Car_x && (Hero_x < Car_x + 56)) {
					Car_x -= Car_v;
				} else if (Hero_x < Car_x && (Hero_x > Car_x - 56)) {
					Car_x += Car_v;
				}

			}//히어로가 차를 밀수 있도록 함.
			if (Hero_y == Car2_y && Car2_Count == 0 && Rusiu_Life[1] == 0) {
				if (Hero_x > Car2_x && (Hero_x < Car2_x + 56)) {
					Car2_x -= Car_v;
				} else if (Hero_x < Car2_x && (Hero_x > Car2_x - 56)) {
					Car2_x += Car_v;
				}
			}
		}

	}

	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	public void keyReleased(int key, char c) {
		switch (key) {
		case Input.KEY_F1:
			game.enterState(ProjectMain._Menu);
			break;
		}
	}
}
