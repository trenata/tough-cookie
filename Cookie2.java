import greenfoot.*;  

public class Cookie2 extends Actor
{
    int endtime = 3000;
    int db = 0;
    int Fall_Speed = -10;
    int at = 0;
    int score = 0;
    int i = 0;
    int x=0, y=3;
    int valasz;
    double Vspeed = 0;
    double a = 1.5;
    double BS = -22;
    boolean levego = false;
    
    private GreenfootImage air = new GreenfootImage ("air.png");
    private GreenfootImage stand = new GreenfootImage ("stand.png");
    private GreenfootImage r1 = new GreenfootImage ("run1.png");
    private GreenfootImage r2 = new GreenfootImage ("run2.png");
    private GreenfootImage r3 = new GreenfootImage ("run3.png");
    private GreenfootImage r4 = new GreenfootImage ("run4.png");
    private GreenfootImage r5 = new GreenfootImage ("run5.png");
    private GreenfootImage r6 = new GreenfootImage ("run6.png");
    private GreenfootImage r7 = new GreenfootImage ("run7.png");
    private GreenfootImage r8 = new GreenfootImage ("run8.png");
    
    private GreenfootImage blank = new GreenfootImage ("blank.png");
    
    GreenfootSound jump = new GreenfootSound("jump.wav");
    
    public void act() 
    {
        Yard theWorld = (Yard) getWorld();
        if(!theWorld.isPaused)
        {
            StartScreen.backgroundMusic.setVolume(40);
            StartScreen.backgroundMusic.playLoop();
            
            setLocation( getX() + Fall_Speed, getY() );
            Move();
            Animate();
            checkFall();
            i++;
            
            if( onFence() ){
                db = 0;
            }
            if( getX() == 0 || getY() > getWorld().getHeight() - 100 ) {
                valasz = 0;
                if(!Cookie1.Question()){
                    StartScreen.backgroundMusic.pause();
                    StartScreen.over.play();
                    
                    GameOver gameOver = new GameOver();
                    Menu menu = new Menu();
                    menu.setImage(blank);
                    Replay replay = new Replay();
                    MainMenu mainmenu = new MainMenu();
                    Exit exit = new Exit();
                    
                    getWorld().addObject(menu, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                    getWorld().addObject(gameOver, getWorld().getWidth() / 2, getWorld().getHeight() / 4);
                    getWorld().addObject(replay, getWorld().getWidth() / 2, getWorld().getHeight() / 2 - 50 );
                    getWorld().addObject(mainmenu, getWorld().getWidth() / 2, getWorld().getHeight() / 2 + 95);
                    getWorld().addObject(exit, getWorld().getWidth() / 2, getWorld().getHeight() / 2 + 250);
                    
                    Play.play = false;
                    theWorld.isPaused = true;
                }
                else{
                    setLocation( getWorld().getWidth()/2, 0);
                    Vspeed = 0;
                }
            }
            if(i == endtime && StartScreen.Mode == "story") {
                StartScreen.win.play();
                Score.deathScore = Score.score;
                Greenfoot.setWorld(new Road());
                Play.play = false;
                StartScreen.world = "road";
            }
        }
    }
    private void Move()
    {
        if(Greenfoot.isKeyDown("right") && !beforeFence() )
        {
           move(13);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-13);
        }
        if(Greenfoot.isKeyDown("up"))
        {
            if( db == 0 ) {
                jump.play();
                db++;
                Vspeed = BS;
                levego = false;
                
                fall();
            }
        }
    }
    public void checkFall()
    {
        if(onFence() || (getY() > getWorld().getHeight() - getImage().getHeight() / 2 && getY() != getWorld().getHeight())){
            Vspeed = 0;
            levego = false;
        }
        else
        {
            levego = true;
            fall();
        }
    }
    public boolean onFence()
    {
        Actor under = getOneObjectAtOffset ( 0, getImage().getHeight() / 2, Fence.class);
        return under != null;
    }
    public boolean beforeFence()
    {
        Actor before = getOneObjectAtOffset ( getImage().getWidth() / 2, 0, Fence.class);
        return before != null;
    }
    public void fall()
    {
        setLocation( getX(), (int)(getY() + Vspeed) );
        Vspeed = Vspeed + a;
    } 
    public void Animate()
    {
        if ( (Greenfoot.isKeyDown("right") && onFence())|| (Greenfoot.isKeyDown("left") && onFence())){
            x++;
            if(x<y)
                setImage(r1);
            if(getImage().equals(r1) && x>y)
                    setImage(r2);
            else
            if(getImage().equals(r2) && x>2*y)
                setImage(r3);
            else
            if(getImage().equals(r3) && x>3*y)
                setImage(r4);
            else
            if(getImage().equals(r4) && x>4*y)
                setImage(r5);
            else
            if(getImage().equals(r5) && x>5*y)
                setImage(r6);
            else
            if(getImage().equals(r6) && x>6*y)
                setImage(r7);
            else
            if(getImage().equals(r7) && x>7*y)
                setImage(r8);
            else if(x>8*y){
                setImage(r1);
                x=0;
            }
        }
        else{
            setImage(stand);
        }
        if(levego == true) 
            setImage(air);
    }
}
