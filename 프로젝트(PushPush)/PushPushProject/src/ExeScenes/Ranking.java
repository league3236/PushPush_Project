package ExeScenes;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.io.*;
import java.util.ArrayList;

import Main.ProjectMain;

public class Ranking extends BasicGameState {
	StateBasedGame game;
	GameContainer gc;
	protected int ID;
	private boolean _Switch = true; // 저장횟수
	ArrayList<String> lineList = new ArrayList<String>(); // 시작시간
	private Image BackGround;

	public Ranking() {
	}

	public Ranking(int id) {
		this.ID = id;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		game = arg1;
		gc = arg0;
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		BackGround.draw(0, 0, ProjectMain._width, ProjectMain._height);
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				g.drawString(lineList.get(i), 882, 265 + (43 * (i / 2))); // i번째의점수출력
			} else {
				g.drawString(lineList.get(i), 630, 265 + (43 * (i / 2))); // i번째의이름출력
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		if (_Switch == true) {
			String StringChanged = String.valueOf((ProjectMain.score / 100)); // 점수 스트링 변환
			BackGround = new Image("rsc/Ranking.png");
			File oFile = new File("rsc/Rank.txt");
			// File Reader를 위한 객체 생성
			FileReader frd = null;
			BufferedReader brd = null;
			// 내용 저장을 위한 ArrayList 정의
			// 라인 단위 저장 및 카운트를 위한 변수 정의
			String rLine = null;
			int lineNum = 0; 
			boolean hasMore = true;
			try {
				frd = new FileReader(oFile);
				brd = new BufferedReader(frd);
				while (hasMore) {
					if ((rLine = brd.readLine()) != null) {
						// ArrayList에 읽은 라인 추가
						lineList.add(rLine);
						hasMore = true;
					} else
						hasMore = false;
				}
				frd.close();
				brd.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 라인단위 출력(for loop)
			lineNum = lineList.size();
			int i = 18;
			while (i > 0 && (ProjectMain.score / 100) > Integer.parseInt(lineList.get(i))) {
				i -= 2;
			}//얻은스코어가더클때까지 loop
			i += 2; //얻어진 값이 그 전값이므로 2 더하기
			if ((ProjectMain.score / 100) > Integer.parseInt(lineList.get(0)))
				i = 0;
			lineList.add(i, StringChanged); // 점수를 Stirng으로 변환한 값을 i번째에 넣어줌.
			lineList.add(i + 1, ProjectMain.getName()); // 이름을 i+1번째에 넣어줌.
			lineList.remove(20); //20번째 21번째 를 삭제하기위해서 20번재 행을 2번 삭제
			lineList.remove(20);
			for (i = 0; i < lineNum; i++) {
				System.out.println(lineList.get(i));
			}
			try {
				FileWriter fw = new FileWriter("rsc/Rank.txt"); // 절대주소 경로 가능
				BufferedWriter bw = new BufferedWriter(fw);
				for (i = 0; i < lineNum; i++) {
					String str = lineList.get(i);
					bw.write(str);
					bw.newLine(); // 줄바꿈
				}
				bw.close();
			} catch (IOException e) {
				System.err.println(e); // 에러가 있다면 메시지 출력
				System.exit(1);
			}

		}

		_Switch = false;

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	public void keyReleased(int key, char c) {
		switch (key) {
		case Input.KEY_1:
			game.enterState(ProjectMain._Play1);
			break;
		}
	}

}