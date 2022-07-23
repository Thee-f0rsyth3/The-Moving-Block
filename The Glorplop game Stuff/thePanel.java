import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Dimension;

public class thePanel extends JPanel implements Runnable{
    final int originalTileSize =32;//sets the Number for the Tile Size This would be used to make the map/Jay
    final int scale =4;

    final int titleSize =originalTileSize * scale;
    final int maxScreenCol = 16;
     final int maxScreenRow = 12;
     final int screenWidth = titleSize * maxScreenCol;
     final int screenHeight = titleSize * maxScreenRow;
     int FPS = 60;
     keyhandles keyH = new keyhandles();

     Thread gameThread;
int playerX = 100;
int playerY = 100;
int playerSpeed = 4;



     public thePanel(){
      this.setPreferredSize(new Dimension(screenWidth, screenHeight));//This refers to the Panel Hight, it will get the set hight from the 'screenHieght' multiplication data above/Jay
       this.setBackground(Color.BLACK);//Sets The Background Color of the window background/Jay
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
     }
        public void startGameThread() {
            gameThread = new Thread(this);
            gameThread.start();
            //This si just declaring a new thread this was declared in the public static header/Jay
        }

    
@Override
        public void run(){
            double drawInterval = 1000000000/FPS;
              double nextDrawTime = System.nanoTime() + drawInterval;
               
while(gameThread != null){
  
    //System.out.println("The Loop Is Running");
    update();

    repaint();
 
    try{   
        double remainingTime = nextDrawTime - System.nanoTime();
        remainingTime = remainingTime/1000000;
        if(remainingTime<0 ){
            remainingTime =0;
        }
     Thread.sleep((long) remainingTime);
       
     nextDrawTime += drawInterval;

    }catch (InterruptedException e){
        e.printStackTrace();
    }
}
}
  public void update(){
if(keyH.upPressed == true){
    playerY -= playerSpeed;
} else if(keyH.downPressed == true){
    playerY += playerSpeed;
}else if(keyH.leftPressed == true){
    playerX -= playerSpeed;
}else if(keyH.rightPressed == true){
    playerX += playerSpeed;
}

  }
  public void paintComponent(Graphics g){
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D)g;
         g2.setColor(Color.white);
          g2.fillRect(playerX, playerY, titleSize, titleSize);
          
  }


}