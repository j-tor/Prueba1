/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1q4;

/**
 *
 * @author aleja
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockBusterApp {
    private BlockBuster blockBuster = new BlockBuster();
    private JTextField codigoField, nombreField, tipoItemField, diasField;
    private JTextArea outputArea;

    public BlockBusterApp() {
        JFrame frame = new JFrame("BlockBuster App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Código:"));
        codigoField = new JTextField(10);
        inputPanel.add(codigoField);
        inputPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField(10);
        inputPanel.add(nombreField);
        inputPanel.add(new JLabel("Tipo (MOVIE/GAME):"));
        tipoItemField = new JTextField(10);
        inputPanel.add(tipoItemField);
        inputPanel.add(new JLabel("Días de renta:"));
        diasField = new JTextField(10);
        inputPanel.add(diasField);
        frame.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        JButton buscarButton = new JButton("Buscar Item");
        JButton agregarButton = new JButton("Agregar Item");
        JButton rentarButton = new JButton("Rentar Item");
        JButton auditarButton = new JButton("Auditar Estados");

        buttonPanel.add(buscarButton);
        buttonPanel.add(agregarButton);
        buttonPanel.add(rentarButton);
        buttonPanel.add(auditarButton);
        frame.add(buttonPanel, BorderLayout.CENTER);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(codigoField.getText());
                String tipo = tipoItemField.getText();
                BlockBusterItem item = blockBuster.buscarItem(codigo, tipo);
                if (item != null) {
                    outputArea.setText(item.toString());
                } else {
                    outputArea.setText("Item No Existe");
                }
            }
        });

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(codigoField.getText());
                String nombre = nombreField.getText();
                String tipoItem = tipoItemField.getText();
                blockBuster.agregarItem(codigo, nombre, tipoItem);
                outputArea.setText("Ítem agregado con éxito.");
            }
        });

        rentarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(codigoField.getText());
                String tipoItem = tipoItemField.getText();
                int dias = Integer.parseInt(diasField.getText());
                BlockBusterItem item = blockBuster.buscarItem(codigo, tipoItem);
                if (item != null) {
                    outputArea.setText("Información del ítem:\n" + item.toString());
                    double monto = item.pagoRenta(dias);
                    outputArea.append("\nMonto a pagar: " + monto);
                } else {
                    outputArea.setText("Item No Existe");
                }
            }
        });

        auditarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blockBuster.auditarMovieEstados();
                outputArea.setText("Estados de películas auditados.");
            }
        });

        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BlockBusterApp();
            }
        });
    }
}
