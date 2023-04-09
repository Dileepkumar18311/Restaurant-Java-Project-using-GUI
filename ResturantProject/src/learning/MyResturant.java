package learning;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

/**
 *
 * @author Dileep kumar
 */
class MyResturant extends JFrame {
    JLabel Customer,name,Contact, Foods,Drinks,Type;
    JTextField tfNumber, tfContact,tfName;
    JButton reset, print,receipt;
    JComboBox cb1, cb2;
    JRadioButton r1, r2;
    JTextArea area1,area2;
    int total,dprice,fprice;
    MyResturant()
    {
        setTitle("Resturant and Coffee");
        setSize(700,500);
        setLayout(null);

        Customer= new JLabel("Customer No:");
        Customer.setBounds(20,50, 120, 30);

        name= new JLabel("Name: ");
        name.setBounds(20,100, 120, 30);

        Contact= new JLabel("Contact No:");
        Contact.setBounds(20,150, 120, 30);

        Foods= new JLabel("Foods:");
        Foods.setBounds(20,200, 120, 30);
        String foods[]={"Pizza","KFC","Burger"};
        cb1=new JComboBox(foods);
        cb1.setBounds(200,200,120,30);

        Drinks= new JLabel("Drinks:");
        Drinks.setBounds(20,250, 120, 30);
        String drinks[]={"Pepsi","String","Cock","Dew"};
        cb2=new JComboBox(drinks);
        cb2.setBounds(200,250,120,30);

        Type= new JLabel("Type:");
        Type.setBounds(20,300, 120, 30);
        r1=new JRadioButton("Diet");
        r2=new JRadioButton("Normal");
        r1.setBounds(200,300,60,30);
        r2.setBounds(300,300,60,30);
        ButtonGroup bg= new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        tfNumber=new JTextField();
        tfNumber.setBounds(150,50,200,30);


        tfName=new JTextField();
        tfName.setBounds(150,100,200,30);

        tfContact=new JTextField();
        tfContact.setBounds(150,150,200,30);



        reset=new JButton("reset");
        reset.setBounds(400,100,80,40);
        getContentPane().add(reset);
        receipt= new JButton("Receipt");
        receipt.setBounds(480,100,80,40);
        getContentPane().add(receipt);
        print=new JButton("Print");
        print.setBounds(560,100,80,40);
        getContentPane().add(print);

        area1=new JTextArea();
        area1.setBounds(400,140,240,200);
        getContentPane().add(area1);



        getContentPane().add(Customer);
        getContentPane().add(tfNumber);
        getContentPane().add(name);
        getContentPane().add(tfName);
        getContentPane().add(Contact);
        getContentPane().add(tfContact);
        getContentPane().add(Foods);
        getContentPane().add(cb1);
        getContentPane().add(Drinks);
        getContentPane().add(cb2);
        getContentPane().add(Type);
        getContentPane().add(r1);
        getContentPane().add(r2);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNumber.setText("");
                tfContact.setText("");
                tfName.setText("");

                area1.setText("");
            }
        });

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    area1.print();
                } catch (PrinterException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        receipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               area1.setText("Happy Resturant and Coffe\n");
               area1.setText(area1.getText()+
                       "Customer Number :  "+ tfNumber.getText()
               + "\nName :  "+ tfName.getText()
               + "\nContact :  " +tfContact.getText());

               area1.setText(area1.getText()+
                       "\nFood : "+
                       cb2.getSelectedItem());

                area1.setText(area1.getText()+
                        "\nDrinks : "+
                        cb2.getSelectedItem());

                if(cb1.getSelectedIndex()==0)
                {
                   fprice=200;
                }
                if (cb1.getSelectedIndex()==1)
                {
                    fprice=300;
                }
                if (cb1.getSelectedIndex()==2)
                {
                    fprice=400;
                }

                if (cb2.getSelectedIndex()==0)
                {
                    dprice=200;
                    total=fprice+dprice;
                    area1.setText(area1.getText()+ "\nTotal: "+total);
                }
                if (cb2.getSelectedIndex()==1)
                {
                    dprice=300;
                    total=fprice+dprice;
                    area1.setText(area1.getText()+ "\nTotal: "+total);
                }
                if (cb2.getSelectedIndex()==2)
                {
                    dprice=400;
                    total=fprice+dprice;
                    area1.setText(area1.getText()+ "\nTotal: "+total);
                }
            }
        });


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new MyResturant();
    }

    private Object getConentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
