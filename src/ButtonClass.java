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
        MainFrame.currentRepository.setText(this.name);


        File dir = new File(this.path + "\\" + "master_1");
        //System.out.println(this.path);
        File[] files = dir.listFiles();

        for (File afile : files) {

            FileButtonClass a = new FileButtonClass(afile.getAbsolutePath(), index++);
            MainFrame.file_list_frame.add(a.file_button);
            MainFrame.file_list_frame.repaint();

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