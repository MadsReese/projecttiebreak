package GUI;

import BE.Member;
import BLL.MemberManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MemberGui extends javax.swing.JFrame
{
    private DefaultListModel model = new DefaultListModel();
    private MemberManager mM = null;
    private int switchLimitation = Integer.MAX_VALUE;
    private int switchType = 0;

    /**
     * Initializes the main member GUI.
     */
    public MemberGui()
    {
        try
        {
            mM = MemberManager.getInstance();
        } 
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(MemberGui.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex)
        {
            Logger.getLogger(MemberGui.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLServerException ex)
        {
            Logger.getLogger(MemberGui.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(MemberGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        lstResults.setModel(model);
        debugFetch();
    }

    public static void main(String[] args)
    {
        new MemberGui().setVisible(true);
        int dialogResult = JOptionPane.showConfirmDialog(null, "WARNING: This is an unfinished and unreleased build!\n", null, WIDTH, 2);
        if (dialogResult == JOptionPane.CANCEL_OPTION || dialogResult == JOptionPane.NO_OPTION)
        {
            System.exit(0);
        }
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
        pnlResultsAndDetails = new javax.swing.JPanel();
        scrPnlResults = new javax.swing.JScrollPane();
        lstResults = new javax.swing.JList();
        scrPnlDetails = new javax.swing.JScrollPane();
        lstDetails = new javax.swing.JList();
        btnClose = new javax.swing.JButton();
        lblCount = new javax.swing.JLabel();
        btnAddMember = new javax.swing.JButton();
        btnRemoveMember = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        lblSearchFor = new javax.swing.JLabel();
        cmbBoxSearchType = new javax.swing.JComboBox();
        pnlLimit = new javax.swing.JPanel();
        lblLimit = new javax.swing.JLabel();
        cmbBoxLimit = new javax.swing.JComboBox();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblQuery.setText("Query");

        pnlResultsAndDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Results and Details"));
        pnlResultsAndDetails.setName("test"); // NOI18N

        scrPnlResults.setViewportView(lstResults);

        scrPnlDetails.setViewportView(lstDetails);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCloseActionPerformed(evt);
            }
        });

        lblCount.setText("Count: ");

        btnAddMember.setText("Add...");
        btnAddMember.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddMemberActionPerformed(evt);
            }
        });

        btnRemoveMember.setText("Remove");

        javax.swing.GroupLayout pnlResultsAndDetailsLayout = new javax.swing.GroupLayout(pnlResultsAndDetails);
        pnlResultsAndDetails.setLayout(pnlResultsAndDetailsLayout);
        pnlResultsAndDetailsLayout.setHorizontalGroup(
            pnlResultsAndDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultsAndDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultsAndDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResultsAndDetailsLayout.createSequentialGroup()
                        .addGroup(pnlResultsAndDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrPnlResults, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlResultsAndDetailsLayout.createSequentialGroup()
                                .addComponent(btnAddMember)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemoveMember)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlResultsAndDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlResultsAndDetailsLayout.createSequentialGroup()
                                .addGap(0, 143, Short.MAX_VALUE)
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
                    .addComponent(btnClose)
                    .addComponent(btnAddMember)
                    .addComponent(btnRemoveMember))
                .addContainerGap())
        );

        pnlSearch.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Options"));
        pnlSearch.setPreferredSize(new java.awt.Dimension(226, 158));

        lblSearchFor.setText("Search for...");

        cmbBoxSearchType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Member No.", "Full Name" }));
        cmbBoxSearchType.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbBoxSearchTypeActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cmbBoxSearchType, 0, 168, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addComponent(lblSearchFor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBoxSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSearchActionPerformed(evt);
            }
        });

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
                        .addContainerGap(238, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlResultsAndDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQuery)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBoxQuery)
                                .addGap(8, 8, 8)
                                .addComponent(btnSearch)
                                .addGap(63, 63, 63))
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
                        .addComponent(btnSearch))
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
    
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void cmbBoxLimitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmbBoxLimitActionPerformed
    {//GEN-HEADEREND:event_cmbBoxLimitActionPerformed
        switch (cmbBoxLimit.getSelectedIndex())
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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSearchActionPerformed
    {//GEN-HEADEREND:event_btnSearchActionPerformed
//        if (switchType == 1)
//        {
//            searchByName();
//        }
//        else
//        {
//            searchByMemberNo();
//        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cmbBoxSearchTypeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmbBoxSearchTypeActionPerformed
    {//GEN-HEADEREND:event_cmbBoxSearchTypeActionPerformed
        switch (cmbBoxSearchType.getSelectedIndex())
        {
            case 0:
                switchType = 0;
                break;
            case 1:
                switchType = 1;
                break;
        }
        btnSearch.doClick();
    }//GEN-LAST:event_cmbBoxSearchTypeActionPerformed

    private void btnAddMemberActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddMemberActionPerformed
    {//GEN-HEADEREND:event_btnAddMemberActionPerformed
        new NewMemberGui().setVisible(true);
    }//GEN-LAST:event_btnAddMemberActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMember;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRemoveMember;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbBoxLimit;
    private javax.swing.JComboBox cmbBoxSearchType;
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
//        model.clear();
//        String query = txtBoxQuery.getText();
//        List<Member> resultSet = mM.getByName(query);
//        resultSet = resultSet.subList(0, Math.min(resultSet.size(), switchLimitation));
//        if (!resultSet.isEmpty())
//        {
//            for (Member m : resultSet)
//            {
//                String memb = m.getMemberNo() + " - " + m.getFirstName() + " " + m.getLastName();
//                model.addElement(memb);
//            }
//            lblCount.setText("Count: " + resultSet.size() + ".");
//        } else
//        {
//            lblCount.setText("No results.");
//        }
    }

    private void searchByMemberNo()
    {
//        model.clear();
//        String query = txtBoxQuery.getText();
//        Member result = mM.getByMemberNo(query);
//        if (result != null)
//        {
//            model.addElement(result);
//            lblCount.setText("Count: 1");
//        } 
//        else
//        {
//            lblCount.setText("No results.");
//        }
    }
    
    private void debugFetch()
    {
        List<Member> resultSet = mM.getAll();
        resultSet = resultSet.subList(0, Math.min(resultSet.size(), switchLimitation));
        if (!resultSet.isEmpty())
        {
            for (Member m : resultSet)
            {
                String memb = m.getMemberNo() + " - " + m.getFirstName() + " " + m.getLastName();
                model.addElement(memb);
            }
            lblCount.setText(resultSet.size() + " results!");
        }
        else
        {
            lblCount.setText("No Results. :(");;
        }
        resultSet.clear();
    }
}