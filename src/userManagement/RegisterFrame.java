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
		titleLabel = new JLabel("�û�ע��");
		titleLabel.setFont(new Font("Dialog", 1, 32));
		titleLabel.setForeground(Color.blue);
		loginNameLabel = new JLabel("�û�����");
		pwdLabel = new JLabel("���룺");
		pwdAgainLabel = new JLabel("ȷ�����룺");
		emailLabel = new JLabel("E-mail��");
		telLabel = new JLabel("�ֻ����룺");
		
		loginNameTextField = new JTextField(15);
		pwdField = new JPasswordField(15);
		pwdAgainField = new JPasswordField(15);
		emailTextField = new JTextField(15);
		telTextField = new JTextField(15);
		
		resettingButton = new JButton("���ñ��");
		registerButton = new JButton("�ύ");
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
		
		this.setTitle("�û�ע��");
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
	
	// �ύ��飬������ݣ��û������أ����������Ƿ���ͬ��Email�Ƿ�Ϸ���Tel�Ƿ�Ϸ�
	boolean loginNameCheck(){	// ���ܴ���ӡ����û�������
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
	
	boolean emailCheck(){	// ����������ʽ�ж�Email�Ƿ�Ϸ�
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
		String userInfo = "��ȷ�����������Ϣ��\n\n";
		if(login)
			userInfo += "�û�����" + loginNameTextField.getText() + "\n";
		else
			userInfo += "��ʾ�����û����ѱ�ע�ᣬ�����һ����" + "\n";
		
		if(pwdCheck)
			userInfo += "��������������ͬ��" + "\n";
		else
			userInfo += "��ʾ���������벻���Ϲ淶�����������룡" + "\n";
		
		if(email)
			userInfo += "E-mail��" + emailTextField.getText() + "\n";
		else
			userInfo += "��ʾ����E-mail�����Ϲ淶�����磺xxx@xxx.com�������������룡" + "\n";
		
		if(tel)
			userInfo += "Tel��" + telTextField.getText() + "\n";
		else
			userInfo += "��ʾ����Tel�����Ϲ淶��11λ�������������룡" + "\n";
		
		JOptionPane.showConfirmDialog(null, userInfo, "ȷ���û���Ϣ", JOptionPane.YES_NO_OPTION);
	}

}
