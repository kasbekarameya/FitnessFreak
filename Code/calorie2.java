//package gym.com.freak.diet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.*;
//import gym.com.valid.*;

public class calorie2 extends JFrame implements ActionListener{
    NumericTextField1 txtage;
    JLabel gender;
    JLabel age;
    ButtonGroup cbg;
    JRadioButton rdfemale;
    JRadioButton rdmale;
    JLabel ht;
    NumericTextField txtcms;
    JLabel wt;
    NumericTextField txtwt;
    JLabel kg;
    JLabel result;
    JLabel activeness;
    JComboBox cmbactive;
    JButton calorie;
    JLabel intake;
    JLabel calneed;
    JLabel bmr;
    JTextField txtcalneed;
    JTextField txtbmr;
    JLabel fat;
    JLabel protein;
    JLabel carb;
    JTextField txtfat;
    JTextField txtpro;
    JTextField txtcarb;
    JLabel lblcms;
    JLabel unit1;
    JLabel unit2;
    JLabel unit3;

    public calorie2() {
        calorieLayout customLayout = new calorieLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        txtage = new NumericTextField1();
        getContentPane().add(txtage);

        gender = new JLabel("Gender");
        getContentPane().add(gender);

        age = new JLabel("Age");
        getContentPane().add(age);

        cbg = new ButtonGroup();
        rdfemale = new JRadioButton("Female", false);
        cbg.add(rdfemale);
        getContentPane().add(rdfemale);

        rdmale = new JRadioButton("Male", true);
        cbg.add(rdmale);
        getContentPane().add(rdmale);

        ht = new JLabel("Height");
        getContentPane().add(ht);

        txtcms = new NumericTextField();
        getContentPane().add(txtcms);

        wt = new JLabel("Weight");
        getContentPane().add(wt);

        txtwt = new NumericTextField();
        getContentPane().add(txtwt);

        kg = new JLabel("Kg");
        getContentPane().add(kg);

        result = new JLabel("Calorie-Result");
        getContentPane().add(result);

        activeness = new JLabel("Activeness");
        getContentPane().add(activeness);

        cmbactive = new JComboBox();
        cmbactive.addItem("Sedanatry");
        cmbactive.addItem("Light Active");
        cmbactive.addItem("Moderately Active");
        cmbactive.addItem("Very Active");
        cmbactive.addItem("Extra Active");
        getContentPane().add(cmbactive);

        calorie = new JButton("Calculate Calorie");
        getContentPane().add(calorie);
        calorie.addActionListener(this);

        intake = new JLabel("You must intake the following daily");
        getContentPane().add(intake);

        calneed = new JLabel("Calorie Needed");
        getContentPane().add(calneed);

        bmr = new JLabel("BMR");
        getContentPane().add(bmr);

        txtcalneed = new JTextField("");
        getContentPane().add(txtcalneed);

        txtbmr = new JTextField("");
        getContentPane().add(txtbmr);

        fat = new JLabel("Fat");
        getContentPane().add(fat);

        protein = new JLabel("Protein");
        getContentPane().add(protein);

        carb = new JLabel("Carbohydrate");
        getContentPane().add(carb);

        txtfat = new JTextField("");
        getContentPane().add(txtfat);

        txtpro = new JTextField("");
        getContentPane().add(txtpro);

        txtcarb = new JTextField("");
        getContentPane().add(txtcarb);

        lblcms = new JLabel("cms");
        getContentPane().add(lblcms);

        unit1 = new JLabel("gms/day");
        getContentPane().add(unit1);

        unit2 = new JLabel("gms/day");
        getContentPane().add(unit2);

        unit3 = new JLabel("gms/day");
        getContentPane().add(unit3);
		

        setSize(getPreferredSize());
		setUndecorated(true);
       getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                txtage.setText("");
				txtcms.setText("");
				txtwt.setText("");
				txtbmr.setText("");
				txtcalneed.setText("");
				txtfat.setText("");
				txtpro.setText("");
				txtcarb.setText("");
            }
        });
    }

    public static void main(String args[]) {
        calorie2 window = new calorie2();
       
		try {
            			// select Look and Feel
	      	         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
				     SwingUtilities.updateComponentTreeUI(window);

	          
        		}
        	catch (Exception ex) {
            	//ex.printStackTrace();
				System.out.println(ex);
        	}

        window.setTitle("Calorie Counter");
        window.pack();
        window.show();
    }

	public void actionPerformed(ActionEvent ie)
	{
		
		if(txtwt.getText().trim().equals("")||txtage.getText().trim().equals("")||txtcms.getText().trim().equals(""))
			{ 
	
				Icon error=new ImageIcon("error.png");
				JOptionPane.showMessageDialog(calorie2.this,"<html><font size=4 color=red>Please enter all fields </font></html> \n\t\t Please fill all the details","Error",JOptionPane.ERROR_MESSAGE,error);
				if(txtage.getText().trim().equals(""))
				txtage.requestFocus();
			}
			else
		{
		
			float wt= Float.parseFloat(txtwt.getText());
			float ht=Float.parseFloat(txtcms.getText());	
			float age=Float.parseFloat(txtage.getText());
			String level=(String)cmbactive.getSelectedItem();
			double bmr2;
            if(rdmale.isSelected()==true)
		{

			 bmr2=Math.round(66+ (13.7 * wt) + (5 * ht) + (6.8 * age));
			txtcalneed.setText(String.valueOf(bmr2));
		}	
		else
		{
			 bmr2=Math.round(655+ (9.6 * wt) + (1.8 * ht) + (4.7 * age));
			txtcalneed.setText(String.valueOf(bmr2));
		}
		
			
			double fneed=Math.round((bmr2*0.25)/9);
			txtfat.setText(String.valueOf(fneed));

			double pneed=Math.round((bmr2*0.25)/4);
			txtpro.setText(String.valueOf(pneed));

			double crneed=Math.round((bmr2*0.25)/4);
			txtcarb.setText(String.valueOf(crneed));
			
			if(level=="Sedentary")
			{
				double sed=Math.round(bmr2*1.2);
				txtbmr.setText(String.valueOf(sed));
			}
			else if(level=="Light Active")
			{
				double light=Math.round(bmr2*1.37);
				txtbmr.setText(String.valueOf(light));

             			}
			else if(level=="Moderately Active")
			{
				double mlight=Math.round(bmr2*1.55);
				txtbmr.setText(String.valueOf(mlight));

             			}
			else if(level=="Very Active")
			{
				double vactive=Math.round(bmr2*1.73);
				txtbmr.setText(String.valueOf(vactive));

             			}
			else
			{
				double eactive=Math.round(bmr2*1.9);
				txtbmr.setText(String.valueOf(eactive));

             			}

			
		}
		

	}			

}

class calorieLayout implements LayoutManager {

    public calorieLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 534 + insets.left + insets.right;
        dim.height = 541 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+40,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+72,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+40,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+72,72,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+72,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+104,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+104,56,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+136,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+136,72,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+320,insets.top+136,40,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+256,96,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+168,80,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+168,120,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+216,136,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+360,200,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+328,104,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+296,80,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+296,112,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+328,112,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+400,72,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+432,72,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+464,80,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+400,96,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+432,96,24);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+464,96,24);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+304,insets.top+104,40,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+400,72,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+432,72,24);}
        c = parent.getComponent(28);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+464,72,24);}
    }
}
