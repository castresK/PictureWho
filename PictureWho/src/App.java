import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {

    private JLabel imageLabel;
    private int currentLevel = 1;
    private LaunchPage launchpage;
    private JButton submitButton;

    public App() {
        setSize(1000, 800);
        setTitle("Picture Who");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(131, 101, 172));
        setLayout(new BorderLayout());
    
        JPanel topPanel = new JPanel(new BorderLayout());
    
        // title of the window app
        JLabel pictureWhoLabel = new JLabel("PICTURE WHO?");
        pictureWhoLabel.setHorizontalAlignment(JLabel.CENTER);
        pictureWhoLabel.setFont(new Font("Segoe UI", Font.BOLD, 33));
        pictureWhoLabel.setForeground(Color.WHITE);
        pictureWhoLabel.setOpaque(true);
        pictureWhoLabel.setBackground(Color.decode("#5E4580"));
        int topPadding = 30;
        int leftPadding = 0;
        int bottomPadding = 50;
        int rightPadding = 0;
        pictureWhoLabel.setBorder(BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding));
    
        topPanel.add(pictureWhoLabel, BorderLayout.NORTH);
        add(topPanel, BorderLayout.NORTH);
    
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10)); 
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 430, -30, 430)); 
        buttonPanel.setBackground(Color.decode("#5E4580"));
    
        // Play button
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Paytone One", Font.BOLD, 20));
        playButton.setForeground(Color.decode("#5E4580"));
        playButton.setBackground(Color.WHITE);
        playButton.setPreferredSize(new Dimension(80, 10));
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDifficultyWindow();
            }
        });
        buttonPanel.add(playButton);
    
        // Settings button
        JButton settingsButton = new JButton("Settings");
        settingsButton.setFont(new Font("Paytone One", Font.BOLD, 20));
        settingsButton.setForeground(Color.decode("#5E4580"));
        settingsButton.setBackground(Color.WHITE);
        settingsButton.setPreferredSize(new Dimension(80, 10));
        buttonPanel.add(settingsButton);
    
        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Paytone One", Font.BOLD, 20));
        exitButton.setForeground(Color.decode("#5E4580"));
        exitButton.setBackground(Color.WHITE);
        exitButton.setPreferredSize(new Dimension(80, 10));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(App.this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
        buttonPanel.add(exitButton);
    
        add(buttonPanel, BorderLayout.CENTER);
    
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
        bottomPanel.setBackground(Color.decode("#5E4580"));

        ImageIcon imageIcon = new ImageIcon("img/thinking.png");
        JLabel imageLabel = new JLabel(imageIcon);
        bottomPanel.add(imageLabel);

        add(bottomPanel, BorderLayout.SOUTH);

    
        setLocationRelativeTo(null);
    }

    // to open difficulty selection window
    private void openDifficultyWindow() {
        JFrame difficultyFrame = new JFrame("Select Difficulty");
        difficultyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        difficultyFrame.setSize(300, 200);
        difficultyFrame.setResizable(false);

        JPanel difficultyPanel = new JPanel(new GridLayout(3, 1));
        difficultyPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Buttons for different difficulty levels
        JButton easyButton = new JButton("Easy");
        JButton moderateButton = new JButton("Moderate");
        JButton hardButton = new JButton("Hard");

        easyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(difficultyFrame, "Easy difficulty selected");
                difficultyFrame.dispose();
            }
        });

        moderateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(difficultyFrame, "Moderate difficulty selected");
                difficultyFrame.dispose();
            }
        });

        hardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(difficultyFrame, "Hard difficulty selected");
                difficultyFrame.dispose();
            }
        });

        difficultyPanel.add(easyButton);
        difficultyPanel.add(moderateButton);
        difficultyPanel.add(hardButton);

        difficultyFrame.add(difficultyPanel);
        difficultyFrame.setLocationRelativeTo(null);
        difficultyFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App game = new App();
                game.setVisible(true);
            }
        });
    }
}
