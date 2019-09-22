//package gym;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;

/*
import com.freak.emergency;
import com.freak.newsusp1;
import com.freak.memprog;
import com.freak.pass;	
import com.freak.eatingpattern;	
import com.freak.measure;	
import com.freak.excer_fin;
import com.freak.fitnesstemp;
import com.freak.Calculator;
import com.freak.curcust2;
import com.freak.holiday2;
import com.freak.diet.calorie2;
import com.freak.emp_fin;
import com.freak.complaint2;
import com.freak.health_quest;
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



class main_form extends JFrame implements ActionListener,ItemListener
{
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	

	static Connection con;
	static Statement st;
	static ResultSet rs;

	static emergency em=new emergency();
	static complaint2 comp=new complaint2();
	static newsusp1 ns=new newsusp1();
	static memprog mp=new memprog();
	//static payment pay=new payment();
	static pass ps=new pass();
	static eatingpattern ep=new eatingpattern();
	static holiday2 hol=new holiday2();
	static excer_fin exf=new excer_fin();
	static measure ms=new measure();
	static fitnesstemp ft=new fitnesstemp();
	static Calculator cl=new Calculator();
	static curcust2 cc=new curcust2();
	static calorie2 cal2=new calorie2();	
	static emp_fin ef=new emp_fin();
	static health_quest hquest=new health_quest();


	

	String id;
	JMenuBar mb;
	JMenu fitf,exercise,configur,reports,remind,health,help,admin_login;
	JMenuItem empl,cmp,qt;
	JMenuItem excard,cft,msr;
	JMenuItem pbhol,genconf,proconf,passconf;
	JMenuItem bday,duedate;
	JMenuItem epat,hqst,ccn,msrmt;
	JMenuItem abt,manual;
	ImageIcon new_mem,mail_img,con_i,dust,back,calc,save_img,b_save,b_add,b_close,b_first,b_last,b_next,b_previous,b_info,b_help,b_reload,b_refresh,h_add,h_save,h_del,h_refresh,b_can;
   	JButton add_new,mail_b,con1_i,dust_b,back_b,calc_b,save_b,save_bb,add_b,close_b,first_b,last_b,next_b,previous_b,info_b,help_b,reload_b,refresh_b,add_h,save_h,del_h,refresh_h,can_b;
   	JToolBar bar;

	JTextField reg;
	JTextField first;	
	JTextField emailid;
	NumericValid home;
	NumericValid cell;
	JTextField notes1;
	JTextField add1;
	StringValidCheck sub1;			
   	NumericValid pin;			
	JTextField occu1;
	NumericValid1 owing_res;
	DateField datefield;
	ButtonGroup bg;

	JRadioButton male;
	JRadioButton fem;
	JCheckBox train;
	JComboBox trainer1;
	JComboBox status1;

	JTextField search1;
	JTabbedPane jtp;
			
			
	JComboBox search_cmb;//28	

			
	JButton srch;

	
	public main_form()
	{
		
				
		//super("Fitness Freak");	
		em.repaint();
		
		
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

		qt =new JMenuItem("Quit");
		fitf.add(qt);
		qt.addActionListener(this);

		
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

		passconf=new JMenuItem("Change Password");
		passconf.addActionListener(this);
		configur.add(passconf);

		reports=new JMenu("Reports");
		mb.add(reports);

		remind=new JMenu("Reminders");
		mb.add(remind);

		bday=new JMenuItem("Birthday");
		remind.add(bday);
		bday.addActionListener(this);

		duedate=new JMenuItem("Payment Due Date");
		duedate.addActionListener(this);
		remind.add(duedate);



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

	/*	admin_login=new JMenu("Report Login");
		admin_login.addActionListener(this);
		mb.add(admin_login);*/

		help=new JMenu("Help");
		mb.add(help);
		manual=new JMenuItem("Fitness Freak Manual");
		help.add(manual);
		abt=new JMenuItem("About Fitness Freak");
		help.add(abt);

		


				bar=new JToolBar();
		bar.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
		
       		new_mem=new ImageIcon("add_reviewer.gif");
		calc=new ImageIcon("icon6.jpg");
		save_img=new ImageIcon("save.png");
		
		b_add=new ImageIcon("\\add.png");
		b_close=new ImageIcon("\\dust.png");
		b_last=new ImageIcon("\\last.png");
		b_next=new ImageIcon("\\next.png");
		b_first=new ImageIcon("\\first.png");
		b_previous=new ImageIcon("previous.png");
		b_info=new ImageIcon("info.png");
		b_reload=new ImageIcon("load.png");
		b_refresh=new ImageIcon("refresh.png");
		b_info=new ImageIcon("info.png");
		b_help=new ImageIcon("help.png");
		h_save=new ImageIcon("Save_h.gif");
		h_add=new ImageIcon("Add_h.gif");
		h_refresh=new ImageIcon("Refresh_h.gif");
		b_can=new ImageIcon("close.png");

		add_new=new JButton(new_mem);
		add_new.setToolTipText("Add a new member");
		add_new.addActionListener(this);

		save_b=new JButton(save_img);
		save_b.setToolTipText("Save the entered details");
		save_b.setEnabled(false);
		save_b.addActionListener(this);

		can_b=new JButton(b_can);
		can_b.setToolTipText("Cancel changes");
		can_b.setEnabled(false);
		can_b.addActionListener(this);

		first_b=new JButton(b_first);
		first_b.setToolTipText("View first record");
		first_b.addActionListener(this);	

		calc_b=new JButton(calc);
		calc_b.addActionListener(this);

		add_b=new JButton(b_add);

		add_b.addActionListener(this);

		//close_b=new JButton(b_close);
		//close_b.addActionListener(this);

		next_b=new JButton(b_next);
		next_b.setToolTipText("View next member");
		next_b.addActionListener(this);

		previous_b=new JButton(b_previous);
		previous_b.setToolTipText("View previous member");
		previous_b.addActionListener(this);

		last_b=new JButton(b_last);
		last_b.setToolTipText("Move to last record");
		last_b.addActionListener(this);

		close_b=new JButton(b_close);
		close_b.setToolTipText("Delete member");
		close_b.addActionListener(this);

		refresh_b=new JButton(b_refresh);
		refresh_b.setToolTipText("Refresh page");
		refresh_b.addActionListener(this);

		reload_b=new JButton(b_reload);
		reload_b.setToolTipText("Update current record");
		reload_b.addActionListener(this);

		info_b=new JButton(b_info);
		info_b.addActionListener(this);

		help_b=new JButton(b_help);
		
		refresh_h=new JButton(h_refresh);
		refresh_h.addActionListener(this);

		add_h=new JButton(h_add);
		add_h.addActionListener(this);

		del_h=new JButton(h_del);
		del_h.addActionListener(this);

		save_h=new JButton(h_save);
		save_h.addActionListener(this);



        bar.add(add_new);
		bar.add(save_b);
	
	
		//bar.add(add_b);
		bar.add(first_b);
		bar.add(previous_b);
		bar.add(next_b);
		bar.add(last_b);

		bar.add(close_b);
		bar.add(can_b);
		bar.add(refresh_b);
		bar.add(reload_b);
		bar.add(calc_b);
		bar.add(info_b);
		bar.add(help_b);
/*		bar.add(add_h);

		bar.add(save_h);
		bar.add(refresh_h);
		bar.add(del_h);*/
      	add(bar, BorderLayout.NORTH);
		
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
			JLabel owing;
			
			JLabel status;
			JLabel notes;
			//JLabel search;
			
     

		
    		membersLayout customLayout = new membersLayout();

			panel1.setFont(new Font("Helvetica", Font.PLAIN, 12));
      		panel1.setLayout(customLayout);
	

			reg_no = new JLabel("Registration No.");
	       	panel1.add(reg_no);
			reg = new JTextField("");
			reg.setEnabled(false);
        	panel1.add(reg);

			first_name = new JLabel("First Name");
      		panel1.add(first_name);
			first = new JTextField();
			first.setEnabled(false);
			panel1.add(first);

			  	
	
			dob = new JLabel("Date of Birth");
        	panel1.add(dob);
			datefield=CalendarFactory.createDateField();
			datefield.setEnabled(false);

			panel1.add(datefield);

	
			email = new JLabel("Email Id");
        	panel1.add(email);
			emailid = new JTextField("");
			emailid.setEnabled(false);
        	panel1.add(emailid);

			gender = new JLabel("Gender");
        	panel1.add(gender);

			bg = new ButtonGroup();
			male=new JRadioButton("male",true);
			male.setEnabled(false);
			fem=new JRadioButton("female");
			fem.setEnabled(false);

			bg.add(male);
			bg.add(fem);

			panel1.add(male);
			panel1.add(fem);//13


 			home_phone = new JLabel("Home Phone No.");
        	panel1.add(home_phone);
			home = new NumericValid();
			home.setEnabled(false);
       		panel1.add(home);      
        	

			cell_no = new JLabel("Cell No.");
        	panel1.add(cell_no);
			cell = new NumericValid();
			cell.setEnabled(false);
        	panel1.add(cell);

			notes = new JLabel("Notes");
      		panel1.add(notes);
			notes1 = new JTextField("");
			notes1.setEnabled(false);
        	panel1.add(notes1);

			address = new JLabel("Address");
       		panel1.add(address);
			add1 = new JTextField("");
			add1.setEnabled(false);
        	panel1.add(add1);
	

       		suburb = new JLabel("Surburb");
       		panel1.add(suburb);
			sub1= new StringValidCheck();
			sub1.setEnabled(false);
       		panel1.add(sub1);  //23

			pin_no = new JLabel("Pin No.");
        	panel1.add(pin_no);			     
       		pin = new NumericValid();
			pin.setEnabled(false);
			panel1.add(pin);	 
	
			occu = new JLabel("Occupation");
       		panel1.add(occu);
			occu1= new JTextField("");
			occu1.setEnabled(false);
			panel1.add(occu1); 

			trainer = new JLabel("Personal Trainer");
      		panel1.add(trainer);
			train=new JCheckBox("Booked");
			train.addItemListener(this);
			train.setEnabled(false);
			panel1.add(train);
			trainer1 = new JComboBox();
       		trainer1.addItem("George");
       		trainer1.addItem("Jhon");
		//	trainer1.addItemListener(this);
			trainer1.setEnabled(false);
      		panel1.add(trainer1);
	 
			
			owing = new JLabel("Owing");
      		panel1.add(owing);
			//String str=pay.owe.getText();
			//int owe_amt=Integer.parseInt(str);
			owing_res = new NumericValid1();
			owing_res.setEnabled(false);
			//int owe_amt=Integer.parseInt(str);
		//	System.out.println("owe_amt is: "+str);
		/*	if(str.equals(""))
			{
				owing_res.setText("0");
			}
			else
			{
				int owe_amt=Integer.parseInt(str);
			if(owe_amt>0)
			{
				owing_res.setForeground(Color.red);
			}
			else
			{
				owing_res.setForeground(Color.black);
			}
			}*/
      		panel1.add(owing_res);

			status = new JLabel("Status");
      		panel1.add(status);
			status1 = new JComboBox();
       		status1.addItem("active");
       		status1.addItem("suspended");
			status1.setEnabled(false);
      		panel1.add(status1); 

			
			
			panel3 = new JPanel();
			panel3.setLayout(new BorderLayout(20,6));
		//	search=new JLabel("Search");
		//	panel3.add(search);

			//panel3.setPreferredSize(new Dimension(80,190));

			search1=new JTextField(5);
			panel3.add(search1, BorderLayout.NORTH);

			search_cmb=new JComboBox();
			search_cmb.addItem("Name");
       		search_cmb.addItem("Id");
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
		  panLayout pan = new panLayout();
				
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
		jp1	.repaint();
		jp2.add(ns);
		jp3.add(mp);
	//	jp4.add(pay);

        
        jtp.addTab("emergency details", jp1);
		jtp.addTab("Suspension", jp2);
		jtp.addTab("Programme", jp3);
		//jtp.addTab("Payment", jp4);
	}

	

	public static void main( String args[] )
	{
		// Create an instance of the test application
		main_form mainFrame= new main_form();
		
		//mainFrame.setVisible( true );
		//mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

		try {
            			// select Look and Feel
	      	         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
				     SwingUtilities.updateComponentTreeUI(mainFrame);

	          
        		}
        	catch (Exception ex) {
            	//ex.printStackTrace();
				System.out.println(ex);
        	}

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
		mainFrame.showRecord(rs);
	//	String mid="0001";
		//int mid_no=Integer.parseInt(mid);
		em.setValueEmp("MEM0001");
		ns.setValueSusp("MEM0001");
		mp.setValueMemp("MEM0001");
		//pay.setValuePay("MEM0001");

	}
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==can_b)
		{	
			can_b.setEnabled(false);
			add_new.setEnabled(true);
			save_b.setEnabled(false);
			first.setEnabled(false);
			datefield.setEnabled(false);
			emailid.setEnabled(false);
			male.setEnabled(false);
			fem.setEnabled(false);
			home.setEnabled(false);
			cell.setEnabled(false);
			notes1.setEnabled(false);
			add1.setEnabled(false);
			sub1.setEnabled(false);
			pin.setEnabled(false);
			occu1.setEnabled(false);
			train.setEnabled(false);
			trainer1.setEnabled(false);
			status1.setEnabled(false);
			setEmpty();
		}
		if(ae.getSource()==add_new)
		{
			try
				{
					System.out.println("hola");
					DataInputStream sin=new DataInputStream(new FileInputStream("MCA_id.dat"));
					reg.setText(sin.readUTF());		
										

				}
				catch(Exception ex)
				{

				}

					first.setEnabled(true);
					datefield.setEnabled(true);
					emailid.setEnabled(true);
					male.setEnabled(true);
					fem.setEnabled(true);
					home.setEnabled(true);
					cell.setEnabled(true);
					notes1.setEnabled(true);
					add1.setEnabled(true);
					sub1.setEnabled(true);
					pin.setEnabled(true);
					occu1.setEnabled(true);
					train.setEnabled(true);
					trainer1.setEnabled(true);
					status1.setEnabled(true);

					save_b.setEnabled(true);
					add_new.setEnabled(false);
					can_b.setEnabled(true);

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
					
					owing_res.setText("");
					em.setEmptyEmp();
					ns.setEmptySusp();
					mp.setEmptyMemp();
					String set=reg.getText();
					System.out.println("setting "+set );
					em.txtmid.setText(set);
					ns.regid.setText(set);
					mp.txtid.setText(set);
				//pay.mid.setText(set);
					
		}
		if(ae.getSource()==save_b)
		{
			
			
			if(first.getText().trim().equals("")||home.getText().trim().equals("")||add1.getText().trim().equals("")||sub1.getText().trim().equals("")||pin.getText().trim().equals("")||occu1.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(main_form.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
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
			else
			{			



			try
			{
			con=DriverManager.getConnection("jdbc:odbc:emp2");
		
			PreparedStatement pstm=con.prepareStatement("insert into members(mid,name,dob,email,gender,home_phone,cell_phone,notes,address,suburb,pin_no,occup,pers_train,pers_cmb,status)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstm.setString(1,reg.getText());
			pstm.setString(2,first.getText());
			
				
			java.util.Date choosed = (java.util.Date)datefield.getValue();
			java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
				
				
			System.out.println("date in sql:"+sqlDate);
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
				pstm.setBoolean(13,true);
			}

			String pt=(String)trainer1.getSelectedItem();				
			pstm.setString(14,pt);

			String stat=(String)status1.getSelectedItem();				
			pstm.setString(15,stat);

			int response = JOptionPane.showConfirmDialog(main_form.this,
            "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
			switch(response) {
            case JOptionPane.YES_OPTION: 
            int upd=pstm.executeUpdate();
			Icon error=new ImageIcon("error.png");
			if(upd==1)
			{
			JOptionPane.showMessageDialog(main_form.this,"<html><font size=4 color=blue>Successfully saved </font></html> ","Saved",JOptionPane.INFORMATION_MESSAGE,error);
			add_new.setEnabled(true);
			}
			else
			{//Icon error=new ImageIcon("error.png");
			JOptionPane.showMessageDialog(main_form.this,"<html><font size=4 color=red>Unable to save</font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
			}
			//pstm.executeUpdate();
			
			DataInputStream dt=new DataInputStream(new FileInputStream("MCA_id.dat"));
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
							DataOutputStream out=new DataOutputStream(new FileOutputStream("MCA_id.dat"));
							out.writeUTF(temp2);
							dt.close();
							String set=reg.getText();
							System.out.println("setting "+set );
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
					 // first_b.setSelected(true);
		}
		}
		if(ae.getSource()==calc_b)
		{
			cal2.show();
		}
		if(ae.getSource()==empl)
		{
			
			
			ef.setVisible(true);
		}

		if(ae.getSource()==close_b)
		{
			try
			{

				System.out.println("helloooo in del in close");	
				
				con=DriverManager.getConnection("jdbc:odbc:emp2");
		
				
		//		String set=reg.getText();
		//		em.delValueEmp(set);
				
			int response1 = JOptionPane.showConfirmDialog(main_form.this,
             "Are you sure you want to delete?","Confirmation",JOptionPane.YES_NO_OPTION);
			 switch(response1)
			 {
				case JOptionPane.YES_OPTION: 
					//rs=st.executeQuery("Delete * from members where mid LIKE '"+reg.getText()+"'");
					//System.out.println("deleted");
					PreparedStatement pstm=con.prepareStatement("delete * from members where mid =?");
					pstm.setString(1,reg.getText());

					int upd=pstm.executeUpdate();
					setEmpty();
					Icon error=new ImageIcon("error.png");
					if(upd==1)
					{
						JOptionPane.showMessageDialog(main_form.this,"<html><font size=4 color=blue>Successfully deleted </font></html> ","Record Deleted",JOptionPane.INFORMATION_MESSAGE,error);
						add_new.setEnabled(true);
					}
					else
					{//Icon error=new ImageIcon("error.png");
						JOptionPane.showMessageDialog(main_form.this,"<html><font size=4 color=red>Error</font></html> \n\t\t Unable to delete","Error",JOptionPane.ERROR_MESSAGE,error);
					}
					

				break;
				case JOptionPane.NO_OPTION: 
				show();
			
			}   

				//rs=st.executeQuery("Delete * from members where mid LIKE '"+reg.getText()+"'");
				//rs.next();
				System.out.println("after del in main");	
				
			}catch(Exception e){}
		
			
		}

	/*	if(ae.getSource()==info_b)
		{	
				logrep.setVisible(true);
		}*/


		if(ae.getSource()==next_b)
		{
			
			
			try
			{
				if(rs.isAfterLast())
				{
					rs.first();

					System.out.println("helloooo in next after last");
					String res=rs.getString(1);
					System.out.println("id_st is in last:"+res);
	
					System.out.println("no is:"+res);
					em.setDisabEmp();
					em.setValueEmp(res);
					ns.setValueSusp(res);
					ns.setEmptySusp();
					mp.pnamecombo.removeAllItems();
					mp.setValueMemp(res);
					mp.setDisabMemp();
					//pay.listModel_progname.removeAllElements();
					//pay.setValuePay(res);
										
				}
				else
				{			
					rs.next();

					//String id_st=reg.getText();
					String id_st=rs.getString(1);
					System.out.println("id_st is in next:"+id_st);

				//	String sub=id_st.substring(3);

				//	System.out.println("substring is:"+sub);
			
				//	int id=Integer.parseInt(sub);
					//int no=id+1;
					//id++;
				//	String pass;
				//	pass="MEM000"+id;
				//	System.out.println("no is:"+pass);
					em.setDisabEmp();
					em.setValueEmp(id_st);
					ns.setValueSusp(id_st);
					ns.setEmptySusp();
					mp.pnamecombo.removeAllItems();
					mp.setValueMemp(id_st);
					mp.setDisabMemp();
					//pay.listModel_progname.removeAllElements();
				//	pay.setValuePay(id_st);
					
					
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

					System.out.println("helloooo in next after last");
					String res=rs.getString(1);
					System.out.println("id_st is in last:"+res);				
					em.setDisabEmp();
					em.setValueEmp(res);
					ns.setValueSusp(res);
					ns.setEmptySusp();
					mp.pnamecombo.removeAllItems();
					mp.setValueMemp(res);
					mp.setDisabMemp();
				//	pay.listModel_progname.removeAllElements();
				//	pay.setValuePay(res);
					
					
				}
				else
				{			
					rs.previous();

					System.out.println("helloooo in prev");
					//String id_st=reg.getText();
					String id_st=rs.getString(1);

					System.out.println("id_st is:"+id_st);

			
					String sub=id_st.substring(3);

					System.out.println("substring is:"+sub);
			
					int id=Integer.parseInt(sub);
					//int no=id+1;
					//id--;
					String pass;
					pass="MEM000"+id;
					System.out.println("no is:"+pass);
					em.setDisabEmp();
					em.setValueEmp(pass);
					ns.setValueSusp(pass);
					ns.setEmptySusp();
					mp.pnamecombo.removeAllItems();
					mp.setValueMemp(pass);
					mp.setDisabMemp();
				//	pay.listModel_progname.removeAllElements();
				//	pay.setValuePay(pass);
					
					
				}
			}catch(Exception e){}
			
			
			showRecord(rs);

		}
		if(ae.getSource()==last_b)
		{
			
			try
			{
				rs.last();			
			
				System.out.println("helloooo in last");
				String res=rs.getString(1);
				System.out.println("id_st is in last:"+res);

				System.out.println("no is:"+res);
				em.setDisabEmp();
				em.setValueEmp(res);
				ns.setValueSusp(res);
				ns.setEmptySusp();
				mp.setValueMemp(res);
				mp.setDisabMemp();
			//	pay.setValuePay(res);
			}catch(Exception e){}
			showRecord(rs);

		}
		if(ae.getSource()==first_b)
		{
			try
			{
				rs.first();

				System.out.println("helloooo in first");
				String res=rs.getString(1);
				System.out.println("id_st is in first:"+res);

				System.out.println("no is:"+res);
				em.setDisabEmp();
				em.setValueEmp(res);
				ns.setValueSusp(res);
				ns.setEmptySusp();
				mp.setValueMemp(res);
				mp.setDisabMemp();
				//pay.setValuePay(res);
			}catch(Exception e){}
			showRecord(rs);

			
		}
	
		if(ae.getSource()==reload_b)
		{
			try
			{
				
				PreparedStatement pstm;
			
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");	
				
			
				java.util.Date dob_ch = (java.util.Date)datefield.getValue();
				java.sql.Date sqlDate = new java.sql.Date(dob_ch.getTime());
				System.out.println(dob_ch);				
				
				
				pstm=con.prepareStatement("update members set name=?,dob=?,email=?,gender=?,home_phone=?,cell_phone=?,notes=?,address=?,suburb=?,pin_no=?,occup=?,pers_train=?,pers_cmb=?,status=? where mid=?");			

				
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
					pstm.setBoolean(12,true);
				}
				String pt=(String)trainer1.getSelectedItem();				
				pstm.setString(13,pt);

				String stat=(String)status1.getSelectedItem();				
				pstm.setString(14,stat);

				pstm.setString(15,reg.getText());
				int upd=pstm.executeUpdate();
				if(upd==1)
				System.out.println("row updated");
				else
				System.out.println("row not updated");

		
	
			}
			catch(Exception e)
			{
				System.out.println("error in update "+e);
				
			}
			
		}

		if(ae.getSource()==srch)
		{

			System.out.println("hello in srch ");
		String condition=(String)search_cmb.getSelectedItem();
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
		//Statement st=con.createStatement();
		PreparedStatement prs=null;
		Statement st=null;
		rs=null;
		String searchfor=search1.getText();
		//String sql=null;
		
		if(condition=="Name")
		{
			
			
			System.out.println("hello in name");
			
			String pass_id="";
			st=con.createStatement();
			rs=st.executeQuery("select * from members where name='"+searchfor+"'");
			while(rs.next())
			{
				pass_id=rs.getString(1);
			}
			System.out.println("id passed in name srch is:"+pass_id);
			
			em.setValueEmp(pass_id);
			ns.setValueSusp(pass_id);
			mp.setValueMemp(pass_id);
			//pay.setValuePay(pass_id);			

			prs=con.prepareStatement("select * from members where mid=?");
			prs.setString(1,pass_id);
		
			
		}
		else
		{	
			System.out.println("heloooooooooooo search in id is:"+searchfor);
			 prs=con.prepareStatement("select * from members where mid=?");
			prs.setString(1,searchfor);
			
			em.setValueEmp(searchfor);
			ns.setValueSusp(searchfor);
			mp.setValueMemp(searchfor);
		//	pay.setValuePay(searchfor);
		}
		ResultSet rs=prs.executeQuery();
		
		while(rs.next())
		{
			
					reg.setText(rs.getString(1));
					first.setText(rs.getString(2));
					
					java.util.Date date1=((java.util.Date)(rs.getDate(3)));					
					datefield.setValue(date1);

					emailid.setText(rs.getString(4));
					String sex;
					sex=rs.getString(5);
					if(sex=="male")
					{
						male.setSelected(true);
					}
					else
					{
						fem.setSelected(true);
					}
					System.out.println("sex is:"+sex);
					home.setText(rs.getString(6));
					cell.setText(rs.getString(7));
					notes1.setText(rs.getString(8));
					add1.setText(rs.getString(9));
					sub1.setText(rs.getString(10));
					pin.setText(rs.getString(11));
					occu1.setText(rs.getString(12));
					train.setSelected(rs.getBoolean(13));
					if(train.isSelected())
					{
						System.out.println("select kiya");	
						trainer1.setEnabled(true);
						trainer1.setSelectedItem(rs.getString(14));
					}
					else
					{
						trainer1.setEnabled(false);
					}
					status1.setSelectedItem(rs.getString(15));
					System.out.println("sarch found");
					
			
			}
			}
			catch(Exception e)
			{
			}
		}	
		
		

		
		
			if(ae.getSource()==epat)	
			{

			
				SwingUtilities.updateComponentTreeUI(ep);	
				ep.setVisible(true);
			}
			if(ae.getSource()==hqst)	
			{

			
				SwingUtilities.updateComponentTreeUI(hquest);	
				hquest.setVisible(true);
			}
		if(ae.getSource()==ccn)	
		{

			
			SwingUtilities.updateComponentTreeUI(cal2);	
			cal2.setVisible(true);
		}
		if(ae.getSource()==calc_b)	
		{

			
			SwingUtilities.updateComponentTreeUI(cal2);	
			cal2.setVisible(true);
		}
		if(ae.getSource()==passconf)	
		{

			
			SwingUtilities.updateComponentTreeUI(ps);	
			ps.setVisible(true);
		}
		if(ae.getSource()==pbhol)	
		{
			
			SwingUtilities.updateComponentTreeUI(hol);
			hol.setVisible(true);

		}
		if(ae.getSource()==empl)	
		{
			
			SwingUtilities.updateComponentTreeUI(ef);
			ef.setVisible(true);

		}
		if(ae.getSource()==excard)	
		{
			
			SwingUtilities.updateComponentTreeUI(exf);
			exf.setVisible(true);

		}
		if(ae.getSource()==msr)	
		{
			
			SwingUtilities.updateComponentTreeUI(ms);
			ms.setVisible(true);

		}
		if(ae.getSource()==msrmt)	
		{
			
			SwingUtilities.updateComponentTreeUI(ms);
			ms.setVisible(true);

		}
	/*	if(ae.getSource()==genconf)	
		{
			
			SwingUtilities.updateComponentTreeUI(gf);
			gf.setVisible(true);

		}*/
		if(ae.getSource()==cmp)	
		{
			
			SwingUtilities.updateComponentTreeUI(comp);
			comp.setVisible(true);

		}
		if(ae.getSource()==cft)	
		{
			
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
		    System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
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
			 }
			/* if(i==3)
			 {
				pay.repaint();
			 }*/
      }
    };
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
				/*
					if(train.isSelected())
					{
						
						trainer1.setEnabled(true);
					}
				*/	
					owing_res.setText("");
					em.setEmptyEmp();
					ns.setEmptySusp();
					mp.setEmptyMemp();
					String set=reg.getText();
					System.out.println("setting "+set );
					em.txtmid.setText(set);
					ns.regid.setText(set);
					mp.txtid.setText(set);

	}

	public void showRecord(ResultSet rs)
	{
		try
			{
				

				
					reg.setText(rs.getString(1));
					first.setText(rs.getString(2));
					
					java.util.Date date1=((java.util.Date)(rs.getDate(3)));					
					datefield.setValue(date1);

					emailid.setText(rs.getString(4));
					String sex;
					sex=rs.getString(5);
					if(sex.equals("male"))
					{
						male.setSelected(true);
						System.out.println("hello in male:");
					}
					else
					{
						
						fem.setSelected(true);
						System.out.println("hello in female:");
					}

					System.out.println("sex is:"+sex);
					home.setText(rs.getString(6));
					cell.setText(rs.getString(7));
					notes1.setText(rs.getString(8));
					add1.setText(rs.getString(9));
					sub1.setText(rs.getString(10));
					pin.setText(rs.getString(11));
					occu1.setText(rs.getString(12));
					train.setSelected(rs.getBoolean(13));
					if(train.isSelected())
					{
						trainer1.setEnabled(true);
						trainer1.setSelectedItem(rs.getString(14));
					}
					else
					{
						trainer1.setEnabled(false);
					}
					status1.setSelectedItem(rs.getString(15));
					
					
				
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
				 //nxtdue.setEnabled(true);
				 trainer1.setEnabled(true);
				//installtype.setEnabled(true);
				 }
				 else
				 {
			//	 nxtdue.setEnabled(false);
			//	installtype.setEnabled(false);
			trainer1.setEnabled(false);

				 }
		}
		
	}


}
class membersLayout implements LayoutManager {

    public membersLayout() {
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
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+24,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+24,176,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+64,112,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+64,176,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+104,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+104,176,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+144,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+144,176,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+184,112,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+184,80,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+184,80,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+224,112,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+224,176,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+264,112,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+264,176,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+304,112,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+304,176,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+24,112,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+24,200,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+64,112,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+64,200,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+104,112,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+104,200,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+144,112,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+144,200,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+184,112,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+184,96,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+656,insets.top+184,96,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+224,112,24);}
      /*  c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+224,200,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+264,112,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+552,insets.top+264,120,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+808,insets.top+144,184,104);}*/
    }
}





class panLayout implements LayoutManager {

    public panLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 657 + insets.left + insets.right;
        dim.height = 141 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+8,192,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+8,88,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+8,192,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+40,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+40,488,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+72,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+72,184,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+72,88,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+440,insets.top+72,184,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+104,112,24);}
        c = parent.getComponent(11);
  /*      if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+104,184,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+104,88,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+440,insets.top+104,184,24);}*/
    }
}





