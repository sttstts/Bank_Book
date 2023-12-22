package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup2 extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JButton s,c;
    String formno;
    Signup2(String formno){

        this.formno = formno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        JLabel l1 = new JLabel("Страница 2:");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel l2 = new JLabel("Детали аккаунта");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(280,70,400,40);
        add(l2);

        JLabel l3 = new JLabel("Тип карты:");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,140,200,30);
        add(l3);

        r1 = new JRadioButton("Дебетовая карта");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,170,30);
        add(r1);

        r2 = new JRadioButton("Кредитная карта");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,170,30);
        add(r2);

        r3 = new JRadioButton("Предоплаченная карта");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,220,30);
        add(r3);

        r4 = new JRadioButton("Овердрафтная карта");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,200,30);
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel l4 = new JLabel("Номер карты:");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(100,300,200,30);
        add(l4);

        JLabel l5 = new JLabel("(Ваш 16-значный номер карты)");
        l5.setFont(new Font("Raleway",Font.BOLD,12));
        l5.setBounds(100,330,200,20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-4841");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(330,300,250,30);
        add(l6);

        JLabel l7 = new JLabel("Это будет отображаться на карте банкомата/чековой книжке и в выписках");
        l7.setFont(new Font("Raleway",Font.BOLD,12));
        l7.setBounds(330,330,500,20);
        add(l7);

        JLabel l8 = new JLabel("PIN-код:");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100,370,200,30);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(330,370,200,30);
        add(l9);

        JLabel l10 = new JLabel("(4-значный пароль)");
        l10.setFont(new Font("Raleway",Font.BOLD,12));
        l10.setBounds(100,400,200,20);
        add(l10);

        JCheckBox c7 = new JCheckBox("Я заявляю, что, насколько мне известно, введенные мной данные верны.",true);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,440,600,20);
        add(c7);

        JLabel l12 = new JLabel("Регистрация No : ");
        l12.setFont(new Font("Raleway", Font.BOLD,14));
        l12.setBounds(500,10,150,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD,14));
        l13.setBounds(760,10,60,30);
        add(l13);


        s = new JButton("Подтвердить");
        s.setFont(new Font("Raleway", Font.BOLD,14));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(250,480,150,30);
        s.addActionListener(this);
        add(s);

        c = new JButton("Закрыть");
        c.setFont(new Font("Raleway", Font.BOLD,14));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(420,480,100,30);
        c.addActionListener(this);
        add(c);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);

        getContentPane().setBackground(new Color(215,252,252));
        setSize(850,565);
        setLayout(null);
        setLocation(400,20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String atype = null;
        if (r1.isSelected()){
            atype = "Дебетовая карта";
        } else if (r2.isSelected()) {
            atype ="Кредитная карта";
        }else if (r3.isSelected()){
            atype ="Предоплаченная карта";
        }else if (r4.isSelected()){
            atype = "Овердрафтная карта";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L)+ 1000L;
        String pin = "" + Math.abs(first3);

        try {
            if (e.getSource()==s){
                if (atype.equals("")){
                    JOptionPane.showMessageDialog(null,"Заполните все поля");
                }else {
                    Conn c1 = new Conn();
                    String q1 = "insert into signuptwo values('"+formno+"', '"+atype+"','"+cardno+"','"+pin+"')";
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n Pin : "+pin );
                    new main_Class(pin);
                    setVisible(false);
                }
            } else if (e.getSource()==c) {
                System.exit(0);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
