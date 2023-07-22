import greenfoot.*;  

public class Menu extends Actor
{
    public void act() 
    {
        if(getWorld().getObjects(Resume.class).size() == 0)
        {
            if(Play.play == true)
                getWorld().removeObject(this);
        }
    }    
}
