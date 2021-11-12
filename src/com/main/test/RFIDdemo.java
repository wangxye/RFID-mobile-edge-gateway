package com.main.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import com.rfid.main.basicOperation.BasicOperateOnclick;
import com.rfid.main.basicOperation.BasicParameter;
import com.rfid.main.basicOperation.BasicTable;
import com.rfid.main.basicOperation.BasicTree;
import com.rfid.main.basicOperation.IPTextField;
import com.rfid.main.deviceParams.AntennaParameter;
import com.rfid.main.deviceParams.DeviceParamsOnclick;
import javax.swing.border.LineBorder;

/**
 * 
 * <p>
 * Title: RFIDdemo
 * </p>
 * <p>
 * Description: ҳ���ʼ��������
 * </p>
 * 
 * @author wangxuanye
 * @date 2020��4��26��
 */
public class RFIDdemo extends JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * �����ĺ�Ӣ���л������������
	 */
	public static String[] language = { "��������", "English" };
	/**
	 * Ĭ�ϼ�������
	 */
	public static ResourceBundle rs = ResourceBundle.getBundle("language", Locale.CHINA);
	/**
	 * main ����
	 */
	private JPanel contentPane;
	/**
	 * ��д������_net
	 */
	protected static JComboBox<String> cbotype_net;
	/**
	 * ��д������_com
	 */
	protected JComboBox<String> cbotype_com;
	/**
	 * ����ѡ������1
	 */
	protected static JRadioButton rdoRecieveAntenna1;
	/**
	 * ����ѡ������2
	 */
	protected static JRadioButton rdoRecieveAntenna2;
	/**
	 * ����ѡ������3
	 */
	protected static JRadioButton rdoRecieveAntenna3;
	/**
	 * ����ѡ������4
	 */
	protected static JRadioButton rdoRecieveAntenna4;
	/**
	 * ˢ��IP��ʽ
	 */
	protected static JButton btnRefresh;
	/**
	 * ˢ��COM��ʽ
	 */
	protected static JButton btnRefresh_1;
	/**
	 * ��������
	 */
	protected static JButton btnSave;
	/**
	 * ��ȡ����
	 */
	protected static JButton btnRead;
	/**
	 * main panel
	 */
	protected static JPanel panel_main;
	/**
	 * ��ҳѡ���
	 */
	protected static JTabbedPane tabbedPane;
	/**
	 * ��ҳѡ���
	 */
	protected static JTabbedPane tabbedPane_1;
	/**
	 * ͨ��top panel
	 */
	protected static JPanel panel_general;
	/***********************************
	 * ͨ��left
	 ***********************************/

	/**
	 * ͨ��left panel
	 */
	protected static JPanel panel_generalLeft;
	/**
	 * ͨѶģʽ
	 */
	protected static JPanel panel_ReaderType;
	/**
	 * ͨѶģʽ-1����
	 */
	protected static JRadioButton rdoOneAnt;
	/**
	 * ͨѶģʽ-4����
	 */
	protected static JRadioButton rdoFourAnt;
	/**
	 * ͨѶģʽ-8����
	 */
	protected static JRadioButton rdoEightAnt;
	/**
	 * �����豸panel
	 */
	protected static JPanel panel_onlineDevice;
	/**
	 * �����豸������
	 */
	protected static JScrollPane scrollPane_tree;
	/**
	 * ������ʾͨѶ��ʽ
	 */
	protected static JTree tree_onlineDevice;
	/**
	 * ��ʾͨѶ��ʽIP��COM
	 */
	protected static DefaultTableModel tableModel;
	/**
	 * 
	 */
	protected static DefaultMutableTreeNode[] nodeTree = null;
	/**
	 * �����豸���ζ���
	 */
	protected static DefaultMutableTreeNode node_1 = new DefaultMutableTreeNode(
			RFIDdemo.rs.getString("LVOnlineEquipment"));
	/**
	 * �����豸������Ĭ��ģʽ
	 */
	protected static DefaultTreeModel model = new DefaultTreeModel(node_1, true);
	/**
	 * �����豸���ζ���
	 */
	protected static DefaultMutableTreeNode node_2 = new DefaultMutableTreeNode(
			RFIDdemo.rs.getString("LVOnlineEquipment"));
	/**
	 * 
	 */
	protected static DefaultMutableTreeNode note = new DefaultMutableTreeNode();
	/**
	 * ��ȡѡ�нڵ�ĸ��ڵ�
	 */
	protected static DefaultMutableTreeNode parent = new DefaultMutableTreeNode();
	/**
	 * ������IP��ַ
	 */
	protected static JPanel panel_newAddIPAdress;
	/**
	 * ����IP
	 */
	protected static JButton btnAddIP;
	/**
	 * ͨѶ��ʽ���ӺͶϿ���Ť
	 */
	protected static JPanel panel_connectAndDisconnect;
	/**
	 * ͨѶ��ʽ-����
	 */
	protected static JButton btnConnect;
	/**
	 * ͨѶ��ʽ-�Ͽ�
	 */
	protected static JButton btnDisconnect;
	/***********************************
	 * ͨ��right
	 ***********************************/
	/**
	 * ͨ��right panel
	 */
	protected static JPanel panel_generalRight;
	/**
	 * ��ʾ��ǩpanel
	 */
	protected static JPanel panel_readerData;
	/**
	 * ���ܲ�������
	 */
	protected static JPanel panel_devicework;
	/**
	 * ��ǩ����panel
	 */
	protected static JPanel panel_readerCount;
	/**
	 * ��ǩ��
	 */
	protected static JLabel labelNub;
	/**
	 * ����ǩ��
	 */
	protected static JLabel labelTagCount;
	/**
	 * ��ȡ��ǩ����panel
	 */
	protected static JPanel panel_readerTagCount;
	/**
	 * ����ǩ��
	 */
	protected static JLabel labelReadCount;
	/**
	 * ��ȡ��ǩ����
	 */
	protected static JLabel labelCount;
	/***************************
	 * ��ʾ��ǩ��Ϣ
	 **************************/
	/**
	 * ��ʾ��ǩ��Ϣpanel
	 */
	protected static JPanel panel_tableDataShow;
	/**
	 * ��ʾ��ǩ��Ϣ������
	 */
	protected static JScrollPane sp_showTagInfo;
	/**
	 * ��ʾ��ǩ��Ϣtable
	 */
	protected static JTable tbl_showTagInfo;
//	/**
//	 * ѡ�񱣴��ļ�
//	 */
//	protected static boolean chooseSaveFile;
	/**
	 * �����������panel
	 */
	protected static JPanel panel_operationData;
	/**
	 * Ѱ��һ��
	 */
	protected static JButton btnInventoryOnce;
	/**
	 * ��������
	 */
	protected static JButton btnStart;
	/**
	 * ֹͣ����
	 */
	protected static JButton btnStop;
	/**
	 * �������
	 */
	protected static JButton btnClearData;
	/**************************************************************************
	 * �������� end
	 *************************************************************************/
	/**************************************************************************
	 * ͨѶ��������end
	 *************************************************************************/
	/**************************************************************************
	 * �豸����start
	 *************************************************************************/
	/**
	 * �豸����
	 */
	protected static JPanel panel_parametersSetup;
	/**
	 * ��ʾ��Ϣ
	 */
	protected static Label labelShowInfo;
	/**********************
	 * �豸����panel_start
	 **********************/
	protected static JPanel panel_DeviceAntenna;
	/**
	 * ���
	 */
	protected static JLabel lblDeviceAntennaWorkTime;
	/**
	 * ����
	 */
	protected static JLabel lblDeviceAntennaPower;

	/**********************
	 * �豸����panel_end
	 **********************/
	/**
	 * ����1
	 */
	protected static JCheckBox chkDeviceAntenna1;
	/**
	 * ����2
	 */
	protected static JCheckBox chkDeviceAntenna2;
	/**
	 * ����3
	 */
	protected static JCheckBox chkDeviceAntenna3;
	/**
	 * ����4
	 */
	protected static JCheckBox chkDeviceAntenna4;
	/**
	 * ���1
	 */
	protected static JComboBox<Integer> cboDeviceAntennaWorkTime1;
	/**
	 * ���2
	 */
	protected static JComboBox<Integer> cboDeviceAntennaWorkTime2;
	/**
	 * ���3
	 */
	protected static JComboBox<Integer> cboDeviceAntennaWorkTime3;
	/**
	 * ���4
	 */
	protected static JComboBox<Integer> cboDeviceAntennaWorkTime4;
	/**
	 * ����1
	 */
	protected static JComboBox<Integer> cboDeviceAntennaPower1;
	/**
	 * ����2
	 */
	protected static JComboBox<Integer> cboDeviceAntennaPower2;
	/**
	 * ����3
	 */
	protected static JComboBox<Integer> cboDeviceAntennaPower3;
	/**
	 * ����4
	 */
	protected static JComboBox<Integer> cboDeviceAntennaPower4;
	/**
	 * �������ð�Ť
	 */
	protected static JPanel panel_antennaParamsButton;
	/**
	 * ���߶�ȡ
	 */
	protected static JButton btnDeviceAntennaRead;
	/**
	 * ��������
	 */
	protected static JButton btnDeviceAntannaSet;
	/**
	 * ���
	 */
	protected static JComboBox<Integer> cboDeviceAntennaWorkTime5;
	/**
	 * ����5
	 */
	protected static JComboBox<Integer> cboDeviceAntennaPower5;
	/**
	 * ����5
	 */
	protected static JCheckBox chkDeviceAntenn5;
	/**
	 * ���߷���ѡ��
	 */
	protected static JLabel lblDeviceAntennaLaunch;
	/**
	 * �ж��Ƿ�����������
	 */
	protected static boolean isContinueReadCard = false;

	/**********************
	 * ����¼��
	 **********************/
	protected static JPanel panel_DataEntry;
	/**
	 * ��������
	 */
	protected static JLabel lblType;
	/**
	 * �������
	 */
	protected static JLabel lblMaterial;
	/**
	 * ���󳤶�
	 */
	protected static JLabel lblLength;
	/**
	 * ������
	 */
	protected static JLabel lblWidth;
	/**
	 * ����߶�
	 */
	protected static JLabel lblHight;
	/**
	 * ��������txt
	 */
	protected static JTextField txtType;
	/**
	 * �������txt
	 */
	protected static JTextField txtMaterial;
	/**
	 * ���󳤶�txt
	 */
	protected static JTextField txtLength;
	/**
	 * ������txt
	 */
	protected static JTextField txtWidth;
	/**
	 * ����߶�txt
	 */
	protected static JTextField txtHight;
	/**
	 * ����¼�밴Ťpanel
	 */
	protected static JPanel panel_networkParamButton;
	/**
	 * ���ݶ�ȡ
	 */
	protected static JButton btnDataRead;
	/**
	 * ��������
	 */
	protected static JButton btnDataSetting;
	/**
	 * Ѱ������
	 */
	protected static JPanel panel_PortSetting;
	/**
	 * �Զ���
	 */
	protected static JRadioButton rdoETSI;
	/**
	 * Ĭ��EPC
	 */
	protected static JRadioButton rdoFCC;
	/**
	 * Ѱ������
	 */
	protected static JLabel lblMHZ;
	/**
	 * Ѱ������_��ʼ��ַ
	 */
	protected static JLabel lblPortIncluding;
	/**
	 * Ѱ������_����
	 */
	protected static JLabel lblMHZ_2;
	/**
	 * Ѱ������_����
	 */
	protected static JButton btnPortSet;
	/**
	 * Ƶ���ȡ
	 */
	protected static JButton btnPortRead;

	/**
	 * ��д��IP
	 */
	protected static JLabel labelIP;
	/**
	 * ��д���˿�
	 */
	protected static JLabel labelPort;
	/**
	 * ��д��IP�˿ڵ�ַ
	 */
	protected static JTextField txtIPPort;
	/**
	 * RS-232
	 */
	protected static JPanel panel_newAddSerialBaud;
	/**
	 * ��������
	 */
	protected static JButton btnAddSerial;
	/**
	 * ���ں�
	 */
	protected static JLabel labelSerial;
	/**
	 * ������
	 */
	protected static JLabel labelBaud;
	/**
	 * ���ںŵ�ַ
	 */
	protected static JComboBox<String> cboSerial;
	/**
	 * �˿ں���ֵ
	 */
	protected static JComboBox<Integer> cboBaud;
	/**
	 * ��д��IP��ַ
	 */
	protected static IPTextField txtIP;
	/**
	 * Ƶ��CHN
	 */
	protected static JRadioButton rdoCHN;
	/**
	 * Ƶ���
	 */
	protected static JComboBox<Double> cboPortlow;
	/**
	 * Ƶ���
	 */
	protected static JComboBox<Double> cboPorthigh;
	/**
	 * ����ģʽѡ������1
	 */
	protected static JComboBox<String> cboRecieveAntennaType;

	/**
	 * <p>
	 * Title:construction
	 * </p>
	 * <p>
	 * Description:����
	 * </p>
	 */
	public RFIDdemo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Object[] options = { "Yes", "No" };
				JOptionPane pane2 = new JOptionPane(RFIDdemo.rs.getString("MainWindowFormClosing"),
						JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, options, options[1]);
				JDialog dialog = pane2.createDialog(RFIDdemo.rs.getString("ClosePrompt"));
				dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(RFIDdemo.class.getResource("/IOT.png")));
				dialog.setVisible(true);
				Object selectedValue = pane2.getValue();
				if (selectedValue == null || selectedValue == options[1]) {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // ����ǹؼ�
				} else if (selectedValue == options[0]) {
					setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
			}
		});
		init();
		mainPanel();
		general();
		deviceParametersSetup();
//		dataEntrySetup();
		commonality();
	}

//	/**  
//	  * <p>Title: dataEntrySetup</p>  
//	  * <p>Description: </p>    
//	  */  
//	private void dataEntrySetup() {
//
//	}

	/**
	 * <p>
	 * Title: main
	 * </p>
	 * <p>
	 * Description: ��������
	 * </p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RFIDdemo frame = new RFIDdemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * <p>
	 * Title: init
	 * </p>
	 * <p>
	 * Description:��ҳ��
	 * </p>
	 */
	private void init() {
		setTitle("��Դ����ƵRFIDϵͳ����");
		setFont(new Font("SimSun", Font.BOLD, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage(RFIDdemo.class.getResource("/IOT.png")));
		// window display style
		String manager = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
		try {
			UIManager.setLookAndFeel(manager);
		} catch (Exception e) {
			// e.printStackTrace();
			// Message.Show("Display window style exception",
			// "");
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	/**
	 * <p>
	 * Title: mainPanel
	 * </p>
	 * <p>
	 * Description:���������
	 * </p>
	 */
	private void mainPanel() {
		panel_main = new JPanel();
		contentPane.add(panel_main, BorderLayout.CENTER);
		panel_main.setLayout(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 10, 953, 590);
	}

	/**
	 * <p>
	 * Title: general
	 * </p>
	 * <p>
	 * Description: ͨ��ҳ��
	 * </p>
	 */
	private void general() {
		panel_general = new JPanel();
		panel_general.setOpaque(false);
		panel_general.setToolTipText("");
		tabbedPane.addTab(RFIDdemo.rs.getString("tabGeneral"), null, panel_general, null);
		panel_generalLeft = new JPanel();
		panel_generalLeft.setBounds(13, 0, 259, 552);
		panel_generalLeft.setOpaque(false);
		panel_generalRight = new JPanel();
		panel_generalRight.setBounds(290, 0, 658, 551);
		panel_generalRight.setOpaque(false);
		panel_readerData = new JPanel();
		panel_readerData.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_readerData.setBounds(0, 0, 658, 24);
		panel_operationData = new JPanel();
		panel_operationData.setBounds(12, 496, 630, 42);
		JPanel panel_tableDataShow = new JPanel();
		panel_tableDataShow.setBounds(0, 30, 658, 429);
		panel_tableDataShow.setLayout(new GridLayout(1, 0, 0, 0));
		sp_showTagInfo = new JScrollPane();

		panel_tableDataShow.add(sp_showTagInfo);
		String columnHeader[] = { RFIDdemo.rs.getString("strLvHeadNo"), "EPC", RFIDdemo.rs.getString("strLvHeadCount"),
				RFIDdemo.rs.getString("strLvHeadAntNo"), RFIDdemo.rs.getString("gopDevice") };
		// ���ģ�Ͷ���
		tableModel = new DefaultTableModel(null, columnHeader);
		tbl_showTagInfo = new JTable(tableModel);
		BasicTable.setTableStyle(tbl_showTagInfo);
		sp_showTagInfo.setViewportView(tbl_showTagInfo);
		panel_operationData.setLayout(new GridLayout(1, 6, 10, 0));

		// ����Ѱ��һ�ΰ�ť��Ϊ����Ӵ����¼�
		btnInventoryOnce = new JButton(RFIDdemo.rs.getString("btnInventoryOnce"));
		btnInventoryOnce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_operationData.add(btnInventoryOnce);

		// ������ʼ������ť��Ϊ����Ӵ����¼�
		btnStart = new JButton("\u6301\u7EED\u5BFB\u5361");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_operationData.add(btnStart);

		// ����ֹͣ��ť��Ϊ����Ӵ����¼�
		btnStop = new JButton(RFIDdemo.rs.getString("btnStop"));
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_operationData.add(btnStop);

		btnClearData = new JButton(RFIDdemo.rs.getString("btnClearData"));
		btnClearData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_operationData.add(btnClearData);

		panel_readerCount = new JPanel();
		panel_readerCount.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_readerCount.setBounds(68, 0, 236, 24);
		panel_readerCount.setLayout(new GridLayout(1, 2, 0, 0));
		labelNub = new JLabel(RFIDdemo.rs.getString("labelNub"));
		panel_readerCount.add(labelNub);
		labelNub.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTagCount = new JLabel("0");
		panel_readerCount.add(labelTagCount);
		labelTagCount.setForeground(Color.RED);
		labelTagCount.setFont(new Font("����", Font.PLAIN, 20));
		labelTagCount.setHorizontalAlignment(SwingConstants.CENTER);
		labelTagCount.setHorizontalTextPosition(SwingConstants.LEADING);
		panel_onlineDevice = new JPanel();
		panel_onlineDevice.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_onlineDevice.setBounds(0, 280, 259, 198);
		JPanel panel_connectAndDisconnect = new JPanel();
		panel_connectAndDisconnect.setBounds(8, 497, 233, 40);
		panel_connectAndDisconnect.setLayout(new GridLayout(1, 2, 20, 0));
		// ���Ӱ�Ť
		btnConnect = new JButton(RFIDdemo.rs.getString("btnConnect"));
		panel_connectAndDisconnect.add(btnConnect);
		btnDisconnect = new JButton(RFIDdemo.rs.getString("btnDisconnect"));

		panel_connectAndDisconnect.add(btnDisconnect);

		BasicTree.getDeviceIP(model, tree_onlineDevice, nodeTree, node_1);
		panel_general.setLayout(null);
		panel_general.add(panel_generalLeft);
		panel_generalLeft.setLayout(null);
		panel_generalLeft.add(panel_onlineDevice);
		panel_onlineDevice.setLayout(new GridLayout(0, 1, 0, 0));
		JScrollPane scrollPane_tree = new JScrollPane();
		panel_onlineDevice.add(scrollPane_tree);
		tree_onlineDevice = new JTree(model);
		scrollPane_tree.setViewportView(tree_onlineDevice);
		// ��ʾ�����豸
		tree_onlineDevice.setRootVisible(true);
		// ��ʾ������ͷ
		tree_onlineDevice.setShowsRootHandles(true);
		// ����Tree��ѡ��Ϊһ��ֻ��ѡ��һ���ڵ��ѡ��
		tree_onlineDevice.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		panel_generalLeft.add(panel_connectAndDisconnect);

		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 11, 259, 256);
		panel_generalLeft.add(tabbedPane_1);
		panel_newAddIPAdress = new JPanel();
		panel_newAddIPAdress.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane_1.addTab("IP", null, panel_newAddIPAdress, null);
		panel_newAddIPAdress.setLayout(null);

		cbotype_net = new JComboBox<String>();
		cbotype_net.setBounds(99, 112, 141, 30);
		panel_newAddIPAdress.add(cbotype_net);
		btnAddIP = new JButton(RFIDdemo.rs.getString("btnAddIP"));
		btnAddIP.setBounds(174, 169, 66, 31);
		btnAddIP.setOpaque(false);
		BasicParameter.comboboxType(cbotype_net);

		panel_newAddIPAdress.add(btnAddIP);

		labelIP = new JLabel("\u8BFB\u5199\u5668IP:");
		labelIP.setHorizontalAlignment(SwingConstants.CENTER);
		labelIP.setToolTipText("");
		labelIP.setBounds(7, 25, 102, 35);
		panel_newAddIPAdress.add(labelIP);

		labelPort = new JLabel("\u7AEF\u53E3\u53F7:");
		labelPort.setHorizontalAlignment(SwingConstants.CENTER);
		labelPort.setBounds(7, 69, 102, 35);
		panel_newAddIPAdress.add(labelPort);

		txtIPPort = new JTextField();
		txtIPPort.setText("4001");
		txtIPPort.setHorizontalAlignment(SwingConstants.CENTER);
		txtIPPort.setBounds(99, 69, 141, 30);
		panel_newAddIPAdress.add(txtIPPort);
		txtIPPort.setColumns(10);

		txtIP = new IPTextField();
		txtIP.setText("192.168.0.178");
		txtIP.setOpaque(false);
		txtIP.setBounds(99, 25, 141, 30);
		panel_newAddIPAdress.add(txtIP);

		btnRefresh = new JButton("\u5237\u65B0");
		btnRefresh.setOpaque(false);
		btnRefresh.setBounds(77, 169, 66, 31);
		panel_newAddIPAdress.add(btnRefresh);

		JLabel lbltype_net = new JLabel("��д������:");
		lbltype_net.setHorizontalAlignment(SwingConstants.CENTER);
		lbltype_net.setBounds(7, 110, 102, 35);
		panel_newAddIPAdress.add(lbltype_net);

		panel_newAddSerialBaud = new JPanel();
		panel_newAddSerialBaud.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane_1.addTab("RS-232", null, panel_newAddSerialBaud, null);

//		tabbedPane_1.addTab("RS-232", null, panel_newAddSerialBound, null);

		panel_newAddSerialBaud.setLayout(null);

		btnAddSerial = new JButton("\u65B0\u589E");
		btnAddSerial.setOpaque(false);
		btnAddSerial.setBounds(174, 169, 66, 31);
		panel_newAddSerialBaud.add(btnAddSerial);

		labelSerial = new JLabel("\u4E32\u53E3\u53F7:");
		labelSerial.setToolTipText("");
		labelSerial.setHorizontalAlignment(SwingConstants.CENTER);
		labelSerial.setBounds(7, 25, 102, 35);
		panel_newAddSerialBaud.add(labelSerial);

		labelBaud = new JLabel("\u6CE2\u7279\u7387:");
		labelBaud.setHorizontalAlignment(SwingConstants.CENTER);
		labelBaud.setBounds(7, 69, 102, 35);
		panel_newAddSerialBaud.add(labelBaud);

		cboSerial = new JComboBox<String>();
//		cboSerial.setColumns(10);
		cboSerial.setBounds(99, 25, 141, 30);
		BasicParameter.comboboxSerial(cboSerial);
		panel_newAddSerialBaud.add(cboSerial);

		cboBaud = new JComboBox<Integer>();
//		cboBaud.setColumns(10);
		cboBaud.setBounds(99, 69, 141, 30);
		BasicParameter.comboboxBaund(cboBaud);

		panel_newAddSerialBaud.add(cboBaud);

		btnRefresh_1 = new JButton("\u5237\u65B0");
		btnRefresh_1.setOpaque(false);
		btnRefresh_1.setBounds(77, 169, 66, 31);
		panel_newAddSerialBaud.add(btnRefresh_1);

		cbotype_com = new JComboBox<String>();
		cbotype_com.setBounds(99, 112, 141, 30);
		panel_newAddSerialBaud.add(cbotype_com);

		BasicParameter.comboboxType(cbotype_com);

		JLabel lbltype_com = new JLabel("\u8BFB\u5199\u5668Type:");
		lbltype_com.setHorizontalAlignment(SwingConstants.CENTER);
		lbltype_com.setBounds(7, 110, 102, 35);
		panel_newAddSerialBaud.add(lbltype_com);
		panel_general.add(panel_generalRight);
		panel_generalRight.setLayout(null);
		panel_generalRight.add(panel_readerData);
		panel_readerData.setLayout(null);
		panel_readerData.add(panel_readerCount);
		panel_readerTagCount = new JPanel();
		panel_readerTagCount.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_readerTagCount.setBounds(332, 0, 236, 24);
		panel_readerTagCount.setLayout(new GridLayout(1, 0, 0, 0));
		labelReadCount = new JLabel(RFIDdemo.rs.getString("labelReadCount"));
		panel_readerTagCount.add(labelReadCount);
		labelReadCount.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_readerData.add(panel_readerTagCount);
		labelCount = new JLabel("0");
		panel_readerTagCount.add(labelCount);
		labelCount.setForeground(Color.BLUE);
		labelCount.setFont(new Font("����", Font.PLAIN, 20));
		labelCount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_generalRight.add(panel_tableDataShow);
		panel_generalRight.add(panel_operationData);

		labelShowInfo = new Label("");
		labelShowInfo.setBounds(508, 467, 123, 23);
		panel_generalRight.add(labelShowInfo);

		BasicOperateOnclick.onclick();

	}

	/**
	 * <p>
	 * Title: commonality
	 * </p>
	 * <p>
	 * Description:�������湫������
	 * </p>
	 */
	private void commonality() {
		// TODO Auto-generated method stub
		panel_main.add(tabbedPane);
		tabbedPane.setSelectedIndex(0);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel_main,
				GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel_main, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE).addGap(0)));
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * ��������
	 */
	public void deviceParametersSetup() {
		panel_parametersSetup = new JPanel();
		tabbedPane.addTab(RFIDdemo.rs.getString("tabDeviceParams"), null, panel_parametersSetup, null);
		panel_parametersSetup.setLayout(null);
		panel_DeviceAntenna = new JPanel();
		panel_DeviceAntenna.setBounds(36, 13, 441, 371);
		panel_parametersSetup.add(panel_DeviceAntenna);
		panel_DeviceAntenna.setBorder(new TitledBorder(null, RFIDdemo.rs.getString("gopDeviceAntenna"),
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblDeviceAntennaWorkTime = new JLabel(RFIDdemo.rs.getString("lblDeviceAntennaWorkTime"));
		lblDeviceAntennaWorkTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeviceAntennaWorkTime.setBounds(98, 38, 97, 15);
		lblDeviceAntennaPower = new JLabel(RFIDdemo.rs.getString("lblDeviceAntennaPower"));
		lblDeviceAntennaPower.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeviceAntennaPower.setBounds(209, 38, 89, 15);
		panel_antennaParamsButton = new JPanel();
		panel_antennaParamsButton.setBounds(207, 316, 191, 30);
		panel_antennaParamsButton.setLayout(new GridLayout(1, 0, 30, 1));

		devicePortArea();

		btnDeviceAntennaRead = new JButton(RFIDdemo.rs.getString("btnDeviceAntennaRead"));
		panel_antennaParamsButton.add(btnDeviceAntennaRead);

		btnDeviceAntannaSet = new JButton(RFIDdemo.rs.getString("btnDeviceAntannaSet"));
		panel_antennaParamsButton.add(btnDeviceAntannaSet);
		panel_DeviceAntenna.setLayout(null);
		panel_DeviceAntenna.add(lblDeviceAntennaWorkTime);
		panel_DeviceAntenna.add(lblDeviceAntennaPower);
		panel_DeviceAntenna.add(panel_antennaParamsButton);

		chkDeviceAntenna1 = new JCheckBox(RFIDdemo.rs.getString("chkDeviceAntenna1"));
		chkDeviceAntenna1.setBounds(10, 67, 80, 27);
		panel_DeviceAntenna.add(chkDeviceAntenna1);
		chkDeviceAntenna1.setHorizontalAlignment(SwingConstants.CENTER);

		cboDeviceAntennaWorkTime1 = new JComboBox<Integer>();
		cboDeviceAntennaWorkTime1.setBounds(98, 64, 96, 27);
		panel_DeviceAntenna.add(cboDeviceAntennaWorkTime1);

		AntennaParameter.comboboxSecond(cboDeviceAntennaWorkTime1);

		cboDeviceAntennaPower1 = new JComboBox<Integer>();
		cboDeviceAntennaPower1.setBounds(209, 62, 96, 27);
		panel_DeviceAntenna.add(cboDeviceAntennaPower1);

		AntennaParameter.comboboxDbm(cboDeviceAntennaPower1);
		chkDeviceAntenna2 = new JCheckBox(RFIDdemo.rs.getString("chkDeviceAntenna2"));
		chkDeviceAntenna2.setBounds(10, 116, 80, 27);
		panel_DeviceAntenna.add(chkDeviceAntenna2);
		chkDeviceAntenna2.setHorizontalAlignment(SwingConstants.CENTER);

		cboDeviceAntennaWorkTime2 = new JComboBox<Integer>();
		cboDeviceAntennaWorkTime2.setBounds(98, 112, 96, 27);
		panel_DeviceAntenna.add(cboDeviceAntennaWorkTime2);
		AntennaParameter.comboboxSecond(cboDeviceAntennaWorkTime2);

		cboDeviceAntennaPower2 = new JComboBox<Integer>();
		cboDeviceAntennaPower2.setBounds(209, 111, 96, 27);
		panel_DeviceAntenna.add(cboDeviceAntennaPower2);
		AntennaParameter.comboboxDbm(cboDeviceAntennaPower2);
		chkDeviceAntenna3 = new JCheckBox(RFIDdemo.rs.getString("chkDeviceAntenna3"));
		chkDeviceAntenna3.setBounds(10, 169, 80, 27);
		panel_DeviceAntenna.add(chkDeviceAntenna3);
		chkDeviceAntenna3.setHorizontalAlignment(SwingConstants.CENTER);

		cboDeviceAntennaWorkTime3 = new JComboBox<Integer>();
		cboDeviceAntennaWorkTime3.setBounds(98, 165, 96, 27);
		panel_DeviceAntenna.add(cboDeviceAntennaWorkTime3);
		AntennaParameter.comboboxSecond(cboDeviceAntennaWorkTime3);

		cboDeviceAntennaPower3 = new JComboBox<Integer>();
		cboDeviceAntennaPower3.setBounds(209, 163, 96, 27);
		panel_DeviceAntenna.add(cboDeviceAntennaPower3);
		AntennaParameter.comboboxDbm(cboDeviceAntennaPower3);

		chkDeviceAntenna4 = new JCheckBox(RFIDdemo.rs.getString("chkDeviceAntenna4"));
		chkDeviceAntenna4.setBounds(10, 212, 80, 27);
		panel_DeviceAntenna.add(chkDeviceAntenna4);
		chkDeviceAntenna4.setHorizontalAlignment(SwingConstants.CENTER);
		cboDeviceAntennaWorkTime4 = new JComboBox<Integer>();
		cboDeviceAntennaWorkTime4.setBounds(98, 209, 96, 27);
		panel_DeviceAntenna.add(cboDeviceAntennaWorkTime4);
		AntennaParameter.comboboxSecond(cboDeviceAntennaWorkTime4);
		cboDeviceAntennaPower4 = new JComboBox<Integer>();
		cboDeviceAntennaPower4.setBounds(209, 207, 96, 27);
		panel_DeviceAntenna.add(cboDeviceAntennaPower4);
		AntennaParameter.comboboxDbm(cboDeviceAntennaPower4);

		cboDeviceAntennaWorkTime5 = new JComboBox<Integer>();
		cboDeviceAntennaWorkTime5.setBounds(98, 254, 96, 27);
		panel_DeviceAntenna.add(cboDeviceAntennaWorkTime5);
		AntennaParameter.comboboxSecond(cboDeviceAntennaWorkTime5);

		cboDeviceAntennaPower5 = new JComboBox<Integer>();
		cboDeviceAntennaPower5.setBounds(209, 253, 96, 27);
		panel_DeviceAntenna.add(cboDeviceAntennaPower5);
		AntennaParameter.comboboxDbm(cboDeviceAntennaPower5);

		chkDeviceAntenn5 = new JCheckBox("\u5929\u7EBF5");
		chkDeviceAntenn5.setHorizontalAlignment(SwingConstants.CENTER);
		chkDeviceAntenn5.setBounds(10, 259, 80, 27);
		panel_DeviceAntenna.add(chkDeviceAntenn5);

		lblDeviceAntennaLaunch = new JLabel("\u53D1\u5C04");
		lblDeviceAntennaLaunch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeviceAntennaLaunch.setBounds(14, 40, 70, 15);
		panel_DeviceAntenna.add(lblDeviceAntennaLaunch);

		cboRecieveAntennaType = new JComboBox<String>();
		cboRecieveAntennaType.setForeground(new Color(0, 0, 0));
		cboRecieveAntennaType.setBounds(312, 30, 115, 30);
		panel_DeviceAntenna.add(cboRecieveAntennaType);
		AntennaParameter.comboboxRecieve(cboRecieveAntennaType);

		rdoRecieveAntenna1 = new JRadioButton("");
		rdoRecieveAntenna1.setBounds(350, 67, 66, 23);
		panel_DeviceAntenna.add(rdoRecieveAntenna1);

		rdoRecieveAntenna2 = new JRadioButton("");
		rdoRecieveAntenna2.setBounds(350, 116, 66, 23);
		panel_DeviceAntenna.add(rdoRecieveAntenna2);

		rdoRecieveAntenna3 = new JRadioButton("");
		rdoRecieveAntenna3.setBounds(350, 169, 66, 23);
		panel_DeviceAntenna.add(rdoRecieveAntenna3);

		rdoRecieveAntenna4 = new JRadioButton("");
		rdoRecieveAntenna4.setBounds(350, 212, 66, 23);
		panel_DeviceAntenna.add(rdoRecieveAntenna4);

		ButtonGroup bgAntennaSet = new ButtonGroup();
		bgAntennaSet.add(rdoRecieveAntenna1);
		bgAntennaSet.add(rdoRecieveAntenna2);
		bgAntennaSet.add(rdoRecieveAntenna3);
		bgAntennaSet.add(rdoRecieveAntenna4);

		panel_DataEntry = new JPanel();
		panel_DataEntry.setBounds(503, 13, 360, 371);
		panel_parametersSetup.add(panel_DataEntry);
		panel_DataEntry.setBorder(new TitledBorder(null, RFIDdemo.rs.getString("strDataOnCloud"), TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_DataEntry.setLayout(null);
		lblType = new JLabel("\u5BF9\u8C61\u5C5E\u6027:");
		lblType.setBounds(40, 46, 102, 30);
		panel_DataEntry.add(lblType);
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterial = new JLabel("\u5BF9\u8C61\u6750\u8D28:");
		lblMaterial.setBounds(40, 96, 102, 30);
		panel_DataEntry.add(lblMaterial);
		lblMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblLength = new JLabel("\u5BF9\u8C61\u957F\u5EA6:");
		lblLength.setBounds(40, 145, 102, 30);
		panel_DataEntry.add(lblLength);
		lblLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblWidth = new JLabel("\u5BF9\u8C61\u5BBD\u5EA6:");
		lblWidth.setBounds(40, 196, 102, 30);
		panel_DataEntry.add(lblWidth);
		lblWidth.setHorizontalAlignment(SwingConstants.CENTER);
		lblHight = new JLabel("\u5BF9\u8C61\u9AD8\u5EA6:");
		lblHight.setBounds(40, 248, 102, 30);
		panel_DataEntry.add(lblHight);
		lblHight.setHorizontalAlignment(SwingConstants.CENTER);

		txtType = new JTextField();
		txtType.setHorizontalAlignment(SwingConstants.CENTER);
		txtType.setColumns(10);
		txtType.setBounds(191, 46, 123, 30);
		panel_DataEntry.add(txtType);
		txtMaterial = new JTextField();
		txtMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaterial.setBounds(191, 96, 123, 30);
		panel_DataEntry.add(txtMaterial);
		txtMaterial.setColumns(10);
		txtLength = new JTextField();
		txtLength.setHorizontalAlignment(SwingConstants.CENTER);
		txtLength.setBounds(191, 145, 123, 30);
		panel_DataEntry.add(txtLength);
		txtLength.setColumns(10);
		txtWidth = new JTextField();
		txtWidth.setHorizontalAlignment(SwingConstants.CENTER);
		txtWidth.setBounds(191, 196, 123, 30);
		panel_DataEntry.add(txtWidth);
		txtWidth.setColumns(10);
		txtHight = new JTextField();
		txtHight.setHorizontalAlignment(SwingConstants.CENTER);
		txtHight.setBounds(191, 248, 123, 30);
		panel_DataEntry.add(txtHight);
		txtHight.setColumns(10);
		panel_networkParamButton = new JPanel();
		panel_networkParamButton.setBounds(64, 311, 250, 35);
		panel_DataEntry.add(panel_networkParamButton);

		panel_networkParamButton.setLayout(new GridLayout(0, 2, 10, 0));
		btnDataRead = new JButton("\u6570\u636E\u8BFB\u53D6");
		panel_networkParamButton.add(btnDataRead);
		btnDataSetting = new JButton("\u6570\u636E\u5F55\u5165");

		panel_networkParamButton.add(btnDataSetting);

		btnSave = new JButton("\u4FDD\u5B58\u8BBE\u7F6E");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBounds(757, 431, 108, 30);
		panel_parametersSetup.add(btnSave);

		btnRead = new JButton("\u8BFB\u53D6\u8BBE\u7F6E");
		btnRead.setBounds(757, 500, 108, 30);
		panel_parametersSetup.add(btnRead);
		labelShowInfo = new Label("");
		labelShowInfo.setForeground(new Color(0, 0, 0));
		labelShowInfo.setBounds(357, 390, 211, 23);
		panel_parametersSetup.add(labelShowInfo);

		DeviceParamsOnclick.onclick();
	}

	/**
	 * Ѱ������
	 */
	public void devicePortArea() {
		panel_PortSetting = new JPanel();
		panel_PortSetting.setBounds(36, 412, 657, 122);
		panel_PortSetting.setBorder(new TitledBorder(null, RFIDdemo.rs.getString("gopDeviceSearch"),
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		rdoETSI = new JRadioButton(RFIDdemo.rs.getString("rdoETSI"));
		rdoETSI.setBounds(82, 44, 66, 23);

		panel_PortSetting.setLayout(null);
		rdoFCC = new JRadioButton(RFIDdemo.rs.getString("rdoFCC"));
		ButtonGroup bgDeviceSet = new ButtonGroup();
		bgDeviceSet.add(rdoETSI);
		bgDeviceSet.add(rdoFCC);

		rdoFCC.setBounds(10, 44, 66, 23);
		panel_parametersSetup.add(panel_PortSetting);
		panel_PortSetting.add(rdoFCC);
		panel_PortSetting.add(rdoETSI);

		rdoCHN = new JRadioButton("CHN");
		rdoCHN.setBounds(154, 44, 66, 23);
		bgDeviceSet.add(rdoCHN);
		panel_PortSetting.add(rdoCHN);
		lblMHZ = new JLabel("MHz\u2014");
		lblMHZ.setBounds(417, 40, 66, 30);
		panel_PortSetting.add(lblMHZ);
		lblMHZ.setHorizontalAlignment(SwingConstants.CENTER);
		lblMHZ.setOpaque(true);
		lblPortIncluding = new JLabel("\u9891\u8C31\u8303\u56F4");
		lblPortIncluding.setBounds(209, 40, 108, 30);
		panel_PortSetting.add(lblPortIncluding);
		lblPortIncluding.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortIncluding.setOpaque(true);
		lblMHZ_2 = new JLabel("MHz");
		lblMHZ_2.setBounds(591, 40, 66, 30);
		panel_PortSetting.add(lblMHZ_2);
		lblMHZ_2.setHorizontalAlignment(SwingConstants.CENTER);
		btnPortSet = new JButton(RFIDdemo.rs.getString("btnPortSet"));
		btnPortSet.setBounds(494, 83, 108, 30);
		panel_PortSetting.add(btnPortSet);
		btnPortRead = new JButton(RFIDdemo.rs.getString("btnPortRead"));
		btnPortRead.setBounds(317, 83, 108, 30);
		panel_PortSetting.add(btnPortRead);

		cboPortlow = new JComboBox<Double>();
//		cboPortlow.setColumns(10);
		cboPortlow.setBounds(317, 40, 100, 30);
		panel_PortSetting.add(cboPortlow);

		cboPorthigh = new JComboBox<Double>();
//		cboPorthigh.setColumns(10);
		cboPorthigh.setBounds(494, 40, 100, 30);
		panel_PortSetting.add(cboPorthigh);
	}
}
