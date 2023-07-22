import greenfoot.*; 

public class SurvivalMode extends Actor
{
    private GreenfootImage survival = new GreenfootImage ("menusurvival.jpg");
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            StartScreen.Mode = "survival";
            Menu menu = new Menu();
            menu.setImage(survival);
            SurKitch kitchen = new SurKitch();
            SurYard yard = new SurYard();
            SurRoad road = new SurRoad();
            MainMenu mainmenu = new MainMenu();
            
            getWorld().addObject(menu, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            getWorld().addObject(mainmenu, getWorld().getWidth()/ 5, getWorld().getHeight() - 80);
            getWorld().addObject(kitchen, getWorld().getWidth() / 4 - 100, getWorld().getHeight() / 2);
            getWorld().addObject(yard, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            getWorld().addObject(road, getWorld().getWidth()*3 / 4 + 100, getWorld().getHeight() / 2);
            
        }
    }    
}
