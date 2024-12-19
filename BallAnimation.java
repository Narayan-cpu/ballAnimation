
package ballanimation;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author narayan naik
 */
class MyFrame extends Frame implements Runnable {
    int x,y,tx,ty;
    MyFrame(){
        x=100;
        y=100;
        tx=ty=1;
        Thread t=new Thread(this);
        t.start();
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    } 
   
    @Override
    @SuppressWarnings("empty-statement")
    public void run()  {
       while(true){
           x+=tx;
           y+=ty;
           if(x<0||x>450){
               tx*=-1;;
           }if(y<20||y>450){
               ty*=-1;
           }
           repaint();
       try{
           Thread.sleep(5);
           
       }catch(Exception e){
           System.out.println(e);
       }
       } 
      
    }
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillOval(x, y, 50,50);
       
    }
              
}
public class BallAnimation {

   
    public static void main(String[] args) {
        
        MyFrame f=new MyFrame();
        f.setSize(450,450);
        f.setVisible(true);
    }
    
}
