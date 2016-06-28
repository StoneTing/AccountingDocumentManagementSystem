package userManagement;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame{
	int windowsWidth = 190;
	int windowsHeight = 380;
	int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	JLabel titleLabel;
	JLabel loginNameLabel;
	JLabel pwdLabel;
	JLabel pwdAgainLabel;
	JLabel emailLabel;
	JLabel telLabel;
	
	JTextField loginNameTextField;
	JPasswordField pwdField;
	JPasswordField pwdAgainField;
	JTextField emailTextField;
	JTextField telTextField;
	
	JButton resettingButton;
	JButton registerButton;
	
	RegisterFrame(){
		titleLabel = new JLabel("用户注册");
		titleLabel.setFont(new Font("Dialog", 1, 32));
		titleLabel.setForeground(Color.blue);
		loginNameLabel = new JLabel("用户名：");
		pwdLabel = new JLabel("密码：");
		pwdAgainLabel = new JLabel("确认密码：");
		emailLabel = new JLabel("E-mail：");
		telLabel = new JLabel("手机号码：");
		
		loginNameTextField = new JTextField(15);
		pwdField = new JPasswordField(15);
		pwdAgainField = new JPasswordField(15);
		emailTextField = new JTextField(15);
		telTextField = new JTextField(15);
		
		resettingButton = new JButton("重置表格");
		registerButton = new JButton("提交");
		registerButton.setForeground(Color.red);
		
		resettingButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				resetting();
			}
		});
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				checkMessageBoxes(loginNameCheck(), pwdCheck(), emailCheck(), telCheck());
			}
		});
		
		this.setTitle("用户注册");
		this.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		this.setBounds((screenWidth - windowsWidth)/2, (screenHeight - windowsHeight)/2, windowsWidth, windowsHeight);
		this.setVisible(true);
		this.setResizable(false);
		
		this.add(titleLabel);
		this.add(loginNameLabel);
		this.add(loginNameTextField);
		this.add(pwdLabel);
		this.add(pwdField);
		this.add(pwdAgainLabel);
		this.add(pwdAgainField);
		this.add(emailLabel);
		this.add(emailTextField);
		this.add(telLabel);
		this.add(telTextField);
		this.add(resettingButton);
		this.add(registerButton);
	}
	
	void resetting(){
		loginNameTextField.setText(null);
		pwdField.setText(null);
		pwdAgainField.setText(null);
		emailTextField.setText(null);
		telTextField.setText(null);
	}
	
	// 提交检查，检查内容：用户名查重，两次密码是否相同，Email是否合法，Tel是否合法
	boolean loginNameCheck(){	// 功能待添加——用户名查重
		return true;
	}
	
	boolean pwdCheck(){
		char[] pwdChar = pwdField.getPassword();
		char[] pwdAgainChar = pwdAgainField.getPassword();
		String pwdStr = new String(pwdChar);
		String pwdAgainStr = new String(pwdAgainChar);		
		if(pwdStr.length() > 0)
			if(pwdStr.equals(pwdAgainStr)){
				return true;
			}else{
				pwdField.setText(null);
				pwdAgainField.setText(null);
				return false;
			}
		else
			return false;
	}
	
	boolean emailCheck(){	// 利用正则表达式判断Email是否合法
		String str = emailTextField.getText();
		String pat = "[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9]+(\\.(com))";
		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(str);
		if(m.matches())
			return true;
		else{
			emailTextField.setText(null);
			return false;
		}
	}
	
	boolean telCheck(){
		if(telTextField.getText().length() == 11)
			return true;
		else
			telTextField.setText(null);
			return false;
		
	}
	
	void checkMessageBoxes(boolean login, boolean pwdCheck, boolean email, boolean tel){
		String userInfo = "请确认您输入的信息：\n\n";
		if(login)
			userInfo += "用户名：" + loginNameTextField.getText() + "\n";
		else
			userInfo += "提示：该用户名已被注册，请更换一个！" + "\n";
		
		if(pwdCheck)
			userInfo += "两次密码输入相同。" + "\n";
		else
			userInfo += "提示：密码输入不符合规范，请重新输入！" + "\n";
		
		if(email)
			userInfo += "E-mail：" + emailTextField.getText() + "\n";
		else
			userInfo += "提示：该E-mail不符合规范（例如：xxx@xxx.com），请重新输入！" + "\n";
		
		if(tel)
			userInfo += "Tel：" + telTextField.getText() + "\n";
		else
			userInfo += "提示：该Tel不符合规范（11位），请重新输入！" + "\n";
		
		JOptionPane.showConfirmDialog(null, userInfo, "确认用户信息", JOptionPane.YES_NO_OPTION);
	}

}
