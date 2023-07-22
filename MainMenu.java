import greenfoot.*;  

public class MainMenu extends Actor
{
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
            Greenfoot.setWorld(new StartScreen());
    }    
}
