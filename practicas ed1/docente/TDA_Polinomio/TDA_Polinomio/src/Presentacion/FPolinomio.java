package Presentacion;

import Negocio.Monomio;
import Negocio.Polinomio;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author niels
 */
public class FPolinomio extends javax.swing.JFrame {

    Polinomio A = new Polinomio();
    Polinomio B = new Polinomio();
    Polinomio P = new Polinomio();
    boolean esValido;
    
    public FPolinomio() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void habilitarInsertar(){
        if (!tfCoeficiente.getText().isEmpty() && !tfExponente.getText().isEmpty()){
            btnInsertarA.setEnabled(true);
            btnInsertarB.setEnabled(true);
        }
        else{
            btnInsertarA.setEnabled(false);
            btnInsertarB.setEnabled(false);
        }
    }
    
    private void habilitarEvaluar(){
        if (!tfX.getText().isEmpty()){
            btnEvaluar.setEnabled(true);
        }
        else{
            btnEvaluar.setEnabled(false);
        }    
    }
    private void habilitarOperaciones(){
        if (!tfPolinomioA.getText().isEmpty() && !tfPolinomioB.getText().isEmpty()){
            btnCalcular.setEnabled(true);
            cbxOperacion.setEnabled(true);
        }
        else{
            btnCalcular.setEnabled(false);
            cbxOperacion.setEnabled(false);
        }    
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfCoeficiente = new javax.swing.JTextField();
        tfExponente = new javax.swing.JTextField();
        cbxSignoExp = new javax.swing.JComboBox<String>();
        cbxSignoCoef = new javax.swing.JComboBox<String>();
        btnInsertarA = new javax.swing.JButton();
        btnInsertarB = new javax.swing.JButton();
        tfPolinomioA = new javax.swing.JTextField();
        tfPolinomioB = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxOperacion = new javax.swing.JComboBox<String>();
        btnCalcular = new javax.swing.JButton();
        tfResultado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxSignoX = new javax.swing.JComboBox<String>();
        tfX = new javax.swing.JTextField();
        btnEvaluar = new javax.swing.JButton();
        btnBorrarPol = new javax.swing.JButton();
        btnBorrarMon = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbResultado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TDA Polinomio");

        tfCoeficiente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tfCoeficiente.setPreferredSize(new java.awt.Dimension(84, 26));
        tfCoeficiente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCoeficienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCoeficienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCoeficienteKeyTyped(evt);
            }
        });

        tfExponente.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        tfExponente.setPreferredSize(new java.awt.Dimension(84, 26));
        tfExponente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfExponenteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfExponenteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfExponenteKeyTyped(evt);
            }
        });

        cbxSignoExp.setEditable(true);
        cbxSignoExp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cbxSignoExp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+", "-" }));

        cbxSignoCoef.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbxSignoCoef.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+", "-" }));

        btnInsertarA.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnInsertarA.setText("Insertar en A");
        btnInsertarA.setEnabled(false);
        btnInsertarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarAActionPerformed(evt);
            }
        });

        btnInsertarB.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnInsertarB.setText("Insertar en B");
        btnInsertarB.setEnabled(false);
        btnInsertarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarBActionPerformed(evt);
            }
        });

        tfPolinomioA.setEditable(false);
        tfPolinomioA.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tfPolinomioA.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfPolinomioACaretUpdate(evt);
            }
        });

        tfPolinomioB.setEditable(false);
        tfPolinomioB.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tfPolinomioB.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfPolinomioBCaretUpdate(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("A :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("B :");

        cbxOperacion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbxOperacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+", "-", "x" }));
        cbxOperacion.setEnabled(false);

        btnCalcular.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.setEnabled(false);
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        tfResultado.setEditable(false);
        tfResultado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("X = ");

        cbxSignoX.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbxSignoX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+", "-" }));

        tfX.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tfX.setPreferredSize(new java.awt.Dimension(84, 26));
        tfX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfXKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfXKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfXKeyTyped(evt);
            }
        });

        btnEvaluar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnEvaluar.setText("Evaluar");
        btnEvaluar.setEnabled(false);
        btnEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluarActionPerformed(evt);
            }
        });

        btnBorrarPol.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBorrarPol.setText("Borrar Polinomio");
        btnBorrarPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPolActionPerformed(evt);
            }
        });

        btnBorrarMon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBorrarMon.setText("Borrar Monomio");
        btnBorrarMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarMonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Operaciones");

        lbResultado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbResultado.setText("Resultado: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("X");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Res :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel3))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfResultado)
                                    .addComponent(tfPolinomioB)
                                    .addComponent(tfPolinomioA, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCalcular)
                                    .addComponent(cbxOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxSignoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEvaluar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBorrarPol)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBorrarMon))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnInsertarB)
                                        .addGap(68, 68, 68)
                                        .addComponent(cbxSignoCoef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfCoeficiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnInsertarA))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbxSignoExp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfExponente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lbResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSignoExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfExponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCoeficiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxSignoCoef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnInsertarA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInsertarB)))
                .addGap(13, 13, 13)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPolinomioA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbxOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPolinomioB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnCalcular))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxSignoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEvaluar)
                            .addComponent(btnBorrarPol)
                            .addComponent(btnBorrarMon))
                        .addGap(18, 18, 18)
                        .addComponent(lbResultado))
                    .addComponent(jLabel7))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfExponenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfExponenteKeyPressed
        char e = evt.getKeyChar();
        int keyCode = evt.getKeyCode();
        if (Character.isDigit(e) | keyCode == KeyEvent.VK_BACK_SPACE)// | keyCode == KeyEvent.VK_SUBTRACT)
            esValido = true;
        else
            esValido = false;
    }//GEN-LAST:event_tfExponenteKeyPressed

    private void tfCoeficienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCoeficienteKeyPressed
        char e = evt.getKeyChar();
        int keyCode = evt.getKeyCode();
        //JOptionPane.showMessageDialog(null, keyCode);
        if (Character.isDigit(e) || keyCode == KeyEvent.VK_BACK_SPACE)
            esValido = true;
        else
            esValido = false;
    }//GEN-LAST:event_tfCoeficienteKeyPressed

    private void tfExponenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfExponenteKeyReleased
        habilitarInsertar();
    }//GEN-LAST:event_tfExponenteKeyReleased

    private void tfExponenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfExponenteKeyTyped
        if (!esValido){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Introducir solo Numeros");
        }
    }//GEN-LAST:event_tfExponenteKeyTyped

    private void tfCoeficienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCoeficienteKeyReleased
        habilitarInsertar();
    }//GEN-LAST:event_tfCoeficienteKeyReleased

    private void tfCoeficienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCoeficienteKeyTyped
        if (!esValido){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Introducir solo Numeros");
        }
    }//GEN-LAST:event_tfCoeficienteKeyTyped

    private void btnInsertarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarAActionPerformed
        int coef = Integer.parseInt(tfCoeficiente.getText());
        int exp = Integer.parseInt(tfExponente.getText());
        Monomio M;
        if (cbxSignoCoef.getSelectedItem().equals("+"))
            M = new Monomio('+',coef, exp);
        else
            M = new Monomio('-',coef, exp);
        
        if (!cbxSignoExp.getSelectedItem().equals("+"))
            M.setExp(-exp);
        
        A.Insertar(M);
        
        tfPolinomioA.setText(A.toString());
    }//GEN-LAST:event_btnInsertarAActionPerformed

    private void btnInsertarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarBActionPerformed
        int coef = Integer.parseInt(tfCoeficiente.getText());
        int exp = Integer.parseInt(tfExponente.getText());
        Monomio M;
        if (cbxSignoCoef.getSelectedItem().equals("+"))
            M = new Monomio('+',coef, exp);
        else
            M = new Monomio('-',coef, exp);
        
        if (!cbxSignoExp.getSelectedItem().equals("+"))
            M.setExp(-exp);
        
        B.Insertar(M);
        
        tfPolinomioB.setText(B.toString());
    }//GEN-LAST:event_btnInsertarBActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        P = new Polinomio();
        if (cbxOperacion.getSelectedItem().equals("+")){
            P.Sumar(A, B);
        }
        else if (cbxOperacion.getSelectedItem().equals("-")){
            P.Restar(A, B);
        }
        else if (cbxOperacion.getSelectedItem().equals("x")){
            P.Multiplicar(A, B);
        }
        
        tfResultado.setText(P.toString());
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnBorrarPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPolActionPerformed
        String options[] = {"A", "B"};
        int option = JOptionPane.showOptionDialog(null, "Polinomio del que desea borrar", "Borrar Polinomio", 0, JOptionPane.QUESTION_MESSAGE, null, options, null);
        if (option == 0){
            A = new Polinomio();
            tfPolinomioA.setText(A.toString());
        }
        else if (option == 1){
            B = new Polinomio();
            tfPolinomioB.setText(B.toString());
        }
    }//GEN-LAST:event_btnBorrarPolActionPerformed

    private void btnBorrarMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarMonActionPerformed
        String options[] = {"A", "B"};
        int option = JOptionPane.showOptionDialog(null, "Polinomio del que desea borrar", "Borrar Monomio", 0, JOptionPane.QUESTION_MESSAGE, null, options, null);
        String monA[] = new String[A.getExps().length];
        for (int i=0; i < monA.length; i++){
            monA[i] = String.valueOf(A.getExps()[i]);
        }
        
        String monB[] = new String[B.getExps().length];
        for (int i=0; i < monB.length; i++){
            monB[i] = String.valueOf(B.getExps()[i]);
        }
        
        if (option == 0){    
            String exp = (JOptionPane.showInputDialog(null,"Seleccionar el exponente del monomio a eliminar","Borrar Monomio",JOptionPane.PLAIN_MESSAGE,null,monA,null)).toString();
            if (exp != null){
                A.Eliminar(Integer.parseInt(exp));
                tfPolinomioA.setText(A.toString());
            }
        }
        else if (option == 1){
            String exp = (JOptionPane.showInputDialog(null,"Seleccionar el exponente del monomio a eliminar","Borrar Monomio",JOptionPane.PLAIN_MESSAGE,null,monB,null)).toString();
            if (exp != null){
                B.Eliminar(Integer.parseInt(exp));
                tfPolinomioB.setText(B.toString());
            }
        }
    }//GEN-LAST:event_btnBorrarMonActionPerformed

    private void btnEvaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluarActionPerformed
        int x = Integer.parseInt(tfX.getText());
        if (cbxSignoX.getSelectedItem().equals("-"))
            x = -x;
    
        String opciones[] = {"A", "B", "Res"};
        int option = JOptionPane.showOptionDialog(null, "Polinomio del que desea borrar", "Borrar Polinomio", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
        
        if (opciones[option].equals("A")){
            lbResultado.setText("A(x = "+x+") = "+A.Evaluar(x));
        }
        else if (opciones[option].equals("B")){
            lbResultado.setText("B(x = "+x+") = "+B.Evaluar(x));
        }
        else{
            lbResultado.setText("Res(x = "+x+") = "+P.Evaluar(x));
        }
    }//GEN-LAST:event_btnEvaluarActionPerformed

    private void tfXKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfXKeyPressed
        char e = evt.getKeyChar();
        int keyCode = evt.getKeyCode();
        if (Character.isDigit(e) | keyCode == KeyEvent.VK_BACK_SPACE)
            esValido = true;
        else
            esValido = false;
    }//GEN-LAST:event_tfXKeyPressed

    private void tfXKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfXKeyReleased
        habilitarEvaluar();
    }//GEN-LAST:event_tfXKeyReleased

    private void tfXKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfXKeyTyped
        if (!esValido){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Introducir solo Numeros");
        }
    }//GEN-LAST:event_tfXKeyTyped

    private void tfPolinomioACaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfPolinomioACaretUpdate
        habilitarOperaciones();
    }//GEN-LAST:event_tfPolinomioACaretUpdate

    private void tfPolinomioBCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfPolinomioBCaretUpdate
        habilitarOperaciones();
    }//GEN-LAST:event_tfPolinomioBCaretUpdate

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FPolinomio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPolinomio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPolinomio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPolinomio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPolinomio().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarMon;
    private javax.swing.JButton btnBorrarPol;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnEvaluar;
    private javax.swing.JButton btnInsertarA;
    private javax.swing.JButton btnInsertarB;
    private javax.swing.JComboBox<String> cbxOperacion;
    private javax.swing.JComboBox<String> cbxSignoCoef;
    private javax.swing.JComboBox<String> cbxSignoExp;
    private javax.swing.JComboBox<String> cbxSignoX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbResultado;
    private javax.swing.JTextField tfCoeficiente;
    private javax.swing.JTextField tfExponente;
    private javax.swing.JTextField tfPolinomioA;
    private javax.swing.JTextField tfPolinomioB;
    private javax.swing.JTextField tfResultado;
    private javax.swing.JTextField tfX;
    // End of variables declaration//GEN-END:variables
}
