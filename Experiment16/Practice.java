package Experiment16;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Practice extends JFrame {

    public Practice() {
        setTitle("Experiment 16");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 1));

        add(button("Student Form", e -> studentForm()));
        add(button("Calculator", e -> calculator()));
        add(button("Movie Booking", e -> movie()));
        add(button("Library Issue", e -> library()));
        add(button("Feedback", e -> feedback()));
        add(button("Salary Slip", e -> salary()));
        add(button("ToDo", e -> todo()));
        add(button("Eligibility", e -> eligibility()));
        add(button("Currency", e -> currency()));
        add(button("Hospital", e -> hospital()));

        setVisible(true);
    }

    JButton button(String text, ActionListener a) {
        JButton b = new JButton(text);
        b.addActionListener(a);
        return b;
    }

    void studentForm() {
        JFrame f = new JFrame("Student Form");
        f.setSize(300, 300);
        f.setLayout(new GridLayout(6,2));

        JTextField name = new JTextField();
        JTextField roll = new JTextField();
        JTextField branch = new JTextField();
        JTextField sem = new JTextField();
        JTextField contact = new JTextField();

        JButton submit = new JButton("Submit");

        f.add(new JLabel("Name")); f.add(name);
        f.add(new JLabel("Roll")); f.add(roll);
        f.add(new JLabel("Branch")); f.add(branch);
        f.add(new JLabel("Sem")); f.add(sem);
        f.add(new JLabel("Contact")); f.add(contact);
        f.add(submit);

        submit.addActionListener(e -> {
            JOptionPane.showMessageDialog(f,
                    name.getText()+" "+roll.getText()+" "+branch.getText());
        });

        f.setVisible(true);
    }

    void calculator() {
        JFrame f = new JFrame("Calculator");
        f.setSize(300,200);
        f.setLayout(new GridLayout(3,2));

        JTextField a = new JTextField();
        JTextField b = new JTextField();
        JLabel res = new JLabel();

        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton mul = new JButton("*");
        JButton div = new JButton("/");

        ActionListener calc = e -> {
            try {
                double x = Double.parseDouble(a.getText());
                double y = Double.parseDouble(b.getText());
                if(e.getSource()==add) res.setText(""+(x+y));
                if(e.getSource()==sub) res.setText(""+(x-y));
                if(e.getSource()==mul) res.setText(""+(x*y));
                if(e.getSource()==div) res.setText(y==0?"Error":""+(x/y));
            } catch(Exception ex){ res.setText("Invalid"); }
        };

        add.addActionListener(calc);
        sub.addActionListener(calc);
        mul.addActionListener(calc);
        div.addActionListener(calc);

        f.add(a); f.add(b);
        f.add(add); f.add(sub);
        f.add(mul); f.add(div);
        f.add(res);

        f.setVisible(true);
    }

    void movie() {
        JFrame f = new JFrame("Movie");
        f.setSize(300,200);
        f.setLayout(new GridLayout(5,2));

        String[] movies = {"A","B"};
        String[] time = {"10AM","5PM"};
        String[] seat = {"Gold","Silver"};

        JComboBox m = new JComboBox(movies);
        JComboBox t = new JComboBox(time);
        JComboBox s = new JComboBox(seat);
        JTextField qty = new JTextField();

        JButton book = new JButton("Book");

        f.add(new JLabel("Movie")); f.add(m);
        f.add(new JLabel("Time")); f.add(t);
        f.add(new JLabel("Seat")); f.add(s);
        f.add(new JLabel("Qty")); f.add(qty);
        f.add(book);

        book.addActionListener(e -> {
            int q = Integer.parseInt(qty.getText());
            int price = s.getSelectedItem().equals("Gold")?200:100;
            JOptionPane.showMessageDialog(f,"Total: "+(q*price));
        });

        f.setVisible(true);
    }

    void library() {
        JFrame f = new JFrame("Library");
        f.setSize(300,250);
        f.setLayout(new GridLayout(5,2));

        JTextField id = new JTextField();
        JTextField book = new JTextField();
        JTextField issue = new JTextField();
        JTextField ret = new JTextField();
        JTextArea area = new JTextArea();

        JButton issueBtn = new JButton("Issue");
        JButton clear = new JButton("Clear");

        f.add(id); f.add(book);
        f.add(issue); f.add(ret);
        f.add(issueBtn); f.add(clear);
        f.add(area);

        issueBtn.addActionListener(e -> {
            area.setText("Issued: "+book.getText());
        });

        clear.addActionListener(e -> area.setText(""));

        f.setVisible(true);
    }

    void feedback() {
        JFrame f = new JFrame("Feedback");
        f.setSize(300,250);
        f.setLayout(new GridLayout(5,1));

        JRadioButton good = new JRadioButton("Good");
        JRadioButton avg = new JRadioButton("Average");
        JCheckBox ui = new JCheckBox("UI");
        JCheckBox speed = new JCheckBox("Speed");
        JButton submit = new JButton("Submit");

        ButtonGroup bg = new ButtonGroup();
        bg.add(good); bg.add(avg);

        f.add(good); f.add(avg);
        f.add(ui); f.add(speed);
        f.add(submit);

        submit.addActionListener(e -> {
            JOptionPane.showMessageDialog(f,"Submitted");
        });

        f.setVisible(true);
    }

    void salary() {
        JFrame f = new JFrame("Salary");
        f.setSize(300,200);
        f.setLayout(new GridLayout(4,2));

        JTextField name = new JTextField();
        JTextField id = new JTextField();
        JTextField sal = new JTextField();
        JTextArea out = new JTextArea();

        JButton gen = new JButton("Generate");

        f.add(name); f.add(id);
        f.add(sal); f.add(gen);
        f.add(out);

        gen.addActionListener(e -> {
            double s = Double.parseDouble(sal.getText());
            double net = s + s*0.2 + s*0.1 - s*0.05;
            out.setText("Net: "+net);
        });

        f.setVisible(true);
    }

    void todo() {
        JFrame f = new JFrame("Todo");
        f.setSize(300,250);
        f.setLayout(new BorderLayout());

        DefaultListModel model = new DefaultListModel();
        JList list = new JList(model);
        JTextField task = new JTextField();

        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");

        add.addActionListener(e -> model.addElement(task.getText()));
        remove.addActionListener(e -> model.remove(list.getSelectedIndex()));

        f.add(task, BorderLayout.NORTH);
        f.add(new JScrollPane(list), BorderLayout.CENTER);
        JPanel p = new JPanel();
        p.add(add); p.add(remove);
        f.add(p, BorderLayout.SOUTH);

        f.setVisible(true);
    }

    void eligibility() {
        JFrame f = new JFrame("Eligibility");
        f.setSize(300,200);
        f.setLayout(new GridLayout(3,1));

        JTextField marks = new JTextField();
        JButton check = new JButton("Check");

        f.add(marks); f.add(check);

        check.addActionListener(e -> {
            int m = Integer.parseInt(marks.getText());
            JOptionPane.showMessageDialog(f, m>=60?"Eligible":"Not Eligible");
        });

        f.setVisible(true);
    }

    void currency() {
        JFrame f = new JFrame("Currency");
        f.setSize(300,200);
        f.setLayout(new GridLayout(3,2));

        JTextField amt = new JTextField();
        String[] c = {"INR","USD"};
        JComboBox from = new JComboBox(c);
        JComboBox to = new JComboBox(c);

        JButton convert = new JButton("Convert");
        JLabel res = new JLabel();

        f.add(amt); f.add(from);
        f.add(to); f.add(convert);
        f.add(res);

        convert.addActionListener(e -> {
            double a = Double.parseDouble(amt.getText());
            if(from.getSelectedItem().equals("INR") && to.getSelectedItem().equals("USD"))
                res.setText(""+(a/80));
            else
                res.setText(""+(a*80));
        });

        f.setVisible(true);
    }

    void hospital() {
        JFrame f = new JFrame("Hospital");
        f.setSize(300,250);
        f.setLayout(new GridLayout(5,2));

        JTextField name = new JTextField();
        JTextField doc = new JTextField();
        JTextField date = new JTextField();
        JTextField time = new JTextField();

        JButton book = new JButton("Book");

        f.add(name); f.add(doc);
        f.add(date); f.add(time);
        f.add(book);

        book.addActionListener(e -> {
            JOptionPane.showMessageDialog(f,"Booked for "+name.getText());
        });

        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Practice();
    }
}