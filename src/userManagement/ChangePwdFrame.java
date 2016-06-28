package userManagement;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mainFrame.MainFrame;

public class ChangePwdFrame extends JFrame{
	int windowsWidth = 270;
	int windowsHeight = 150;
	int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	JLabel oldPwdLabel;
	JLabel newPwdLabel;
	JLabel newPwdAgainLabel;
	
	JPasswordField oldPwd;
	JPasswordField newPwd;
	JPasswordField newPwdAgain;
	
	JButton submitButton;
	
	public ChangePwdFrame(){
		oldPwdLabel = new JLabel("旧密码：");
		newPwdLabel = new JLabel("新密码：");
		newPwdAgainLabel = new JLabel("再确认：");

		oldPwd = new JPasswordField(15);
		newPwd = new JPasswordField(15);
		newPwdAgain = new JPasswordField(15);
		
		submitButton = new JButton("确认修改！");
		
		this.add(oldPwdLabel);
		this.add(oldPwd);
		this.add(newPwdLabel);
		this.add(newPwd);
		this.add(newPwdAgainLabel);
		this.add(newPwdAgain);
		this.add(submitButton);
		
		this.setLayout(new FlowLayout());
//		this.setSize(270, 160);
		this.setBounds((screenWidth - windowsWidth)/2, (screenHeight - windowsHeight)/2, windowsWidth, windowsHeight);
		this.setTitle("密码修改");
		this.setResizable(false);
		this.setVisible(true);
	
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(oldPwdCheck() && newPwdCheck()){
					JOptionPane.showMessageDialog(null, "密码修改成功。");
					dispose();
					new LoginFrame();
				}
				else
					JOptionPane.showMessageDialog(null, "密码修改失败，请重试！");	
			}
		});
	}
	
	boolean oldPwdCheck(){
		// 等待数据库提供接口
		
		char[] oldPwdChar = oldPwd.getPassword();
		String oldPwdStr = new String(oldPwdChar);
//		if(oldPwdChar )
		return true;
//		else
//		return false;
		
	}
	boolean newPwdCheck(){
		char[] pwdChar = newPwd.getPassword();
		char[] pwdAgainChar = newPwdAgain.getPassword();
		String pwdStr = new String(pwdChar);
		String pwdAgainStr = new String(pwdAgainChar);		
		if(pwdStr.length() > 0)
			if(pwdStr.equals(pwdAgainStr)){
				return true;
			}else{
				newPwd.setText(null);
				newPwdAgain.setText(null);
				return false;
			}
		else
			return false;
	}
	
//	public static void main(String[] args) {
//		new ChangePwdFrame();
//	}
}
