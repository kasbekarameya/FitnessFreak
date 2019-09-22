//package gym.com.freak;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.print.*;

public class curcust2 extends JFrame implements ActionListener{
    JLabel current;
    JButton print;
    JButton close;
    JPanel panel_1;
    JTable table;
    DefaultTableModel model;
    Vector data,columnNames,rowset;

    public curcust2() {
        curcustLayout customLayout = new curcustLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        current = new JLabel("Current Customers");
        getContentPane().add(current);

        print = new JButton("Print");
        getContentPane().add(print);
        print.addActionListener(this);

        close = new JButton("Close");
        getContentPane().add(close);
        close.addActionListener(this);

        //panel_1 = new JPanel();
       // getContentPane().add(panel_1);

        int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
    int horizontal=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;

/*	String data[][] = {{"height","5.7","43","34","BMI","40","34","78","54","56","65","56","87","21","12","321","25","98","",""}};
    String col [] = {"Reg No.","Name","Date","Weight","Height","Neck","Shoulder","Chest Normal","Chest Expanded","Upper Arm","ForeArm","Upper Abdomen","Waist","Lower Abdomen","Hips","Thigh","Calf","WHR","BMI","Body Fat %"};
 model = new DefaultTableModel(data,col);
    table = new JTable(model){
      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;   //Disallow the editing of any cell
      }
    };
*/
	/*	try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:emp2");
			columnNames=new Vector();
 			data=new Vector();
 			
		
 		
 				
 				
 			
 					Statement stmt=con.createStatement();
 					ResultSet rs=stmt.executeQuery("select * from members");
 					ResultSetMetaData md=rs.getMetaData();
 					int columns=md.getColumnCount();
 					for (int i=1;i<=columns;i++)
					{
 						
						columnNames.addElement(md.getColumnName(i));
 					}
 					
 					while(rs.next())
					{
 						System.out.println("records: ");
	 					 rowset=new Vector(columns);
 						for(int i=1;i<=columns;i++)
						{
 							rowset.addElement(rs.getObject(i));
							//model.setDataVector(rowset,column);
 						}
							
 					}
					//model.setDataVector(data,columnNames);
					 data.addElement(rowset);
 						model = new DefaultTableModel(data,columnNames);
  					  table = new JTable(model){
     						 public boolean isCellEditable(int rowIndex, int colIndex) {
        						return false;   //Disallow the editing of any cell
     						 }
   						 };
  					  JScrollPane sp=new JScrollPane(table,vertical,horizontal);
					getContentPane().add(sp);
				
		    }    //try end
			catch(Exception e)
			{
 				System.out.println("Exception: " + e);
 			}
			*/
	try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn=DriverManager.getConnection("jdbc:odbc:emp2");
			Statement st=conn.createStatement();
			ResultSet set=st.executeQuery("select mid,name,cell_phone,gender,status from members");
			int row=0;
			int i=0;
			while(set.next())
			{
				row++;
			}
			 model=new DefaultTableModel(new String[]{"Membership Id","Name","Cell Phone No","Gender","Status"},row);
			table=new JTable(model);
			set=st.executeQuery("select mid, name, cell_phone, gender, status from members");
			while(set.next())
			{
				model.setValueAt(set.getString(1),i,0);
				model.setValueAt(set.getString(2),i,1);
				model.setValueAt(set.getString(3),i,2);
				model.setValueAt(set.getString(4),i,3);
				model.setValueAt(set.getString(5),i,4);
				i++;
			}
			table=new JTable(model);
		}
		catch(Exception ex)
		{
		}
		JScrollPane sp=new JScrollPane(table,vertical,horizontal);
		getContentPane().add(sp);			
			
 

		

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        curcust2 window = new curcust2();
        try {
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

            // start application
           // new MinFrame();
        }
        catch (Exception ex) {
           // ex.printStackTrace();
        }

        window.setTitle("Customer Report");
        window.pack();
        window.show();
    }

		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==print)
			{
				PrinterJob jb=PrinterJob.getPrinterJob();
				jb.printDialog();
			}
			if(ae.getSource()==close)
			{
				dispose();
			}
		}
}

class curcustLayout implements LayoutManager {

    public curcustLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 915 + insets.left + insets.right;
        dim.height = 621 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+64,184,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+552,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+496,insets.top+552,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+104,832,432);}
    }
}
