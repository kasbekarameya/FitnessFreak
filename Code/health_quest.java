//package gym.com.freak;


import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;
//import gym.com.valid.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import java.io.*;
import java.sql.*;

public class health_quest extends JFrame implements ItemListener,ActionListener
{
	
	JButton save,canc,close;
	JPanel p1,p2;	
	static Connection con;
	static ResultSet rs;
	static Statement st;


		JLabel m_id,m_name,dates,ang_pect,hrt,hist,disab,hrt_prob,tab,diet,exe,stress,asth,hbp,palp,bp,gynac,alc,diab,fev,musco,sup,ster,med,other;
		JComboBox id_c,ang_pect_c,hrt_c,hist_c,disab_c,hrt_prob_c,tab_c,diet_c,exe_c,stress_c,asth_c,hbp_c,palp_c,bp_c,gynac_c,alc_c,diab_c,fev_c;
		JCheckBox musc,sprain,frac,surg,back,gen;
		JTextField sup_txt,ster_txt,med_txt,other_txt,name_txt;
		DateField datefield;


	public health_quest()
	{
		
		
		setLayout(new FlowLayout());		
		


		createPanel1();
		createPanel2();

		//setVisible(true);
		setSize(1000,760);
		
		getContentPane().add(p1,BorderLayout.NORTH);
		getContentPane().add(p2,BorderLayout.SOUTH);
		
	}
	public void createPanel1()
	{
		p1=new JPanel();
		//p1.setLayout(new FlowLayout());
		quest1Layout quest1 = new quest1Layout();

		p1.setLayout(quest1);

		p1.setPreferredSize(new Dimension(1000,630));
		
		
		Border etch = BorderFactory.createEtchedBorder( );
		p1.setBorder(BorderFactory.createTitledBorder(etch, "Questionnare"));



		m_id=new JLabel("Member Id");
		id_c=new JComboBox();
		id_c.addItemListener(this);
	
		m_name=new JLabel("Name");		
		name_txt=new JTextField("");

		dates=new JLabel("Date");		
		datefield = CalendarFactory.createDateField();
       

		ang_pect=new JLabel("Have you ever had angina pectoris,heavy pressure on your chest as a result of exercise or other physical activity such as climbing stairs ?");
		ang_pect_c=new JComboBox();

		hrt=new JLabel("Do you have a family history of heart attack or coronary heart disease before the age of 50?");
		hrt_c=new JComboBox();		

		hist=new JLabel("Have you ever had a real or suspected heart attack,micocardial intraction,coronary insufficiency or thrombosis?");
		hist_c=new JComboBox();

		diet=new JLabel("Have you ever been on a special diet to lower your cholesterol?");
		diet_c=new JComboBox();

		exe=new JLabel("Do you engage in regular exercise?");
		exe_c=new JComboBox();

		asth=new JLabel("Do you have asthma?");
		asth_c=new JComboBox();

		hbp=new JLabel("Do you have high blood pressure?");
		hbp_c=new JComboBox();

		palp=new JLabel("Have you ever experienced rapid heart action or palpitation?");
		palp_c=new JComboBox();

		gynac=new JLabel("Any gynaecological disorders in the past/present?");
		gynac_c=new JComboBox();		

		alc=new JLabel("Do you drink alcohol or smoke?");
		alc_c=new JComboBox();		

		diab=new JLabel("Do u have diabetes?");
		diab_c=new JComboBox();		

		fev=new JLabel("Have you ever had rheumatic fever?");		
		fev_c=new JComboBox();		

		musco=new JLabel("Please describe any past or current muskoskeletal injury you have incurred such as:");
		musc=new JCheckBox("Muscle pull");
		sprain=new JCheckBox("Sprain");
		frac=new JCheckBox("Fractures");
		surg=new JCheckBox("Surgeries");
		back=new JCheckBox("Back Pain");
		gen=new JCheckBox("General");

		sup=new JLabel("Do you take any dietary supplements? If yes,metion duration");
		sup_txt=new JTextField("");

		ster=new JLabel("Have you taken steroids at any time?");
		ster_txt=new JTextField("");

		med=new JLabel("Are you taking any medications?");
		med_txt=new JTextField("");

		other=new JLabel("Any other medical problems?");
		other_txt=new JTextField("");	
		id_c.addItem("   --Select--    ");	
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select mid from members");
			while(rs.next())
			{
					
					id_c.addItem(rs.getString(1));
			}
			
		}
		catch(Exception e)
      	{
		    System.out.println( e );
      	}
		
		p1.add(m_id);
		
		p1.add(id_c);
		p1.add(m_name);	
		p1.add(name_txt);
		name_txt.setEnabled(false);
		  		
		p1.add(ang_pect);
		ang_pect_c.addItem("no");
		ang_pect_c.addItem("yes");
		p1.add(ang_pect_c);
		p1.add(hrt);				

		hist_c.addItem("no");
		hist_c.addItem("yes");		
		p1.add(hist_c);			

		p1.add(hist);
		
		hrt_c.addItem("no");
		hrt_c.addItem("yes");
		p1.add(hrt_c);


		gynac_c.addItem("no");
		gynac_c.addItem("yes");
		p1.add(gynac_c);
		
		p1.add(diet);
		diet_c.addItem("no");
		diet_c.addItem("yes");		
		p1.add(diet_c);

		p1.add(exe);
		exe_c.addItem("no");
		exe_c.addItem("yes");		
		p1.add(exe_c);

		p1.add(asth);
		asth_c.addItem("no");
		asth_c.addItem("yes");		
		p1.add(asth_c);
		
		p1.add(hbp);
		hbp_c.addItem("no");
		hbp_c.addItem("yes");		
		p1.add(hbp_c);

		p1.add(palp);
		palp_c.addItem("no");
		palp_c.addItem("yes");		
		p1.add(palp_c);

		p1.add(gynac);

		alc_c.addItem("no");
		alc_c.addItem("yes");
		p1.add(alc_c);		

		p1.add(alc);	
		
		p1.add(diab_c);
		p1.add(diab);
		diab_c.addItem("no");
		diab_c.addItem("yes");

		p1.add(fev_c);

		p1.add(fev);
		fev_c.addItem("no");
		fev_c.addItem("yes");
		

		p1.add(musco);
		p1.add(musc);
		p1.add(sprain);
		p1.add(frac);
		p1.add(surg);
		p1.add(back);
		p1.add(gen);

		p1.add(sup);
		p1.add(sup_txt);

		p1.add(ster);
		p1.add(ster_txt);

		p1.add(med);
		p1.add(med_txt);

		p1.add(other);
		p1.add(other_txt);

		
		

		p1.add(dates);
		
		p1.add(datefield);
		add(p1);		
		
	}

	public void createPanel2()
	{	
		p2=new JPanel();
		p2.setPreferredSize(new Dimension(1000,60));
	
		//Border etch1 = BorderFactory.createEtchedBorder( );
		p2.setBorder(BorderFactory.createEtchedBorder( ));
		//p2.setLayout(new FlowLayout());
		quest2Layout quest2 = new quest2Layout();
		p2.setLayout(quest2);

		

		save=new JButton("Save");	
		save.addActionListener(this);	
		canc=new JButton("Update");
		//canc.setEnabled(false);
		canc.addActionListener(this);	

		close=new JButton("Close");		
		close.addActionListener(this);	
		
		p2.add(save);
		p2.add(canc);
		p2.add(close);
		add(p2);	

		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	
	}
	public static void main(String args[])
	{
		health_quest hq=new health_quest();

		try {
            			// select Look and Feel
	      	         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
				     SwingUtilities.updateComponentTreeUI(hq);

	          
        		}
        	catch (Exception ex) {
            	//ex.printStackTrace();
				System.out.println(ex);
        	}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==canc)
		{
			//setOrig();
			/*if(sup_txt.getText().trim().equals("")||ster_txt.getText().trim().equals("")||med_txt.getText().trim().equals("")||other_txt.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(health_quest.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
				if(sup_txt.getText().trim().equals(""))
				sup_txt.requestFocus();
				if(ster_txt.getText().trim().equals(""))
				ster_txt.requestFocus();
				if(med_txt.getText().trim().equals(""))
				med_txt.requestFocus();
				if(other_txt.getText().trim().equals(""))
				other_txt.requestFocus();
			
			}
			else
			{			
			*/
			if(id_c.getSelectedItem()=="   --Select--    ")
			{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(health_quest.this,"<html><font size=4 color=red>First choose a member to update records.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			
			else
			{
			
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");

				String mid_sel=(String)id_c.getSelectedItem();
				String ang_sel=(String)ang_pect_c.getSelectedItem();
				String hist_sel=(String)hist_c.getSelectedItem();
				String hrt_sel=(String)hrt_c.getSelectedItem();
				String diet_sel=(String)diet_c.getSelectedItem();
				String exe_sel=(String)exe_c.getSelectedItem();
				String asth_sel=(String)asth_c.getSelectedItem();

				String hbp_sel=(String)hbp_c.getSelectedItem();
				String palp_sel=(String)palp_c.getSelectedItem();
				String gynac_sel=(String)gynac_c.getSelectedItem();
				String alc_sel=(String)alc_c.getSelectedItem();
				String diab_sel=(String)diab_c.getSelectedItem();
				String fev_sel=(String)fev_c.getSelectedItem();
				java.util.Date choosed=(java.util.Date)datefield.getValue();
				java.sql.Date sqlDate=new java.sql.Date(choosed.getTime());
				PreparedStatement psm=con.prepareStatement("update health_quest set name=?,date_q=?,stairs=?,disease_hist=?,attack=?,cholestrol=?,reg_ex=?,asthma=?,bp=?,palpitatn=?,gynac=?,alcohol=?,diabetes=?,fever=?,muscle_pull=?,sprain=?,fracture=?,surgery=?,back_pain=?,gen_discomfort=?,supp=?,steroids=?,medication=?,other_prob=? where mid=?");
				
				psm.setString(1,name_txt.getText());
				psm.setDate(2,sqlDate);
				if(ang_sel.equals("yes"))
				{
					psm.setBoolean(3,true);
				}
				else
				{
					psm.setBoolean(3,false);
				}
				if(hist_sel.equals("yes"))
				{
					psm.setBoolean(4,true);	
				}
				else
				{
					psm.setBoolean(4,false);
				}
				if(hrt_sel.equals("yes"))
				{
					psm.setBoolean(5,true);
				}
				else
				{
					psm.setBoolean(5,false);
				}
				if(diet_sel.equals("yes"))
				{
					psm.setBoolean(6,true);
				}
				else
				{
					psm.setBoolean(6,false);
				}
				if(exe_sel.equals("yes"))
				{
					psm.setBoolean(7,true);
				}
				else
				{
					psm.setBoolean(7,false);
				}
				if(asth_sel.equals("yes"))
				{
					psm.setBoolean(8,true);
				}
				else
				{
					psm.setBoolean(8,false);
				}
				if(hbp_sel.equals("yes"))
				{
					psm.setBoolean(9,true);
				}
				else
				{
					psm.setBoolean(9,false);
				}
				if(palp_sel.equals("yes"))
				{
					psm.setBoolean(10,true);
				}
				else
				{
					psm.setBoolean(10,false);
				}
				if(gynac_sel.equals("yes"))
				{
					psm.setBoolean(11,true);
				}
				else
				{
					psm.setBoolean(11,false);
				}
				if(alc_sel.equals("yes"))
				{
					psm.setBoolean(12,true);
				}
				else
				{
					psm.setBoolean(12,false);
				}
				if(diab_sel.equals("yes"))
				{
					psm.setBoolean(13,true);
				}
				else
				{
					psm.setBoolean(13,false);
				}
				if(fev_sel.equals("yes"))
				{
					psm.setBoolean(14,true);
				}
				else
				{
					psm.setBoolean(14,false);
				}
				
				if(musc.isSelected())
				{
					psm.setBoolean(15,true);
				}
				else
				{
					psm.setBoolean(15,false);
				}
				if(sprain.isSelected())
				{
					psm.setBoolean(16,true);
				}
				else
				{
					psm.setBoolean(16,false);
				}
				if(frac.isSelected())
				{
					psm.setBoolean(17,true);
				}
				else
				{
					psm.setBoolean(17,false);
				}
				if(surg.isSelected())
				{
					psm.setBoolean(18,true);
				}
				else
				{
					psm.setBoolean(18,false);
				}
				if(back.isSelected())
				{
					psm.setBoolean(19,true);
				}
				else
				{
					psm.setBoolean(19,false);
				}
				if(gen.isSelected())
				{
					psm.setBoolean(20,true);
				}
				else
				{
					psm.setBoolean(20,false);
				}
				psm.setString(21,sup_txt.getText());
				psm.setString(22,ster_txt.getText());
				psm.setString(23,med_txt.getText());
				psm.setString(24,other_txt.getText());
				psm.setString(25,mid_sel);
				int response = JOptionPane.showConfirmDialog(health_quest.this,
				"Are you sure you want to update?","Confirmation",JOptionPane.YES_NO_OPTION);
				switch(response) {
				 case JOptionPane.YES_OPTION: 
					int upd=psm.executeUpdate();
				 if(upd>=1)
					{
			Icon check=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(health_quest.this,"<html><font size=4 color=green>The Record has been Updated.</font></html>","Save Message",JOptionPane.ERROR_MESSAGE,check);			
					
					//setOrig();
					}

				break;


				 case JOptionPane.NO_OPTION: 
					show();
				}   
			}
			catch(Exception e)
			{
				System.out.println("error in save:"+e);
				e.printStackTrace();
			}
			}
		
		}	

		
		if(ae.getSource()==close)
		{
			dispose();

		}
		if(ae.getSource()==save)
		{
			
			
		/*	if(sup_txt.getText().trim().equals("")||ster_txt.getText().trim().equals("")||med_txt.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(health_quest.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
				if(sup_txt.getText().trim().equals(""))
				sup_txt.requestFocus();
				if(ster_txt.getText().trim().equals(""))
				ster_txt.requestFocus();
				if(med_txt.getText().trim().equals(""))
				med_txt.requestFocus();
				if(other_txt.getText().trim().equals(""))
				other_txt.requestFocus();
			
			}
			else
			{	*/		
			if(id_c.getSelectedItem()=="   --Select--    ")
			{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(health_quest.this,"<html><font size=4 color=red>First choose a member to save records.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			
			else
			{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");

				String mid_sel=(String)id_c.getSelectedItem();
				String ang_sel=(String)ang_pect_c.getSelectedItem();
				String hist_sel=(String)hist_c.getSelectedItem();
				String hrt_sel=(String)hrt_c.getSelectedItem();
				String diet_sel=(String)diet_c.getSelectedItem();
				String exe_sel=(String)exe_c.getSelectedItem();
				String asth_sel=(String)asth_c.getSelectedItem();

				String hbp_sel=(String)hbp_c.getSelectedItem();
				String palp_sel=(String)palp_c.getSelectedItem();
				String gynac_sel=(String)gynac_c.getSelectedItem();
				String alc_sel=(String)alc_c.getSelectedItem();
				String diab_sel=(String)diab_c.getSelectedItem();
				String fev_sel=(String)fev_c.getSelectedItem();
				java.util.Date choosed=(java.util.Date)datefield.getValue();
				java.sql.Date sqlDate=new java.sql.Date(choosed.getTime());
				PreparedStatement psm=con.prepareStatement("insert into health_quest(mid,name,date_q,stairs,disease_hist,attack,cholestrol,reg_ex,asthma,bp,palpitatn,gynac,alcohol,diabetes,fever,muscle_pull,sprain,fracture,surgery,back_pain,gen_discomfort,supp,steroids,medication,other_prob) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				psm.setString(1,mid_sel);
				psm.setString(2,name_txt.getText());
				psm.setDate(3,sqlDate);
				if(ang_sel.equals("yes"))
				{
					psm.setBoolean(4,true);
				}
				else
				{
					psm.setBoolean(4,false);
				}
				if(hist_sel.equals("yes"))
				{
					psm.setBoolean(5,true);	
				}
				else
				{
					psm.setBoolean(5,false);
				}
				if(hrt_sel.equals("yes"))
				{
					psm.setBoolean(6,true);
				}
				else
				{
					psm.setBoolean(6,false);
				}
				if(diet_sel.equals("yes"))
				{
					psm.setBoolean(7,true);
				}
				else
				{
					psm.setBoolean(7,false);
				}
				if(exe_sel.equals("yes"))
				{
					psm.setBoolean(8,true);
				}
				else
				{
					psm.setBoolean(8,false);
				}
				if(asth_sel.equals("yes"))
				{
					psm.setBoolean(9,true);
				}
				else
				{
					psm.setBoolean(9,false);
				}
				if(hbp_sel.equals("yes"))
				{
					psm.setBoolean(10,true);
				}
				else
				{
					psm.setBoolean(10,false);
				}
				if(palp_sel.equals("yes"))
				{
					psm.setBoolean(11,true);
				}
				else
				{
					psm.setBoolean(11,false);
				}
				if(gynac_sel.equals("yes"))
				{
					psm.setBoolean(12,true);
				}
				else
				{
					psm.setBoolean(12,false);
				}
				if(alc_sel.equals("yes"))
				{
					psm.setBoolean(13,true);
				}
				else
				{
					psm.setBoolean(13,false);
				}
				if(diab_sel.equals("yes"))
				{
					psm.setBoolean(14,true);
				}
				else
				{
					psm.setBoolean(14,false);
				}
				if(fev_sel.equals("yes"))
				{
					psm.setBoolean(15,true);
				}
				else
				{
					psm.setBoolean(15,false);
				}
				
				if(musc.isSelected())
				{
					psm.setBoolean(16,true);
				}
				else
				{
					psm.setBoolean(16,false);
				}
				if(sprain.isSelected())
				{
					psm.setBoolean(17,true);
				}
				else
				{
					psm.setBoolean(17,false);
				}
				if(frac.isSelected())
				{
					psm.setBoolean(18,true);
				}
				else
				{
					psm.setBoolean(18,false);
				}
				if(surg.isSelected())
				{
					psm.setBoolean(19,true);
				}
				else
				{
					psm.setBoolean(19,false);
				}
				if(back.isSelected())
				{
					psm.setBoolean(20,true);
				}
				else
				{
					psm.setBoolean(20,false);
				}
				if(gen.isSelected())
				{
					psm.setBoolean(21,true);
				}
				else
				{
					psm.setBoolean(21,false);
				}
				psm.setString(22,sup_txt.getText());
				psm.setString(23,ster_txt.getText());
				psm.setString(24,med_txt.getText());
				psm.setString(25,other_txt.getText());
				int response = JOptionPane.showConfirmDialog(health_quest.this,
				"Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
				switch(response) {
				 case JOptionPane.YES_OPTION: 
					psm.executeUpdate();
			Icon check=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(health_quest.this,"<html><font size=4 color=green>The Record has been Saved</font></html>","Save Message",JOptionPane.ERROR_MESSAGE,check);			
					
					setOrig();
				

				break;


				 case JOptionPane.NO_OPTION: 
					show();
				}   
			}
			catch(Exception e)
			{
				System.out.println("error in save:"+e);
				e.printStackTrace();
			}
		
			}
		}	
	}
	public void setOrig()
	{
		ang_pect_c.setSelectedItem("no");
				hist_c.setSelectedItem("no");
				hrt_c.setSelectedItem("no");
				diet_c.setSelectedItem("no");
				exe_c.setSelectedItem("no");
				asth_c.setSelectedItem("no");

				hbp_c.setSelectedItem("no");
				palp_c.setSelectedItem("no");
				gynac_c.setSelectedItem("no");
				alc_c.setSelectedItem("no");
				diab_c.setSelectedItem("no");
				fev_c.setSelectedItem("no");
				datefield.setValue(new java.util.Date());
				sup_txt.setText("");
				ster_txt.setText("");
				med_txt.setText("");
				other_txt.setText("");
				musc.setSelected(false);
				sprain.setSelected(false);
				frac.setSelected(false);
				surg.setSelected(false);
				back.setSelected(false); 
				gen.setSelected(false);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		
		 if (ie.getStateChange() == ie.SELECTED)
		 {
			
			String str=(String)id_c.getSelectedItem();
			try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			PreparedStatement pstat = con.prepareStatement("SELECT members.name from members where members.mid=?");
			pstat.setString(1,str);
			ResultSet rset=pstat.executeQuery();
				if(rset.next())
				{
				do	
				{
					//System.out.println("name is:"+rset.getString(1));
					name_txt.setText(rset.getString(1));
					//name_txt.setText("hello");
				}while(rset.next());
				
				}
				else
				{
					name_txt.setText("");
					
					setOrig();
				}
			}
			catch(Exception ex)
			{
				System.out.println("error in name:"+ex);
			}

			try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");

			PreparedStatement pst = con.prepareStatement("SELECT * from health_quest where mid=?");
			pst.setString(1,str);
			ResultSet rs=pst.executeQuery();
						if(rs.next())
				{
                		do
						{
							  java.util.Date chk=((java.util.Date)(rs.getDate(3)));
							  datefield.setValue(chk);
			  				  if(rs.getBoolean(4)==true)
							  {
									ang_pect_c.setSelectedItem("yes");
							  }
							  else
							  {
									ang_pect_c.setSelectedItem("no");
							  }
							  if(rs.getBoolean(5)==true)
							  {
									hrt_c.setSelectedItem("yes");
							  }
							  else
							  {
									hrt_c.setSelectedItem("no");
							  }
							  if(rs.getBoolean(6)==true)
							  {
									hist_c.setSelectedItem("yes");
							  }
							  else
							  {
									hist_c.setSelectedItem("no");
							  }
							  if(rs.getBoolean(7)==true)
							  {
									diet_c.setSelectedItem("yes");
							  }
							  else
							  {
									diet_c.setSelectedItem("no");
							  }
							  if(rs.getBoolean(8)==true)
							  {
									exe_c.setSelectedItem("yes");
							  }
							  else
							  {
									exe_c.setSelectedItem("no");
							  }
							  if(rs.getBoolean(9)==true)
							  {
									asth_c.setSelectedItem("yes");
							  }
							  else
							  {
									asth_c.setSelectedItem("no");
							  }
							  if(rs.getBoolean(10)==true)
							  {
									hbp_c.setSelectedItem("yes");
							  }
							  else
							  {
									hbp_c.setSelectedItem("no");
							  }
							  if(rs.getBoolean(11)==true)
							  {
									palp_c.setSelectedItem("yes");
							  }
							  else
							  {
									palp_c.setSelectedItem("no");
							  }
							  if(rs.getBoolean(12)==true)
							  {
									gynac_c.setSelectedItem("yes");
							  }
							  else
							  {
									gynac_c.setSelectedItem("no");
							  }

							  if(rs.getBoolean(13)==true)
							  {
									alc_c.setSelectedItem("yes");
							  }
							  else
							  {
									alc_c.setSelectedItem("no");
							  }
							  if(rs.getBoolean(14)==true)
							  {
									diab_c.setSelectedItem("yes");
							  }
							  else
							  {
									diab_c.setSelectedItem("no");
							  }

							  if(rs.getBoolean(15)==true)
							  {
									fev_c.setSelectedItem("yes");
							  }
							  else
							  {
									fev_c.setSelectedItem("no");
							  }
							  musc.setSelected(rs.getBoolean(16));	
							  sprain.setSelected(rs.getBoolean(17));	
							  frac.setSelected(rs.getBoolean(18));	
							  surg.setSelected(rs.getBoolean(19));	
							  back.setSelected(rs.getBoolean(20));	
							  gen.setSelected(rs.getBoolean(21));
							  
							  sup_txt.setText(rs.getString(22));
							  ster_txt.setText(rs.getString(23));
							  med_txt.setText(rs.getString(24));
							  other_txt.setText(rs.getString(25));
							 
						}while (rs.next());
						save.setEnabled(false);
				canc.setEnabled(true);
				}
						else
						{
						//	name_txt.setText("");	
						 save.setEnabled(true);
						canc.setEnabled(false);
							setOrig();
						}
						
              }
			
			catch (Exception e)
			{
				System.out.println("error :"+e);
           	 }
			
	
		 }
		
   	 }
}
/*
class quest1Layout implements LayoutManager {

    public quest1Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 1023 + insets.left + insets.right;
        dim.height = 597 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+8,56,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+8,120,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+8,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+8,120,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+40,816,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+40,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+72,816,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+72,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+104,816,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+104,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+144,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+144,376,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+144,56,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+176,376,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+176,56,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+208,376,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+208,56,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+240,376,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+240,56,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+272,376,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+272,56,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+464,insets.top+144,360,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+176,72,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+464,insets.top+176,360,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+208,72,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+464,insets.top+208,360,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+240,72,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+464,insets.top+240,360,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+320,688,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+360,120,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+360,96,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+360,104,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+360,112,24);}
        c = parent.getComponent(33);
        if (c.isVisible()) {c.setBounds(insets.left+488,insets.top+360,112,24);}
        c = parent.getComponent(34);
        if (c.isVisible()) {c.setBounds(insets.left+608,insets.top+360,104,24);}
        c = parent.getComponent(35);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+400,384,24);}
        c = parent.getComponent(36);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+400,312,24);}
        c = parent.getComponent(37);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+440,384,24);}
        c = parent.getComponent(38);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+440,312,24);}
        c = parent.getComponent(39);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+472,384,24);}
        c = parent.getComponent(40);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+472,312,24);}
        c = parent.getComponent(41);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+512,384,24);}
        c = parent.getComponent(42);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+512,312,24);}
        c = parent.getComponent(43);
        if (c.isVisible()) {c.setBounds(insets.left+560,insets.top+8,72,24);}
        c = parent.getComponent(44);
        if (c.isVisible()) {c.setBounds(insets.left+640,insets.top+8,72,24);}
    }
}

*/
class quest1Layout implements LayoutManager {

    public quest1Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 1023 + insets.left + insets.right;
        dim.height = 597 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,88,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+8,120,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+8,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+8,120,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+40,816,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+40,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+72,816,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+72,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+104,816,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+104,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+144,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+144,376,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+144,56,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+176,376,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+176,56,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+208,376,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+208,56,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+240,376,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+240,56,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+272,376,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+272,56,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+464,insets.top+144,360,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+176,72,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+464,insets.top+176,360,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+208,72,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+464,insets.top+208,360,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+848,insets.top+240,72,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+464,insets.top+240,360,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+320,688,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+360,120,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+360,96,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+360,104,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+360,112,24);}
        c = parent.getComponent(33);
        if (c.isVisible()) {c.setBounds(insets.left+488,insets.top+360,112,24);}
        c = parent.getComponent(34);
        if (c.isVisible()) {c.setBounds(insets.left+608,insets.top+360,104,24);}
        c = parent.getComponent(35);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+400,384,24);}
        c = parent.getComponent(36);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+400,312,24);}
        c = parent.getComponent(37);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+440,384,24);}
        c = parent.getComponent(38);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+440,312,24);}
        c = parent.getComponent(39);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+472,384,24);}
        c = parent.getComponent(40);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+472,312,24);}
        c = parent.getComponent(41);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+512,384,24);}
        c = parent.getComponent(42);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+512,312,24);}
        c = parent.getComponent(43);
        if (c.isVisible()) {c.setBounds(insets.left+560,insets.top+8,72,24);}
        c = parent.getComponent(44);
        if (c.isVisible()) {c.setBounds(insets.left+640,insets.top+8,72,24);}
    }
}

class quest2Layout implements LayoutManager {

    public quest2Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 851 + insets.left + insets.right;
        dim.height = 71 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+352,insets.top+16,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+472,insets.top+16,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+584,insets.top+16,72,24);}
    }
}
