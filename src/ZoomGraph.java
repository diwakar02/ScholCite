/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diwakarsharma
 */
//imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ZoomGraph extends javax.swing.JFrame {

        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement pst=null;
    /**
     * Creates new form Graph
     */
    public ZoomGraph() {
        initComponents();
        conn=javaconnect.ConnecrDb();
        populateZoomGraph();
    }
    
    public void populateZoomGraph(){
        
         try{    
           
        String sql = "select * from citations where fname=? COLLATE NOCASE or lname=? COLLATE NOCASE ORDER BY fname";
        pst=conn.prepareStatement(sql);
        pst.setString(1,MainPage.fnametxt.getText());
        pst.setString(2,MainPage.lnametxt.getText());
        rs = pst.executeQuery();
        //pst.setString(2,lnametxt.getText());
        while(rs.next()){
          int Y1= Integer.parseInt(rs.getString("Y1"));
          int Y2 = Integer.parseInt(rs.getString("Y2"));
          int Y3 = Integer.parseInt(rs.getString("Y3"));
          int Y4 = Integer.parseInt(rs.getString("Y4"));
          int Y5 = Integer.parseInt(rs.getString("Y5"));
          //Graph
          DefaultCategoryDataset dataset = new DefaultCategoryDataset();
          dataset.setValue(Y1, "Citations", "2009");
          dataset.setValue(Y2, "Citations", "2010");
          dataset.setValue(Y3, "Citations", "2011");
          dataset.setValue(Y4, "Citations", "2012");
          dataset.setValue(Y5, "Citations", "2013");
          JFreeChart chart = ChartFactory.createBarChart("Citations by Graph", "Year", "Citations", dataset, PlotOrientation.VERTICAL, false, true, false);
          CategoryPlot p = chart.getCategoryPlot();
          p.setRangeGridlinePaint(Color.black);
          ChartPanel chartpanel =new ChartPanel(chart);
          //Graph = new ChartFrame("Chart", chart);
          jPanel1.setLayout(new BorderLayout());
          jPanel1.add(chartpanel, BorderLayout.NORTH);
          jPanel1.setSize(250,600);
          jPanel1.setVisible(true);
         
        }
   
    }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_zoomout = new javax.swing.JButton();
        btn_Close = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Graph View (Zoomed)");

        btn_zoomout.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btn_zoomout.setText("Zoom out");
        btn_zoomout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_zoomoutActionPerformed(evt);
            }
        });

        btn_Close.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btn_Close.setText("Close");
        btn_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(501, Short.MAX_VALUE)
                        .addComponent(btn_zoomout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_zoomout)
                    .addComponent(btn_Close))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(700, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_CloseActionPerformed

    private void btn_zoomoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_zoomoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Graph g = new Graph();
        g.setVisible(true);   
    }//GEN-LAST:event_btn_zoomoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Close;
    private javax.swing.JButton btn_zoomout;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
