//package gym.com.freak;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class suggest extends JFrame implements ActionListener{
    JLabel memno;
    JTextField txtmid;
    JLabel date;
    DateField datefield;
    JLabel breakf;
    JLabel brunch;
    JLabel lunch;
    JLabel snack;
    JLabel dinner;
    JTextField txtbreak;
    JTextField txtbrunch;
    JTextField txtlunch;
    JTextField txtsnack;
    JTextField txtdinner;
    JButton save;
    JButton upd;
    JLabel ext;
    JTextField txtext;

    public suggest() {
        sugsestLayout customLayout = new sugsestLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        memno = new JLabel("Membership No.");
        getContentPane().add(memno);

        txtmid = new JTextField("");
        getContentPane().add(txtmid);
        txtmid.setEnabled(false);
       
         //String str=passmid();	
        

        date = new JLabel("  Date");
        getContentPane().add(date);

       // textfield_2 = new JTextField("textfield_2");
       //getContentPane().add(textfield_2);
        datefield = CalendarFactory.createDateField();
        getContentPane().add(datefield);

        breakf = new JLabel("Breakfast");
        getContentPane().add(breakf);

        brunch = new JLabel("Brunch");
        getContentPane().add(brunch);

        lunch = new JLabel("Lunch");
        getContentPane().add(lunch);

        snack = new JLabel("Evening Snack");
        getContentPane().add(snack);

        dinner = new JLabel("Dinner");
        getContentPane().add(dinner);

        txtbreak = new JTextField("");
        getContentPane().add(txtbreak);

        txtbrunch = new JTextField("");
        getContentPane().add(txtbrunch);

        txtlunch = new JTextField("");
        getContentPane().add(txtlunch);

        txtsnack = new JTextField("");
        getContentPane().add(txtsnack);

        txtdinner = new JTextField("");
        getContentPane().add(txtdinner);
  


        save = new JButton("Save");
        getContentPane().add(save);
        save.addActionListener(this);
		

        upd = new JButton("Update");
        getContentPane().add(upd);
        upd.addActionListener(this);

        ext = new JLabel("Extra");
        getContentPane().add(ext);
 
        txtext = new JTextField("");
        getContentPane().add(txtext);

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
        suggest window = new suggest();
         try {
            // select Look and Feel
  UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

	          
             }
             catch (Exception ex) {
            	System.out.println(ex);
        	}
	 window.setTitle("sugsest");
        window.pack();
        window.show();
    }
 public String passmid(String str)
        {
	txtmid.setText(str);
	try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			PreparedStatement pst=con.prepareStatement("select sugg_date,breakf,brunch,lunch,snack,dinner,extra from food_sugg where mid=?");
			//ResultSet rs=st.executeQuery("select breakf,brunch,lunch,snack,dinner,extra from food_sugg where mid="+str);
			//datefield.
			pst.setString(1,str);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			java.util.Date date1=((java.util.Date)(rs.getDate(1)));
			datefield.setValue(date1);
			System.out.println("yyaaaawwwwnnnn");
			txtbreak.setText(rs.getString(2));
			txtbrunch.setText(rs.getString(3));
			txtlunch.setText(rs.getString(4));
			txtsnack.setText(rs.getString(5));
			txtdinner.setText(rs.getString(6));
			txtext.setText(rs.getString(7));
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			int count=0;
			PreparedStatement ps=con.prepareStatement("select breakf,brunch,lunch,snack,dinner,extra from food_sugg where mid=?");
			ps.setString(1,str);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			do
			{
				 count=count+1;
				System.out.println(rs.getString(1));
				
			}while(rs.next());
			save.setEnabled(false);
			
			}
			else
			{
			System.out.println("no history");
			save.setEnabled(true);
			upd.setEnabled(false);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	return str;
                
          }
public void actionPerformed(ActionEvent ae) 
{
	if(ae.getSource()==save)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			PreparedStatement prep=con.prepareStatement("insert into food_sugg(mid, sugg_date, breakf, brunch, lunch, snack, dinner, extra) values(?,?,?,?,?,?,?,?)");
  	
			prep.setString(1,txtmid.getText());
			
			java.util.Date choosed = (java.util.Date)datefield.getValue();
			java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
			prep.setDate(2,sqlDate);
			prep.setString(3,txtbreak.getText());
			prep.setString(4,txtbrunch.getText());
			prep.setString(5,txtlunch.getText());
			prep.setString(6,txtsnack.getText());
			prep.setString(7,txtdinner.getText());
			prep.setString(8,txtext.getText());
			int ins=prep.executeUpdate();

			
				if(ins==1)
			{
			Icon tick=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(suggest.this,"<html><font size=4 color=green>Record Saved</font></html> ","Message",JOptionPane.ERROR_MESSAGE,tick);
			save.setEnabled(false);
			upd.setEnabled(true);
			
			}
			else
			{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(suggest.this,"<html><font size=4 color=red>Could Not Save</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				
			}

			System.out.println("after save");
			}
			catch(Exception e)
			{
 				System.out.println("Exception: " + e);
				
 			}     	



	}//if over	
	
	if(ae.getSource()==upd)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			String sel=txtmid.getText();
			PreparedStatement prep=con.prepareStatement("update food_sugg set sugg_date=?,breakf=?,brunch=?,lunch=?,snack=?,dinner=?,extra=?  where mid=?");	
			java.util.Date choosed = (java.util.Date)datefield.getValue();
			java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
			prep.setDate(1,sqlDate);
			prep.setString(2,txtbreak.getText());
			prep.setString(3,txtbrunch.getText());
			prep.setString(4,txtlunch.getText());
			prep.setString(5,txtsnack.getText());
			prep.setString(6,txtdinner.getText());
			prep.setString(7,txtext.getText());
			prep.setString(8,sel);
			int updrow=prep.executeUpdate();
			if(updrow==1)
			{
			Icon tick=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(suggest.this,"<html><font size=4 color=green>Row Updated</font></html> ","Message",JOptionPane.ERROR_MESSAGE,tick);
			
			
			}
			else
			{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(suggest.this,"<html><font size=4 color=red>Could Not Update</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				
			}
		}
		catch(Exception e)
		{
 			System.out.println("Exception: " + e);
				
 		}     	
		}//if over
	
}
         
}

class sugsestLayout implements LayoutManager {

    public sugsestLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 556 + insets.left + insets.right;
        dim.height = 404 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+32,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+32,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+296,insets.top+32,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+384,insets.top+32,80,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+96,96,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+136,96,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+176,96,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+216,96,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+256,96,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+96,264,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+136,264,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+176,264,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+216,264,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+256,264,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+344,80,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+344,112,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+296,96,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+296,264,24);}
    }
}
