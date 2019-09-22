//package gym;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;

//import org.jdesktop.jdic.desktop.*;
import java.net.*;
import java.io.File;

/*

import gym.com.freak.emergency;
import gym.com.freak.newsusp1;
import gym.com.freak.memprog;
import gym.com.freak.pass;	
import gym.com.freak.eatingpattern;	
import gym.com.freak.measure;	
import gym.com.freak.excer_fin;
import gym.com.freak.fitnesstemp;
import gym.com.freak.Calculator;
import gym.com.freak.holiday2;
import gym.com.freak.diet.calorie2;
import gym.com.freak.emp_fin;
import gym.com.freak.complaint2;
import gym.com.freak.health_quest;
import gym.com.freak.prog_config1;	
import gym.com.freak.payment;
//import gym.com.freak.Calculator;

import gym.com.reports.*;
*/
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.BoxLayout;	
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



class main_form1 extends JFrame implements ActionListener,ItemListener
{
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	

	static Connection con;
	static Statement st;
	static ResultSet rs;
	ResultSet resu;
		

	 static emergency em=new emergency();
	 static payment pay=new payment();	
	 static newsusp1 ns=new newsusp1();
	 static memprog mp=new memprog();
	
	

	String id;
	JMenuBar mb;
	JMenu fitf,exercise,configur,remind,health,help,reports,genr,cust,sals;
	JMenuItem empl,appt,cmp,qt;
	JMenu adm;
	JMenuItem excard,cft,msr;
	JMenuItem pbhol,genconf,proconf,passconf,repconf;
	JMenuItem bday,duedate,nutri,msg,cftr;
	JMenuItem gnrl,perf;
	JMenuItem cur,emem;
	JMenuItem exp,pro,noop,om,insta;
	JMenuItem suspo,shift,smem,suspt;
	JMenuItem epat,hqst,ccn,msrmt;
	JMenuItem abt,manual;
	ImageIcon new_mem,mail_img,con_i,dust,back,calc,save_img,b_save,b_add,b_close,b_first,b_last,b_next,b_previous,b_locker,b_help,b_reload,b_refresh,h_add,h_save,h_del,h_refresh,b_can;
   	JButton add_new,mail_b,con1_i,dust_b,back_b,calc_b,save_b,save_bb,add_b,close_b,first_b,last_b,next_b,previous_b,locker_b,locker,reload_b,refresh_b,add_h,save_h,del_h,refresh_h,can_b,help_b;
   	JToolBar bar;

	JTextField reg;
	StringValidCheck first;	
	JTextField emailid;
	NumericValid home;
	NumericValid cell;
	JTextField notes1;
	JTextField add1;
	StringValidCheck sub1;			
   	NumericValid pin;			
	JTextField occu1;
	//NumericValid1 owing_res;
	DateField datefield;
	ButtonGroup bg;

	JRadioButton male;
	JRadioButton fem;
	JCheckBox train;
	JComboBox trainer1;
//	JComboBox status1;

	JTextField search1;
	JTabbedPane jtp;
			
			
	JComboBox search_cmb;//28	

			
	JButton srch;
			Icon check=new ImageIcon("Check_h.gif");
			
	
	public main_form1()
	{
		
			Icon lock=new ImageIcon("lock.gif");	
			Icon exit=new ImageIcon("Exit.png");	
		
		
		
		mb=new JMenuBar();
		setJMenuBar(mb);

		
		fitf=new JMenu("Fitness Freak");
		mb.add(fitf);		
		
		empl =new JMenuItem(" Employee");
		empl.addActionListener(this);
		fitf.add(empl);

		cmp =new JMenuItem("Complaint");
		fitf.add(cmp);
		cmp.addActionListener(this);

		appt =new JMenuItem("Appointment");
		fitf.add(appt);
		appt.addActionListener(this);

		qt =new JMenuItem("Quit");
		fitf.add(qt);
		qt.addActionListener(this);
       qt.setIcon(exit);

		
		exercise=new JMenu("Excercise");
		mb.add(exercise);

		excard =new JMenuItem("Excercise Card");
		exercise.add(excard);
		excard.addActionListener(this);

		cft =new JMenuItem("Fitness Test");
		exercise.add(cft);
		cft.addActionListener(this);

		msr =new JMenuItem("Measurement");
		exercise.add(msr);
		msr.addActionListener(this);
		

		configur=new JMenu("Configuration");
		mb.add(configur);

		pbhol=new JMenuItem("Public Holiday");
		pbhol.addActionListener(this);
		configur.add(pbhol);

		genconf=new JMenuItem("General Configuration");
		configur.add(genconf);
		genconf.addActionListener(this);
		
		proconf=new JMenuItem("Programme Configuration");
		configur.add(proconf);
		proconf.addActionListener(this);	

		passconf=new JMenuItem("Change Login Password");
		passconf.addActionListener(this);
		configur.add(passconf);

		repconf=new JMenuItem("Change Report Password");
		repconf.addActionListener(this);
		repconf.setEnabled(false);

		configur.add(repconf);

		reports=new JMenu("Reports");


		adm=new JMenu("Admin Reports");
		genr=new JMenu("General Reports");

		cust=new JMenu("Customer Related");
		sals=new JMenu("Sales Related");

		cur=new JMenuItem("Current Customers");
		cur.addActionListener(this);
		emem=new JMenuItem("Expired memberships");
		emem.addActionListener(this);
		exp=new JMenuItem("Expenses");
		exp.addActionListener(this);
		pro=new JMenuItem("Profit-Loss");
		pro.addActionListener(this);
		noop=new JMenuItem("No. of programs");
		noop.addActionListener(this);
		om=new JMenuItem("Money Owed");
		om.addActionListener(this);
		insta=new JMenuItem("Installments");
		insta.addActionListener(this);
		smem=new JMenuItem("Suspended members");
		smem.addActionListener(this);
		suspo=new JMenuItem("Customer Suspension Report");
		suspo.addActionListener(this);
		shift=new JMenuItem("Employee Shifts");
		shift.addActionListener(this);
		

		cust.add(cur);
		cust.add(emem);
		sals.add(exp);
		sals.add(pro);
		sals.add(noop);
		sals.add(om);
		sals.add(insta);
		adm.add(cust);
		adm.add(sals);
		genr.add(smem);
		genr.add(suspo);
		

		genr.add(shift);
		reports.add(genr);	
		reports.add(adm);	
		mb.add(reports);

		adm.setEnabled(false);
		adm.setIcon(lock);


		remind=new JMenu("Reminders");
		mb.add(remind);

		bday=new JMenuItem("Birthday");
		remind.add(bday);
		bday.addActionListener(this);

		duedate=new JMenuItem("Payment Due Date");
		duedate.addActionListener(this);
		remind.add(duedate);

		msg=new JMenuItem("Massage Appointments");
		remind.add(msg);
		msg.addActionListener(this);

		nutri=new JMenuItem("Nutritionist Appointments");
		nutri.addActionListener(this);
		remind.add(nutri);

		cftr=new JMenuItem("Common Fitness Test");
		cftr.addActionListener(this);
		remind.add(cftr);



		health=new JMenu("Health");
		mb.add(health);

		epat=new JMenuItem("Eating Pattern");
		epat.addActionListener(this);
		health.add(epat);

		msrmt=new JMenuItem("Measurement");
		msrmt.addActionListener(this);
		health.add(msrmt);

		hqst=new JMenuItem("Health Questionnaire");
		hqst.addActionListener(this);
		health.add(hqst);

		ccn=new JMenuItem("Calorie Counter");
		ccn.addActionListener(this);
		health.add(ccn);


		help=new JMenu("Help");
		mb.add(help);
		/*manual=new JMenuItem("Fitness Freak Manual");
		manual.addActionListener(this);
		help.add(manual);*/
		abt=new JMenuItem("About Fitness Freak");
		abt.addActionListener(this);

		help.add(abt);




		bar=new JToolBar();
		bar.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
		
       	new_mem=new ImageIcon("add_reviewer.gif");
		calc=new ImageIcon("icon6.jpg");
		save_img=new ImageIcon("save.png");
		
		b_add=new ImageIcon("add.png");
		b_close=new ImageIcon("dust2.png");
		b_last=new ImageIcon("last.png");
		b_next=new ImageIcon("next.png");
		b_first=new ImageIcon("first.png");
		b_previous=new ImageIcon("previous.png");
		b_locker=new ImageIcon("lock_off.png");
		b_reload=new ImageIcon("load.png");
		b_refresh=new ImageIcon("refresh.png");
		b_help=new ImageIcon("lock_log.png");
		h_save=new ImageIcon("Save_h.gif");
		h_add=new ImageIcon("Add_h.gif");
		h_refresh=new ImageIcon("Refresh_h.gif");
		b_can=new ImageIcon("close.png");


		add_new=new JButton(new_mem);
		add_new.setToolTipText("Add a new member(ALT+A)");
		add_new.setMnemonic(KeyEvent.VK_A);
		add_new.addActionListener(this);

		save_b=new JButton(save_img);
		save_b.setToolTipText("Save the entered details(ALT+S)");
		save_b.setEnabled(false);
		save_b.setMnemonic(KeyEvent.VK_S);

		save_b.addActionListener(this);

		can_b=new JButton(b_can);
		can_b.setToolTipText("Cancel changes(ALT+C)");
		can_b.setEnabled(false);
		can_b.setMnemonic(KeyEvent.VK_C);

		can_b.addActionListener(this);

		first_b=new JButton(b_first);
		first_b.setToolTipText("View first record");
		first_b.addActionListener(this);	


		calc_b=new JButton(calc);
		calc_b.addActionListener(this);
		calc_b.setToolTipText("Calorie Counter");
		add_b=new JButton(b_add);

		add_b.addActionListener(this);

		//close_b=new JButton(b_close);
		//close_b.addActionListener(this);

		next_b=new JButton(b_next);
		next_b.setToolTipText("View next member(ALT+N)");
		next_b.addActionListener(this);
		next_b.setMnemonic(KeyEvent.VK_N);


		previous_b=new JButton(b_previous);
		previous_b.setToolTipText("View previous member(ALT+P)");
		previous_b.addActionListener(this);
		previous_b.setMnemonic(KeyEvent.VK_P);

		last_b=new JButton(b_last);
		last_b.setToolTipText("Move to last record");
		last_b.addActionListener(this);

		close_b=new JButton(b_close);
		close_b.setToolTipText("Delete member(ALT+D)");
		close_b.setMnemonic(KeyEvent.VK_D);

		close_b.addActionListener(this);


		reload_b=new JButton(b_reload);
		reload_b.setToolTipText("Update current record(ALT+U)");
		reload_b.setMnemonic(KeyEvent.VK_U);

		reload_b.addActionListener(this);

		locker_b=new JButton(b_locker);
		locker_b.addActionListener(this);
		locker_b.setToolTipText("View confidential reports");

		help_b=new JButton(b_help);
		help_b.addActionListener(this);
		help_b.setEnabled(false);
		help_b.setToolTipText("Lock confidential reports");
		
		refresh_h=new JButton(h_refresh);
		refresh_h.addActionListener(this);

		add_h=new JButton(h_add);
		add_h.addActionListener(this);

		del_h=new JButton(h_del);
		del_h.addActionListener(this);

		save_h=new JButton(h_save);
		save_h.addActionListener(this);

	//	cal_b=new JButton(b_cal);
	//	cal_b.addActionListener(this);
	//	cal_b.setToolTipText("Basic Calculator");



        bar.add(add_new);
		bar.add(save_b);
	
	
		bar.add(first_b);
		bar.add(previous_b);
		bar.add(next_b);
		bar.add(last_b);

		bar.add(close_b);
		bar.add(can_b);
		bar.add(reload_b);
		bar.add(calc_b);
		bar.add(locker_b);
		bar.add(help_b);

      	add(bar, BorderLayout.NORTH);
		bar.setFloatable(false);
		
		// Create the panels
		createPanel1();
		createPanel2();


		setSize(1022,760);
		add(panel1,BorderLayout.CENTER);
		
		
		add(panel2,BorderLayout.PAGE_END);
		//fra.setDefaultCloseOperation(fra.EXIT_ON_CLOSE);		

		
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setExtendedState(JFrame.MAXIMIZED_BOTH); 
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:emp2");
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//	st=con.createStatement();
			rs=st.executeQuery("select * from members");
			rs.next();
			
			}
		catch(Exception e)
		{
			System.out.println("error"+e);
		}

		showRecord(rs);

		String mid_no=reg.getText();
		em.setValueEmp(mid_no);
		ns.setValueSusp(mid_no);
		mp.setValueMemp(mid_no);
		pay.setValuePay(mid_no);

		show();
	
		

		
	}

	public void createPanel1()
	{

		

		panel1 = new JPanel();
		panel1.setLayout( new BorderLayout());
		
		panel1.setPreferredSize(new Dimension(1000,368));


		
			JLabel reg_no;
			
			JLabel first_name;
			
			
			JLabel dob;
			JLabel email;
			JLabel gender;
			JLabel home_phone;
			JLabel cell_no;
			JLabel address;
			JLabel suburb;
			JLabel pin_no;		
			JLabel occu;				
    		JLabel trainer;
			JLabel notes;
			
     

		
    		membersLayout1 customLayout = new membersLayout1();

			panel1.setFont(new Font("Helvetica", Font.PLAIN, 12));
      		panel1.setLayout(customLayout);
	

			reg_no = new JLabel("Member ID.");
	       	panel1.add(reg_no);
			reg = new JTextField("");
			reg.setEnabled(false);
        	panel1.add(reg);


			first_name = new JLabel("*Full Name");
      		panel1.add(first_name);
			first = new StringValidCheck();
			panel1.add(first);
			  	
	
			dob = new JLabel("*Date of Birth");
        	panel1.add(dob);
			datefield=CalendarFactory.createDateField();
			//datefield.setEnabled(false);

			panel1.add(datefield);

	
			email = new JLabel("Email Id");
        	panel1.add(email);
			emailid = new JTextField("");
		//	emailid.setEnabled(false);
        	panel1.add(emailid);

			gender = new JLabel("*Gender");
        	panel1.add(gender);

			bg = new ButtonGroup();
			male=new JRadioButton("male",true);
		//	male.setEnabled(false);
			fem=new JRadioButton("female");
		//	fem.setEnabled(false);

			bg.add(male);
			bg.add(fem);

			panel1.add(male);
			panel1.add(fem);//13


 			home_phone = new JLabel("*Home Phone No.");
        	panel1.add(home_phone);
			home = new NumericValid();
		//	home.setEnabled(false);
       		panel1.add(home);      
        	

			cell_no = new JLabel("Cell No.");
        	panel1.add(cell_no);
			cell = new NumericValid();
		//	cell.setEnabled(false);
        	panel1.add(cell);

			notes = new JLabel("Notes");
      		panel1.add(notes);
			notes1 = new JTextField("");
	//		notes1.setEnabled(false);
        	panel1.add(notes1);

			address = new JLabel("*Address");
       		panel1.add(address);
			add1 = new JTextField("");
        	panel1.add(add1);
	

       		suburb = new JLabel("*Surburb");
       		panel1.add(suburb);
			sub1= new StringValidCheck();
       		panel1.add(sub1);  

			pin_no = new JLabel("*Pin No.");
        	panel1.add(pin_no);			     
       		pin = new NumericValid();
			panel1.add(pin);	 
	
			occu = new JLabel("*Occupation");
       		panel1.add(occu);
			occu1= new JTextField("");
			panel1.add(occu1); 

			trainer = new JLabel("Personal Trainer");
      		panel1.add(trainer);
			train=new JCheckBox("Booked",false);
			train.addItemListener(this);
		//	train.setEnabled(false);
			panel1.add(train);
			trainer1 = new JComboBox();
			trainer1.addItem("N/A");
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:emp2");
				st=con.createStatement();
				rs=st.executeQuery("select * from emp where profile='Gym Instructor'");
				while(rs.next())
				{
       				trainer1.addItem(rs.getString(2));
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

      		panel1.add(trainer1);
	 
			

			
			panel3 = new JPanel();
			panel3.setLayout(new BorderLayout(20,6));

			search1=new JTextField(5);
			panel3.add(search1, BorderLayout.NORTH);

			search_cmb=new JComboBox();
	  		search_cmb.addItem("Full Name");
       		search_cmb.addItem("Member Id");

			search_cmb.addItemListener(this);
			panel3.add(search_cmb, BorderLayout.NORTH);

			srch=new JButton("Search");
			srch.addActionListener(this);
			panel3.add(srch, BorderLayout.SOUTH);	
			panel1.add(panel3); 

			panel3.setLayout(new FlowLayout());

			Border etch1 = BorderFactory.createEtchedBorder(  );
			panel3.setBorder(BorderFactory.createTitledBorder(etch1, "Search"));
	
	
	}

	public void createPanel2()
	{
		panel2 = new JPanel();
		panel2.setLayout( new BorderLayout());

		panel2.setBorder(BorderFactory.createEtchedBorder());
				
		panel2.setPreferredSize(new Dimension(1000,325));
		

		jtp = new JTabbedPane(JTabbedPane.LEFT);
		jtp.addChangeListener(changeListener);
        panel2.add(jtp);
       
        JPanel jp1 = new JPanel();		
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		jp1.add(em);
		em.repaint();
		jp1.repaint();
		jp2.add(ns);
		jp3.add(mp);
		jp4.add(pay);

        
        jtp.addTab("emergency details", jp1);
		jtp.addTab("Suspension", jp2);
		jtp.addTab("Programme", jp3);
		jtp.addTab("Payment", jp4);

	}

	

	public static void main( String args[] )
	{
		main_form1 mainFrame= new main_form1();
		

		try {
	      	         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
				     SwingUtilities.updateComponentTreeUI(mainFrame);

	          
        		}
        	catch (Exception ex) {
				System.out.println(ex);
        	}


	}

	public void saverec()
			{
			try
			{
			con=DriverManager.getConnection("jdbc:odbc:emp2");
		
			PreparedStatement pstm=con.prepareStatement("insert into members(mid,name,dob,email,gender,home_phone,cell_phone,notes,address,suburb,pin_no,occup,pers_train,pers_cmb)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstm.setString(1,reg.getText());
			pstm.setString(2,first.getText());
			
				
			java.util.Date choosed = (java.util.Date)datefield.getValue();
			java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
				
				
			pstm.setDate(3,sqlDate);

			pstm.setString(4,emailid.getText());

			if(male.isSelected())
			{
				pstm.setString(5,"male");
			}
			else
			{
				pstm.setString(5,"female");
			}
			
			pstm.setString(6,home.getText());
			pstm.setString(7,cell.getText());
			pstm.setString(8,notes1.getText());
			pstm.setString(9,add1.getText());
			pstm.setString(10,sub1.getText());
			pstm.setString(11,pin.getText());
			pstm.setString(12,occu1.getText());
			if(train.isSelected())
			{
				pstm.setBoolean(13,true);
			}
			else
			{
				pstm.setBoolean(13,false);
			}

			String pt=(String)trainer1.getSelectedItem();				
			pstm.setString(14,pt);

				
			int response = JOptionPane.showConfirmDialog(main_form1.this,
            "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
			switch(response) {
            case JOptionPane.YES_OPTION: 
            int upd=pstm.executeUpdate();
			next_b.setEnabled(true);
				first_b.setEnabled(true);
				last_b.setEnabled(true);
				previous_b.setEnabled(true);
				reload_b.setEnabled(true);
				close_b.setEnabled(true);
				save_b.setEnabled(false);
				can_b.setEnabled(false);

		
			if(upd==1)
			{
			JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=green>Successfully saved </font></html> ","Saved",JOptionPane.INFORMATION_MESSAGE,check);
			add_new.setEnabled(true);
			String sql="select * from members";
			Statement st=con.createStatement(); 
			resu=st.executeQuery(sql);
			showRecord(resu);
			}
			
			DataInputStream dt=new DataInputStream(new FileInputStream("mem.dat"));
			String temp2=dt.readUTF();
			String coursename="MEM";
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
							DataOutputStream out=new DataOutputStream(new FileOutputStream("mem.dat"));
							out.writeUTF(temp2);
							dt.close();
							String set=reg.getText();
							em.txtmid.setText(set);	
			
			
						break;
					case JOptionPane.NO_OPTION: 
					show();
			}	
							
		}
		catch(Exception e)
      	 	{
            			System.out.println("error"+e );
					//	e.printStackTrace();
      		} 
			}//saverec over



	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==can_b)
		{	
			add_new.setEnabled(true);
			can_b.setEnabled(false);
			reg.setText("");
			save_b.setEnabled(false);
			setEmpty();
					next_b.setEnabled(true);
					first_b.setEnabled(true);
					last_b.setEnabled(true);
					previous_b.setEnabled(true);
					reload_b.setEnabled(true);
					close_b.setEnabled(true);
					while (ns.model.getRowCount()>0){
							ns.model.removeRow(0);
								}

					while (mp.model.getRowCount()>0){
							mp.model.removeRow(0);
								}
					

		}
		if(ae.getSource()==add_new)
		{
			try
				{
					//System.out.println("hola");
					DataInputStream sin=new DataInputStream(new FileInputStream("mem.dat"));
					reg.setText(sin.readUTF());		
										

				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
					em.save_b.setEnabled(true);
					em.upd_b.setEnabled(false);
					em.can_b.setEnabled(true);
					train.setSelected(false);
					trainer1.setSelectedItem("N/A");
					save_b.setEnabled(true);
					add_new.setEnabled(false);
					can_b.setEnabled(true);
					pay.listModel_progname.clear();
					mp.pnamecombo.removeAllItems();
					setEmpty();
					mp.addCombo();

					next_b.setEnabled(false);
					first_b.setEnabled(false);
					last_b.setEnabled(false);
					previous_b.setEnabled(false);
					reload_b.setEnabled(false);
					close_b.setEnabled(false);
					int no=ns.model.getRowCount();

					while (ns.model.getRowCount()>0){
							ns.model.removeRow(0);
								}

					while (mp.model.getRowCount()>0){
							mp.model.removeRow(0);
								}


		}//add_new over


		if(ae.getSource()==save_b)
		{
			
			
			if(first.getText().trim().equals("")||home.getText().trim().equals("")||add1.getText().trim().equals("")||sub1.getText().trim().equals("")||pin.getText().trim().equals("")||occu1.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
				if(first.getText().trim().equals(""))
				first.requestFocus();
				if(home.getText().trim().equals(""))
				home.requestFocus();
				if(add1.getText().trim().equals(""))
				add1.requestFocus();
				if(sub1.getText().trim().equals(""))
				sub1.requestFocus();
				if(pin.getText().trim().equals(""))
				pin.requestFocus();
				if(occu1.getText().trim().equals(""))
				occu1.requestFocus();
			
			}
				



			else if(home.getText().length()>11 || home.getText().length()<8)
			{
					System.out.println("home pfone val");
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Invalid phone number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
			
			}
				
			else if(emailid.getText().length()!=0)
			{			

					MailValid m1=new MailValid();
					Boolean b=m1.email(emailid.getText());
					if (b==false)
					{
						Icon error=new ImageIcon("error.png");
						JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Enter valid id </font></html> \n\t\t Please enter valid email id","Error",JOptionPane.ERROR_MESSAGE,error);
						emailid.requestFocus();
					}
				
					else if(train.isSelected())
					{
						String pt=(String)trainer1.getSelectedItem();
						//pstm.setBoolean(13,true);	
						System.out.println(pt);
						Icon infom=new ImageIcon("info.png");
						if(pt=="N/A")
						{	
							JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=Blue>Please select a trainer</font></html> ","Information",JOptionPane.INFORMATION_MESSAGE,infom);					
							trainer1.requestFocus();
						}
						
					else if(cell.getText().length()!=0)
					{
							if(cell.getText().length()>13 || cell.getText().length()<10)
							{
								System.out.println("celll pfone val");

								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Invalid mobile number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
							}
							else
								saverec();
			
					}
					else
						saverec();						
					}
				}//main else if
				
					
					
				
				else if(emailid.getText().length()==0)
				{
					
				
					if(train.isSelected())
					{
						String pt=(String)trainer1.getSelectedItem();
						//pstm.setBoolean(13,true);	
						System.out.println(pt);
						Icon infom=new ImageIcon("info.png");
						if(pt=="N/A")
						{	
							JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=Blue>Please select a trainer</font></html> ","Information",JOptionPane.INFORMATION_MESSAGE,infom);					
							trainer1.requestFocus();
						}
						
						else if(cell.getText().length()!=0)
						{
							if(cell.getText().length()>13 || cell.getText().length()<10)
							{
								System.out.println("celll pfone val");

								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Invalid mobile number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
							}
							else
								saverec();
			
						}
						else
							saverec();						
					}
					else
							saverec();

					
					 
			
				}
							
				
				else
				{
					//pstm.setBoolean(13,false);
					saverec();
				}
				

				

			
			
		}//save_b over


		if(ae.getSource()==ccn)
		{
			calorie2 cal2=new calorie2();		
			cal2.setTitle("Calorie Counter");
			cal2.show();
			 SwingUtilities.updateComponentTreeUI(cal2);
		}
	
		if(ae.getSource()==cur)
		{
			
		curcust2 cc=new curcust2();	
		cc.setTitle("Current Customer Report");
			cc.setVisible(true);
		     SwingUtilities.updateComponentTreeUI(cc);

		}
		if(ae.getSource()==abt)
		{
			
		about abo=new about();	
		abo.setTitle("About Us");
			abo.setVisible(true);
		     SwingUtilities.updateComponentTreeUI(abo);

		}


		if(ae.getSource()==emem)
		{
			memover mov=new memover();
			mov.setTitle("Memberships Expiring");
		     SwingUtilities.updateComponentTreeUI(mov);
			mov.setVisible(true);
		}
		if(ae.getSource()==exp)
		{
			expense expen=new expense();
			expen.setTitle("Expense Report");
		     SwingUtilities.updateComponentTreeUI(expen);
			expen.setVisible(true);
		}
		if(ae.getSource()==insta)
		{
			installment install=new installment();
			install.setTitle("Member Installment Report");
		     SwingUtilities.updateComponentTreeUI(install);
			install.setVisible(true);
		}
		if(ae.getSource()==noop)
		{
			noofprogs nop=new noofprogs();
			nop.setTitle("No. of customers in each programme");
		     SwingUtilities.updateComponentTreeUI(nop);
			nop.setVisible(true);
		}
		if(ae.getSource()==om)
		{
			oweMoney money=new oweMoney();
			money.setTitle("Members Owing Money");
		     SwingUtilities.updateComponentTreeUI(money);
			money.setVisible(true);
		}
		if(ae.getSource()==pro)
		{
			profit prof=new profit();
			prof.setTitle("Profit Report");
		     SwingUtilities.updateComponentTreeUI(prof);
			prof.setVisible(true);
		}
		if(ae.getSource()==smem)
		{
			suspmember suspmemb=new suspmember();
			suspmemb.setTitle("Currently Suspended Members");
		     SwingUtilities.updateComponentTreeUI(suspmemb);
			suspmemb.setVisible(true);
		}




		if(ae.getSource()==close_b)
		{
			try
			{

				
				con=DriverManager.getConnection("jdbc:odbc:emp2");
		
				
			int response1 = JOptionPane.showConfirmDialog(main_form1.this,
             "Are you sure you want to delete?","Confirmation",JOptionPane.YES_NO_OPTION);
			 switch(response1)
			 {
				case JOptionPane.YES_OPTION: 
					PreparedStatement pstm=con.prepareStatement("delete * from members where mid =?", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					pstm.setString(1,reg.getText());

					int upd=pstm.executeUpdate();

					if(upd==1)
					{
					
			JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=green>Record successfully deleted </font></html> ","Record Delete",JOptionPane.INFORMATION_MESSAGE,check);

						setEmpty();
					reg.setText("");
					em.txtmid.setText("");
					ns.regid.setText("");
					mp.txtid.setText("");
					pay.mid.setText("");
						add_new.setEnabled(true);
					em.save_b.setEnabled(true);
					em.upd_b.setEnabled(false);
					em.can_b.setEnabled(true);


				 rs=st.executeQuery("select * from members");

					}
					else
					{
						Icon error=new ImageIcon("error.png");

						JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Error</font></html> \n\t\t Unable to delete","Error",JOptionPane.ERROR_MESSAGE,error);
					}
					

				break;
				case JOptionPane.NO_OPTION: 
				show();

				
			
			}   
		
			}catch(Exception e)
			 {
					e.printStackTrace();
			}
		
			
		}

		if(ae.getSource()==locker_b)
		{	
				login_rep logrep=new login_rep();
				logrep.setVisible(true);
		}
		if(ae.getSource()==help_b)
		{	
			adm.setEnabled(false);
			repconf.setEnabled(false);

			locker_b.setEnabled(true);
			help_b.setEnabled(false);

		}

		/*if(ae.getSource()==cal_b)
		{	
				gym.com.freak.Calculator calcu=new gym.com.freak.Calculator();
				calcu.setTitle("Calculator");	
				SwingUtilities.updateComponentTreeUI(calcu);	
				calcu.setVisible(true);
				calcu.setSize(250,270);
		}*/

		if(ae.getSource()==next_b)
		{
			
			
			try
			{
				
				if(rs.isAfterLast())
				{
					
					rs.first();

					String res=rs.getString(1);
					em.setValueEmp(res);
					ns.setEmptySusp();
					ns.setValueSusp(res);
				
				
					mp.pnamecombo.removeAllItems();
					mp.setEmptyMemp();
					mp.setValueMemp(res);
					mp.setDisabMemp();
					pay.setEmpty();
					pay.listModel_progname.removeAllElements();
					pay.repaint();
					pay.setValuePay(res);
										
				}
				else
				{			
					
					rs.next();

					String id_st=rs.getString(1);
				//	em.setDisabEmp();
					
					ns.setEmptySusp();
					mp.pnamecombo.removeAllItems();
					mp.setEmptyMemp();
					pay.listModel_progname.removeAllElements();
					pay.setEmpty();
					em.setValueEmp(id_st);
					
					ns.setValueSusp(id_st);
					mp.setValueMemp(id_st);
					mp.setDisabMemp();
					
					
					
					pay.repaint();
					pay.setValuePay(id_st);
					
					
				}
				
			}catch(Exception e){}
			
			showRecord(rs);
			

		}
		if(ae.getSource()==previous_b)
		{
			try
			{
				
				if(rs.isBeforeFirst())
				{
					
					rs.last();

					String res=rs.getString(1);
					em.setValueEmp(res);
					ns.setEmptySusp();
					ns.setValueSusp(res);
				
				
					mp.pnamecombo.removeAllItems();
					mp.setEmptyMemp();
					mp.setValueMemp(res);
					mp.setDisabMemp();
					pay.listModel_progname.removeAllElements();
					pay.setEmpty();

					pay.repaint();
					pay.setValuePay(res);
										
					
					
				}
				else
				{			
					
					rs.previous();
					String id_st=rs.getString(1);
				//	em.setDisabEmp();
					em.setValueEmp(id_st);
					ns.setEmptySusp();
					ns.setValueSusp(id_st);
					
					
					mp.pnamecombo.removeAllItems();
					mp.setEmptyMemp();
					mp.setValueMemp(id_st);
					mp.setDisabMemp();
					pay.listModel_progname.removeAllElements();
					pay.setEmpty();
					pay.repaint();
					pay.setValuePay(id_st);
					
					
				}
				
			}catch(Exception e){}
			
			showRecord(rs);
			

		}
		if(ae.getSource()==last_b)
		{
			
			try
			{
				rs=st.executeQuery("select * from members");
				rs.last();			
			
				String res=rs.getString(1);
				em.setValueEmp(res);
					ns.setEmptySusp();
					ns.setValueSusp(res);
				mp.setEmptyMemp();
				mp.pnamecombo.removeAllItems();
				mp.setValueMemp(res);
				mp.setDisabMemp();
				pay.setEmpty();
				pay.listModel_progname.removeAllElements();
				pay.setValuePay(res);
			}catch(Exception e){}
			showRecord(rs);

		}
		if(ae.getSource()==first_b)
		{
			
			try
			{
				rs=st.executeQuery("select * from members");
				rs.first();

				String res=rs.getString(1);
				em.setValueEmp(res);
					ns.setEmptySusp();
					ns.setValueSusp(res);
				mp.setEmptyMemp();
				mp.pnamecombo.removeAllItems();
				mp.setValueMemp(res);
				mp.setDisabMemp();
				pay.setEmpty();
				pay.listModel_progname.removeAllElements();
				pay.setValuePay(res);
			}catch(Exception e){}
			showRecord(rs);

			
		}
	
		if(ae.getSource()==reload_b)
		{
			if(first.getText().trim().equals("")||home.getText().trim().equals("")||add1.getText().trim().equals("")||sub1.getText().trim().equals("")||pin.getText().trim().equals("")||occu1.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
				if(first.getText().trim().equals(""))
				first.requestFocus();
				if(home.getText().trim().equals(""))
				home.requestFocus();
				if(add1.getText().trim().equals(""))
				add1.requestFocus();
				if(sub1.getText().trim().equals(""))
				sub1.requestFocus();
				if(pin.getText().trim().equals(""))
				pin.requestFocus();
				if(occu1.getText().trim().equals(""))
				occu1.requestFocus();
			
			}
			else if(home.getText().length()>11 || home.getText().length()<8)
			{
					System.out.println("home pfone val");
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Invalid phone number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
			
			}
				
			else if(emailid.getText().length()!=0)
			{			

					MailValid m1=new MailValid();
					Boolean b=m1.email(emailid.getText());
					if (b==false)
					{
						Icon error=new ImageIcon("error.png");
						JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Enter valid id </font></html> \n\t\t Please enter valid email id","Error",JOptionPane.ERROR_MESSAGE,error);
						emailid.requestFocus();
					}
				
					else if(train.isSelected())
					{
						String pt=(String)trainer1.getSelectedItem();
						//pstm.setBoolean(13,true);	
						System.out.println(pt);
						Icon infom=new ImageIcon("info.png");
						if(pt=="N/A")
						{	
							JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=Blue>Please select a trainer</font></html> ","Information",JOptionPane.INFORMATION_MESSAGE,infom);					
							trainer1.requestFocus();
						}
						
					else if(cell.getText().length()!=0)
					{
							if(cell.getText().length()>13 || cell.getText().length()<10)
							{
								System.out.println("celll pfone val");

								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Invalid mobile number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
							}
							else
								updfunc();
			
					}
					else
						updfunc();						
					}
				}//main else if
				
					
					
				
				else if(emailid.getText().length()==0)
				{
					
				
					if(train.isSelected())
					{
						String pt=(String)trainer1.getSelectedItem();
						//pstm.setBoolean(13,true);	
						System.out.println(pt);
						Icon infom=new ImageIcon("info.png");
						if(pt=="N/A")
						{	
							JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=Blue>Please select a trainer</font></html> ","Information",JOptionPane.INFORMATION_MESSAGE,infom);					
							trainer1.requestFocus();
						}
						
						else if(cell.getText().length()!=0)
						{
							if(cell.getText().length()>13 || cell.getText().length()<10)
							{
								System.out.println("celll pfone val");

								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Invalid mobile number.</font></html> ","Error",JOptionPane.ERROR_MESSAGE,error);
							}
							else
								updfunc();
			
						}
						else
							updfunc();						
					}
					else
							updfunc();

					
					 
			
				}
							
				
				else
				{
					updfunc();
				}
				
				 
				
				
		}//relaod ends



		if(ae.getSource()==srch)
		{

		
		String condition=(String)search_cmb.getSelectedItem();
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
		//Statement st=con.createStatement();
		PreparedStatement prs=null;
		ResultSet set=null;
		String searchfor=search1.getText();
		
		if(condition=="Full Name")
		{
			
			String pass_id="";
			prs=con.prepareStatement("select * from members where name=?");
			prs.setString(1,searchfor);
			//prs.executeQuery();
			
			
		}
		else
		{	
			
			prs=con.prepareStatement("select * from members where mid=?");
			prs.setString(1,searchfor);
			
		}
		 set=prs.executeQuery();
		if(set.next())
			{
			do
			{
				String pass_id="";
				showRecord(set);
			//	System.out.println("hello hw r u?");
				//while(set.next())
				
				 pass_id=reg.getText();
				 System.out.println("hello"+pass_id);
				
			showRecord(set);

								ns.setEmptySusp();
					mp.pnamecombo.removeAllItems();
					mp.setEmptyMemp();
					pay.listModel_progname.removeAllElements();
					pay.setEmpty();
					mp.setDisabMemp();
					
					
					
					pay.repaint();




			em.setValueEmp(pass_id);
			ns.setValueSusp(pass_id);
			mp.setValueMemp(pass_id);
			pay.setValuePay(pass_id);
			}while(set.next());
			}
			else
			{
			Icon error=new ImageIcon("error.png");
			JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>No Match Found</font></html>","Message",JOptionPane.ERROR_MESSAGE,error);
			
			


			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}		
	

		

		
		
			if(ae.getSource()==epat)	
			{

				eatingpattern ep=new eatingpattern();
				ep.setTitle("Eating Pattern");	
				SwingUtilities.updateComponentTreeUI(ep);	
				ep.setVisible(true);
			}
			if(ae.getSource()==hqst)	
			{

				health_quest hquest=new health_quest();
				hquest.setTitle("Health Questionnare");
				SwingUtilities.updateComponentTreeUI(hquest);	
				hquest.setVisible(true);
			}
			if(ae.getSource()==shift)	
			{

				shiftrep shiftr=new shiftrep();
				shiftr.setTitle("Employee Shifts");
				SwingUtilities.updateComponentTreeUI(shiftr);	
				shiftr.setVisible(true);
			}
			if(ae.getSource()==suspo)	
			{

				suspenover suspov=new suspenover();
				suspov.setTitle("Customer Suspension Report");
				SwingUtilities.updateComponentTreeUI(suspov);	
				suspov.setVisible(true);
			}
			
			if(ae.getSource()==nutri)	
			{

				nutriAppt na=new nutriAppt();
				na.setTitle("Nutritionist Appointment");
				SwingUtilities.updateComponentTreeUI(na);	
				na.setVisible(true);
			}
			if(ae.getSource()==cftr)	
			{

				cftAppt ca=new cftAppt();
				ca.setTitle("Fitness Test Reminders");
				SwingUtilities.updateComponentTreeUI(ca);	
				ca.setVisible(true);
			}
			if(ae.getSource()==msg)	
			{

				mssgAppt ma=new mssgAppt();
				ma.setTitle("Massage Appointments");
				SwingUtilities.updateComponentTreeUI(ma);	
				ma.setVisible(true);
			}

		if(ae.getSource()==bday)	
		{

			bdayremind bdayr=new bdayremind();
			bdayr.setTitle("Birthday Reminders");
			SwingUtilities.updateComponentTreeUI(bdayr);	
			bdayr.setVisible(true);
		}
			if(ae.getSource()==duedate)	
			{

				duedate ddate=new duedate();
				ddate.setTitle("Payment Due Dates");
				SwingUtilities.updateComponentTreeUI(ddate);	
				ddate.setVisible(true);
			}

		if(ae.getSource()==manual)	
		{
			try
			{
			//Desktop.open(new File("manual.pdf"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}			

		}
		if(ae.getSource()==calc_b)	
		{

			calorie2 cal2=new calorie2();	
			cal2.setTitle("Calorie Counter");
			SwingUtilities.updateComponentTreeUI(cal2);	
			cal2.setVisible(true);
		}
		if(ae.getSource()==passconf)	
		{

			pass ps=new pass();
			ps.setTitle("Change Password");
			SwingUtilities.updateComponentTreeUI(ps);	
			ps.setVisible(true);
		}
		if(ae.getSource()==repconf)	
		{

			repass reps=new repass();
			reps.setTitle("Change Report Password");
			SwingUtilities.updateComponentTreeUI(reps);	
			reps.setVisible(true);
		}

		if(ae.getSource()==pbhol)	
		{
			holiday2 hol=new holiday2();
			hol.setTitle("Public Holidays");
			SwingUtilities.updateComponentTreeUI(hol);
			hol.setVisible(true);

		}
		if(ae.getSource()==proconf)	
		{
			prog_config1 pf=new prog_config1();
			pf.setTitle("Programme Configuration");
			SwingUtilities.updateComponentTreeUI(pf);
			pf.setVisible(true);

		}

		if(ae.getSource()==empl)	
		{
			emp_fin ef=new emp_fin();
			ef.setTitle("Employee Details");
			SwingUtilities.updateComponentTreeUI(ef);
			ef.setVisible(true);

		}
		if(ae.getSource()==excard)	
		{
			excer_fin exf=new excer_fin();
			exf.setTitle("Excercise Card");
			SwingUtilities.updateComponentTreeUI(exf);
			exf.setVisible(true);

		}
		if(ae.getSource()==msr)	
		{
			measure ms=new measure();
			ms.setTitle("Member Measurements");
			SwingUtilities.updateComponentTreeUI(ms);
			ms.setVisible(true);

		}
		if(ae.getSource()==msrmt)	
		{
			measure ms=new measure();
			ms.setTitle("Member Measurements");
			SwingUtilities.updateComponentTreeUI(ms);
			ms.setVisible(true);

		}
		if(ae.getSource()==genconf)	
		{ 
			general_config genconfig=new general_config();
			genconfig.setTitle("General Configuration");
			SwingUtilities.updateComponentTreeUI(genconfig);
			genconfig.setVisible(true);

		}
		if(ae.getSource()==cmp)	
		{
			complaint2 comp=new complaint2();
			comp.setTitle("Complaints");
			SwingUtilities.updateComponentTreeUI(comp);
			comp.setVisible(true);

		}
		if(ae.getSource()==appt)	
		{
			appoint app=new appoint();
			app.setTitle("Appointments");
			SwingUtilities.updateComponentTreeUI(app);
			app.setVisible(true);

		}
		if(ae.getSource()==cft)	
		{
			fitnesstemp ft=new fitnesstemp();
			ft.setTitle("Fitness Test");
			SwingUtilities.updateComponentTreeUI(ft);
			ft.setVisible(true);

		}	
		if(ae.getSource()==qt)	
		{
			System.exit(0);
		}
	
			
	}	
	

	ChangeListener changeListener = new ChangeListener()
	 {
		    public void stateChanged(ChangeEvent changeEvent) {
			JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
						
	        int index = sourceTabbedPane.getSelectedIndex();
			int i=jtp.getSelectedIndex();

				 
			 if(i==0)
			 {
				em.repaint();
			 }	
			if(i==1)
			 {
				ns.repaint();
			 }
			if(i==2)
			 {
				mp.repaint();
					mp.pnamecombo.removeAllItems();
					mp.setValueMemp(reg.getText());
					mp.setDisabMemp();

			 }
			 if(i==3)
			 {
				pay.repaint();
					//pay.listModel_progname.removeAllElements();
				
					//pay.setValuePay(reg.getText());
										pay.listModel_progname.removeAllElements();
					pay.setEmpty();
					pay.setValuePay(reg.getText());


			 }
      }
    };

	public void updfunc()
	{
		System.out.println("inside updfunc");	
		try
			{
				
				PreparedStatement pstm;
			
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");	
				
			
				java.util.Date dob_ch = (java.util.Date)datefield.getValue();
				java.sql.Date sqlDate = new java.sql.Date(dob_ch.getTime());
			//	System.out.println(dob_ch);				
				
				
				pstm=con.prepareStatement("update members set name=?,dob=?,email=?,gender=?,home_phone=?,cell_phone=?,notes=?,address=?,suburb=?,pin_no=?,occup=?,pers_train=?,pers_cmb=? where mid=?");			

				
				pstm.setString(1,first.getText());
				pstm.setDate(2,sqlDate);
				pstm.setString(3,emailid.getText());
				if(male.isSelected())
				{
					pstm.setString(4,"male");
				}
				else
				{
					pstm.setString(4,"female");
				}
				
				pstm.setString(5,home.getText());
				pstm.setString(6,cell.getText());				
				pstm.setString(7,notes1.getText());
				pstm.setString(8,add1.getText());
				pstm.setString(9,sub1.getText());
				pstm.setString(10,pin.getText());
				pstm.setString(11,occu1.getText());
				if(train.isSelected())
				{
					pstm.setBoolean(12,true);
				}
				else
				{
					pstm.setBoolean(12,false);
					
				}
				String pt=(String)trainer1.getSelectedItem();				
				pstm.setString(13,pt);


				pstm.setString(14,reg.getText());

				int upd=pstm.executeUpdate();
			if(upd==1)
			{
			JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=green>Record successfully updated </font></html> ","Saved",JOptionPane.INFORMATION_MESSAGE,check);
			add_new.setEnabled(true);
			}
			else
			{Icon error=new ImageIcon("error.png");
			JOptionPane.showMessageDialog(main_form1.this,"<html><font size=4 color=red>Unable to update</font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
			}

		
	
			}
			catch(Exception e)
			{
				System.out.println("error in update "+e);
				
			}
	}
	public void setEmpty()
	{
					first.setText("");
				//	dob1.setText("");
					datefield.setValue(new java.util.Date());
					emailid.setText("");
					
					male.setSelected(true);				
					
					home.setText("");
					cell.setText("");
					notes1.setText("");
					add1.setText("");
					sub1.setText("");
					pin.setText("");
					occu1.setText("");
				
					if(train.isSelected())
					{
						
						trainer1.setEnabled(true);
					}
					
				//	owing_res.setText("");
					em.setEmptyEmp();
					ns.setEmptySusp();
					ns.name.setText("");
					mp.setEmptyMemp();
					pay.setEmpty();

					String set=reg.getText();
					System.out.println("setting "+set );
					em.txtmid.setText(set);
					ns.regid.setText(set);
					mp.txtid.setText(set);
					pay.mid.setText(set);
	}




	public void showRecord(ResultSet rs)
	{
		try
			{
				
					reg.setText(rs.getString(1));
					System.out.println(reg.getText());

					first.setText(rs.getString(2));
					
					java.util.Date date1=((java.util.Date)(rs.getDate(3)));					
					datefield.setValue(date1);

					emailid.setText(rs.getString(4));
					String sex;
					sex=rs.getString(5);
					if(sex.equals("male"))
					{
						male.setSelected(true);
					//	System.out.println("hello in male:");
					}
					else
					{
						
						fem.setSelected(true);
				//		System.out.println("hello in female:");
					}

					home.setText(rs.getString(6));
					cell.setText(rs.getString(7));
					notes1.setText(rs.getString(8));
					add1.setText(rs.getString(9));
					sub1.setText(rs.getString(10));
					pin.setText(rs.getString(11));
					occu1.setText(rs.getString(12));
					train.setSelected(rs.getBoolean(13));
					System.out.println("train:"+rs.getBoolean(13));
					trainer1.setSelectedItem(rs.getString(14));

					if(train.isSelected())
					{
						trainer1.setEnabled(true);
						trainer1.setSelectedItem(rs.getString(14));
					}
					else
					{
						trainer1.setEnabled(false);
						trainer1.setSelectedItem("N/A");
					}
					
			}
			catch(Exception e)
			{
				System.out.println("error in rec"+e);
			}
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		 

		 Object source = ie.getItemSelectable();
        if (source == train) 
		{
			 if (ie.getStateChange() == ie.SELECTED) 
				 {
				 trainer1.setEnabled(true);
				 }
				 else
				 {
			trainer1.setEnabled(false);
			trainer1.setSelectedItem("N/A");

				 }
		}
				String str=(String)search_cmb.getSelectedItem();
		if(str=="Member Id")
		{
			search1.setText("MEM");
		}
		else
		{
			search1.setText("");
		}

		
	}

	class login_rep extends JFrame implements ActionListener{
    JLabel user;
    JLabel pass;
    JTextField txtuser;
    JPasswordField pf;
    JButton loginf;
    Connection conn;
     Statement stat;
	ResultSet set;


    public login_rep() {
		super("Administrator Login");
        loginLayout1 customLayout = new loginLayout1();

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
				{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
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
					
					adm.setEnabled(true);
					repconf.setEnabled(true);
					help_b.setEnabled(true);
					locker_b.setEnabled(false);
					
				dispose();
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
			  dispose();
            }
        });
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
			{
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
					//main_form1 mform=new main_form1();
				//	System.out.print("true");
					//(mform.adm).setEnabled(true);
					adm.setEnabled(true);
					repconf.setEnabled(true);
					help_b.setEnabled(true);
					locker_b.setEnabled(false);
					
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




}

class membersLayout1 implements LayoutManager {

    public membersLayout1() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 1006 + insets.left + insets.right;
        dim.height = 375 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+32,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+32,176,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+80,112,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+80,176,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+128,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+128,176,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+168,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+168,176,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+208,112,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+208,80,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+208,80,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+248,112,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+248,176,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+248,112,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+248,200,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+296,112,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+296,592,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+32,112,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+32,200,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+80,112,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+80,200,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+128,112,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+128,200,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+168,112,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+168,200,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+208,112,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+208,96,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+656,insets.top+208,96,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+808,insets.top+144,184,104);}
    }
}


class loginLayout1 implements LayoutManager {

    public loginLayout1() {
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




