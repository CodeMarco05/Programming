package Code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.io.FileFilter;
import java.text.FieldPosition;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class GUI extends JFrame {

	private  JPanel contentPane;
	private JButton btn_selectInputDir;
	private Label lbl_inputPath;
	
	public static String inputFilePath;
	public static String outputFolderPath;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					GUI frame = new GUI();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Text Bit Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(201, 201, 201));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_selectInputFile = new JButton("Select Input File");
		btn_selectInputFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_selectInputFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				
				// Create a file filter for .txt files
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files (*.txt)", "txt");
		        fileChooser.setFileFilter(filter);

		        // Show the file chooser dialog
		        int returnValue = fileChooser.showOpenDialog(contentPane);

		        //Is the selected option valid
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            // Get the selected file
		            java.io.File selectedFile = fileChooser.getSelectedFile();

		            // Get the path of the selected file
		            String filePath = selectedFile.getAbsolutePath();
		            
		            //Sets the text for the label
		            if(Utils.getFileExtension(filePath).equals("txt")) {
		            	lbl_inputPath.setText(filePath);
		            	
		            	inputFilePath = filePath;
		            	
		            }

		            
		        } 
		          
				
			}
		});
		btn_selectInputFile.setBounds(364, 94, 179, 23);
		contentPane.add(btn_selectInputFile);
		
		lbl_inputPath = new Label("");
		lbl_inputPath.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbl_inputPath.setBackground(new Color(180, 180, 180));
		lbl_inputPath.setBounds(10, 94, 317, 22);
		contentPane.add(lbl_inputPath);
		
		Label lbl_outputPath = new Label("");
		lbl_outputPath.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbl_outputPath.setBackground(new Color(180, 180, 180));
		lbl_outputPath.setBounds(10, 136, 317, 22);
		contentPane.add(lbl_outputPath);
		
		btn_selectInputDir = new JButton("Select Output Directory");
		btn_selectInputDir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_selectInputDir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser folderChooser = new JFileChooser();
				
				// Set the file chooser to select directories only
		        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		        // Show the folder chooser dialog
		        int returnValue = folderChooser.showOpenDialog(contentPane);

		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            // Get the selected folder
		            java.io.File selectedFolder = folderChooser.getSelectedFile();

		            // Get the path of the selected folder
		            String folderPath = selectedFolder.getAbsolutePath();
		            
		            
		            outputFolderPath = folderPath;
		            
		        } 
				
				
			}
		});
		btn_selectInputDir.setBounds(364, 135, 179, 23);
		contentPane.add(btn_selectInputDir);
		
		Label lbl_headlineEncode = new Label("Encode File to Binary Picture");
		lbl_headlineEncode.setFont(new Font("Arial Black", Font.BOLD, 22));
		lbl_headlineEncode.setAlignment(Label.CENTER);
		lbl_headlineEncode.setBounds(10, 47, 573, 22);
		contentPane.add(lbl_headlineEncode);
		
		JButton btn_startEncode = new JButton("Start Encoding");
		btn_startEncode.setForeground(new Color(238, 51, 51));
		btn_startEncode.setBackground(new Color(238, 51, 51));
		btn_startEncode.setFont(new Font("Arial Black", Font.BOLD, 16));
		btn_startEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Utils.checkInput();
				
			}
		});
		btn_startEncode.setBounds(201, 200, 179, 23);
		contentPane.add(btn_startEncode);
		UIManager.put("Label.foreground", new Color(128, 128, 128));

	}
}
