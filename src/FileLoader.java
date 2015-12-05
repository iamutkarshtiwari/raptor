import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by iamutkarsh on 4/10/15.
 */
public class FileLoader  {


    public static JLabel settings, branch, sync, sync_label, merge;
    public static JFileChooser chooser;
    public static String current_working_path;
    public static ArrayList<JButton> repo_list = new ArrayList<JButton>();
    public static ArrayList<String> repo_path_list = new ArrayList<String>();



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

        branch = new JLabel(trngle);
        branch.setBounds(10, 20, 20, 30);
        branch.setVisible(true);

        // Sunc Icon

        trngle = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\sync.png");
        img1 = trngle.getImage();
        newimg1 = img1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        trngle = new ImageIcon(newimg1);

        sync = new JLabel(trngle);
        sync.setBounds(880, 25, 20, 20);
        sync.setVisible(true);

        sync_label = new JLabel("Sync");
        sync_label.setBounds(905, 25, 40, 20);
        sync_label.setVisible(true);


        // Merge Icon

        trngle = new ImageIcon("C:\\Users\\Utkarsh\\IdeaProjects\\raptor\\src\\icons\\merge.png");
        img1 = trngle.getImage();
        newimg1 = img1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        trngle = new ImageIcon(newimg1);

        merge = new JLabel(trngle);
        merge.setBounds(830, 25, 20, 20);
        merge.setVisible(true);


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
            //System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            //File pathname= chooser.getCurrentDirectory();

            MainFrame.add_location2.setText(chooser.getSelectedFile().getAbsolutePath());
            // System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
        }
        //new File(chooser.getCurrentDirectory()).mkdir();


    }

    //public void actionPerformed(){}


}
