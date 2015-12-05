/**
 * Created by Utkarsh on 29-Nov-15.
 */

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
// Include the Dropbox SDK.
import com.dropbox.core.*;
import java.io.*;
import java.util.*;




public class LoginPage implements ActionListener {

    public JFrame login_container;
    public JTextField login_id, login_email;
    public JPasswordField login_password;
    public JButton signup_label, login_label, forgot_password_label, signup_text_label, login_text_label;
    public JLabel login_container_image, login_id_label,
            login_password_label, login_email_label;

    public void login() {

        login_container = new JFrame();
        login_container.setSize(480, 480);
        login_container.setLayout(null);
        login_container.getContentPane().setBackground(Color.WHITE);
        login_container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon raptor_image = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\raptor_tag.png");
        Image raptor_image_scaled = raptor_image.getImage().getScaledInstance(400, 100,Image.SCALE_DEFAULT);
        raptor_image = new ImageIcon(raptor_image_scaled);
        login_container_image = new JLabel(raptor_image);
        login_container_image.setBounds(30,10, 400, 100);

        //Login id label
        login_id_label = new JLabel("UserName");
        login_id_label.setBounds(80,140,60,30);
        login_id_label.setVisible(true);

        // Login id text
        login_id = new JTextField();
        login_id.setBounds(150, 140, 200, 30);
        login_id.setVisible(true);

        //Login password label
        login_password_label = new JLabel("Password");
        login_password_label.setBounds(80,190,60,30);
        login_password_label.setVisible(true);

        // Login password text
        login_password = new JPasswordField();
        login_password.setBounds(150, 190, 200, 30);
        login_password.setVisible(true);

        //Login email label
        login_email_label = new JLabel("Email Id");
        login_email_label.setBounds(80,240,60,30);
        login_email_label.setVisible(false);

        // Login email text
        login_email = new JTextField();
        login_email.setBounds(150, 240, 200, 30);
        login_email.setVisible(false);

        //login button

        ImageIcon login_button = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\login_button.jpg");
        Image login_button_scaled = login_button.getImage().getScaledInstance(200, 40,Image.SCALE_DEFAULT);
        login_button = new ImageIcon(login_button_scaled);
        login_label = new JButton(login_button);
        login_label.setBounds(150, 280, 200, 40);
        login_label.setVisible(true);

        // signup button
        ImageIcon signup_button = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\signup_button.png");
        Image signup_button_scaled = signup_button.getImage().getScaledInstance(200, 40,Image.SCALE_DEFAULT);
        signup_button = new ImageIcon(signup_button_scaled);
        signup_label = new JButton(signup_button);
        signup_label.setBounds(150, 280, 200, 40);
        signup_label.setVisible(false);
        signup_label.setOpaque(false);
        signup_label.setContentAreaFilled(false);
        signup_label.setBorderPainted(false);
        signup_label.setVisible(false);

        // fotget password
        forgot_password_label = new JButton("Forgot password?");
        forgot_password_label.setBounds(130, 320, 140, 30);
        forgot_password_label.setOpaque(false);
        forgot_password_label.setContentAreaFilled(false);
        forgot_password_label.setBorderPainted(false);

        // signup label
        signup_text_label = new JButton("Signup");
        signup_text_label.setBounds(290, 320, 80, 30);
        signup_text_label.setOpaque(false);
        signup_text_label.setContentAreaFilled(false);
        signup_text_label.setBorderPainted(false);

        //go back to login

        login_text_label = new JButton("Go back and login");
        login_text_label.setBounds(170, 320, 150, 30);
        login_text_label.setOpaque(false);
        login_text_label.setContentAreaFilled(false);
        login_text_label.setBorderPainted(false);
        login_text_label.setVisible(false);



        // Action Listeners

        login_label.addActionListener(this);
        signup_label.addActionListener(this);
        forgot_password_label.addActionListener(this);
        signup_text_label.addActionListener(this);
        login_text_label.addActionListener(this);


        // Added components to the main login window
        login_container.add(login_id);
        login_container.add(login_container_image);
        login_container.add(login_id_label);
        login_container.add(login_password_label);
        login_container.add(login_password);
        login_container.add(login_email);
        login_container.add(login_email_label);
        login_container.add(login_label);
        login_container.add(forgot_password_label);
        login_container.add(signup_text_label);
        login_container.add(signup_label);
        login_container.add(login_text_label);

        login_container.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signup_text_label) {

            login_email.setVisible(true);
            login_email_label.setVisible(true);
            forgot_password_label.setVisible(false);
            signup_label.setVisible(true);
            login_label.setVisible(false);
            signup_text_label.setVisible(false);
            login_text_label.setVisible(true);

        } else if (e.getSource() == login_text_label ) {

            login_email.setVisible(false);
            login_email_label.setVisible(false);
            forgot_password_label.setVisible(true);
            signup_label.setVisible(false);
            login_label.setVisible(true);
            signup_text_label.setVisible(true);
            login_text_label.setVisible(false);

        } else if (e.getSource() == login_label) {

            authorizeDetails();

        }
        else if (e.getSource() == signup_label) {
            if (authorizeDetails() == true) {
                pushDetails();
            }

        }

    }


    public void pushDetails() {

    }

    public boolean authorizeDetails() {

    }





    public static void main(String[] Args)throws IOException {

        LoginPage a = new LoginPage();
        a.login();

    }

}

