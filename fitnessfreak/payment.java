//package gym.com.freak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;
//import gym.com.valid.*;


public class payment extends JApplet implements ActionListener,ItemListener{
    JLabel label_1;
    public JTextField mid;
    JLabel label_2;
    JTextField mname;
    JLabel label_3;
    JList progname;
    JScrollPane sp_progname;
    JLabel label_4;
    DateField paydate;
    JLabel label_5;
    JComboBox method;
    JLabel label_6;
    JComboBox status;
    JLabel label_7;
    JComboBox installtype;
    JLabel label_8;
    NumericTextField price;
    JLabel label_9;
    JCheckBox install;
    JLabel label_10;
    JLabel label_11;
    JTextField amt;
     DateField nxtdue;
    JLabel label_12;
    JTextField owe;
    JLabel label_13;
    JTextField bnk;
    JLabel label_14;
    JTextField chq;
    JLabel label_15;
    JTextField act;
    JButton save;
    JButton can;
    JButton rcpt;
	JButton tab;
	Connection con;
	public DefaultListModel listModel_progname;
	java.util.Date choosed;
	java.sql.Date sqlDate;
	java.util.Date nxtchoosed;
	java.sql.Date nxtsqlDate;
	recptnew ob1=new recptnew();


    public payment() {


        paymentLayout customLayout = new paymentLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("Member ID");
        getContentPane().add(label_1);

        mid = new JTextField("");
        getContentPane().add(mid);
		mid.setEnabled(false);

        label_2 = new JLabel("Member Name");
        getContentPane().add(label_2);

        mname = new JTextField("");
        getContentPane().add(mname);
		mname.setEnabled(false);

        label_3 = new JLabel("Programme Name");
        getContentPane().add(label_3);

        listModel_progname = new DefaultListModel();
        progname = new JList(listModel_progname);
        sp_progname = new JScrollPane(progname);
        getContentPane().add(sp_progname);
		progname.setEnabled(true);


        label_4 = new JLabel("Payment Date");
        getContentPane().add(label_4);

        paydate =  CalendarFactory.createDateField();
        getContentPane().add(paydate);

        label_5 = new JLabel("Payment Method");
        getContentPane().add(label_5);

        method = new JComboBox();
		method.addItem("---( select )---");
	    method.addItem("Cash");
        method.addItem("Cheque");
		method.addItemListener(this);
		method.setSelectedItem("---( select )---");


        getContentPane().add(method);
        
		label_6 = new JLabel("Status");
        getContentPane().add(label_6);

        status = new JComboBox();
        status.addItem("N/A");
		status.addItem("Paid");
        status.addItem("Pending");
  	     status.setSelectedItem("N/A");
		getContentPane().add(status);
		status.setEnabled(false);



        label_7 = new JLabel("Payment Type");
        getContentPane().add(label_7);

        nxtdue =  CalendarFactory.createDateField();
        getContentPane().add(nxtdue);
		nxtdue.setEnabled(false);


        
		label_8 = new JLabel("Programme Price");
        getContentPane().add(label_8);

        price = new NumericTextField();
        getContentPane().add(price);
		price.setEnabled(false);

        label_11 = new JLabel("Next Due Date");
        getContentPane().add(label_11);

        install = new JCheckBox("Installment");
        getContentPane().add(install);
		install.addItemListener(this);

        label_10 = new JLabel("Amount Paid");
        getContentPane().add(label_10);


		        label_9 = new JLabel("Paid for");
        getContentPane().add(label_9);

		

        amt = new JTextField("");
        getContentPane().add(amt);
		amt.setEnabled(false);


        installtype = new JComboBox();
		  installtype.addItem("N/A");
        installtype.addItem("First Installment");
        installtype.addItem("Second Installment");
		installtype.setEnabled(false);
		installtype.addItemListener(this);
  	   installtype.setSelectedItem("N/A");      
        getContentPane().add(installtype);




        label_12 = new JLabel("Owing Amount");
        getContentPane().add(label_12);

        owe = new JTextField("");
        getContentPane().add(owe);
		owe.setEnabled(false);

        label_13 = new JLabel("Bank Name");
        getContentPane().add(label_13);

        bnk = new JTextField("");
        getContentPane().add(bnk);
		bnk.setEnabled(false);

        label_14 = new JLabel("Cheque Number");
        getContentPane().add(label_14);

        chq = new JTextField();
        getContentPane().add(chq);
		chq.setEnabled(false);

        label_15 = new JLabel("Account Number");
        getContentPane().add(label_15);

        act = new JTextField();
        getContentPane().add(act);
		act.setEnabled(false);

		 save = new JButton("Save");
        getContentPane().add(save);
		save.addActionListener(this);
		 save.setToolTipText("Save Payment");


		 can = new JButton("Clear");
        getContentPane().add(can);
		  can.setToolTipText("Clears all textfields");
			can.addActionListener(this);


		 rcpt = new JButton("Generate Receipt");
        getContentPane().add(rcpt);
		rcpt.addActionListener(this);
		  rcpt.setToolTipText("Generates Payment Receipt after Saving Record");
		  rcpt.setEnabled(false);

	  tab = new JButton("View Table");
        getContentPane().add(tab);
		tab.addActionListener(this);
		  tab.setToolTipText("View Previous Payment Details");



        setSize(getPreferredSize());

    }

	

	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==save)
	{
	
	try
	{		
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:emp2");
		choosed = (java.util.Date)paydate.getValue();	
		sqlDate = new java.sql.Date(choosed.getTime());
		String str=(String)method.getSelectedItem();
		String typ=(String)installtype.getSelectedItem();
		String stat=(String)status.getSelectedItem();
		String s="N/A";
		nxtchoosed = (java.util.Date)nxtdue.getValue();	
		nxtsqlDate = new java.sql.Date(nxtchoosed.getTime());
		if(mname.getText().trim().equals("")||progname.isSelectionEmpty()||price.getText().trim().equals("")||str=="---( select )---")
		{
			Icon error=new ImageIcon("error.png");
			 JOptionPane.showMessageDialog(payment.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
		}
		else
		{
		int firstSelIx = progname.getSelectedIndex();
		String sel = (String)listModel_progname.getElementAt(firstSelIx);

		if(install.isSelected())
		{
			if(str=="Cash")
			{
				if(typ=="N/A")
				{
					Icon error=new ImageIcon("error.png");
					 JOptionPane.showMessageDialog(payment.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
				}
				else
				{
					
				PreparedStatement pstm=con.prepareStatement("insert into payment(mid,paydate,method,amount_paid,installment,next_duedate,owing,status,price,instal_type,progname,bnk,chq,acc)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstm.setString(1,mid.getText());
				pstm.setDate(2,sqlDate);
				pstm.setString(3,str);
				pstm.setString(4,amt.getText());
				pstm.setBoolean(5,true);
				pstm.setDate(6,nxtsqlDate);
				pstm.setString(7,owe.getText());
				pstm.setString(8,stat);
				pstm.setString(9,price.getText());
				pstm.setString(10,typ);
				pstm.setString(11,sel);
				pstm.setString(12,s);
				pstm.setString(13,s);
				pstm.setString(14,s);
				
				String m1= mid.getText();
				String m2= amt.getText();
				String m3= owe.getText();
				String m4= price.getText();
				String m5= mname.getText();
				String m6="Installment basis";
				java.util.Date mm7=(java.util.Date)paydate.getValue();	
				java.sql.Date mmm7 = new java.sql.Date(mm7.getTime());
				String m7=mmm7.toString();
				java.util.Date mm8=(java.util.Date)nxtdue.getValue();
				java.sql.Date mmm8 = new java.sql.Date(mm8.getTime());
				String m8=mmm8.toString();

         int response = JOptionPane.showConfirmDialog(payment.this,
             "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
				 switch(response) 
				{
					  case JOptionPane.YES_OPTION: 
					   pstm.executeUpdate();
					   	rcpt.setEnabled(true);
						save.setEnabled(false);
					ob1.empty(); 	
						if(typ=="Second Installment")
					{
							String nd="N/A";
						ob1.instalcash(m1,m5,sel,m4,m2,m3,str,m7,stat,m6,typ,nd);
						
					}
					else
					{
						ob1.instalcash(m1,m5,sel,m4,m2,m3,str,m7,stat,m6,typ,m8);
					}
					setEmpty();
					
			Icon check=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(payment.this,"<html><font size=4 color=green>Record Saved</font></html>","Save Message",JOptionPane.ERROR_MESSAGE,check);
					    break;
						 case JOptionPane.NO_OPTION: 
							show();
				 }
				 pstm.close();
				}
		
			  }
			  if(str=="Cheque")
			   {
				 if(bnk.getText().trim().equals("")||chq.getText().trim().equals("")||act.getText().trim().equals("")||typ=="N/A")
				{
			Icon error=new ImageIcon("error.png");
			 JOptionPane.showMessageDialog(payment.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);

				}
				else
				{

				PreparedStatement pstm1=con.prepareStatement("insert into payment(mid,paydate,method,amount_paid,installment,next_duedate,owing,status,price,bnk,chq,acc,instal_type,progname)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstm1.setString(1,mid.getText());
				pstm1.setDate(2,sqlDate);
				pstm1.setString(3,str);
				pstm1.setString(4,amt.getText());
				pstm1.setBoolean(5,true);
				pstm1.setDate(6,nxtsqlDate);
				pstm1.setString(7,owe.getText());
				pstm1.setString(8,stat);
				pstm1.setString(9,price.getText());
				pstm1.setString(10,bnk.getText());
				pstm1.setString(11,chq.getText());
				pstm1.setString(12,act.getText());
				pstm1.setString(13,typ);
				pstm1.setString(14,sel);

				String m1= mid.getText();
				String m2= amt.getText();
				String m3= owe.getText();
				String m4= price.getText();
				String m5= mname.getText();
				String m6="Installment basis";
				java.util.Date mm7=(java.util.Date)paydate.getValue();	
				java.sql.Date mmm7 = new java.sql.Date(mm7.getTime());
				String m7=mmm7.toString();
				java.util.Date mm8=(java.util.Date)nxtdue.getValue();
				java.sql.Date mmm8 = new java.sql.Date(mm8.getTime());
				String m8=mmm8.toString();
				String m9= bnk.getText();
				String m10= act.getText();
				String m11= chq.getText();

         int response1 = JOptionPane.showConfirmDialog(payment.this,
             "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
				 switch(response1) 
				{
					  case JOptionPane.YES_OPTION: 
					   pstm1.executeUpdate();
					  	  rcpt.setEnabled(true);
						  save.setEnabled(false);
						ob1.empty();   
					if(typ=="Second Installment")
					{
							String nd="N/A";

						ob1.instalcheque(m1,m5,sel,m4,m2,m3,str,m7,stat,m6,typ,nd,m9,m10,m11);
					}
					else
					{
						ob1.instalcheque(m1,m5,sel,m4,m2,m3,str,m7,stat,m6,typ,m8,m9,m10,m11);
					}
					setEmpty();
					
			Icon check=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(payment.this,"<html><font size=4 color=green>Record Saved</font></html>","Save Message",JOptionPane.ERROR_MESSAGE,check);
				

					    break;
						 case JOptionPane.NO_OPTION: 
							show();
				 } 
				 pstm1.close();
				}
				
				}
		}
		else
		{
			if(str=="Cash")
			{
				PreparedStatement pstm2=con.prepareStatement("insert into payment(mid,paydate,method,amount_paid,installment,status,price,progname,instal_type,owing,bnk,chq,acc)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstm2.setString(1,mid.getText());
				pstm2.setDate(2,sqlDate);
				pstm2.setString(3,str);
				
				pstm2.setString(4,amt.getText());
				pstm2.setBoolean(5,false);
				pstm2.setString(6,stat);
				pstm2.setString(7,price.getText());
				pstm2.setString(8,sel);
				pstm2.setString(9,typ);
				pstm2.setString(10,owe.getText());
				pstm2.setString(11,s);
				pstm2.setString(12,s);
				pstm2.setString(13,s);

				
				String m1= mid.getText();
				String m2= amt.getText();
				String m3= owe.getText();
				String m4= price.getText();
				String m5= mname.getText();
				String m6="One-Time Payment";
				java.util.Date mm7=(java.util.Date)paydate.getValue();
				java.sql.Date mmm7 = new java.sql.Date(mm7.getTime());
				String m7=mmm7.toString();


         int response2 = JOptionPane.showConfirmDialog(payment.this,
             "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
				 switch(response2) 
				{
					  case JOptionPane.YES_OPTION: 
					   pstm2.executeUpdate();
					  
					  rcpt.setEnabled(true);
						save.setEnabled(false);
					ob1.empty(); 
					  	ob1.cash(m1,m5,sel,m4,m2,m3,str,m7,stat);
						  setEmpty();
						  
			Icon check=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(payment.this,"<html><font size=4 color=green>Record Saved</font></html>","Save Message",JOptionPane.ERROR_MESSAGE,check);

					    break;
						 case JOptionPane.NO_OPTION: 
							show();
				 }
			pstm2.close();
			 
			  }
			  if(str=="Cheque")
				{
				   if(bnk.getText().trim().equals("")||chq.getText().trim().equals("")||act.getText().trim().equals(""))
				{
			Icon error=new ImageIcon("error.png");
			 JOptionPane.showMessageDialog(payment.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);

				}
				else
				{
				PreparedStatement pstm3=con.prepareStatement("insert into payment(mid,paydate,method,amount_paid,installment,status,price,bnk,chq,acc,progname,instal_type,owing)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstm3.setString(1,mid.getText());
				pstm3.setDate(2,sqlDate);
				pstm3.setString(3,str);
				
				pstm3.setString(4,amt.getText());
				pstm3.setBoolean(5,false);
				pstm3.setString(6,stat);
				pstm3.setString(7,price.getText());
				pstm3.setString(8,bnk.getText());
				pstm3.setString(9,chq.getText());
				pstm3.setString(10,act.getText());
				pstm3.setString(11,sel);
				pstm3.setString(12,typ);
				pstm3.setString(13,owe.getText());

				String m1= mid.getText();
				String m2= amt.getText();
				String m3= owe.getText();
				String m4= price.getText();
				String m5= mname.getText();
				String m6="One-Time Payment";
				java.util.Date mm7=(java.util.Date)paydate.getValue();	
				java.sql.Date mmm7 = new java.sql.Date(mm7.getTime());
				String m7=mmm7.toString();
				String m9= bnk.getText();
				String m10= act.getText();
				String m11= chq.getText();

		 
		 int response3 = JOptionPane.showConfirmDialog(payment.this,
             "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
				 switch(response3) 
				{
					  case JOptionPane.YES_OPTION: 
					   pstm3.executeUpdate();
					
						  rcpt.setEnabled(true);
						save.setEnabled(false);
					
					ob1.empty(); 
							ob1.cheque(m1,m5,sel,m4,m2,m3,str,m7,stat,m9,m10,m11);
									setEmpty();
									
			Icon check=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(payment.this,"<html><font size=4 color=green>Record Saved</font></html>","Save Message",JOptionPane.ERROR_MESSAGE,check);
					    break;
						 case JOptionPane.NO_OPTION: 
							show();
				 } 
				 		pstm3.close();

				}

				}
		}
	    }
		con.close();
		}catch(Exception re)
			{
			System.out.println("error"+re );
			re.printStackTrace();
			} 

	}

if(ae.getSource()==can)
	{
			
			price.setText("");
			owe.setText("");
			amt.setText("");
			bnk.setText("");
			act.setText("");
			chq.setText("");
			bnk.setEnabled(false);
			act.setEnabled(false);
			chq.setEnabled(false);
			price.setEnabled(false);
			installtype.setEnabled(false);
			
			nxtdue.setEnabled(false);
			save.setEnabled(true);
			
		  installtype.setSelectedItem("N/A");
		  status.setSelectedItem("N/A");
  	   method.setSelectedItem("---( select )---");            
	    rcpt.setEnabled(false);
	   progname.clearSelection();
	   install.setSelected(false);
	   nxtdue.setValue(new java.util.Date());
		paydate.setValue(new java.util.Date());
	}
if(ae.getSource()==tab)
	{
		String id=mid.getText();
		String nam=mname.getText();
		viewtab ob=new viewtab();
		 ob.setTitle("View Selected Member's Payment Details");
		(ob.mid).setText(id);
		(ob.name).setText(nam);
		String strSQL="select progname,status,paydate,method,amount_paid,installment,next_duedate,owing,price,bnk,chq,acc,instal_type from payment where mid='"+id+"'";

		ob.createtab(strSQL);
		ob.show();
		
	}
	if(ae.getSource()==rcpt)
	{
		ob1.setVisible(true);
		  ob1.setTitle("Generate Payment Receipt");

		rcpt.setEnabled(false);
		save.setEnabled(true);
		SwingUtilities.updateComponentTreeUI(ob1);
		
	}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		 if (ie.getStateChange() == ie.SELECTED)
		 {
			String str1=(String)method.getSelectedItem();
			 if(str1=="Cash")
			 {
				 status.setSelectedItem("Paid");

				bnk.setEnabled(false);
				chq.setEnabled(false);
				act.setEnabled(false);
			 }
			 if(str1=="Cheque")
			 {
				status.setSelectedItem("Paid");

				bnk.setEnabled(true);
				chq.setEnabled(true);
				act.setEnabled(true);
			 }
		 Object source = ie.getItemSelectable();
        if (source == install) 
		{
			 if (ie.getStateChange() == ie.SELECTED) 
				 {
					installtype.setEnabled(true);
					nxtdue.setEnabled(true);
				 }
				 else
				 {
				 nxtdue.setEnabled(false);
				installtype.setEnabled(false);

				 }
		}

			 String sec=(String)installtype.getSelectedItem();
			 
			if(sec=="Second Installment")
			 {
				
				status.setSelectedItem("Paid");

				amt.setText(price.getText());
				owe.setText("0");
				nxtdue.setEnabled(false);//shud not b aplicable

			 }
			 if(sec=="First Installment")
			 {
				
				status.setSelectedItem("Pending");
				nxtdue.setEnabled(true);
				Float pr=Float.parseFloat(price.getText());
				float o=(pr/2);
				String ow = Float.toString(o);
				amt.setText(ow);
				owe.setText(ow);		
			 }
			 if(sec=="N/A" && source==install)
			 {
				
				status.setSelectedItem("Paid");

				amt.setText(price.getText());
				owe.setText("0");
				nxtdue.setEnabled(false);//shud not b aplicable

			 }
		 
		 }
		
	}

    public static void main(String args[]) {
        payment window = new payment();
try {
          
    UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

	          
      }
       catch (Exception ex) {
            	ex.printStackTrace();
        	}
    }
	public void setValuePay(String getid)
	{
		System.out.println("in setvalpay  in pay"+getid);
		try
		{
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
		con=DriverManager.getConnection("jdbc:odbc:emp2");
		Statement st=con.createStatement();
		ResultSet rst=st.executeQuery("select mid,name from members where mid='"+getid+"'");

			while(rst.next())
			{
				mid.setText(rst.getString(1));

				mname.setText(rst.getString(2));	
			}
			PreparedStatement st1=con.prepareStatement("select prog_name from mem_prog where mid=?");
			st1.setString(1,mid.getText());
			ResultSet rst1=st1.executeQuery();
			while(rst1.next())
			{
				listModel_progname.addElement(rst1.getString(1));	
			}
		//	rst.close();
		//	st1.close();
		//	con.close();

		}
		catch(Exception er)
      		{
		    System.out.println( er );
      		}  

	   progname.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent evt) {
		Object ob1=progname.getSelectedValue();
		String so1=ob1.toString();

		try{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con=DriverManager.getConnection("jdbc:odbc:emp2");
			PreparedStatement at1=con.prepareStatement("select price from mem_prog where mid=? and prog_name=?");
			at1.setString(1,mid.getText());
			at1.setString(2,so1);
			ResultSet ul1=at1.executeQuery();
			while(ul1.next())
			{
				price.setText(ul1.getString(1));
			}
				amt.setText(price.getText());
				owe.setText("0");

		///ul1.close();
		//at1.close();
		//con.close();
		}catch(Exception v){System.out.println( v );}

	  }
	   });

	}
	public void setEmptyPemp()
	{
							
				mname.setText("");
				chq.setText("");
				bnk.setText("");
				act.setText("");
				owe.setText("");
				price.setText("");
				amt.setText("");
	}
	public void setEmpty()
	{
							

				chq.setText("");
				bnk.setText("");
				act.setText("");
				owe.setText("");
				price.setText("");
				amt.setText("");
				bnk.setEnabled(false);
			act.setEnabled(false);
			chq.setEnabled(false);
			price.setEnabled(false);
			installtype.setEnabled(false);
			
			nxtdue.setEnabled(false);
			//save.setEnabled(true);
			
		  installtype.setSelectedItem("N/A");
		  status.setSelectedItem("N/A");
  	   method.setSelectedItem("---( select )---");            
	
	   install.setSelected(false);

	   	nxtdue.setValue(new java.util.Date());
		paydate.setValue(new java.util.Date());


	}

}
class paymentLayout implements LayoutManager {

    public paymentLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 609 + insets.left + insets.right;
        dim.height = 303 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+32,104,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+32,136,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+64,104,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+64,136,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+96,104,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+96,136,72);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+32,104,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+32,120,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+64,104,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+64,120,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+96,104,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+96,120,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+136,104,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+176,120,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+176,104,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+176,136,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+176,104,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+136,120,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+208,104,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+208,104,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+208,136,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+208,120,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+240,104,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+240,136,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+272,104,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+272,136,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+240,104,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+240,120,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+272,104,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+272,120,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+0,72,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+0,72,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+0,120,24);}
        c = parent.getComponent(33);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+0,128,24);}
    }
}

