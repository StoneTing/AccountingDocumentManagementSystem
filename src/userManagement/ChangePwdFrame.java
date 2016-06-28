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
		oldPwdLabel = new JLabel("�����룺");
		newPwdLabel = new JLabel("�����룺");
		newPwdAgainLabel = new JLabel("��ȷ�ϣ�");

		oldPwd = new JPasswordField(15);
		newPwd = new JPasswordField(15);
		newPwdAgain = new JPasswordField(15);
		
		submitButton = new JButton("ȷ���޸ģ�");
		
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
		this.setTitle("�����޸�");
		this.setResizable(false);
		this.setVisible(true);
	
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(oldPwdCheck() && newPwdCheck()){
					JOptionPane.showMessageDialog(null, "�����޸ĳɹ���");
					dispose();
					new LoginFrame();
				}
				else
					JOptionPane.showMessageDialog(null, "�����޸�ʧ�ܣ������ԣ�");	
			}
		});
	}
	
	boolean oldPwdCheck(){
		// �ȴ����ݿ��ṩ�ӿ�
		
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
