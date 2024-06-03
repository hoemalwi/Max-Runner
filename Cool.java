import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cool extends Actor
{
    public GreenfootImage[] imagesRun= new GreenfootImage[8];
    public GreenfootImage[] imagesJump= new GreenfootImage[11];
    public GreenfootImage[] imagesIdle= new GreenfootImage[6];
    public int countRun= 0;
    public int countRun1 = 0;
    public int countJump = 0;
    public int countJump1 = 0;
    public int countIdle = 0;
    public int countIdle1 = 0;
    public final int gravitasi = 1;
    public int kecepatan;
    public boolean falling = false;
    public GreenfootSound backSoundCoin;
    public int score = 0;
    public int num = 0;
    /*
     * Act - do whatever the dino wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Cool(){
        animJump();
        animRun();
        animIdle();
        kecepatan = 0;
        
        
    }
    public void act()
    {
        
    }
    public void Running(){
        if(countRun1 % 4 == 0 ){
        setImage(imagesRun[countRun++ %8]);
        
        }
        if(countRun1 > 32){
            countRun1 = 0;
        }
        
        countRun1 ++;
        
    }
    public void animRun(){
       for(int i = 0; i < 8; i++){
            int a = i+1;
            String filename = "Run_"+ a + ".png";
            imagesRun[i] = new GreenfootImage(filename);   
        } 
    }
    public void animJump(){
        for(int i = 0; i < 11; i++){
            int a = i+1;
            String filename = "Jump_"+ a + ".png";
            imagesJump[i] = new GreenfootImage(filename);   
        } 
        
    }
    public void animIdle(){
        for(int i = 0; i < 6; i++){
            int a = i+1;
            String filename = "CoolIdle_"+ a + ".png";
            imagesIdle[i] = new GreenfootImage(filename);   
        }
        
    }
    public void Idle(){
        
        if(countIdle1 % 8 == 0 ){
        setImage(imagesIdle[countIdle++ %6]);
        
        }
        if(countIdle1 > 48){
            countIdle1 = 0;
        }
        countIdle1 ++;
    }
    
    public void Jumping(){
        if (countJump1 % 2 == 0) {
            setImage(imagesJump[countJump++ % 11]);
        }
        if (countJump1 > 2) {
            countJump1 = 0;
        }
        countJump1 ++;
    }
    
    public void jump(){
        kecepatan = -13;
    }
    
    public void out(){
        setLocation(getX() + num, getY());
        if(getX() == 0){
            num = 0;
        } else {
            num = 1;
        }
    
    }
    
    public void checkDrink(int val) {
        World myWorld = getWorld();
        Main bg = (Main)myWorld;
        Energy energy = bg.getEnergy();
        
        if (energy.energy == val){
            num = 1;
        }
    }
}