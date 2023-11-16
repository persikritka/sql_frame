package listener;

import database.ConnectorToDatabase;
import service.StudentService;
import service.impl.StudentImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {


        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame, true);
        dialog.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel deleteLabel = new JLabel("Enter id");
        JTextField deleteField = new JTextField(10);
        dialog.add(deleteLabel);
        dialog.add(deleteField);

        JButton btn = new JButton("OK");

        StudentService studentService = new StudentImpl();
        ConnectorToDatabase connectorToDatabase = new ConnectorToDatabase();

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(deleteField.getText());
                try {
                    studentService.delete(id);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dialog.setVisible(false);
            }
        });

        dialog.add(btn);

        dialog.setSize(500,400);
        dialog.setTitle("Dialog Window");
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}

