import javax.swing.*;
import java.text.DecimalFormat;

public class Power {
    JFrame frameDiameter;
    JTextField diameter;
    JLabel diameterInformation;
    JTextField length;
    JLabel lengthInformation;
    JButton calculate;
    JLabel resultShow;
    double result;
    float diameterResult;
    float lenghtResult;
    JRadioButton aluminum;
    JRadioButton copper;

    static DecimalFormat df2 = new DecimalFormat("#.##");
    public Power()
    {

        frameDiameter = new JFrame("Moc");
        calculate = new JButton("Oblicz");
        diameter = new JTextField();
        diameterInformation = new JLabel();
        resultShow = new JLabel();
        frameDiameter.add(resultShow);
        frameDiameter.add(diameter);
        frameDiameter.add(diameterInformation);

        diameter.setBounds(125,100, 200,30);
        diameterInformation.setBounds(125, 50, 250, 30);
        resultShow.setBounds(125, 300, 250, 30);

        aluminum = new JRadioButton("Aluminium", false);
        copper = new JRadioButton("Miedz", true);

        frameDiameter.add(aluminum);
        frameDiameter.add(copper);

        aluminum.setBounds(50, 25, 200, 30);
        copper.setBounds(350, 25, 200, 30);

        diameter.setColumns(10);
        diameterInformation.setText("Podaj średnice przewodu w mm2");

        length = new JTextField();
        lengthInformation = new JLabel();

        frameDiameter.add(length);
        frameDiameter.add(lengthInformation);

        length.setBounds(125,200, 200,30);
        lengthInformation.setBounds(125, 150, 250, 30);

        length.setColumns(10);
        lengthInformation.setText("Podaj długość w metrach");

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

        calculate.setBounds(125, 250, 250, 30);
        frameDiameter.add(calculate);
        calculate.addActionListener(e -> {
            
            lenghtResult = Float.parseFloat(length.getText());
            diameterResult = Float.parseFloat(diameter.getText());
            
            if (copper.isSelected()) { 
  
                    result = (Math.pow(400, 2) * 0.01 * diameterResult)/ ( Math.pow(10, 3) * 1.72 * Math.pow(10, -8) * lenghtResult * Math.pow(10, 6));
            } 

            if (aluminum.isSelected()) { 
  
                    result = (Math.pow(400, 2) * 0.01 * diameterResult)/ ( Math.pow(10, 3) * 2.82 * Math.pow(10, -8) * lenghtResult * Math.pow(10, 6));
            } 

            resultShow.setText(df2.format(result) + " " + "kW");

        });
        frameDiameter.setSize(500, 500);
        frameDiameter.setLayout(null);
        frameDiameter.setVisible(true);
    }

}
