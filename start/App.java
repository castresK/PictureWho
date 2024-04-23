package main.start;

// import necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;


// main class extending JFrame 
public class App extends JFrame {

    private boolean isVolumeOn = true; // for the bg music of the game


    public App() {

        // set frame properties 
        setTitle("Picture Who");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        getContentPane().setBackground(new Color(131, 101, 172));
        setLayout(new BorderLayout());

        playBackgroundMusic();
        

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInstructionsPopup();
            }
        });
        timer.setRepeats(false); // Set to run only once
        timer.start();
    

        // create a panel for the top section 
        JPanel topPanel = new JPanel(new BorderLayout());

        // create a custom image icon
        ImageIcon customIcon = new ImageIcon("#"); 
        

        // create a style the title label
        JLabel pictureWhoLabel = new JLabel("Picture Who?");
        pictureWhoLabel.setHorizontalAlignment(JLabel.CENTER);
        pictureWhoLabel.setFont(new Font("segoe ui black", Font.BOLD, 150));
        pictureWhoLabel.setForeground(Color.decode("#E7E4DB"));
        pictureWhoLabel.setBackground(Color.decode("#5E4580"));
        pictureWhoLabel.setOpaque(true);
        pictureWhoLabel.setIcon(customIcon);
        int topPadding = 80;
        int leftPadding = 0;
        int bottomPadding = 90;
        int rightPadding = 0;
        pictureWhoLabel.setBorder(BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding));


        // add the title to the top panel 
        topPanel.add(pictureWhoLabel, BorderLayout.NORTH);
        // add the top panel to the main frame (north position)
        add(topPanel, BorderLayout.NORTH);


        // create a panel for the buttons, the 3 buttons, play and exit
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 180, 90));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(-50, 430, -50, 430));
        buttonPanel.setBackground(Color.decode("#5E4580"));
        Color buttonPanelColor = Color.decode("#E7E4DB");
        

        // create and style the Play button
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("segoe ui black", Font.BOLD, 65));
        playButton.setForeground(Color.decode("#5E4580"));
        playButton.setPreferredSize(new Dimension(400,180));
        playButton.setBackground(Color.WHITE);
        playButton.setForeground(Color.decode("#5E4580"));
        playButton.setBackground(buttonPanelColor); 
        

        // add action listener for play button once you click it it will automatically gp the openDifficultyWindow
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDifficultyWindow();
            }
        });
        buttonPanel.add(playButton);
    

    
        // Exit button once it click it will automatically go to the exit of this application 
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("segoe ui black", Font.BOLD, 65));
        exitButton.setForeground(Color.decode("#5E4580"));
        exitButton.setBackground(Color.WHITE);
        exitButton.setBackground(buttonPanelColor);
        exitButton.setPreferredSize(new Dimension(400,180));


        // exit confirmation listenere
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // thid displaying the confirmation dialog when the exitButton clicked
                int choice = JOptionPane.showConfirmDialog(App.this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // this closing the application if user confirms to exit
                    dispose();
                }
            }
        });
        
        // adding the exitbutton to our collective panel for buttons
        buttonPanel.add(exitButton);
        // the borderlayout position
        add(buttonPanel, BorderLayout.CENTER);

        // Now, let's add a panel at the bottom for future expansion 
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.decode("#5E4580"));
        // Adding this bottom panel to the southern area of the border layout
        add(bottomPanel, BorderLayout.SOUTH);
        // This sets the location of the window relative to the specified component. Passing in 'null' centers the window on screen.
        setLocationRelativeTo(null);
    }

    // instructions of how to play the game
    private void showInstructionsPopup() {

        String message = "<html><div style='text-align: center; margin-left: 60px; margin-right: 60px;'>" +
        "<span style='font-family: Paytone One; font-size: 18px; color: #443C3C;'>Welcome to Picture Who!</span><br><br>" +
        "<span style='font-size: 15px; color: #5E4580;'>Here's how it works:</span><br><br>" +
        "<span style='font-size: 12px; color: #5E4580;'>You can select your preferred difficulty level from three options:</span><br>" +
        "<span style='font-size: 12px; color: #5E4580;'>Easy (20 seconds), Moderate (25 seconds), and Hard (30 seconds).</span><br>" +
        "<span style='font-size: 12px; color: #5E4580;'>Each difficulty level consists of 10 levels for you to complete.</span><br>" +
        "<span style='font-size: 12px; color: #5E4580;'>However, there's no definitive end to the game.</span><br>" +
        "<span style='font-size: 12px; color: #5E4580;'>instead, it's designed as a cycle where you can repeat each difficulty level</span><br>" +
        "<span style='font-size: 12px; color: #5E4580;'>to improve your skills and beat your previous scores.</span><br>" +
        "<span style='font-size: 12px; color: #5E4580;'>Additionally, you have two hint trials available,</span><br>" +
        "<span style='font-size: 12px; color: #5E4580;'>but each hint incurs a time penalty of minus 5 seconds.</span><br>" +
        "<span style='font-size: 12px; color: #5E4580;'>Ready for the challenge? Let's begin!</span><br><br>" +
        "<span style='font-size: 12px; color: #5E4580;'>Click 'OK' to proceed.</span></div></html>";

        JOptionPane.showMessageDialog(this, message, "Instructions", JOptionPane.INFORMATION_MESSAGE);
    }
    


    // This method is responsible for creating a new window to select the game's difficulty.
    private void openDifficultyWindow() {

        // first, we create the new window (JFrame)
        JFrame difficultyFrame = new JFrame("Select Difficulty");

        // its sized and designed appropriately 
        difficultyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        difficultyFrame.setSize(1000, 600);
        difficultyFrame.setResizable(false);
        
        // a panel is created to hold the difficulty level buttons
        JPanel difficultyPanel = new JPanel(new GridLayout(1, 0));
        difficultyPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        
           // Here we start creating the buttons for different difficulty levels ("Easy", "Moderate", "Hard")
        // Buttons for different difficulty levels
        JButton easyButton = new JButton("Easy");
        easyButton.setFont(new Font("segoe ui black", Font.BOLD, 45));
        easyButton.setForeground(Color.decode("#5E4580"));
        easyButton.setBackground(Color.WHITE);

        JButton moderateButton = new JButton("Moderate");
        moderateButton.setFont(new Font("segoe ui black", Font.BOLD, 45));
        moderateButton.setForeground(Color.decode("#5E4580"));
        moderateButton.setBackground(Color.WHITE);

        JButton hardButton = new JButton("Hard");
        hardButton.setFont(new Font("segoe ui black", Font.BOLD, 45));
        hardButton.setForeground(Color.decode("#5E4580"));
        hardButton.setBackground(Color.WHITE);


        // Each button is assigned an ActionListener - this is the code that runs when the button is clicked.
        easyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                // Shows a message to the user indicating an "Easy" game has been selected
                JOptionPane.showMessageDialog(difficultyFrame, "Easy difficulty selected", "Level Selected", getDefaultCloseOperation());
                // Close the difficultyFrame window
                difficultyFrame.dispose();
                
                // And begins a new game at the "Easy" difficulty
                new easyLevels();
            }
        });
        //  Same steps repeated for the moderate and hard levels
        moderateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(difficultyFrame, "Moderate difficulty selected");
                difficultyFrame.dispose();
                new moderateLevels();
            }
        });

        hardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(difficultyFrame, "Hard difficulty selected");
                difficultyFrame.dispose();
                new hardLevels();
            }
        });

        // Now we're adding all the buttons to the panel
        difficultyPanel.add(easyButton);
        difficultyPanel.add(moderateButton);
        difficultyPanel.add(hardButton);

        // The panel is then added to the new window (JFrame)
        difficultyFrame.add(difficultyPanel);

           // The JFrame position is set and finally, we make it visible to the user.
        difficultyFrame.setLocationRelativeTo(null);
        difficultyFrame.setVisible(true);
    }

    

    private void playBackgroundMusic() {
        try {
            File audioFile = new File("Picture Who\\project\\main\\se\\bg music.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the music continuously
            clip.start();

            // Adjust volume based on settings
            if (!isVolumeOn) {
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(10.0f); // Mute the sound
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        // We start the app
        SwingUtilities.invokeLater(new Runnable() {
            // We create the app and make it visible
            public void run() {
                App game = new App();
                game.setVisible(true);
            }
        });
    }
}