import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.logging.Formatter;

public class Inverter {

        JFrame frameInverter;
        JTextField power;
        JLabel powerInformation;
        JTextField current;
        JLabel currentInformation;
        JButton calculate;
        JLabel voltageInformation;
        JTextField voltage;
        float powerResult;
        float currentResult;
        float voltageResult;

        public Inverter()
        {

            frameInverter = new JFrame("Inverter");
            calculate = new JButton("Ok");
            power = new JTextField();
            powerInformation = new JLabel();

            frameInverter.add(power);
            frameInverter.add(powerInformation);

            power.setBounds(125,100, 200,30);
            powerInformation.setBounds(125, 50, 250, 30);


            power.setColumns(10);
            powerInformation.setText("Podaj maksymalne moc w [kW]");

            current = new JTextField();
            currentInformation = new JLabel();

            frameInverter.add(current);
            frameInverter.add(currentInformation);

            current.setBounds(125,200, 200,30);
            currentInformation.setBounds(125, 150, 250, 30);

            current.setColumns(10);
            currentInformation.setText("Podaj maksymalne prąd w [A]");

            voltage = new JTextField();
            voltageInformation = new JLabel();

            frameInverter.add(voltage);
            frameInverter.add(voltageInformation);

            voltage.setBounds(125,300, 200,30);
            voltageInformation.setBounds(125, 250, 250, 30);

            voltage.setColumns(10);
            voltageInformation.setText("Podaj maksymalne napięcię w [V]");

            calculate.setBounds(125, 400, 250, 30);
            frameInverter.add(calculate);
            calculate.addActionListener(e -> {
                current.setEditable(false);
                power.setEditable(false);
                voltage.setEditable(false);
                if(current.getText() == null)
                    currentResult = 0;
                else
                    currentResult = Float.parseFloat(current.getText());

                if(power.getText() == null)
                    powerResult = 0;
                else
                    powerResult = Float.parseFloat(power.getText());
                if(voltage.getText() == null)
                    voltageResult = 0;
                else
                    voltageResult = Float.parseFloat(voltage.getText());
                Panels first = new Panels();
                first.show();
                first.setCurrentInverter(currentResult);
                first.setPowerInverter(powerResult);
                first.setVoltageInverter(voltageResult);
            });
            frameInverter.setSize(500, 500);
            frameInverter.setLayout(null);
            frameInverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameInverter.setVisible(true);
        }


    public static void main(String s[]) {
        new Inverter();
    }

    }


