package mainFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ContentPanl extends JPanel {
	JPanel allPanel;
	JPanel functionWestPanel, detailFunctionCenterPanel, showAreaEastPanel, stateSouthPanel;

	JButton documentButton, subjectButton;
	JButton addSubjectButton, deleteSubjectButton, listSubjectButton;
	JButton enteringDocumentButton, selectDocumentButton, deleteDocumentButton, generateBalanceSheetButton;

	JToolBar statusBar = new JToolBar();
	JLabel nowUserLabel, nowTimeLabel;

	public ContentPanl() {
		// ��ť
		documentButton = new JButton("��ƿ�Ŀ����");
		subjectButton = new JButton("���ƾ֤����");

		addSubjectButton = new JButton("��ӻ�ƿ�Ŀ");
		deleteSubjectButton = new JButton("ɾ����ƿ�Ŀ");
		listSubjectButton = new JButton("��ʾ��ƿ�Ŀ�б�");

		enteringDocumentButton = new JButton("ƾ֤¼��");
		selectDocumentButton = new JButton("ƾ֤��ѯ");
		deleteDocumentButton = new JButton("ƾ֤ɾ��");
		generateBalanceSheetButton = new JButton("�����ʲ���ծ��");

		// ����������
		allPanel = new JPanel();
		allPanel.setLayout(new BorderLayout());

		functionWestPanel = new JPanel();
		detailFunctionCenterPanel = new JPanel();
		showAreaEastPanel = new JPanel();
		stateSouthPanel = new JPanel();

		this.add(allPanel);

		allPanel.add(BorderLayout.WEST, functionWestPanel);
		this.add(BorderLayout.CENTER, detailFunctionCenterPanel);
		this.add(BorderLayout.EAST, showAreaEastPanel);
		this.add(BorderLayout.SOUTH, statusBar);

		nowUserLabel = new JLabel("��ǰ�û���");
		nowTimeLabel = new JLabel("ʱ�䣺");

		// ״̬��
		statusBar.add(nowUserLabel);
		statusBar.add(nowTimeLabel);
		

		functionWestPanel.setLayout(new FlowLayout());
		functionWestPanel.add(documentButton);
		functionWestPanel.add(subjectButton);

		// �߽粼��
		functionWestPanel.setLayout(new FlowLayout());
		functionWestPanel.add(documentButton);
		functionWestPanel.add(subjectButton);
	}
}
