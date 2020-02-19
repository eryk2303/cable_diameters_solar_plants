import javax.swing.*;

public class Result {

    float currentPanel;
    float voltagePanel;
    float powerPanel;
    public void setCurrentPanel(float currentPanel){this.currentPanel = currentPanel;}
    public void setVoltagePanel(float voltagePanel){this.voltagePanel = voltagePanel;}
    public void setPowerPanel(float powerPanel){this.powerPanel = powerPanel;}

    float currentInverter;
    float voltageInverter;
    float powerInverter;
    public void setCurrentInverter(float currentInverter){this.currentInverter = currentInverter;}
    public void setVoltageInverter(float voltageInverter){this.voltageInverter = voltageInverter;}
    public void setPowerInverter(float powerInverter){this.powerInverter = powerInverter;}
    JLabel result;
    private int powerResult;
    public void show() {
        JFrame frameStart = new JFrame("Wynik");
        frameStart.setSize(500, 500);
        result = new JLabel();

        frameStart.add(result);
        result.setBounds(125, 250, 250, 30);

        powerResult = Math.min((int)(1.2*powerInverter), currentTakeToCalculate()*voltageTakeToCalculate());
        result.setText("Maksymalna ilość paneli" + Integer.toString(powerResult));

        frameStart.setLayout(null);
        frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStart.setVisible(true);

    }
    public int currentTakeToCalculate()
    {
        int currentResult = (int)(currentInverter/currentPanel);
        return currentResult;
    }
    public int voltageTakeToCalculate()
    {
        int voltageResult = (int)(voltageInverter/voltagePanel);
        return voltageResult;
    }
    public int powerTakeToCalculate()
    {
        int powerResult = (int)((1.2*powerInverter)/powerPanel);
        return powerResult;
    }

}
