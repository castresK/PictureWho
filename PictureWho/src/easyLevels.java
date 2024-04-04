    //  private void openGameWindow() {
    //         JFrame gameFrame = new JFrame("Picture Who");
    //         gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //         gameFrame.setSize(1000, 600);
    //         gameFrame.setResizable(false);

    //         JPanel mainPanel = new JPanel(new BorderLayout());
    //         gameFrame.getContentPane().add(mainPanel);

    //         JPanel imagePanel = new JPanel(new GridLayout(2, 2));
    //         mainPanel.add(imagePanel, BorderLayout.CENTER);


    //         // load images into ImageIcons
    //         ImageIcon imageIcon1 = new ImageIcon("img/caatdog.jpg");
    //         ImageIcon imageIcon2 = new ImageIcon("img/girl.jpg");
    //         ImageIcon imageIcon3 = new ImageIcon("img/ca.jpg");
    //         ImageIcon imageIcon4 = new ImageIcon("img/pets.jpg");

    //         // images to fit within the cells
    //         Image image1 = imageIcon1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    //         Image image2 = imageIcon2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    //         Image image3 = imageIcon3.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    //         Image image4 = imageIcon4.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

    //         ImageIcon scaledImageIcon1 = new ImageIcon(image1);
    //         ImageIcon scaledImageIcon2 = new ImageIcon(image2);
    //         ImageIcon scaledImageIcon3 = new ImageIcon(image3);
    //         ImageIcon scaledImageIcon4 = new ImageIcon(image4);

    //         // JLabels and set the scaled icons
    //         JLabel imageLabel1 = new JLabel(scaledImageIcon1);
    //         JLabel imageLabel2 = new JLabel(scaledImageIcon2);
    //         JLabel imageLabel3 = new JLabel(scaledImageIcon3);
    //         JLabel imageLabel4 = new JLabel(scaledImageIcon4);

    //         imagePanel.add(imageLabel1);   
    //         imagePanel.add(imageLabel2);
    //         imagePanel.add(imageLabel3);
    //         imagePanel.add(imageLabel4);

    //         JPanel answerPanel = new JPanel(new BorderLayout());
    //         mainPanel.add(answerPanel, BorderLayout.SOUTH);

    //         JTextField answerField = new JTextField();
    //         answerField.setPreferredSize(new Dimension(300, 50));
    //         answerPanel.add(answerField, BorderLayout.CENTER);
    //         answerField.addActionListener(new ActionListener() {
    //             @Override
    //             public void actionPerformed(ActionEvent e) {
    //                 if (submitButton != null) {
    //                     submitButton.doClick();
    //                 }
    //             }
    //         });

    //         submitButton = new JButton("Submit");
    //         submitButton.addActionListener(new ActionListener() {
    //             @Override
    //             public void actionPerformed(ActionEvent e) {
    //                 String enteredAnswer = answerField.getText().trim().toLowerCase();
    //                 String correctAnswer = "pets";

    //                 if (enteredAnswer.equals(correctAnswer)) {
    //                     JOptionPane.showMessageDialog(gameFrame, "nyeta talino ha");
    //                     openNextLevel();
    //                     gameFrame.dispose(); // close current game window
    //                 } else {
    //                     JOptionPane.showMessageDialog(gameFrame, "BOBO MALI");
    //                 }

    //                 answerField.setText("");
    //             }
    //         });
    //         answerPanel.add(submitButton, BorderLayout.EAST);

    //         gameFrame.pack();
    //         gameFrame.setLocationRelativeTo(null);
    //         gameFrame.setVisible(true);
    //     } 

    // private void openNextLevel() {
        // currentLevel++;
        // JOptionPane.showMessageDialog(this, "Proceed to next level bro");

        // proceed to the next level
        // launchpage = new LaunchPage();
// }