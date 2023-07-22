import greenfoot.*;  

public class StartGame extends Actor
{
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            StartScreen.Mode = "story";
            Greenfoot.setWorld(new Kitchen());
            StartScreen.world = "kitchen";
        }
    }    
}
