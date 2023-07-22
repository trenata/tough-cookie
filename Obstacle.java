import greenfoot.*;  

public class Obstacle extends Actor
{
    int Speed = -15;
    public void act() 
    {
        Kitchen theWorld = (Kitchen) getWorld();
        if(!theWorld.isPaused)
        {
            setLocation( getX() + Speed, getY() );
            if(getX() == 0) {
                 getWorld().removeObject(this);
            }
            if(Cookie1.elvivo == true)
            {
                getWorld().removeObjects(getWorld().getObjects(Obstacle.class)); 
                Cookie1.elvivo = false;
            }
        }    
    }
}
