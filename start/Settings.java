package main.start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Settings extends JFrame {
    private JToggleButton volumeToggleButton;
    private JLabel onLabel;
    private JLabel offLabel;
    private JButton closeButton;
    private JButton guidelineButton;

    private boolean isVolumeOn = true;

    public Settings() {
        setTitle("Settings");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(131, 101, 172)); // Set background color
        setLayout(new BorderLayout());

        // Volume control panel
        JPanel volumePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        volumePanel.setBackground(new Color(131, 101, 172)); // Set background color
        volumePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel volumeLabel = new JLabel("Sound");
        volumeLabel.setForeground(Color.WHITE);
        volumeLabel.setFont(volumeLabel.getFont().deriveFont(Font.BOLD, 20));
        volumePanel.add(volumeLabel);

        onLabel = new JLabel("");
        onLabel.setForeground(Color.WHITE);
        volumePanel.add(onLabel);

        volumeToggleButton = new JToggleButton();
        volumeToggleButton.setPreferredSize(new Dimension(301, 124));
        volumeToggleButton.setContentAreaFilled(false); // Remove default fill
        volumeToggleButton.setBorderPainted(false); // Remove default border
        volumeToggleButton.setIcon(new ImageIcon("Picture Who/project/main/img/off.png")); 
        volumeToggleButton.setSelectedIcon(new ImageIcon("Picture Who/project/main/img/on.png")); 
        volumeToggleButton.setSelected(isVolumeOn); // Set default state
        volumeToggleButton.setOpaque(true); // Make sure the button is opaque to set its background color
        volumeToggleButton.setBackground(new Color(131, 101, 172)); // Set background color
        volumeToggleButton.setForeground(Color.WHITE); // Set foreground (text) color


        volumeToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement action when button is toggled
                isVolumeOn = volumeToggleButton.isSelected();
                updateVolumeState();
            }
        });

        volumePanel.add(volumeToggleButton);

        offLabel = new JLabel("");
        offLabel.setForeground(Color.GRAY);
        volumePanel.add(offLabel);

        // Add volume panel to the frame
        add(volumePanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Set layout to BoxLayout with Y_AXIS alignment
        buttonPanel.setBackground(new Color(131, 101, 172));

        guidelineButton = new JButton("View Guidelines");
        guidelineButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        guidelineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showGuidelines();
            }
        });
        buttonPanel.add(guidelineButton);

        closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(closeButton);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Update volume toggle button based on initial state
        updateVolumeState();
    }

    private void updateVolumeState() {
        if (isVolumeOn) {
            onLabel.setForeground(Color.WHITE);
            offLabel.setForeground(Color.GRAY);
            volumeToggleButton.setSelected(true);
        } else {
            onLabel.setForeground(Color.GRAY);
            offLabel.setForeground(Color.WHITE);
            volumeToggleButton.setSelected(false);
        }
    }

    private void showGuidelines() {
        // Implement method to show guidelines
        JOptionPane.showMessageDialog(this, "Here are the guidelines of the game.");
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Settings settings = new Settings();
                settings.setVisible(true);
                settings.setLocationRelativeTo(null); // Center the window
            }
        });
    }
}
