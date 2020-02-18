import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.logging.Formatter;

public class Diameter {
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
    static DecimalFormat df2 = new DecimalFormat("#.##");
    public Diameter()
    {

        frameDiameter = new JFrame("Srednica");
        calculate = new JButton("Oblicz");
        power = new JTextField();
        powerInformation = new JLabel();
        resultShow = new JLabel();
        frameDiameter.add(resultShow);
        frameDiameter.add(power);
        frameDiameter.add(powerInformation);

        power.setBounds(125,100, 200,30);
        powerInformation.setBounds(125, 50, 250, 30);
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

        calculate.setBounds(125, 250, 250, 30);
        frameDiameter.add(calculate);
        calculate.addActionListener(e -> {
            length.setEditable(false);
            power.setEditable(false);
            lenghtResult = Float.parseFloat(length.getText());
            powerResult = Float.parseFloat(power.getText());

            result = (powerResult * Math.pow(10, 3) * 1.68 * Math.pow(10, -8) * lenghtResult * Math.pow(10, 6))/(Math.pow(400, 2)*0.01);

            resultShow.setText(df2.format(result) + " " + "mm2");

        });
        frameDiameter.setSize(500, 500);
        frameDiameter.setLayout(null);
        frameDiameter.setVisible(true);
    }




}
