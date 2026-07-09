import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class FeeCalculator extends JFrame implements ActionListener {

    // Components
    JTextField semField, categoryField;
    JLabel resultLabel, dueDateLabel;
    JButton calcBtn, resetBtn, exitBtn;

    public FeeCalculator() {

        setTitle("SmartFee");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        setLayout(new GridLayout(10, 2, 10, 10));

        // Background color
        getContentPane().setBackground(new Color(230, 240, 255));

        // ===== TITLE =====
        JLabel titleLabel = new JLabel("SMARTFEE", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(new Color(0, 51, 102));

        add(titleLabel);
        add(new JLabel(""));

        // ===== COLLEGE =====
        JLabel collegeLabel = new JLabel("SJCIT", SwingConstants.CENTER);
        collegeLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        collegeLabel.setForeground(new Color(153, 0, 0));

        add(collegeLabel);
        add(new JLabel(""));

        JLabel deptLabel = new JLabel("Dept. of CSE", SwingConstants.CENTER);
        deptLabel.setFont(new Font("Arial", Font.BOLD, 18));
        deptLabel.setForeground(new Color(102, 0, 153));

        add(deptLabel);
        add(new JLabel(""));

        // ===== Semester Input =====
        JLabel semLabel = new JLabel("Enter Semester [1-8]:");
        semLabel.setForeground(Color.BLUE);
        semLabel.setFont(new Font("Arial", Font.BOLD, 14));

        add(semLabel);

        semField = new JTextField();
        semField.setBackground(Color.WHITE);
        add(semField);

        // ===== Category Input =====
        JLabel catLabel = new JLabel("Category [GEN/SC/ST/MGMT]:");
        catLabel.setForeground(Color.BLUE);
        catLabel.setFont(new Font("Arial", Font.BOLD, 14));

        add(catLabel);

        categoryField = new JTextField();
        categoryField.setBackground(Color.WHITE);
        add(categoryField);

        // ===== Buttons =====
        calcBtn = new JButton("Calculate Fees");
        resetBtn = new JButton("Reset");
        exitBtn = new JButton("Exit");

        // Button Colors
        calcBtn.setBackground(new Color(0, 153, 76));
        calcBtn.setForeground(Color.WHITE);

        resetBtn.setBackground(new Color(255, 153, 0));
        resetBtn.setForeground(Color.WHITE);

        exitBtn.setBackground(new Color(204, 0, 0));
        exitBtn.setForeground(Color.WHITE);

        // Action Listeners
        calcBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        add(calcBtn);
        add(resetBtn);

        // ===== Result Section =====
        JLabel feeLabel = new JLabel("Total Fees:");
        feeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        feeLabel.setForeground(new Color(102, 0, 153));

        add(feeLabel);

        resultLabel = new JLabel("₹ 0");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setForeground(new Color(0, 102, 0));

        add(resultLabel);

        // ===== Due Date =====
        JLabel dueLabel = new JLabel("Last Date:");
        dueLabel.setFont(new Font("Arial", Font.BOLD, 15));
        dueLabel.setForeground(new Color(102, 0, 153));

        add(dueLabel);

        dueDateLabel = new JLabel("-");
        dueDateLabel.setFont(new Font("Arial", Font.BOLD, 16));
        dueDateLabel.setForeground(Color.RED);

        add(dueDateLabel);

        // ===== Footer =====
        add(exitBtn);

        JLabel footer = new JLabel("SmartFee 2026");
        footer.setForeground(Color.DARK_GRAY);

        add(footer);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // ===== Calculate Fees =====
        if (e.getSource() == calcBtn) {

            try {

                int sem = Integer.parseInt(semField.getText());
                String category = categoryField.getText().toUpperCase();

                // Semester Validation
                if (sem < 1 || sem > 8) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Semester must be between 1 and 8");

                    return;
                }

                int baseFee = 45000;
                double total = baseFee;

                // Category Logic
                switch (category) {

                    case "SC":
                    case "ST":
                        total = baseFee * 0.1;
                        break;

                    case "MGMT":
                        total = baseFee * 1.5;
                        break;

                    case "GEN":
                        total = baseFee;
                        break;

                    default:

                        JOptionPane.showMessageDialog(
                                this,
                                "Invalid category");

                        return;
                }

                // CSE Lab Fee
                total += 3000;

                // Exam Fee
                total += (sem % 2 == 1) ? 1800 : 1500;

                // Display Total
                resultLabel.setText(
                        "₹ " + String.format("%.0f", total));

                // Due Date
                LocalDate dueDate = LocalDate.now().plusDays(15);

                dueDateLabel.setText(
                        dueDate.format(
                                DateTimeFormatter.ofPattern("dd-MM-yyyy")));

            }

            catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Enter valid semester number");
            }
        }

        // ===== Reset =====
        else if (e.getSource() == resetBtn) {

            semField.setText("");
            categoryField.setText("");

            resultLabel.setText("₹ 0");
            dueDateLabel.setText("-");
        }

        // ===== Exit =====
        else if (e.getSource() == exitBtn) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new FeeCalculator();
    }
}