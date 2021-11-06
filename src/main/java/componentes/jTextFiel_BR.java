
package componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;


/**
 * @author Diego Alexander Gaviria Jimenez
 */
public class jTextFiel_BR extends JTextField{
    
    private final Dimension dm = new Dimension(250,28);
    private final BorderLineRound borde = new BorderLineRound((Color.lightGray.darker()),true);

    
    public jTextFiel_BR(){
        
        
        setOpaque(true);
        setBorder(borde);
        setSize(dm);
        setPreferredSize(dm);
        setHorizontalAlignment(CENTER);//lo pone en el centro
        setFont(new Font("Century Gothic",0,12));
        
        addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                txtFocusGaided(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtFocuslost(e);
            }
        });
    }
    
    public void txtFocusGaided(FocusEvent evy){
        setBorder(new BorderLineRound(new Color(1,178,0),true));  
        
        
    }
    
    public void txtFocuslost(FocusEvent evy){
        setBorder(borde);
    }
    
    
 /*       @Override 
     protected void paintComponent(Graphics g) { 
        
          super.paintComponent(g);
         
        Graphics2D g2 = (Graphics2D) g; 
        Paint oldPaint = g2.getPaint(); 
            setBorder(borde);
     
        if(getImage()!=null){ 
            g2.drawImage(getImage(), 5, 2, getHeight()-3, getHeight()-3, null); 
            setBorder(new EmptyBorder(0,(int)(getHeight()*1.2),0,2)); 
        } 
     
        g2.setPaint(oldPaint); 
       
    } */
     
    
}
