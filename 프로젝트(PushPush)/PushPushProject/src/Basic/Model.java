package Basic;

public class Model {
	private static int heroLife=3; //초기 영웅 에너지.
	
	boolean feelkey=false;//궁극기 사용위한 boolean
	
	int start_x;//start로고 x축
	int start_y;//start로고 y축
	
	int Hero_x; //초기 영웅 x축
    int Hero_y;//초기 영웅 Y축
    int Hero_v = 1; //1만큼 움직이게끔

    int Car_x; //초기 화물 x축
    int Car_y;//초기 화물 Y축
    int Car_v = 1; //1만큼 움직이게끔

    int Car_Des_x ; //화물 목적지 위치
    int Car_Des_y ; // 화물 목적지 위치
    
    int Enemy_x;//초기 적 x
    int Enemy_y;//초기 적 y
    int Enemy_v = 1; //  움직이게끔.
    
	int xpos;//마우스 x좌표
	int ypos;//마우스 y좌표
	
	int menu_x;//메뉴x좌표
	int menu_y;//메뉴y좌표
	
    public int getHeroLife() {
		return heroLife;
	}
    public boolean getFeel() {
		return feelkey;
	}

	public void setHeroLife(int heroLife) {
		Model.heroLife = heroLife;
	}
	public int minusHeroLife(){
		return heroLife--;
	}
	public void setHero_x_y(int x,int y){
		Hero_x=x;
		Hero_y=y;
	}
	public void plusHero_x(){
		Hero_x+=Hero_v;
	}
	public void plusHero_y(){
		Hero_y+=Hero_v;
	}
	public void minusHero_x(){
		Hero_x-=Hero_v;
	}
	public void minusHero_y(){
		Hero_y-=Hero_v;
	}
	public void setHero_v(int x){
		Hero_v=x;
	}
	public void setCar_x_y(int x,int y){
		Car_x=x;
		Car_y=y;
	}
	public void setCar_Des_x_y(int x,int y){
		Car_Des_x=x;
		Car_Des_y=y;
	}
	public void setEnemy_x_y(int x,int y){
		Enemy_x=x;
		Enemy_y=y;
	}
	public void set_pos_x_y(int x,int y){
		xpos=x;
		ypos=y;
	}
	public void setStart_x_y(int x,int y){
		start_x=x;
		start_y=y;
	}
	public void setMenu_x_y(int x,int y){
		menu_x=x;
		menu_y=y;
	}
	public void trueFeel(){
		feelkey=true;
	}
	public void falseFeel(){
		feelkey=false;
	}
	public void plusCar_x(){
		Car_x+=Car_v;
	}
	public void plusCar_y(){
		Car_y+=Car_v;
	}
	public void minusCar_x(){
		Car_x-=Car_v;
	}
	public void minusCar_y(){
		Car_y-=Car_v;
	}
	public void setCar_v(int x){
		Car_v=x;
	}
	
	public void plusEnemy_x(){
		Enemy_x+=Enemy_v;
	}
	public void plusEnemy_y(){
		Enemy_y+=Enemy_v;
	}
	public void minusEnemy_x(){
		Enemy_x-=Enemy_v;
	}
	public void minusEnemy_y(){
		Enemy_y-=Enemy_v;
	}
	public void setEnemy_v(int x){
		Enemy_v=x;
	}
	
	
	public int getHero_x() {
		return Hero_x;
	}
	public int getHero_y() {
		return Hero_y;
	}
	public int getHero_v(){
		return Hero_v;
	}
	public int getCar_x() {
		return Car_x;
	}
	public int getCar_y() {
		return Car_y;
	}
	public int getCar_v(){
		return Car_v;
	}
	public int getCar_Des_x() {
		return Car_Des_x;
	}
	public int getCar_Des_y() {
		return Car_Des_y;
	}
	public int getEnemy_x() {
		return Enemy_x;
	}
	public int getEnemy_y() {
		return Enemy_y;
	}
	public int getPos_x() {
		return xpos;
	}
	public int getPos_y() {
		return ypos;
	}
	public int getStart_x() {
		return start_x;
	}
	public int getStart_y() {
		return start_y;
	}
	public int getMenu_x() {
		return menu_x;
	}
	public int getMenu_y() {
		return menu_y;
	}
	public int Target(int x1,int y1,int x2,int y2){
		return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
	}
	public float Target(int x1,int y1,float x2,float y2){
		return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
	}
	public int Target_Max(int x1,int y1){
		return (x1+y1)*(x1+y1);
	}
}
