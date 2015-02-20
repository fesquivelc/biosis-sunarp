/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.Controlador;
import com.personal.utiles.FormularioUtil;
import com.personal.utiles.ParametrosUtil;
import com.personal.utiles.PropertiesUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.apache.commons.beanutils.BeanUtils;
import utiles.Encriptador;

/**
 *
 * @author fesquivelc
 */
public class Configuracion extends javax.swing.JInternalFrame {

    /**
     * Creates new form Configuracion
     */
    private final String urlRRHH;
    private final String urlBIOSIS;
    private final String urlBIOSTAR;

    private Properties rrhh;
    private Properties biosis;
    private Properties biostar;

    public Configuracion() {
        initComponents();

        urlRRHH = "config/rrhh-config.properties";
        urlBIOSIS = "config/biosis-config.properties";
        urlBIOSTAR = "config/biostar-config.properties";

        mostrarValores();

    }

    private void mostrarValores() {
        //CARGANDO PROPIEDADES DE RECURSOS HUMANOS
        rrhh = PropertiesUtil.cargarProperties(urlRRHH);
        biosis = PropertiesUtil.cargarProperties(urlBIOSIS);
        biostar = PropertiesUtil.cargarProperties(urlBIOSTAR);

        cargar(rrhh, cboTipoBD1, txtConexion1, txtUsuario1, txtPassword1);
        cargar(biostar, cboTipoBD2, txtConexion2, txtUsuario2, txtPassword2);
        cargar(biosis, cboTipoBD3, txtConexion3, txtUsuario3, txtPassword3);

    }

    private void cargar(Properties fichero, JComboBox combo, JTextField txtConexion, JTextField txtUsuario, JTextField txtPassword) {
        int tipoBD = Integer.parseInt(fichero.getProperty("tipo"));

//        String driver = ParametrosUtil.obtenerDriver(tipoBD);
        String url = fichero.getProperty("url");
        String usuario = fichero.getProperty("usuario");
        String password = fichero.getProperty("password");

        combo.setSelectedIndex(tipoBD - 1);
        txtConexion.setText(url);
        txtUsuario.setText(usuario);
        txtPassword.setText(Encriptador.decrypt(password));
    }

    private void guardar(Properties fichero, String urlFichero, JComboBox combo, JTextField txtConexion, JTextField txtUsuario, JTextField txtPassword) {

        int tipoBD = combo.getSelectedIndex() + 1;

//        String driver = ParametrosUtil.obtenerDriver(tipoBD);
        String url = txtConexion.getText();
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

//        combo.setSelectedIndex(tipoBD - 1);
        txtConexion.setText(url);
        txtUsuario.setText(usuario);
        txtPassword.setText(password);
        
        fichero.setProperty("url", url);
        fichero.setProperty("usuario", usuario);
        fichero.setProperty("password", Encriptador.encrypt(password));
        fichero.setProperty("tipo", tipoBD+"");

        PropertiesUtil.guardarProperties(fichero, urlFichero);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlRRHH = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtConexion1 = new javax.swing.JTextField();
        txtUsuario1 = new javax.swing.JTextField();
        txtPassword1 = new javax.swing.JPasswordField();
        jLabel43 = new javax.swing.JLabel();
        cboTipoBD1 = new javax.swing.JComboBox();
        pnlBiostar = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtConexion2 = new javax.swing.JTextField();
        txtUsuario2 = new javax.swing.JTextField();
        txtPassword2 = new javax.swing.JPasswordField();
        jLabel47 = new javax.swing.JLabel();
        cboTipoBD2 = new javax.swing.JComboBox();
        pnlBiosis = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtConexion3 = new javax.swing.JTextField();
        txtUsuario3 = new javax.swing.JTextField();
        txtPassword3 = new javax.swing.JPasswordField();
        jLabel51 = new javax.swing.JLabel();
        cboTipoBD3 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Configuración de base de datos");
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        pnlRRHH.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de conexión a RRHH"));
        pnlRRHH.setLayout(new java.awt.GridBagLayout());

        jLabel40.setText("Conexión:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlRRHH.add(jLabel40, gridBagConstraints);

        jLabel41.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlRRHH.add(jLabel41, gridBagConstraints);

        jLabel42.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlRRHH.add(jLabel42, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlRRHH.add(txtConexion1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlRRHH.add(txtUsuario1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlRRHH.add(txtPassword1, gridBagConstraints);

        jLabel43.setText("Tipo de BD:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlRRHH.add(jLabel43, gridBagConstraints);

        cboTipoBD1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SQL Server", "PostgreSQL", "MySQL" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        pnlRRHH.add(cboTipoBD1, gridBagConstraints);

        getContentPane().add(pnlRRHH);

        pnlBiostar.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de conexión a Biostar"));
        pnlBiostar.setLayout(new java.awt.GridBagLayout());

        jLabel44.setText("Conexión:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlBiostar.add(jLabel44, gridBagConstraints);

        jLabel45.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlBiostar.add(jLabel45, gridBagConstraints);

        jLabel46.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlBiostar.add(jLabel46, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlBiostar.add(txtConexion2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlBiostar.add(txtUsuario2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlBiostar.add(txtPassword2, gridBagConstraints);

        jLabel47.setText("Tipo de BD:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlBiostar.add(jLabel47, gridBagConstraints);

        cboTipoBD2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SQL Server", "PostgreSQL", "MySQL" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        pnlBiostar.add(cboTipoBD2, gridBagConstraints);

        getContentPane().add(pnlBiostar);

        pnlBiosis.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de conexión a Biosis"));
        pnlBiosis.setLayout(new java.awt.GridBagLayout());

        jLabel48.setText("Conexión:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlBiosis.add(jLabel48, gridBagConstraints);

        jLabel49.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlBiosis.add(jLabel49, gridBagConstraints);

        jLabel50.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlBiosis.add(jLabel50, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlBiosis.add(txtConexion3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlBiosis.add(txtUsuario3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlBiosis.add(txtPassword3, gridBagConstraints);

        jLabel51.setText("Tipo de BD:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        pnlBiosis.add(jLabel51, gridBagConstraints);

        cboTipoBD3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SQL Server", "PostgreSQL", "MySQL" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        pnlBiosis.add(cboTipoBD3, gridBagConstraints);

        getContentPane().add(pnlBiosis);

        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0, 5, 0};
        jPanel4Layout.rowHeights = new int[] {0};
        jPanel4.setLayout(jPanel4Layout);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel4.add(jButton1, gridBagConstraints);

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel4.add(jButton2, gridBagConstraints);

        getContentPane().add(jPanel4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.guardar(rrhh, urlRRHH, cboTipoBD1, txtConexion1, txtUsuario1, txtPassword1);
        this.guardar(biostar, urlBIOSTAR, cboTipoBD2, txtConexion2, txtUsuario2, txtPassword2);
        this.guardar(biosis, urlBIOSIS, cboTipoBD3, txtConexion3, txtUsuario3, txtPassword3);
        FormularioUtil.mensajeExito(this, Controlador.NUEVO);
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboTipoBD1;
    private javax.swing.JComboBox cboTipoBD2;
    private javax.swing.JComboBox cboTipoBD3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel pnlBiosis;
    private javax.swing.JPanel pnlBiostar;
    private javax.swing.JPanel pnlRRHH;
    private javax.swing.JTextField txtConexion1;
    private javax.swing.JTextField txtConexion2;
    private javax.swing.JTextField txtConexion3;
    private javax.swing.JPasswordField txtPassword1;
    private javax.swing.JPasswordField txtPassword2;
    private javax.swing.JPasswordField txtPassword3;
    private javax.swing.JTextField txtUsuario1;
    private javax.swing.JTextField txtUsuario2;
    private javax.swing.JTextField txtUsuario3;
    // End of variables declaration//GEN-END:variables

    private void inicializar() {

    }

    private void guardar(Properties fichero, String urlFichero, JComboBox combo, JTextField txtConexion, JTextField txtUsuario, JTextField txtPassword, boolean selected) {
        int tipoBD = combo.getSelectedIndex() + 1;

//        String driver = ParametrosUtil.obtenerDriver(tipoBD);
        String url = txtConexion.getText();
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

//        combo.setSelectedIndex(tipoBD - 1);
        txtConexion.setText(url);
        txtUsuario.setText(usuario);
        txtPassword.setText(password);
        
        fichero.setProperty("url", url);
        fichero.setProperty("usuario", usuario);
        fichero.setProperty("password", Encriptador.encrypt(password));
        fichero.setProperty("tipo", tipoBD+"");
        
        if(selected){
            fichero.setProperty("action", "create");
        }else{
            fichero.setProperty("action", "none");
        }

        PropertiesUtil.guardarProperties(fichero, urlFichero);
    }

}
