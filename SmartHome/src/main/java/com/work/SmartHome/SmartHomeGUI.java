package com.work.SmartHome;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SmartHomeGUI extends JFrame {
    private final SmartHomeManager manager;
    private final DefaultTableModel tableModel;

    public SmartHomeGUI() {
        manager = new SmartHomeManager(); // Load hardcoded devices

        setTitle("🏠 Smart Home Control Panel");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"ID", "Type", "Name", "Status"}, 0);
        JTable table = new JTable(tableModel);
        refreshTable();

        JButton onButton = new JButton("Turn ON");
        JButton offButton = new JButton("Turn OFF");
        JButton refreshButton = new JButton("Refresh");

        onButton.addActionListener(e -> controlDevice(table, true));
        offButton.addActionListener(e -> controlDevice(table, false));
        refreshButton.addActionListener(e -> refreshTable());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(onButton);
        buttonPanel.add(offButton);
        buttonPanel.add(refreshButton);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Device d : manager.getDevices()) {
            tableModel.addRow(new Object[]{d.getId(), d.getType(), d.getName(), d.getStatus()});
        }
    }

    private void controlDevice(JTable table, boolean turnOn) {
        int row = table.getSelectedRow();
        if (row == -1) { JOptionPane.showMessageDialog(this, "Select a device first!"); return; }
        int id = (int) table.getValueAt(row, 0);
        manager.controlDevice(id, turnOn);
        refreshTable();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SmartHomeGUI().setVisible(true));
    }
}
