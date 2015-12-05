
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



// Main container

public class MainFrame implements ActionListener{


    public static boolean plus_on=false;
	public JFrame main_container;
    public JButton plus, add, create, clone, clone_repo, create_repo, add_file, browse;
    public static JInternalFrame plus_frame, repository_list_frame, file_list_frame, top_toolbar, text_area_frame;
    public static JTextField add_location1, add_location2, create_location, filter_repository;
    public JLabel path, name, triangle, create_repository_image;
    public Graphics g;
    public JTextArea text_area;

    public static JPanel repository_list_panel;
    public static JScrollPane repository_list_scrollpane;


    public int plus_counter=1;

    public int plus_button_width=85;
    public int plus_button_height=30;
    public int repo_counter=0;





	MainFrame() {


        plus_frame = new JInternalFrame();

        plus_frame.setBounds(40, 60, 100, 100);
        plus_frame.setLayout(null);
        plus_frame.setBackground(Color.white);
        //plus_frame.setEnabled(false);


        repository_list_frame = new JInternalFrame();
        repository_list_frame.setBounds(0, 112, 300, 675);
        repository_list_frame.setLayout(null);
        repository_list_frame.setVisible(true);
        repository_list_frame.setBackground(Color.white);


        repository_list_panel = new JPanel();
        repository_list_panel.setBounds(0, 0, 300, 2000);
        repository_list_panel.setLayout(null);
        repository_list_panel.setVisible(true);
        repository_list_panel.setBackground(Color.white);




        repository_list_scrollpane = new JScrollPane(repository_list_panel);
        repository_list_scrollpane.setBounds(0, 0, 300, 675);
        //repository_list_scrollpane.setLayout(null);
        //repository_list_scrollpane.setVisible(true);
        //repository_list_scrollpane.setBackground(Color.white);
        //repository_list_scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);



        //repository_list_scrollpane.getVerticalScrollBar().setPreferredSize(new Dimension(0, ));

        //repository_list_scrollpane.setViewportBorder(new LineBorder(Color.RED));

        //repository_list_frame.removeAll();
        //repository_list_frame.repaint();

        //repository_list_frame.setAutoscrolls(true);

        //repository_list_frame.setEnabled(true);


        file_list_frame = new JInternalFrame();
        file_list_frame.setBounds(301, 112, 400, 675);
        file_list_frame.setLayout(null);
        file_list_frame.setVisible(true);
        file_list_frame.setBackground(Color.white);
        //file_list_frame.setEnabled(false);


        top_toolbar = new JInternalFrame();
        top_toolbar.setBounds(301, 5, 1010, 68);
        top_toolbar.setLayout(null);
        top_toolbar.setVisible(true);
        top_toolbar.setBackground(Color.white);
        //top_toolbar.setEnabled(false);

        text_area_frame = new JInternalFrame();
        text_area_frame.setBounds(702, 75, 666, 675);
        //text_area_frame.setLayout(null);
        text_area_frame.setVisible(true);
        text_area_frame.setBackground(Color.white);
        //text_area_frame.setEnabled(true);


        text_area = new JTextArea(666, 675);
        text_area.setBounds(702, 75, 666, 675);
        //text_area.setLayout(null);
        text_area.setVisible(false);
        text_area.setBackground(Color.white);
        //text_area.setEnabled(true);
        text_area.setEditable(true);


        // North pane of plus null
        BasicInternalFrameUI bi = (BasicInternalFrameUI) plus_frame.getUI();
        bi.setNorthPane(null);

        bi = (BasicInternalFrameUI) repository_list_frame.getUI();
        bi.setNorthPane(null);

        bi = (BasicInternalFrameUI) file_list_frame.getUI();
        bi.setNorthPane(null);

        bi = (BasicInternalFrameUI) top_toolbar.getUI();
        bi.setNorthPane(null);

        bi = (BasicInternalFrameUI) text_area_frame.getUI();
        bi.setNorthPane(null);


        // Plus frame vanish

        // *********************************************************


        top_toolbar.addMouseListener(new MouseAdapter() {


            public void mouseEntered(MouseEvent e) {

                if (plus_on == false) {

                    plus_frame.setVisible(false);
                    //plus_counter++;

                }

            }
        });



        file_list_frame.addMouseListener(new MouseAdapter() {


            public void mouseEntered(MouseEvent e) {

                if (plus_on == false) {

                    plus_frame.setVisible(false);
                    //plus_counter++;
                }

            }
        });


        repository_list_frame.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                if (plus_on == false) {

                    plus_frame.setVisible(false);
                    repository_list_frame.setVisible(true);
                    //repository_list_frame.setEnabled(true);
                    //plus_counter++;
                }

            }
        });




        plus_frame.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                plus_on = false;
                //System.out.println("help");
            }


        });

        // **************************************************************************












        // Image Display

        //Triangle Display
        ImageIcon trngle = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\triangle.png");

        Image img1 = trngle.getImage() ;
        Image newimg1 = img1.getScaledInstance(15,15,  java.awt.Image.SCALE_SMOOTH ) ;
        trngle = new ImageIcon( newimg1 );

        triangle = new JLabel(trngle);
        triangle.setBounds(53, 35, 15, 15);
        triangle.setVisible(true);



        // Create repo Image

        trngle = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\create_repository.png");

        img1 = trngle.getImage() ;
        newimg1 = img1.getScaledInstance(580, 200, java.awt.Image.SCALE_SMOOTH ) ;
        trngle = new ImageIcon( newimg1 );

        create_repository_image = new JLabel(trngle);
        create_repository_image.setBounds(702, 300, 580, 200);
        create_repository_image.setVisible(true);


        // Function call
        //FileLoader a = new FileLoader();
		FileLoader.image_load();






        main_container = new JFrame();
		main_container.setSize(1366,768);
		main_container.setLayout(null);
        main_container.getContentPane().setBackground(Color.WHITE);
		main_container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




		ImageIcon plus_icon = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\plus.png");
		ImageIcon add_file_image = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\add.png");
		ImageIcon create_repo_image = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\create.png");
		ImageIcon clone_repo_image = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\clone.png");
        ImageIcon browse_button_image = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\browse.png");



		plus = new JButton(plus_icon);
		plus.setBounds(31, 31, 20, 20);
		plus.setVisible(true);

		add = new JButton("Add");
		add.setBounds(80, 15, plus_button_width, plus_button_height);
		add.setVisible(false);

		// add image
		Image img = add_file_image.getImage() ;
		Image newimg = img.getScaledInstance(60,50,  java.awt.Image.SCALE_SMOOTH ) ;
		ImageIcon icon = new ImageIcon( newimg );

		add_file = new JButton(icon);
		add_file.setBounds(220,230,60,50);
		add_file.setVisible(false);


		// add text location

		// location 1
		add_location1= new JTextField();

		add_location1.setBounds(100,150,300,30);
		add_location1.setVisible(true);

        // location 2
        add_location2= new JTextField();

        add_location2.setBounds(100,150,300,30);
        add_location2.setVisible(true);



        create_location = new JTextField();

        create_location.setBounds(100,100,300,30);
        create_location.setVisible(false);









		create = new JButton("Create");
		create.setBounds(200, 15, plus_button_width, plus_button_height);
		create.setVisible(false);


		// create image
		img = create_repo_image.getImage() ;
		newimg = img.getScaledInstance(60,50,  java.awt.Image.SCALE_SMOOTH ) ;
		icon = new ImageIcon( newimg );

		create_repo = new JButton(icon);
		create_repo.setBounds(220,230,60,50);
		create_repo.setVisible(false);


        // create Button Listener

        create_repo.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {

                boolean mkdir = new File(FileLoader.chooser.getSelectedFile().getAbsolutePath()+"\\"+create_location.getText()+"_rap").mkdir();

                // Adding created directory to arraylist
                FileLoader.repo_path_list.add(FileLoader.chooser.getSelectedFile().getAbsolutePath() + "\\" + create_location.getText() + "_rap");



                // Setting current working directory
                FileLoader.current_working_path = FileLoader.chooser.getSelectedFile().getAbsolutePath();

                // Duplicacy check

                int flag = 0;

                // UserDetails file info.dat
                String path = "C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\data\\repository_list.dat";
                // Use relative path for Unix systems
                File f = new File(path);
                // Works for both Windows and Linux
                if (!f.exists()) {
                    try {
                        f.getParentFile().mkdirs();
                        f.createNewFile();
                    } catch (Exception exp) {

                    }
                }


                try {
                    File file = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\data\\repository_list.dat");
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {


                        if(line.compareToIgnoreCase(FileLoader.chooser.getSelectedFile().getAbsolutePath() + "\\" + create_location.getText() + "_rap") == 0) {

                            JOptionPane.showMessageDialog(null, "Repository already Exists!", "Redundancy", JOptionPane.INFORMATION_MESSAGE);
                            flag = 1;
                            break;

                        }


                    }
                    fileReader.close();
                }

                catch (IOException et) {
                    et.printStackTrace();
                }



                if( flag == 0 ) {


                    // Creating a new button

                    ButtonClass but = new ButtonClass((FileLoader.current_working_path + "\\" + create_location.getText() + "_rap"), repo_counter++);


                    repository_list_frame.add(but.button);
                    repository_list_frame.repaint();

                    //repository_list_scrollpane.getViewport().add(but.button, null);
                    //repository_list_scrollpane.repaint();


                    // Inserting repository paths in the .dat file


                    try {
                        File file = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\data\\repository_list.dat");

                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw);

                        //This will add a new line to the file content
                        out.println(FileLoader.current_working_path + "\\" + create_location.getText() + "_rap");
                        //repo_counter++;

                        out.close();


                    }

                    catch (IOException ioe) {
                        System.out.println("Exception occurred:");
                        ioe.printStackTrace();
                    }


                    JOptionPane.showMessageDialog(null, "Repository created!", "Alert", JOptionPane.INFORMATION_MESSAGE);

                    create_location.setText("");
                    add_location2.setText("");

                    //repository_list_frame.repaint();


                }





            }
        });









		clone = new JButton("Clone");
		clone.setBounds(320, 15, plus_button_width, plus_button_height);
		clone.setVisible(false);


		// clone image

		img = clone_repo_image.getImage() ;
		newimg = img.getScaledInstance(60,50,  java.awt.Image.SCALE_SMOOTH ) ;
		icon = new ImageIcon( newimg );

		clone_repo = new JButton(icon);
		clone_repo.setBounds(220,230,60,50);
		//clone_repo.setBackground(Color.BLUE);
		clone_repo.setVisible(false);



        // browse button

        img = browse_button_image.getImage() ;
        newimg = img.getScaledInstance(40,30,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon( newimg );

        browse = new JButton(icon);
        browse.setBounds(405,150,40,30);
        browse.setVisible(false);

        //browse mouse listener

        browse.addMouseListener(new MouseAdapter() {



             public void mouseClicked(MouseEvent e) {

                 plus_on = true;
                 FileLoader.file_chooser();

             }
        });









		// Labels

		path = new JLabel("Path");

		path.setBounds(50,150,40,30);

		path.setVisible(false);


		name = new JLabel("Name");
		name.setBounds(50, 100, 40, 30);
		name.setVisible(false);


		// Text Fields

        filter_repository = new JTextField("Filter Repository");


        filter_repository.setBounds(0, 75, 300, 36);
        filter_repository.setVisible(true);



        // filter label vanish
        filter_repository.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                filter_repository.setText("");
                plus_frame.setVisible(false);
            }

            public void mouseExited(MouseEvent e) {
                filter_repository.setText("Filter Repository");
            }
        });







		// Adding buttons to plus frame

		plus_frame.add(add);
		plus_frame.add(create);
		plus_frame.add(clone);

		plus_frame.add(add_file);
		plus_frame.add(clone_repo);
		plus_frame.add(create_repo);

		plus_frame.add(add_location1);
        plus_frame.add(add_location2);
        plus_frame.add(create_location);

        plus_frame.add(browse);



		// Label add

		plus_frame.add(path);
		plus_frame.add(name);



		plus.addActionListener(this);
		add.addActionListener(this);
		create.addActionListener(this);
		clone.addActionListener(this);

		add_file.addActionListener(this);
		create_repo.addActionListener(this);
		//clone_repo.addActionListener(this);




		// On plus button click

        text_area_frame.add(text_area);
        text_area_frame.add(create_repository_image);


        // Filter Repository frame updation
	    //repository_list_frame.add(filter_repository);



        // Reading repository path from the .dat file



        try {
            File file = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\data\\repository_list.dat");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {


                ButtonClass but = new ButtonClass(line, repo_counter++);
                repository_list_frame.add(but.button);

                repository_list_frame.repaint();
                //repository_list_panel.revalidate();
                //repository_list_scrollpane.repaint();


            }
            fileReader.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }










		main_container.add(plus_frame);
        //main_container.add(filter_repository);
        //repository_list_scrollpane.add(repository_list_panel);
        //repository_list_frame.add(repository_list_scrollpane);

        //repository_list_frame.getContentPane().add(repository_list_scrollpane, BorderLayout.CENTER);


        main_container.add(repository_list_frame);
        main_container.add(file_list_frame);
        main_container.add(top_toolbar);
        main_container.add(triangle);
        main_container.add(text_area_frame);
        main_container.add(plus);
        main_container.add(filter_repository);

        main_container.setVisible(true);

	}







	public void actionPerformed(ActionEvent e) {

        // Event Listener for plus

        if (e.getSource() == plus) {

            plus_counter++;

            plus_frame.setSize(500, 300);


            // Hide/Unhide
            //if (plus_counter % 2 == 0) {

            plus_frame.setVisible(true);
            add.setVisible(true);
            create.setVisible(true);
            clone.setVisible(true);


            path.setVisible(true);
            browse.setVisible(true);
            add_location1.setVisible(true);


        }

        // Add Pressed

        if (e.getSource() == add) {

            add_file.setVisible(true);
            create_repo.setVisible(false);
            //clone_repo.setVisible(false);
            plus_frame.setSize(500, 300);

            path.setVisible(true);

            name.setVisible(false);
            add_location1.setVisible(true);
            add_location2.setVisible(false);
            create_location.setVisible(false);
            browse.setVisible(true);


        }

        // Create Pressed

        if (e.getSource() == create) {

            add_file.setVisible(false);
            create_repo.setVisible(true);
            //clone_repo.setVisible(false);
            plus_frame.setSize(500, 300);
            name.setVisible(true);
            path.setVisible(true);
            add_location1.setVisible(false);
            add_location2.setVisible(true);
            create_location.setVisible(true);
            browse.setVisible(true);


        }

        // Clone Pressed
        if (e.getSource() == clone) {

            add_file.setVisible(false);
            create_repo.setVisible(false);
            //clone_repo.setVisible(true);
            plus_frame.setSize(500, 600);
            path.setVisible(false);
            name.setVisible(false);
            add_location1.setVisible(false);
            add_location2.setVisible(false);
            create_location.setVisible(false);
            browse.setVisible(false);


        }


    }









    public static void main(String[] args) throws IOException/*, DbxException*/ {


        // Get your app key and secret from the Dropbox developers website.
        /* final String APP_KEY = "xnaszs0wlgoliac";
        final String APP_SECRET = "1ypt7e9jcn6xf17";

        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

        DbxRequestConfig config = new DbxRequestConfig(
                "JavaTutorial/1.0", Locale.getDefault().toString());
        //DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);

        //String authorizeUrl = webAuth.start();o
        // Have the user sign in and authorize your app.
       // String authorizeUrl = webAuth.start();
       // System.out.println("1. Go to: " + authorizeUrl);
       // System.out.println("2. Click \"Allow\" (you might have to log in first)");
       // System.out.println("3. Copy the authorization code.");
       // String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();

        //DbxAuthFinish authFinish = webAuth.finish(code);
        String accessToken = "g417_KT4mrAAAAAAAAAABluNznE270Pqc6oz2gVuACwK2JNwDdgruohDzzI9huEI";  //authFinish.accessToken;

        DbxClient client = new DbxClient(config, accessToken);
        System.out.println("Linked account: " + client.getAccountInfo().displayName);

        // Uploading file
        File inputFile = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\hello.txt");
        FileInputStream inputStream = new FileInputStream(inputFile);
        /*try {
            DbxEntry.File uploadedFile = client.uploadFile("/hello.txt",
                    DbxWriteMode.force(), inputFile.length(), inputStream);
            System.out.println("Uploaded: " + uploadedFile.toString());
        } finally {
            inputStream.close();
        }*/




        new MainFrame();

	}



}