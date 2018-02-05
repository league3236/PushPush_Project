package Basic;

import org.newdawn.slick.Input;


public class Control {
	
	public void controller (Input input,Model model){
		if((model.getHeroLife()>0)){
			if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<1){model.plusHero_y();}}	
	        if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>553){model.minusHero_y();}}
	        if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<1){model.plusHero_x();}}
	        if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>1007){model.minusHero_x();}}    
		}// 케릭터 컨트롤
		
	}
	public void controller_car (Input input,Model model,float Min, float Max){
		 if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<1){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>1007){model.minusCar_x();}}
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<1){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>553){model.minusCar_y();}}
	}// 화물 컨트롤
	public void controllerPush (Input input,Model model){
		if((model.getHeroLife()>0)){
			if((model.getHero_x()>728&&model.getHero_x()<795)&&(model.getHero_y()>252&&model.getHero_y()<425)){
				if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<253){model.plusHero_y();}}	
				if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>424){model.minusHero_y();}}
				if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<729){model.plusHero_x();}}
				if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>794){model.minusHero_x();}}    
			}// 케릭터 컨트롤  처음 시작부분 4*2 이동
			if(((model.getHero_x()<795)&&(model.getHero_x()>360))&&(model.getHero_y()>304&&model.getHero_y()<317)){
				if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<305){model.plusHero_y();}}	
				if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>316){model.minusHero_y();}}
				if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<361){model.plusHero_x();}}
				if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>794){model.minusHero_x();}}    
			}// 케릭터 컨트롤 중간통로 이동
			if(((model.getHero_x()<430)&&(model.getHero_x()>423))&&(model.getHero_y()>141&&model.getHero_y()<317)){
				if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<142){model.plusHero_y();}}	
				if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>316){model.minusHero_y();}}
				if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<424){model.plusHero_x();}}
				if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>429){model.minusHero_x();}}    
			}// 케릭터 컨트롤 통로 들어간다음 위쪽 이동
			if(((model.getHero_x()<425)&&(model.getHero_x()>303))&&(model.getHero_y()>141&&model.getHero_y()<151)){
				if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<142){model.plusHero_y();}}	
				if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>150){model.minusHero_y();}}
				if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<304){model.plusHero_x();}}
				if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>424){model.minusHero_x();}}    
			}// 케릭터 컨트롤 왼쪽으로 세칸이동
			if(((model.getHero_x()<309)&&(model.getHero_x()>303))&&((model.getHero_y()>141)&&(model.getHero_y()<258))){
				if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<142){model.plusHero_y();}}	
				if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>257){model.minusHero_y();}}
				if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<304){model.plusHero_x();}}
				if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>308){model.minusHero_x();}}    
			}// 케릭터 컨트롤 아래로 세칸이동
			if(((model.getHero_x()<309)&&(model.getHero_x()>238))&&(model.getHero_y()>248&&model.getHero_y()<258)){
				if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<249){model.plusHero_y();}}	
				if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>257){model.minusHero_y();}}
				if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<239){model.plusHero_x();}}
				if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>308){model.minusHero_x();}}    
			}// 케릭터 컨트롤 왼쪽으로 두칸이동
			if(((model.getHero_x()<250)&&(model.getHero_x()>238))&&(model.getHero_y()>256&&model.getHero_y()<371)){
				if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<257){model.plusHero_y();}}	
				if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>370){model.minusHero_y();}}
				if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<239){model.plusHero_x();}}
				if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>249){model.minusHero_x();}}    
			}// 케릭터 컨트롤 아래로 세칸이동
			if(((model.getHero_x()<368)&&(model.getHero_x()>238))&&(model.getHero_y()>362&&model.getHero_y()<371)){
				if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<363){model.plusHero_y();}}	
				if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>370){model.minusHero_y();}}
				if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<239){model.plusHero_x();}}
				if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>367){model.minusHero_x();}}    
			}// 케릭터 컨트롤 오른쪽로 세칸이동
			if(((model.getHero_x()<369)&&(model.getHero_x()>360))&&(model.getHero_y()>241&&model.getHero_y()<371)){
				if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<242){model.plusHero_y();}}	
				if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>370){model.minusHero_y();}}
				if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<361){model.plusHero_x();}}
				if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>368){model.minusHero_x();}}    
			}// 케릭터 컨트롤 위로 세칸이동
			if(((model.getHero_x()<430)&&(model.getHero_x()>238))&&(model.getHero_y()>247&&model.getHero_y()<259)){
				if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<248){model.plusHero_y();}}	
				if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>258){model.minusHero_y();}}
				if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<239){model.plusHero_x();}}
				if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>429){model.minusHero_x();}}    
			}// 작은 중간통로 이동
			if(((model.getHero_x()<430)&&(model.getHero_x()>361))&&(model.getHero_y()>240&&model.getHero_y()<317)){
				if(input.isKeyDown(Input.KEY_UP)){model.minusHero_y();if(model.getHero_y()<241){model.plusHero_y();}}	
				if(input.isKeyDown(Input.KEY_DOWN)){model.plusHero_y();if(model.getHero_y()>316){model.minusHero_y();}}
				if(input.isKeyDown(Input.KEY_LEFT)){model.minusHero_x();if(model.getHero_x()<362){model.plusHero_x();}}
				if(input.isKeyDown(Input.KEY_RIGHT)){model.plusHero_x();if(model.getHero_x()>429){model.minusHero_x();}}    
			}// 작은 중간통로 이동
			
		}
	}
	
	public void controller_car_Push (Input input,Model model,float Min, float Max){
		if((model.getCar_x()>728&&model.getCar_x()<795)&&(model.getCar_y()>252&&model.getCar_y()<425)){
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<253){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>424){model.minusCar_y();}}
	        if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<729){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()+8<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>794){model.minusCar_x();}}
	}
		if((model.getCar_x()<795&&model.getCar_x()>360)&&(model.getCar_y()>304&&model.getCar_y()<=320)){
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<305){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>319){model.minusCar_y();}}
	        if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<361){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()+5<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>794){model.minusCar_x();}}
	}
		if((model.getCar_x()<430&&model.getCar_x()>423)&&(model.getCar_y()>141&&model.getCar_y()<=315)){
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<142){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>314){model.minusCar_y();}}
	        if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<424){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()+5<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>429){model.minusCar_x();}}
	}
		if((model.getCar_x()<425&&model.getCar_x()>303)&&(model.getCar_y()>141&&model.getCar_y()<151)){
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<142){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>150){model.minusCar_y();}}
	        if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<304){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()+5<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>424){model.minusCar_x();}}
	}
		if((model.getCar_x()<309&&model.getCar_x()>303)&&(model.getCar_y()>141&&model.getCar_y()<258)){
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<142){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>257){model.minusCar_y();}}
	        if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<304){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()+5<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>308){model.minusCar_x();}}
	}
		if((model.getCar_x()<309&&model.getCar_x()>238)&&(model.getCar_y()>248&&model.getCar_y()<258)){
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<249){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>257){model.minusCar_y();}}
	        if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<239){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()+5<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>308){model.minusCar_x();}}
	}
		if((model.getCar_x()<250&&model.getCar_x()>238)&&(model.getCar_y()>256&&model.getCar_y()<371)){
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<257){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>370){model.minusCar_y();}}
	        if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<239){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()+5<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>249){model.minusCar_x();}}
	}
		if((model.getCar_x()<368&&model.getCar_x()>238)&&(model.getCar_y()>362&&model.getCar_y()<371)){
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<363){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>370){model.minusCar_y();}}
	        if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<239){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()+5<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>367){model.minusCar_x();}}
	}
		if((model.getCar_x()<369&&model.getCar_x()>360)&&(model.getCar_y()>241&&model.getCar_y()<371)){
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<252){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>370){model.minusCar_y();}}
	        if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<361){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()+5<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>368){model.minusCar_x();}}
	}
		if((model.getCar_x()<430&&model.getCar_x()>238)&&(model.getCar_y()>247&&model.getCar_y()<259)){
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<248){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>258){model.minusCar_y();}}
	        if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<239){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()+8<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>429){model.minusCar_x();}}
	}
		if((model.getCar_x()<433&&model.getCar_x()>361)&&(model.getCar_y()>242&&model.getCar_y()<320)){
	        if(Min<Max&&model.getHero_y()>model.getCar_y()){model.minusCar_y();if(model.getCar_y()<243){model.plusCar_y();}}
	        if(Min<Max&&model.getHero_y()<model.getCar_y()){model.plusCar_y();if(model.getCar_y()>319){model.minusCar_y();}}
	        if(Min<Max&&model.getHero_x()>model.getCar_x()){model.minusCar_x();if(model.getCar_x()<362){model.plusCar_x();}}
	        if(Min<Max&&model.getHero_x()+5<model.getCar_x()){model.plusCar_x();if(model.getCar_x()>432){model.minusCar_x();}}
	}
		
	}// 화물 컨트롤
	
	public void controllerEnemy_Push (Model model){
		if(model.getFeel()!=true){
		if(model.getEnemy_x()>303&&model.getEnemy_x()<309){
			if(model.getEnemy_y()<=258){model.plusEnemy_y();}
			}//아래로이동
		if(model.getEnemy_y()<=259&&model.getEnemy_y()>252&&model.getEnemy_x()<330){
			if(model.getEnemy_x()>=241){model.minusEnemy_x();}
		}//왼쪽으로이동
		if(model.getEnemy_x()>=240&&model.getEnemy_x()<244){
			if(model.getEnemy_y()<=370){model.plusEnemy_y();}
		}//아래로이동
		if(model.getEnemy_y()<=371&&model.getEnemy_y()>368){
			if(model.getEnemy_x()<=368){model.plusEnemy_x();}
		}//오른쪽으로 이동
		if(model.getEnemy_x()<=369&&model.getEnemy_x()>367){
			if(model.getEnemy_y()>=248){model.minusEnemy_y();}
		}//위이동
		if(model.getEnemy_y()>=247&&model.getEnemy_y()<250&&model.getEnemy_x()>334){
			if(model.getEnemy_x()<=433){model.plusEnemy_x();}
		}//오른쪽으로이동
		if(model.getEnemy_x()<=434&&model.getEnemy_x()>430){
			if(model.getEnemy_y()>=144){model.minusEnemy_y();}
		}//위이동
		if(model.getEnemy_y()>=143&&model.getEnemy_y()<146){
			if(model.getEnemy_x()>=304){model.minusEnemy_x();}
		}//왼쪽으로이동
	}
	}
	
	
}

