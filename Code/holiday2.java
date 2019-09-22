//package gym.com.freak;

import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Date;
import java.util.Vector;

public class holiday2 extends JFrame implements ActionListener{
    JLabel hol;
    JTextField holiday;
    JLabel dat;
    JPanel tab;
    DateField datefield;
    JButton savehol;
    JButton delhol;
    
	JTable table;
	DefaultTableModel model;
	Vector columnNames = new Vector();
    Vector data = new Vector();

    public holiday2() {
        holiday2Layout customLayout = new holiday2Layout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        hol = new JLabel("Holiday Name");
        getContentPane().add(hol);

        holiday = new JTextField("");
        getContentPane().add(holiday);

        dat = new JLabel("Date Closed");
        getContentPane().add(dat);

      
	    int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
   		
 
        try
        {
            
 
			String driver = "sun.jdbc.odbc.JdbcOdbcDriver";

			String url = "jdbc:odbc:emp2";
           
            Class.forName( driver );
			Connection connection = DriverManager.getConnection( url );
 
           
 
            String sql = "Select * from public_holiday";
			Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
 
            columnNames.addElement("Holiday Name");
			columnNames.addElement("Holiday Date");
 
           /* for (int i = 1; i <= columns; i++)
            {
				columnNames.addElement( md.getColumnName(i) );
            }*/
 
            
 
            while (rs.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
					row.addElement( rs.getObject(i));

                }
 
                data.addElement( row );
            }
 
            rs.close();
            stmt.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }
 
       
		model=new DefaultTableModel(data,columnNames);
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
	
		//table.addMouseListener(new TableHandler());
		


		JScrollPane sp=new JScrollPane(table,vertical,horizontal);
		getContentPane().add(sp);

        datefield = CalendarFactory.createDateField();
        getContentPane().add(datefield);

		ImageIcon i = new ImageIcon("add.png");
		ImageIcon saveic = new ImageIcon("save.png");
		ImageIcon delic = new ImageIcon("dust.png");
		//ImageIcon refic = new ImageIcon("");

        savehol = new JButton();
		savehol.setIcon(saveic);
        getContentPane().add(savehol);
		savehol.addActionListener(this);

        delhol = new JButton();
		delhol.setIcon(delic);
        getContentPane().add(delhol);
		delhol.addActionListener(this);

		setUndecorated(true);
       getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        setSize(getPreferredSize());
		setUndecorated(true);
       getRootPane().setWindowDecorationStyle(JRootPane.FRAME);



        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               dispose();
            }
        });
    }
	/*class TableHandler extends MouseAdapter
	{
    
	    public void mouseClicked(MouseEvent me)
	    {
			int ro=table.getSelectedRow();
			String sel=(String)table.getValueAt(ro,0);
			System.out.println(sel);
			holiday.setEnabled(false);
			try
			{
				
            				String driver = "sun.jdbc.odbc.JdbcOdbcDriver";

           				String url = "jdbc:odbc:emp2";
     				 Class.forName( driver );
            				Connection con = DriverManager.getConnection(url);
	    			//Statement st=con.createStatement();
				PreparedStatement pstm=con.prepareStatement("select * from public_holiday where name=?");
				//ResultSet set=st.executeQuery("select * from public_holiday where name="+sel);
				//String scd="";
				pstm.setString(1,sel);
				ResultSet set=pstm.executeQuery();
				System.out.println("hghghghgg");
				while(set.next())
				{
					
					System.out.println("kkiiilllllllmmmmmeeeee");
					java.util.Date date1=((java.util.Date)(set.getDate(2)));
					holiday.setText(set.getString(1));
					datefield.setValue(date1);
				}
				//textfield_1.setText(scd);
				//textfield_2.setText(set.getString(2));
				
			}
			catch(Exception ew)
			{
				System.out.println( "error---------->"+ew );
			}

		}
	}*/



    public static void main(String args[]) {
        holiday2 window = new holiday2();
		try {
            
	      	UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);
			}
             catch (Exception ex) {
            	ex.printStackTrace();
        	}
        window.setTitle("Holiday Configuration");
        window.pack();
        window.show();
    }
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==savehol)
		{
			String hol=holiday.getText().toLowerCase();
		//	System.out.println(hol);
			java.util.Date choosed = (java.util.Date)datefield.getValue();
			java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
			boolean b=false;
			
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
				
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from public_holiday");
			
	/*			while(rs.next())
				{
			String holi=rs.getString(1);

			java.util.Date sqlDat = (java.util.Date)(rs.getDate(2));
			String sqlDatd=sqlDat.toString();
			String choosedd=choosed.toString();
					System.out.println(sqlDatd);
					System.out.println(choosedd);
					if(hol.equals(rs.getString(1)))
					{
						b=true;
					//	break;
					}
					else
					{
					
					b=false;
					}
				}//while over
				rs.close();
				st.close();
				
				
			}*/

				while(rs.next())
				{

					
					if(hol.equals(rs.getString(1)))
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
				JOptionPane.showMessageDialog(holiday2.this,"<html><font size=4 color=red>This holiday already exists.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				System.out.println("exists");
				}
				else if(hol.equals(""))
			{
					Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(holiday2.this,"<html><font size=4 color=red>Please fill holiday name.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
				else
				{
				try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");	
				PreparedStatement pstm=con.prepareStatement("insert into public_holiday(name,holdate)values(?,?)");
				pstm.setString(1,holiday.getText());
				

				pstm.setDate(2,sqlDate);

				int upd=pstm.executeUpdate();
				model.insertRow(table.getRowCount(),new Object[]{hol,sqlDate});
		
					holiday.setText("");
					datefield.setValue(new java.util.Date());
				System.out.println("row updates="+upd);
				}
				catch(Exception e)
      	 		{
            			System.out.println("error"+e );
					
      			}

				}
			
			
		}  //save over


		if(ae.getSource()==delhol)
		{
			int selected=table.getSelectedRow();
			int rowcount=table.getSelectedRowCount();
			if(selected==-1 || rowcount!=1)
			{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(holiday2.this,"<html><font size=4 color=red>Choose a single record to delete.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else
			{
			try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			PreparedStatement pstm=con.prepareStatement("delete from public_holiday where name=?");
			
			String s=(String)model.getValueAt(selected,0);
			//java.util.Date choosed = (java.util.Date)datefield.getValue();
			//java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
			pstm.setString(1,s);
			int del=pstm.executeUpdate();
						model.removeRow(selected);

			if(del==1)
			{
			Icon tick=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(holiday2.this,"<html><font size=4 color=red>Deleted</font></html>","Message",JOptionPane.ERROR_MESSAGE,tick);
			}	
			else
				System.out.print("not deleted");
			holiday.setText("");
			}
			catch(Exception e)
      	 	{
            			System.out.println("error"+e );
					
      		} 
			}
		}//if over

	}

	
}

/*
class holiday2Layout implements LayoutManager {

    public holiday2Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 420 + insets.left + insets.right;
        dim.height = 357 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+264,120,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+264,112,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+304,120,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+48,280,208);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+304,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+8,48,32);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+8,48,32);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,48,32);}
    }
}
*/


class holiday2Layout implements LayoutManager {

    public holiday2Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 420 + insets.left + insets.right;
        dim.height = 357 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+264,120,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+264,112,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+304,120,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+48,280,208);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+304,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+8,48,32);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+8,48,32);}
    }
}
