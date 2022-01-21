package ui;

import java.awt.Dimension;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class StatisticsPanel extends JPanel implements ActionListener {

	private final int WIDTH = 500, HEIGHT = 500;
	private JLabel titleLBL, outputLBL, inputLBL, listLBL, outputTitleLBL;
	private JButton inputButton, maxButton, minButton, meanButton;
	private JTextField numInput;
	private JLabel infoLBL;
	private ArrayList<Integer> numList = new ArrayList<Integer>();

	public StatisticsPanel() {
		this.setBackground(new Color(51, 204, 153));
		this.setPreferredSize(new Dimension(500, 489));
		this.setLayout(null);

		titleLBL = new JLabel();
		titleLBL.setFont(new Font("HP Simplified", Font.PLAIN, 29));
		titleLBL.setHorizontalAlignment(SwingConstants.CENTER);
		titleLBL.setText("Statistics");
		titleLBL.setBounds(165, 11, 148, 40);
		this.add(titleLBL);

		outputTitleLBL = new JLabel();
		outputTitleLBL.setFont(new Font("Sitka Banner", Font.PLAIN, 28));
		outputTitleLBL.setVerticalAlignment(SwingConstants.TOP);
		outputTitleLBL.setText("Output:");
		outputTitleLBL.setHorizontalAlignment(SwingConstants.CENTER);
		outputTitleLBL.setBounds(288, 296, 188, 40);
		this.add(outputTitleLBL);

		inputLBL = new JLabel();
		inputLBL.setBounds(278, 296, 198, 40);
		this.add(inputLBL);

		listLBL = new JLabel();
		listLBL.setBackground(Color.WHITE);
		listLBL.setOpaque(true);
		listLBL.setBounds(48, 88, 246, 157);
		listLBL.setHorizontalAlignment(SwingConstants.CENTER);
		listLBL.setFont(new Font("SimSun", Font.BOLD, 21));
		this.add(listLBL);

		inputButton = new JButton();
		inputButton.setBackground(Color.WHITE);
		inputButton.setVerticalAlignment(SwingConstants.TOP);
		inputButton.setText("Input");
		inputButton.setFont(new Font("Sitka Banner", Font.PLAIN, 28));
		inputButton.setBounds(344, 189, 100, 40);
		inputButton.addActionListener(this);
		this.add(inputButton);

		maxButton = new JButton();
		maxButton.setText("Maximum");
		maxButton.setVerticalAlignment(SwingConstants.TOP);
		maxButton.setFont(new Font("Sitka Banner", Font.PLAIN, 28));
		maxButton.setBounds(45, 357, 209, 40);
		maxButton.setBackground(Color.WHITE);
		maxButton.addActionListener(this);
		this.add(maxButton);

		minButton = new JButton();
		minButton.setText("Minimum");
		minButton.setVerticalAlignment(SwingConstants.TOP);
		minButton.setFont(new Font("Sitka Banner", Font.PLAIN, 28));
		minButton.setBounds(45, 419, 209, 40);
		minButton.setBackground(Color.WHITE);
		minButton.addActionListener(this);
		this.add(minButton);

		meanButton = new JButton();
		meanButton.setVerticalAlignment(SwingConstants.TOP);
		meanButton.setText("Mean");
		meanButton.setFont(new Font("Sitka Banner", Font.PLAIN, 28));
		meanButton.setBounds(45, 296, 209, 40);
		meanButton.setBackground(Color.WHITE);
		meanButton.addActionListener(this);
		this.add(meanButton);

		outputLBL = new JLabel();
		outputLBL.setOpaque(true);
		outputLBL.setBackground(Color.WHITE);
		outputLBL.setHorizontalAlignment(SwingConstants.CENTER);
		outputLBL.setFont(new Font("Serif", Font.BOLD, 21));
		outputLBL.setBounds(288, 332, 188, 127);
		add(outputLBL);

		numInput = new JTextField();
		numInput.setHorizontalAlignment(SwingConstants.CENTER);
		numInput.setFont(new Font("SimSun", Font.BOLD, 21));
		numInput.setBounds(366, 106, 57, 46);
		numInput.setColumns(10);
		add(numInput);

		infoLBL = new JLabel("Add numbers to the list (up to 10), and click a button to perform an operation\r\n");
		infoLBL.setFont(new Font("Sitka Banner", Font.PLAIN, 13));
		infoLBL.setBounds(48, 46, 390, 25);
		add(infoLBL);
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == inputButton) {
			addInput();
		} else if (src == maxButton) {
			max();
		} else if (src == minButton) {
			min();
		} else if (src == meanButton) {
			mean();
		}

	}

	private void mean() {
		int sum = 0;
		double mean;

		for (int i = 0; i < numList.size(); i++) {
			sum += numList.get(i);
		}
		mean = sum / numList.size();

		outputLBL.setText("" + mean);
	}

	private void min() {
		int min = numList.get(0);

		for (int i = 0; i < numList.size(); i++) {
			if (min > numList.get(i)) {
				min = numList.get(i);
			}
		}

		outputLBL.setText("" + min);
	}

	private void max() {
		int max = numList.get(0);

		for (int i = 0; i < numList.size(); i++) {
			if (numList.get(i) > max) {
				max = numList.get(i);
			}
		}

		outputLBL.setText("" + max);
	}

	private void addInput() {
		if (numList.size() >= 10) {
			JOptionPane.showMessageDialog(inputLBL, "Too many numbers", "Make sure you have 10 or less numbers",
					JOptionPane.ERROR_MESSAGE);
		} else {
			if (numInput.getText() != "" && numInput.getText() != null) {
				int num = Integer.parseInt(numInput.getText());
				numList.add(num);
				numInput.setText("");

				String list = "";
				for (int i = 0; i < numList.size(); i++) {
					if (i == 0) {
						list += numList.get(i);
					} else {
						list += "," + numList.get(i);
					}
				}
				listLBL.setText(list);
			}

		}
	}
}
