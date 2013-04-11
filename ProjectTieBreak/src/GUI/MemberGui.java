package GUI;

import java.util.List;
import javax.swing.DefaultListModel;

public class MemberGui extends javax.swing.JFrame
{
    private DefaultListModel model = new DefaultListModel(); 
    private int switchLimitation = Integer.MAX_VALUE;
    private int switchType = 0;
    
    /**
     * Initializes the main member GUI.
     */
    public MemberGui()
    {
        initComponents();
        lstResults.setModel(model);
    }
    
    public static void main(String[] args) 
    {
        new MemberGui().setVisible(true);
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        txtBoxQuery = new javax.swing.JTextField();
        lblQuery = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        pnlResultsAndDetails = new javax.swing.JPanel();
        scrPnlResults = new javax.swing.JScrollPane();
        lstResults = new javax.swing.JList();
        scrPnlDetails = new javax.swing.JScrollPane();
        lstDetails = new javax.swing.JList();
        btnNew = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblCount = new javax.swing.JLabel();
        pnlSearch = new javax.swing.JPanel();
        lblSearchFor = new javax.swing.JLabel();
        cmbBoxSearchFor = new javax.swing.JComboBox();
        pnlLimit = new javax.swing.JPanel();
        lblLimit = new javax.swing.JLabel();
        cmbBoxLimit = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblQuery.setText("Query");

        btnSearch.setText("Search");
        btnSearch.setActionCommand("");
        btnSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSearchActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnClearActionPerformed(evt);
            }
        });

        pnlResultsAndDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Results and Details"));
        pnlResultsAndDetails.setName("test"); // NOI18N

        scrPnlResults.setViewportView(lstResults);

        scrPnlDetails.setViewportView(lstDetails);

        btnNew.setText("New...");
        btnNew.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnNewActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCloseActionPerformed(evt);
            }
        });

        lblCount.setText("Count: ");

        javax.swing.GroupLayout pnlResultsAndDetailsLayout = new javax.swing.GroupLayout(pnlResultsAndDetails);
        pnlResultsAndDetails.setLayout(pnlResultsAndDetailsLayout);
        pnlResultsAndDetailsLayout.setHorizontalGroup(
            pnlResultsAndDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultsAndDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultsAndDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResultsAndDetailsLayout.createSequentialGroup()
                        .addGroup(pnlResultsAndDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlResultsAndDetailsLayout.createSequentialGroup()
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemove))
                            .addComponent(scrPnlResults, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlResultsAndDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlResultsAndDetailsLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose))
                            .addComponent(scrPnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(pnlResultsAndDetailsLayout.createSequentialGroup()
                        .addComponent(lblCount)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlResultsAndDetailsLayout.setVerticalGroup(
            pnlResultsAndDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultsAndDetailsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlResultsAndDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrPnlDetails)
                    .addComponent(scrPnlResults, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResultsAndDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnRemove)
                    .addComponent(btnClose))
                .addContainerGap())
        );

        pnlSearch.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Options"));
        pnlSearch.setPreferredSize(new java.awt.Dimension(226, 158));

        lblSearchFor.setText("Search for...");

        cmbBoxSearchFor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CPR-Number", "Name" }));
        cmbBoxSearchFor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbBoxSearchForActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addComponent(lblSearchFor)
                        .addGap(0, 106, Short.MAX_VALUE))
                    .addComponent(cmbBoxSearchFor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addComponent(lblSearchFor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBoxSearchFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlLimit.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Limit"));
        pnlLimit.setAutoscrolls(true);

        lblLimit.setText("Limit to...");

        cmbBoxLimit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "10", "20", "50", "100" }));
        cmbBoxLimit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbBoxLimitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLimitLayout = new javax.swing.GroupLayout(pnlLimit);
        pnlLimit.setLayout(pnlLimitLayout);
        pnlLimitLayout.setHorizontalGroup(
            pnlLimitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLimitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLimitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbBoxLimit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlLimitLayout.createSequentialGroup()
                        .addComponent(lblLimit)
                        .addGap(0, 115, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlLimitLayout.setVerticalGroup(
            pnlLimitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLimitLayout.createSequentialGroup()
                .addComponent(lblLimit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBoxLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(236, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlResultsAndDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQuery)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBoxQuery)
                                .addGap(12, 12, 12)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClear))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pnlLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBoxQuery)
                        .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblQuery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlLimit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(pnlResultsAndDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlResultsAndDetails.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
 
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

    }//GEN-LAST:event_btnClearActionPerformed

    private void cmbBoxSearchForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxSearchForActionPerformed

    }//GEN-LAST:event_cmbBoxSearchForActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void cmbBoxLimitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmbBoxLimitActionPerformed
    {//GEN-HEADEREND:event_cmbBoxLimitActionPerformed
        switch(cmbBoxLimit.getSelectedIndex())
        {
            case 0: 
                switchLimitation = Integer.MAX_VALUE;
                break;
            case 1: 
                switchLimitation = 10;
                break;
            case 2: 
                switchLimitation = 20;
                break;
            case 3: 
                switchLimitation = 50;
                break;
            case 4: 
                switchLimitation = 100;
                break;
        }
        btnSearch.doClick();
    }//GEN-LAST:event_cmbBoxLimitActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbBoxLimit;
    private javax.swing.JComboBox cmbBoxSearchFor;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblLimit;
    private javax.swing.JLabel lblQuery;
    private javax.swing.JLabel lblSearchFor;
    private javax.swing.JList lstDetails;
    private javax.swing.JList lstResults;
    private javax.swing.JPanel pnlLimit;
    private javax.swing.JPanel pnlResultsAndDetails;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JScrollPane scrPnlDetails;
    private javax.swing.JScrollPane scrPnlResults;
    private javax.swing.JTextField txtBoxQuery;
    // End of variables declaration//GEN-END:variables

private void searchByName()
{
    model.clear();
    String query = txtBoxQuery.getText();
    List<String> resultSet = mM.getByName(query);
    resultSet = resultSet.subList(0, Math.min(resultSet.size(), switchLimitation));
    if (!resultSet.isEmpty())
    {
      for (String s: resultSet)
      {
          model.addElement(s);
      }
      lblCount.setText("Count: " + resultSet.size() + ".");
    }
    else
    {
      lblCount.setText("No results.");
    }
}

private void searchByCPR()
{
    model.clear();
    String query = txtBoxQuery.getText();
    List<String> resultSet = mM.getByCPR(query);
    resultSet = resultSet.subList(0, Math.min(resultSet.size(), switchLimitation));
    if (!resultSet.isEmpty())
    {
      for (String s: resultSet)
      {
          model.addElement(s);
      }
      lblCount.setText("Count: " + resultSet.size() + ".");
    }
    else
    {
      lblCount.setText("No results.");
    }
}