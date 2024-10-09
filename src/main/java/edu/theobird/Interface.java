package edu.theobird;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    JPanel panel = new JPanel(new GridLayout(2,1));
    JButton button = new JButton("Generate");

    public Interface() {
        super("Number Plate Generator");
        setSize(300,100);

        panel.add(button);
        Main.platebox.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(Main.platebox);


        button.addActionListener(e -> Main.platebox.setText(Main.generate()));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        add(panel);
        setVisible(true);
    }


}
