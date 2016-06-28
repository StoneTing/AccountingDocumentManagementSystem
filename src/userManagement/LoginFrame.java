package userManagement;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mainFrame.MainFrame;

public class LoginFrame extends JFrame{
	JPanel titlePanel;
	JPanel userPanel;
	
	int windowsWidth = 500;
	int windowsHeight = 130;
	int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	JLabel titleLabel;
	JLabel loginNameLabel;
	JLabel pwdLabel;
	JLabel versionLabel;
	
	JTextField loginNameTextField;
	
	JPasswordField pwdField;
	
	JButton informationButton;
	JButton registerButton;
	JButton resettingButton;
	JButton loginButton;
	
	String versionStr;
	
	public LoginFrame(){		
		versionStr = " V1.0";
		
		titlePanel = new JPanel();
		userPanel = new JPanel();
		
		titleLabel = new JLabel("会计凭证管理系统");
		titleLabel.setForeground(Color.blue);
		titleLabel.setFont(new Font("Dialog", 1, 25));
		loginNameLabel = new JLabel("用户名：");
		pwdLabel = new JLabel("密码：     ");
		versionLabel = new JLabel(versionStr);
		
		loginNameTextField = new JTextField(15);
		pwdField = new JPasswordField(15);
		
		informationButton = new JButton("葫芦娃组--成员信息");
		registerButton = new JButton("注册");
		resettingButton = new JButton("重置");
		loginButton = new JButton("登录");
		loginButton.setForeground(Color.red);
		
		this.setTitle("会计凭证管理系统" + versionStr);
		this.setBounds((screenWidth - windowsWidth)/2, (screenHeight - windowsHeight)/2, windowsWidth, windowsHeight);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 2));
		this.setResizable(false);
		this.add(titlePanel);
		this.add(userPanel);
		
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new RegisterFrame();
			}
		});
		
		resettingButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				resetting();
			}
		});
		
		//loginButton的监听器待添加
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		titlePanel.setVisible(true);
		titlePanel.setSize(250, 100);
		titlePanel.setLayout(new FlowLayout());
		
		userPanel.setVisible(true);
		userPanel.setSize(250, 100);
		userPanel. setLayout(new FlowLayout());
		
		
		titlePanel.add(titleLabel);
		titlePanel.add(versionLabel);
		titlePanel.add(informationButton);
		
		userPanel.add(loginNameLabel);
		userPanel.add(loginNameTextField);
		userPanel.add(pwdLabel);
		userPanel.add(pwdField);
		userPanel.add(registerButton);
		userPanel.add(resettingButton);
		userPanel.add(loginButton);
		
	}

	void resetting(){
		loginNameTextField.setText(null);
		pwdField.setText(null);
	}
	
	void login(){
		// 等待与数据库交互，验证用户名和密码
		dispose();
		new MainFrame();
	}
}