package mainFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import userManagement.ChangePwdFrame;
import userManagement.LoginFrame;

public class MainFrame extends JFrame{
	int windowsWidth = 1000;
	int windowsHeight = 650;
	int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	JMenuBar menuBar = new JMenuBar();;
	JMenu userManagementMenu;
	JMenu functionMenu;
	JMenu documentManagementMenu, subjectManagementMenu;
	JMenu helpMenu;
	JMenuItem changePwdItem, logoutItem, exitItem;
	JMenuItem addSubjectItem, listSubjectItem, deleteSubjectItem;
	JMenuItem enteringDocumentItem, selectDocumentItem, deleteDocumentItem, generateBalanceSheet;
	
	public MainFrame(){
		this.setTitle("会计凭证管理系统");
		this.setSize(500, 600);
		this.setVisible(true);
		this.setBounds((screenWidth - windowsWidth)/2, (screenHeight - windowsHeight)/2, windowsWidth, windowsHeight);
		this.setJMenuBar(menuBar);
		MenuItemInit();
	}
	
	void MenuItemInit(){
		// 菜单栏
		userManagementMenu = new JMenu("用户管理");
		functionMenu = new JMenu("功能列表");
		documentManagementMenu = new JMenu("会计凭证管理");
		subjectManagementMenu = new JMenu("会计科目管理");
		helpMenu = new JMenu("帮助");
		
		changePwdItem = new JMenuItem("修改当前用户密码");
		logoutItem = new JMenuItem("注销当前用户");
		exitItem = new JMenuItem("退出系统");

		addSubjectItem = new JMenuItem("添加会计科目");
		deleteSubjectItem = new JMenuItem("删除会计科目");
		listSubjectItem = new JMenuItem("显示会计科目列表");

		enteringDocumentItem = new JMenuItem("录入凭证");
		selectDocumentItem = new JMenuItem("查询凭证");
		generateBalanceSheet = new JMenuItem("生成资产负债表");
		deleteDocumentItem = new JMenuItem("删除凭证");

		menuBar.add(userManagementMenu);
		menuBar.add(functionMenu);
		menuBar.add(helpMenu);

		userManagementMenu.add(changePwdItem);
		userManagementMenu.add(logoutItem);
		userManagementMenu.addSeparator();
		userManagementMenu.add(exitItem);
		
		changePwdItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new ChangePwdFrame();
				dispose();
			}
		});
		logoutItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new LoginFrame();
			}
		});
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		functionMenu.add(subjectManagementMenu);
		functionMenu.add(documentManagementMenu);

		documentManagementMenu.add(addSubjectItem);
		documentManagementMenu.add(listSubjectItem);
		documentManagementMenu.addSeparator();
		documentManagementMenu.add(deleteSubjectItem);
		
		subjectManagementMenu.add(enteringDocumentItem);
		subjectManagementMenu.add(selectDocumentItem);
		subjectManagementMenu.addSeparator();
		subjectManagementMenu.add(deleteDocumentItem);
		subjectManagementMenu.addSeparator();
		subjectManagementMenu.add(generateBalanceSheet);

	}

//	public static void main(String[] args) {
//		new MainFrame();
//	}
}
