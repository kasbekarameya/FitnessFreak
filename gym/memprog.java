//package gym.com.freak;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Vector;
import java.util.*;
import javax.swing.SwingUtilities;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;
import javax.swing.JTable;

//import gym.com.valid.*;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;


public class memprog extends JApplet implements ActionListener{
   	java.util.Date choosed;
	java.sql.Date sqlDate;
	java.util.Date choosed1;
	java.sql.Date sqlDate1;
	java.util.Date choosed2;
	java.sql.Date sqlDate2;
	java.util.Date date2;

	Icon tick=new ImageIcon("Check_h.gif");

	JLabel pname;
    JLabel strtdate;
    JLabel enddate;
    public JComboBox pnamecombo;
    JLabel pprice;
    NumericTextField txtprice;
    JLabel mname;
    JTextField txtmem;
    JLabel period;
    JComboBox periodcombo;
    JPanel panel_1;
    JLabel label_1;
    public JTextField txtid;
    DateField cmbstart;
    JTextField txtend;
    //JButton add;
    JButton save;
    JButton del;
    JButton can;
	JButton gen;
	//ImageIcon new_mem,ca,de,sav;
	JTable table;
    public DefaultTableModel model;
	Connection con;
	float pr;

    public memprog() {
   /*   	new_mem=new ImageIcon("add.png");
       	sav=new ImageIcon("save.png");
       	de=new ImageIcon("trash.JPG");
       	ca=new ImageIcon("Delete_h.gif");*/

        memprogLayout customLayout = new memprogLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        pname = new JLabel("Programme Name");
        getContentPane().add(pname);

        strtdate = new JLabel("Start Date");
        getContentPane().add(strtdate);


        enddate = new JLabel("End Date");
        getContentPane().add(enddate);

		
        pnamecombo = new JComboBox();
		getContentPane().add(pnamecombo);
	//	pnamecombo.addItemListener(this);

        pprice = new JLabel("Programme Price");
        getContentPane().add(pprice);

        txtprice = new NumericTextField();
        getContentPane().add(txtprice);

        mname = new JLabel("Member Name");
        getContentPane().add(mname);

        txtmem = new JTextField("");
        getContentPane().add(txtmem);

        period = new JLabel("Period");
        getContentPane().add(period);

        periodcombo = new JComboBox();
		periodcombo.addItem("3 Months");
        periodcombo.addItem("6 Months");
        periodcombo.addItem("1 Year");
        getContentPane().add(periodcombo);

        panel_1 = new JPanel();
		 int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;		     
		int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
   		String col[] = {"Programme Name","Period","Price","Start date","End Date"};
		String data[][] = {{"","","","",""}};
		model=new DefaultTableModel(data,col);
		table=new JTable(model){
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);
 //	table.setAutoResizeMode(AUTO_RESIZE_OFF);
                    if (o != null)
                    {
                        return o.getClass();
                    }
                }
 
                return Object.class;
           }
	 public boolean isCellEditable(int rowIndex, int colIndex) {
        return false; }  //Disallow the editing of any cell
        };
	
	
		JScrollPane sp=new JScrollPane(table,vertical,horizontal);
		getContentPane().add(sp);
      
        label_1 = new JLabel("Member ID");
        getContentPane().add(label_1);

        txtid = new JTextField("");
    getContentPane().add(txtid);

       cmbstart = CalendarFactory.createDateField();
        getContentPane().add(cmbstart);


        txtend = new JTextField("");
        getContentPane().add(txtend);

      /* // add = new JButton(new_mem);
	    add = new JButton("Add");
		add.addActionListener(this);

        getContentPane().add(add);*/
		
       // save = new JButton(sav);
	    save = new JButton("Save");
		save.addActionListener(this);
        getContentPane().add(save);
		

        //del = new JButton(de);
		del = new JButton("Delete");
		del.addActionListener(this);
        getContentPane().add(del);
		

       // can = new JButton(ca);
	    can = new JButton("Clear");
		can.addActionListener(this);
        getContentPane().add(can);
		
ImageIcon cal=new ImageIcon("calculator.png");

		gen = new JButton(cal);
		
        getContentPane().add(gen);
		gen.addActionListener(this);

		
		txtend.setEnabled(false);
		
		txtid.setEnabled(false);
		
		txtmem.setEnabled(false);
		txtprice.setEnabled(false);
		can.setEnabled(true);
		save.setEnabled(false);

		del.setToolTipText("Deletes the record selected from the table");
		 save.setToolTipText("Save member's programme");
		// add.setToolTipText("Add a new programme");
		 can.setToolTipText("Clears all textfields");

	

        setSize(getPreferredSize());

		

     
    }

	 

	
		


		public void setValueMemp(String mid_get)
		{
		
			//	System.out.println("id in mem prog : "+mid_get);
				try
				{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
					con=DriverManager.getConnection("jdbc:odbc:emp2");
					Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					
					ResultSet res=st.executeQuery("select name from members where mid='"+mid_get+"'");
					
					if(res.next())
					{	
						do				
						{
					
							
							txtid.setText(mid_get);	
							txtmem.setText(res.getString(1));
							
			
				
						}while(res.next());
											
					}

					else
					{
						setEmptyMemp();
						txtid.setText(mid_get);
						txtmem.setText(res.getString(1));						
					}
					res.close();
					st.close();
					//con.close();
					
				}
					
				catch(Exception e)
      			{
					System.out.println("inside setvalmemp1");
					e.printStackTrace();
      			}

			/*	try
				{
		
					
					PreparedStatement psa=con.prepareStatement("select prog_name from mem_prog where mid=?");
					
					String s=txtid.getText();
				//	System.out.println("id in cmb prog is:"+s);
					psa.setString(1,s);
					
					ResultSet rsta=psa.executeQuery();
					
					
					while(rsta.next())
					{
					
						pnamecombo.addItem(rsta.getString(1));	
						
					}
					rsta.close();
					psa.close();
				}
				catch(Exception exa)
      			{
					System.out.println("inside setvalmemp2" +exa );
      			}
			*/
		addCombo();
				setSize(getPreferredSize());

				String strSQL="select prog_name,period,price,start_date,end_date from mem_prog where mid=?";
				createtab(strSQL);

/*	try
	{
		con.close();
	}catch(Exception e)
		{
		System.out.println("connection"+e);
		e.printStackTrace();
		}
*/

		}
	public void createtab(String strSQL)
	{
		Vector columnNames=new Vector();
 		Vector data=new Vector();
 		try {
 				String s=txtid.getText();
			//	System.out.println("string s is : "+s);
				PreparedStatement pre=con.prepareStatement(strSQL);

					pre.setString(1,s);
 					ResultSet resul=pre.executeQuery();
 					ResultSetMetaData md=resul.getMetaData();
					int columns=md.getColumnCount(); 
 					columnNames.addElement("Programme Name");
					columnNames.addElement("Period");
					columnNames.addElement("Price");
					columnNames.addElement("Start Date");
					columnNames.addElement("End Date");
 					
 					while(resul.next())
					{
 						
	 					Vector rowset=new Vector(columns);
 						for(int i=1;i<=columns;i++)
						{
 							rowset.addElement(resul.getObject(i));
							//model.setDataVector(rowset,column);
 						}
						data.addElement(rowset);
 						
 				     }
					model.setDataVector(data,columnNames);	
					resul.close();
					pre.close();
			}		   
			catch(Exception e)
			{
 				System.out.println("Exception in memprog: " + e);
 			}
    }
	public void addCombo()
	{
		try
		{
		String strSQL1="select prog_name from prog_config";
		//	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			Statement sa=con.createStatement();

			ResultSet rst=sa.executeQuery(strSQL1);
			while(rst.next())
			{
					
					pnamecombo.addItem(rst.getString(1));	

			}
			rst.close();
			sa.close();
		}
		catch(Exception ex)
      		{
		    System.out.println( ex );
      		}
	}


	public void setEmptyMemp()
	{
							
				
				txtmem.setText("");

				txtprice.setText("");
				txtend.setText("");		
								
				cmbstart.setValue(new java.util.Date());
				while (model.getRowCount()>0){
							model.removeRow(0);
								}


		
	}
	public void setDisabMemp()
	{
			
			txtend.setEnabled(false);
			txtprice.setEnabled(false);
			
			
			gen.setEnabled(true);
			save.setEnabled(false);
		//	del.setEnabled(true);
		//	add.setEnabled(true);
		//	can.setEnabled(false);		
		
	}
	 
public void actionPerformed(ActionEvent ae)
	{
	/*if(ae.getSource()==add)
	{
		txtprice.setText("");
		txtend.setText("");
	//	periodcombo.setSelectedItem("3 Months");
		
		del.setEnabled(false);
		cmbstart.setEnabled(true);
		txtprice.setEnabled(true);
		periodcombo.setEnabled(true);
		can.setEnabled(true);
		add.setEnabled(false);
		gen.setEnabled(true);
		pnamecombo.removeAllItems();
		try
		{
		String strSQL1="select prog_name from prog_config";
		//	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			Statement sa=con.createStatement();

			ResultSet rst=sa.executeQuery(strSQL1);
			while(rst.next())
			{
					
					pnamecombo.addItem(rst.getString(1));	

			}
			rst.close();
			sa.close();
		}
		catch(Exception ex)
      		{
		    System.out.println( ex );
      		}

	}*/
	if(ae.getSource()==gen)
	{
		
		choosed1 = (java.util.Date)cmbstart.getValue();	
//	System.out.println("date in choosed: "+choosed1);

	sqlDate1 = new java.sql.Date(choosed1.getTime());
//	System.out.println("date in sql:"+sqlDate1);

		
		String pnc=(String)pnamecombo.getSelectedItem();
					System.out.println("pnc"+pnc);

		String pc=(String)periodcombo.getSelectedItem();
//		System.out.println("value of pc is::"+pc);
	/*	if(pc.equals(""))
		{
			System.out.println("inside match");
			Icon error=new ImageIcon("error.png");
			JOptionPane.showMessageDialog(memprog.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please select a programme period","Error",JOptionPane.ERROR_MESSAGE,error);
		}*/
		String s="";
		try
		{
			//	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			//con=DriverManager.getConnection("jdbc:odbc:emp2");

			String strSQL1="select price from prog_config where prog_name=?";
			PreparedStatement p=con.prepareStatement(strSQL1);
			p.setString(1,pnc);
			
			ResultSet rstt=p.executeQuery();
			while(rstt.next()){
				s=rstt.getString(1);
		}
			System.out.println("s"+s);
			pr=Float.parseFloat(s);

		}
		catch(Exception e){System.out.println(e);
		e.printStackTrace();}
				
		if(pc.equals("3 Months"))
		{
			System.out.println(pc);
			calculateEnd(choosed1,90);
			float three=pr*3;
			System.out.println("price:"+three);
			txtprice.setText(String.valueOf(three));
		}
		if(pc.equals("6 Months"))
		{
			calculateEnd(choosed1,180);
			float six=pr*6;
			txtprice.setText(String.valueOf(six));
		}
		if(pc.equals("1 Year"))
		{
			calculateEnd(choosed1,365);
			float twelve=pr*11;
			txtprice.setText(String.valueOf(twelve));
		}
		save.setEnabled(true);
		
	}
	


	if(ae.getSource()==del)
	{
						int selected=table.getSelectedRow();
		java.util.Date sel=(java.util.Date)table.getValueAt(selected,3);
			
			sqlDate2 = new java.sql.Date(sel.getTime());    //start_date

		String sel2=(String)table.getValueAt(selected,0);  //prog_name
			System.out.println(sel);
			System.out.println(txtid.getText());
			String cho=sqlDate2.toString();
			int rowcount=table.getSelectedRowCount();
			if(selected==-1 || rowcount!=1)
			{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(memprog.this,"<html><font size=4 color=red>Choose a single record to delete.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else
			{
			try{
			
		
						

			 int response1 = JOptionPane.showConfirmDialog(memprog.this,
             "Are you sure you want to delete?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(response1) {
            case JOptionPane.YES_OPTION: 
			PreparedStatement psm=con.prepareStatement("delete * from mem_prog where mid=? and prog_name=? and start_date=?");
	
			psm.setString(1,txtid.getText());
			psm.setString(2,sel2);
			psm.setDate(3,sqlDate2);

			int del=psm.executeUpdate();
			if(del>=1)
			{
				model.removeRow(selected);
			Icon tick=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(memprog.this,"<html><font size=4 color=red>Deleted</font></html>","Message",JOptionPane.ERROR_MESSAGE,tick);
				txtprice.setText("");
				txtend.setText("");							
				cmbstart.setValue(new java.util.Date());
			
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
	
	if(ae.getSource()==save)
	{

	//	if(progname=&&)


	try
	{
	
	if(txtmem.getText().trim().equals(""))
	{ 
	
	Icon error=new ImageIcon("error.png");
	 JOptionPane.showMessageDialog(memprog.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
	}

		String pnc=(String)pnamecombo.getSelectedItem();
		String pc=(String)periodcombo.getSelectedItem();
			
		java.util.Date choosed2 = (java.util.Date)cmbstart.getValue();	
		java.sql.Date  sqlDate3 = new java.sql.Date(choosed2.getTime());
				
		if(txtprice.getText().trim().equals(""))
		{
				Icon error=new ImageIcon("error.png");

				 JOptionPane.showMessageDialog(memprog.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
		}
		else
		{
			SimpleDateFormat enddate=new SimpleDateFormat("dd/MM/yyyy");
			String en=txtend.getText();
			java.util.Date finalendate=enddate.parse(en);
			java.sql.Date sqlen=new java.sql.Date(finalendate.getTime());
	   PreparedStatement ps=con.prepareStatement("insert into mem_prog(mid,prog_name,start_date,end_date,price,period)values(?,?,?,?,?,?)");
			ps.setString(1,txtid.getText());
			ps.setString(2,pnc);
			ps.setDate(3,sqlDate3);
			ps.setDate(4,sqlen);
			ps.setString(5,txtprice.getText());
			String ma=txtprice.getText();
			ps.setString(6,pc);
			
	         int response = JOptionPane.showConfirmDialog(memprog.this,
             "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(response) {
            case JOptionPane.YES_OPTION: 
             int saved=ps.executeUpdate();
		
			//py.listModel_progname.addElement(pnc);
			
			//py.setValuePay(txtid.getText());
			//py.repaint();
			/*	payment py=new payment();
					py.listModel_progname.removeAllElements();
					py.repaint();
					py.setValuePay(txtid.getText());*/

			if(saved>=1)
			 {
			model.insertRow(table.getRowCount(),new Object[]{pnc,pc,ma,sqlDate3,sqlen});
			JOptionPane.showMessageDialog(memprog.this,"<html><font size=4 color=green>The Record has been Saved</font></html>","Message",JOptionPane.ERROR_MESSAGE,tick);

			save.setEnabled(false);
			del.setEnabled(true);
			gen.setEnabled(true);
			can.setEnabled(true);
				txtprice.setText("");
				txtend.setText("");							
				cmbstart.setValue(new java.util.Date());

			 }
			 else
				System.out.println("not saved in here");
               break;

            case JOptionPane.NO_OPTION: 
				show();
		 }   
		}
	}catch(Exception r) {	System.out.println("error"+r );	} 
		
	}

	


	if(ae.getSource()==can)
	{
		txtprice.setText("");
		txtend.setText("");
	
		save.setEnabled(false);
		del.setEnabled(true);
					cmbstart.setValue(new java.util.Date());
	
		

		
		txtprice.setEnabled(false);
		
	//	pnamecombo.removeAllItems();
	/*	try
		{
		
		//	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			PreparedStatement psaa=con.prepareStatement("select prog_name from mem_prog where mid=?");
			String s=txtid.getText();
			psaa.setString(1,s);
			ResultSet rstaa=psaa.executeQuery();
	//		System.out.println("cancel execution");
			while(rstaa.next())
			{
					
					pnamecombo.addItem(rstaa.getString(1));	

			}
			
		}
		catch(Exception exa)
      		{
		    System.out.println( exa );
      		}
		*/

	}
			
     } 
		public void calculateEnd(java.util.Date choosed1,int period)
		{
		
		try{
		
		//	System.out.println("date calculated");
			String r=addDaysToDate(choosed1,period);
			txtend.setText(r);

 
			
			}catch(Exception xe){}
		}
	/*public void itemStateChanged(ItemEvent ie)
	{
		 if (ie.getStateChange() == ie.SELECTED)
		 {
			 try
			{
			 	String str=(String)pnamecombo.getSelectedItem();
				PreparedStatement p=con.prepareStatement("select price from prog_config where prog_name=?");
				p.setString(1,str);
			

				ResultSet r=p.executeQuery();
				while(r.next())
				{
				
				txtprice.setText(r.getString(1));
				}
				r.close();
				p.close();
		 }catch(Exception n){System.out.println(n);}
	}
	}*/


	public String addDaysToDate(Date date_get, int daysToAdd)// throws Exception
	{
      
	 
	//  System.out.println("set");
	//  System.out.println("date_get is:"+date_get);	
      Calendar now = Calendar.getInstance();	

      now.setTime(date_get); 	
      now.add(Calendar.DAY_OF_MONTH, daysToAdd);
	
	  Date ob=now.getTime();

	  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	  String strDate = sdf.format(ob);
	//  System.out.println("set");
	  return strDate;

   }

   
	
	public static void main(String args[]) {
        memprog window = new memprog();
try {
          
    UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

	          
      }
       catch (Exception ex) {
            	ex.printStackTrace();
        	}

    
    }


}

/*	class NumericTextField extends JTextField
{

  
    public NumericTextField()
	{
		System.out.println("num");
	}
	public Document createDefaultModel()
    {
	
		return new NumericDocument();
    }

    public static class NumericDocument extends PlainDocument
    {
		// The regular expression to match input against (zero or more digits)
        public final static Pattern DIGITS = Pattern.compile("[0-9.]*");
		//  private final static Pattern DIGITS = Pattern.compile("\\d*");
		public final static Pattern POINT = Pattern.compile(".+\\.[0-9]+");
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
				JOptionPane.showMessageDialog(null,"Enter only numbers");
			}
		}
        
    }

}*/



/*
class memprogLayout implements LayoutManager {

    public memprogLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 529 + insets.left + insets.right;
        dim.height = 324 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+64,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+96,112,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+128,80,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+64,288,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+128,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+128,96,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+32,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+32,104,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+96,80,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+96,88,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+168,504,128);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+32,80,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+32,88,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+96,96,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+128,88,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+0,56,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+0,64,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+0,64,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+0,64,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+96,64,24);}
    }
}

class memprogLayout implements LayoutManager {

    public memprogLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 534 + insets.left + insets.right;
        dim.height = 312 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+64,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+96,112,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+128,80,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+64,288,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+128,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+128,96,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+32,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+32,104,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+96,80,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+96,88,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+168,504,128);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+32,80,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+32,88,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+96,96,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+128,88,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+0,64,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+0,64,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+0,64,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+96,64,24);}
    }
}
*/
class memprogLayout implements LayoutManager {

    public memprogLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 534 + insets.left + insets.right;
        dim.height = 312 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+64,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+96,112,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+128,80,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+64,288,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+128,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+128,96,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+32,96,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+32,104,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+96,80,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+96,88,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+168,504,128);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+32,104,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+32,72,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+96,96,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+128,88,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+0,64,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+0,64,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+0,64,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+96,32,24);}
    }
}