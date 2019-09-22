//package gym.com.freak;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;

//import gym.com.freak.diet.calorie2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Date;
import java.util.Vector;
//import javax.swing.JTable;
//import gym.com.valid.*;



public class measure extends JFrame implements ItemListener,ActionListener
{
    JLabel regno;
    JLabel date;
    JLabel wt;
    JLabel ht;
    JLabel neck;
    JLabel shoulder;
    JLabel chestnorm;
    JLabel chestexp;
    JLabel upperarm;
    JLabel forearm;
 
     NumericTextField txtwt;
     NumericTextField txtht;
     NumericTextField txtneck;
	DateField datefield;
    JComboBox cb;
     NumericTextField txtshoulder;
     NumericTextField txtchestnorm;
     NumericTextField txtchestexp;
     NumericTextField txtupperarm;
     NumericTextField txtforearm;
    JLabel label_11;
    JLabel upperabdomen;
    JLabel waist;
    JLabel lowerabd;
    JLabel hips;
    JLabel thigh;
    JLabel calf;
    JLabel whr;
    JLabel bmi;
    JLabel bodyfat;
    JTextField txtname;
     NumericTextField txtupperabd;
     NumericTextField txtwaist;
     NumericTextField txtlowerabd;
     NumericTextField txthips;
     NumericTextField txtthigh;
     NumericTextField txtcalf;
     NumericTextField txtwhr;
     NumericTextField txtbmi;
     NumericTextField txtbodyfat;
    JPanel panel_1;
    JButton add_b;
    JButton save;
    JButton cancel;
	JTable table;
    Connection con;
	DefaultTableModel model;
	JButton calcount;

    public measure()
	{
        measurementsLayout customLayout = new measurementsLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        regno = new JLabel("Member ID.");
        getContentPane().add(regno);

        date = new JLabel("Date");
        getContentPane().add(date);

        wt = new JLabel("Weight");
        getContentPane().add(wt);

        ht = new JLabel("height");
        getContentPane().add(ht);

        neck = new JLabel("Neck");
        getContentPane().add(neck);

        shoulder = new JLabel("Shoulder");
        getContentPane().add(shoulder);

        chestnorm = new JLabel("Chest Normal");
        getContentPane().add(chestnorm);

        chestexp = new JLabel("Chest Expanded");
        getContentPane().add(chestexp);

        upperarm = new JLabel("Upper Arm");
        getContentPane().add(upperarm);

        forearm = new JLabel("Forearm");
        getContentPane().add(forearm);

    
	 datefield = CalendarFactory.createDateField();
        getContentPane().add(datefield);

        txtwt = new  NumericTextField();
        getContentPane().add(txtwt);
		txtwt.setEnabled(false);

        txtht = new  NumericTextField();
        getContentPane().add(txtht);
		txtht.setEnabled(false);

        txtneck = new  NumericTextField();
        getContentPane().add(txtneck);
		txtneck.setEnabled(false);
    
      
		cb=new JComboBox();
		
		cb.addItem("-----Select-----");
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			con=DriverManager.getConnection("jdbc:odbc:emp2");
		
			Statement st=con.createStatement();
			ResultSet rst=st.executeQuery("select mid from members");
			while(rst.next())
			{
					
					cb.addItem(rst.getString(1));	

			}
			
		}
		catch(Exception e)
      		{
		    System.out.println( e );
      		}
		
		
		cb.addItemListener(this);
		add(cb);

        txtshoulder = new  NumericTextField();
        getContentPane().add(txtshoulder);
		txtshoulder.setEnabled(false);

        txtchestnorm = new  NumericTextField();
        getContentPane().add(txtchestnorm);
		txtchestnorm.setEnabled(false);

        txtchestexp = new  NumericTextField();
        getContentPane().add(txtchestexp);
		txtchestexp.setEnabled(false);

        txtupperarm = new  NumericTextField();
        getContentPane().add(txtupperarm);
		txtupperarm.setEnabled(false);

        txtforearm = new  NumericTextField();
        getContentPane().add(txtforearm);
		txtforearm.setEnabled(false);

        label_11 = new JLabel("Name");
        getContentPane().add(label_11);

        upperabdomen = new JLabel("Upper Abdomen");
        getContentPane().add(upperabdomen);

        waist = new JLabel("Waist");
        getContentPane().add(waist);

        lowerabd = new JLabel("Lower Abdomen");
        getContentPane().add(lowerabd);

        hips = new JLabel("Hips");
        getContentPane().add(hips);

        thigh = new JLabel("Thigh");
        getContentPane().add(thigh);

        calf = new JLabel("Calf");
        getContentPane().add(calf);

        whr = new JLabel("Calories Needed");
        getContentPane().add(whr);

        bmi = new JLabel("BMI");
        getContentPane().add(bmi);

        bodyfat = new JLabel("Body Fat %");
        getContentPane().add(bodyfat);

        txtname = new JTextField("");
		txtname.setEnabled(false);
        getContentPane().add(txtname);

        txtupperabd = new  NumericTextField();
		txtupperabd.setEnabled(false);
        getContentPane().add(txtupperabd);
		

        txtwaist = new  NumericTextField();
        getContentPane().add(txtwaist);
		txtwaist.setEnabled(false);

        txtlowerabd = new  NumericTextField();
        getContentPane().add(txtlowerabd);
		txtlowerabd.setEnabled(false);

        txthips = new  NumericTextField();
        getContentPane().add(txthips);
		txthips.setEnabled(false);

        txtthigh = new  NumericTextField();
        getContentPane().add(txtthigh);
		txtthigh.setEnabled(false);

        txtcalf = new  NumericTextField();
        getContentPane().add(txtcalf);
		txtcalf.setEnabled(false);

        txtwhr = new  NumericTextField();
        getContentPane().add(txtwhr);
		txtwhr.setEnabled(false);

        txtbmi = new  NumericTextField();
        getContentPane().add(txtbmi);
		txtbmi.setEnabled(false);

        txtbodyfat = new  NumericTextField();
        getContentPane().add(txtbodyfat);
		txtbodyfat.setEnabled(false);

       

		 int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		  int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
   		String col[] = {"Mem ID","Name","Date","Weight","Height","Neck","Shoulder","Chest Normal","Chest Expanded","Upper Arm","ForeArm","Upper Abdomen","Waist","Lower Abdomen","Hips","Thigh","Calf","WHR","BMI","Body Fat %"};
		String data[][] = {{"","","","","","","","","","","","","","","","","","","",""}};
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
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		getContentPane().add(sp);


        add_b= new JButton("Add");
        getContentPane().add(add_b);
		add_b.addActionListener(this);
		add_b.setEnabled(true);

        save = new JButton("Save");
		save.addActionListener(this);
        getContentPane().add(save);
		save.setEnabled(false);
		
        cancel = new JButton("Cancel");
      cancel.addActionListener(this);
        getContentPane().add(cancel);
		cancel.setEnabled(false);

		ImageIcon qst=new ImageIcon("question.png");
		calcount=new JButton(qst);
      calcount.addActionListener(this);
        getContentPane().add(calcount);
		calcount.setToolTipText("Click here to know your calorie needs");

          setUndecorated(true);
       getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
			
        setSize(getPreferredSize());
		 addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cb.setSelectedItem("-----Select-----");
            }
        });
    
      
    }
	

    public static void main(String args[]) {
        measure window = new measure();
         try {
            
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			SwingUtilities.updateComponentTreeUI(window);           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        window.setTitle("Measurements");
        window.pack();
        window.show();
    }


	public void itemStateChanged(ItemEvent ie)
	{
		
		 if (ie.getStateChange() == ie.SELECTED)
		 {
    
		String str=(String)cb.getSelectedItem();
		if(str=="-----Select-----")
			 {
				txtname.setText("");
				txtwt.setText("");
				txtht.setText("");
				txtneck.setText("");
				txtshoulder.setText("");
				txtchestnorm.setText("");
				txtchestexp.setText("");
				txtupperarm.setText("");
				txtforearm.setText("");
				txtupperabd.setText("");
				txtwaist.setText("");
				
				txtlowerabd.setText("");
				txthips.setText("");
				txtthigh.setText("");
				txtcalf.setText("");
				txtwhr.setText("");
				txtbmi.setText("");
				txtbodyfat.setText("");

			 }
		String strSQL="SELECT measurement.mid,name,date_test,weight,height,neck,shoulder,chestnormal,chestexp,upperarm,forearm,upperabd,waist,lowerabd,hips,thigh,calf,calories,BMI,bodyfat from measurement,members where members.mid=? and measurement.mid=members.mid";
		try {
              PreparedStatement pst = con.prepareStatement("SELECT name from members where mid=?");
			  pst.setString(1,str);
			  ResultSet rs=pst.executeQuery();
              while (rs.next())
			  {
                   txtname.setText(rs.getString("name"));
			  }
				
                 		
              }
			
			catch (Exception e)
			{
				System.out.println("error :"+e);
           	}
			
			createtab(strSQL);
	
		 }
		
   	 }
	  public void createtab(String strSQL)
	{
		  String str=(String)cb.getSelectedItem();
 		System.out.println("records outside: " );
		Vector columnNames=new Vector();
 		Vector data=new Vector();
		
 		try {
 				
 				
				PreparedStatement pre=con.prepareStatement(strSQL);

					pre.setString(1,str);
 					ResultSet result=pre.executeQuery();
 					ResultSetMetaData md=result.getMetaData();
					int columns=md.getColumnCount(); 
 					for (int i=1;i<=columns;i++)
					{
 						
						columnNames.addElement(md.getColumnName(i));
 					}
 				while(result.next())
					{
 						System.out.println("records: " );
	 					Vector rowset=new Vector(columns);
 						for(int i=1;i<=columns;i++)
						{
 							rowset.addElement(result.getObject(i));
							//model.setDataVector(rowset,column);
 						}
						data.addElement(rowset);
 						
 					}
					model.setDataVector(data,columnNames);	
			
				
		    }
			catch(Exception e)
			{
 				System.out.println("Exception: " + e);
 			}
			
	}	
	 public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==save)
		{
		
		System.out.println("after save");
		PreparedStatement pstm;
		//ResultSetMetaData md=rs.getMetaData();
		if(txtwt.getText().trim().equals("")||txtht.getText().trim().equals("")||txtneck.getText().trim().equals("")||txtshoulder.getText().trim().equals("")||txtchestnorm.getText().trim().equals("")||txtchestexp.getText().trim().equals("")||txtupperarm.getText().trim().equals("")||txtforearm.getText().trim().equals("")||txtwaist.getText().trim().equals("")||txtupperabd.getText().trim().equals("")||txtlowerabd.getText().trim().equals("")||txthips.getText().trim().equals("")||txtcalf.getText().trim().equals("")||txtbmi.getText().trim().equals("")||txtwhr.getText().trim().equals("")||txtbodyfat.getText().trim().equals("")||txtthigh.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(measure.this,"<html><font size=4 color=red>Please enter all fields </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
				if(txtwt.getText().trim().equals(""))
				txtwt.requestFocus();
				if(txtht.getText().trim().equals(""))
				txtht.requestFocus();
				if(txtneck.getText().trim().equals(""))
				txtneck.requestFocus();
				if(txtshoulder.getText().trim().equals(""))
				txtshoulder.requestFocus();
				if(txtchestnorm.getText().trim().equals(""))
				txtchestnorm.requestFocus();
				if(txtchestexp.getText().trim().equals(""))
				txtchestexp.requestFocus();
				if(txtupperarm.getText().trim().equals(""))
				txtupperarm.requestFocus();
				if(txtforearm.getText().trim().equals(""))
				txtforearm.requestFocus();
				if(txtwaist.getText().trim().equals(""))
				txtwaist.requestFocus();
				if(txtupperabd.getText().trim().equals(""))
				txtupperabd.requestFocus();
				if(txtlowerabd.getText().trim().equals(""))
				txtlowerabd.requestFocus();
				if(txthips.getText().trim().equals(""))
				txthips.requestFocus();
				if(txtcalf.getText().trim().equals(""))
				txtcalf.requestFocus();
				if(txtthigh.getText().trim().equals(""))
				txtthigh.requestFocus();
				if(txtbmi.getText().trim().equals(""))
				txtbmi.requestFocus();
				if(txtwhr.getText().trim().equals(""))
				txtwhr.requestFocus();
				if(txtbodyfat.getText().trim().equals(""))
				txtbodyfat.requestFocus();
				
			
			}
			else
			{

				
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:emp2");

				String mtr=(String)cb.getSelectedItem();

				
				//int mr=Integer.parseInt(mtr);
				//System.out.println("item selected: "+mr);

				
				
				java.util.Date choosed = (java.util.Date)datefield.getValue();	
				System.out.println("date in choosed: "+choosed);

				java.sql.Date sqlDate = new java.sql.Date(choosed.getTime());				
				System.out.println("date in sql:"+sqlDate);				
			
				model.insertRow(table.getRowCount(),new Object[]{mtr,txtname.getText(),sqlDate,txtwt.getText(),txtht.getText(),txtneck.getText(),txtshoulder.getText(),txtchestnorm.getText(),txtchestexp.getText(),txtupperarm.getText(),txtforearm.getText(),txtupperabd.getText(),txtwaist.getText(),
				txtlowerabd.getText(),
				txthips.getText(),
				txtthigh.getText(),
				txtcalf.getText(),
				txtwhr.getText(),
				txtbmi.getText(),
				txtbodyfat.getText()});
			

				pstm=con.prepareStatement("insert into measurement(mid,date_test,weight,height,neck,shoulder,chestnormal,chestexp,upperarm,forearm,upperabd,waist,lowerabd,hips,thigh,calf,calories,BMI,bodyfat)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");			
			
					
				
				pstm.setString(1,mtr);
				pstm.setDate(2,sqlDate);			
				pstm.setString(3,txtwt.getText());
				pstm.setString(4,txtht.getText());
				pstm.setString(5,txtneck.getText());
				pstm.setString(6,txtshoulder.getText());
				pstm.setString(7,txtchestnorm.getText());
				pstm.setString(8,txtchestexp.getText());
				pstm.setString(9,txtupperarm.getText());
				pstm.setString(10,txtforearm.getText());
				pstm.setString(11,txtupperabd.getText());
				pstm.setString(12,txtwaist.getText());
				
				pstm.setString(13,txtlowerabd.getText());
				pstm.setString(14,txthips.getText());
				pstm.setString(15,txtthigh.getText());
				pstm.setString(16,txtcalf.getText());
				pstm.setString(17,txtwhr.getText());
				pstm.setString(18,txtbmi.getText());
				pstm.setString(19,txtbodyfat.getText());	
				
				
				int ins=pstm.executeUpdate();
				if(ins==1)
			{
			Icon tick=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(measure.this,"<html><font size=4 color=green>Row Saved</font></html> ","Message",JOptionPane.ERROR_MESSAGE,tick);
			save.setEnabled(false);
			add_b.setEnabled(true);
			cancel.setEnabled(false);
			}
			else
			{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(measure.this,"<html><font size=4 color=red>Could Not Save</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				
			}

			}
			catch(Exception e)
			{
 				System.out.println("Exception: " + e);
				
 			}
			}
	 }

	if(ae.getSource()==add_b)
	{	
				if(cb.getSelectedItem()=="-----Select-----")
				{
					System.out.print("fisrt choose");
					
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(measure.this,"<html><font size=4 color=red>First choose a member to view the details</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				}
				else
				{
				save.setEnabled(true);
				cancel.setEnabled(true);
				add_b.setEnabled(false);
				txtwt.setText("");
				txtht.setText("");
				txtneck.setText("");
				txtshoulder.setText("");
				txtchestnorm.setText("");
				txtchestexp.setText("");
				txtupperarm.setText("");
				txtforearm.setText("");
				txtupperabd.setText("");
				txtwaist.setText("");
				
				txtlowerabd.setText("");
				txthips.setText("");
				txtthigh.setText("");
				txtcalf.setText("");
				txtwhr.setText("");
				txtbmi.setText("");
				txtbodyfat.setText("");

				txtwaist.setEnabled(true);
				txtupperabd.setEnabled(true);
				txtlowerabd.setEnabled(true);
				txthips.setEnabled(true);
				txtthigh.setEnabled(true);
				txtcalf.setEnabled(true);
				txtcalf.setEnabled(true);
				txtbmi.setEnabled(true);
				txtbodyfat.setEnabled(true);
				txtneck.setEnabled(true);
				txtht.setEnabled(true);
				txtwt.setEnabled(true);
				txtshoulder.setEnabled(true);
				txtchestnorm.setEnabled(true);
				txtchestexp.setEnabled(true);
				txtupperarm.setEnabled(true);
				txtforearm.setEnabled(true);
				txtwhr.setEnabled(true);
				}

	

	}
	if(ae.getSource()==cancel)
	{
		cancel.setEnabled(true);
		save.setEnabled(true);
		add_b.setEnabled(true);
		cb.setSelectedItem("-----Select-----");
		txtwaist.setEnabled(false);
				txtupperabd.setEnabled(false);
				txtlowerabd.setEnabled(false);
				txthips.setEnabled(false);
				txtthigh.setEnabled(false);
				txtcalf.setEnabled(false);
				txtcalf.setEnabled(false);
				txtbmi.setEnabled(false);
				txtbodyfat.setEnabled(false);
				txtneck.setEnabled(false);
				txtht.setEnabled(false);
				txtwt.setEnabled(false);
				txtshoulder.setEnabled(false);
				txtchestnorm.setEnabled(false);
				txtchestexp.setEnabled(false);
				txtupperarm.setEnabled(false);
				txtforearm.setEnabled(false);
				txtwhr.setEnabled(false);
	}

	if(ae.getSource()==calcount)
	{

		calorie2 cal=new calorie2();
		cal.setVisible(true);
		cal.setTitle("Calorie Counter");
	}
}
}

class measurementsLayout implements LayoutManager {

    public measurementsLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 712 + insets.left + insets.right;
        dim.height = 579 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+16,96,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+48,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+80,96,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+112,96,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+144,96,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+176,96,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+208,96,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+240,96,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+272,96,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+304,96,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+48,104,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+80,104,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+112,104,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+144,104,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+16,104,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+176,104,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+208,104,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+240,104,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+272,104,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+304,104,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+16,96,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+48,96,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+80,96,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+112,96,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+144,96,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+176,96,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+208,96,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+240,96,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+272,96,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+392,insets.top+304,96,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+512,insets.top+16,96,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+512,insets.top+48,96,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+512,insets.top+80,96,24);}
        c = parent.getComponent(33);
        if (c.isVisible()) {c.setBounds(insets.left+512,insets.top+112,96,24);}
        c = parent.getComponent(34);
        if (c.isVisible()) {c.setBounds(insets.left+512,insets.top+144,96,24);}
        c = parent.getComponent(35);
        if (c.isVisible()) {c.setBounds(insets.left+512,insets.top+176,96,24);}
        c = parent.getComponent(36);
        if (c.isVisible()) {c.setBounds(insets.left+512,insets.top+208,96,24);}
        c = parent.getComponent(37);
        if (c.isVisible()) {c.setBounds(insets.left+512,insets.top+240,96,24);}
        c = parent.getComponent(38);
        if (c.isVisible()) {c.setBounds(insets.left+512,insets.top+272,96,24);}
        c = parent.getComponent(39);
        if (c.isVisible()) {c.setBounds(insets.left+512,insets.top+304,96,24);}
        c = parent.getComponent(40);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+336,696,160);}
        c = parent.getComponent(41);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+520,72,24);}
        c = parent.getComponent(42);
        if (c.isVisible()) {c.setBounds(insets.left+304,insets.top+520,72,24);}
        c = parent.getComponent(43);
        if (c.isVisible()) {c.setBounds(insets.left+416,insets.top+520,80,24);}
        c = parent.getComponent(44);
        if (c.isVisible()) {c.setBounds(insets.left+616,insets.top+232,40,40);}
    }
}

