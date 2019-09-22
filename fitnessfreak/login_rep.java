//package gym;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.Timer;
import java.util.*;

public class login_rep extends JFrame implements ActionListener{
    JLabel user;
    JLabel pass;
    JTextField txtuser;
    JPasswordField pf;
    JButton loginf;
    Connection conn;
     Statement stat;
	ResultSet set;

	//static main_form mform=new main_form();

    public login_rep() {
        loginLayout2 customLayout = new loginLayout2();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        user = new JLabel("User Name");
        getContentPane().add(user);

        pass = new JLabel("Password");
        getContentPane().add(pass);

        txtuser = new JTextField("");
        getContentPane().add(txtuser);

        pf= new JPasswordField("");
        getContentPane().add(pf);
        pf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if((e.getKeyCode())==KeyEvent.VK_ENTER)
				{
				boolean flag=false;
				String s="";
				s=txtuser.getText();
				char a[]=pf.getPassword();
				String u_name=null;
				String pass=null;
				try
				{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:emp2");
				stat=conn.createStatement();
				set=stat.executeQuery("Select * from login_rep");
				set.next();
				u_name=set.getString(1);
				pass=set.getString(2);
				}
				catch(Exception ex)
				{
				}

				if(s.equals(u_name) && a.length==pass.length())
				{
					for(int i=0;i<pass.length();i++)
					{
					  if(a[i]==pass.charAt(i))
					       flag=true;
					  else
					  {
					       flag=false;
					       break;
					  }


					}
				 }
				if(flag==true)
				{
					//setSize(width,height);
					//bar.setVisible(true);
					//activityMonitor.start();
					System.out.print("true");

				}
				else
				{
					Icon error=new ImageIcon("error.png");
					 JOptionPane.showMessageDialog(login_rep.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
				}
			}
			}
		});

        loginf = new JButton("Login");
        getContentPane().add(loginf);
        loginf.addActionListener(this);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
				
            }
        });
    }

    public static void main(String args[]) {
        login_rep window = new login_rep();
       try {
            // select Look and Feel
  UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

	          
             }
             catch (Exception ex) {
            	System.out.println(ex);
        	}
        window.setTitle("login");
        window.pack();
        window.show();
    }
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==loginf)
		{
			boolean flag=false;
			String s="";
			s=txtuser.getText();
			char a[]=pf.getPassword();
			String u_name=null;
			String pass=null;
			try
			{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:emp2");
				stat=conn.createStatement();
				set=stat.executeQuery("Select * from login_rep");
				set.next();
				u_name=set.getString(1);
				pass=set.getString(2);
			}
			catch(Exception ex)
			{
			}

			if(s.equals(u_name) && a.length==pass.length())
			{
				for(int i=0;i<pass.length();i++)
				{
					  if(a[i]==pass.charAt(i))
					  flag=true;
					  else
					  {
					       flag=false;
					       break;
					  }


				}
			  }
				if(flag==true)
				{
					//setSize(width,height);
					//bar.setVisible(true);
					//activityMonitor.start();
					main_form1 mform=new main_form1();
					System.out.print("true");
					(mform.adm).setEnabled(true);
					
				dispose();

				}
				else
				{
					Icon error=new ImageIcon("error.png");
					 JOptionPane.showMessageDialog(login_rep.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
				}
			}
		}
	
}

class loginLayout2 implements LayoutManager {

    public loginLayout2() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 402 + insets.left + insets.right;
        dim.height = 231 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+72,96,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+112,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+72,112,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+112,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+168,88,24);}
    }
}
