import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Timetable extends JFrame {
    private JTextField nameInput;
    private JSpinner hours;
    private JSpinner minutes;
    private JButton addBtn;
    private JTextArea participantList;
    private JTextArea messageLog;
    private JPanel mainPanel;

    public Timetable() {
    addBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            switch (nameInput.getText()) {
                case " ", "", "enter a name here" -> messageLog.append("No valid name was entered \n");
                default -> {
                    participantList.append(nameInput.getText() + " at " + hours.getValue() + ':' + minutes.getValue());
                    messageLog.append("The participant was added \n");
                }
            }
        }
    });
}

    public static void main(String[]args){
        Timetable timetable = new Timetable();
        timetable.setContentPane(timetable.mainPanel);
        timetable.setTitle("Appointment planner");
        timetable.setSize(500, 800);
        timetable.setVisible(true);
        timetable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
