/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mcs
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.management.Query.div;

public class ATMGUI extends JFrame {
    private BankAccount account;

    private JTextField amountField;
    private JTextArea messageArea;

    public ATMGUI(BankAccount account) {
        this.account = account;

        setTitle("ATM Machine");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Set layout to null for absolute positioning

        // Define panel here
        JPanel panel = new JPanel();
        panel.setLayout(null); // Set layout to null for absolute positioning
        panel.setBounds(0, 0, 500, 500);
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel);

        JLabel amountLabel = new JLabel("<html><b>Amount:</b></html>");
        amountLabel.setBounds(50, 50, 100, 30);
        panel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(160, 50, 200, 30);
        panel.add(amountField);

        JButton withdrawButton = new JButton("<html><b>Withdraw</b></html>");
        withdrawButton.setBounds(50, 100, 120, 30);
        panel.add(withdrawButton);

        JButton depositButton = new JButton("<html><b>Deposit</b></html>");
        depositButton.setBounds(180, 100, 120, 30);
        panel.add(depositButton);

        JButton balanceButton = new JButton("<html><b>Check Balance</b></html>");
        balanceButton.setBounds(310, 100, 120, 30);
        panel.add(balanceButton);

        messageArea = new JTextArea();
        messageArea.setBounds(50, 150, 380, 200);
        panel.add(messageArea);

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                if (account.withdraw(amount)) {
                    showMessage("Withdrawal successful");
                } else {
                    showMessage("Insufficient balance or invalid amount");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                showMessage("Deposit successful");
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance = account.checkBalance();
                showMessage("Current Balance: Rs: " + balance);
            }
        });
    }

    private void showMessage(String message) {
    messageArea.setText(message);
    }


    public static void main(String[] args) {
        // Create a bank account with initial balance of $1000
        BankAccount account = new BankAccount(1000);
        ATMGUI atmGUI = new ATMGUI(account);
        atmGUI.setVisible(true);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false; // Insufficient balance
        }
    }

    public double checkBalance() {
        return balance;
    }
}
