//package gym.com.freak;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.math.*;
import java.awt.print.*;
import java.util.Date;
//import gym.com.valid.*;


public class fitnesstemp extends JFrame implements ActionListener,ItemListener{
    JLabel ymca;
    JLabel mainlabel;
    NumericTextField1 txtymca;
    JLabel sit;
    NumericTextField1 txtsit;
    JLabel flex;
    NumericTextField txtflex;
    JLabel rsymca;
    JLabel rssit;
    JLabel rsflex;
    JLabel pushup;
    NumericTextField txtabs;
    NumericTextField1 txtpushup;
    JLabel rspushup;
    JLabel abs;
    JLabel rsabs;
    JLabel squat;
    NumericTextField txtsquat;
    JLabel rssquat;
    JLabel plank;
    NumericTextField txtplank;
    JLabel rsplank;
    JLabel label_1;
    JLabel label_3;
    JLabel label_4;
    JLabel heartrate;
    NumericTextField txtbp;
	NumericTextField1 txtheart;
    JLabel bp;
    JButton calculate;
    JButton cancel;
    JButton print;
    JLabel unit;
    JLabel mid;
    JComboBox cmbmid;
    JLabel date;
 
    DateField datefield;
    JLabel name;
    JTextField txtname;
    JLabel rep1;
    JLabel rep2;
    JLabel inch;
    JLabel rep3;
    JLabel sec3;
    JLabel sec2;
    JLabel sec1;
    JButton show;
	JButton save;
	Connection con;
	PreparedStatement pstm;

    public fitnesstemp() {
        fitnessLayout customLayout = new fitnessLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ymca = new JLabel("Y.M.C.A STEP TEST");
        getContentPane().add(ymca);

        mainlabel = new JLabel("Fitness Test");
        getContentPane().add(mainlabel);

        txtymca = new NumericTextField1();
        getContentPane().add(txtymca);

        sit = new JLabel("SIT AND REACH TEST");
        getContentPane().add(sit);

        txtsit = new NumericTextField1();
        getContentPane().add(txtsit);

        flex = new JLabel("SHOULDER FLEXIBILITY");
        getContentPane().add(flex);

        txtflex = new NumericTextField();
        getContentPane().add(txtflex);

        rsymca = new JLabel("");
        getContentPane().add(rsymca);

        rssit = new JLabel("");
        getContentPane().add(rssit);

        rsflex = new JLabel("");
        getContentPane().add(rsflex);

        pushup = new JLabel("1 MIN PUSH UP TEST");
        getContentPane().add(pushup);

        txtabs = new NumericTextField();
        getContentPane().add(txtabs);

        txtpushup = new NumericTextField1();
        getContentPane().add(txtpushup);

        rspushup = new JLabel("");
        getContentPane().add(rspushup);

        abs = new JLabel("MODIEFIED AB HOLD");
        getContentPane().add(abs);

        rsabs = new JLabel("");
        getContentPane().add(rsabs);

        squat = new JLabel("WALL SQAUT");
        getContentPane().add(squat);

        txtsquat = new NumericTextField();
        getContentPane().add(txtsquat);

        rssquat = new JLabel("");
        getContentPane().add(rssquat);

        plank = new JLabel("PLANK TEST");
        getContentPane().add(plank);

        txtplank = new NumericTextField();
        getContentPane().add(txtplank);

        rsplank = new JLabel("");
        getContentPane().add(rsplank);

        label_1 = new JLabel("TEST");
        getContentPane().add(label_1);

        label_3 = new JLabel("SCORE");
        getContentPane().add(label_3);

        label_4 = new JLabel("CATEGORY");
        getContentPane().add(label_4);

        heartrate = new JLabel("Pre Excercise Heart Rate");
        getContentPane().add(heartrate);

        txtbp = new NumericTextField();
        getContentPane().add(txtbp);

        txtheart = new NumericTextField1();
        getContentPane().add(txtheart);

        bp = new JLabel("Blood Pressure");
        getContentPane().add(bp);



        calculate = new JButton("Calculate");
        getContentPane().add(calculate);
        calculate.addActionListener(this);
		calculate.setToolTipText("Click to evaluate performance");

        cancel = new JButton("Clear");
        getContentPane().add(cancel);
        cancel.addActionListener(this);
		cancel.setEnabled(true);
		cancel.setToolTipText("Clears all fields");

        print = new JButton("Print");
        getContentPane().add(print);
		print.addActionListener(this);
		print.setToolTipText("Prints fitness report");


        unit = new JLabel("mm/Hg");
        getContentPane().add(unit);

        mid = new JLabel("Membership Id");
        getContentPane().add(mid);

        cmbmid = new JComboBox();
        cmbmid.addItem("---Select---");
       // cmbmid.addItem("2");
        
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			con=DriverManager.getConnection("jdbc:odbc:emp2");
		//	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select mid from members");
			while(rs.next())
			{
					
					cmbmid.addItem(rs.getString(1));	

			}
			
		}
		catch(Exception e)
      		{
		    System.out.println( e );
      		}
		
		
		
		add(cmbmid);



        //getContentPane().add(cmbmid);
        cmbmid.addItemListener(this);

        date = new JLabel("Date");
        getContentPane().add(date);

       // textfield_1 = new NumericTextField;
       // getContentPane().add(textfield_1);

       datefield = CalendarFactory.createDateField();
        getContentPane().add(datefield);


        name = new JLabel("Name");
        getContentPane().add(name);

        txtname = new JTextField("");
        getContentPane().add(txtname);
        txtname.setEditable(false);

        rep1 = new JLabel("Reps");
        getContentPane().add(rep1);

        rep2 = new JLabel("Reps");
        getContentPane().add(rep2);

        inch = new JLabel("Inches");
        getContentPane().add(inch);

        rep3 = new JLabel("Reps");
        getContentPane().add(rep3);

        sec3 = new JLabel("Secs");
        getContentPane().add(sec3);

        sec2 = new JLabel("Secs");
        getContentPane().add(sec2);

        sec1 = new JLabel("Secs");
        getContentPane().add(sec1);

        show = new JButton("Show Record");
        getContentPane().add(show);
        show.addActionListener(this);
		show.setToolTipText("Displays previous record based on date chosen");

		save = new JButton("Save");
        getContentPane().add(save);
		save.addActionListener(this);
		save.setEnabled(false);
		save.setToolTipText("Saves record for later view");

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
        fitnesstemp window = new fitnesstemp();
	 try {
           
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);
           
        }
        catch (Exception ex) {
            //ex.printStackTrace();
        }
window.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        window.setTitle("Fitness");
        window.pack();
        window.show();
    }

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==save)
		{
		
		
		

			try
			{
			
				//int birthd=(int)choosed;	
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			con=DriverManager.getConnection("jdbc:odbc:emp2");
				pstm=con.prepareStatement("insert into fitness_test(mid,cftdate,heartrate,bp,step,sitnreach,flex,pushup,abhold,squat,plank)values(?,?,?,?,?,?,?,?,?,?,?)");


				String midchosen=(String)cmbmid.getSelectedItem();
				pstm.setString(1,midchosen);
				java.util.Date choosed = (java.util.Date)datefield.getValue();
				java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
				pstm.setDate(2,sqlDate);
				//pstm.setString(3,txtname.getText());
				pstm.setString(3,txtheart.getText());
				pstm.setString(4,txtbp.getText());
				pstm.setString(5,txtymca.getText());
				pstm.setString(6,txtsit.getText());
				pstm.setString(7,txtflex.getText());
				pstm.setString(8,txtpushup.getText());
				pstm.setString(9,txtabs.getText());
				pstm.setString(10,txtsquat.getText());
				pstm.setString(11,txtplank.getText());
				int saved=pstm.executeUpdate();
				if(saved==1)
				{
					System.out.println("saved");
					Icon tick=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(fitnesstemp.this,"<html><font size=4 color=green>Record Saved</font></html> ","Message",JOptionPane.ERROR_MESSAGE,tick);
			save.setEnabled(false);

				}
				else
				{
				}
				
			}
			catch(Exception e){

			System.out.println("error--------->"+e);	
			}
			
		}//save
		if(ae.getSource()==calculate)
		{
			String str=(String)cmbmid.getSelectedItem();
			if(str=="---Select---")
			{
					
					
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(fitnesstemp.this,"<html><font size=4 color=red>First choose a member to calculate result</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else if(txtymca.getText().trim().equals("")||txtsit.getText().trim().equals("")||txtflex.getText().trim().equals("")||txtabs.getText().trim().equals("")||txtpushup.getText().trim().equals("")||txtsquat.getText().trim().equals("")||txtplank.getText().trim().equals("")||txtbp.getText().trim().equals("")||txtheart.getText().trim().equals("")||txtname.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(fitnesstemp.this,"<html><font size=4 color=red>Please enter all fields </font></html>","Error",JOptionPane.ERROR_MESSAGE,error);
				if(txtymca.getText().trim().equals(""))
				txtymca.requestFocus();
				if(txtsit.getText().trim().equals(""))
				txtsit.requestFocus();
				if(txtflex.getText().trim().equals("")) 
				txtflex.requestFocus();
				if(txtabs.getText().trim().equals(""))
				txtabs.requestFocus();
				if(txtpushup.getText().trim().equals(""))
				txtpushup.requestFocus();
				if(txtsquat.getText().trim().equals(""))
				txtsquat.requestFocus();
				if(txtplank.getText().trim().equals(""))
				txtplank.requestFocus();
				if(txtbp.getText().trim().equals(""))
				txtbp.requestFocus();
				if(txtheart.getText().trim().equals(""))
				txtheart.requestFocus();
				
			}
			else
			{


			save.setEnabled(true);
			show.setEnabled(false);
			calmethod();

				}
			
		}
		if(ae.getSource()==print)
		{
			String str=(String)cmbmid.getSelectedItem();
			if(str=="---Select---")
			{
					
					
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(fitnesstemp.this,"<html><font size=4 color=red>First choose a member to print report.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else
			{
				PrinterJob jb=PrinterJob.getPrinterJob();
				jb.printDialog();
			}
		}

		if(ae.getSource()==cancel)
		{
			save.setEnabled(false);
			calculate.setEnabled(true);
			//cancel.setEnabled(false);
			cmbmid.setSelectedItem("---Select---");
			emptyAll();
		}
		
		if(ae.getSource()==show)
		{
			String str=(String)cmbmid.getSelectedItem();
			if(str=="---Select---")
			{
					
					
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(fitnesstemp.this,"<html><font size=4 color=red>First choose a member to view record.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else
			{
			calculate.setEnabled(false);
			save.setEnabled(false);
			try
			{
					
				PreparedStatement prs;
				String searchfor=(String)cmbmid.getSelectedItem();
				Date choosed = (Date) datefield.getValue();
				
				java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
				
				System.out.println(choosed);
				 prs=con.prepareStatement("select heartrate,bp,step,sitnreach,flex,pushup,abhold,squat,plank from fitness_test where mid=? and cftdate=?");
				prs.setString(1,searchfor);
				prs.setDate(2,sqlDate);
		
				ResultSet res=prs.executeQuery();
				if(res.next())
				{
		
				do
				{
				txtheart.setText(res.getString(1));
				txtbp.setText(res.getString(2));
				txtymca.setText(res.getString(3));
				txtsit.setText(res.getString(4));
				txtflex.setText(res.getString(5));
				txtpushup.setText(res.getString(6));
				txtabs.setText(res.getString(7));
				txtsquat.setText(res.getString(8));
				txtplank.setText(res.getString(9));
				}while(res.next());
				calmethod();
				}
				else
				{
					Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(fitnesstemp.this,"<html><font size=4 color=red>No record on this date</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			
				}
		
			}
			catch(Exception e)
			{
				System.out.print("sql--error==="+e);
			}
			}
			
			}	
		

	}//action event
		
	public void itemStateChanged(ItemEvent ie)
	{
		
		 
		 if (ie.getStateChange() == ie.SELECTED)
		 {
			emptyAll();
			show.setEnabled(true);
		String str=(String)cmbmid.getSelectedItem();
		if(str=="---Select---")
			 {
				emptyAll();
			 }

		


		try {
			PreparedStatement state=con.prepareStatement("SELECT name from members where mid=?");
			state.setString(1,str);
			ResultSet rst=state.executeQuery();
            while (rst.next())
			{
                  
				txtname.setText(rst.getString("name"));
					
             }
				
                  		
           		     }
			
		catch (Exception e)
		{
			System.out.println("error :"+e);
       	}
		}	
	}
	public void emptyAll()
{
	  txtymca.setText("");
	  txtsit.setText("");
	  txtflex.setText("");
	  txtabs.setText("");
      txtpushup.setText("");
	  txtsquat.setText("");
	  txtplank.setText("");
	  txtbp.setText("");
      txtheart.setText("");
	  txtname.setText("");
	  rspushup.setText("");
	  rsymca.setText("");
      rssit.setText("");
      rsflex.setText("");
      rssquat.setText("");
      rsplank.setText("");
	  rsabs.setText("");

}
public void calmethod()
	{
		cancel.setEnabled(true);
			//int stepcount=(int)txtymca.getText();
			float stepcount= Float.parseFloat(txtymca.getText());
			System.out.println(stepcount);
			
			if(stepcount>=79 && stepcount<=99)
			rsymca.setText("Good");
			else if(stepcount>=100 && stepcount<=116)
			rsymca.setText("Average");
			else
			rsymca.setText("Poor");

			float sit= Float.parseFloat(txtsit.getText());
			if(sit>=17 && sit<=20)
			rssit.setText("Good");
			else if(sit>=16 && sit<=13)
			rssit.setText("Average");
			else
			rssit.setText("Poor");

			float flexc= Float.parseFloat(txtflex.getText());
			if(flexc<=1 && flexc>=0)
			rsflex.setText("Poor");
			else if(flexc>=2 && flexc<=5)
			rsflex.setText("Good");
			else
			rsflex.setText("Excellent");

			float push= Float.parseFloat(txtpushup.getText());
			if(push>=0 && push<=17)
			rspushup.setText("Poor");
			else if(push>=18 && push<=30)
			rspushup.setText("Average");
			else
			rspushup.setText("Excellent");

			int ab= Integer.parseInt(txtabs.getText());
			if(ab>=180)
			rsabs.setText("Good");
			else if(ab>=60 && ab<180)
			rsabs.setText("Average");
			else
			rsabs.setText("Poor");
			
			int sqt= Integer.parseInt(txtsquat.getText());
			if(sqt>180)
			rssquat.setText("Good");
			else if(sqt>=60 && sqt<=180)
			rssquat.setText("Average");
			else
			rssquat.setText("Poor");

			int plk= Integer.parseInt(txtplank.getText());
			if(sqt>150)
			rsplank.setText("Good");
			else if(sqt>=60 && sqt<=150)
			rsplank.setText("Average");
			else
			rsplank.setText("Poor");
	}
}



/*
class fitnessLayout implements LayoutManager {

    public fitnessLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 626 + insets.left + insets.right;
        dim.height = 606 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+264,128,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+24,144,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+264,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+304,128,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+304,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+344,144,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+344,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+264,88,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+304,88,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+344,88,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+384,128,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+424,72,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+384,72,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+384,88,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+424,128,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+424,88,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+464,128,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+464,72,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+464,88,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+504,128,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+504,72,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+504,88,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+224,72,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+224,56,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+224,72,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+144,144,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+184,48,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+144,72,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+184,32,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+552,72,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+352,insets.top+552,80,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+552,88,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+184,72,24);}
        c = parent.getComponent(33);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+72,104,24);}
        c = parent.getComponent(34);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+72,88,24);}
        c = parent.getComponent(35);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+72,72,24);}
        c = parent.getComponent(36);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+72,72,24);}
        c = parent.getComponent(37);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+112,72,24);}
        c = parent.getComponent(38);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+112,72,24);}
        c = parent.getComponent(39);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+264,56,24);}
        c = parent.getComponent(40);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+304,56,24);}
        c = parent.getComponent(41);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+344,56,24);}
        c = parent.getComponent(42);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+384,56,24);}
        c = parent.getComponent(43);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+424,56,24);}
        c = parent.getComponent(44);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+464,56,24);}
        c = parent.getComponent(45);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+504,56,24);}
        c = parent.getComponent(46);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+552,120,24);}
        c = parent.getComponent(47);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+552,72,24);}
    }
}


class fitnessLayout implements LayoutManager {

    public fitnessLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 626 + insets.left + insets.right;
        dim.height = 606 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+264,128,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+24,144,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+264,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+304,128,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+304,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+344,144,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+344,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+264,88,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+304,88,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+344,88,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+384,128,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+424,72,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+384,72,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+384,88,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+424,128,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+424,88,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+464,128,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+464,72,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+464,88,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+504,128,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+504,72,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+504,88,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+224,72,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+224,56,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+224,72,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+144,144,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+184,48,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+144,72,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+184,32,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+552,72,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+304,insets.top+552,80,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+552,88,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+184,72,24);}
        c = parent.getComponent(33);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+72,104,24);}
        c = parent.getComponent(34);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+72,88,24);}
        c = parent.getComponent(35);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+72,72,24);}
        c = parent.getComponent(36);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+72,72,24);}
        c = parent.getComponent(37);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+112,72,24);}
        c = parent.getComponent(38);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+112,72,24);}
        c = parent.getComponent(39);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+264,56,24);}
        c = parent.getComponent(40);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+304,56,24);}
        c = parent.getComponent(41);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+344,56,24);}
        c = parent.getComponent(42);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+384,56,24);}
        c = parent.getComponent(43);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+424,56,24);}
        c = parent.getComponent(44);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+464,56,24);}
        c = parent.getComponent(45);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+504,56,24);}
        c = parent.getComponent(46);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+552,120,24);}
    }
}*/


class fitnessLayout implements LayoutManager {

    public fitnessLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 626 + insets.left + insets.right;
        dim.height = 606 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+264,128,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+24,144,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+264,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+304,128,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+304,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+344,144,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+344,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+264,88,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+304,88,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+344,88,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+384,128,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+424,72,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+384,72,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+384,88,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+424,128,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+424,88,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+464,128,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+464,72,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+464,88,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+504,128,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+504,72,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+504,88,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+224,72,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+224,56,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+224,72,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+144,144,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+176,88,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+144,72,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+176,104,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+552,72,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+352,insets.top+552,80,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+552,88,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+176,72,24);}
        c = parent.getComponent(33);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+72,104,24);}
        c = parent.getComponent(34);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+72,88,24);}
        c = parent.getComponent(35);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+72,72,24);}
        c = parent.getComponent(36);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+72,72,24);}
        c = parent.getComponent(37);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+112,72,24);}
        c = parent.getComponent(38);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+112,88,24);}
        c = parent.getComponent(39);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+264,56,24);}
        c = parent.getComponent(40);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+304,56,24);}
        c = parent.getComponent(41);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+344,56,24);}
        c = parent.getComponent(42);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+384,56,24);}
        c = parent.getComponent(43);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+424,56,24);}
        c = parent.getComponent(44);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+464,56,24);}
        c = parent.getComponent(45);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+504,56,24);}
        c = parent.getComponent(46);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+552,120,24);}
        c = parent.getComponent(47);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+552,72,24);}
    }
}
