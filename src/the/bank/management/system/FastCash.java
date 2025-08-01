
package the.bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 700, 800);
        add(l3);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 14));

        b1 = new JButton("Rs 100");
        b1.setFont(new Font("System", Font.BOLD, 10));
        b2 = new JButton("Rs 500");
        b2.setFont(new Font("System", Font.BOLD, 10));
        b3 = new JButton("Rs 1000");
        b3.setFont(new Font("System", Font.BOLD, 10));
        b4 = new JButton("Rs 2000");
        b4.setFont(new Font("System", Font.BOLD, 10));
        b5 = new JButton("Rs 5000");
        b5.setFont(new Font("System", Font.BOLD, 10));
        b6 = new JButton("Rs 10000");
        b6.setFont(new Font("System", Font.BOLD, 10));
        b7 = new JButton("BACK");
        b7.setFont(new Font("System", Font.BOLD, 10));

        setLayout(null);

        l1.setBounds(140, 260, 700, 35);
        l3.add(l1);

        b1.setBounds(140, 370, 100, 25);
        l3.add(b1);

        b2.setBounds(290, 370, 100, 25);
        l3.add(b2);

        b3.setBounds(140, 400, 100, 25);
        l3.add(b3);

        b4.setBounds(290, 400, 100, 25);
        l3.add(b4);

        b5.setBounds(140, 430, 100, 25);
        l3.add(b5);

        b6.setBounds(290, 430, 100, 25);
        l3.add(b6);

        b7.setBounds(290, 460, 100, 25);
        l3.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(700, 800);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } String num = "17";
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String args[]) {
        new FastCash("").setVisible(true);
    }
}

