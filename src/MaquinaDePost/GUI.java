/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaquinaDePost;

import javax.swing.Timer;

public class GUI extends javax.swing.JFrame {

    private final String alfabeto1 = "a";
    private final String alfabeto2 = "b";
    private final String alfabeto3 = "c";
    private final String alfabeto4 = "d";
    private final String alfabeto5 = "#";
    private String palavra = "";
    private String contador = "";

    private void geraPalavra(Integer parte1, Integer parte2) {
        for (int i = 0; i < parte1; i++) {
            palavra += alfabeto1;
        }
        for (int i = 0; i < parte2; i++) {
            palavra += alfabeto2;
        }
        txtComputacao.setText(palavra);
    }

    private void limpar() {
        txtComputacao.setText("");
        txtResultado.setText("");
        txtEquacao1.setText("0");
        txtEquacao2.setText("0");
        palavra = "";
        contador = "";

    }

    private void esperar() {
        Timer timer = new Timer(2000, null);
        timer.setRepeats(false);
        timer.setInitialDelay(5000);
        timer.start();
    }

    private void soma() {
        esperar();
        palavra += alfabeto5;
        txtComputacao.setText(txtComputacao.getText() + "\n" + palavra);
        String atual = palavra.substring(0, 1);
        contador = "";
        while (!atual.equals(alfabeto5)) {
            palavra = palavra.substring(1) + alfabeto3;
            atual = palavra.substring(0, 1);
            contador += " ";
            esperar();
            txtComputacao.setText(txtComputacao.getText() + "\n" + contador + palavra);
        }
        if (atual.equals(alfabeto5)) {
            palavra = palavra.substring(1);
            contador += " ";
            esperar();
            txtComputacao.setText(txtComputacao.getText() + "\n" + contador + palavra);
        }
        for (Integer i = 1; i < palavra.length() + 1; i++) {
            txtResultado.setText(i.toString());
        }
    }

    private void subtracao() {
        esperar();
        palavra += alfabeto5;
        txtComputacao.setText(txtComputacao.getText() + "\n" + palavra);
        String atual = palavra.substring(0, 1);
        while (!atual.equals(alfabeto5)) {
            switch (atual) {
                case alfabeto1:
                    int posicao_b = palavra.indexOf(alfabeto2);
                    if (posicao_b != -1) {
                        //palavra += alfabeto3;
                        palavra = palavra.substring(0, posicao_b) + palavra.substring(posicao_b + 1);
                        palavra = palavra.substring(1);
                        contador += "  ";
                    } else {
                        palavra += alfabeto3;
                        palavra = palavra.substring(1);
                        contador += " ";
                    }
                    break;
                case alfabeto2:
                    palavra += alfabeto4;
                    palavra = palavra.substring(1);
            }
            esperar();
            atual = palavra.substring(0, 1);
            txtComputacao.setText(txtComputacao.getText() + "\n" + contador + palavra); 
        }
        if (atual.equals(alfabeto5)) {
            palavra = palavra.substring(1);
            contador += " ";
            esperar();
            txtComputacao.setText(txtComputacao.getText() + "\n" + contador + palavra);
        }
        /*for (Integer i = 0; i < palavra.length(); i++) {
            System.out.println("tamanho: " + palavra.length());
            System.out.println("palavra(" + i + "): " + palavra.charAt(i));
            Integer resultado = 0;
            if (palavra.charAt(i) == 'c') {
                resultado++;
            } 
            if (palavra.charAt(i) == 'd') {
                resultado = resultado - 1;
            }
            txtResultado.setText(resultado.toString());
        }*/
        palavra += alfabeto5;
        atual = palavra.substring(0, 1);
        Integer resultado = 0;
        while (!atual.equals(alfabeto5)) {
            System.out.println(atual);
            switch (atual) {
                case alfabeto3:
                    resultado++;
                    break;
                case alfabeto4:
                    resultado--;
                    break;
            }
            palavra = palavra.substring(1);
            atual = palavra.substring(0, 1);
        }
        esperar();
        txtResultado.setText(resultado.toString());
        /*
        for (Integer i = 1; i < palavra.length() + 1; i++) {
            txtResultado.setText(i.toString());
        }
        */
    }

    public void multiplicacao() {
        esperar();
        palavra += alfabeto5;
        txtComputacao.setText(txtComputacao.getText() + "\n" + palavra);
        String atual = palavra.substring(0, 1);
        contador = "";
        while (!atual.equals(alfabeto5)) {
            switch (atual) {
                case alfabeto1:
                    int posicao_b = palavra.indexOf(alfabeto2);
                    if (posicao_b != -1) {
                        String auxilar = palavra.substring(posicao_b, posicao_b + 1);
                        System.out.println("Posicao b: " + posicao_b);
                        while (auxilar.equals(alfabeto2)) {
                            System.out.println("Auxiliar: " + auxilar);

                            palavra += alfabeto3;
                            posicao_b++;
                            auxilar = palavra.substring(posicao_b, posicao_b + 1);
                        }
                    }
                    esperar();
                    txtComputacao.setText(txtComputacao.getText() + "\n" + contador + palavra);
                    break;
            }
            palavra = palavra.substring(1);
            atual = palavra.substring(0, 1);
            esperar();
            contador += " ";
            txtComputacao.setText(txtComputacao.getText() + "\n" + contador + palavra);
        }
        if (atual.equals(alfabeto5)) {
            palavra = palavra.substring(1);
            contador += " ";
            esperar();
            txtComputacao.setText(txtComputacao.getText() + "\n" + contador + palavra);
        }
        for (Integer i = 1; i < palavra.length() + 1; i++) {
            txtResultado.setText(i.toString());
        }
    }

    public void divisao() {
        esperar();
        palavra += alfabeto5;
        txtComputacao.setText(txtComputacao.getText() + "\n" + palavra);
        contador = "";
        int contador_a = 0;
        int contador_b = 0;
        String auxiliar = "";
        String atual = "";
        // Quantidade de B (Divisor)
        int posicao_b = palavra.indexOf(alfabeto2);
        atual = palavra.substring(posicao_b, posicao_b + 1);
        while (atual.equals(alfabeto2)) {
            contador_b++;
            atual = palavra.substring(posicao_b + contador_b, posicao_b + contador_b + 1);
        }
        //System.out.println("Contador B: " + contador_b);
        int posicao = 0;
        atual = palavra.substring(0, 1);
        while (!atual.equals(alfabeto2)) {
            // Quantidade de A (Dividendo)
            contador_a = 0;
            while (atual.equals(alfabeto1) && contador_a < contador_b) {
                contador_a++;
                atual = palavra.substring(contador_a, contador_a + 1);
            }
            //System.out.println("Contador A: " + contador_a);
            // Remove os iguais
            if (contador_a > 0 && contador_a == contador_b) {
                palavra += alfabeto3;
                palavra = palavra.substring(contador_a);
                for (int i = 0; i < contador_a; i++) {
                    contador += " ";
                }
            } else {
                contador += " ";
                palavra = palavra.substring(1);
            }
            esperar();
            txtComputacao.setText(txtComputacao.getText() + "\n" + contador + palavra);
            atual = palavra.substring(0, 1);
        }
        while (!atual.equals(alfabeto5)) {
            palavra = palavra.substring(1);
            atual = palavra.substring(0, 1);
            contador += " ";
        }
        if (atual.equals(alfabeto5)) {
            palavra = palavra.substring(1);
            contador += " ";
            esperar();
            txtComputacao.setText(txtComputacao.getText() + "\n" + contador + palavra);
        }
        for (Integer i = 1; i < palavra.length() + 1; i++) {
            txtResultado.setText(i.toString());
        }

    }

    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComputacao = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtResultado = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        cboxOperacao = new javax.swing.JComboBox();
        txtEquacao2 = new javax.swing.JTextField();
        txtEquacao1 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        btnExecutar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Máquina de Post");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Máquina de Post");

        txtComputacao.setColumns(20);
        txtComputacao.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        txtComputacao.setRows(5);
        jScrollPane1.setViewportView(txtComputacao);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Computação");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Resultado");

        txtResultado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Equação");

        cboxOperacao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cboxOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+", "-", "/", "*" }));

        txtEquacao2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtEquacao2.setText("0");

        txtEquacao1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtEquacao1.setText("0");
        txtEquacao1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEquacao1KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEquacao1KeyPressed(evt);
            }
        });

        btnExecutar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnExecutar.setText("Executar");
        btnExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel5.setText("https://github.com/brunotonia/MaquinaDePost");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExecutar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(txtEquacao1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEquacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboxOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEquacao1)
                    .addComponent(txtEquacao2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExecutar)
                    .addComponent(btnLimpar)
                    .addComponent(jLabel5))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecutarActionPerformed
        // TODO add your handling code here:
        geraPalavra(new Integer(txtEquacao1.getText()), new Integer(txtEquacao2.getText()));
        switch (cboxOperacao.getSelectedIndex()) {
            case 0:
                soma();
                break;
            case 1:
                subtracao();
                break;
            case 2:
                divisao();
                break;
            case 3:
                multiplicacao();
                break;
        }
    }//GEN-LAST:event_btnExecutarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtEquacao1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquacao1KeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();

        }

    }//GEN-LAST:event_txtEquacao1KeyTyped

    private void txtEquacao1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquacao1KeyPressed

    }//GEN-LAST:event_txtEquacao1KeyPressed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecutar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox cboxOperacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea txtComputacao;
    private javax.swing.JTextField txtEquacao1;
    private javax.swing.JTextField txtEquacao2;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables
}
