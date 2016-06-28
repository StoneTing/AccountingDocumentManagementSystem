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
		// 按钮
		documentButton = new JButton("会计科目管理");
		subjectButton = new JButton("会计凭证管理");

		addSubjectButton = new JButton("添加会计科目");
		deleteSubjectButton = new JButton("删除会计科目");
		listSubjectButton = new JButton("显示会计科目列表");

		enteringDocumentButton = new JButton("凭证录入");
		selectDocumentButton = new JButton("凭证查询");
		deleteDocumentButton = new JButton("凭证删除");
		generateBalanceSheetButton = new JButton("生成资产负债表");

		// 五个区的面板
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

		nowUserLabel = new JLabel("当前用户：");
		nowTimeLabel = new JLabel("时间：");

		// 状态栏
		statusBar.add(nowUserLabel);
		statusBar.add(nowTimeLabel);
		

		functionWestPanel.setLayout(new FlowLayout());
		functionWestPanel.add(documentButton);
		functionWestPanel.add(subjectButton);

		// 边界布局
		functionWestPanel.setLayout(new FlowLayout());
		functionWestPanel.add(documentButton);
		functionWestPanel.add(subjectButton);
	}
}
