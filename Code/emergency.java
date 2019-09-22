//package gym.com.freak;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

//import gym.com.valid.*;


public class emergency  extends JApplet implements ActionListener//extends JFrame
 {
    
	static Connection con;
	static Statement st;
	static ResultSet rs; 
	
	
	JLabel label_1;
	JLabel mid;
    JLabel emhome;
    JLabel emname;
    JLabel emcell;
    JLabel label_5;
    JLabel emname2;
    JLabel emhome2;
    JLabel emcell2;
    JLabel med;
	public JTextField txtmid;
    StringTextField txtemname;
    NumericTextField1 txtemhome;
    NumericTextField1 txtcell;
    NumericTextField1 txtemhome2;
    NumericTextField1 txtemcell2;
    StringTextField txtname2;
    JLabel medcon;
    JTextArea txtmedcon;
    JScrollPane sp_txtmedcon;
    JLabel docname;
    JLabel docphone;
    JLabel medication;
    StringTextField txtdocname;
    NumericTextField1 txtdocphone;
    JTextField textfield_9;

	public JButton save_b;
	//JButton del_b;
	public JButton upd_b;
	//JButton add_b;
	public JButton can_b;

    public emergency() {




		//System.out.println("in emergency");

		//System.out.println("id in emerg is:"+id);
        emergencyLayout customLayout = new emergencyLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("Emergency Details :");
        getContentPane().add(label_1);

        emhome = new JLabel("Home No.");
        getContentPane().add(emhome);
		

        emname = new JLabel("Contact Name");
        getContentPane().add(emname);

        emcell = new JLabel("Cell No.");
        getContentPane().add(emcell);

        label_5 = new JLabel("Alternative Contact:");
        getContentPane().add(label_5);

        emname2 = new JLabel("Name");
        getContentPane().add(emname2);

        emhome2 = new JLabel("Home No.");
        getContentPane().add(emhome2);

        emcell2 = new JLabel("Cell No.");
        getContentPane().add(emcell2);

        med = new JLabel("Medical Details:");
        getContentPane().add(med);

        txtemname = new StringTextField();
        getContentPane().add(txtemname);
//		txtemname.setEnabled(false);

        txtemhome = new NumericTextField1();
        getContentPane().add(txtemhome);
	//	txtemhome.setEnabled(false);

        txtcell = new NumericTextField1();
        getContentPane().add(txtcell);
	//	txtcell.setEnabled(false);

        txtemhome2 = new NumericTextField1();
        getContentPane().add(txtemhome2);
	//	txtemhome2.setEnabled(false);

        txtemcell2 = new NumericTextField1();
        getContentPane().add(txtemcell2);
	//	txtemcell2.setEnabled(false);

        txtname2 = new StringTextField();
        getContentPane().add(txtname2);
	//	txtname2.setEnabled(false);

        medcon = new JLabel("Medical Conditions");
        getContentPane().add(medcon);

        txtmedcon = new JTextArea("");
        sp_txtmedcon = new JScrollPane(txtmedcon);
        getContentPane().add(sp_txtmedcon);
	//	txtmedcon.setEnabled(false);

        docname = new JLabel("Doctor Name");
        getContentPane().add(docname);

        docphone = new JLabel("Doctor Phone");
        getContentPane().add(docphone);

        medication = new JLabel("Medication");
        getContentPane().add(medication);

        txtdocname = new StringTextField();
        getContentPane().add(txtdocname);
	//	txtdocname.setEnabled(false);

        txtdocphone = new NumericTextField1();
        getContentPane().add(txtdocphone);
	//	txtdocphone.setEnabled(false);

        textfield_9 = new JTextField("");
        getContentPane().add(textfield_9);
	//	textfield_9.setEnabled(false);

		

		can_b=new JButton("Clear");
		can_b.addActionListener(this);
		getContentPane().add(can_b);
		can_b.setToolTipText("Clears all the textfields");

		save_b=new JButton("Save");
		save_b.addActionListener(this);
		getContentPane().add(save_b);
		save_b.setToolTipText("Saves the entered details");

		mid=new JLabel("* Member ID");
		getContentPane().add(mid);

		txtmid = new JTextField();
		txtmid.setEnabled(false);
        getContentPane().add(txtmid);


		upd_b=new JButton("Update");
		upd_b.addActionListener(this);
		getContentPane().add(upd_b);
		upd_b.setToolTipText("Updates the existing record");




        setSize(getPreferredSize());

		
    }

    public static void main(String args[]) {
        emergency window = new emergency();

		try {
            		
	      	         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
				     SwingUtilities.updateComponentTreeUI(window);

	          
        		}
        	catch (Exception ex) {
            	
				System.out.println(ex);
        	}

    

    }
public void saver()
	 {
				try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:emp2");	
			PreparedStatement pst=con.prepareStatement("insert into emerg_details(mid,name,home_no,cell_no,name2,home_no2,cell_no2,med_cond,dr_name,dr_phone,medic) values(?,?,?,?,?,?,?,?,?,?,?)");

			pst.setString(1,txtmid.getText());
			pst.setString(2,txtemname.getText());
			pst.setString(3,txtemhome.getText());
			pst.setString(4,txtcell.getText());
			pst.setString(5,txtname2.getText());
			pst.setString(6,txtemhome2.getText());
			pst.setString(7,txtemcell2.getText());
			pst.setString(8,txtmedcon.getText());
			pst.setString(9,txtdocname.getText());
			pst.setString(10,txtdocphone.getText());
			pst.setString(11,textfield_9.getText());
			int response = JOptionPane.showConfirmDialog(emergency.this,
             "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(response) {
            case JOptionPane.YES_OPTION:          
			 pst.executeUpdate();			
			save_b.setEnabled(false);
			upd_b.setEnabled(true);
			Icon check=new ImageIcon("Check_h.gif");
			 JOptionPane.showMessageDialog(emergency.this,"<html><font size=4 color=green>The Record has been Saved</font></html>","Saved",JOptionPane.INFORMATION_MESSAGE,check);
			/*	save_b.setEnabled(false);
				del_b.setEnabled(true);
			  add_b.setEnabled(true);
			  upd_b.setEnabled(true);*
			  setDisabEmp();
			*/
			
               break;
            case JOptionPane.NO_OPTION: 
				show();
		 }   
						pst.close();

			con.close();
			}catch(Exception e)
			{
				System.out.println("error: "+e);
			}
	 }
	public void actionPerformed(ActionEvent ae)
	{
		
/*		if(ae.getSource()==add_b)
		{
			txtemname.setEnabled(true);
			txtemhome.setEnabled(true);
			txtcell.setEnabled(true);
			txtname2.setEnabled(true);
			txtemhome2.setEnabled(true);
			txtemcell2.setEnabled(true);
			txtdocname.setEnabled(true);
			txtdocphone.setEnabled(true);
			textfield_9.setEnabled(true);
			txtmedcon.setEnabled(true);

			
			add_b.setEnabled(false);
		//	save_b.setEnabled(true);
			upd_b.setEnabled(false);
		//	del_b.setEnabled(false);
			can_b.setEnabled(true);

		}*/
		if(ae.getSource()==can_b)
		{
			/*txtemname.setEnabled(false);
			txtemhome.setEnabled(false);
			txtcell.setEnabled(false);
			txtname2.setEnabled(false);
			txtemhome2.setEnabled(false);
			txtemcell2.setEnabled(false);
			txtdocname.setEnabled(false);
			txtdocphone.setEnabled(false);
			textfield_9.setEnabled(false);
			txtmedcon.setEnabled(false);

			
			add_b.setEnabled(true);
			save_b.setEnabled(false);
			upd_b.setEnabled(true);
			del_b.setEnabled(true);
			can_b.setEnabled(false);*/
			setEmptyEmp();

		}
	/*	if(ae.getSource()==del_b)
		{
			try
			{
							
				PreparedStatement psm=con.prepareStatement("delete * from emerg_details where mid=?");
	
				psm.setString(1,txtmid.getText());
				
				int response1 = JOptionPane.showConfirmDialog(emergency.this,
				"Are you sure you want to delete?","Confirmation",JOptionPane.YES_NO_OPTION);
				 switch(response1) {
				case JOptionPane.YES_OPTION: 
				psm.executeUpdate();
				
			
				JOptionPane.showMessageDialog(emergency.this,"<html><font size=4 color=blue>The Record has been deleted</font></html>");
				break;
				case JOptionPane.NO_OPTION: 
				show();
				}
			}		
			catch(Exception r){System.out.println("error"+r );}
					
		 } */
		
		if(ae.getSource()==save_b)
		{
			Icon error=new ImageIcon("error.png");

			boolean b=true;
			//boolean b1=true,b2=true,b3=true,b4=true, b5=false;
			try
			{
				PreparedStatement tp=con.prepareStatement("select mid from members where mid=?");
				tp.setString(1,txtmid.getText());
					ResultSet tpr=tp.executeQuery();
					if(tpr.next())
				{
						b=false;
						System.out.println("b="+b);

				}
				else 
					b=true;

			}catch(Exception e)
				{
				System.out.println("hello error"+e);
				}

			if(b==false)
			{
		
				saver();		
				
			}
			
			else
			{

				JOptionPane.showMessageDialog(emergency.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please first fill the Main Form above","Error",JOptionPane.ERROR_MESSAGE,error);
			}
		}




		if(ae.getSource()==upd_b)
		{
			
			if(txtmid.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(emergency.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill in all the mandatory fields","Error",JOptionPane.ERROR_MESSAGE,error);
			
			}

			else
			{			
			try
			{
				
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");	
				PreparedStatement pst=con.prepareStatement("update emerg_details set name=?,home_no=?,cell_no=?,name2=?,home_no2=?,cell_no2=?,med_cond=?,dr_name=?,dr_phone=?,medic=? where mid=?");

				
			
			pst.setString(1,txtemname.getText());
			pst.setString(2,txtemhome.getText());
			pst.setString(3,txtcell.getText());
			pst.setString(4,txtname2.getText());
			pst.setString(5,txtemhome2.getText());
			pst.setString(6,txtemcell2.getText());
			pst.setString(7,txtmedcon.getText());
			pst.setString(8,txtdocname.getText());
			pst.setString(9,txtdocphone.getText());
			pst.setString(10,textfield_9.getText());
			pst.setString(11,txtmid.getText());

			//pst.executeUpdate();


			 pst.executeUpdate();				
			Icon check=new ImageIcon("Check_h.gif");
			 JOptionPane.showMessageDialog(emergency.this,"<html><font size=4 color=green>The Record has been Updated</font></html>","Saved",JOptionPane.INFORMATION_MESSAGE,check);

			pst.close();
			con.close();
			}
			catch(Exception e)
			{
				System.out.println("error in update "+e);
				
			}

			}
		}
	}
	public void setDisabEmp()
	{
			txtemname.setEnabled(false);
			txtemhome.setEnabled(false);
			txtcell.setEnabled(false);
			txtemhome2.setEnabled(false);
			txtemcell2.setEnabled(false);
			txtname2.setEnabled(false);
			txtmedcon.setEnabled(false);
			txtdocname.setEnabled(false);
			txtdocphone.setEnabled(false);
			textfield_9.setEnabled(false);

		//	add_b.setEnabled(true);
		//	save_b.setEnabled(false);
			upd_b.setEnabled(true);
		//	del_b.setEnabled(true);
			can_b.setEnabled(false);
	}

	public void setEmptyEmp()
	{
							
				txtemname.setText("");
				txtemhome.setText("");
				txtcell.setText("");
				txtemhome2.setText("");
				txtemcell2.setText("");
				txtname2.setText("");
    
				txtmedcon.setText("");
    
				txtdocname.setText("");
				txtdocphone.setText("");
				textfield_9.setText("");
		
	}
	public void setValueEmp(String id)
	{
		
			//System.out.println("on call in emergency");
			//System.out.println("id in emergency is : "+id);

			try
			{
				


					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con=DriverManager.getConnection("jdbc:odbc:emp2");
					//System.out.println("after connection in emergency");
					//st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					st=con.createStatement();
				//	System.out.println("after st in emergency");
					
					
					rs=st.executeQuery("select * from emerg_details where mid LIKE '"+id+"'");
			
					
					//System.out.println("after rs in emergency");

				
					if(rs.next())
					{	
						do
						{
						
						txtmid.setText(rs.getString(1));
						txtemname.setText(rs.getString(2));
						
						txtemhome.setText(rs.getString(3));
						txtcell.setText(rs.getString(4));
						txtname2.setText(rs.getString(5));
						txtemhome2.setText(rs.getString(6));
						txtemcell2.setText(rs.getString(7));
						txtmedcon.setText(rs.getString(8));
						txtdocname.setText(rs.getString(9));
						txtdocphone.setText(rs.getString(10));
						textfield_9.setText(rs.getString(11));
						save_b.setEnabled(false);
						upd_b.setEnabled(true);
					
						}while(rs.next());
					}
				
					else
					{
						setEmptyEmp();
						txtmid.setText(id);
						upd_b.setEnabled(false);
						save_b.setEnabled(true);
					}
					rs.close();
					st.close();
					con.close();
			}
			catch(Exception e)
			{
				System.out.println("error in emerg"+e);
			}
		
	}

/*	public void srchValueEmp(String nam)
	{
		
			System.out.println("on call in emergency");
			System.out.println("name in emergency is : "+nam);

			try
			{
				


					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con=DriverManager.getConnection("jdbc:odbc:emp2");
					System.out.println("after connection in emergency");
					//st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					st=con.createStatement();
					System.out.println("after st in emergency");
					
					
					rs=st.executeQuery("select * from emerg_details where name LIKE '"+nam+"'");
			
					
					System.out.println("after rs in emergency");

				
					if(rs.next())
					{	
						System.out.println("inside if");
						do
						{
						
						txtmid.setText(rs.getString(1));
						txtemname.setText(rs.getString(2));
						
						txtemhome.setText(rs.getString(3));
						txtcell.setText(rs.getString(4));
						txtname2.setText(rs.getString(5));
						txtemhome2.setText(rs.getString(6));
						txtemcell2.setText(rs.getString(7));
						txtmedcon.setText(rs.getString(8));
						txtdocname.setText(rs.getString(9));
						txtdocphone.setText(rs.getString(10));
						textfield_9.setText(rs.getString(11));
					
					
						}while(rs.next());
					}
				
					else
					{
						setEmptyEmp();
						//txtmid.setText(id);
					}
			}
			catch(Exception e)
			{
				System.out.println("error in emerg"+e);
			}
		
	}*/

	public void delValueEmp(String id)
	{
		
			//System.out.println("on call in emergency");
			//System.out.println("id in emergency is : "+id);

			try
			{
				


					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con=DriverManager.getConnection("jdbc:odbc:emp2");
					//System.out.println("after connection in emergency");
					//st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					st=con.createStatement();
					//System.out.println("after st in emergency in del");

					//System.out.println("after id to be del"+id);
					
					
					rs=st.executeQuery("Delete * from emerg_details where mid LIKE '"+id+"'");
			
					
				//	System.out.println("after rs in emergency in del");
					rs.close();
					st.close();
					con.close();
				
				
			}
			catch(Exception e)
			{
				System.out.println("error in emerg"+e);
			}
		
	}
}
/*
class emergencyLayout implements LayoutManager {

    public emergencyLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 716 + insets.left + insets.right;
        dim.height = 318 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+24,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+120,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+88,96,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+152,96,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+176,104,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+200,96,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+232,96,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+264,96,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+40,112,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+88,96,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+120,96,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+152,96,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+232,96,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+264,96,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+200,96,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+72,112,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+72,176,104);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+200,104,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+232,104,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+264,104,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+200,120,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+232,120,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+264,120,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+8,80,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+56,96,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+56,96,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+8,72,24);}
    }
}

class emergencyLayout implements LayoutManager {

    public emergencyLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 716 + insets.left + insets.right;
        dim.height = 318 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+24,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+120,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+88,96,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+152,96,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+176,104,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+200,96,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+232,96,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+264,96,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+40,112,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+88,96,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+120,96,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+152,96,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+232,96,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+264,96,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+200,96,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+72,112,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+72,176,104);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+200,104,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+232,104,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+264,104,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+200,120,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+232,120,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+264,120,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+8,80,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+56,96,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+56,96,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+8,72,24);}
    }
}
*/
class emergencyLayout implements LayoutManager {

    public emergencyLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 716 + insets.left + insets.right;
        dim.height = 302 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+24,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+120,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+88,96,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+152,96,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+176,104,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+200,96,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+232,96,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+264,96,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+40,112,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+88,96,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+120,96,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+152,96,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+232,96,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+264,96,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+200,96,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+72,112,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+72,176,104);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+200,104,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+232,104,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+264,104,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+200,120,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+232,120,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+264,120,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+8,72,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+8,80,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+56,96,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+56,96,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+8,72,24);}
    }
}
