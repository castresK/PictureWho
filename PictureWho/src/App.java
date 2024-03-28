import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {
    private JLabel imageLabel;

    public App() {
        setTitle("Picture Who");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setResizable(false);
        getContentPane().setBackground(new Color(131, 101, 172)); 

        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel pictureWhoLabel = new JLabel("PICTURE WHO?");
        pictureWhoLabel.setHorizontalAlignment(JLabel.CENTER);
        pictureWhoLabel.setFont(new Font("Segoe UI", Font.BOLD, 33));
        pictureWhoLabel.setForeground(Color.WHITE);
        pictureWhoLabel.setOpaque(true);
        pictureWhoLabel.setBackground(Color.decode("#5E4580"));
        topPanel.add(pictureWhoLabel, BorderLayout.NORTH);

        ImageIcon icon = new ImageIcon("img/Bone White Blue Groovy You Matter Desktop Wallpaper (1).png");
        imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.decode("#5E4580"));
        imageLabel.setVerticalAlignment(JLabel.BOTTOM); 
        topPanel.add(imageLabel, BorderLayout.CENTER);

        // Add the top panel to the frame
        add(topPanel, BorderLayout.CENTER);

        // Create buttons panel
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(Color.decode("#5E4580")); 

        // Play button
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
        playButton.setForeground(Color.decode("#5E4580")); 
        playButton.setBackground(Color.WHITE); 
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(App.this, "Starting the game...");
                openGameWindow(); 
            }
        });

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
        exitButton.setForeground(Color.decode("#5E4580")); 
        exitButton.setBackground(Color.WHITE); 
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(App.this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    dispose(); 
                }
            }
        });

        // Add buttons to button panel
        buttonPanel.add(playButton, BorderLayout.WEST);
        buttonPanel.add(exitButton, BorderLayout.EAST);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void openGameWindow() {
        JFrame gameFrame = new JFrame("Game Window");
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setSize(1000, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());
        gameFrame.getContentPane().add(mainPanel);

        JPanel imagePanel = new JPanel(new GridLayout(2, 2));
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        for (int i = 0; i < 4; i++) {
            JLabel imageLabel = new JLabel();
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            imagePanel.add(imageLabel);
        }

        JPanel smallerPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(smallerPanel, BorderLayout.SOUTH);

        for (int i = 0; i < 3; i++) {
            JLabel smallLabel = new JLabel();
            smallLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            smallerPanel.add(smallLabel);
        }

        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null); 
        gameFrame.setVisible(true);
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
