//package gym.com.freak;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.*;
import java.util.regex.*;
import javax.swing.JOptionPane;
import java.util.Formatter;
//import gym.com.valid.*;


public class emp_fin extends JFrame implements ActionListener,ItemListener{
    JLabel birth;
    JLabel pin;
    JLabel add;
    JLabel name;
    JLabel empno;
    JLabel mobno;
    JLabel phoneno;
    JLabel doj;
    JLabel email;
     NumericTextField textfield_1;
     NumericTextField txtda;
   JTextField txtemail;
    NumericTextField txtmob;
     NumericTextField txtphone;
    DateField datefield;
     DateField datefield2;
     NumericTextField txtpin;
    JTextField txtremark;
    StringTextField txtname;
    JTextField txtempno;
    JLabel remark;
    JLabel shift;
    JLabel desg;
    JTextArea txtadd;
    JScrollPane sp_txtadd;
    JLabel sal;
    //JLabel label_5;
    //JComboBox cmbstatus;
    JLabel basic;
    JLabel DA;
    JLabel pf;
     NumericTextField txtpf;
    JLabel label_6;
    JComboBox combobox_1;
    JButton button_1;
    JButton save;
    JButton update;
    JButton del;
    ButtonGroup cbg;
    JRadioButton rdmale;
    JRadioButton rdfemale;
    JComboBox combobox_2;
    JTextField txtsearch;
    JComboBox cond;
    JButton search2;
	JLabel label_1;
    JTextField txtfinsal;
    JButton calsal;
 JButton cancel;

    public emp_fin() {
        empLayout customLayout = new empLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        birth = new JLabel("Birth Date");
        getContentPane().add(birth);

        pin = new JLabel("* Pin Code");
        getContentPane().add(pin);

        add = new JLabel("* Address");
        getContentPane().add(add);

        name = new JLabel("* Name");
        getContentPane().add(name);

        empno = new JLabel("Employee ID");
        getContentPane().add(empno);

        mobno = new JLabel("Mobile No.");
        getContentPane().add(mobno);

        phoneno = new JLabel("*Phone No.");
        getContentPane().add(phoneno);

        doj = new JLabel("Date of Join");
        getContentPane().add(doj);

        email = new JLabel("Email Id.");
        getContentPane().add(email);

        textfield_1 = new  NumericTextField();
        getContentPane().add(textfield_1);

        txtda = new  NumericTextField();
        getContentPane().add(txtda);

        //txtemail = new MailTextField();
		txtemail = new JTextField();
        getContentPane().add(txtemail);

        txtmob = new  NumericTextField();
        getContentPane().add(txtmob);

        txtphone = new  NumericTextField();
        getContentPane().add(txtphone);

        datefield2 = CalendarFactory.createDateField();
        getContentPane().add(datefield2);

        datefield = CalendarFactory.createDateField();
        getContentPane().add(datefield);

        txtpin = new  NumericTextField();
        getContentPane().add(txtpin);

        txtremark = new JTextField("");
        getContentPane().add(txtremark);

        txtname = new StringTextField();
        getContentPane().add(txtname);

        txtempno = new JTextField("");
        getContentPane().add(txtempno);
        txtempno.setEditable(false);

        remark = new JLabel("Remark");
        getContentPane().add(remark);

        shift = new JLabel("Timing/Shift");
        getContentPane().add(shift);

        desg = new JLabel("Gender");
        getContentPane().add(desg);

        txtadd = new JTextArea("");
        sp_txtadd = new JScrollPane(txtadd);
        getContentPane().add(sp_txtadd);

        sal = new JLabel("Salary Details");
        getContentPane().add(sal);


        basic = new JLabel("* Basic");
        getContentPane().add(basic);

        DA = new JLabel("*DA (%)");
        getContentPane().add(DA);

        pf = new JLabel("*PF (%)");
        getContentPane().add(pf);

        txtpf = new  NumericTextField();
        getContentPane().add(txtpf);

        label_6 = new JLabel("Type of Employee");
        getContentPane().add(label_6);

        combobox_1 = new JComboBox();
        combobox_1.addItem("Gym Instructor");
        combobox_1.addItem("Receptionist");
        combobox_1.addItem("Management");
        combobox_1.addItem("Nutritionist");
        combobox_1.addItem("Cleaner");
        getContentPane().add(combobox_1);

        button_1 = new JButton("Add");
        getContentPane().add(button_1);
        button_1.addActionListener(this);
        

        save = new JButton("Save");
        getContentPane().add(save);
        save.addActionListener(this);
		save.setEnabled(false);

        update = new JButton("Update");
        getContentPane().add(update);
        update.addActionListener(this);
        update.setEnabled(false);

        del = new JButton("Delete");
        getContentPane().add(del);
        del.addActionListener(this);
	del.setEnabled(false);

        cbg = new ButtonGroup();
        rdmale = new JRadioButton("Male", true);
        cbg.add(rdmale);
        getContentPane().add(rdmale,true);

        rdfemale = new JRadioButton("Female", false);
        cbg.add(rdfemale);
        getContentPane().add(rdfemale);

        combobox_2 = new JComboBox();
        combobox_2.addItem("Morning");
        combobox_2.addItem("Evening");
        getContentPane().add(combobox_2);

        txtsearch = new JTextField("");
        getContentPane().add(txtsearch);

        cond = new JComboBox();
        cond.addItem("Name");
        cond.addItem("Employee Id");
        getContentPane().add(cond);
		cond.addItemListener(this);

        search2 = new JButton("Search");
        getContentPane().add(search2);
        search2.addActionListener(this);
        search2.setEnabled(true);

		label_1 = new JLabel("* Salary");
        getContentPane().add(label_1);

        txtfinsal = new JTextField("");
        getContentPane().add(txtfinsal);
		txtfinsal.setEnabled(false);


		ImageIcon i = new ImageIcon("calculator.png");
        calsal = new JButton(i);
        getContentPane().add(calsal);
	calsal.addActionListener(this);
	calsal.setEnabled(false);

	cancel = new JButton("Cancel");
        getContentPane().add(cancel);
	cancel.setEnabled(false);
	cancel.addActionListener(this);



        setSize(getPreferredSize());
		setUndecorated(true);
       getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
          		txtname.setText("");
				txtpin.setText("");
				txtremark.setText("");
				txtemail.setText("");
				txtphone.setText("");
				txtmob.setText("");
				textfield_1.setText("");
				txtadd.setText("");
				textfield_1.setText("");
				txtda.setText("");
				txtpf.setText("");
				txtfinsal.setText("");
				txtempno.setText("");
				update.setEnabled(false);
				del.setEnabled(false);
				java.util.Date today1 = new java.util.Date();
				datefield.setValue(today1);
				datefield2.setValue(today1);



            }
        });
    }

    public static void main(String args[]) {
        emp_fin window = new emp_fin();

         try {
           
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);
           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
window.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        window.setTitle("Employee Details");
        window.pack();
        window.show();
    }


	public void itemStateChanged(ItemEvent ie)
	{
		 

		
       
		String str=(String)cond.getSelectedItem();
		if(str=="Employee Id")
		{
			txtsearch.setText("EMP");
		}
		if(str=="Name")
		{
			txtsearch.setText("");
		}

		
	}


public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==save)
		{
		
			if(txtname.getText().trim().equals("")||txtadd.getText().trim().equals("")||txtpin.getText().trim().equals("")||txtphone.getText().trim().equals("")||txtda.getText().trim().equals("")||txtpf.getText().trim().equals("")||textfield_1.getText().trim().equals("")||txtfinsal.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Please enter all mandatory fields </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
				if(txtname.getText().trim().equals(""))
				txtname.requestFocus();
				if(txtadd.getText().trim().equals(""))
				txtadd.requestFocus();
				if(txtpin.getText().trim().equals(""))
				txtpin.requestFocus();
				if(txtphone.getText().trim().equals(""))
				txtphone.requestFocus();
				if(txtda.getText().trim().equals(""))
				txtphone.requestFocus();
				if(txtpf.getText().trim().equals(""))
				txtphone.requestFocus();
				if(textfield_1.getText().trim().equals(""))
				txtphone.requestFocus();
				if(txtfinsal.getText().trim().equals(""))
				txtphone.requestFocus();
			}
			
			else if(txtphone.getText().length()>11 || txtphone.getText().length()<8)
			{
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Enter valid phone number </font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
					txtphone.requestFocus();
				
			}


			else if(txtemail.getText().length()!=0)
			{			

				MailTextField m1=new MailTextField();
				Boolean b=m1.email(txtemail.getText());
				if (b==false)
				{
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Enter valid email id </font></html> \n\t\t ","Error",JOptionPane.ERROR_MESSAGE,error);
					txtemail.requestFocus();
				}
				
				else if(txtmob.getText().length()!=0)
				{
					if(txtmob.getText().length()>13 || txtmob.getText().length()<10)
					{
					
						Icon error=new ImageIcon("error.png");
						JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Invalid mobile number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
						txtmob.requestFocus();
					}
					else
					saverec();
			
				}	
					else
					saverec();
				
			}	
			
			else if(txtemail.getText().length()==0)
			{			

				
				 if(txtmob.getText().length()!=0)
				{
					if(txtmob.getText().length()>13 || txtmob.getText().length()<10)
					{
					
						Icon error=new ImageIcon("error.png");
						JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Invalid mobile number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
						txtmob.requestFocus();
					}
					else
					saverec();
			
				}	
					else
					saverec();
				
			}	
			
			else
			 {
				System.out.println("pleaasseeee update");
				saverec();
			 }
			
			/*else if(txtemail.getText().length()!=0)
			{			

			MailTextField m1=new MailTextField();
				Boolean b=m1.email(txtemail.getText());
				if (b==false)
				{
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Enter valid id </font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
				
					txtemail.requestFocus();
				}
				else
					saverec();
			}	
			else if(txtmob.getText().length()!=0)
			{
				if(txtmob.getText().length()>13 || txtmob.getText().length()<10)
				{
					
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Invalid mobile number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
				}
				else
					saverec();
			
			}
			else 
			{
				saverec();
			}*/

			
			}//save over
			
		if(ae.getSource()==cancel)

		{
				java.util.Date today4 = new java.util.Date();
				datefield.setValue(today4);
				datefield2.setValue(today4);

			search2.setEnabled(true);
			button_1.setEnabled(true);
			update.setEnabled(false);
			save.setEnabled(false);
			del.setEnabled(false);
			cancel.setEnabled(false);

			txtempno.setText("");
			txtname.setText("");
				txtpin.setText("");
				txtremark.setText("");
				txtemail.setText("");
				txtphone.setText("");
				txtmob.setText("");
				textfield_1.setText("");
				txtadd.setText("");
				textfield_1.setText("");
				txtda.setText("");
				txtpf.setText("");
				txtfinsal.setText("");
				calsal.setEnabled(false);
		}

		if(ae.getSource()==button_1)

		{
				java.util.Date today5 = new java.util.Date();
				datefield.setValue(today5);
				datefield2.setValue(today5);

				button_1.setEnabled(false);
				cancel.setEnabled(true);
				
				calsal.setEnabled(true);
				update.setEnabled(false);
				del.setEnabled(false);
				search2.setEnabled(false);
				save.setEnabled(true);
				try
				{
					DataInputStream sin=new DataInputStream(new FileInputStream("emp.dat"));
					txtempno.setText(sin.readUTF());
				}
				catch(Exception ex)
				{
				}
				txtname.setText("");
				txtpin.setText("");
				txtremark.setText("");
				txtemail.setText("");
				txtphone.setText("");
				txtmob.setText("");
				textfield_1.setText("");
				txtadd.setText("");
				textfield_1.setText("");
				txtda.setText("");
				txtpf.setText("");
				txtfinsal.setText("");

		}

		if(ae.getSource()==update)
		{
			int resp = JOptionPane.showConfirmDialog(emp_fin.this, "Are you sure you want to update?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(resp) {
            case JOptionPane.YES_OPTION: 
			if(txtname.getText().trim().equals("")||txtadd.getText().trim().equals("")||txtpin.getText().trim().equals("")||txtphone.getText().trim().equals("")||txtda.getText().trim().equals("")||txtpf.getText().trim().equals("")||textfield_1.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Insufficient data </font></html> \n\t\tPlease enter all mandatory fields","Error",JOptionPane.ERROR_MESSAGE,error);
				if(txtname.getText().trim().equals(""))
				txtname.requestFocus();
				if(txtadd.getText().trim().equals(""))
				txtadd.requestFocus();
				if(txtpin.getText().trim().equals(""))
				txtpin.requestFocus();
				if(txtphone.getText().trim().equals(""))
				txtphone.requestFocus();
				if(txtda.getText().trim().equals(""))
				txtphone.requestFocus();
				if(txtpf.getText().trim().equals(""))
				txtphone.requestFocus();
				if(textfield_1.getText().trim().equals(""))
				txtphone.requestFocus();
			}
			
			else if(txtphone.getText().length()>11 || txtphone.getText().length()<8)
			{
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Enter valid phone number </font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
					txtphone.requestFocus();
				
			}
				
			
			else if(txtemail.getText().length()!=0)
			{			

				MailTextField m1=new MailTextField();
				Boolean b=m1.email(txtemail.getText());
				if (b==false)
				{
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Enter valid email id </font></html> \n\t\t ","Error",JOptionPane.ERROR_MESSAGE,error);
					txtemail.requestFocus();
				}
				
				else if(txtmob.getText().length()!=0)
				{
					if(txtmob.getText().length()>13 || txtmob.getText().length()<10)
					{
					
						Icon error=new ImageIcon("error.png");
						JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Invalid mobile number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
						txtmob.requestFocus();
					}
					else
					updnow();
			
				}	
					else
					updnow();
				
			}	
			
			else if(txtemail.getText().length()==0)
			{			

				
				 if(txtmob.getText().length()!=0)
				{
					if(txtmob.getText().length()>13 || txtmob.getText().length()<10)
					{
					
						Icon error=new ImageIcon("error.png");
						JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Invalid mobile number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
						txtmob.requestFocus();
					}
					else
					updnow();
			
				}	
					else
					updnow();
				
			}	
			
			else
			 {
				System.out.println("pleaasseeee update");
				updnow();
			 }
			
			break;
			case JOptionPane.NO_OPTION: 
				show();
		 }
		}
		if(ae.getSource()==del)
		{
			PreparedStatement ps;
			int resp = JOptionPane.showConfirmDialog(emp_fin.this, "Are you sure you want to delete?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(resp) {
            case JOptionPane.YES_OPTION: 
				java.util.Date today = new java.util.Date();
             datefield.setValue(today);
			 datefield2.setValue(today);
			
			try
			{
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
				ps=con.prepareStatement("DELETE FROM emp where empno=?");
				ps.setString(1,txtempno.getText());
				int del=ps.executeUpdate();
				txtempno.setText("");
				txtname.setText("");
				txtpin.setText("");
				txtremark.setText("");
				txtemail.setText("");
				txtphone.setText("");
				txtmob.setText("");
				textfield_1.setText("");
				txtadd.setText("");
				textfield_1.setText("");
				txtda.setText("");
				txtpf.setText("");
				txtfinsal.setText("");
				txtsearch.setText("");
				if(del==1)
				{
				Icon tick=new ImageIcon("Check_h.gif");
				JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=green>Record Deleted</font></html> ","Message",JOptionPane.ERROR_MESSAGE,tick);
				}
				else
				{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Could Not Delete</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				}
			}
			catch(Exception e)
			{
				System.out.println("error"+e);
				
			}
			
			 break;
            case JOptionPane.NO_OPTION: 
		
				//ps.close();
				//con.close();
				show();
		 }
		}
		if(ae.getSource()==calsal)
		{
				
				if(txtda.getText().trim().equals("")||txtpf.getText().trim().equals("")||textfield_1.getText().trim().equals(""))
				{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Please fill all the details</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);

				}
				else
				{
				float i1=Float.parseFloat(textfield_1.getText());
				float i2=Float.parseFloat(txtda.getText());
				float i3=Float.parseFloat(txtpf.getText());
				if(i2>=0 && i2<=100 && i3>=0 && i3<=100)
				{
				float daadded=(i2/100)*i1;
				float pfsub=(i3/100)*i1;
				float finsal=(i1+daadded)-pfsub;
				Formatter fmt = new Formatter();
				Object f=fmt.format("%.2f", finsal);
				
				txtfinsal.setText(String.valueOf(f));
				//save.setEnabled(true);
				System.out.println(finsal);
				}
				else
				{
				System.out.println("Percentage should be less than 100");
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Percentage should be less than 100</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				
				}
				}	
				
		}
		
		if(ae.getSource()==search2)
		{
			if(txtsearch.getText().trim().equals(""))
			{
				Icon error=new ImageIcon("error.png");
			JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Please enter a value to be searched.</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
			
			}
			else
			{
		String condition=(String)cond.getSelectedItem();
		calsal.setEnabled(true);
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
		
		PreparedStatement prs=null;
		String searchfor=txtsearch.getText().toLowerCase();
		
		if(condition=="Name")
		{
			
			//String sql="select * from emp";
			//System.out.println(searchfor);
			 prs=con.prepareStatement("select * from emp where name=?");
			prs.setString(1,searchfor);

		}
		else
		{	
			 prs=con.prepareStatement("select * from emp where empno=?");
			prs.setString(1,searchfor);
			// sql="select * from emp where empno="+searchfor;
		}
		ResultSet rs=prs.executeQuery();
		if(rs.next())
			{
			do
		{
			
				txtempno.setText(rs.getString(1));
				txtname.setText(rs.getString(2));
				txtadd.setText(rs.getString(3));
				txtpin.setText(rs.getString(4));

				java.util.Date date1=((java.util.Date)(rs.getDate(5)));
				System.out.println("date1 is:"+date1);
				datefield.setValue(date1);
				

				java.util.Date date2=((java.util.Date)(rs.getDate(6)));
				datefield2.setValue(date2);
				System.out.println("date2 is:"+date2);

				String sex=rs.getString(7);


				if(sex.equals("male"))
					{
						rdmale.setSelected(true);
					}
					else
					{
						rdfemale.setSelected(true);
					}

				txtphone.setText(rs.getString(8));
				txtmob.setText(rs.getString(9));
				txtemail.setText(rs.getString(10));
				Object ob1=(Object)rs.getString(11);
				combobox_2.setSelectedItem(ob1);
				txtremark.setText(rs.getString(12));
				//Object ob2=(Object)rs.getString(13);
				//cmbstatus.setSelectedItem(ob2);
				Object ob3=(Object)rs.getString(13);
				combobox_1.setSelectedItem(ob3);
				
				
			
				textfield_1.setText(rs.getString(14));
				txtda.setText(rs.getString(15));
				txtpf.setText(rs.getString(16));
				txtfinsal.setText(rs.getString(17));
				
				System.out.println("sarch found");
				txtsearch.setText("");
				update.setEnabled(true);
				del.setEnabled(true);

		}while(rs.next());
			}
			else
			{
			Icon error=new ImageIcon("error.png");
			JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>No Match Found</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
			txtsearch.setText("");
			update.setEnabled(false);
			del.setEnabled(false);


			}
		}
		catch(Exception e)
		{
		}
			}
		}	
		
	}
			public void updnow()
			{
				try
				{
				
				PreparedStatement pstm;
				String shift_sel=(String)combobox_2.getSelectedItem();
				String prof_sel=(String)combobox_1.getSelectedItem();						
				System.out.println("update block");
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");	
				String res=null;
				if(rdmale.isSelected()==true)
				{
					res="male";
				}
				else
				{
						res="female";
				}

				java.util.Date choosed = (java.util.Date)datefield.getValue();
				java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());

				java.util.Date choosed2 = (java.util.Date)datefield2.getValue();
				java.sql.Date sqlDate2 = new java.sql.Date(choosed2.getTime());
				
				String sel=txtempno.getText();
				
				pstm=con.prepareStatement("update emp set name=?,address=?,pincode=?,birthdate=?,doj=?,sex=?,phoneno=?,mobileno=?,emailid=?,shift=?,remark=?,profile=?,basic=?,da=?,pf=?,sal=? where empno=?");			

				
				pstm.setString(1,txtname.getText());
				pstm.setString(2,txtadd.getText());
				pstm.setString(3,txtpin.getText());
				pstm.setDate(4,sqlDate);
				pstm.setDate(5,sqlDate2);
				pstm.setString(6,res);				
				pstm.setString(7,txtphone.getText());
				pstm.setString(8,txtmob.getText());
				//System.out.println("email:"+txtemail.getText());
				pstm.setString(9,txtemail.getText());

				pstm.setString(10,shift_sel);
				pstm.setString(11,txtremark.getText());
				pstm.setString(12,prof_sel);  
				float i1=Float.parseFloat(textfield_1.getText());
				float i2=Float.parseFloat(txtda.getText());
				float i3=Float.parseFloat(txtpf.getText());
				float i4=Float.parseFloat(txtfinsal.getText());
				/*Formatter fmt = new Formatter();
				Object f=fmt.format("%.2f", textfield_1.getText());
				Object f2=fmt.format("%.2f", txtda.getText());
				Object f3=fmt.format("%.2f", txtpf.getText());*/
				//txtfinsal.setText(String.valueOf(f));
				pstm.setString(13,String.valueOf(i1));
				pstm.setString(14,String.valueOf(i2));
				pstm.setString(15,String.valueOf(i3));
				pstm.setString(16,txtfinsal.getText());
				pstm.setString(17,txtempno.getText());
				
				int upd=pstm.executeUpdate();
				if(upd==1)
				{
				//System.out.println("row updated");
				Icon tick=new ImageIcon("Check_h.gif");
				JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=green>Record Updated</font></html> ","Message",JOptionPane.ERROR_MESSAGE,tick);
				}
				else
				{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Could Not Update</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				}
	
			}
			catch(Exception e)
			{
				System.out.println("error"+e);
				e.printStackTrace();
				
			}
	}

			public void saverec()
			{
			String sql;

			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
					
				

							
				PreparedStatement pstm=con.prepareStatement("insert into emp(empno,name,address,pincode,birthdate,doj,sex,phoneno,mobileno,emailid,shift,remark,profile,basic,da,pf,sal)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstm.setString(1,txtempno.getText());
				String empname=txtname.getText().toLowerCase();
				pstm.setString(2,empname);
				pstm.setString(3,txtadd.getText());
				pstm.setString(4,txtpin.getText());
				
				java.util.Date choosed = (java.util.Date)datefield.getValue();
				java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
				
				
				 System.out.println("date in sql:"+sqlDate);
				 pstm.setDate(5,sqlDate);
				java.util.Date choosed2 = (java.util.Date)datefield2.getValue();
				java.sql.Date sqlDate2 = new java.sql.Date(choosed2.getTime());
				pstm.setDate(6,sqlDate2);
				if(rdmale.isSelected()==true)
				pstm.setString(7,"male");
				else
				pstm.setString(7,"female");	
				pstm.setString(8,txtphone.getText());
				pstm.setString(9,txtmob.getText());
				pstm.setString(10,txtemail.getText());
				String timing=(String)combobox_2.getSelectedItem();
				pstm.setString(11,timing);
				
				pstm.setString(12,txtremark.getText());
				//String status=(String)cmbstatus.getSelectedItem();
				//pstm.setString(13,status);
				String pro=(String)combobox_1.getSelectedItem();
				pstm.setString(13,pro);
				float i1=Float.parseFloat(textfield_1.getText());
				float i2=Float.parseFloat(txtda.getText());
				float i3=Float.parseFloat(txtpf.getText());
				//float i4=Float.parseFloat(txtfinsal.getText());
				pstm.setFloat(14,i1);
				pstm.setFloat(15,i2);
				pstm.setFloat(16,i3);
				pstm.setString(17,txtfinsal.getText());
				int ins=pstm.executeUpdate();
			
				if (ins==1)
				{
				Icon check=new ImageIcon("Check_h.gif");
				JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=green>Record Saved</font></html>","Save",JOptionPane.ERROR_MESSAGE,check);
				save.setEnabled(false);
				search2.setEnabled(true);
				update.setEnabled(true);
				del.setEnabled(true);
				cancel.setEnabled(false);
				button_1.setEnabled(true);
				calsal.setEnabled(false);
				}
				else
				{
					Icon error1=new ImageIcon("error.gif");
					JOptionPane.showMessageDialog(emp_fin.this,"<html><font size=4 color=red>Could Not Save</font></html>","Error",JOptionPane.ERROR_MESSAGE,error1);
				}

				DataInputStream dt=new DataInputStream(new FileInputStream("emp.dat"));
							String temp2=dt.readUTF();
							String coursename="EMP";
							int len=coursename.length();
							String temp=temp2.substring(len);
							int x=Integer.parseInt(temp);
							if(x<9)
							{
								x++;
								temp2=coursename+"000"+x;
							}
							else
							if(x<99)
							{
								x++;
								temp2=coursename+"00"+x;
							}
							else
							if(x<999)
							{
								x++;
								temp2=coursename+"0"+x;
							}
							else
							{
								x++;
								temp2=coursename+x;
							}
							DataOutputStream out=new DataOutputStream(new FileOutputStream("emp.dat"));
							out.writeUTF(temp2);
							dt.close();

			}
			catch(Exception e)
      	 	 	{
            			System.out.println("error"+e );
					//	e.printStackTrace();
      		 	} 
			}

class NumericTextField extends JTextField
{

  
    protected Document createDefaultModel()
    {
        return new NumericDocument();
    }

    private class NumericDocument extends PlainDocument
    {
     // The regular expression to match input against (zero or more digits)
        private final  Pattern DIGITS = Pattern.compile("[0-9.]*");
     //  private final static Pattern DIGITS = Pattern.compile("\\d*");
   //   private final static Pattern POINT = Pattern.compile(".+\\.[0-9]+");
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
        {
            // Only insert the text if it matches the regular expression
           // if (str != null && DIGITS.matcher(str).matches())
 	if (str != null && DIGITS.matcher(str).matches())
	{
                super.insertString(offs, str, a);
	}
	else
	{
		JOptionPane.showMessageDialog(emp_fin.this,"Enter only numbers");
		
	}
	}


        
    }
}
}
/* 
class empLayout implements LayoutManager {

    public empLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 749 + insets.left + insets.right;
        dim.height = 428 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+184,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+152,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+104,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+72,72,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+40,80,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+280,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+248,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+216,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+312,72,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+616,insets.top+72,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+616,insets.top+104,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+312,112,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+280,112,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+248,112,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+216,112,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+184,112,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+152,112,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+152,112,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+72,112,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+40,112,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+152,88,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+112,96,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+40,72,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+104,112,40);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+40,104,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+184,88,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+184,112,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+72,72,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+104,72,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+136,72,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+616,insets.top+136,72,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+216,104,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+216,112,24);}
        c = parent.getComponent(33);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+360,72,24);}
        c = parent.getComponent(34);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+360,72,24);}
        c = parent.getComponent(35);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+360,80,24);}
        c = parent.getComponent(36);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+360,80,24);}
        c = parent.getComponent(37);
        if (c.isVisible()) {c.setBounds(insets.left+384,insets.top+40,72,24);}
        c = parent.getComponent(38);
        if (c.isVisible()) {c.setBounds(insets.left+384,insets.top+72,72,24);}
        c = parent.getComponent(39);
        if (c.isVisible()) {c.setBounds(insets.left+384,insets.top+112,72,24);}
        c = parent.getComponent(40);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+216,80,24);}
        c = parent.getComponent(41);
        if (c.isVisible()) {c.setBounds(insets.left+616,insets.top+216,80,24);}
        c = parent.getComponent(42);
        if (c.isVisible()) {c.setBounds(insets.left+568,insets.top+256,88,24);}
        c = parent.getComponent(43);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+168,72,24);}
        c = parent.getComponent(44);
        if (c.isVisible()) {c.setBounds(insets.left+616,insets.top+168,72,24);}
        c = parent.getComponent(45);
        if (c.isVisible()) {c.setBounds(insets.left+696,insets.top+160,32,32);}
        c = parent.getComponent(46);
        if (c.isVisible()) {c.setBounds(insets.left+504,insets.top+360,72,24);}
    }
}
*/
class empLayout implements LayoutManager {

    public empLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 749 + insets.left + insets.right;
        dim.height = 428 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+184,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+152,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+104,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+72,72,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+40,80,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+280,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+248,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+216,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+312,72,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+616,insets.top+72,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+616,insets.top+104,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+312,112,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+280,112,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+248,112,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+216,112,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+184,112,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+152,112,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+152,112,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+72,112,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+40,112,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+152,88,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+112,96,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+40,72,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+104,112,40);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+40,104,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+72,72,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+104,72,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+136,72,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+616,insets.top+136,72,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+184,104,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+184,112,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+360,72,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+360,72,24);}
        c = parent.getComponent(33);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+360,80,24);}
        c = parent.getComponent(34);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+360,80,24);}
        c = parent.getComponent(35);
        if (c.isVisible()) {c.setBounds(insets.left+384,insets.top+40,72,24);}
        c = parent.getComponent(36);
        if (c.isVisible()) {c.setBounds(insets.left+384,insets.top+72,72,24);}
        c = parent.getComponent(37);
        if (c.isVisible()) {c.setBounds(insets.left+384,insets.top+112,72,24);}
        c = parent.getComponent(38);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+216,80,24);}
        c = parent.getComponent(39);
        if (c.isVisible()) {c.setBounds(insets.left+616,insets.top+216,80,24);}
        c = parent.getComponent(40);
        if (c.isVisible()) {c.setBounds(insets.left+568,insets.top+256,88,24);}
        c = parent.getComponent(41);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+168,72,24);}
        c = parent.getComponent(42);
        if (c.isVisible()) {c.setBounds(insets.left+616,insets.top+168,72,24);}
        c = parent.getComponent(43);
        if (c.isVisible()) {c.setBounds(insets.left+696,insets.top+160,32,32);}
        c = parent.getComponent(44);
        if (c.isVisible()) {c.setBounds(insets.left+504,insets.top+360,72,24);}
    }
}
