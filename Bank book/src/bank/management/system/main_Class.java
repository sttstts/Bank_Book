package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    main_Class(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label = new JLabel("Пожалуйста, выберите вашу транзакцию");
        label.setBounds(405, 180, 700, 35);
        label.setForeground(Color.BLACK);
        label.setBackground(Color.YELLOW);
        label.setFont(new Font("System", Font.BOLD, 26));
        l3.add(label);

        b1 = new JButton("Положить на счёт");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(430, 250, 150, 50);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Вывести со счёта");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(430, 315, 150, 50);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("Баланс карты");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(430, 380, 150, 50);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("Выход");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(700, 380, 150, 50);
        b4.addActionListener(this);
        l3.add(b4);

        setLayout(null);
        setSize(1250, 700);
        setLocation(0, 0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource() == b4) {
            System.exit(0);
        } else if (e.getSource()==b2) {
            new Withdrawl(pin);
            setVisible(false);
        } else if (e.getSource()==b3) {
            new BalanceEnquriy(pin);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new main_Class("");
    }
}

