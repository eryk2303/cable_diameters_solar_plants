import javax.swing.*;

public class Panels {
    JFrame framePanles;
    JTextField current;
    JLabel currentInformation;
    JButton calculate;
    JLabel voltageInformation;
    JTextField voltage;
    float currentResult;
    float voltageResult;
    float currentInverter;
    float voltageInverter;
    float powerInverter;
    float powerResult;
    JTextField power;
    JLabel powerInformation;
    public void setCurrentInverter(float currentInverter){this.currentInverter = currentInverter;}
    public void setVoltageInverter(float voltageInverter){this.voltageInverter = voltageInverter;}
    public void setPowerInverter(float powerInverter){this.powerInverter = powerInverter;}
    public void show()
    {

        framePanles = new JFrame("Inverter");
        calculate = new JButton("Ok");


        current = new JTextField();
        currentInformation = new JLabel();

        framePanles.add(current);
        framePanles.add(currentInformation);

        current.setBounds(125,100, 200,30);
        currentInformation.setBounds(125, 50, 250, 30);

        current.setColumns(10);
        currentInformation.setText("Podaj maksymalne prąd w [A]");

        voltage = new JTextField();
        voltageInformation = new JLabel();

        framePanles.add(voltage);
        framePanles.add(voltageInformation);

        voltage.setBounds(125,200, 200,30);
        voltageInformation.setBounds(125, 150, 250, 30);

        voltage.setColumns(10);
        voltageInformation.setText("Podaj maksymalne napięcię w [V]");


        power = new JTextField();
        powerInformation = new JLabel();

        framePanles.add(power);
        framePanles.add(powerInformation);

        powerInformation.setBounds(125,250, 200,30);
        power.setBounds(125, 300, 250, 30);


        power.setColumns(10);
        powerInformation.setText("Podaj maksymalne moc w [W]");

        calculate.setBounds(125, 400, 250, 30);
        framePanles.add(calculate);
        calculate.addActionListener(e -> {
            current.setEditable(false);
            voltage.setEditable(false);
            power.setEditable(false);
            currentResult = Float.parseFloat(current.getText());
            voltageResult = Float.parseFloat(voltage.getText());
            powerResult = Float.parseFloat(power.getText());
            Result first = new Result();
            first.setCurrentPanel(currentResult);
            first.setVoltagePanel(voltageResult);
            first.setPowerPanel(powerResult);
            first.setCurrentInverter(currentInverter);
            first.setPowerInverter(powerInverter);
            first.setVoltageInverter(voltageInverter);
            first.show();

        });
        framePanles.setSize(500, 500);
        framePanles.setLayout(null);
        framePanles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePanles.setVisible(true);
    }
}
