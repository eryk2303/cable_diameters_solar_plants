import javax.swing.*;
import java.text.DecimalFormat;

public class Length {
    JFrame frameDiameter;
    JTextField diameter;
    JLabel diameterInformation;
    JTextField power;
    JLabel powerInformation;
    JButton calculate;
    JLabel resultShow;
    double result;
    float diameterResult;
    float powerResult;
    JRadioButton aluminum;
    JRadioButton copper;
    JRadioButton fourHundredV;
    JRadioButton eightHundredV;
    int voltage;
    

    static DecimalFormat df2 = new DecimalFormat("#.##");
    public Length()
    {

        frameDiameter = new JFrame("Moc");
        calculate = new JButton("Oblicz");
        diameter = new JTextField();
        diameterInformation = new JLabel();
        resultShow = new JLabel();
        frameDiameter.add(resultShow);
        frameDiameter.add(diameter);
        frameDiameter.add(diameterInformation);

        aluminum = new JRadioButton("Aluminium", false);
        copper = new JRadioButton("Miedz", true);

        fourHundredV = new JRadioButton("400 V", false);
        eightHundredV = new JRadioButton("800 V", true);

        frameDiameter.add(aluminum);
        frameDiameter.add(copper);

        frameDiameter.add(fourHundredV);
        frameDiameter.add(eightHundredV);

        fourHundredV.setBounds(50, 50, 200, 30);
        eightHundredV.setBounds(350, 50, 200, 30);

        aluminum.setBounds(50, 25, 200, 30);
        copper.setBounds(350, 25, 200, 30);

        diameter.setBounds(125,100, 200,30);
        diameterInformation.setBounds(125, 75, 250, 30);
        resultShow.setBounds(125, 300, 250, 30);

        diameter.setColumns(10);
        diameterInformation.setText("Podaj średnice przewodu w mm2");

        power = new JTextField();
        powerInformation = new JLabel();

        frameDiameter.add(power);
        frameDiameter.add(powerInformation);

        power.setBounds(125,200, 200,30);
        powerInformation.setBounds(125, 150, 250, 30);

        power.setColumns(10);

        powerInformation.setText("Podaj moc w kW");

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

        calculate.setBounds(125, 250, 250, 30);
        frameDiameter.add(calculate);
        calculate.addActionListener(e -> {
            
            powerResult = Float.parseFloat(power.getText());
            diameterResult = Float.parseFloat(diameter.getText());

            if (fourHundredV.isSelected()) { 
  
                    voltage = 400;
            } 

            if (eightHundredV.isSelected()) { 
  
                    voltage = 800;
            } 


            if (copper.isSelected()) { 
  
                    result = (Math.pow(voltage, 2) * 0.01 * diameterResult)/ ( Math.pow(10, 3) * 1.72 * Math.pow(10, -8) * powerResult * Math.pow(10, 6));
            } 

            if (aluminum.isSelected()) { 
  
                    result = (Math.pow(voltage, 2) * 0.01 * diameterResult)/ ( Math.pow(10, 3) * 2.82 * Math.pow(10, -8) * powerResult * Math.pow(10, 6));
            } 
            


            resultShow.setText(df2.format(result) + " " + "m");

        });
        frameDiameter.setSize(500, 500);
        frameDiameter.setLayout(null);
        frameDiameter.setVisible(true);
    }
}
