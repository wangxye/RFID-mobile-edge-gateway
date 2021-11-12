package com.rfid.main.deviceParams;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.main.test.RFIDdemo;

public class DeviceParamsOnclick extends RFIDdemo {
	private static final long serialVersionUID = 1L;

	public static void onclick() {
		btnDeviceAntannaSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeviceParams.setAntParam();
			}
		});
		btnDeviceAntennaRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeviceParams.readAntParam();
			}
		});
		/**
		 * 
		 * 
		 * btnDefaultParams.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { DeviceParams.defaultSetup(); } });
		 * btnSetParams.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { DeviceParams.setParameter(); } });
		 */
		btnDataRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeviceParams.readData();
			}
		});

		btnDataSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeviceParams.setData();
			}
		});

		btnPortRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeviceParams.readPort();
			}
		});

		btnPortSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeviceParams.setPort();
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeviceParams.save();
			}
		});

		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeviceParams.read();
			}
		});

		rdoETSI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AntennaParameter.comboboxPort(cboPortlow, cboPorthigh, 865, 868);
			}

		});

		rdoFCC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AntennaParameter.comboboxPort(cboPortlow, cboPorthigh, 902, 928);
			}

		});

		rdoCHN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AntennaParameter.comboboxPort(cboPortlow, cboPorthigh, 920, 925);
			}

		});

		cboRecieveAntennaType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cboRecieveAntennaType.getSelectedIndex() == 1) {
					rdoRecieveAntenna1.setEnabled(false);
					rdoRecieveAntenna2.setEnabled(false);
					rdoRecieveAntenna3.setEnabled(false);
					rdoRecieveAntenna4.setEnabled(false);

				} else {
					rdoRecieveAntenna1.setEnabled(true);
					rdoRecieveAntenna2.setEnabled(true);
					rdoRecieveAntenna3.setEnabled(true);
					rdoRecieveAntenna4.setEnabled(true);
				}
			}
		});
	}

}
