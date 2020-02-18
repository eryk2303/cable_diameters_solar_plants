import javax.swing.*;

public class Start {

    public  Start() {
        JFrame frameStart = new JFrame("Start");
        JButton diameter = new JButton("Oblicz średnice przewodu");
        JButton power = new JButton("Oblicz moc maksymalna");
        JButton length = new JButton("Oblicz długość maksymalną");
        frameStart.setSize(500, 500);
        diameter.setBounds(125, 100, 250, 30);
        frameStart.add(diameter);
        diameter.addActionListener(e -> {
            new Diameter();
        });
        power.setBounds(125, 150, 250, 30);
        frameStart.add(power);
        power.addActionListener(e -> {
            new Power();
        });
        length.setBounds(125, 200, 250, 30);
        frameStart.add(length);
        length.addActionListener(e -> {
            new Length();
        });
        frameStart.setLayout(null);
        frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStart.setVisible(true);

    }

    public static void main(String s[]) {
        new Start();
    }


}
