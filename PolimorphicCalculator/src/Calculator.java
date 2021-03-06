

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator {

	//Declare Calculator's graphical components
	protected JFrame frame;
	protected JPanel windowContent;
	protected JMenu edit;
	protected JMenu view;
	protected JMenu help;
	protected JTextField displayField;
	protected JButton backspace;
	protected JButton ce;
	protected JButton c;
	protected JButton one;
	protected JButton two;
	protected JButton three;
	protected JButton four;
	protected JButton five;
	protected JButton six;
	protected JButton seven;
	protected JButton eight;
	protected JButton nine;
	protected JButton zero;
	protected JButton mc, mr, ms, mPlus;
	protected JButton sqrt, mod, inv, equal;
	protected JButton plus, minus, div, mult;
	protected JButton dot, plusMinus;
	
	/**
	 * Constructor creates the components, registers them with listeners, 
	 * adds them to the frame
	 * @param args
	 */
	
	public Calculator(){
		
		//create a panel; its layout manager will be set in subclasses
		
		windowContent = new JPanel();
		
		//create the components
		
		displayField = new JTextField();
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		edit = new JMenu("Edit");
		view = new JMenu("View");
		help = new JMenu("Help");
		backspace = new JButton("Backspace");
		ce = new JButton("CE");
		c = new JButton("C");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		mc = new JButton("MC");
		mr = new JButton("MR");
		ms = new JButton("MS");
		mPlus = new JButton("M+");
		plus = new JButton("+");
		minus = new JButton("-");
		div = new JButton("/");
		mult = new JButton("*");
		sqrt = new JButton("sqrt");
		mod = new JButton("%");
		inv = new JButton("1/x");
		equal = new JButton("=");
		dot = new JButton(".");
		plusMinus = new JButton("+/-");
		
		//create listener and register components with it		
		
		CalculatorEngine calcEngine = new CalculatorEngine(this);

		backspace.addActionListener(calcEngine);
		ce.addActionListener(calcEngine);
		c.addActionListener(calcEngine);
		plus.addActionListener(calcEngine);
		minus.addActionListener(calcEngine);
		div.addActionListener(calcEngine);
		mult.addActionListener(calcEngine);
		sqrt.addActionListener(calcEngine);
		mod.addActionListener(calcEngine);
		one.addActionListener(calcEngine);
		two.addActionListener(calcEngine);
		three.addActionListener(calcEngine);
		four.addActionListener(calcEngine);
		five.addActionListener(calcEngine);
		six.addActionListener(calcEngine);
		seven.addActionListener(calcEngine);
		eight.addActionListener(calcEngine);
		nine.addActionListener(calcEngine);
		zero.addActionListener(calcEngine);
		mc.addActionListener(calcEngine);
		mr.addActionListener(calcEngine);
		ms.addActionListener(calcEngine);
		mPlus.addActionListener(calcEngine);
		inv.addActionListener(calcEngine);
		equal.addActionListener(calcEngine);
		dot.addActionListener(calcEngine);
		plusMinus.addActionListener(calcEngine);
		
	
		//add the components to the panel
		
		windowContent.add(displayField);
		windowContent.add(edit);
		windowContent.add(view);
		windowContent.add(help);
		windowContent.add(backspace);
		windowContent.add(ce);
		windowContent.add(c);
		windowContent.add(one);
		windowContent.add(two);
		windowContent.add(three);
		windowContent.add(four);
		windowContent.add(five);
		windowContent.add(six);
		windowContent.add(seven);
		windowContent.add(eight);
		windowContent.add(nine);
		windowContent.add(zero);
		windowContent.add(plus);
		windowContent.add(minus);
		windowContent.add(div);
		windowContent.add(mult);
		windowContent.add(sqrt);
		windowContent.add(mod);
		windowContent.add(inv);
		windowContent.add(equal);
		windowContent.add(mc);
		windowContent.add(mr);
		windowContent.add(ms);
		windowContent.add(mPlus);
		windowContent.add(dot);
		windowContent.add(plusMinus);
		
		//create the frame and set its content pane
		
		frame = new JFrame("Cristina's Beautiful Calculator");
		frame.setContentPane(windowContent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//public API

	public String getDisplayFieldValue() {
		return displayField.getText();
	}

	public void setDisplayFieldValue(String val) {
		this.displayField.setText(val);
	}


}

