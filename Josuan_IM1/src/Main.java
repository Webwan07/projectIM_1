import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.HashMap;
import java.util.Set;

public class Main extends javax.swing.JFrame {
    private Connection connection;
    private PreparedStatement prepare;
    private Statement statement;
    private final String tableName = "im1";
    private final String[] columns = {"id", "FirstName", "LastName", "Department", "Program"};
    private final String url = "jdbc:mysql://localhost:3306/mydatabase?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private int clickCount = 0;
   
    private final String[] departmentList = {"CCS", "COC"};
    private final String[] programList = {"BSIT", "BSCS", "BSA", "BSBA"};
    private final String[][] programLists = {{"BSIT","BSCS"},{"BSA","BSBA"}};
    
    public Main() {
        initComponents();
        setTitle("Josuan's CRUD");

        Image icon = new ImageIcon(this.getClass().getResource("server.png")).getImage();
        this.setIconImage(icon);
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url,"root","");
            this.statement = connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        infoTxt.setText("");
        mainTable.setModel(table()); 
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        crudTxt = new javax.swing.JLabel();
        infoTxt = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        lnameTxt = new javax.swing.JLabel();
        getFname = new javax.swing.JTextField();
        getLname = new javax.swing.JTextField();
        fnameTxt = new javax.swing.JLabel();
        departmentTxt = new javax.swing.JLabel();
        programTxt = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        getDepartment = new javax.swing.JComboBox<>();
        getProgram = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        titlePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crudTxt.setFont(new java.awt.Font("Segoe UI", 1, 56)); // NOI18N
        crudTxt.setForeground(new java.awt.Color(255, 255, 255));
        crudTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        crudTxt.setText("CRUD");
        crudTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crudTxtMouseClicked(evt);
            }
        });
        titlePanel.add(crudTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        infoTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoTxt.setText("Info");
        titlePanel.add(infoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, 417, 30));

        bodyPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bodyPanelMouseClicked(evt);
            }
        });

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "Department", "Program"
            }
        ));
        mainTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mainTable);

        lnameTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lnameTxt.setForeground(new java.awt.Color(255, 255, 255));
        lnameTxt.setText("Last name:");

        getFname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        getLname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        fnameTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fnameTxt.setForeground(new java.awt.Color(255, 255, 255));
        fnameTxt.setText("First name:");

        departmentTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        departmentTxt.setForeground(new java.awt.Color(255, 255, 255));
        departmentTxt.setText("Department:");

        programTxt.setBackground(new java.awt.Color(255, 255, 255));
        programTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        programTxt.setForeground(new java.awt.Color(255, 255, 255));
        programTxt.setText("Program:");

        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        getDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(departmentList));
        getDepartment.setPreferredSize(new java.awt.Dimension(64, 26));
        getDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getDepartmentMouseClicked(evt);
            }
        });

        getProgram.setModel(new javax.swing.DefaultComboBoxModel<>(programList));
        getProgram.setPreferredSize(new java.awt.Dimension(64, 26));
        getProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getProgramActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(fnameTxt)
                        .addGap(18, 18, 18)
                        .addComponent(getFname, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lnameTxt)
                            .addComponent(departmentTxt))
                        .addGap(18, 18, 18)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getLname, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(getDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addComponent(addBtn)
                                .addGap(61, 61, 61)
                                .addComponent(updateBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteBtn))
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addComponent(programTxt)
                                .addGap(18, 18, 18)
                                .addComponent(getProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(getFname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fnameTxt))
                                .addGap(18, 18, 18)
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(getLname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lnameTxt))
                                .addGap(18, 18, 18)
                                .addComponent(getDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(departmentTxt))
                        .addGap(18, 18, 18)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(getProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(programTxt))
                        .addGap(36, 36, 36)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int getIDFunc(){
        int row = mainTable.getSelectedRow();
        Object value = mainTable.getValueAt(row, 0);
            
        return Integer.parseInt(value.toString());
    }
    
    private void infoText(String text, Color col){
        infoTxt.setText(text);
        infoTxt.setForeground(col);
    }
    
    private void clearAllFields(){
        getFname.setText("");
        getLname.setText("");      
    }
    
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int rowIndex = mainTable.getSelectedRow();
        int getColumn = mainTable.getSelectedColumn();
        mainTable.editCellAt(rowIndex, getColumn);
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();

        int editedRow = mainTable.getEditingRow();
        int editedColumn = mainTable.getEditingColumn();

        if (editedRow != -1 && editedColumn != -1) {
            TableCellEditor editor = mainTable.getCellEditor(editedRow, editedColumn);

            if (editor != null) {
                editor.stopCellEditing();
            }

            Object editedValue = model.getValueAt(editedRow, editedColumn);
            
            updateData(editedColumn, editedValue.toString(), getIDFunc());

            switch (editedColumn) {
                case 1:
                    infoText("First name changed successfully", Color.white);
                    break;
                case 2:
                    infoText("Last name changed successfully", Color.white);
                    break;
                case 3:
                    infoText("Department changed successfully", Color.white);
                    break;
                case 4:
                    infoText("Program changed successfully", Color.white);
                    break;
                default:
                    break;
            }
        } else {
            infoText("No cell is being edited.", Color.white);
        }

        clearAllFields();
        mainTable.setModel(table());
        clickCount = 0;
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String query = "INSERT INTO "+tableName+" ("+columns[1]+","+columns[2]+","+columns[3]+","+columns[4]+") VALUES (?,?,?,?)";

        String getfname = getFname.getText();
        String getlname = getLname.getText();
        String getdepartment = (String) getDepartment.getSelectedItem();
        String getprogram = (String) getProgram.getSelectedItem();
        
        if(!getfname.trim().isEmpty() && !getlname.trim().isEmpty()){
            try{
                prepare = connection.prepareStatement(query);
                prepare.setString(1, getfname);
                prepare.setString(2, getlname);
                prepare.setString(3, getdepartment);
                prepare.setString(4, getprogram);

                prepare.executeUpdate();      

                infoText("Successfully added new student.", Color.white);
                clearAllFields();
                prepare.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            infoText("Can't add student, Fill all fields",Color.white);
        }
        clickCount = 0;
        mainTable.setModel(table());
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        try{
            int getId = getIDFunc();

            deleteData(getId);
            infoText("Student ID: "+getId+" Deleted.", Color.white);
        }catch(ArrayIndexOutOfBoundsException e){
            
        }finally{
            clickCount = 0;
            mainTable.setModel(table());
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void mainTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTableMouseClicked
        mainTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JComboBox(departmentList)));
        mainTable.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JComboBox(programList)));
            
        getFname.setText(mainTable.getValueAt(mainTable.getSelectedRow(), 1).toString());
        getLname.setText(mainTable.getValueAt(mainTable.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_mainTableMouseClicked
    
    private void crudTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crudTxtMouseClicked
        clickCount++;
        
        if(clickCount == 5){
            truncateTable();
            mainTable.setModel(table());
            clearAllFields();
            infoTxt.setText("");
        }
    }//GEN-LAST:event_crudTxtMouseClicked

    private void bodyPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bodyPanelMouseClicked
      
    }//GEN-LAST:event_bodyPanelMouseClicked

    private void getDepartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getDepartmentMouseClicked

    }//GEN-LAST:event_getDepartmentMouseClicked

    private void getProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getProgramActionPerformed

    }//GEN-LAST:event_getProgramActionPerformed
    
    private DefaultTableModel table(){
        String query = "SELECT * FROM "+tableName;
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "First Name", "Last Name", "Department", "Program"});

        try{
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                int id = result.getInt(columns[0]);
                String firstname = result.getString(columns[1]);
                String lastname = result.getString(columns[2]);
                String department = result.getString(columns[3]);
                String program = result.getString(columns[4]);

                model.addRow(new Object[]{id,firstname,lastname,department,program});
            }

            result.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return model;
    }
    
    private void truncateTable(){
        String query = "TRUNCATE TABLE "+tableName;
        try{
            statement = connection.createStatement();
            statement.executeUpdate(query);
           
        }catch(Exception e){
            
        }
    }

    private void updateData(int idx, String val, int id){
        String query = "UPDATE "+tableName+" SET "+columns[idx]+" = ? WHERE "+columns[0]+" = ?";
        
        try{
            prepare = connection.prepareStatement(query);
            prepare.setString(1, val);
            prepare.setInt(2, id);
            
            prepare.executeUpdate();
            
            prepare.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void deleteData(int id){
        String query = "DELETE FROM "+tableName+" WHERE "+columns[0]+" = ?";
        try{
            prepare = connection.prepareStatement(query);
            prepare.setInt(1, id);
            
            prepare.executeUpdate();
            
            prepare.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    public static void main(String args[]) {
        FlatDarkLaf.setup();
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel crudTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel departmentTxt;
    private javax.swing.JLabel fnameTxt;
    private javax.swing.JComboBox<String> getDepartment;
    private javax.swing.JTextField getFname;
    private javax.swing.JTextField getLname;
    private javax.swing.JComboBox<String> getProgram;
    private javax.swing.JLabel infoTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lnameTxt;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable mainTable;
    private javax.swing.JLabel programTxt;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
   //#F1EFEF #CCC8AA #7D7C7C #191717
}