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
		this.setTitle("���ƾ֤����ϵͳ");
		this.setSize(500, 600);
		this.setVisible(true);
		this.setBounds((screenWidth - windowsWidth)/2, (screenHeight - windowsHeight)/2, windowsWidth, windowsHeight);
		this.setJMenuBar(menuBar);
		MenuItemInit();
	}
	
	void MenuItemInit(){
		// �˵���
		userManagementMenu = new JMenu("�û�����");
		functionMenu = new JMenu("�����б�");
		documentManagementMenu = new JMenu("���ƾ֤����");
		subjectManagementMenu = new JMenu("��ƿ�Ŀ����");
		helpMenu = new JMenu("����");
		
		changePwdItem = new JMenuItem("�޸ĵ�ǰ�û�����");
		logoutItem = new JMenuItem("ע����ǰ�û�");
		exitItem = new JMenuItem("�˳�ϵͳ");

		addSubjectItem = new JMenuItem("��ӻ�ƿ�Ŀ");
		deleteSubjectItem = new JMenuItem("ɾ����ƿ�Ŀ");
		listSubjectItem = new JMenuItem("��ʾ��ƿ�Ŀ�б�");

		enteringDocumentItem = new JMenuItem("¼��ƾ֤");
		selectDocumentItem = new JMenuItem("��ѯƾ֤");
		generateBalanceSheet = new JMenuItem("�����ʲ���ծ��");
		deleteDocumentItem = new JMenuItem("ɾ��ƾ֤");

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
