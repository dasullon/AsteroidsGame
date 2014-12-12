import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class AsteroidsGame extends PApplet {

SpaceShip ha_mez= new SpaceShip();
ArrayList <Asteroid> falcao;
Starzz [] james;
boolean asteroidHit = false; 
int hitCounter=0;
ArrayList <Bullets>j_rod;
boolean gameOver= false;
PImage img;
public void setup() 
{
 img = loadImage("James.jpg");
 size(610,431);
 background(0);
 james=new Starzz[100];
 falcao= new ArrayList<Asteroid>();
 j_rod= new ArrayList <Bullets>();
 for (int i =0; i<james.length; i++)
 {
  james[i] = new Starzz();
}
for (int nI =0; nI<20; nI++)
{
 falcao.add(new Asteroid());
}
}

public void draw() 
{
  if(gameOver == false)
  {
    background(0);
    for (int i=0; i< james.length;i++)
    {
      james[i].show();
    } 
    for (int i=0; i< falcao.size();i++)
    {
      falcao.get(i).show();
      falcao.get(i).move();
    } 
    for (int i=0; i< j_rod.size();i++)
    {
      j_rod.get(i).show();
      j_rod.get(i).move();  

    }
    ha_mez.show();
    ha_mez.move();
  }

  if (gameOver==true){
   if (hitCounter==20){
    background(img);
    textSize(24); 
    stroke(100);  
    text ("You Won!", 50,75);
  } 
  else{
   background(0);
   textSize(24);
   text ("You lost! Better luck next time!", 130,220);
 }
}
}

public void keyPressed()
{
   if(key=='2') //hyperspace
   {
    ha_mez.setX((int)(Math.random()*610));
    ha_mez.setDirectionX(0);
    ha_mez.setY((int)(Math.random()*431));
    ha_mez.setDirectionY(0);
    ha_mez.setPointDirection((int)(Math.random()*360));
  }
  if (key=='w'||key=='W'){
    ha_mez.accelerate(0.1f);
  }
  if (key=='s'||key=='S'){
    ha_mez.accelerate(-0.1f);
  }
  if (key=='a'||key=='A'){
   ha_mez.rotate(-20);
 }
 if (key=='d'||key=='D'){
  ha_mez.rotate(20);
}
if(key==' '){
  j_rod.add(new Bullets());
}
//remove spaceship
for (int i = 0; i < falcao.size(); i++){
  int distanceTo = (int) dist(ha_mez.getX(), (int )ha_mez.getY(), (int )falcao.get(i).getX(), (int) falcao.get(i).getY());
  if(distanceTo < 20){
    gameOver=true;
  }
}
// if bullet hits, remove asteroid
for (int i = 0; i < j_rod.size(); i++){
  for (int a = 0; a < falcao.size(); a++){
    int distanceTo = (int) dist(j_rod.get(i).getX(),(int)j_rod.get(i).getY(), (int)falcao.get(a).getX(), (int) falcao.get(a).getY());
    if(distanceTo < 20){
      falcao.remove(a);
      hitCounter++;
    }
  }
}
}
class Starzz
{
  int x,y; 
  Starzz()
  {
    x=(int)(Math.random()*609 +1);
    y=(int)(Math.random()*430 +1);
  }
  public void show()
  {
    stroke(255);  
    ellipse(x, y, 3, 3);
  }
}//

class Asteroid extends Floater{
 public int rotHames;
 Asteroid(){
  rotHames= ((int)(Math.random()*6)-5);
  corners = 6;
  xCorners = new int[corners];
  yCorners = new int[corners];
  xCorners[0] = -11;
  yCorners[0] = -8;
  xCorners[1] = 7;
  yCorners[1] = -8;
  xCorners[2] = 13;
  yCorners[2] = 0;
  xCorners[3] = 6;
  yCorners[3] = 10;
  xCorners[4] = -11;
  yCorners[4] = 8;
  xCorners[5] = -5;
  yCorners[5] = 0;
  myCenterX=((int)(Math.random()*610)+1);
  myCenterY=((int)(Math.random()*431)+1);
  myDirectionX=((int)(Math.random()*10-5));
  myDirectionY=((int)(Math.random()*12-6));
  myPointDirection=((int)(Math.random()*2));
  myColor= color(170);
}
public void setX(int x){myCenterX=x;}
public int getX(){return (int)myCenterX;}
public void setY(int y){myCenterY=y;}
public int getY(){return (int)myCenterY;}
public void setDirectionX(double x){myDirectionX=x;}
public double getDirectionX () {return myDirectionX;}
public void setDirectionY(double y){myDirectionY=y;}
public double getDirectionY () {return myDirectionY;}
public void setPointDirection(int degrees) {myPointDirection=degrees;}
public double getPointDirection() {return myPointDirection;}

public void move(){
 rotate(rotHames);
 super.move();
}
}// 

class SpaceShip extends Floater  
{   
  public SpaceShip(){
    corners = 4;
    xCorners = new int[corners];
    yCorners = new int[corners];
    xCorners[0] = -8;
    yCorners[0] = -8;
    xCorners[1] = 16;
    yCorners[1] = 0;
    xCorners[2] = -8;
    yCorners[2] = 8;
    xCorners[3] = -2;
    yCorners[3] = 0;
    myCenterX=250;
    myCenterY=250;
    myDirectionX=0;
    myDirectionY=0;
    myPointDirection=0;
    myColor= color(0,255,255);
  }
  public void setX(int x){myCenterX=x;}
  public int getX(){return (int)myCenterX;}
  public void setY(int y){myCenterY=y;}
  public int getY(){return (int)myCenterY;}
  public void setDirectionX(double x){myDirectionX=x;}
  public double getDirectionX () {return myDirectionX;}
  public void setDirectionY(double y){myDirectionY=y;}
  public double getDirectionY () {return myDirectionY;}
  public void setPointDirection(int degrees) {myPointDirection=degrees;}
  public double getPointDirection() {return myPointDirection;}
}//

abstract class Floater //Do NOT modify the Floater class! Make changes in the SpaceShip class 
{   
  protected int corners;  //the number of corners, a triangular floater has 3   
  protected int[] xCorners;   
  protected int[] yCorners;   
  protected int myColor;   
  protected double myCenterX, myCenterY; //holds center coordinates   
  protected double myDirectionX, myDirectionY; //holds x and y coordinates of the vector for direction of travel   
  protected double myPointDirection; //holds current direction the ship is pointing in degrees    
  abstract public void setX(int x);  
  abstract public int getX();   
  abstract public void setY(int y);   
  abstract public int getY();   
  abstract public void setDirectionX(double x);   
  abstract public double getDirectionX();   
  abstract public void setDirectionY(double y);   
  abstract public double getDirectionY();   
  abstract public void setPointDirection(int degrees);   
  abstract public double getPointDirection(); 

  //Accelerates the floater in the direction it is pointing (myPointDirection)   
  public void accelerate (double dAmount)   
  {          
    //convert the current direction the floater is pointing to radians    
    double dRadians =myPointDirection*(Math.PI/180);     
    //change coordinates of direction of travel    
    myDirectionX += ((dAmount) * Math.cos(dRadians));    
    myDirectionY += ((dAmount) * Math.sin(dRadians));       
  }   
  public void rotate (int nDegreesOfRotation)   
  {     
    //rotates the floater by a given number of degrees    
    myPointDirection+=nDegreesOfRotation;   
  }   
  public void move ()   //move the floater in the current direction of travel
  {      
    //change the x and y coordinates by myDirectionX and myDirectionY       
    myCenterX += myDirectionX;    
    myCenterY += myDirectionY;     

    //wrap around screen    
    if(myCenterX >width)
    {     
      myCenterX = 0;    
    }    
    else if (myCenterX<0)
    {     
      myCenterX = width;    
    }    
    if(myCenterY >height)
    {    
      myCenterY = 0;    
    }   
    else if (myCenterY < 0)
    {     
      myCenterY = height;    
    }   
  }   
  public void show ()  //Draws the floater at the current position  
  {             
    fill(myColor);   
    stroke(myColor);    
    //convert degrees to radians for sin and cos         
    double dRadians = myPointDirection*(Math.PI/180);                 
    int xRotatedTranslated, yRotatedTranslated;    
    beginShape();         
    for(int nI = 0; nI < corners; nI++)    
    {     
      //rotate and translate the coordinates of the floater using current direction 
      xRotatedTranslated = (int)((xCorners[nI]* Math.cos(dRadians)) - (yCorners[nI] * Math.sin(dRadians))+myCenterX);     
      yRotatedTranslated = (int)((xCorners[nI]* Math.sin(dRadians)) + (yCorners[nI] * Math.cos(dRadians))+myCenterY);      
      vertex(xRotatedTranslated,yRotatedTranslated);    
    }   
    endShape(CLOSE);  
  }     
}

class Bullets extends Floater
{
  public Bullets(){
    corners = 4;
    xCorners = new int[corners];
    yCorners = new int[corners];
    xCorners[0] = -8;
    yCorners[0] = -8;
    xCorners[1] = 16;
    yCorners[1] = 0;
    xCorners[2] = -8;
    yCorners[2] = 8;
    xCorners[3] = -2;
    yCorners[3] = 0;
    myCenterX=ha_mez.getX();
    myCenterY=ha_mez.getY();
    myPointDirection=ha_mez.getPointDirection();
    double dRadians = myPointDirection*(Math.PI/180); 
    myDirectionX= 5 * Math.cos(dRadians)+ha_mez.getDirectionX();
    myDirectionY= 5 * Math.sin(dRadians) +  ha_mez.getDirectionY();
    myColor= color(255,0,0);
  }
  public void setX(int x){myCenterX=x;}
  public int getX(){return (int)myCenterX;}
  public void setY(int y){myCenterY=y;}
  public int getY(){return (int)myCenterY;}
  public void setDirectionX(double x){myDirectionX=x;}
  public double getDirectionX () {return myDirectionX;}
  public void setDirectionY(double y){myDirectionY=y;}
  public double getDirectionY () {return myDirectionY;}
  public void setPointDirection(int degrees) {myPointDirection=degrees;}
  public double getPointDirection() {return myPointDirection;} 

  public void move(){
    myCenterX += myDirectionX;    
    myCenterY += myDirectionY;     

    if(myCenterX >width)
    {     
      j_rod.remove(this);    
    }    
    else if (myCenterX<0)
    {     
      j_rod.remove(this);      
    }    
    if(myCenterY >height)
    {    
     j_rod.remove(this);     
   }   
   else if (myCenterY < 0)
   {     
    j_rod.remove(this);       
  } 
}
}//
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "AsteroidsGame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
