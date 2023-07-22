import greenfoot.*;  

public class Score extends Actor
{
    public static int score = 0;
    static int deathScore = 0;
    public void act() 
    {
        setImage(new GreenfootImage("Chocolates : " + score, 24, new Color(45, 18, 1), new Color(229, 202, 121)));
    }    
    public void addScore()
    {
        score++;
    }
}
