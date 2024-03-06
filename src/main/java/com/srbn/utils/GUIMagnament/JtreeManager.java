/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.srbn.utils.GUIMagnament;

import com.opencsv.exceptions.CsvValidationException;
import com.srbn.utils.CSVmagnament.CSVManager;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author ADMIN
 */
public class JtreeManager {

    public DefaultMutableTreeNode createFileTree(File root) {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(root.getName());
        traverseAndAddNodes(root, rootNode);
        return rootNode;
    }

    private void traverseAndAddNodes(File folder, DefaultMutableTreeNode parentNode) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(file.getName());
                parentNode.add(node);

                if (file.isDirectory()) {
                    traverseAndAddNodes(file, node);
                }
            }
        }
    }

    public void addSelectionNodes(JTree tree, JTextArea textArea, String mainPath) {

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (selectedNode != null && selectedNode.isLeaf()) {
                    String filePath = mainPath+ getFilePath(selectedNode);
                    if (filePath.endsWith(".csv")) {
                        try {
                            String csvContent = CSVManager.readCSVFile(filePath);
                            textArea.setText(csvContent);
                        } catch (IOException exception) {
                            System.out.println(filePath);

                            textArea.setText("Error reading CSV file: " + exception.getMessage());
                        } catch (CsvValidationException ex) {
                            textArea.setText("Error vlidation CSV file: " + ex.getMessage());
                        }
                    }
                }
            }
        });

    }

    private static String getFilePath(DefaultMutableTreeNode node) {
        StringBuilder path = new StringBuilder();

        while (node != null) {
            Object userObject = node.getUserObject();
            if (userObject instanceof String) {
                path.insert(0, File.separator + userObject);
            }
            if (node != null && node.isLeaf()) {
                break;
            }
            node = (DefaultMutableTreeNode) node.getParent();

        }
        return path.toString();
    }


}
