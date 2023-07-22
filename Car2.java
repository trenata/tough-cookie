import greenfoot.*;  

public class Car2 extends Actor
{
    public void act() 
    {
        Road theWorld = (Road) getWorld();
        if(!theWorld.isPaused)
        {
            setLocation( getX() - Greenfoot.getRandomNumber(6) - 10, getY());
            if(getX() == 0) {
                 getWorld().removeObject(this);
            }
        }
    }    
}
