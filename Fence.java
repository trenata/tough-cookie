import greenfoot.*;  

public class Fence extends Actor
{
    int Speed = -10;
    public void act() 
    {
        Yard theWorld = (Yard) getWorld();
        if(!theWorld.isPaused)
        {
            setLocation( getX() + Speed, getY() );
            if(getX() == 0) {
                 getWorld().removeObject(this);
            }
        }
    }   
}
