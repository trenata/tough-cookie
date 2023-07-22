import greenfoot.*; 

public class StartScreen extends World
{
    static String Mode; 
    static String world = "start";
    
    static GreenfootSound backgroundMusic = new GreenfootSound("background.mp3");
    static GreenfootSound over = new GreenfootSound("gameover.mp3");
    static GreenfootSound win = new GreenfootSound("win.mp3");
    static GreenfootSound point = new GreenfootSound("point.mp3");
    public StartScreen()
    {  
        super(1200, 842, 1, true);
       
        StartGame startgame = new StartGame();
        addObject(startgame, getWidth()/4, getHeight()/2);
        
        SurvivalMode survivalmode = new SurvivalMode();
        addObject(survivalmode, getWidth()/3, getHeight()*2/3);
        
        Exit exit = new Exit();
        addObject(exit, getWidth()/4, getHeight()*5/6);
        
        Play.play = false;
    }
    public void act(){
        if(Play.play != true){
            backgroundMusic.playLoop();
            backgroundMusic.setVolume(40);
        }
    }
}
