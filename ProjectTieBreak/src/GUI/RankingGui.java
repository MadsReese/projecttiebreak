/*
 * 
 */
package GUI;

import BE.Member;
import BE.MemberContainer;
import BLL.RankingManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author boinq
 */
public class RankingGui extends javax.swing.JFrame {
    private DefaultListModel model3 = new DefaultListModel();
    private RankingManager rM;
    private int switchLimitation = Integer.MAX_VALUE;
    private int switchType = 0;
    
    /**
     * Creates new form RankingGui
     */
    public RankingGui() throws SQLServerException, SQLException, FileNotFoundException, IOException
    {
        this.setTitle("Tie-Break Tennis Club Ranking List");
        initComponents();
        rM = RankingManager.getInstance();
        lstRank.setModel(model3);
    }

    public static void main(String[] args) throws SQLServerException, SQLException, FileNotFoundException, IOException
    {
        new RankingGui().setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRank = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Tie-Break Ranking List");

        dateLabel.setText("Last Updated: ");
        dateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lstRank.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "model3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstRank.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstRankValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstRank);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstRankValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstRankValueChanged

    }//GEN-LAST:event_lstRankValueChanged

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        searchByRank();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void updateDateLabel(){
        Date date = new Date( );
        String str = String.format("Last Updated: %tc", date);
        dateLabel.setText(str);
    }
    
    private void searchByRank()
    {
        model3.clear();
        String query = "";
        //String query = txtBoxQuery.getText();
        List<Member> resultSet;
        try
        {
            resultSet = rM.getByRank();
        } catch (SQLException ex)
        {
            Logger.getLogger(RankingGui.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        resultSet = resultSet.subList(0, Math.min(resultSet.size(), switchLimitation));
        if (!resultSet.isEmpty())
        {
            int i = 1;
            for (Member m : resultSet)
            {
                model3.addElement(new MemberContainer(m,i++));
            }
            
        } else
        {
            //lblCount.setText("No results.");
        }
        updateDateLabel();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstRank;
    // End of variables declaration//GEN-END:variables
}
