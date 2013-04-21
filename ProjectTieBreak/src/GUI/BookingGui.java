/*
 * 
 */
package GUI;

import BE.Booking;
import BE.Court;
import BE.CourtContainer;
import BLL.BookingManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author boinq
 */
public class BookingGui extends javax.swing.JFrame {
    private DefaultListModel model4 = new DefaultListModel();
    private DefaultListModel model5 = new DefaultListModel();
    private BookingManager bM;
    private int switchLimitation = Integer.MAX_VALUE;
    private int switchType = 0;
    /**
     * Creates new form BookingGui
     */
    public BookingGui() throws SQLServerException, SQLException, FileNotFoundException, IOException
    {
        this.setTitle("Tie-Break Tennis Club Booking");
        initComponents();
        bM = BookingManager.getInstance();
        lstCourts.setModel(model4);
        lstBookings.setModel(model5);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstCourts = new javax.swing.JList();
        btnRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstBookings = new javax.swing.JList();
        btnAddBooking = new javax.swing.JButton();
        txtFrom = new javax.swing.JTextField();
        txtTo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMemberNo = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        txtTime = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstCourts.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "model4" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstCourts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCourtsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCourts);
        lstCourts.getAccessibleContext().setAccessibleName("");

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tie-Break Booking");

        lstBookings.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Bookings" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstBookings);

        btnAddBooking.setText("Add booking");
        btnAddBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookingActionPerformed(evt);
            }
        });

        txtFrom.setText("dd-mm-yyyy");

        txtTo.setText("dd-mm-yyyy");

        jLabel2.setText("From:");

        jLabel3.setText("To:");

        jLabel4.setText("Booker:");

        txtMemberNo.setToolTipText("Member No.");

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        txtTime.setToolTipText("fx 17:00");

        jLabel5.setText("Time:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddBooking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtMemberNo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(txtTo)
                                    .addComponent(txtTime))))
                        .addGap(348, 348, 348)
                        .addComponent(btnRemove)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMemberNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBooking)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstCourtsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCourtsValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lstCourtsValueChanged

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        getAllAvailbleCourts();
        getAllBookings();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookingActionPerformed
        Court c = (Court)lstCourts.getSelectedValue();
        int f;
        int t;
        int cc = c.getId();
        int m;
        int ti;
        f = Integer.parseInt(txtFrom.getText());
        t = Integer.parseInt(txtTo.getText());
        m = Integer.parseInt(txtMemberNo.getText());
        ti = Integer.parseInt(txtTime.getText());
        
        Booking bookingobj = Booking.createSimple(1,f,t,cc,m,ti);
        try 
        {
            bM.addBooking(bookingobj);
        } 
        catch (SQLServerException ex) 
        {
            Logger.getLogger(BookingGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(BookingGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAddBookingActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        Booking c = (Booking)lstBookings.getSelectedValue();
        lstCourts.clearSelection();
        System.out.println("Derp");
        model5.removeElement(c);
        try
        {
            bM.removeBooking(c);
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        getAllBookings();
        
    }//GEN-LAST:event_btnRemoveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLServerException, SQLException, FileNotFoundException, IOException
    {
       new BookingGui().setVisible(true);
            
    }
    
    private void getAllBookings(){
        model5.clear();
        String query = "";
        //String query = txtBoxQuery.getText();
        List<Court> resultSet;
        try
        {
            resultSet = bM.getAllBookings();
        } catch (SQLException ex)
        {
            Logger.getLogger(RankingGui.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        resultSet = resultSet.subList(0, Math.min(resultSet.size(), switchLimitation));
        if (!resultSet.isEmpty())
        {
            int i = 1;
            for (Court m : resultSet)
            {
                model5.addElement(new CourtContainer(m));
            }
            
        } else
        {
            
            //lblCount.setText("No results.");
        }        
    }
    
    private void getAllAvailbleCourts(){
        model4.clear();
        String query = "";
        //String query = txtBoxQuery.getText();
        List<Court> resultSet;
        try
        {
            resultSet = bM.getAllCourts();
        } catch (SQLException ex)
        {
            Logger.getLogger(RankingGui.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        resultSet = resultSet.subList(0, Math.min(resultSet.size(), switchLimitation));
        if (!resultSet.isEmpty())
        {
            int i = 1;
            for (Court m : resultSet)
            {
                model4.addElement(new CourtContainer(m));
            }
            
        } else
        {
            
            //lblCount.setText("No results.");
        }        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBooking;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstBookings;
    private javax.swing.JList lstCourts;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtMemberNo;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}
