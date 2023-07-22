import greenfoot.*;  

public class SurKitch extends Actor
{
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){
            StartScreen.world = "kitchen";
            Greenfoot.setWorld(new Kitchen());
        }
    }    
}
