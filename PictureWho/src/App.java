import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {

    private JLabel imageLabel;
    @SuppressWarnings("unused")
    private int currentLevel = 1;
    @SuppressWarnings("unused")
    private LaunchPage launchpage;
    private JButton submitButton; 

    public App() {
        setTitle("Picture Who");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setResizable(false);
        getContentPane().setBackground(new Color(131, 101, 172));

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
        int bottomPadding = 0;
        int rightPadding = 0;

        pictureWhoLabel.setBorder(BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding));

        topPanel.add(pictureWhoLabel, BorderLayout.NORTH);


        ImageIcon icon = new ImageIcon("img/tao.png");
        imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.BOTTOM);
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.decode("#5E4580"));
        imageLabel.setVerticalAlignment(JLabel.BOTTOM);

        topPanel.add(pictureWhoLabel, BorderLayout.NORTH);
        topPanel.add(imageLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.CENTER);

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
                dispose();
            }
        });

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setOpaque(false);

        buttonPanel.add(centerPanel, BorderLayout.CENTER);

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

        buttonPanel.add(playButton, BorderLayout.EAST);
        buttonPanel.add(exitButton, BorderLayout.WEST);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // when user press play this will run
    private void openGameWindow() {
        JFrame gameFrame = new JFrame("Picture Who");
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setSize(1000, 600);
        gameFrame.setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        gameFrame.getContentPane().add(mainPanel);

        JPanel imagePanel = new JPanel(new GridLayout(2, 2));
        mainPanel.add(imagePanel, BorderLayout.CENTER);


        // load images into ImageIcons
        ImageIcon imageIcon1 = new ImageIcon("img/caatdog.jpg");
        ImageIcon imageIcon2 = new ImageIcon("img/girl.jpg");
        ImageIcon imageIcon3 = new ImageIcon("img/ca.jpg");
        ImageIcon imageIcon4 = new ImageIcon("img/pets.jpg");

        // images to fit within the cells
        Image image1 = imageIcon1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image image2 = imageIcon2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image image3 = imageIcon3.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image image4 = imageIcon4.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        ImageIcon scaledImageIcon1 = new ImageIcon(image1);
        ImageIcon scaledImageIcon2 = new ImageIcon(image2);
        ImageIcon scaledImageIcon3 = new ImageIcon(image3);
        ImageIcon scaledImageIcon4 = new ImageIcon(image4);

        // JLabels and set the scaled icons
        JLabel imageLabel1 = new JLabel(scaledImageIcon1);
        JLabel imageLabel2 = new JLabel(scaledImageIcon2);
        JLabel imageLabel3 = new JLabel(scaledImageIcon3);
        JLabel imageLabel4 = new JLabel(scaledImageIcon4);

        imagePanel.add(imageLabel1);   
        imagePanel.add(imageLabel2);
        imagePanel.add(imageLabel3);
        imagePanel.add(imageLabel4);

        JPanel answerPanel = new JPanel(new BorderLayout());
        mainPanel.add(answerPanel, BorderLayout.SOUTH);

        JTextField answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(300, 50));
        answerPanel.add(answerField, BorderLayout.CENTER);
        answerField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (submitButton != null) {
                    submitButton.doClick();
                }
            }
        });

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredAnswer = answerField.getText().trim().toLowerCase();
                String correctAnswer = "pets";

                if (enteredAnswer.equals(correctAnswer)) {
                    JOptionPane.showMessageDialog(gameFrame, "nyeta talino ha");
                    openNextLevel();
                    gameFrame.dispose(); // close current game window
                } else {
                    JOptionPane.showMessageDialog(gameFrame, "BOBO MALI");
                }

                answerField.setText("");
            }
        });
        answerPanel.add(submitButton, BorderLayout.EAST);

        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    private void openNextLevel() {
        currentLevel++;
        JOptionPane.showMessageDialog(this, "Proceed to next level bro");

        //proceed to the next level
        launchpage = new LaunchPage();
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
