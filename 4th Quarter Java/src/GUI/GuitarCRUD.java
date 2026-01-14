package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GuitarCRUD extends JFrame {

    private JTextField txtModel, txtPrice;
    private JComboBox<String> cmbBrand;
    private JTable table;
    private DefaultTableModel model;

    public GuitarCRUD() {
        setTitle("Guitar Center");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ===== FORM PANEL =====
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        formPanel.add(new JLabel("Brand:"));

        cmbBrand = new JComboBox<>(new String[]{
                Guitarbrands.FENDER,
                Guitarbrands.GIBSON,
                Guitarbrands.IBANEZ
        });
        formPanel.add(cmbBrand);

        formPanel.add(new JLabel("Model:"));
        txtModel = new JTextField();
        formPanel.add(txtModel);

        formPanel.add(new JLabel("Price:"));
        txtPrice = new JTextField();
        formPanel.add(txtPrice);

        // ===== BUTTON PANEL =====
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        // ===== TABLE =====
        model = new DefaultTableModel(new String[]{"ID", "Brand", "Model", "Price"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // ===== MAIN LAYOUT =====
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // ===== ACTIONS =====
        btnAdd.addActionListener(e -> addGuitar());
        btnUpdate.addActionListener(e -> updateGuitar());
        btnDelete.addActionListener(e -> deleteGuitar());
        table.getSelectionModel().addListSelectionListener(e -> loadSelectedRow());
    }

    private void addGuitar() {
        String brand = cmbBrand.getSelectedItem().toString();
        String modelName = txtModel.getText().trim();
        double price;

        if (modelName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Model cannot be empty.");
            return;
        }

        try {
            price = Double.parseDouble(txtPrice.getText().trim().replace(",", ""));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price.");
            return;
        }

        Guitar guitar = Guitarbrands.createGuitar(brand, modelName, price);
        GuitarDataBase.addGuitar(guitar);
        refreshTable();
        clearFields();
    }

    private void updateGuitar() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row to update.");
            return;
        }

        Guitar guitar = GuitarDataBase.getAllGuitars().get(row);

        try {
            guitar.setBrand(cmbBrand.getSelectedItem().toString());
            guitar.setModel(txtModel.getText().trim());
            guitar.setPrice(Double.parseDouble(txtPrice.getText().trim().replace(",", "")));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price.");
            return;
        }

        refreshTable();
        clearFields();
    }

    private void deleteGuitar() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row to delete.");
            return;
        }

        GuitarDataBase.deleteGuitar(row);
        refreshTable();
        clearFields();
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (Guitar g : GuitarDataBase.getAllGuitars()) {
            model.addRow(new Object[]{
                    g.getId(),
                    g.getBrand(),
                    g.getModel(),
                    "$" + g.getPrice()
            });
        }
    }

    private void loadSelectedRow() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            txtModel.setText(model.getValueAt(row, 2).toString());
            txtPrice.setText(model.getValueAt(row, 3).toString().replace("$", ""));
            cmbBrand.setSelectedItem(model.getValueAt(row, 1).toString());
        }
    }

    private void clearFields() {
        txtModel.setText("");
        txtPrice.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuitarCRUD().setVisible(true));
    }
}