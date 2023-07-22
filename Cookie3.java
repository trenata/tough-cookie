import greenfoot.*; 

public class Cookie3 extends Actor
{
    int finalScore = 75;
    int Speed = 10;
    int x=0,y=2, x1=0, y1=2;
    int valasz;
    
    private GreenfootImage stand = new GreenfootImage ("stand.png");
    private GreenfootImage r1 = new GreenfootImage ("move1.png");
    private GreenfootImage r2 = new GreenfootImage ("move2.png");
    private GreenfootImage r3 = new GreenfootImage ("move3.png");
    private GreenfootImage r4 = new GreenfootImage ("move4.png");
    
    private GreenfootImage blank = new GreenfootImage ("blank.png");
    
    GreenfootSound crash = new GreenfootSound("crash.mp3");
    static GreenfootSound tough = new GreenfootSound("ToughCookie.mp3");

    public Cookie3()
    {
        GreenfootImage image = getImage();
        image.scale(90, 108);
        setImage(image);
    }
    public void act() 
    {
        Road theWorld = (Road) getWorld();
        if(!theWorld.isPaused)
        {
            StartScreen.backgroundMusic.setVolume(40);
            StartScreen.backgroundMusic.playLoop();
            
            Move();
            Animate();
            
            Actor car1 = getOneIntersectingObject (Car1.class); 
            Actor car2 = getOneIntersectingObject (Car2.class); 
            if( car1 != null || car2 != null) {
                valasz = 0;
                crash.play();
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
                    setLocation( getWorld().getWidth()/2, getWorld().getHeight() - 30);
                }
            }
            if(Score.score == finalScore && StartScreen.Mode == "story"){
                StartScreen.backgroundMusic.pause();
                StartScreen.win.play();
                tough.playLoop();
                tough.setVolume(50);

                getWorld().removeObjects(getWorld().getObjects(Car1.class));
                getWorld().removeObjects(getWorld().getObjects(Car2.class));
                
                theWorld.isPaused = true;
                Story story = new Story();
                getWorld().addObject(story, getWorld().getWidth()/2, getWorld().getHeight()/2);
            }
        }
        else
            StartScreen.backgroundMusic.pause();
    } 
    public void Move()
    {
        if ( Greenfoot.isKeyDown("left") )
        {
            move(-Speed );
        }
        if ( Greenfoot.isKeyDown("right") )
        {
            move(Speed);
        }
        if ( Greenfoot.isKeyDown("up") && getY() > 100 )
        {
            setLocation(getX(), getY() - Speed );
        }
        if ( Greenfoot.isKeyDown("down") && getY() < getWorld().getHeight()-getImage().getHeight()/2 )
        {
            setLocation(getX(), getY() + Speed);
        }
    }
    public void Animate()
    {
        if ( Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down")){ 
            x++;
            if(x<y)
            setImage(r1);
            if(getImage().equals(r1) && x>y)
                setImage(r2);
            else if(x>2*y){
                setImage(r1);
                x=0;
            }
        }
        else
        {
            if ( Greenfoot.isKeyDown("left") ){ 
                x1++;
                if(x1<y1)
                    setImage(r1);
                if(getImage().equals(r1) && x1>y1)
                        setImage(r3);
                else if(x1>2*y1){
                    setImage(r1);
                    x=0;
                }
            }
            else
            {
                if ( Greenfoot.isKeyDown("right") ){ 
                    x1++;
                    if(x1<y1)
                        setImage(r1);
                    if(getImage().equals(r1) && x1>y1)
                        setImage(r4);
                    else if(x1>2*y1){
                        setImage(r1);
                        x=0;
                    }
                }
            }
        }
    }
}
