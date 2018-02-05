package Basic;

public class Model {
	private static int heroLife=3; //�ʱ� ���� ������.
	
	boolean feelkey=false;//�ñر� ������� boolean
	
	int start_x;//start�ΰ� x��
	int start_y;//start�ΰ� y��
	
	int Hero_x; //�ʱ� ���� x��
    int Hero_y;//�ʱ� ���� Y��
    int Hero_v = 1; //1��ŭ �����̰Բ�

    int Car_x; //�ʱ� ȭ�� x��
    int Car_y;//�ʱ� ȭ�� Y��
    int Car_v = 1; //1��ŭ �����̰Բ�

    int Car_Des_x ; //ȭ�� ������ ��ġ
    int Car_Des_y ; // ȭ�� ������ ��ġ
    
    int Enemy_x;//�ʱ� �� x
    int Enemy_y;//�ʱ� �� y
    int Enemy_v = 1; //  �����̰Բ�.
    
	int xpos;//���콺 x��ǥ
	int ypos;//���콺 y��ǥ
	
	int menu_x;//�޴�x��ǥ
	int menu_y;//�޴�y��ǥ
	
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
