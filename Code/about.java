//package gym.com.freak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class about extends JFrame implements ActionListener{
    JLabel label_1;
    JLabel label_2;
    JLabel label_3;
    JLabel label_4;
    JLabel label_5;
    JButton button_1;

    public about() {
		ImageIcon ad=new ImageIcon("logo2.jpg");
        aboutLayout customLayout = new aboutLayout();

        //setFont(new Font("Monotype Corsiva", Font.ITALIC, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel(ad);
        getContentPane().add(label_1);

        label_2 = new JLabel("FITNESS FREAK");
        getContentPane().add(label_2);

        label_3 = new JLabel("Version 1.0");
        getContentPane().add(label_3);

        label_4 = new JLabel("Fitness Freak:Gym Management");//\n System \nVersion 1.0\n All rights reserved 
        getContentPane().add(label_4);

        label_5 = new JLabel("Programmed By :-Ameya ,Saurabh, Dhruv ,Kirtan ");
        getContentPane().add(label_5);

        button_1 = new JButton("OK");
        getContentPane().add(button_1);
		button_1.addActionListener(this);	

        setSize(getPreferredSize());

			setUndecorated(true);
	getRootPane().setWindowDecorationStyle(JRootPane.FRAME);



        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               dispose();
            }
        });
    }

    public static void main(String args[]) {
        about window = new about();
			try {
            			// select Look and Feel
	        UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);

	          
        		}
        	catch (Exception ex) {
            	ex.printStackTrace();
        	}

        window.setTitle("about");
        window.pack();
        window.show();
    }
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==button_1)
		{
			dispose();
		}
	}
}
class aboutLayout implements LayoutManager {

    public aboutLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 491 + insets.left + insets.right;
        dim.height = 413 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+40,128,104);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+40,232,56);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+112,232,56);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+184,232,64);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+272,392,40);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+328,88,24);}
    }
}
