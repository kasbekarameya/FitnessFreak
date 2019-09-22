//package gym.com.freak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;


public class appoint extends JFrame implements ActionListener,ItemListener{
    JLabel label_1;
    JTextField appno;
    JLabel label_2;
    JLabel label_3;
    JTextField txtmname;
    JLabel label_4;
    JComboBox apptype;
    JLabel label_5;
     DateField cmbdate;
    JLabel label_6;
    JComboBox tim3;
    JComboBox cmbemp;
    JPanel panel_1;
    JButton add;
    JButton save;
    JButton can;
    JButton del;
	DefaultTableModel model;
	JTable table;
	Connection con;
    JComboBox min;
    JComboBox hrs;
	String strSQL;
    JLabel label_7;
    JComboBox cmbid;

    public appoint() {
		ImageIcon ad,de,ca,sav;
		ad=new ImageIcon("add.png");
       	sav=new ImageIcon("save.png");
       	de=new ImageIcon("dust.PNG");
       	ca=new ImageIcon("close.png");


        appointLayout customLayout = new appointLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("Appointment No");
        getContentPane().add(label_1);

        appno = new JTextField("");
        getContentPane().add(appno);
		appno.setEnabled(false);

        label_2 = new JLabel("Appointment Type");
        getContentPane().add(label_2);

        label_3 = new JLabel("Member Name");
        getContentPane().add(label_3);

        label_4 = new JLabel("Employee Name");
        getContentPane().add(label_4);

        apptype = new JComboBox();
	
	    apptype.addItem("Nutrionist");
        apptype.addItem("Massage");
		apptype.addItem("CFT");

        getContentPane().add(apptype);

        label_5 = new JLabel("Appointment Date");
        getContentPane().add(label_5);

        cmbdate = CalendarFactory.createDateField();
        getContentPane().add(cmbdate);

        label_6 = new JLabel("Appointment Time");
        getContentPane().add(label_6);

      

        tim3 = new JComboBox();
        tim3.addItem("AM");
        tim3.addItem("PM");
        getContentPane().add(tim3);

        cmbemp = new JComboBox();
        getContentPane().add(cmbemp);
		cmbemp.addItem("---Select---");

        panel_1 = new JPanel();
		int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;		     
		int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
    	String col[] = {"App No","App Type","Member ID","Member Name","Employee Name","Date","Time"};
		String data[][] = {{"","","","","","",""}};

		model=new DefaultTableModel(data,col);
		table=new JTable(model)    {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);
 	//table.setAutoResizeMode(AUTO_RESIZE_OFF);
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
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//table.addMouseListener(new TableHandler());
	
        getContentPane().add(sp);

        add = new JButton(ad);
        getContentPane().add(add);
		add.addActionListener(this);

        save = new JButton(sav);
        getContentPane().add(save);
		save.addActionListener(this);

        can = new JButton(ca);
        getContentPane().add(can);
		can.addActionListener(this);

        del = new JButton(de);
        getContentPane().add(del);
		del.addActionListener(this);

		save.setEnabled(false);
		can.setEnabled(false);
		appno.setEnabled(false);
		cmbdate.setEnabled(false);
		cmbemp.setEnabled(false);
		apptype.setEnabled(false);
	//	min.setEnabled(false);
	//	hrs.setEnabled(false);
		tim3.setEnabled(false);


		try
		{
		
		//	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			con=DriverManager.getConnection("jdbc:odbc:emp2");

			PreparedStatement psa1=con.prepareStatement("select name from emp");
			ResultSet rsta1=psa1.executeQuery();
			while(rsta1.next())
			{
					
					cmbemp.addItem(rsta1.getString(1));	

			}
			
		}
		catch(Exception exa)
      		{
		    System.out.println( exa );
      		}
	strSQL ="select appid,apptype,mid,memname,empname,appdate,apptime from appointment";
	createtab(strSQL);

	        min = new JComboBox();
    		min.addItem("00");
			min.addItem("01");
			min.addItem("02");
			min.addItem("03");
			min.addItem("04");
			min.addItem("05");
			min.addItem("06");
			min.addItem("07");
			min.addItem("08");
			min.addItem("09");
			min.addItem("10");
				
			min.addItem("11");
			min.addItem("12");
			min.addItem("13");
			min.addItem("14");
			min.addItem("15");
			min.addItem("16");
			min.addItem("17");
			min.addItem("18");
			min.addItem("19");
			min.addItem("20");

			min.addItem("21");
			min.addItem("22");
			min.addItem("23");
			min.addItem("24");
			min.addItem("25");
			min.addItem("26");
			min.addItem("27");
			min.addItem("28");
			min.addItem("29");
			min.addItem("30");

			min.addItem("31");
			min.addItem("32");
			min.addItem("33");
			min.addItem("34");
			min.addItem("35");
			min.addItem("36");
			min.addItem("37");
			min.addItem("38");
			min.addItem("39");
			min.addItem("40");

			min.addItem("41");
			min.addItem("42");
			min.addItem("43");
			min.addItem("44");
			min.addItem("45");
			min.addItem("46");
			min.addItem("47");
			min.addItem("48");
			min.addItem("49");
			min.addItem("50");

			min.addItem("51");
			min.addItem("52");
			min.addItem("53");
			min.addItem("54");
			min.addItem("55");
			min.addItem("56");
			min.addItem("57");
			min.addItem("58");
			min.addItem("59");

		   getContentPane().add(min);


        hrs = new JComboBox();
    	
			hrs.addItem("01");
			hrs.addItem("02");
			hrs.addItem("03");
			hrs.addItem("04");
			hrs.addItem("05");
			hrs.addItem("06");
			hrs.addItem("07");
			hrs.addItem("08");
			hrs.addItem("09");
			hrs.addItem("10");
				
			hrs.addItem("11");
			hrs.addItem("12");

		getContentPane().add(hrs);
		min.setEnabled(false);
		hrs.setEnabled(false);

       label_7 = new JLabel("Member ID");
        getContentPane().add(label_7);

        cmbid = new JComboBox();
        getContentPane().add(cmbid);
		cmbid.addItemListener(this);

        txtmname = new JTextField("");
        getContentPane().add(txtmname);

		try
		{
		
		//	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			PreparedStatement psa11=con.prepareStatement("select mid from members");
			ResultSet rsta11=psa11.executeQuery();
			cmbid.addItem("---Select---");

			while(rsta11.next())
			{
					
					cmbid.addItem(rsta11.getString(1));	

			}
		
		}
		catch(Exception exa)
      		{
		    System.out.println( exa );
      		}
	         cmbid.setSelectedItem("---Select---");
	         cmbemp.setSelectedItem("---Select---");

			cmbid.setEnabled(false);
			txtmname.setEnabled(false);
	    setSize(getPreferredSize());
		setUndecorated(true);
    	getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
           		min.setSelectedItem("00");
				hrs.setSelectedItem("01");
				appno.setText("");
				tim3.setSelectedItem("AM");
				cmbid.setSelectedItem("MEM0001");
	         cmbemp.setSelectedItem("---Select---");
	         cmbid.setSelectedItem("---Select---");
		txtmname.setText("");

				cmbdate.setValue(new java.util.Date());
				add.setEnabled(true);
				save.setEnabled(false);
				can.setEnabled(false);
				del.setEnabled(true);
				appno.setEnabled(false);
				cmbdate.setEnabled(false);
				
				cmbemp.setEnabled(false);
				apptype.setEnabled(false);
				min.setEnabled(false);
				hrs.setEnabled(false);
				tim3.setEnabled(false);
				cmbid.setEnabled(false);
            }
        });
    }
	public void itemStateChanged(ItemEvent ie)
	{
		 if (ie.getStateChange() == ie.SELECTED)
		 {
			 try{
		String m=(String)cmbid.getSelectedItem();
			PreparedStatement psa=con.prepareStatement("select name from members where mid=?");
			psa.setString(1,m);
			ResultSet rsta=psa.executeQuery();
			while(rsta.next())
			{
				txtmname.setText(rsta.getString(1));	
			}	
			 }catch(Exception l){}
		 }
	}
	/*class TableHandler extends MouseAdapter
	{
    
	    public void mouseClicked(MouseEvent me)
	    {
			int ro=table.getSelectedRow();
			String sel=(String)table.getValueAt(ro,0);
			
			try
			{
	    			
	PreparedStatement pstm1=con.prepareStatement("select appid,apptype,mid,appdate,memname,empname,hrs,min,am from appointment where appid=?");
//	PreparedStatement pstm1=con.prepareStatement("select appid,apptype,appdate,memname,empname,hrs,min,am from appointment where appid=?");
				
				pstm1.setString(1,sel);
				ResultSet set=pstm1.executeQuery();
				while(set.next())
				{
				appno.setText(set.getString(1));							
				apptype.setSelectedItem(set.getString(2));
				cmbid.setSelectedItem(set.getString(3));
				java.util.Date date1=((java.util.Date)(set.getDate(4)));
				cmbdate.setValue(date1);
				txtmname.setText(set.getString(5));
				cmbemp.setSelectedItem(set.getString(6));
				hrs.setSelectedItem(set.getString(7));
				min.setSelectedItem(set.getString(8));
				tim3.setSelectedItem(set.getString(9));

				}
				
			}
			catch(Exception ew)
			{
				System.out.println( "error---------->"+ew );
			}

		}
	}		//tablehandler over  */
	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==add)
	{
		can.setEnabled(true);
		save.setEnabled(true);
		del.setEnabled(false);
		add.setEnabled(false);
		cmbdate.setEnabled(true);
		
		cmbemp.setEnabled(true);
		apptype.setEnabled(true);
		cmbid.setEnabled(true);
		min.setEnabled(true);
		hrs.setEnabled(true);
		tim3.setEnabled(true);
		min.setSelectedItem("00");
		hrs.setSelectedItem("01");
		tim3.setSelectedItem("AM");
		cmbdate.setValue(new java.util.Date());

 int numrows = model.getRowCount();   
 for(int i = numrows - 1; i >=0; i--)   
 {
	 model.removeRow(i);  
 }
			try
				{
					System.out.println("hola");
					DataInputStream sin=new DataInputStream(new FileInputStream("App.dat"));
					appno.setText(sin.readUTF());		
				}catch(Exception ex){}
				

	}
	if(ae.getSource()==save)
	{


	
			java.util.Date choosed=(java.util.Date)cmbdate.getValue();	
			java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());
		String typ=(String)apptype.getSelectedItem();
		
		String em=(String)cmbemp.getSelectedItem();
		String t=(String)tim3.getSelectedItem();
		
	
		String spin=(String)min.getSelectedItem();

	
		String spin1=(String)hrs.getSelectedItem();
		System.out.println("inserting");		
			String id=(String)cmbid.getSelectedItem();
	String apptim=spin1+"."+spin+" "+t;
	String apno=appno.getText();

		if(id=="---Select---"||em=="---Select---")
			{

				Icon warn=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(appoint.this,"<html><font size=4 color=red>Please fill all the details.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);

			}
			else
			{
				try{
	PreparedStatement pm=con.prepareStatement("insert into appointment(appid,apptype,appdate,memname,empname,hrs,min,am,apptime,mid)values(?,?,?,?,?,?,?,?,?,?)");


		pm.setString(1,apno);
		pm.setString(2,typ);
		pm.setDate(3,sqlDate);
		pm.setString(4,txtmname.getText());
		pm.setString(5,em);
		pm.setString(6,spin1);
		pm.setString(7,spin);
		pm.setString(8,t);
		pm.setString(9,apptim);
				pm.setString(10,id);
			 int resp = JOptionPane.showConfirmDialog(appoint.this,
             "Are you sure you want to save?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(resp) {
            case JOptionPane.YES_OPTION: 
             pm.executeUpdate();
		appno.setEnabled(false);
		cmbdate.setEnabled(false);
		cmbemp.setEnabled(false);
		apptype.setEnabled(false);
		min.setEnabled(false);
		cmbid.setEnabled(false);
		hrs.setEnabled(false);
		tim3.setEnabled(false);
		appno.setText("");
		tim3.setSelectedItem("AM");
		min.setSelectedItem("00");
		hrs.setSelectedItem("01");
		cmbid.setSelectedItem("---Select---");
		cmbemp.setSelectedItem("---Select---");
		txtmname.setText("");
		cmbdate.setValue(new java.util.Date());
	
					try{
			DataInputStream dt=new DataInputStream(new FileInputStream("App.dat"));
			String temp2=dt.readUTF();
			String coursename="APP";
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
							DataOutputStream out=new DataOutputStream(new FileOutputStream("App.dat"));
							out.writeUTF(temp2);
							dt.close();

		}catch(Exception i){System.out.println("ERROR"+i);}
				createtab(strSQL);
	//	model.insertRow(table.getRowCount(),new Object[]{apno,typ,mn,em,sqlDate,apptim});

			Icon check=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(appoint.this,"<html><font size=4 color=green>Record Saved</font></html>","Save Message",JOptionPane.ERROR_MESSAGE,check);
			
		del.setEnabled(true);
		save.setEnabled(false);
		can.setEnabled(false);
		add.setEnabled(true);

               break;
            case JOptionPane.NO_OPTION: 
	//			createtab(strSQL);
					

				show();
		 }   
			}catch(Exception m){System.out.println( m );}
			}
	}
	if(ae.getSource()==del)
	{
			int selected=table.getSelectedRow();
			int rowcount=table.getSelectedRowCount();
			if(selected==-1 || rowcount!=1)
			{
				Icon warn=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(appoint.this,"<html><font size=4 color=red>Choose one record to delete.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else
			{

		try{
			
			 int response1 = JOptionPane.showConfirmDialog(appoint.this,
             "Are you sure you want to delete?","Confirmation",JOptionPane.YES_NO_OPTION);
         switch(response1) {
            case JOptionPane.YES_OPTION: 
				//String id=appno.getText();
			String appdel=(String)table.getValueAt(selected,0);  

			PreparedStatement sm=con.prepareStatement("DELETE FROM appointment where appid=?");
			sm.setString(1,appdel);
             int deleted=sm.executeUpdate();
			if(deleted>=1)
			 {
				
				
			Icon check=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(appoint.this,"<html><font size=4 color=green>Record Deleted</font></html>","Delete Message",JOptionPane.ERROR_MESSAGE,check);
			model.removeRow(selected);
			 }
		appno.setText("");
		tim3.setSelectedItem("AM");
		min.setSelectedItem("00");
		hrs.setSelectedItem("01");
		cmbdate.setValue(new java.util.Date());
		cmbid.setSelectedItem("---Select---");
		cmbemp.setSelectedItem("---Select---");
		txtmname.setText("");

               break;
            case JOptionPane.NO_OPTION: 
				show();
		 }   
			
		

			}catch(Exception me){System.out.println( me );}
			}
	}
	if(ae.getSource()==can)
	{
		add.setEnabled(true);
		save.setEnabled(false);
		can.setEnabled(false);
		del.setEnabled(true);
		appno.setEnabled(false);
		cmbdate.setEnabled(false);
		cmbemp.setEnabled(false);
		apptype.setEnabled(false);
		min.setEnabled(false);
		cmbid.setEnabled(false);
		hrs.setEnabled(false);
		tim3.setEnabled(false);
		appno.setText("");
		tim3.setSelectedItem("AM");
		min.setSelectedItem("00");
		hrs.setSelectedItem("01");
		cmbdate.setValue(new java.util.Date());
		cmbid.setSelectedItem("---Select---");
		cmbemp.setSelectedItem("---Select---");
		txtmname.setText("");

	createtab(strSQL);
	}
	}
	 public void createtab(String strSQL)
	{
		 try
        {
 			Vector data = new Vector();
			 Vector col = new Vector(7);
			col.add("App No");
			col.add("App Type");
			col.add("Member ID");

			col.add("Member Name");
			col.add("Employee Name");
			col.add("Date");
			col.add("Time");

           // String sql ="select appid,apptype,memname,empname,appdate,apptime";
            Statement prest = con.createStatement();
            ResultSet rs1 = prest.executeQuery(strSQL);

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
		catch(Exception e)
		{
 				System.out.println("Exception: " + e);
 		}		
	
	}
    public static void main(String args[]) {
        appoint window = new appoint();
try {
          
    UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

      } catch (Exception ex) {ex.printStackTrace();}
        	

        window.setTitle("Appointments");
        window.pack();
        window.show();
    }
}

/*
class appointLayout implements LayoutManager {

    public appointLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 616 + insets.left + insets.right;
        dim.height = 506 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+80,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+80,120,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+120,112,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+160,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+160,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+160,112,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+120,120,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+80,112,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+80,144,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+120,112,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+120,40,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+480,insets.top+120,40,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+528,insets.top+120,48,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+160,144,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+216,528,248);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+24,40,32);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+24,40,32);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+24,40,32);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+24,40,32);}
    }
}


class appointLayout implements LayoutManager {

    public appointLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 616 + insets.left + insets.right;
        dim.height = 506 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+80,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+80,120,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+120,112,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+160,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+160,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+160,112,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+120,120,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+80,112,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+80,144,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+120,112,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+528,insets.top+120,48,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+160,144,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+216,528,248);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+24,40,32);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+24,40,32);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+24,40,32);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+24,40,32);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+480,insets.top+120,40,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+120,40,24);}
    }
}

class appointLayout implements LayoutManager {

    public appointLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 627 + insets.left + insets.right;
        dim.height = 515 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+80,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+80,120,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+120,112,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+160,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+160,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+160,112,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+120,120,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+80,112,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+80,144,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+120,112,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+528,insets.top+120,48,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+160,144,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+248,528,248);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+24,40,32);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+24,40,32);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+24,40,32);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+24,40,32);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+480,insets.top+120,40,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+120,40,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+200,112,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+200,120,24);}
    }
}
*/
class appointLayout implements LayoutManager {

    public appointLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 627 + insets.left + insets.right;
        dim.height = 515 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+80,112,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+80,120,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+120,112,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+200,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+160,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+120,120,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+80,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+80,144,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+120,112,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+528,insets.top+120,48,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+160,144,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+248,528,248);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+24,40,32);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+24,40,32);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+24,40,32);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+24,40,32);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+480,insets.top+120,40,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+120,40,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+160,112,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+160,120,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+200,120,24);}
    }
}
