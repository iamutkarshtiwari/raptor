import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.*;
/**
 * Created by iamutkarsh on 6/10/15.
 */
public class ButtonClass  {



    public String path, name;
    public JButton button;
    public int index;
    //path = " ";
    //name = " " ;


    ButtonClass(String Path, int index) {

        this.path = Path;

        // Name extraction

        int i = this.path.lastIndexOf('\\');
        int j = this.path.lastIndexOf('_');


        this.name = this.path.substring(i+1, j);

        //System.out.println(this.name);

        this.button = new JButton(this.name);

        this.index = index;
        this.button.setBounds(0, 0 + (this.index * 36), 283, 36);
        this.button.setVisible(true);
        //this.button.setBackground(Color.LIGHT_GRAY);




        this.button.addMouseListener(new MouseAdapter() {

            String path = this.path;
            //file_list_frame.removeAll();

            public void mouseClicked(MouseEvent e) {

                int index = 0;


                File dir = new File(path);
                File[] files = dir.listFiles();

                for( File afile : files) {

                    FileButtonClass a = new FileButtonClass(afile.getAbsolutePath(), index++);
                    MainFrame.file_list_frame.add(a.file_button);
                    MainFrame.file_list_frame.repaint();

                }









            }
        });





    }

}




class FileButtonClass {

    public String path, name;
    public JButton file_button;
    public int index;

    FileButtonClass(String Path, int index) {

        this.path = Path;
        this.index = index;

        //this.path.substring(i+1, j);

        this.name = this.path.substring(this.path.lastIndexOf('/') + 1, this.path.length());
        this.file_button = new JButton(this.name);


        this.file_button.setBounds(0, 0 + (this.index * 36), 283, 36);
        this.file_button.setVisible(true);
        this.file_button.setBackground(Color.LIGHT_GRAY);


    }
}