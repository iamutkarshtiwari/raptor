import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by iamutkarsh on 4/10/15.
 */
public class FileLoader {

    public static JLabel settings, sync_label;
    public static JButton branch, merge, sync;
    public static JFileChooser chooser;
    public static String current_working_path;
    public static ArrayList < JButton > repo_list = new ArrayList < JButton > ();
    public static ArrayList < String > repo_path_list = new ArrayList < String > ();
    //public static JInternalFrame branchDropdown;
    public static String currentProjectPath = null;
    public static boolean branchTest = false;
    public static boolean sizeCollapse;
    
    public static void image_load() {
        // Settings Icon
        ImageIcon trngle = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\settings.png");

        Image img1 = trngle.getImage();
        Image newimg1 = img1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        trngle = new ImageIcon(newimg1);

        settings = new JLabel(trngle);
        settings.setBounds(970, 25, 20, 20);
        settings.setVisible(true);
        
        // Branch Icon
        trngle = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\branch.png");
        img1 = trngle.getImage();
        newimg1 = img1.getScaledInstance(20, 30, java.awt.Image.SCALE_SMOOTH);
        trngle = new ImageIcon(newimg1);

        branch = new JButton(trngle);
        branch.setBounds(10, 20, 20, 30);
        branch.setVisible(true);
        
        branch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.branchDropdown.setVisible(!branchTest);
                MainFrame.logDropdown.setVisible(false);
                branchTest = !branchTest;

                /// Branch list
                File dir = new File(FileLoader.currentProjectPath);
                //System.out.println(this.path);
                File[] files = dir.listFiles();

                int y = 5;
                for (File afile: files) {
                    if ((afile.getAbsolutePath().substring(afile.getAbsolutePath().lastIndexOf('.') + 1)).compareTo("dat") == 0) {
                        JButton branchButton = new JButton(afile.getAbsolutePath().substring(afile.getAbsolutePath().lastIndexOf('\\') + 1, afile.getAbsolutePath().lastIndexOf('.')));

                        branchButton.setBounds(0, y, 250, 40);
                        y += 40;
                        branchButton.setVisible(true);
                        MainFrame.branchDropdown.add(branchButton);
                        sizeCollapse = true;

                        branchButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                MainFrame.currentBranch = branchButton.getText();
                                merge.setEnabled(true);

                                MainFrame.logDropdown.setVisible(sizeCollapse);
                                sizeCollapse = !sizeCollapse;
                                MainFrame.logDropdown.getContentPane().removeAll();
                                MainFrame.logDropdown.getContentPane().repaint();

                                // Reading repository path from the .dat file
                                int y = 5;
                                try {
                                    File file = new File(FileLoader.currentProjectPath + "\\" + branchButton.getText() + ".dat");
                                    System.out.println(FileLoader.currentProjectPath + "\\" + branchButton.getText() + ".dat");
                                    FileReader fileReader = new FileReader(file);
                                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                                    StringBuffer stringBuffer = new StringBuffer();
                                    String line;
                                    while ((line = bufferedReader.readLine()) != null) {



                                        JButton but = new JButton(line.substring(line.lastIndexOf('\\') + 1));
                                        but.setBounds(0, y, 250, 40);
                                        y += 40;
                                        but.setVisible(true);
                                        MainFrame.logDropdown.add(but);

                                        MainFrame.logDropdown.repaint();

                                        but.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                MainFrame.file_list_frame.getContentPane().removeAll();
                                                MainFrame.file_list_frame.getContentPane().repaint();

                                                // Repaint file list

                                                MainFrame.logDropdown.setVisible(false);
                                                MainFrame.branchDropdown.setVisible(false);
                                                int index = 0;


                                                File dir = new File(FileLoader.currentProjectPath + "\\" + but.getText());
                                                //System.out.println(this.path);
                                                File[] files = dir.listFiles();

                                                for (File afile: files) {

                                                    FileButtonClass a = new FileButtonClass(afile.getAbsolutePath(), index++);
                                                    MainFrame.file_list_frame.add(a.file_button);
                                                    MainFrame.file_list_frame.repaint();
                                                }
                                            }
                                        });
                                    }
                                    fileReader.close();
                                } catch (Exception exp) {
                                    //e.printStackTrace();
                                }
                            }
                        });

                    }
                }


            }
        });


        // Branch dropdown box
        // Sync Icon
        trngle = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\sync.png");
        img1 = trngle.getImage();
        newimg1 = img1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        trngle = new ImageIcon(newimg1);

        sync = new JButton(trngle);
        sync.setBounds(880, 25, 20, 20);
        sync.setVisible(true);

        sync.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new File("C:\\Users\\Utkarsh\\Dropbox\\" + FileLoader.currentProjectPath.substring(FileLoader.currentProjectPath.lastIndexOf('\\') + 1)).mkdir();
                    FileUtils.copyDirectory(new File(FileLoader.currentProjectPath), new File("C:\\Users\\Utkarsh\\Dropbox\\" + FileLoader.currentProjectPath.substring(FileLoader.currentProjectPath.lastIndexOf('\\') + 1)));
                } catch (Exception epp) {}

            }
        });
        
        sync_label = new JLabel("Sync");
        sync_label.setBounds(905, 25, 40, 20);
        sync_label.setVisible(true);

        // Merge Icon
        trngle = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\merge.png");
        img1 = trngle.getImage();
        newimg1 = img1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        trngle = new ImageIcon(newimg1);

        merge = new JButton("Enter Commit message");
        merge.setBounds(650, 25, 200, 20);
        merge.setVisible(true);
        merge.setEnabled(false);

        // create commits
        merge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.commit_message.setVisible(MainFrame.commit_boolean);
                MainFrame.commit_message.getContentPane().repaint();
                MainFrame.commit_boolean = !MainFrame.commit_boolean;
            }
        });

        MainFrame.top_toolbar.add(settings);
        MainFrame.top_toolbar.add(branch);
        MainFrame.top_toolbar.add(sync);
        MainFrame.top_toolbar.add(sync_label);
        MainFrame.top_toolbar.add(merge);
    }

    public static void file_chooser() {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        //chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            
            MainFrame.add_location2.setText(chooser.getSelectedFile().getAbsolutePath());

            try {
                File file = new File(FileLoader.currentProjectPath + "\\" + "info.log");
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw);

                //This will add a new line to the file content
                out.println(chooser.getSelectedFile().getAbsolutePath());
                //repo_counter++;
                out.close();

            } catch (IOException ioe) {
                System.out.println("Exception occurred:");
                ioe.printStackTrace();
            }
        }
    }

}