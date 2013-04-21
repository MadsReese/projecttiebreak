/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.BookingOptions;
import BLL.BookingOptionsManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;
import javax.swing.WindowConstants;

/**
 *
 * @author Jesper
 */
public class OptionsGui extends javax.swing.JFrame
{
    private BookingOptionsManager bom;
    private ArrayList<BookingOptions> options;
    /**
     * Creates new form OptionsGui
     */
    public OptionsGui()
    {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setup();
    }

    //get the
    private void setup()
    {
        
        try
        {
            bom = BookingOptionsManager.getInstance();
        } catch (IOException ex)
        {
            Logger.getLogger(OptionsGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            options = bom.getAll();
        } catch (SQLException ex)
        {
            Logger.getLogger(OptionsGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(BookingOptions b: options)
        {
            if(b.getType().equalsIgnoreCase("outdoor"))
            {
                txtOutdoorPrice.setText(b.getPrice()+"");
                txtOutdoorRentalFrom.setText(b.getRentableFromDate());
                txtOutdoorRentalTo.setText(b.getRentableToDate());
                txtOutdoorRentalTimeFrom.setText(b.getRentableFromTime()/60 + ":" +b.getRentableFromTime()%60);
                txtOutdoorRentalTimeTo.setText(b.getRentableToTime()/60 + ":" + b.getRentableToTime()%60);
            }
            else if(b.getType().equalsIgnoreCase("indoor"))
            {
                txtIndoorPrice.setText(b.getPrice()+"");
                txtIndoorRentalFrom.setText(b.getRentableFromDate());
                txtIndoorRentalTo.setText(b.getRentableToDate());
                txtIndoorRentalTimeFrom.setText(b.getRentableFromTime()/60 + ":" +b.getRentableFromTime()%60);
                txtIndoorRentalTimeTo.setText(b.getRentableToTime()/60 + ":" + b.getRentableToTime()%60);
            }    
        }
        
    }
    
    private void updateOptions()
    {
        options = new ArrayList();
        try
        {
        options.add(getIndoorText());
        options.add(getOutdoorText());
        }
        catch(DataFormatException e)
        {
            //JOptionPane.showMessageDialo(frame,"input error",e.getMessage());
        }
        BookingOptions[] tempOptions = new BookingOptions[2];
        try
        {
            tempOptions[0]=getIndoorText();
        } catch (DataFormatException ex)
        {
            Logger.getLogger(OptionsGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            tempOptions[1]=getOutdoorText();
        } catch (DataFormatException ex)
        {
            Logger.getLogger(OptionsGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            bom.updateAll(tempOptions);
        } catch (SQLException ex)
        {
            Logger.getLogger(OptionsGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private BookingOptions getIndoorText() throws DataFormatException
    {
        
        String indoorPrice = txtIndoorPrice.getText();
        
        double price = Double.parseDouble(indoorPrice);
        
        
        String[] rentableFromDate = txtIndoorRentalFrom.getText().split("-");
        int month = Integer.parseInt(rentableFromDate[1]);
        int day = Integer.parseInt(rentableFromDate[0]);
        if(!(month>0 && month < 13 && day>0 && day<32))
            throw new DataFormatException("Indoor From Date Format");
        String rentableDate1 = txtIndoorRentalFrom.getText();
        
        String[] rentableToDate = txtIndoorRentalTo.getText().split("-");
        month = Integer.parseInt(rentableFromDate[1]);
        day = Integer.parseInt(rentableFromDate[0]);
        if(!(month>0 && month < 13 && day>0 && day<32))
            throw new DataFormatException("Indoor To Date Format");
        String rentableDate2 = txtIndoorRentalFrom.getText();
        
        String[] rentableFromTime = txtIndoorRentalTimeFrom.getText().split(":");
        int rentableFromTime2 = Integer.parseInt(rentableFromTime[0])*60+Integer.parseInt(rentableFromTime[1]);
        
        String[] rentableToTime = txtIndoorRentalTimeFrom.getText().split(":");
        int rentableToTime2 = Integer.parseInt(rentableToTime[0])*60+Integer.parseInt(rentableToTime[1]);
        
        if(!(rentableFromTime2<=rentableToTime2 && rentableToTime2<1440 && rentableFromTime2<1440))
            throw new DataFormatException("Indoor Time Format");
            
        return new BookingOptions("Indoor",rentableDate1,rentableDate2,price,rentableFromTime2,rentableToTime2);
    }
    private BookingOptions getOutdoorText() throws DataFormatException
    {
        String outdoorPrice = txtOutdoorPrice.getText();
        
        double price = Double.parseDouble(outdoorPrice);
        
        
        String[] rentableFromDate = txtOutdoorRentalFrom.getText().split("-");
        int month = Integer.parseInt(rentableFromDate[1]);
        int day = Integer.parseInt(rentableFromDate[0]);
        if(!(month>0 && month < 13 && day>0 && day<32))
            throw new DataFormatException("Outdoor From Date Format");
        String rentableDate1 = txtOutdoorRentalFrom.getText();
        
        String[] rentableToDate = txtOutdoorRentalTo.getText().split("-");
        month = Integer.parseInt(rentableFromDate[1]);
        day = Integer.parseInt(rentableFromDate[0]);
        if(!(month>0 && month < 13 && day>0 && day<32))
            throw new DataFormatException("Outdoor To Date Format");
        String rentableDate2 = txtOutdoorRentalFrom.getText();
        
        String[] rentableFromTime = txtOutdoorRentalTimeFrom.getText().split(":");
        int rentableFromTime2 = Integer.parseInt(rentableFromTime[0])*60+Integer.parseInt(rentableFromTime[1]);
        
        String[] rentableToTime = txtOutdoorRentalTimeFrom.getText().split(":");
        int rentableToTime2 = Integer.parseInt(rentableToTime[0])*60+Integer.parseInt(rentableToTime[1]);
        
        if(!(rentableFromTime2<=rentableToTime2 && rentableToTime2<1440 && rentableFromTime2<1440))
            throw new DataFormatException("Outdoor Time Format");
            
        return new BookingOptions("Outdoor",rentableDate1,rentableDate2,price,rentableFromTime2,rentableToTime2);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblOutDoorPriceText = new javax.swing.JLabel();
        txtOutdoorPrice = new javax.swing.JTextField();
        lblIndoorRentalPrice = new javax.swing.JLabel();
        txtIndoorPrice = new javax.swing.JTextField();
        lblOutdoorRental = new javax.swing.JLabel();
        txtOutdoorRentalFrom = new javax.swing.JTextField();
        lblOutdoorTo = new javax.swing.JLabel();
        txtOutdoorRentalTo = new javax.swing.JTextField();
        txtIndoorRentalTo = new javax.swing.JTextField();
        lblIndoorFrom = new javax.swing.JLabel();
        txtIndoorRentalFrom = new javax.swing.JTextField();
        lblIndoorRental = new javax.swing.JLabel();
        lblInDoorFrom = new javax.swing.JLabel();
        lblOutDoorFrom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOutdoorRentalTimeFrom = new javax.swing.JTextField();
        lblFrom = new javax.swing.JLabel();
        txtOutdoorRentalTimeTo = new javax.swing.JTextField();
        lblIndoorRentalHours = new javax.swing.JLabel();
        lblInDoorFrom1 = new javax.swing.JLabel();
        txtIndoorRentalTimeFrom = new javax.swing.JTextField();
        txtIndoorFrom1 = new javax.swing.JLabel();
        txtIndoorRentalTimeTo = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnApply = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblOutDoorPriceText.setText("Outdoor court rental price:");

        lblIndoorRentalPrice.setText("Indoor court rental price:");

        lblOutdoorRental.setText("Outdoor court rental period: ");

        txtOutdoorRentalFrom.setText("dd-mm");

        lblOutdoorTo.setText("To");

        txtOutdoorRentalTo.setText("dd-mm");

        txtIndoorRentalTo.setText("dd-mm");

        lblIndoorFrom.setText("To");

        txtIndoorRentalFrom.setText("dd-mm");

        lblIndoorRental.setText("Indoor court rental period:");

        lblInDoorFrom.setText("From");

        lblOutDoorFrom.setText("From");

        jLabel1.setText("Outdoor court rental hours:");

        jLabel2.setText("From");

        txtOutdoorRentalTimeFrom.setText("HH:mm");

        lblFrom.setText("To");

        txtOutdoorRentalTimeTo.setText("HH:mm");

        lblIndoorRentalHours.setText("Indoor court rental hours:");

        lblInDoorFrom1.setText("From");

        txtIndoorRentalTimeFrom.setText("HH:mm");

        txtIndoorFrom1.setText("To");

        txtIndoorRentalTimeTo.setText("HH:mm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblOutdoorRental))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOutDoorPriceText)
                                    .addComponent(lblIndoorRentalPrice))))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblOutDoorFrom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtOutdoorRentalFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOutdoorPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIndoorPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOutdoorRentalTimeFrom))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblIndoorRentalHours)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblInDoorFrom1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblIndoorRental)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblInDoorFrom)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIndoorRentalFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIndoorRentalTimeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblOutdoorTo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtOutdoorRentalTo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFrom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOutdoorRentalTimeTo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIndoorFrom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIndoorRentalTo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIndoorFrom1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIndoorRentalTimeTo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOutDoorPriceText)
                    .addComponent(txtOutdoorPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIndoorRentalPrice)
                    .addComponent(txtIndoorPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOutdoorRental)
                    .addComponent(txtOutdoorRentalFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOutdoorTo)
                    .addComponent(txtOutdoorRentalTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOutDoorFrom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtOutdoorRentalTimeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFrom)
                    .addComponent(txtOutdoorRentalTimeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIndoorRental)
                    .addComponent(txtIndoorRentalFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIndoorFrom)
                    .addComponent(txtIndoorRentalTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInDoorFrom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIndoorRentalHours)
                    .addComponent(lblInDoorFrom1)
                    .addComponent(txtIndoorRentalTimeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndoorFrom1)
                    .addComponent(txtIndoorRentalTimeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Booking", jPanel1);

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelActionPerformed(evt);
            }
        });

        btnApply.setText("Apply");
        btnApply.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApply)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnApply, btnCancel, btnOk});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel)
                    .addComponent(btnApply))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnApplyActionPerformed
    {//GEN-HEADEREND:event_btnApplyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnApplyActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnOkActionPerformed
    {//GEN-HEADEREND:event_btnOkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelActionPerformed
    {//GEN-HEADEREND:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(OptionsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(OptionsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(OptionsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(OptionsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new OptionsGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblInDoorFrom;
    private javax.swing.JLabel lblInDoorFrom1;
    private javax.swing.JLabel lblIndoorFrom;
    private javax.swing.JLabel lblIndoorRental;
    private javax.swing.JLabel lblIndoorRentalHours;
    private javax.swing.JLabel lblIndoorRentalPrice;
    private javax.swing.JLabel lblOutDoorFrom;
    private javax.swing.JLabel lblOutDoorPriceText;
    private javax.swing.JLabel lblOutdoorRental;
    private javax.swing.JLabel lblOutdoorTo;
    private javax.swing.JLabel txtIndoorFrom1;
    private javax.swing.JTextField txtIndoorPrice;
    private javax.swing.JTextField txtIndoorRentalFrom;
    private javax.swing.JTextField txtIndoorRentalTimeFrom;
    private javax.swing.JTextField txtIndoorRentalTimeTo;
    private javax.swing.JTextField txtIndoorRentalTo;
    private javax.swing.JTextField txtOutdoorPrice;
    private javax.swing.JTextField txtOutdoorRentalFrom;
    private javax.swing.JTextField txtOutdoorRentalTimeFrom;
    private javax.swing.JTextField txtOutdoorRentalTimeTo;
    private javax.swing.JTextField txtOutdoorRentalTo;
    // End of variables declaration//GEN-END:variables
}
