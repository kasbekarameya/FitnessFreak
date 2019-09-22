//package gym.com.freak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
//import javax.swing.JTable.*;
import javax.swing.SwingUtilities;
//import gym.com.valid.*;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.util.regex.Pattern;




//textfield.requestFocus() 
public class prog_config1 extends JFrame implements ActionListener{
    JLabel progname;
    JLabel abbcode;
    JTextField code;
    NumericTextField price;
    NumericTextField1 max;
    NumericTextField1 min;
    AlphaTextField name;
    JLabel progprice;
    JLabel minage;
    JLabel maxage;
    JPanel panel_1;  //used for placing table but not used newhere
    JPanel panel;
    JTable table;
    DefaultTableModel model;
    Connection con;
    Statement st;
    Statement st1;
    ResultSet rs;
    ResultSet rs1;
    JButton add,upd,del,save,can;
    PreparedStatement pstm,pstm1;
	String nm;
	String sql1;
    public prog_config1() {

	ImageIcon new_mem,up,de,sav,ca;
    	
   	 JToolBar bar;
	bar=new JToolBar();
	bar.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
    new_mem=new ImageIcon("add.png");
    sav=new ImageIcon("save.png");
    up=new ImageIcon("Load.png");
   	de=new ImageIcon("dust2.png");
	ca=new ImageIcon("close.png");
    

	add=new JButton(new_mem);
     upd=new JButton(up);
     del=new JButton(de);
	save=new JButton(sav);
	can=new JButton(ca);

	save.setEnabled(false);
		del.addActionListener(this);
		can.addActionListener(this);
		add.addActionListener(this);
		upd.addActionListener(this);
		save.addActionListener(this);


       	 bar.add(add);
       	 bar.add(save);
       	 bar.add(upd);
       	 bar.add(del);
       	 bar.add(can);
		 add.setToolTipText("Add a new Programme");
		 save.setToolTipText("Save Progamme");
		del.setToolTipText("Delete selected Programme");
		upd.setToolTipText("Update selected Programme");
		 can.setToolTipText("Cancel");
		can.setEnabled(false);
       getContentPane().add(bar,BorderLayout.NORTH);

	panel=new JPanel();

        prog_configLayout customLayout = new prog_configLayout();

        panel.setFont(new Font("Helvetica", Font.PLAIN, 12));
        panel.setLayout(customLayout);

        progname = new JLabel("Programme Name");
        panel.add(progname);

        abbcode = new JLabel("Abbreviated Code");
        panel.add(abbcode);

		
        max = new NumericTextField1();
        panel.add(max);


        code = new JTextField("");
        panel.add(code);

		 progprice = new JLabel("Programme Price");
        panel.add(progprice);


        price = new NumericTextField();
        panel.add(price);

		 minage = new JLabel("Minimum Age");
        panel.add(minage);


        min = new NumericTextField1();
        panel.add(min);

		 maxage = new JLabel("Maximum Age");
        panel.add(maxage);


        name = new AlphaTextField();
        panel.add(name);


    
 int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;		     
 int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
      	String col[] = {"Programme Name","Code","Price","Min Age","Max Age"};
		String data[][] = {{"","","","",""}};
		model=new DefaultTableModel(data,col);

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
		
		panel.add(sp);
        getContentPane().add(panel);
       
	table.addMouseListener(new TableHandler());

       	setUndecorated(true);
	getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

      sql1 = "Select prog_name,code,price,min_age,max_age from prog_config";
	createtab(sql1);

/*	try
	{

        rs=st.executeQuery("select prog_name,code,price,min_age,max_age from prog_config");
		while(rs.next())
		{
					
			name.setText(rs.getString(1));	
			code.setText(rs.getString(2));
			price.setText(rs.getString(3));
			min.setText(rs.getString(4));
			max.setText(rs.getString(5));
		}
	}
	catch(Exception e)
      	{
	    System.out.println( e );
      	}

     */

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
				name.setText("");
		min.setText("");
		max.setText("");
		price.setText("");
		code.setText("");
			add.setEnabled(true);
			upd.setEnabled(true);
			del.setEnabled(true);
			save.setEnabled(false);
			can.setEnabled(false);
			createtab(sql1);
            }
        });
    }

class TableHandler extends MouseAdapter
	{
    
	    public void mouseClicked(MouseEvent me)
	    {
			int ro=table.getSelectedRow();
			String sel=(String)table.getValueAt(ro,0);
			
			try
			{
	    			
	PreparedStatement pstm1=con.prepareStatement("select * from prog_config where prog_name=?");
				
				pstm1.setString(1,sel);
				ResultSet set=pstm1.executeQuery();
				while(set.next())
				{
				name.setText(set.getString(1));							
				code.setText(set.getString(2));
				price.setText(set.getString(3));
				min.setText(set.getString(4));
				max.setText(set.getString(5));

				}
				nm=name.getText();
				
			}
			catch(Exception ew)
			{
				System.out.println( "error---------->"+ew );
			}

		}
	}		//tablehandler over
		 public void createtab(String sql)
	{
		 try
        {
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			con=DriverManager.getConnection("jdbc:odbc:emp2");
 
			Vector data = new Vector();
		      Vector col = new Vector(5);
			col.add("Programme Name");
			col.add("Code");
			col.add("Price");
			col.add("Min Age");
			col.add("Max Age");

            st = con.createStatement();
            rs1 = st.executeQuery( sql );
            ResultSetMetaData md = rs1.getMetaData();
            int columns = md.getColumnCount();

            //  Get row data
 
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


		}
	    catch(Exception x)
        {
            System.out.println( x );
        }
	}
	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==add)
	{
		name.setText("");
		min.setText("");
		max.setText("");
		price.setText("");
		code.setText("");
		upd.setEnabled(false);
		del.setEnabled(false);
		add.setEnabled(false);
		save.setEnabled(true);
		can.setEnabled(true);

		int numrows = model.getRowCount();   
		for(int i = numrows - 1; i >=0; i--)   
		 {
			 model.removeRow(i);  
		 }				


		/*if(ae.getSource()==upd)
			JOptionPane.showMessageDialog(prog_config1.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\tCannot be updated","Error",JOptionPane.ERROR_MESSAGE);
		*/
	}

	if(ae.getSource()==save)
	{
		
	if(name.getText().trim().equals("") || code.getText().trim().equals("") || price.getText().trim().equals("") || min.getText().trim().equals("") || max.getText().trim().equals(""))
	{ 
		Icon error=new ImageIcon("error.png");
	 JOptionPane.showMessageDialog(prog_config1.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
	if(name.getText().trim().equals(""))
		name.requestFocus();
	if(code.getText().trim().equals(""))
		code.requestFocus();
	if(price.getText().trim().equals(""))
		price.requestFocus();
	if(min.getText().trim().equals(""))
		min.requestFocus();
	if(max.getText().trim().equals(""))
		max.requestFocus();
	}
	else
	{
		
	/*	int mi=Integer.parseInt(min.getText());
		if(mi<16||mi>35)
				

				 JOptionPane.showMessageDialog(prog_config1.this,"<html><font size=4 color=red>Incorrect Data </font></html> \n\t\tMinimum age should not be less than 16 or greater than 35 ","Error",JOptionPane.ERROR_MESSAGE);
		int ma=Integer.parseInt(max.getText());
		if(ma<16||ma>80)
				 JOptionPane.showMessageDialog(prog_config1.this,"<html><font size=4 color=red>Incorrect Data </font></html> \n\t\tMaximum age should not be less than 16 or greater than 80 ","Error",JOptionPane.ERROR_MESSAGE);
*/
			String pro=name.getText().toLowerCase();

			boolean b=false;
			
			try
			{
				Statement stu=con.createStatement();
				ResultSet rsu=stu.executeQuery("select * from prog_config");
			
				while(rsu.next())
				{

					
					if(pro.equals(rsu.getString(1)))
					{
						b=true;
						break;
					}
					else
					{
					
					b=false;
					}
				}//while over
				
			}
			catch(Exception e){ System.out.println(e); }
			if(b==true)
				{
					Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(prog_config1.this,"<html><font size=4 color=red>This programme already exists.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				System.out.println("exists");
				}
				else
				{

		try{
	     pstm=con.prepareStatement("insert into prog_config(prog_name,code,price,min_age,max_age)values(?,?,?,?,?)");
			pstm.setString(1,name.getText());
			String n=name.getText();
			pstm.setString(2,code.getText());
			String c=code.getText();
			pstm.setString(3,price.getText());
			String p=price.getText();
			pstm.setString(4,min.getText());
			String minn=min.getText();
			pstm.setString(5,max.getText());
			String maxx=max.getText();

			 int response4 = JOptionPane.showConfirmDialog(prog_config1.this,
             "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(response4)
		{
            case JOptionPane.YES_OPTION: 
			pstm.executeUpdate();  
			createtab(sql1);
			model.insertRow(table.getRowCount(),new Object[]{n,c,p,minn,maxx});

			Icon tick=new ImageIcon("Check_h.gif");
			 JOptionPane.showMessageDialog(prog_config1.this,"<html><font size=4 color=green>The Record has been Saved</font></html>","Message",JOptionPane.ERROR_MESSAGE,tick);
			
			add.setEnabled(true);
			upd.setEnabled(true);
			del.setEnabled(true);
			save.setEnabled(false);
			can.setEnabled(false);

			name.setText("");
			code.setText("");
			price.setText("");
			min.setText("");
			max.setText("");
			
			

               break;
            case JOptionPane.NO_OPTION: 
			//	createtab(sql1);
				show();
		 }   
		

			}catch(Exception r){System.out.println("error"+r );} 
				}
	}
	}
	if(ae.getSource()==upd)
	{
		int selected=table.getSelectedRow();
		int rowcount=table.getSelectedRowCount();
		if(selected==-1 || rowcount!=1)
		{
			Icon warn=new ImageIcon("error.png");
			JOptionPane.showMessageDialog(prog_config1.this,"<html><font size=4 color=red>Choose a single record to update.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
		}
		else
		{

	if(name.getText().trim().equals("") || code.getText().trim().equals("") || price.getText().trim().equals("") || min.getText().trim().equals("") || max.getText().trim().equals(""))
	{ 
		Icon error=new ImageIcon("error.png");
	 JOptionPane.showMessageDialog(prog_config1.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
	if(name.getText().trim().equals(""))
		name.requestFocus();
	if(code.getText().trim().equals(""))
		code.requestFocus();
	if(price.getText().trim().equals(""))
		price.requestFocus();
	if(min.getText().trim().equals(""))
		min.requestFocus();
	if(max.getText().trim().equals(""))
		max.requestFocus();
	}
	else
	{

		try
		{

			//System.out.println(sqlDate2);
			PreparedStatement pm=con.prepareStatement("update prog_config set prog_name=?,code=?,price=?,min_age=?,max_age=? where prog_name=?");
	
			pm.setString(1,name.getText());
			pm.setString(2,code.getText());
			pm.setString(3,price.getText());
			
			pm.setString(4,min.getText());
			pm.setString(5,max.getText());
			pm.setString(6,nm);		
			 int response1 = JOptionPane.showConfirmDialog(prog_config1.this,
             "Are you sure you want to update?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(response1)
		{
            case JOptionPane.YES_OPTION: 
             pm.executeUpdate();
				model.removeRow(selected);
			String n=name.getText();
			String c=code.getText();
			String p=price.getText();
			String minn=min.getText();
			String maxx=max.getText();
			name.setText("");
			code.setText("");
			price.setText("");
			min.setText("");
			max.setText("");



				model.insertRow(table.getRowCount(),new Object[]{n,c,p,minn,maxx});

						Icon tick=new ImageIcon("Check_h.gif");
	JOptionPane.showMessageDialog(prog_config1.this,"<html><font size=4 color=green>The Record has been updated</font></html>","Message",JOptionPane.ERROR_MESSAGE,tick);
			
               break;
            case JOptionPane.NO_OPTION: 
				show();
		 }   

		}catch(Exception r){System.out.println("error"+r );}
			}
	}
     } 
	if(ae.getSource()==del)
	{
			int selected=table.getSelectedRow();
			int rowcount=table.getSelectedRowCount();
			if(selected==-1 || rowcount!=1)
			{
				Icon warn=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(prog_config1.this,"<html><font size=4 color=red>Choose one record to delete.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else
			{

		try
		{

			PreparedStatement tpsm=con.prepareStatement("delete * from prog_config where prog_name=?");
	
			tpsm.setString(1,name.getText());

			 int response2 = JOptionPane.showConfirmDialog(prog_config1.this,
             "Are you sure you want to delete?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(response2) {
            case JOptionPane.YES_OPTION: 
             tpsm.executeUpdate();
			model.removeRow(selected);
			name.setText("");
			code.setText("");
			price.setText("");
			min.setText("");
			max.setText("");


				Icon tick=new ImageIcon("Check_h.gif");
	
			 JOptionPane.showMessageDialog(prog_config1.this,"<html><font size=4 color=green>The Record has been deleted</font></html>","Message",JOptionPane.ERROR_MESSAGE,tick);

               break;
            case JOptionPane.NO_OPTION: 
				show();
		 }   
			
		}catch(Exception r){System.out.println("error"+r );}
			}
	}
	if(ae.getSource()==can)
		{
			name.setText("");
			code.setText("");
			price.setText("");
			min.setText("");
			max.setText("");
			add.setEnabled(true);
			upd.setEnabled(true);
			del.setEnabled(true);
			save.setEnabled(false);
			can.setEnabled(false);
			createtab(sql1);


		}

	}
    public static void main(String args[]) {

		SwingUtilities.invokeLater(new Runnable()
        {
          
            public void run()
            {

        prog_config1 window = new prog_config1();
	try {
            // select Look and Feel
	  UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

	          
             }
             catch (Exception ex) {
            	ex.printStackTrace();
        	}
        window.setTitle("Programme Configuration");
        window.pack();
        window.show();
            }
        });
    }
}
/*
class prog_configLayout implements LayoutManager {

    public prog_configLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 560 + insets.left + insets.right;
        dim.height = 371 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+56,120,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+96,120,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+96,104,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+136,104,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+136,104,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+96,104,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+56,104,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+136,120,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+56,104,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+288,insets.top+96,120,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+288,insets.top+136,120,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+288,insets.top+56,120,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+176,488,176);}
    }
}
*/
class prog_configLayout implements LayoutManager {

    public prog_configLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 560 + insets.left + insets.right;
        dim.height = 371 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+56,120,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+96,120,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+96,104,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+96,104,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+136,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+136,104,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+56,120,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+56,104,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+96,120,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+56,104,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+176,488,176);}
    }
}
class AlphaTextField extends JTextField
{

  
    public Document createDefaultModel()
    {
        return new NumericDocument();
    }

    public class NumericDocument extends PlainDocument
    {
        // The regular expression to match input against (zero or more digits)
        private final Pattern DIGITS = Pattern.compile("[a-zA-Z,\\s,+]*");


        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
        {
            // Only insert the text if it matches the regular expression
           // if (str != null && DIGITS.matcher(str).matches())
 	if (str != null && DIGITS.matcher(str).matches())
                super.insertString(offs, str, a);
	else
		JOptionPane.showMessageDialog(getParent(),"Only alphabets allowed");
        }
    }
}