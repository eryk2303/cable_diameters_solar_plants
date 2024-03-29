import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.logging.Formatter;

public class Diameter {
	JFrame tmp;
    JFrame frameDiameter;
    JTextField power;
    JLabel powerInformation;
    JTextField length;
    JLabel lengthInformation;
    JButton calculate;
    JLabel resultShow;
    double result;
    float powerResult;
    float lenghtResult;
    JRadioButton aluminum;
    JRadioButton copper;
    JRadioButton fourHundredV;
    JRadioButton eightHundredV;
    int voltage;

    static DecimalFormat df2 = new DecimalFormat("#.##");
    public Diameter()
    {

        frameDiameter = new JFrame("Srednica");
        calculate = new JButton("Oblicz");
        power = new JTextField();
        powerInformation = new JLabel();
        resultShow = new JLabel();

        aluminum = new JRadioButton("Aluminium", false);
        copper = new JRadioButton("Miedz", true);

        fourHundredV = new JRadioButton("400 V", false);
        eightHundredV = new JRadioButton("800 V", true);

        frameDiameter.add(resultShow);
        frameDiameter.add(power);
        frameDiameter.add(powerInformation);
        frameDiameter.add(aluminum);
        frameDiameter.add(copper);

        frameDiameter.add(fourHundredV);
        frameDiameter.add(eightHundredV);

        fourHundredV.setBounds(50, 50, 200, 30);
        eightHundredV.setBounds(350, 50, 200, 30);
        aluminum.setBounds(50, 25, 200, 30);
        copper.setBounds(350, 25, 200, 30);
        power.setBounds(125, 100, 200, 30);
        powerInformation.setBounds(125, 75, 250, 30);
        resultShow.setBounds(125, 300, 250, 30);

        power.setColumns(10);
        powerInformation.setText("Podaj moc w kW");

        length = new JTextField();
        lengthInformation = new JLabel();

        frameDiameter.add(length);
        frameDiameter.add(lengthInformation);

        length.setBounds(125,200, 200,30);
        lengthInformation.setBounds(125, 150, 250, 30);

        length.setColumns(10);
        lengthInformation.setText("Podaj długość w metrach");
    
        calculate.setBounds(75, 250, 300, 30);
        frameDiameter.add(calculate);

        copper.addActionListener(e -> {
            
            if (copper.isSelected()) { 
                aluminum.setSelected(false);
            }

            
        });

        aluminum.addActionListener(e -> {
            
            if (aluminum.isSelected()) { 
                copper.setSelected(false);
            }

            
        });

        fourHundredV.addActionListener(e -> {
            
            if (fourHundredV.isSelected()) { 
                eightHundredV.setSelected(false);
            }

            
        });

        eightHundredV.addActionListener(e -> {
            
            if (eightHundredV.isSelected()) { 
                fourHundredV.setSelected(false);
            }

            
        });

        calculate.addActionListener(e -> {
            
            lenghtResult = Float.parseFloat(length.getText());
            powerResult = Float.parseFloat(power.getText());

            if (fourHundredV.isSelected()) { 
  
                    voltage = 400;
            } 

            if (eightHundredV.isSelected()) { 
  
                    voltage = 800;
            } 

            if (copper.isSelected()) { 
  
                    result = (powerResult * Math.pow(10, 3) * 1.72 * Math.pow(10, -8) * lenghtResult * Math.pow(10, 6))/(Math.pow(voltage, 2)*0.01);
            } 

            if (aluminum.isSelected()) { 
  
                    result = (powerResult * Math.pow(10, 3) * 2.82 * Math.pow(10, -8) * lenghtResult * Math.pow(10, 6))/(Math.pow(voltage, 2)*0.01);
            } 
            

            resultShow.setText(df2.format(result) + " " + "mm2");

        });
        frameDiameter.setSize(500, 500);
        frameDiameter.setLayout(null);
        frameDiameter.setVisible(true);
    }




}
