import greenfoot.*;  

public class Replay extends Actor
{
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)){
            if(StartScreen.world == "kitchen"){
                Greenfoot.setWorld(new Kitchen());
                Score.score = Score.deathScore;
            }
            else if(StartScreen.world == "yard"){
                Greenfoot.setWorld(new Yard());
                Score.score = Score.deathScore;
            }
            else{
                Greenfoot.setWorld(new Road());
                Score.score = Score.deathScore;
            }
        }    
    }    
}
