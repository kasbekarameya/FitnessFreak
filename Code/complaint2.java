//package gym.com.freak;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.*;
import java.io.*;
//import gym.com.valid.*;

public class complaint2 extends JFrame implements ActionListener {
    JLabel label_1;
    JTextField txtcno;
    JLabel madeby;
    StringTextField txtmade;
    JLabel date;
    //JTextField textfield_3;
	DateField datefield;
    JCheckBox cmbstatus;
    JLabel label_5;
    JTextArea txtcomplain;
    JScrollPane sp_txtcomplain;
    JPanel panel_1;
    JButton add1;
    JButton save;
    JButton upd;
    JButton delete;
	JTable table;
    Connection con;
	DefaultTableModel model;
	JButton cancel;
	String sql;

    public complaint2() {
        complaintLayout customLayout = new complaintLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("Complaint No.");
        getContentPane().add(label_1);

        txtcno = new JTextField("");
        getContentPane().add(txtcno);
		txtcno.setEnabled(false);

        madeby = new JLabel("Made By");
        getContentPane().add(madeby);

        txtmade = new StringTextField();
        getContentPane().add(txtmade);

        date = new JLabel("Date");
        getContentPane().add(date);

		datefield = CalendarFactory.createDateField();
        getContentPane().add(datefield);


        cmbstatus = new JCheckBox("Status");
        getContentPane().add(cmbstatus);

        label_5 = new JLabel("Complaint");
        getContentPane().add(label_5);

        txtcomplain = new JTextArea("");
        sp_txtcomplain = new JScrollPane(txtcomplain);
        getContentPane().add(sp_txtcomplain);

		int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		  int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
   		String col[] = {"Complaint ID","Made By","Date","Complaint","Status"};
		String data[][] = {{"","","","",""}};
		model=new DefaultTableModel(data,col);
		table=new JTable(model)
			  
	      {
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

		table.addMouseListener(new TableHandler());
		JScrollPane sp=new JScrollPane(table,vertical,horizontal);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		getContentPane().add(sp);

        add1 = new JButton("Add");
        getContentPane().add(add1);
		add1.addActionListener(this);

        save = new JButton("Save");
        getContentPane().add(save);
		save.addActionListener(this);
		save.setEnabled(false);

        upd = new JButton("Update");
        getContentPane().add(upd);
		upd.addActionListener(this);

        delete = new JButton("Delete");
        getContentPane().add(delete);
		delete.addActionListener(this);

		cancel = new JButton("Cancel");
        getContentPane().add(cancel);
		cancel.addActionListener(this);
		cancel.setEnabled(false);

        setSize(new Dimension(600,550));
		setUndecorated(true);
       getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

            sql = "Select * from complaint";
		createtab(sql);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                txtcno.setText("");
                txtmade.setText("");
                txtcomplain.setText("");
				cmbstatus.setSelected(false);
				
				cancel.setEnabled(false);
				add1.setEnabled(true);
				upd.setEnabled(true);
				delete.setEnabled(true);
				save.setEnabled(false);
				createtab(sql);

            }
        });
    }
	class TableHandler extends MouseAdapter
	{
    
	    public void mouseClicked(MouseEvent me)
	    {
			int ro=table.getSelectedRow();
			String sel=(String)table.getValueAt(ro,0);
			//System.out.println(sel);
			try
			{
				
            	String driver = "sun.jdbc.odbc.JdbcOdbcDriver";

           		String url = "jdbc:odbc:emp2";
     			 Class.forName( driver );
            	Connection con = DriverManager.getConnection(url);
				PreparedStatement pstm=con.prepareStatement("select * from complaint where compid=?");
				pstm.setString(1,sel);
				ResultSet set=pstm.executeQuery();
				//System.out.println("hghghghgg");
				while(set.next())
				{
					txtcno.setText(set.getString(1));
					txtmade.setText(set.getString(2));
					java.util.Date date1=((java.util.Date)(set.getDate(3)));
					datefield.setValue(date1);
					txtcomplain.setText(set.getString(4));
					cmbstatus.setSelected(set.getBoolean(5));
				}
				
				set.close();
				pstm.close();
				con.close();
			}
			catch(Exception ew)
			{
				System.out.println( "error---------->"+ew );
			}

		}
	}

    public static void main(String args[]) {
        complaint2 window = new complaint2();
		try {
            
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        window.setTitle("complaint");
        window.pack();
        window.show();
    }
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add1)
		{
				cancel.setEnabled(true);
				save.setEnabled(true);
				add1.setEnabled(false);
				upd.setEnabled(false);
				delete.setEnabled(false);
			//	System.out.print("hooooooooaaaaa");
				try
				{
					DataInputStream sin=new DataInputStream(new FileInputStream("cmp.dat"));
					txtcno.setText(sin.readUTF());
				}
				catch(Exception ex)
				{
				}
				
				txtmade.setText("");
				txtcomplain.setText("");
				int numrows = model.getRowCount();   
				for(int i = numrows - 1; i >=0; i--)   
				 {
					 model.removeRow(i);  
				 }				
		}

		if(ae.getSource()==cancel)
		{
			cancel.setEnabled(false);
			add1.setEnabled(true);
			upd.setEnabled(true);
			delete.setEnabled(true);
			save.setEnabled(false);
			txtmade.setText("");
			txtcno.setText("");
			txtcomplain.setText("");
			createtab(sql);

			java.util.Date today = new java.util.Date();
             datefield.setValue(today);
		}


	if(ae.getSource()==save)
		{
			if(txtmade.getText().trim().equals("")||txtcomplain.getText().trim().equals(""))
			{
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(complaint2.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill in all the details","Error",JOptionPane.ERROR_MESSAGE,error);
				if(txtmade.getText().trim().equals(""))
				txtmade.requestFocus();
				if(txtcomplain.getText().trim().equals(""))
				txtcomplain.requestFocus();

			}
			else
			{
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			java.util.Date choosed = (java.util.Date)datefield.getValue();
			java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());		
			PreparedStatement pstm=con.prepareStatement("insert into complaint(compid,madeby,com_date,complain,status)values(?,?,?,?,?)");
			pstm.setString(1,txtcno.getText());
			pstm.setString(2,txtmade.getText());
			pstm.setDate(3,sqlDate);
			pstm.setString(4,txtcomplain.getText());
			if(cmbstatus.isSelected())
					pstm.setBoolean(5,true);
			else
					pstm.setBoolean(5,false);
	int resp = JOptionPane.showConfirmDialog(complaint2.this, "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(resp) {
            case JOptionPane.YES_OPTION: 
             pstm.executeUpdate();
			
			createtab(sql);
			if(cmbstatus.isSelected())
				model.insertRow(table.getRowCount(),new Object[]{txtcno.getText(),txtmade.getText(),sqlDate,txtcomplain.getText(),true});
			else
				model.insertRow(table.getRowCount(),new Object[]{txtcno.getText(),txtmade.getText(),sqlDate,txtcomplain.getText(),false});

			Icon check=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(complaint2.this,"<html><font size=4 color=green>Record Saved</font></html>","Save",JOptionPane.ERROR_MESSAGE,check);
			DataInputStream dt=new DataInputStream(new FileInputStream("cmp.dat"));
							String temp2=dt.readUTF();
							String coursename="CMP";
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
							DataOutputStream out=new DataOutputStream(new FileOutputStream("cmp.dat"));
							out.writeUTF(temp2);
							dt.close();

			java.util.Date today = new java.util.Date();
             datefield.setValue(today);

			upd.setEnabled(true);
			delete.setEnabled(true);
			save.setEnabled(false);
			add1.setEnabled(true);
			cancel.setEnabled(false);

			txtcno.setText("");
			txtmade.setText("");
			txtcomplain.setText("");
			cmbstatus.setSelected(false);


             break;
            case JOptionPane.NO_OPTION: 
			//	createtab(sql);
				pstm.close();
				con.close();
				show();
		 }
			}catch(Exception m){System.out.println( m );}
			}
		}

		if(ae.getSource()==delete)
		{

			int selected=table.getSelectedRow();
			int rowcount=table.getSelectedRowCount();
			if(selected==-1 || rowcount!=1)
			{
				Icon warn=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(complaint2.this,"<html><font size=4 color=red>Choose one record to delete.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else
			{
							int response1 = JOptionPane.showConfirmDialog(complaint2.this,
             "Are you sure you want to delete?","Confirmation",JOptionPane.YES_NO_OPTION);
			 switch(response1)
			 {
				case JOptionPane.YES_OPTION: 
			try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			PreparedStatement pstm=con.prepareStatement("delete from complaint where compid=?");
			
			pstm.setString(1,txtcno.getText());
			int del=pstm.executeUpdate();
		    model.removeRow(selected);

			if(del==1)
			{
			Icon tick=new ImageIcon("Check_h.gif");
				JOptionPane.showMessageDialog(complaint2.this,"<html><font size=4 color=red>Deleted</font></html>","Message",JOptionPane.ERROR_MESSAGE,tick);
			txtcno.setText("");
			txtmade.setText("");
			txtcomplain.setText("");
			cmbstatus.setSelected(false);
			}	
			else
				System.out.print("not deleted");
			pstm.close();
			con.close();
			}
			catch(Exception e)
      	 	{
            			System.out.println("error"+e );
					
      		} 

				break;
				case JOptionPane.NO_OPTION: 
				show();
			
			}   

			}
		}//if over

		if(ae.getSource()==upd)
		{
			int selected=table.getSelectedRow();
			int rowcount=table.getSelectedRowCount();
			if(selected==-1 || rowcount!=1)
			{
				Icon warn=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(complaint2.this,"<html><font size=4 color=red>Choose a single record to update.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else
			{
				if(txtmade.getText().trim().equals("")||txtcomplain.getText().trim().equals(""))
				{
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(complaint2.this,"<html><font size=4 color=red>Insufficient Data </font></html> \n\t\t Please fill in all the details","Error",JOptionPane.ERROR_MESSAGE,error);
				if(txtmade.getText().trim().equals(""))
				txtmade.requestFocus();
				if(txtcomplain.getText().trim().equals(""))
				txtcomplain.requestFocus();

				}
				else
				{

			int response1 = JOptionPane.showConfirmDialog(complaint2.this,
             "Are you sure you want to update?","Confirmation",JOptionPane.YES_NO_OPTION);
			 switch(response1)
			 {
				case JOptionPane.YES_OPTION: 
					try
					{
				
				PreparedStatement pstm;
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");	
				//Statement st=con.createStatement();
				String res=null;
				

				java.util.Date choosed = (java.util.Date)datefield.getValue();
				java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
				
				pstm=con.prepareStatement("update complaint set madeby=?,com_date=?,complain=?,status=? where compid=?");			

				
				pstm.setString(1,txtmade.getText());
				pstm.setDate(2,sqlDate);
				pstm.setString(3,txtcomplain.getText());
				if(cmbstatus.isSelected())
				{
					pstm.setBoolean(4,true);
				}
				else
				{
					pstm.setBoolean(4,false);
				}

				pstm.setString(5,txtcno.getText());
				
				
				int upd2=pstm.executeUpdate();
				model.removeRow(selected);
				if(cmbstatus.isSelected())
				model.insertRow(table.getRowCount(),new Object[]{txtcno.getText(),txtmade.getText(),sqlDate,txtcomplain.getText(),true});
				else
				model.insertRow(table.getRowCount(),new Object[]{txtcno.getText(),txtmade.getText(),sqlDate,txtcomplain.getText(),false});

				if(upd2==1)
				{
				//System.out.println("row updated");
				Icon tick=new ImageIcon("Check_h.gif");
				JOptionPane.showMessageDialog(complaint2.this,"<html><font size=4 color=green>Row Updated</font></html> ","Message",JOptionPane.ERROR_MESSAGE,tick);
				}
				else
				{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(complaint2.this,"<html><font size=4 color=red>Could Not Update</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				}
				pstm.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("error"+e);
				
			}

				break;
				case JOptionPane.NO_OPTION: 
				show();
			
			}   

				}
			}
		}

	}//action prfrmeed

	 public void createtab(String sql)
	{
		 try
        {
			String driver = "sun.jdbc.odbc.JdbcOdbcDriver";

			String url = "jdbc:odbc:emp2";
           
            Class.forName( driver );
			Connection con = DriverManager.getConnection( url );

 			Vector columnNames = new Vector(5);
			  Vector data = new Vector();

			columnNames.addElement("Complaint ID");
			columnNames.addElement("Made By");
			columnNames.addElement("Date");
			columnNames.addElement("Complaint");
			columnNames.addElement("Status"); 
            
 			Statement stmt1 = con.createStatement();
            ResultSet rs3 = stmt1.executeQuery( sql );
            ResultSetMetaData md = rs3.getMetaData();
            int columns = md.getColumnCount();

            while (rs3.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
					row.addElement( rs3.getObject(i));

                }
 
                data.addElement( row );
            }
			model.setDataVector(data,columnNames);	
			rs3.close();
			stmt1.close();
			con.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

	}


}

class complaintLayout implements LayoutManager {

    public complaintLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 571 + insets.left + insets.right;
        dim.height = 504 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+24,96,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+24,104,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+24,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+24,104,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+64,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+64,104,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+104,96,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+64,104,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+96,232,96);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+216,472,224);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+456,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+456,72,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+456,80,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+320,insets.top+456,72,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+456,72,24);}
    }
}
