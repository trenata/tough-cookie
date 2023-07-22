import greenfoot.*;  

public class Play extends Actor
{
    static boolean play = false;
    public void act() 
    {
       if (Greenfoot.mouseClicked(this))
       {
            play = true;
            if(StartScreen.world == "kitchen"){
                Cookie1 cookie1 = new Cookie1();
                getWorld().addObject(cookie1, getWorld().getWidth()/2, getWorld().getHeight()/2);
                Chocolate chocolate = new Chocolate();
            }
            if(StartScreen.world == "yard"){
                Cookie2 cookie2 = new Cookie2();
                getWorld().addObject(cookie2, getWorld().getWidth()/3, getWorld().getHeight()- 410);
                Fence fence = new Fence();
                getWorld().addObject(fence, getWorld().getWidth()/3, getWorld().getHeight() + 100);
                Fence fence2 = new Fence();
                getWorld().addObject(fence2, getWorld().getWidth()*3/4, getWorld().getHeight());
            }
            if(StartScreen.world == "road"){
                Cookie3 cookie3 = new Cookie3();
                getWorld().addObject(cookie3, getWorld().getWidth()/2, getWorld().getHeight() - 30);
            }
            getWorld().removeObject(this);
       }
    }    
}
