//package gym.com.freak;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Vector;
import java.util.*;
import javax.swing.SwingUtilities;
//import gym.com.valid.*;

public class eatingpattern extends JFrame implements ItemListener,ActionListener{
    JLabel label_1;
    JComboBox mid;
    JLabel label_3;
    JLabel label_4;
    JComboBox prog;
    JLabel label_5;
    NumericTextField weight;
    JLabel label_6;
    NumericTextField height;
    JLabel label_7;
    JLabel label_8;
    JTextField exercise;
    JLabel label_9;
    JTextField obese;
    JLabel label_10;
    JTextField dietprog;
    JLabel label_11;
    JTextField history;
    JLabel label_12;
    JTextField menstrual;
    JTextField reason;
    JLabel label_13;
    JLabel label_14;
    JTextField depression;
    JLabel label_15;
    JTextField eater;
    JLabel label_16;
    JTextField water;
    JLabel label_17;
    JLabel label_18;
    JLabel label_19;
    JLabel label_20;
    JLabel label_21;
    JLabel label_22;
    JLabel label_23;
    JLabel label_24;
    JTextField tooth;
    JTextField hungpeak;
    JTextField snack;
    JTextField stress;
    JTextField habits;
    JTextField meal;
    JTextField likes;
    JComboBox dietician;
    JButton suggest1;
    JButton upd;
    JButton save;
    JComboBox combobox_1;
    //JButton addrec;
    JTextField txtname;
    Connection con;
	Statement st;
	ResultSet rs;
	 JLabel label_2;
    JLabel label_25;


    public eatingpattern() {
        eatingpatternLayout customLayout = new eatingpatternLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("Member ID");
        getContentPane().add(label_1);

        mid = new JComboBox();
		mid.addItem("----Select----");
        try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			con=DriverManager.getConnection("jdbc:odbc:emp2");
		
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			rs=st.executeQuery("select mid from members");
			
			while(rs.next())
			{
					
					mid.addItem(rs.getString(1));	

			}
			//rs.refreshRow();
		}
		catch(Exception e)
      		{
		    System.out.println( e );
      		}
	mid.addItemListener(this);	
       getContentPane().add(mid);

        label_3 = new JLabel("Member Name");
        getContentPane().add(label_3);

        label_5 = new JLabel("* Weight");
        getContentPane().add(label_5);

        weight = new NumericTextField();
        getContentPane().add(weight);

        label_6 = new JLabel("* Height");
        getContentPane().add(label_6);

        height = new NumericTextField();
        getContentPane().add(height);

        label_7 = new JLabel("Veg / Non-Veg");
        getContentPane().add(label_7);

        label_8 = new JLabel("Exercise History");
        getContentPane().add(label_8);

        exercise = new JTextField("");
        getContentPane().add(exercise);

        label_9 = new JLabel("Obese");
        getContentPane().add(label_9);

        obese = new JTextField("");
        getContentPane().add(obese);

        label_10 = new JLabel("Previous Diet Progams");
        getContentPane().add(label_10);

        dietprog = new JTextField("");
        getContentPane().add(dietprog);

        label_11 = new JLabel("Medical History");
        getContentPane().add(label_11);

        history = new JTextField("");
        getContentPane().add(history);

        label_12 = new JLabel("Menstrual Pattern,\nPregnancy");
        getContentPane().add(label_12);

        menstrual = new JTextField("");
        getContentPane().add(menstrual);

        reason = new JTextField("");
        getContentPane().add(reason);

        label_13 = new JLabel("Reason for losing weight");
        getContentPane().add(label_13);

        label_14 = new JLabel("* Any Depression?");
        getContentPane().add(label_14);

        depression = new JTextField("");
        getContentPane().add(depression);

        label_15 = new JLabel("Quick/Slow/Moderate Eater");
        getContentPane().add(label_15);

        eater = new JTextField("");
        getContentPane().add(eater);

        label_16 = new JLabel("* Water Consumption");
        getContentPane().add(label_16);

        water = new JTextField("");
        getContentPane().add(water);

        label_17 = new JLabel("Specific Likes/Dislikes");
        getContentPane().add(label_17);

        label_18 = new JLabel("Sweet Tooth");
        getContentPane().add(label_18);

        label_19 = new JLabel("Hunger Peak");
        getContentPane().add(label_19);

        label_20 = new JLabel("Snacking");
        getContentPane().add(label_20);

        label_21 = new JLabel("Are you stressed out?");
        getContentPane().add(label_21);

        label_22 = new JLabel("Nutritionist");
        getContentPane().add(label_22);

        label_23 = new JLabel("Regular/Irregular Eating\n habits");
        getContentPane().add(label_23);

        label_24 = new JLabel("Main Meal");
        getContentPane().add(label_24);

        tooth = new JTextField("");
        getContentPane().add(tooth);

        hungpeak = new JTextField("");
        getContentPane().add(hungpeak);

        snack = new JTextField("");
        getContentPane().add(snack);

        stress = new JTextField("");
        getContentPane().add(stress);

        habits = new JTextField("");
        getContentPane().add(habits);

        meal = new JTextField("");
        getContentPane().add(meal);

        likes = new JTextField("");
        getContentPane().add(likes);

        dietician = new JComboBox();
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			con=DriverManager.getConnection("jdbc:odbc:emp2");
			
			PreparedStatement st=con.prepareStatement("select name from emp where profile=?");
			//ResultSet rst=st.executeQuery("select name from emp where profile=Nutritionist");
			st.setString(1,"Nutritionist");
			ResultSet rst=st.executeQuery();
			while(rst.next())
			{
					
					dietician.addItem(rst.getString(1));	

			}
			
		}
		catch(Exception e)
      		{
		    System.out.println( e );
      		}
        getContentPane().add(dietician);

        suggest1 = new JButton("Suggest");
        getContentPane().add(suggest1);
        suggest1.addActionListener(this);

        upd = new JButton("Update");
        getContentPane().add(upd);
		upd.addActionListener(this);

        save = new JButton("Save");
        getContentPane().add(save);
        save.addActionListener(this);
		

        combobox_1 = new JComboBox();
        combobox_1.addItem("Vegetarian");
        combobox_1.addItem("Non-Vegetarian");
        getContentPane().add(combobox_1);

        //addrec = new JButton("Add");
        //getContentPane().add(addrec);

        txtname = new JTextField("");
        getContentPane().add(txtname);
		txtname.setEnabled(false);

		label_2 = new JLabel("in cms");
        getContentPane().add(label_2);

        label_25 = new JLabel("in Kg");
        getContentPane().add(label_25);


        setSize(getPreferredSize());
		
          setUndecorated(true);
       getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               dispose();
			   mid.setSelectedItem("----Select----");
            }
        });
    }

    public static void main(String args[]) {
        eatingpattern window = new eatingpattern();
        try {
            // select Look and Feel
  UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	SwingUtilities.updateComponentTreeUI(window);

	          
             }
             catch (Exception ex) {
            	System.out.println(ex);
        	}
        window.setTitle("Eating Pattern of the Member");
        window.pack();
        window.show();
    }
      public void itemStateChanged(ItemEvent ie)
	{
		
		 if (ie.getStateChange() == ie.SELECTED)
		 {
			 if(mid.getSelectedItem()=="----Select----")
			{
				 
				//Icon warn=new ImageIcon("Warning_h.gif");
				//JOptionPane.showMessageDialog(eatingpattern.this,"<html><font size=4 color=red>First choose a member to update records.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				height.setText("");
				weight.setText("");
				txtname.setText("");
				exercise.setText("");
				//System.out.println(rst3.getString("exercise"));
				obese.setText("");
				dietprog.setText("");
				height.setText("");
				weight.setText("");
				history.setText("");
				meal.setText("");
                depression.setText("");
				dietician.setSelectedItem("");
                water.setText("");
				stress.setText("");
                snack.setText("");
				hungpeak.setText("");
                tooth.setText("");
				eater.setText("");
				likes.setText("");
				menstrual.setText("");
				habits.setText("");
				reason.setText("");
				//suggest1.setEnabled(false);
				upd.setEnabled(false);

			}
			else
			 {
    			try
				{
				String str=(String)mid.getSelectedItem();
				PreparedStatement pst = con.prepareStatement("SELECT name from members where members.mid=?");
					
				pst.setString(1,str);
				ResultSet rst=pst.executeQuery();
		                	while (rst.next())
				{
                  			    	txtname.setText(rst.getString("name"));
						
				}
			/*	PreparedStatement pst1 = con.prepareStatement("SELECT prog_name from mem_prog where mid=?");
				pst1.setString(1,str);
				ResultSet rst1=pst1.executeQuery();
		                	while (rst1.next())
				{
                  			   	 prog.addItem(rst1.getString("prog_name"));
				}*/
				
				PreparedStatement pst3 = con.prepareStatement("SELECT * from eatingpattern where mid=?");
				pst3.setString(1,str);
				ResultSet rst3=pst3.executeQuery();
				if(rst3.next())
				{
				
		         do
				{
				System.out.println("gghhjh");
				combobox_1.setSelectedItem(rst3.getString("veg"));
				height.setText(rst3.getString("ht"));
				weight.setText(rst3.getString("wt"));
				exercise.setText(rst3.getString("exercise"));
				//System.out.println(rst3.getString("exercise"));
				obese.setText(rst3.getString("obese"));
				dietprog.setText(rst3.getString("previousdiet"));
				history.setText(rst3.getString("history"));
				meal.setText(rst3.getString("mainmeal"));
                depression.setText(rst3.getString("depression"));
				dietician.setSelectedItem(rst3.getString("dietician"));
                water.setText(rst3.getString("water"));
				stress.setText(rst3.getString("stress"));
                snack.setText(rst3.getString("snack"));
				hungpeak.setText(rst3.getString("hunger"));
                  			tooth.setText(rst3.getString("tooth"));
				eater.setText(rst3.getString("eater"));
				likes.setText(rst3.getString("likes"));
				menstrual.setText(rst3.getString("menstrual"));
				habits.setText(rst3.getString("habits"));
				reason.setText(rst3.getString("reason"));
				//Object ob1=(Object)rs.getString("veg");
                  			 
				}while (rst3.next());
				save.setEnabled(false);
				upd.setEnabled(true);
				}
				else
				{
					System.out.println("n rcs");
					combobox_1.setSelectedItem("");
				upd.setEnabled(false);
				save.setEnabled(true);
				
				exercise.setText("");
				//System.out.println(rst3.getString("exercise"));
				obese.setText("");
				dietprog.setText("");
				height.setText("");
				weight.setText("");
				history.setText("");
				meal.setText("");
                depression.setText("");
				dietician.setSelectedItem("");
                water.setText("");
				stress.setText("");
                snack.setText("");
				hungpeak.setText("");
                tooth.setText("");
				eater.setText("");
				likes.setText("");
				menstrual.setText("");
				habits.setText("");
				reason.setText("");
				}
				
				
				
			}	//try over
			catch (Exception X)
			{
				System.out.println("error :"+X);
            			}
		}//if over
		 }
	}//itemchange over
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==save)
		{
			if(mid.getSelectedItem()=="----Select----")
			{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(eatingpattern.this,"<html><font size=4 color=red>First choose a member to save records.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else if(height.getText().trim().equals("")||weight.getText().trim().equals("")||water.getText().trim().equals("")||depression.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(eatingpattern.this,"<html><font size=4 color=blue>Please enter all mandatory fields marked with star</font></html>","Error",JOptionPane.ERROR_MESSAGE,error);
				if(height.getText().trim().equals(""))
				height.requestFocus();
				if(weight.getText().trim().equals(""))
				weight.requestFocus();
			}
			else




			{
		try
		{
			 String str=(String)mid.getSelectedItem();	
			
			PreparedStatement prep=con.prepareStatement("insert into eatingpattern(mid,veg,exercise,obese,previousdiet,history,mainmeal,depression,dietician,water,stress,snack,hunger,tooth,eater,likes,menstrual,habits,reason,ht,wt)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String s=(String)dietician.getSelectedItem();
			String veggie=(String)combobox_1.getSelectedItem();
			prep.setString(1,str);
			prep.setString(2,veggie);
			prep.setString(3,exercise.getText());
			prep.setString(4,obese.getText());
			prep.setString(5,dietprog.getText());
			prep.setString(6,history.getText());
			prep.setString(7,meal.getText());
			prep.setString(8,depression.getText());
			prep.setString(9,s);
			prep.setString(10,water.getText());
			prep.setString(11,stress.getText());
			prep.setString(12,snack.getText());
			prep.setString(13,hungpeak.getText());
			prep.setString(14,tooth.getText());
				
			prep.setString(15,eater.getText());
			prep.setString(16,likes.getText());
			prep.setString(17,menstrual.getText());
			prep.setString(18,habits.getText());
			prep.setString(19,reason.getText());
			prep.setString(20,height.getText());
			prep.setString(21,weight.getText());


			//prep.setString(19,str);
			int updrow=prep.executeUpdate();
			if(updrow==1)
			{
			Icon tick=new ImageIcon("Check_h.gif");
			JOptionPane.showMessageDialog(eatingpattern.this,"<html><font size=4 color=green>Row Saved</font></html> ","Message",JOptionPane.ERROR_MESSAGE,tick);
			save.setEnabled(false);
			upd.setEnabled(true);
			}
			else
			{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(eatingpattern.this,"<html><font size=4 color=red>Could Not Save</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				
			}
			}
			catch(Exception e)
			{
 				System.out.println("Exception: " + e);
				
 			}

			}


		 }
		if(ae.getSource()==suggest1)
		{
			if(mid.getSelectedItem()=="----Select----")
			{
				Icon warn=new ImageIcon("Warning_h.gif");
				JOptionPane.showMessageDialog(eatingpattern.this,"<html><font size=4 color=red>First choose a member to view details.</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
			}
			else
			{
			suggest s=new suggest();
			s.setTitle("Diet Suggestion");
			String str=(String)mid.getSelectedItem();	
			s.passmid(str);
			s.setVisible(true);
			}

		}
		if(ae.getSource()==upd)
		{
			try
			{
			PreparedStatement prep=con.prepareStatement("update eatingpattern set veg=?,exercise=?,obese=?,previousdiet=?,history=?,mainmeal=?,depression=?,dietician=?,water=?,stress=?,snack=?,hunger=?,tooth=?,eater=?,likes=?,menstrual=?,habits=?,reason=?,ht=?,wt=? where mid=?");			
			String str=(String)mid.getSelectedItem();
			String veggie=(String)combobox_1.getSelectedItem();
			String s=(String)dietician.getSelectedItem();
			prep.setString(1,veggie);
			prep.setString(2,exercise.getText());
			prep.setString(3,obese.getText());
			prep.setString(4,dietprog.getText());
			prep.setString(5,history.getText());
			prep.setString(6,meal.getText());
			prep.setString(7,depression.getText());
			prep.setString(8,s);
			prep.setString(9,water.getText());
			prep.setString(10,stress.getText());
			prep.setString(11,snack.getText());
			prep.setString(12,hungpeak.getText());
			prep.setString(13,tooth.getText());
				
			prep.setString(14,eater.getText());
			prep.setString(15,likes.getText());
			prep.setString(16,menstrual.getText());
			prep.setString(17,habits.getText());
			prep.setString(18,reason.getText());
			prep.setString(19,height.getText());
			prep.setString(20,weight.getText());
			prep.setString(21,str);
				int upd=prep.executeUpdate();
				if(upd==1)
				{
				Icon tick=new ImageIcon("Check_h.gif");
				JOptionPane.showMessageDialog(eatingpattern.this,"<html><font size=4 color=green>Record Updated</font></html> ","Message",JOptionPane.ERROR_MESSAGE,tick);
				}
				else
				{
					Icon warn=new ImageIcon("Warning_h.gif");
					JOptionPane.showMessageDialog(eatingpattern.this,"<html><font size=4 color=red>Could Not Update</font></html>","Message",JOptionPane.ERROR_MESSAGE,warn);
				}
				
			}
			catch(Exception e)
			{
 				System.out.println("Exception: " + e);
				
			}

		}


	}
}
/*class eatingpatternLayout implements LayoutManager {

    public eatingpatternLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 740 + insets.left + insets.right;
        dim.height = 588 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+40,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+40,88,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+80,96,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+120,96,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+120,160,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+160,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+160,56,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+160,48,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+160,64,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+200,104,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+240,120,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+240,168,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+40,120,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+40,160,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+80,136,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+80,160,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+120,120,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+120,160,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+360,176,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+360,160,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+440,160,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+440,152,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+200,120,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+200,160,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+280,168,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+280,160,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+280,120,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+280,168,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+320,144,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+440,120,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+400,120,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+360,120,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+320,120,24);}
        c = parent.getComponent(33);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+240,144,24);}
        c = parent.getComponent(34);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+400,176,24);}
        c = parent.getComponent(35);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+160,144,24);}
        c = parent.getComponent(36);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+440,168,24);}
        c = parent.getComponent(37);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+400,168,24);}
        c = parent.getComponent(38);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+360,168,24);}
        c = parent.getComponent(39);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+320,168,24);}
        c = parent.getComponent(40);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+400,160,24);}
        c = parent.getComponent(41);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+160,160,24);}
        c = parent.getComponent(42);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+320,160,24);}
        c = parent.getComponent(43);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+240,160,24);}
        c = parent.getComponent(44);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+512,104,24);}
        c = parent.getComponent(45);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+512,104,24);}
        c = parent.getComponent(46);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+512,104,24);}
        c = parent.getComponent(47);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+200,168,24);}
        c = parent.getComponent(48);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+80,160,24);}
    }
}
*/

class eatingpatternLayout implements LayoutManager {

    public eatingpatternLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 740 + insets.left + insets.right;
        dim.height = 588 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+40,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+40,88,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+80,96,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+160,72,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+160,64,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+120,96,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+120,64,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+200,104,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+240,120,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+240,168,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+40,120,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+40,160,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+80,136,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+80,160,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+120,120,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+120,160,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+360,176,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+360,160,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+440,160,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+440,152,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+200,120,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+200,160,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+280,168,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+280,160,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+280,120,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+280,168,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+320,144,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+440,120,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+400,120,24);}
        c = parent.getComponent(29);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+360,120,24);}
        c = parent.getComponent(30);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+320,120,24);}
        c = parent.getComponent(31);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+240,144,24);}
        c = parent.getComponent(32);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+400,176,24);}
        c = parent.getComponent(33);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+160,144,24);}
        c = parent.getComponent(34);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+440,168,24);}
        c = parent.getComponent(35);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+400,168,24);}
        c = parent.getComponent(36);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+360,168,24);}
        c = parent.getComponent(37);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+320,168,24);}
        c = parent.getComponent(38);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+400,160,24);}
        c = parent.getComponent(39);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+160,160,24);}
        c = parent.getComponent(40);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+320,160,24);}
        c = parent.getComponent(41);
        if (c.isVisible()) {c.setBounds(insets.left+536,insets.top+240,160,24);}
        c = parent.getComponent(42);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+512,104,24);}
        c = parent.getComponent(43);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+512,104,24);}
        c = parent.getComponent(44);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+512,104,24);}
        c = parent.getComponent(45);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+200,168,24);}
        c = parent.getComponent(46);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+80,160,24);}
        c = parent.getComponent(47);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+120,72,24);}
        c = parent.getComponent(48);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+160,72,24);}
    }
}

