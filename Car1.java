import greenfoot.*;  

public class Car1 extends Actor
{
    public void act() 
    {
        Road theWorld = (Road) getWorld();
        if(!theWorld.isPaused)
        {
            setLocation( getX() + Greenfoot.getRandomNumber(6) + 10, getY());
            if(getX() > getWorld().getWidth() - 10) {
                 getWorld().removeObject(this);
            }        
        }
    }    
}
