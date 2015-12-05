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
    public JTextField login_id, login_email, login_signup_password;
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

        // Login password text with '*'
        login_password = new JPasswordField();
        login_password.setBounds(150, 190, 200, 30);
        login_password.setVisible(true);

        // Login password text without '*'
        login_signup_password = new JTextField();
        login_signup_password.setBounds(150, 190, 200, 30);
        login_signup_password.setVisible(false);

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

        // forgot password
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
        login_container.add(login_signup_password);

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
            login_password.setVisible(false);
            login_signup_password.setVisible(true);


        } else if (e.getSource() == login_text_label ) {

            login_email.setVisible(false);
            login_email_label.setVisible(false);
            forgot_password_label.setVisible(true);
            signup_label.setVisible(false);
            login_label.setVisible(true);
            signup_text_label.setVisible(true);
            login_text_label.setVisible(false);
            login_signup_password.setVisible(false);
            login_password.setVisible(true);


        } else if (e.getSource() == login_label) {

            authorizeDetails();

        } else if (e.getSource() == signup_label) {

            //username validation
            for ( char ch : ((login_id.getText()).toCharArray())) {
                if (!( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || ch == '_' || ch == '.' )) {
                    JOptionPane.showMessageDialog(null, "Invalid username");
                    return ;
                }

            }

            // user email validation
            EmailValidator emailValidator = new EmailValidator();
            if(!emailValidator.validate(login_email.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Invalid email Id");
                return;
            }

            JOptionPane.showMessageDialog(null, "Signing up... Please Wait!");
            pushDetails();

            login_id.setText(login_id.getText());
            login_password.setText(login_signup_password.getText());
            e.setSource(login_text_label);
            actionPerformed(e);

            // UserDetails file info.dat
            String path = "C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\data\\" + "info.dat";
            // Use relative path for Unix systems
            File f = new File(path);
            // Works for both Windows and Linux
            try {
                f.getParentFile().mkdirs();
                f.createNewFile();
            } catch (Exception exp) {

            }
            //Writin Personal info of user in the .info file
            try {
                File file = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\data\\" + "info.dat");

                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw);

                //This will add a new line to the file content
                out.print(login_id.getText() + "\\r\\n");
                out.print(login_signup_password.getText()+"\\r\\n");
                out.print(login_email.getText()+"\\r\\n");

                out.close();
            }

            catch (IOException ioe) {
                System.out.println("Exception occurred:");
                ioe.printStackTrace();
            }





        }
    }

    // For signup
    public void pushDetails() {

        // Get your app key and secret from the Dropbox developers website.
        final String APP_KEY = "xnaszs0wlgoliac";
        final String APP_SECRET = "1ypt7e9jcn6xf17";

        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

        DbxRequestConfig config = new DbxRequestConfig(
                "JavaTutorial/1.0", Locale.getDefault().toString());
        //DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);


        String accessToken = "g417_KT4mrAAAAAAAAAABluNznE270Pqc6oz2gVuACwK2JNwDdgruohDzzI9huEI";  //authFinish.accessToken;




        try {
            //DbxEntry.Folder uploadFolder = createFolder(String path)throws DbxException
            DbxClient client = new DbxClient(config, accessToken);
            System.out.println("Linked account: " + client.getAccountInfo().displayName);

            // Create userInfo file
            File infoFile = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\data\\info.dat");
            FileInputStream inputStream = new FileInputStream(infoFile);

            DbxEntry.Folder uploadedFolder = client.createFolder('/'+(login_id.getText()).toString());
            DbxEntry.File uploadInfoFile = client.uploadFile("/" + (login_id.getText()).toString() + "/" +"info.dat",
                    DbxWriteMode.force(), infoFile.length(), inputStream);
            System.out.println("Uploaded: ");
            JOptionPane.showMessageDialog(null, "Signup successfull! Please login.");
        } catch(Exception e) {
            //inputStream.close();
        }

    }

    // for login
    public boolean authorizeDetails() {
        return true;
    }





    public static void main(String[] Args)throws IOException {

        LoginPage a = new LoginPage();
        a.login();

    }

}

