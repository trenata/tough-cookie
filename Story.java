import greenfoot.*;  

public class Story extends Actor
{
    int click = 0;
    
    private GreenfootImage story1 = new GreenfootImage ("story1.jpg");
    private GreenfootImage story2 = new GreenfootImage ("story2.jpg");
    private GreenfootImage story3 = new GreenfootImage ("story3.jpg");
    private GreenfootImage story4 = new GreenfootImage ("story4.jpg");
    private GreenfootImage story5 = new GreenfootImage ("story5.jpg");
    
    private GreenfootImage story6 = new GreenfootImage ("story6.jpg");
    private GreenfootImage story7 = new GreenfootImage ("story7.jpg");
    private GreenfootImage story8 = new GreenfootImage ("story8.jpg");
    private GreenfootImage end = new GreenfootImage ("theend.jpg");
    
    private GreenfootImage menupic = new GreenfootImage ("menu 1.png");
    
    Play play = new Play();
    Menu menu = new Menu();
    
    public void act() 
    {
        StartScreen.backgroundMusic.setVolume(25);
        if(Greenfoot.mouseClicked(this))
                click++;
        if (click == 1)
            setImage(story2);
        if(click == 2)
            setImage(story3);
        if(click == 3)
            setImage(story4);
        if(click == 4)
            setImage(story5);
        if(click == 5){
            menu.setImage(menupic);
            getWorld().addObject(menu, getWorld().getWidth()/2, getWorld().getHeight()/2);
            getWorld().addObject(play, getWorld().getWidth()/2, getWorld().getHeight()/2+100);
            StartScreen.backgroundMusic.setVolume(40);
            getWorld().removeObject(this);
        }
        Score.score = 0; 
        
        if(StartScreen.world == "road"){
            setImage(story6);
            if(click == 1)
               setImage(story7);
            if(click == 2)
                setImage(story8);
            if(click == 3){
               setImage(end);
               Cookie3.tough.stop();
               Greenfoot.stop();
            }
        }
    }
}    

