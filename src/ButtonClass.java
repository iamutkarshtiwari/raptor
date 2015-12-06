import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.*;
import java.util.*;
/**
 * Created by iamutkarsh on 6/10/15.
 */
public class ButtonClass implements ActionListener {



    public String path, name;
    public JButton button;
    public int index;
    public static boolean sizeCollapse;
    //path = " ";
    //name = " " ;


    ButtonClass(String Path, int index) {

        this.path = Path;
        FileLoader.currentProjectPath = this.path;

        // Name extraction

        int i = this.path.lastIndexOf('\\');
        //System.out.println(i);
        //System.out.println(this.path);


        this.name = this.path.substring(i+1);

        //System.out.println(this.name);

        this.button = new JButton(this.name);

        this.index = index;
        this.button.setBounds(0, 0 + (this.index * 36), 283, 36);
        this.button.setVisible(true);
        //this.button.setBackground(Color.LIGHT_GRAY);
        this.button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String path = this.path;
        MainFrame.file_list_frame.getContentPane().removeAll();
        MainFrame.file_list_frame.getContentPane().repaint();

        int index = 0;


        File dir = new File(this.path + "\\" + "master_1");
        //System.out.println(this.path);
        File[] files = dir.listFiles();

        for (File afile : files) {

            FileButtonClass a = new FileButtonClass(afile.getAbsolutePath(), index++);
            MainFrame.file_list_frame.add(a.file_button);
            MainFrame.file_list_frame.repaint();

        }

        /// Branch list

        dir = new File(FileLoader.currentProjectPath);
        //System.out.println(this.path);
        files = dir.listFiles();

        int y = 5;
        for (File afile : files) {

            if ((afile.getAbsolutePath().substring(afile.getAbsolutePath().lastIndexOf('.') + 1)).compareTo("dat") == 0) {

                JButton branchButton = new JButton(afile.getAbsolutePath().substring(afile.getAbsolutePath().lastIndexOf('\\')+1, afile.getAbsolutePath().lastIndexOf('.')));

                branchButton.setBounds(0, y, 250, 40);
                y+=40;
                branchButton.setVisible(true);
                MainFrame.branchDropdown.add(branchButton);
                sizeCollapse = true;

                branchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

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



                                JButton but = new JButton(line.substring(line.lastIndexOf('\\')+1));
                                but.setBounds(0, y, 250, 40);
                                y+=40;
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

                                        for (File afile : files) {

                                            FileButtonClass a = new FileButtonClass(afile.getAbsolutePath(), index++);
                                            MainFrame.file_list_frame.add(a.file_button);
                                            MainFrame.file_list_frame.repaint();

                                        }




                                    }
                                });
                                //repository_list_panel.revalidate();
                                //repository_list_scrollpane.repaint();


                            }
                            fileReader.close();
                        }

                        catch (Exception exp) {
                            //e.printStackTrace();
                        }




                        //MainFrame



                    }
                });

            }
        }




    }
}




class FileButtonClass {

    private String path_file,name;
    public JButton file_button;
    private int index;

    FileButtonClass(final String Path, int index) {

        this.path_file = Path;
        this.index = index;
        this.name= this.path_file.substring(this.path_file.lastIndexOf("\\")+1,this.path_file.length());



        this.file_button = new JButton(this.name);

        this.file_button.setBounds(0, 0 + (this.index * 36), 290, 36);
        this.file_button.setVisible(true);
        this.file_button.setBackground(Color.gray);
        this.file_button.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                MainFrame.text_area.setText(null);
                MainFrame.text_area_counter.setText(null);
                MainFrame.text_area.setVisible(true);
                MainFrame.text_area_counter.setVisible(true);
                int cc=0;            //counter for my main frame
                // MainFrame.create_repository_image.setVisible(false);
                MainFrame.scroll_pane1.setVisible(true);
                MainFrame.scroll_pane2.setVisible(true);

                try {
                    BufferedReader br = new BufferedReader(new FileReader(Path));
                    String line1;
                    while ((line1 = br.readLine()) != null) {
                        //JOptionPane.showMessageDialog(null,line1);
                        MainFrame.text_area.append(line1+"\n");
                        MainFrame.text_area_counter.append(String.valueOf(++cc)+" :"+"\n");
                    }
                }
                catch (IOException eee)
                {
                    System.out.println("IO Exception occured");

                }
            }
        });



    }

}