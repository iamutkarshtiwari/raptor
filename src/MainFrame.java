
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
// Include the Dropbox SDK.
import com.dropbox.core.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

// Include Javaxt library
//import javaxt.io.*;
import org.apache.commons.io.FileUtils;



// Main container

public class MainFrame implements ActionListener{


    public static boolean plus_on=false;
	public static JFrame main_container;
    public JButton plus, add, create, clone, clone_repo, create_repo, add_file, browse;
    public static JInternalFrame plus_frame, repository_list_frame, file_list_frame, top_toolbar, text_area_frame, branchDropdown, logDropdown;
    public static JTextField add_location1, add_location2, create_location, filter_repository;
    public static JLabel path, name, triangle, create_repository_image, currentRepository, currentRepository_label;
    public Graphics g;
    public static JTextArea text_area, text_area_counter;
    public static JScrollPane scroll_pane1, scroll_pane2;
    public static JInternalFrame commit_message;
    public static JLabel commit_message_label;
    public static JTextField commit_message_text;
    public static String currentBranch;

    public static boolean commit_boolean = false;

    public static JTextField branchName;

    public static int currentProjectNumber;




    public static JPanel repository_list_panel;
    public static JScrollPane repository_list_scrollpane;


    public int plus_counter=1;

    public int plus_button_width=120;
    public int plus_button_height=30;
    public int repo_counter=0;





	MainFrame() {


        plus_frame = new JInternalFrame();

        plus_frame.setBounds(40, 60, 100, 100);
        plus_frame.setLayout(null);
        plus_frame.setBackground(Color.white);
        //plus_frame.setEnabled(false);







/*
        commit_message_label = new JLabel("Enter commit message");
        commit_message_label.setBounds(50,10,150,10);
        commit_message_label.setBackground(Color.WHITE);
        commit_message_label.setVisible(true);
*/
        commit_message_text = new JTextField();
        commit_message_text.setBounds(10, 10, 100, 30);
        commit_message_text.setBackground(Color.WHITE);
        commit_message_text.setVisible(true);


        commit_message_text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {


            }



            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {


                    try {
                        System.out.println(FileLoader.currentProjectPath + "\\" + currentBranch + ".dat");

                        LineNumberReader lnr = new LineNumberReader(new FileReader(new File(FileLoader.currentProjectPath +
                                "\\" + currentBranch + ".dat")));
                        System.out.println("check");
                        lnr.skip(Long.MAX_VALUE);

                        int count = lnr.getLineNumber() + 1;
                        lnr.close();


                        BufferedReader brTest = new BufferedReader(new FileReader(FileLoader.currentProjectPath + "\\" + "info.log"));

                        new File(FileLoader.currentProjectPath + "\\" + currentBranch + "_" + String.valueOf(count + 1)).mkdir();

                        String testpath ="";
                        try {
                            File file = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\data\\repository_list.dat");
                            FileReader fileReader = new FileReader(file);
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            StringBuffer stringBuffer = new StringBuffer();
                            String line;
                            int ccount = 1;
                            while ((line = bufferedReader.readLine()) != null) {


                                if(ccount == currentProjectNumber) {
                                    testpath = line;
                                }
                                ccount ++;


                            }
                            fileReader.close();
                        }

                        catch (IOException et) {
                            et.printStackTrace();
                        }


                        FileUtils.copyDirectory(new File(testpath), new File(FileLoader.currentProjectPath + "\\" + currentBranch + "_" + String.valueOf(count + 1)));


                        JOptionPane.showMessageDialog(null, "Commmit pushed!");


                        File file = new File(FileLoader.currentProjectPath + "\\" + branchName.getText() + ".dat");
                        file.createNewFile();
                        File log = new File(FileLoader.currentProjectPath + "\\" + branchName.getText() + ".log");
                        log.createNewFile();
                        JOptionPane.showMessageDialog(null, "Branch created!");


                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw);

                        //This will add a new line to the file content
                        out.println(FileLoader.currentProjectPath + "\\" + branchName.getText() + "_1");
                        //repo_counter++;

                        out.close();

                        fw = new FileWriter(log, true);
                        bw = new BufferedWriter(fw);
                        out = new PrintWriter(bw);


                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date = new Date();
                        //System.out.println(dateFormat.format(date));
                        //This will add a new line to the file content
                        out.println(dateFormat.format(date));

                        out.close();


                    } catch (Exception exp) {
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });



        commit_message = new JInternalFrame();
        commit_message.setBounds(1000, 80, 250,50);
        commit_message.setBackground(Color.CYAN);
        commit_message.setVisible(false);

        //commit_message.add(commit_message_label);
        commit_message.add(commit_message_text);






        repository_list_frame = new JInternalFrame();
        repository_list_frame.setBounds(0, 112, 300, 675);
        repository_list_frame.setLayout(null);
        repository_list_frame.setVisible(true);
        repository_list_frame.setBackground(Color.white);

        currentRepository = new JLabel("");
        currentRepository.setBounds(100, 30, 200, 40);
        currentRepository.setVisible(true);

        currentRepository_label = new JLabel("Current Repository");
        currentRepository_label.setBounds(100, 20, 200, 20);
        currentRepository_label.setVisible(true);


        repository_list_panel = new JPanel();
        repository_list_panel.setBounds(0, 0, 300, 2000);
        repository_list_panel.setLayout(null);
        repository_list_panel.setVisible(true);
        repository_list_panel.setBackground(Color.white);


        branchDropdown = new JInternalFrame();
        branchDropdown.setBounds(350,50,250,400);
        branchDropdown.setVisible(false);
        branchDropdown.setLayout(null);
        branchDropdown.setBackground(Color.yellow);

        logDropdown = new JInternalFrame();
        logDropdown.setBounds(602,50,250,400);
        logDropdown.setVisible(false);
        logDropdown.setLayout(null);
        logDropdown.setBackground(Color.cyan);




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

        text_area_counter = new JTextArea(20, 675);
        //text_area_counter.setBounds(702, 75, 20, 675);
        //text_area.setLayout(null);
        text_area_counter.setVisible(false);
        text_area_counter.setBackground(Color.white);
        //text_area.setEnabled(true);
        text_area_counter.setEditable(false);

        text_area = new JTextArea(646, 675);
        //text_area.setBounds(722, 75, 646, 675);

        //text_area.setLayout(null);
        text_area.setVisible(false);
        text_area.setBackground(Color.white);
        //text_area.setEnabled(true);
        text_area.setEditable(false);

        //adding scroll to two textcomponents
        scroll_pane1= new JScrollPane(text_area);
        scroll_pane1.setBounds(740, 75, 616, 675);
        scroll_pane1.setVisible(false);

        scroll_pane2= new JScrollPane(text_area_counter);
        scroll_pane2.setBounds(706, 75, 30, 675);
        scroll_pane2.setVisible(false);
        scroll_pane2.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        scroll_pane2.getVerticalScrollBar().setModel(scroll_pane1.getVerticalScrollBar().getModel());






        // North pane of plus null
        BasicInternalFrameUI bi = (BasicInternalFrameUI) plus_frame.getUI();
        bi.setNorthPane(null);

        bi = (BasicInternalFrameUI) branchDropdown.getUI();
        bi.setNorthPane(null);

        bi = (BasicInternalFrameUI) logDropdown.getUI();
        bi.setNorthPane(null);

        bi = (BasicInternalFrameUI) commit_message.getUI();
        bi.setNorthPane(null);





        bi = (BasicInternalFrameUI) repository_list_frame.getUI();
        bi.setNorthPane(null);

        bi = (BasicInternalFrameUI) file_list_frame.getUI();
        bi.setNorthPane(null);

        bi = (BasicInternalFrameUI) top_toolbar.getUI();
        bi.setNorthPane(null);

        //bi = (BasicInternalFrameUI) text_area_frame.getUI();
        //bi.setNorthPane(null);


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



        /*
        // = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\raptor.jpg");
        trngle = new ImageIcon(ImageIO.read(new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\raptor.jpg")));
        img1 = trngle.getImage() ;
        newimg1 = img1.getScaledInstance(1366 ,768,  java.awt.Image.SCALE_SMOOTH ) ;
        trngle = new ImageIcon( newimg1 ); */

        //main_container = new JFrame(trngle);
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

		add = new JButton("Create Branch");
		add.setBounds(80, 15, plus_button_width, plus_button_height);
		add.setVisible(false);

        // add image
        Image img = add_file_image.getImage() ;
        Image newimg = img.getScaledInstance(60,50,  java.awt.Image.SCALE_SMOOTH ) ;
        ImageIcon icon = new ImageIcon( newimg );



        add_file = new JButton(icon);
        add_file.setBounds(220,230,60,50);
        add_file.setVisible(false);

        // Branch creation
        add_file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    new File(FileLoader.currentProjectPath + "\\" + branchName.getText() + "_1").mkdir();
                    File file = new File(FileLoader.currentProjectPath + "\\" + branchName.getText() + ".dat");
                    file.createNewFile();
                    File log = new File(FileLoader.currentProjectPath + "\\" + branchName.getText() + ".log");
                    log.createNewFile();
                    JOptionPane.showMessageDialog(null, "Branch created!");


                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw);

                    //This will add a new line to the file content
                    out.println(FileLoader.currentProjectPath + "\\" + branchName.getText() + "_1");
                    //repo_counter++;

                    out.close();

                    fw = new FileWriter(log, true);
                    bw = new BufferedWriter(fw);
                    out = new PrintWriter(bw);


                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    //System.out.println(dateFormat.format(date));
                    //This will add a new line to the file content
                    out.println(dateFormat.format(date));

                    out.close();


                } catch (Exception exp) {
                }
            }

        });





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

        branchName = new JTextField();
        branchName.setBounds(100,100,300,30);
        branchName.setVisible(false);









		create = new JButton("Add Project");
		create.setBounds(210, 15, plus_button_width, plus_button_height);
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

                int flag = 0;



                try {


                    new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\Projects" + "\\" + create_location.getText()).mkdir();
                    FileUtils.copyDirectory(new File(add_location2.getText()), new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\Projects" + "\\" + create_location.getText()+ "\\"+ "master_1"));

                    File branch = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\Projects" + "\\" + create_location.getText()+"\\"+"master.dat");
                    branch.createNewFile();
                    branch = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\Projects" + "\\" + create_location.getText()+"\\"+"master.log");
                    branch.createNewFile();
                    branch = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\Projects" + "\\" + create_location.getText()+"\\"+"info.log");
                    branch.createNewFile();

                    FileWriter fw = new FileWriter(branch, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw);

                    LineNumberReader lnr = new LineNumberReader(new FileReader(new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\data\\repository_list.dat")));
//                   System.out.println("check");
                    lnr.skip(Long.MAX_VALUE);

                    int count = lnr.getLineNumber() + 1;
                    lnr.close();

                    //This will add a new line to the file content
                    out.println(count);
                    //repo_counter++;

                    out.close();
                    // Copying files for other location to Projects folder

                    // Write master_1 path in master.dat

                    File file = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\Projects" + "\\" + create_location.getText()+"\\"+"master.dat");
                    File log = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\Projects" + "\\" + create_location.getText()+"\\"+"master.log");

                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    fw = new FileWriter(file, true);
                    bw = new BufferedWriter(fw);
                    out = new PrintWriter(bw);

                    //This will add a new line to the file content
                    out.println("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\Projects" + "\\" + create_location.getText()+ "\\"+ "master_1");
                    //repo_counter++;

                    out.close();

                    fw = new FileWriter(log, true);
                    bw = new BufferedWriter(fw);
                    out = new PrintWriter(bw);


                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    //System.out.println(dateFormat.format(date));
                    //This will add a new line to the file content
                    out.println(dateFormat.format(date));

                    //repo_counter++;

                    out.close();




                } catch (Exception exp) {}

                try {
                    File file = new File("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\data\\repository_list.dat");
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {


                        if(line.compareToIgnoreCase("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\Projects" + "\\" + create_location.getText()) == 0) {

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

                    ButtonClass but = new ButtonClass(("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\Projects" + "\\" + create_location.getText()), repo_counter++);


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

                        //System.out.println("hey");/
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw);

                        //This will add a new line to the file content
                        out.println("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\Projects" + "\\" + create_location.getText());
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
		//plus_frame.add(clone);

		plus_frame.add(add_file);
		//plus_frame.add(clone_repo);
		plus_frame.add(create_repo);

		plus_frame.add(add_location1);
        plus_frame.add(add_location2);
        plus_frame.add(create_location);
        plus_frame.add(branchName);

        plus_frame.add(browse);



		// Label add

		plus_frame.add(path);
		plus_frame.add(name);



		plus.addActionListener(this);
		add.addActionListener(this);
		create.addActionListener(this);
		clone.addActionListener(this);

		//add_file.addActionListener(this);
		create_repo.addActionListener(this);
		//clone_repo.addActionListener(this);


        // text_area_frame.add(scroll_pane1);
        // text_area_frame.add(scroll_pane2);
        Border bg= BorderFactory.createLineBorder(Color.blue,3);
        text_area.setBorder(bg);
        //Border bg1= BorderFactory.createLineBorder(Color.black,1);
        //text_area_counter.setBorder(bg1);
        // text_area.setVisible(true);
        //text_area_frame.add(text_area);






		// On plus button click

        //text_area_frame.add(text_area);
        //text_area_frame.add(create_repository_image);


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











        //main_container.add(filter_repository);
        //repository_list_scrollpane.add(repository_list_panel);
        //repository_list_frame.add(repository_list_scrollpane);

        //repository_list_frame.getContentPane().add(repository_list_scrollpane, BorderLayout.CENTER);

        main_container.add(commit_message);
        main_container.add(branchDropdown);
        main_container.add(logDropdown);
        main_container.add(plus_frame);
        main_container.add(currentRepository);
        main_container.add(currentRepository_label);
        main_container.add(repository_list_frame);
        main_container.add(file_list_frame);
        main_container.add(top_toolbar);
        main_container.add(triangle);
        //main_container.add(text_area_frame);
        main_container.add(plus);
        main_container.add(filter_repository);
        main_container.add(scroll_pane2);
        main_container.add(scroll_pane1);


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
            add_file.setVisible(true);
            create.setVisible(true);
            clone.setVisible(true);
            name.setVisible(true);
            branchName.setVisible(true);


            path.setVisible(false);
            browse.setVisible(false);
            add_location1.setVisible(false);
            add_location2.setVisible(false);
            create_location.setVisible(false);


        }

        // Add Pressed

        if (e.getSource() == add) {

            add_file.setVisible(true);
            create_repo.setVisible(false);
            //clone_repo.setVisible(false);
            plus_frame.setSize(500, 300);

            path.setVisible(false);

            name.setVisible(true);
            branchName.setVisible(true);
            add_location1.setVisible(false);
            add_location2.setVisible(false);
            create_location.setVisible(false);
            browse.setVisible(false);


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

        /*
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
        */


    }

    public void downloadFolder(String Path) {



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