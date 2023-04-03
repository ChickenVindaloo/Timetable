import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class Timetable extends JFrame {
    private JTextField nameInput;
    SpinnerNumberModel hourModel = new SpinnerNumberModel(12, 0, 23, 1);
    private JSpinner hoursSpinner;
    SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 59, 1);
    private JSpinner minutesSpinner;
    private JButton addBtn;
    private JTextArea participantList;
    private JTextArea messageLog;
    private JPanel mainPanel;

    public Timetable() {
        //limit spinner range
        hoursSpinner.setModel(hourModel);
        minutesSpinner.setModel(minuteModel);

        //event listener for when the button is clicked
        addBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            switch (nameInput.getText()) {
                //check if a name was entered
                case " ", "", "enter a name here" -> messageLog.append("No valid name was entered \n");
                default -> { //if a name was entered, add the appointment
                    int minutes = (int) minutesSpinner.getValue();
                    if (minutes < 10) {
                        participantList.append(nameInput.getText() + " at " + hoursSpinner.getValue() + ":0" + minutesSpinner.getValue() + "\n");
                        messageLog.append("The participant was added \n");

                    } else {
                        participantList.append(nameInput.getText() + " at " + hoursSpinner.getValue() + ':' + minutesSpinner.getValue() + "\n");
                        messageLog.append("The participant was added \n");
                    }
                }
            }
        }
    });
}

    public static void main(String[]args){
        Timetable timetable = new Timetable();
        timetable.setContentPane(timetable.mainPanel);
        timetable.setTitle("Appointment planner");
        timetable.setSize(500, 500);
        timetable.setVisible(true);
        timetable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

