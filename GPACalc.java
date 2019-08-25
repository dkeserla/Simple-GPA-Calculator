import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.TextField;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JButton;

public class GPACalc {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-46,459
	 */
	private final TextField textField = new TextField();
	private JTextField classTotal;
	private JTextField classWeightedString;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GPACalc window = new GPACalc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GPACalc() {
		initialize();
	}
	public void restart() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lbl = new JLabel("How many classes are you in? ");
		lbl.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		lbl.setBounds(76, 11, 261, 53);
		frame.getContentPane().add(lbl);
		
		classTotal = new JTextField();
		classTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		classTotal.setBounds(347, 17, 40, 40);
		frame.getContentPane().add(classTotal);
		classTotal.setColumns(10);
		
		JLabel lbl_2 = new JLabel("How many classes are weighted? ");
		lbl_2.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		lbl_2.setBounds(76, 83, 294, 53);
		frame.getContentPane().add(lbl_2);
		
		classWeightedString = new JTextField();
		classWeightedString.setFont(new Font("Tahoma", Font.PLAIN, 18));
		classWeightedString.setColumns(10);
		classWeightedString.setBounds(347, 89, 40, 40);
		frame.getContentPane().add(classWeightedString);
		
		Button button_1 = new Button("Submit");
		button_1.setBounds(186, 157, 90, 33);
		frame.getContentPane().add(button_1);
		

		
		JButton button = new JButton("Close?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		button.setBounds(10, 428, 89, 23);
		frame.getContentPane().add(button);
		/*
 		JButton btnReset = new JButton("Reset?");
		btnReset.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		btnReset.setBounds(385, 427, 89, 23);
		frame.getContentPane().add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.getContentPane().removeAll();
					frame.repaint();
				    initialize();
					restart();
					}
				catch(Exception e2) {
					initialize();
					restart();
				}
				finally {
					frame.revalidate();
					frame.repaint();
				}
				restart();
				initialize();
				frame.revalidate();
				frame.repaint();
		}
		}
		);
		*/
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer classTotalNum = 0, classWeighted = 0;
				try {
					classTotalNum = Integer.parseInt(classTotal.getText());
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Please Submit A Valid Number for Class Total");
				}
				try {
					classWeighted = Integer.parseInt(classWeightedString.getText());
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Please Submit A Valid Number for Weighted Total");
				}
				finally {
					GPA(frame, classTotalNum,classWeighted);
				}
			}
			
		});
		
	}

	
	public void GPA(JFrame frame, Integer classTotalNum, Integer classWeighted)  {
		
		List<JTextField> boxes = new ArrayList<JTextField>();
		List<JLabel> labels = new ArrayList<JLabel>();
			for(int i = 0; i <boxes.size();i++)
			{
					frame.remove(boxes.get(i));
					frame.remove(labels.get(i));
					
			}
			boxes.clear();
			labels.clear();
		String[] firstThrough = {"1st","2nd","3rd","4th", "5th", "6th", "7th", "8th"};
		for(int i = 0; i < classTotalNum;i++)
			boxes.add(new JTextField());
		for(int i = 0; i < classTotalNum;i++)
			labels.add(new JLabel(firstThrough[i]));
		int cons = 0;
		int x = 47;
		int y = 290;
		JLabel put = new JLabel("Put in your averages for each class");
		put.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		put.setBounds(100, 212, 285, 53);
		frame.getContentPane().add(put);
		Double GPA = 0.0;
		Integer sum = 0;
		try {
			
			for(int i = 0; i <classTotalNum;i++)
				{
						
						labels.get(cons).setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
						labels.get(cons).setBounds(x + 11, y - 40, 261, 53);
						frame.getContentPane().add(labels.get(cons));
						boxes.get(cons).setBounds(x, y, 40, 40);
						boxes.get(cons).setFont(new Font("Tahoma", Font.PLAIN, 18));
						frame.getContentPane().add(boxes.get(cons));
						boxes.get(cons).setColumns(10);
						x += 50;
						cons++;
						
				}
			
		}
		catch(Exception x1){}
		finally {
			frame.revalidate();
			frame.repaint();
		}
		Button button = new Button("Submit Averages");
		button.setBounds(186, 358, 100, 33);
		frame.getContentPane().add(button);
		frame.revalidate();
		frame.repaint();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer sumTemp = 0;
				try {
					for(int i = 0; i < classTotalNum;i++)
						sumTemp += Integer.parseInt(boxes.get(i).getText());
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "One or More Values are Incorrect");
				}
				finally {
					
					frame.revalidate();
					frame.repaint();
				}
				JLabel g = new JLabel();
				if(finalGPA(frame, sumTemp, classTotalNum, classWeighted, GPA) >= 0) {
					 g = new JLabel("Your GPA is " + finalGPA(frame, sumTemp, classTotalNum, classWeighted, GPA) );
				}
				g.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
				g.setBounds(165, 397, 176, 53);
				frame.getContentPane().add(g);
				
				}
			}
			
		);
		frame.revalidate();
		frame.repaint();
	}
	public void updateSum(Integer sum, Integer sumTemp)
	{
		sum = sumTemp;
	}
	public double finalGPA(JFrame frame,Integer sum, Integer classTotalNum, Integer classWeighted, Double GPA) {
		Integer tot = (5*classTotalNum) + classWeighted;
		Integer tote =  classTotalNum*100 - sum;
		Double totel = tote/10.0;
		Double total = tot - totel;
		GPA = total/(classTotalNum*1.0);
		return GPA;
	}
	public void but(Button button, JFrame frame,Integer sum, Integer classTotalNum, Integer classWeighted, List<JTextField> boxes, Double GPA) {
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer sumTemp = 0;
				try {
					for(int i = 0; i < classTotalNum;i++)
						sumTemp += Integer.parseInt(boxes.get(i).getText());
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "One or More Values are Incorrect");
				}
				finally {
					frame.revalidate();
					frame.repaint();
				}
				updateSum(sum, sumTemp);
				finalGPA(frame, sum, classTotalNum, classWeighted, GPA);
				JLabel g = new JLabel("Your GPA is " + GPA );
				g.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
				g.setBounds(165, 397, 176, 53);
				frame.getContentPane().add(g);
				
				}
			}
			
		);
		
	}
}

