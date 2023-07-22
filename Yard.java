import greenfoot.*;  

public class Yard extends World
{
    int counter = 50;
    private boolean readPause = true;
    public boolean isPaused = false;
    
    private GreenfootImage menupic = new GreenfootImage ("menu 2.png");
    private GreenfootImage blank = new GreenfootImage ("blank.png");
    
    Score score = new Score();
    Menu menu = new Menu();
    Resume resume = new Resume();
    MainMenu mainmenu = new MainMenu();
    Exit exit = new Exit();
    public Yard()
    {    
        super(1200, 842, 1);
        
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
                if(counter == 50)
                {
                    if(Greenfoot.getRandomNumber(10)<6){
                        Chocolate2 chocolate = new Chocolate2();
                        addObject(chocolate, getWidth(), Greenfoot.getRandomNumber(getHeight()));
                    }
                    Fence fence = new Fence();
                    addObject(fence, getWidth(), Greenfoot.getRandomNumber(getHeight()/2-100) + getHeight()/2 + 200);
                    
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