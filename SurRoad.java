import greenfoot.*;  

public class SurRoad extends Actor
{
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){
            StartScreen.world = "road";
            Greenfoot.setWorld(new Road());
        }
    }    
}
