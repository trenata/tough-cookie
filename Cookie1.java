import greenfoot.*;  

public class Cookie1 extends Actor
{
    int endtime = 3000;
    int Speed = 15;
    int score = 0;
    int i = 0;
    int valasz;
    int x = 1;
    int y = 3;
    static boolean elvivo = false;

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
   
    GreenfootSound hit = new GreenfootSound("hit.mp3");

    public void act() 
    {
        Kitchen theWorld = (Kitchen) getWorld();
        if(!theWorld.isPaused)
        {
            StartScreen.backgroundMusic.setVolume(40);
            StartScreen.backgroundMusic.playLoop();
            setLocation( getX() - Speed, getY() );
            i++;
            
            Move();
            Animate();
            checkEnd();
            
            Actor obstacle = getOneIntersectingObject (Obstacle.class); 
            if( getX() == 0 || obstacle != null) {
                valasz = 0;
                hit.play();
                if(!Question()){
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
                    elvivo = true;
                    setLocation( getWorld().getWidth()/3, getWorld().getHeight()/2);
                }
            }
        }
    } 
    public void checkEnd()
    {
        if(i == endtime && StartScreen.Mode == "story") {
                StartScreen.win.play();
                Score.deathScore = Score.score;
                Greenfoot.setWorld(new Yard());
                Play.play = false;
                StartScreen.world = "yard";
            }
    }
    public void Move()
    {
        if ( Greenfoot.isKeyDown("left") )
            move(-(Speed + 2));
            
        if ( Greenfoot.isKeyDown("right") )
            move(Speed + 2);
            
        if ( Greenfoot.isKeyDown("up") && getY() > 100 )
            setLocation(getX(), getY() - (Speed+2));
            
        if ( Greenfoot.isKeyDown("down") && getY() < getWorld().getHeight()-getImage().getHeight()/2 )
            setLocation(getX(), getY() + Speed-2);
    }
    public void Animate()
    {
        if ( Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left")){
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
        if(!Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("left"))
            setImage(stand);
    }
    public static boolean Question()
    {
        int v = Greenfoot.getRandomNumber(56);
        int valasz = 0;
        boolean jo = true;
        switch (v)
        {
            case 0:valasz = Integer.parseInt(Greenfoot.ask("In what year was the dog Laika sent to the space?"));
                if(valasz!=1957 )
                    return false;
            break;
            case 1: valasz = Integer.parseInt(Greenfoot.ask("In what year did Neil Armstrong first land on the Moon?"));
                if(valasz!=1969 )
                    return false;
            break;
            case 2: valasz = Integer.parseInt(Greenfoot.ask("At what degrees (Celsius) does the water boil?"));
                if(valasz!= 100)
                    return false;
            break;
            case 3: valasz = Integer.parseInt(Greenfoot.ask("How high is the Mount Everest?"));
                if(valasz!= 8848)
                    return false;
            break;
            case 4: valasz = Integer.parseInt(Greenfoot.ask("How many stars are on the flag of the EU?"));
                if(valasz!=12 ) 
            return false;
                break;
            case 5: valasz = Integer.parseInt(Greenfoot.ask("How many stars are on the American flag?"));
                if(valasz!=50 )
                    return false;
            break;
            case 6: valasz = Integer.parseInt(Greenfoot.ask("How many stripes are on the American flag?"));
                if(valasz!=13 )
                    return false;
            break;
            case 7: valasz = Integer.parseInt(Greenfoot.ask("What year did Columbus discover America?"));
                if(valasz!=1492 )
                    return false;
            break;
            case 8: valasz = Integer.parseInt(Greenfoot.ask("How many ships did Columbus have on his first voyage?"));
                if(valasz!=3 )
                    return false;
            break;
            case 9: valasz = Integer.parseInt(Greenfoot.ask("How many ships did Magellan have on his journey around the World?"));
                if(valasz!=5 )
                    return false;
            break;
            case 10: valasz = Integer.parseInt(Greenfoot.ask("How many teeth does an adult have?"));
                if(valasz!= 32)
                    return false;
            break;
            case 11: valasz = Integer.parseInt(Greenfoot.ask("In what year did the First World War end?"));
                if(valasz!=1918 )
                    return false;
            break;
            case 12: valasz = Integer.parseInt(Greenfoot.ask("In what year did the Second World War end?"));
                if(valasz!=1945 )
                    return false;
            break;
            case 13: valasz = Integer.parseInt(Greenfoot.ask("In what year did the First World War begin?"));
                if(valasz!=1914 )
                    return false;
            break;
            case 14: valasz = Integer.parseInt(Greenfoot.ask("In what year did the Second World War begin?"));
                if(valasz!=1939 )
                    return false;
            break;
            case 15: valasz = Integer.parseInt(Greenfoot.ask("How long (km) is the Nile?"));
                if(valasz!=6853 )
                    return false;
            break;
            case 16: valasz = Integer.parseInt(Greenfoot.ask("In what year did Elvis the King (Elvis Presley) die?"));
                if(valasz!=1977 )
                    return false;
            break;
            case 17: valasz = Integer.parseInt(Greenfoot.ask("When was the Google founded?"));
                if(valasz!=1998 )
                    return false;
            break;
            case 18: valasz = Integer.parseInt(Greenfoot.ask("How many months does the pregnancy last?"));
                if(valasz!=9 )
                    return false;
            break;
            case 19: valasz = Integer.parseInt(Greenfoot.ask("In what year did the Walt Disney’s Snow White come out?"));
                if(valasz!=1937 )
                    return false;
            break;
            case 20: valasz = Integer.parseInt(Greenfoot.ask("How many characters are in the English alphabet?"));
                if(valasz!= 26)
                    return false;
            break;
            case 21: valasz = Integer.parseInt(Greenfoot.ask("How many hours are in a week?"));
                if(valasz!=168 )
                    return false;
            break;
            case 22: valasz = Integer.parseInt(Greenfoot.ask("How many days are in June?"));
                if(valasz!= 30)
                    return false;
            break;
            case 23: valasz = Integer.parseInt(Greenfoot.ask("In what year did the American Civil War begin?"));
                if(valasz!= 1861)
                    return false;
            break;
            case 24: valasz = Integer.parseInt(Greenfoot.ask("How many ossicles are in the ear?"));
                if(valasz!= 3)
                    return false;
            break;
            case 25: valasz = Integer.parseInt(Greenfoot.ask("In what year did the Berlin Wall fall?"));
                if(valasz!= 1989)
                    return false;
            break;
            case 26: valasz = Integer.parseInt(Greenfoot.ask("How many kidneys do we have?"));
                if(valasz!= 2)
                    return false;
            break;
            case 27: valasz = Integer.parseInt(Greenfoot.ask("How many cms are in one km?"));
                if(valasz!= 100000)
                    return false;
            break;
            case 28: valasz = Integer.parseInt(Greenfoot.ask("How many dm^3 are 1 liter?"));
                if(valasz!= 1)
                    return false;
            break;
            case 29: valasz = Integer.parseInt(Greenfoot.ask("What is the gravity of the Earth? (rounded)"));
                if(valasz!= 10)
                    return false;
            break;
            case 30: valasz = Integer.parseInt(Greenfoot.ask("1 + 1 + 1 * 0 + 1 ="));
                if(valasz!=3 )
                    return false;
            break;
            case 31: valasz = Integer.parseInt(Greenfoot.ask("x^ 2 - 2x + 1"));
                if(valasz!= 1)
                    return false;
            break;
            case 32: valasz = Integer.parseInt(Greenfoot.ask("How many oxygen atoms are in a water molecule?"));
                if(valasz!= 1)
                    return false;
            break;
            case 33: valasz = Integer.parseInt(Greenfoot.ask("0 / [(5^13) * 9] + 2"));
                if(valasz!= 2)
                    return false;
            break;
            case 34: valasz = Integer.parseInt(Greenfoot.ask("cos0 ="));
                if(valasz!= 1)
                    return false;
            break;
            case 35: valasz = Integer.parseInt(Greenfoot.ask("cos^2(75) +sin^2(75)  ="));
                if(valasz!= 1)
                    return false;
            break;
            case 36: valasz = Integer.parseInt(Greenfoot.ask("2^10 ="));
                if(valasz!= 1024)
                    return false;
            break;
            case 37: valasz = Integer.parseInt(Greenfoot.ask("1 + 1 + 2 + 2 + 1 + 2 + 1 + 2 + 4 + 2 ="));
                if(valasz!=18 )
                    return false;
            break;
            case 38: valasz = Integer.parseInt(Greenfoot.ask("1823 – 876 ="));
                if(valasz!= 947)
                    return false;
            break;
            case 39: valasz = Integer.parseInt(Greenfoot.ask("1893152 – 900124 ="));
                if(valasz!= 993028)
                    return false;
            break;
            case 40: valasz = Integer.parseInt(Greenfoot.ask("351 – (5 * 12 – 3 * 4) ="));
                if(valasz!= 403)
                    return false;
            break;
            case 41: valasz = Integer.parseInt(Greenfoot.ask("In what year was Einstein born?"));
                if(valasz!= 1879)
                    return false;
            break;
            case 42: valasz = Integer.parseInt(Greenfoot.ask("How many countries are in Europe?"));
                if(valasz!=44 )
                    return false;
            break;
            case 43: valasz = Integer.parseInt(Greenfoot.ask("How many capitals does Cuba have?"));
                if(valasz!= 1)
                    return false;
            break;
            case 44: valasz = Integer.parseInt(Greenfoot.ask("How many Oscars did the 'Titanic' win?"));
                if(valasz!= 11)
                    return false;
            break;
            case 45: valasz = Integer.parseInt(Greenfoot.ask("In what year was Puskas Ferenc born?"));
                if(valasz!= 1927)
                    return false;
            break;
            case 46: valasz = Integer.parseInt(Greenfoot.ask("In what year was Pelé born?"));
                if(valasz!=1940 )
                    return false;
            break;
            case 47: valasz = Integer.parseInt(Greenfoot.ask("In what year was Winston Churchill born?"));
                if(valasz!= 1874)
                    return false;
            break;
            case 48: valasz = Integer.parseInt(Greenfoot.ask("In what year did Marilyn Monroe die?"));
                    if(valasz!= 1962)
                        return false;
            break;
            case 49: valasz = Integer.parseInt(Greenfoot.ask("How many members were in The Beatles?"));
                if(valasz!= 4)
                    return false;
            break;
            case 50: valasz = Integer.parseInt(Greenfoot.ask("How many oxigen atoms are in a hydrochloric acid molecule?"));
                if(valasz!=4 )
                    return false;
            break;
            case 51: valasz = Integer.parseInt(Greenfoot.ask("How many hidrogen atoms are in a hydrochloric acid molecule?"));
                if(valasz!= 2)
                    return false;
            break;
            case 52: valasz = Integer.parseInt(Greenfoot.ask("What is the approximate speed of light? (m/s)"));
                if(valasz!= 300000000)
                    return false;
            break;
            case 53: valasz = Integer.parseInt(Greenfoot.ask("What year did the French Revolution start?"));
                if(valasz!=1789 )
                    return false;
            break;
            case 54: valasz = Integer.parseInt(Greenfoot.ask("In what year was the first Football World Cup held?"));
                if(valasz!= 1930)
                    return false;
            break;
            case 55: valasz = Integer.parseInt(Greenfoot.ask("1+1+1*(0+1)+1 ="));
                if(valasz!= 4)
                    return false;
            break;
        }
        return true;
    }
}
