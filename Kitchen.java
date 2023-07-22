import greenfoot.*;  

public class Kitchen extends World
{
    int counter = 10;
    private boolean readPause = true;
    public boolean isPaused = false;
    
    private GreenfootImage apple = new GreenfootImage ("apple.png");
    private GreenfootImage cup = new GreenfootImage ("cup.png");
    private GreenfootImage hand = new GreenfootImage ("hand.png");
    private GreenfootImage fork = new GreenfootImage ("fork.png");
    private GreenfootImage spoon = new GreenfootImage ("spoon.png");
    private GreenfootImage knife = new GreenfootImage ("knife.png");
    private GreenfootImage blank = new GreenfootImage ("blank.png");
    
    private GreenfootImage menupic = new GreenfootImage ("menu 1.png");
    
    Score score = new Score();
    Menu menu = new Menu();
    Resume resume = new Resume();
    MainMenu mainmenu = new MainMenu();
    Exit exit = new Exit();
    
    public Kitchen()
    {    
        super(1200, 842, 1); 
        addObject(score, 65, 10);
        if(StartScreen.Mode == "story"){
            Story story = new Story();
            addObject(story, getWidth()/2, getHeight()/2);
        }
        else{
            Play play = new Play();
            Menu menu2 = new Menu();
            menu2.setImage(menupic);
            addObject(menu2, getWidth()/2, getHeight()/2);
            addObject(play, getWidth()/2, getHeight()/2+100);
        }
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
                if(counter == 50)
                {
                    int x = Greenfoot.getRandomNumber(10);
                    Obstacle obstacle = new Obstacle();
                    if (x == 1 || x == 2)
                        obstacle.setImage(apple);
                    else if( x> 2 && x < 5 )
                        obstacle.setImage(cup);
                    else if( x == 6)
                        obstacle.setImage(fork);
                    else if( x == 7)
                        obstacle.setImage(spoon);
                    else if( x == 5 )
                        obstacle.setImage(knife);
                    else if( x == 0)
                        obstacle.setImage(hand);
                    if(x >= 8)
                    {
                        Chocolate chocolate = new Chocolate();
                        addObject(chocolate, getWidth(), Greenfoot.getRandomNumber(getHeight() - 150) + 149);
                    }
                    else if( x == 0)
                         addObject(obstacle, getWidth(), getHeight() - 100);
                    else addObject(obstacle, getWidth(), Greenfoot.getRandomNumber(getHeight() - 150) + 150);
                    counter = Greenfoot.getRandomNumber(20);
                }
                counter++; 
            }
        }
    }
    public Score getScore()
    {
        return score;
    }
}
