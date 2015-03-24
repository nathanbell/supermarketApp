
import java.sql.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tutis
 */
public class floorStaffCalendar extends javax.swing.JFrame {
    String usersName = loginScreen.usersName();
    String position = loginScreen.position();
    String userID = loginScreen.userID();
    
    String[] Events = new String[20]; 

    /**
     * Creates new form floorStaffCalendar
     */
    public floorStaffCalendar() {
        initComponents();
        
        Connection connection = null;
 
      // See https://support.ecs.westminster.ac.uk/mysql/index.php for your password
      try     // open the connection to the MySQL server
      { 
         connection = DriverManager.getConnection(
             "jdbc:mysql://localhost:2222/w1431708_0",
             //"jdbc:mysql://elephant.ecs.westminster.ac.uk:3306/w1431708_0",
             "w1431708", "CHXBuRf107JM");
      } catch (SQLException e)
      {
         System.out.println("ERROR: Connection Failed!");
         return;
      }
        
                Statement stmt = null;
       try                // create a Statement for the SQL query
       {  stmt = connection.createStatement(); }
       catch(SQLException e)
       {
          System.out.println("ERROR: Failed to create Statement.");
          return;
       }
 	  
       ResultSet queryRes = null;
       try       
       {
           for (int x = 0; x < 20; x++) {
                Events[x] = " ";
            }
       queryRes = stmt.executeQuery( "SELECT * FROM Event WHERE EventID = '" + userID + "'");
       int b=1;
       while ( queryRes.next() )   
          {           
           
           int numColumns = queryRes.getMetaData().getColumnCount();
           for (int i = 1; i <= numColumns; i++ ){
           
           
           Events[b]= queryRes.getObject(i).toString();
           b = b + 1;           
           
           }
          }       
       }
       
       
       catch (SQLException e)
       {
          System.out.println("ERROR: Cannot execute query.");
       }
        
        
        String Event1 = Events[2] + " " + Events[3];
        String Event2 = Events[5] + " " + Events[6];
        String Event3 = Events[8] + " " + Events[9];
        supermarketRole.setText(position);
        userName.setText(usersName);
        
        event1.setText(Event1);
        event2.setText(Event2);
        event3.setText(Event3);
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
        supermarketRole = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        event3 = new javax.swing.JLabel();
        event2 = new javax.swing.JLabel();
        event1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Your Supermarket position is:");

        supermarketRole.setText("*position*");

        userName.setText("Users Name");

        jLabel3.setText("Welcome!!");

        event3.setText("*event 3*");

        event2.setText("*event 2*");

        event1.setText("*event 1*");

        jLabel4.setText("Your Events are:");

        logOut.setText("Log Out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(supermarketRole, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(103, 103, 103))
                            .addComponent(event1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(event2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(event3, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logOut)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(supermarketRole))
                .addGap(44, 44, 44)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName)
                .addGap(73, 73, 73)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(event1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(event2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(event3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(logOut)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        this.setVisible(false);
        new loginScreen().setVisible(true);
    }//GEN-LAST:event_logOutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(floorStaffCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(floorStaffCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(floorStaffCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(floorStaffCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new floorStaffCalendar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel event1;
    private javax.swing.JLabel event2;
    private javax.swing.JLabel event3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton logOut;
    private javax.swing.JLabel supermarketRole;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}