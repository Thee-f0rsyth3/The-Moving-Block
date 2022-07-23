import javax.swing.JFrame;


//We need the Inport JFrame in order to make these Window eliment below/Jay


public class Main{
  

    public static void main(String[] args) {
       JFrame window= new JFrame();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//This sets the default close thing to exit program /Jay
      window.setResizable(true);//This sets if the Panel is resizable as in callapsable/Jay
      window.setTitle("The Glorplop game");//The title for the Jpanel

      window.setLocationRelativeTo(null);//Null equals zero so it would display In the Center Screen/Jay
      window.setVisible(true);


        thePanel gamepnl = new thePanel();
        window.add(gamepnl);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);//set the window to True or False 
        gamepnl.startGameThread();








    }

    
  }
  