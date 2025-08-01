
package the.bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    
    Transactions(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 700, 800);
        add(l2);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 14));
        
       
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 10));
        b2 = new JButton("WITHDRAWL");
        b2.setFont(new Font("System", Font.BOLD, 10));
        b3 = new JButton("FAST CASH");
        b3.setFont(new Font("System", Font.BOLD, 10));
        b4 = new JButton("STATEMENT");
        b4.setFont(new Font("System", Font.BOLD, 10));
        b5 = new JButton("CHANGE PIN");
        b5.setFont(new Font("System", Font.BOLD, 10));
        b6 = new JButton("BALANCE");
        b6.setFont(new Font("System", Font.BOLD, 10));
        b7 = new JButton("EXIT");
        b7.setFont(new Font("System", Font.BOLD, 10));
        
        setLayout(null);
        
        l1.setBounds(140,260,700,35);
        l2.add(l1);
        
        b1.setBounds(140,370,100,25);
        l2.add(b1);
        
        b2.setBounds(290,370,100,25);
        l2.add(b2);
        
        b3.setBounds(140,400,100,25);
        l2.add(b3);
        
        b4.setBounds(290,400,100,25);
        l2.add(b4);
        
        b5.setBounds(140,430,100,25);
        l2.add(b5);
        
        b6.setBounds(290,430,100,25);
        l2.add(b6);
        
        b7.setBounds(290,460,100,25);
        l2.add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        
        setSize(700,800);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==b2){ 
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource()==b3){ 
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource()==b4){ 
            new MiniStatement(pin).setVisible(true);
        }else if(ae.getSource()==b5){ 
            setVisible(false);
            new Pin(pin).setVisible(true);
        }else if(ae.getSource()==b6){ 
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }else if(ae.getSource()==b7){ 
            System.exit(0);
        }
    }
    public static void main(String args[]) {
        new Transactions("").setVisible(true);
    }
}
