import greenfoot.*;  

public class SurYard extends Actor
{
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){  
            StartScreen.world = "yard";
            Greenfoot.setWorld(new Yard());
        }
    }    
}
