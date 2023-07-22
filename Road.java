import greenfoot.*;  

public class Road extends World
{
    int d = 50;
    private boolean readPause = true;
    public boolean isPaused = false;
   
    private GreenfootImage menupic = new GreenfootImage ("menu 3.png");
    private GreenfootImage blank = new GreenfootImage ("blank.png");
    
    Score score = new Score();  
    Menu menu = new Menu();
    Resume resume = new Resume();
    MainMenu mainmenu = new MainMenu();
    Exit exit = new Exit();
    public Road()
    {    
        super(1200, 842, 1);
        
        Chocolate3 chocolate = new Chocolate3();
        addObject(chocolate, Greenfoot.getRandomNumber(getWidth()-100)+50, Greenfoot.getRandomNumber(getHeight()-100)+50);
        
        Menu menu = new Menu();
        menu.setImage(menupic);
        addObject(menu, getWidth()/2, getHeight()/2);
        
        Play play = new Play();
        addObject(play, getWidth()/2, getHeight()/2+100);
        
        addObject(score, 65, 10);
    }
    public void act(){
        if(Play.play == true){
            if(!readPause && !Greenfoot.isKeyDown("p"))
            readPause = true;
            if((Greenfoot.isKeyDown("p") || Greenfoot.mouseClicked(resume)) && readPause)
            {
                if(isPaused) {
                    isPaused = false;
                    
                    removeObject(menu);
                    removeObject(resume);
                    removeObject(mainmenu);
                    removeObject(exit);
                }
                else{
                    isPaused = true;
                    
                    menu.setImage(blank);
                    addObject(menu, getWidth() / 2, getHeight() / 2);
                    addObject(resume, getWidth() / 2, getHeight() / 2 - 200);
                    addObject(mainmenu, getWidth() / 2, getHeight() / 2);
                    addObject(exit, getWidth() / 2, getHeight() / 2 + 200);
                }
                readPause = false;
            }
            if(!isPaused)
            {
                if(d == Greenfoot.getRandomNumber(40) + 50)
                {
                    Car1 car1 = new Car1();
                    addObject(car1, 0, getHeight()/6-60);
                    d = 0;
                }
                if(d == Greenfoot.getRandomNumber(40) + 50)
                {
                    Car1 car2 = new Car1();
                    addObject(car2, 0, getHeight()*3/6-60);
                    d = 0;
                }
                if(d == Greenfoot.getRandomNumber(40) + 50)
                {
                    Car1 car3 = new Car1();
                    addObject(car3, 0, getHeight()*5/6-60);
                    d = 0;
                }
                if(d == Greenfoot.getRandomNumber(40) + 50)
                {
                   Car2 car4 = new Car2();
                    addObject(car4, getWidth(), getHeight()*2/6-60);
                    d = 0;
                }
                if(d == Greenfoot.getRandomNumber(40) + 50)
                {
                    Car2 car5 = new Car2();
                    addObject(car5, getWidth(), getHeight()*4/6-60);
                    d = 0;
                }
                d++;
                if(d>120)
                {
                    d = 0;
                }
            }
       }
    }
    public Score getScore()
    {
        return score;
    }
}
