/**
 * Created by benhiggs on 26/01/2016.
 */

import com.opencsv.CSVReader;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class GUI{
    static File filein;
    static JFrame window;
    static JPanel tabs;
    static JPanel graphs;
    static JPanel exports;

    static String [] titles;
    static ArrayList students;

    public static void init(){
        window = new JFrame("Test");
        window.setSize(1000,700);
        window.setLayout(new BorderLayout());

        tabs = new JPanel();
        tabs.setBackground(Color.DARK_GRAY);
        tabs.add(new JButton("tab1"));
        tabs.add(new JButton("tab2"));
        tabs.add(new JButton("tab3"));
        tabs.add(new JButton("tab4"));
        tabs.add(new JButton("tab5"));
        tabs.add(new JButton("tab6"));

        JButton fileopen = new JButton("Choose file..");
        fileopen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser  fileDialog = new JFileChooser();
                fileDialog.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if (f.isDirectory()) {
                            return true;
                        } else {
                            String filename = f.getName().toLowerCase();
                            return filename.endsWith(".csv");
                        }
                    }
                    @Override
                    public String getDescription() {
                        return "CSV files only (*.csv)";
                    }
                });
                if ( fileDialog.showOpenDialog(fileDialog) == JFileChooser.APPROVE_OPTION) {
                    filein = fileDialog.getSelectedFile();
                    try {
                        extractData();
                    }catch (Exception ex){}
                }
            }
        });

        graphs = new JPanel();
        graphs.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        graphs.setBackground(Color.WHITE);
        graphs.add(fileopen);

        exports = new JPanel();
        exports.setBackground(Color.WHITE);
        exports.add(new JTextArea("Progress:"));
        exports.add(new JProgressBar());
        exports.add(new JTextArea("                     "));
        exports.add(new JTextArea("Export choices:"));
        exports.add(new JCheckBox("PDF"));
        exports.add(new JCheckBox("HTML"));
        exports.add(new JButton("Export"));

        window.add(tabs,BorderLayout.NORTH);
        window.add(graphs,BorderLayout.CENTER);
        window.add(exports,BorderLayout.SOUTH);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    private static void extractData() throws Exception {
        CSVReader in = new CSVReader(new FileReader(filein));
        String [] nextLine;
        titles = in.readNext();
        while ((nextLine = in.readNext()) != null) {
            System.out.println(nextLine[0] +"|"+ nextLine[1] + " etc..."+nextLine[nextLine.length-1]);
        }
    }

    public static void main(String args[]){
        init();
    }
}


