package listener;

import database.ConnectorToDatabase;
import service.StudentService;
import service.impl.StudentImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {


        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame, true);
        GridLayout grid = new GridLayout(6, 2, 5, 12);
       // dialog.setLayout(new FlowLayout(FlowLayout.LEFT));
        dialog.setLayout(grid);
        JLabel displayText = new JLabel("Enter student data");
        JLabel text = new JLabel("");
        dialog.add(displayText);
        dialog.add(text);
        // JPanel namePanel = new JPanel(new FlowLayout());
        // dialog.add(namePanel);
        JLabel nameLabel = new JLabel("Name");
        JTextField nameField = new JTextField(10);
        // namePanel.add(nameLabel);
        // namePanel.add(nameField);
        dialog.add(nameLabel);
        dialog.add(nameField);

        // JPanel surnamePanel = new JPanel(new FlowLayout());
        // dialog.add(surnamePanel);
        JLabel surnameLabel = new JLabel("Surname");
        JTextField surnameField = new JTextField(10);
        // namePanel.add(surnameLabel);
        // namePanel.add(surnameField);
        dialog.add(surnameLabel);
        dialog.add(surnameField);

        JLabel dateLabel = new JLabel("Date of birthday");
        JTextField dateField = new JTextField(10);
        dialog.add(dateLabel);
        dialog.add(dateField);

        JLabel idSexLabel = new JLabel("ID sex");
        JTextField idSexField = new JTextField(10);
        dialog.add(idSexLabel);
        dialog.add(idSexField);

        JButton btn = new JButton("OK");

        StudentService studentService = new StudentImpl();
        ConnectorToDatabase connectorToDatabase = new ConnectorToDatabase();

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String surname = surnameField.getText();
                String date = dateField.getText();
                int idSex = Integer.parseInt(idSexField.getText());
                try {
                    studentService.insert(name, surname, date, idSex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dialog.setVisible(false);
            }
        });

        dialog.add(btn);
        dialog.pack();
        //dialog.setSize(500,400);
        dialog.setTitle("Dialog Window");
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
