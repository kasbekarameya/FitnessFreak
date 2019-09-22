//package gym.com.freak;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import javax.swing.JTable;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

//import gym.com.valid.*;

public class newsusp1 extends JApplet implements ActionListener
{
	java.util.Date choosed;
	java.sql.Date sqlDate;
	java.util.Date choosed1;
	java.sql.Date sqlDate1;
	java.util.Date choosed2;
	java.sql.Date sqlDate2;

	
    JLabel memid;
    public JTextField regid;
    JLabel memname;
     public JTextField name;
    JLabel suspend;
    NumericTextField1 per;
    JLabel stdate;
    JLabel endate;
    JTextField end;
    JLabel reas;
    JTextField reason;
    JLabel day;
    JLabel fee;
    NumericTextField fees;
    JPanel panel_1;
	JPanel panel;
	JButton gen;
    DateField start;


    JTable table;
    public DefaultTableModel model;
	Connection con;
    Statement state;
    Statement st,st1;
    ResultSet rs;
    ResultSet rs1;
	ResultSet result;
    JButton addb,save,del,next,can;
    PreparedStatement pstm;


    public newsusp1()
	{

		ImageIcon new_mem,de,nex,sav;
    	
		

		panel=new JPanel();
        newsuspendLayout customLayout = new newsuspendLayout();

        panel.setFont(new Font("Helvetica", Font.PLAIN, 12));
        panel.setLayout(customLayout);

        memid = new JLabel("Member ID");
        panel.add(memid);

        regid = new JTextField("");
		regid.setEnabled(false);
	
        panel.add(regid);

        memname = new JLabel("Member Name");
        panel.add(memname);

        name = new JTextField();
		name.setEnabled(false);
        panel.add(name);

        suspend = new JLabel("Suspension Period");
        panel.add(suspend);

        per = new NumericTextField1();
        panel.add(per);
		

        stdate = new JLabel("Start Date");
        panel.add(stdate);

        endate = new JLabel("End Date");
        panel.add(endate);

        end = new JTextField("");
        panel.add(end);
		end.setEnabled(false);

        reas = new JLabel("Reason");
        panel.add(reas);

        reason = new JTextField();
        panel.add(reason);


        day = new JLabel("( IN DAYS )");
        panel.add(day);

        fee = new JLabel(" Fees");
        panel.add(fee);

        fees = new NumericTextField();
        panel.add(fees);

		int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;		     
		int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
    	String col[] = {"Start Date","Period(In days)","End Date","Reason","Fees"};
		String data[][] = {{"","","","",""}};

		model=new DefaultTableModel(data,col);
		table=new JTable(model)
			  
	      {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);
                    if (o != null)
                    {
                        return o.getClass();
                    }
                }
 
                return Object.class;
           }
	 public boolean isCellEditable(int rowIndex, int colIndex) {
        return false; }  
        };
	
		JScrollPane sp=new JScrollPane(table,vertical,horizontal);
		
	
		panel.add(sp);
		

		start = CalendarFactory.createDateField();
        panel.add(start);
		start.setEnabled(true);

ImageIcon cal=new ImageIcon("calculator.png");
		gen=new JButton(cal);
		gen.setEnabled(true);
		gen.addActionListener(this);
		panel.add(gen);


		save=new JButton("Save");
		save.addActionListener(this);
		save.setEnabled(false);
		panel.add(save);
		save.setToolTipText("Saves the entered details");

		del=new JButton("Delete");
		del.addActionListener(this);
		panel.add(del);
		del.setToolTipText("Deletes the record selected from the table");

		can=new JButton("Clear");
		can.addActionListener(this);
		can.setEnabled(true);
		panel.add(can);
		can.setToolTipText("Clears all the textfields");

		start.setEnabled(true);

		per.setEnabled(true);
		reason.setEnabled(true);
		fees.setEnabled(true);

		getContentPane().add(panel);

		
		
	}

	  public void setValueSusp(String mid_get)
		{
		
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			con=DriverManager.getConnection("jdbc:odbc:emp2");
			state = con.createStatement();
			result=state.executeQuery("select * from members where mid='"+mid_get+"'");


			if(result.next())
			{	

				do
				{
					regid.setText(result.getString(1));
					name.setText(result.getString(2));
			
				}while(result.next());
			}
			else
			{
				setEmptySusp();
				regid.setText(mid_get);
			}
			result.close();
			state.close();
		}
		catch(Exception le)
      	{
			System.out.println("in setvalsusp");
		 le.printStackTrace();
      	}
        
    	
		String strSQL="select start_date,period,end_date,reason,fees from suspend where mid=?";
        createtab(strSQL);
		try{
			choosed = (java.util.Date)start.getValue();	
			sqlDate = new java.sql.Date(choosed.getTime());
			}catch(Exception se){	System.out.println( "error"+se );	}
		setSize(getPreferredSize());      
    }

	  public void createtab(String strSQL)
	  {
		 try
        {
 			Vector data = new Vector();
			 Vector col = new Vector(7);
	
			col.add("Start Date");
			col.add("Period (In days)");
			col.add("End Date");
			col.add("Reason");
			col.add("Fees");

			String s=regid.getText();
            PreparedStatement prest = con.prepareStatement(strSQL);
			prest.setString(1,s);
            rs1 = prest.executeQuery();

			ResultSetMetaData md = rs1.getMetaData();
            int columns = md.getColumnCount();
			
 
            while (rs1.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs1.getObject(i) );
                }
 
                data.addElement( row );
            }
				model.setDataVector(data,col);	
			rs1.close();
			prest.close();
		 }
		catch(Exception e)
		{
 				System.out.println("Exception in createtab: " + e);
 		}
			
	}

	public void setEmptySusp()
	{
							
				
				//name.setText("");

				end.setText("");
				per.setText("");
				reason.setText("");
				fees.setText("");
				start.setValue(new java.util.Date());
								while (model.getRowCount()>0){
							model.removeRow(0);
								}

		
	}

	public void actionPerformed(ActionEvent ae)
	{

	if(ae.getSource()==gen)
	{
		
		choosed1=(java.util.Date)start.getValue();
		sqlDate1 = new java.sql.Date(choosed1.getTime());
		if(per.getText().trim().equals(""))
		{
			Icon error=new ImageIcon("error.png");
			JOptionPane.showMessageDialog(newsusp1.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill in a suspension period","Error",JOptionPane.ERROR_MESSAGE,error);
		}
		else
		{
			int period=Integer.parseInt(per.getText());
			calculateEnd(choosed1,period);
			save.setEnabled(true);
		}
	}
	if(ae.getSource()==save)
	{
		choosed1=(java.util.Date)start.getValue();
		sqlDate1 = new java.sql.Date(choosed1.getTime());
	

	if(name.getText().trim().equals("") ||end.getText().trim().equals("") || per.getText().trim().equals("") || reason.getText().trim().equals("") || fees.getText().trim().equals(""))
	{ 
	
	Icon error=new ImageIcon("error.png");
	 JOptionPane.showMessageDialog(newsusp1.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
	 if(end.getText().trim().equals(""))
		end.requestFocus();
	if(per.getText().trim().equals(""))
		per.requestFocus();
	if(reason.getText().trim().equals(""))
		reason.requestFocus();
	if(fees.getText().trim().equals(""))
		fees.requestFocus();
	}
	
	else
	{
		try
		{
			
		java.util.Date choosed2 = (java.util.Date)start.getValue();	
		java.sql.Date sqlDate3 = new java.sql.Date(choosed2.getTime());

	     pstm=con.prepareStatement("insert into suspend(mid,period,start_date,end_date,reason,fees)values(?,?,?,?,?,?)");
		pstm.setString(1,regid.getText());
		pstm.setString(2,per.getText());
		String p=per.getText();	
		pstm.setDate(3,sqlDate3);
		pstm.setString(4,end.getText());
		String sqlDate1=end.getText();	
		pstm.setString(5,reason.getText());
		String r=reason.getText();
		pstm.setString(6,fees.getText());
		String f=fees.getText();
         int response = JOptionPane.showConfirmDialog(newsusp1.this,
             "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(response) {
            case JOptionPane.YES_OPTION: 
         
			 int sav=pstm.executeUpdate();
			 if(sav>=1)
			 {
			 Icon tick=new ImageIcon("Check_h.gif");
				model.insertRow(table.getRowCount(),new Object[]{sqlDate3,p,sqlDate1,r,f});
			 JOptionPane.showMessageDialog(newsusp1.this,"<html><font size=4 color=green>The Record has been Saved</font></html>","Message",JOptionPane.ERROR_MESSAGE,tick);
			save.setEnabled(false);
			gen.setEnabled(true);
				end.setText("");
				per.setText("");
				reason.setText("");
				fees.setText("");
				start.setValue(new java.util.Date());
			 }
			 else
				System.out.println("not saved");

               break;
            case JOptionPane.NO_OPTION: 
				show();
		 }   
			
			pstm.close();		//	System.out.println("inserting");
		}catch(Exception re){System.out.println("error"+re );} 
	}
	}
	if(ae.getSource()==del)
	{

		
			int selected=table.getSelectedRow();
			int rowcount=table.getSelectedRowCount();
			java.util.Date choosed4=(java.util.Date)start.getValue();
			java.sql.Date sqlDate2 = new java.sql.Date(choosed4.getTime());

			if(selected==-1 || rowcount!=1)
			{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(newsusp1.this,"<html><font size=4 color=red>Choose a single record to delete.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else
			{
			try{
			
		
						

			 int response1 = JOptionPane.showConfirmDialog(newsusp1.this,
             "Are you sure you want to delete?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(response1) {
            case JOptionPane.YES_OPTION: 
			PreparedStatement psm=con.prepareStatement("delete from suspend where mid=? and start_date=?");
	
			psm.setString(1,regid.getText());
			psm.setDate(2,sqlDate2);

			int del=psm.executeUpdate();
			model.removeRow(selected);
				end.setText("");
				per.setText("");
				reason.setText("");
				fees.setText("");
				start.setValue(new java.util.Date());

			if(del>=1)
			{
				System.out.print("not deleted");
			Icon tick=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(newsusp1.this,"<html><font size=4 color=red>Deleted</font></html>","Message",JOptionPane.ERROR_MESSAGE,tick);
			}	
			else
				System.out.print("not deleted");

			
			
			
               break;
            case JOptionPane.NO_OPTION: 
				show();

			}
			
			}
			catch(Exception e)
      	 	{
            			System.out.println("error"+e );
					
      		} 

			
			} 

     } 
	  if(ae.getSource()==can)
	{
		save.setEnabled(false);
		fees.setText("");
		per.setText("");
		end.setText("");
		reason.setText("");
		start.setValue(new java.util.Date());

	}

	}
	public void calculateEnd(java.util.Date choosed1,int period)
	{
		try{
				String r=addDaysToDate(choosed1,period);
				end.setText(r);
			
			}catch(Exception xe){System.out.println("calcEnd"+xe);}
	}	
    public static void main(String args[])
	{
        newsusp1 window = new newsusp1();
		try {
          
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);	          
			}
		    catch (Exception ex) {
							System.out.println("in main susp");

            ex.printStackTrace();
        	}
	         
    }

	public String addDaysToDate(Date date_get, int daysToAdd)// throws Exception
	{
      
	 
      Calendar now = Calendar.getInstance();	

      now.setTime(date_get); 	
      now.add(Calendar.DAY_OF_MONTH, daysToAdd);
	
	  Date ob=now.getTime();

	  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	  String strDate = sdf.format(ob);
	  return strDate;

   }
}




class newsuspendLayout implements LayoutManager {

    public newsuspendLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 595 + insets.left + insets.right;
        dim.height = 292 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+40,96,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+40,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+72,96,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+72,96,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+104,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+104,32,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+72,120,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+136,120,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+136,104,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+104,96,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+104,96,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+104,64,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+136,96,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+136,96,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+168,488,120);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+72,104,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+472,insets.top+104,24,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+0,72,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+0,72,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+0,72,24);}
    }
}



