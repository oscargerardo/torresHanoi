
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends javax.swing.JFrame {

    
    int numeroMovimientos = 0;
    Pila pilaTorreA;
    Pila pilaTorreB;
    Pila pilaTorreC;
    
    //Variables para las tablas
    DefaultTableModel modeloTablaTorreA, modeloTablaTorreB, modeloTablaTorreC;
    
    int objetivo = 0;
    
    double numMinMov = 0;
    
    boolean stop = false;
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        modeloTablaTorreA = (DefaultTableModel) TorreA.getModel();
        modeloTablaTorreA.setRowCount(10);
        
        modeloTablaTorreB = (DefaultTableModel) TorreB.getModel();
        modeloTablaTorreB.setRowCount(10);
        
        modeloTablaTorreC = (DefaultTableModel) TorreC.getModel();
        modeloTablaTorreC.setRowCount(10);
        
        DefaultTableCellRenderer renderA = new DefaultTableCellRenderer();
        renderA.setHorizontalAlignment(SwingConstants.CENTER);
        TorreA.getColumnModel().getColumn(0).setCellRenderer(renderA);
        
        DefaultTableCellRenderer renderB = new DefaultTableCellRenderer();
        renderB.setHorizontalAlignment(SwingConstants.CENTER);
        TorreB.getColumnModel().getColumn(0).setCellRenderer(renderB);
        
        DefaultTableCellRenderer renderC = new DefaultTableCellRenderer();
        renderC.setHorizontalAlignment(SwingConstants.CENTER);
        TorreC.getColumnModel().getColumn(0).setCellRenderer(renderC);
        
    }

    
    private void limpiar(){
        CbNumDiscos.setSelectedItem(String.valueOf(objetivo));
        numeroMovimientos = 0;
        numMinMov = 0;
    }
    
    private void presentarCantidadMovimientos(){
        numeroMovimientos++;
        LvlNumMov.setText(String.valueOf(numeroMovimientos));
        
    }
    
    private void iniciar(){
        
        try {
            limpiar();
            pilaTorreA = new Pila();
            pilaTorreB = new Pila();
            pilaTorreC = new Pila();

            objetivo = Integer.parseInt(CbNumDiscos.getSelectedItem().toString());

            numMinMov = Math.pow(2, objetivo) -1;

            LvlNumMov.setText(String.valueOf(numeroMovimientos));

            LblMinMov.setText(String.valueOf(String.format("%.0f", numMinMov)));


            for(int x = objetivo; x >= 1;x--){
                Nodo plataforma = new Nodo();
                String disco = "";
                for(int y = x; y > 0; y--){
                    disco+= "#";
                }

                plataforma.setDato(disco);
                
                pilaTorreA.push(plataforma);
            }

            presentarTorreA();
            presentarTorreB();
            presentarTorreC();
            
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
        
    }
    
    private void reiniciar(){
        try {
            if(!LblMinMov.getText().equals("")){
                limpiar();
                iniciar();
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    private void presentarTorreA(){
        
        ((DefaultTableModel)TorreA.getModel()).setRowCount(0);
        
        modeloTablaTorreA.setRowCount(10);
        
        Nodo k;
        
        int rowDisco = (10- pilaTorreA.getContadorNodo());
        
        if(pilaTorreA.getContadorNodo() > 0){
            for(k = pilaTorreA.getCabeza(); k.getAbajo() != null; k = k.getAbajo()){
                String[] vectorNormal = {k.getDato()};
                modeloTablaTorreA.insertRow(rowDisco, vectorNormal);
                rowDisco++;
            }
            if(k.getAbajo()==null){
                 String[] vectorNormal = {k.getDato()};
                 modeloTablaTorreA.insertRow(rowDisco, vectorNormal);
            }
        }
        
        TorreA.setModel(modeloTablaTorreA);
        modeloTablaTorreA.setRowCount(10);
    }
    private void presentarTorreB(){
        
        ((DefaultTableModel)TorreB.getModel()).setRowCount(0);
        
        modeloTablaTorreB.setRowCount(10);
        
        Nodo k;
        
        int rowDisco = (10- pilaTorreB.getContadorNodo());
        
        if(pilaTorreB.getContadorNodo() > 0){
            for(k = pilaTorreB.getCabeza(); k.getAbajo() != null; k = k.getAbajo()){
                String[] vectorNormal = {k.getDato()};
                modeloTablaTorreB.insertRow(rowDisco, vectorNormal);
                rowDisco++;
            }
            if(k.getAbajo()==null){
                 String[] vectorNormal = {k.getDato()};
                 modeloTablaTorreB.insertRow(rowDisco, vectorNormal);
            }
        }
        
        TorreB.setModel(modeloTablaTorreB);
        modeloTablaTorreB.setRowCount(10);
        
    }
    private void presentarTorreC(){
        
         ((DefaultTableModel)TorreC.getModel()).setRowCount(0);
        
        modeloTablaTorreC.setRowCount(10);
        
        Nodo k;
        
        int rowDisco = (10- pilaTorreC.getContadorNodo());
        
        if(pilaTorreC.getContadorNodo() > 0){
            for(k = pilaTorreC.getCabeza(); k.getAbajo() != null; k = k.getAbajo()){
                String[] vectorNormal = {k.getDato()};
                modeloTablaTorreC.insertRow(rowDisco, vectorNormal);
                rowDisco++;
            }
            if(k.getAbajo()==null){
                 String[] vectorNormal = {k.getDato()};
                 modeloTablaTorreC.insertRow(rowDisco, vectorNormal);
            }
        }
        
        TorreC.setModel(modeloTablaTorreC);
        modeloTablaTorreC.setRowCount(10);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TorreC = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TorreB = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TorreA = new javax.swing.JTable();
        BtnA_B = new javax.swing.JButton();
        BtnA_C = new javax.swing.JButton();
        BtnB_C = new javax.swing.JButton();
        BtnB_A = new javax.swing.JButton();
        BtnC_B = new javax.swing.JButton();
        BtnC_A = new javax.swing.JButton();
        CbNumDiscos = new javax.swing.JComboBox<>();
        LblMinMov = new javax.swing.JLabel();
        LvlNumMov = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtnReiniciar = new javax.swing.JButton();
        BtnIniciar = new javax.swing.JButton();
        BtnResolver = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TorreC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre C"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreC.setAutoscrolls(false);
        TorreC.setFocusable(false);
        TorreC.setRowSelectionAllowed(false);
        TorreC.setShowHorizontalLines(false);
        TorreC.setShowVerticalLines(false);
        jScrollPane1.setViewportView(TorreC);
        if (TorreC.getColumnModel().getColumnCount() > 0) {
            TorreC.getColumnModel().getColumn(0).setResizable(false);
        }

        TorreB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre B"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreB.setAutoscrolls(false);
        TorreB.setFocusable(false);
        TorreB.setRowSelectionAllowed(false);
        TorreB.setShowHorizontalLines(false);
        TorreB.setShowVerticalLines(false);
        jScrollPane2.setViewportView(TorreB);
        if (TorreB.getColumnModel().getColumnCount() > 0) {
            TorreB.getColumnModel().getColumn(0).setResizable(false);
        }

        TorreA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre A"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreA.setAutoscrolls(false);
        TorreA.setFocusable(false);
        TorreA.setRowSelectionAllowed(false);
        TorreA.setShowHorizontalLines(false);
        TorreA.setShowVerticalLines(false);
        jScrollPane3.setViewportView(TorreA);
        if (TorreA.getColumnModel().getColumnCount() > 0) {
            TorreA.getColumnModel().getColumn(0).setResizable(false);
        }

        BtnA_B.setText("B");
        BtnA_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_BActionPerformed(evt);
            }
        });

        BtnA_C.setText("C");
        BtnA_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_CActionPerformed(evt);
            }
        });

        BtnB_C.setText("C");
        BtnB_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_CActionPerformed(evt);
            }
        });

        BtnB_A.setText("A");
        BtnB_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_AActionPerformed(evt);
            }
        });

        BtnC_B.setText("B");
        BtnC_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_BActionPerformed(evt);
            }
        });

        BtnC_A.setText("A");
        BtnC_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_AActionPerformed(evt);
            }
        });

        CbNumDiscos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));

        LblMinMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblMinMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LvlNumMov.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LvlNumMov.setForeground(new java.awt.Color(255, 51, 51));
        LvlNumMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LvlNumMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Número de discos:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Número de movimientos:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Número mínimo de movimientos:");

        BtnReiniciar.setText("Reiniciar");
        BtnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReiniciarActionPerformed(evt);
            }
        });

        BtnIniciar.setText("Iniciar");
        BtnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIniciarActionPerformed(evt);
            }
        });

        BtnResolver.setText("Resolver");
        BtnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResolverActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel6.setText("Mini Juego Torres de Hanoi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CbNumDiscos, javax.swing.GroupLayout.Alignment.TRAILING, 0, 155, Short.MAX_VALUE)
                            .addComponent(LblMinMov, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LvlNumMov, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(BtnA_B, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnA_C, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172)
                        .addComponent(BtnB_A, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(BtnB_C, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(BtnC_A, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(BtnC_B, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(752, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(237, 237, 237)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(619, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addComponent(BtnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(817, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2, jScrollPane3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnA_B)
                    .addComponent(BtnA_C)
                    .addComponent(BtnB_A)
                    .addComponent(BtnB_C)
                    .addComponent(BtnC_A)
                    .addComponent(BtnC_B))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbNumDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(LblMinMov, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LvlNumMov, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(351, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(615, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(136, 136, 136)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(728, Short.MAX_VALUE)
                    .addComponent(BtnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane2, jScrollPane3});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void moverdeA_B(){
        try {
            if(pilaTorreA.getContadorNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreA.Peek());
                if(pilaTorreB.getContadorNodo()>0){
                    
                    //Comprobar si lo que quiero pasar de A a B es mayor
                    if(plataforma.getDato().compareTo(pilaTorreB.Peek()) > 0){
                        return;
                    }
                
                }
                
                pilaTorreA.pop();
                pilaTorreB.push(plataforma);
                
                presentarTorreA();
                presentarTorreB();
                presentarCantidadMovimientos();
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    private void moverdeA_C(){
         try {
            if(pilaTorreA.getContadorNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreA.Peek());
                if(pilaTorreC.getContadorNodo()>0){
                    
                    //Comprobar si lo que quiero pasar de A a B es mayor
                    if(plataforma.getDato().compareTo(pilaTorreC.Peek()) > 0){
                        return;
                    }
                
                }
                
                pilaTorreA.pop();
                pilaTorreC.push(plataforma);
                
                presentarTorreA();
                presentarTorreC();
                presentarCantidadMovimientos();
                
                if(pilaTorreC.getContadorNodo()==objetivo && numeroMovimientos == numMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades haz alcanzado el objetivo de minimo de movimientos \n \n Intenta con otro nivel de dificultad", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
                }else if(pilaTorreC.getContadorNodo()==objetivo && numeroMovimientos != numMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades lo haz resuelto \n \n Intenta superar el objetivo minimo de movimientos", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    
    private void moverdeB_A(){
         try {
            if(pilaTorreB.getContadorNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreB.Peek());
                if(pilaTorreA.getContadorNodo()>0){
                    
                    //Comprobar si lo que quiero pasar de A a B es mayor
                    if(plataforma.getDato().compareTo(pilaTorreA.Peek()) > 0){
                        return;
                    }
                
                }
                
                pilaTorreB.pop();
                pilaTorreA.push(plataforma);
                
                presentarTorreA();
                presentarTorreB();
                presentarCantidadMovimientos();
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    private void moverdeB_C(){
         try {
            if(pilaTorreB.getContadorNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreB.Peek());
                if(pilaTorreC.getContadorNodo()>0){
                    
                    //Comprobar si lo que quiero pasar de A a B es mayor
                    if(plataforma.getDato().compareTo(pilaTorreC.Peek()) > 0){
                        return;
                    }
                
                }
                
                pilaTorreB.pop();
                pilaTorreC.push(plataforma);
                
                presentarTorreB();
                presentarTorreC();
                presentarCantidadMovimientos();
                
                if(pilaTorreC.getContadorNodo()==objetivo && numeroMovimientos == numMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades haz alcanzado el objetivo de minimo de movimientos \n \n Intenta con otro nivel de dificultad", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
                }else if(pilaTorreC.getContadorNodo()==objetivo && numeroMovimientos != numMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades lo haz resuelto \n \n Intenta superar el objetivo minimo de movimientos", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    private void moverdeC_A(){
         try {
            if(pilaTorreC.getContadorNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreC.Peek());
                if(pilaTorreA.getContadorNodo()>0){
                    
                    //Comprobar si lo que quiero pasar de A a B es mayor
                    if(plataforma.getDato().compareTo(pilaTorreA.Peek()) > 0){
                        return;
                    }
                
                }
                
                pilaTorreC.pop();
                pilaTorreA.push(plataforma);
                
                presentarTorreA();
                presentarTorreC();
                presentarCantidadMovimientos();
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    private void moverdeC_B(){
        try {
            if(pilaTorreC.getContadorNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreC.Peek());
                if(pilaTorreB.getContadorNodo()>0){
                    
                    //Comprobar si lo que quiero pasar de A a B es mayor
                    if(plataforma.getDato().compareTo(pilaTorreB.Peek()) > 0){
                        return;
                    }
                
                }
                
                pilaTorreC.pop();
                pilaTorreB.push(plataforma);
                
                presentarTorreB();
                presentarTorreC();
                presentarCantidadMovimientos();
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    private void BtnA_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnA_CActionPerformed
        moverdeA_C();
    }//GEN-LAST:event_BtnA_CActionPerformed

    private void BtnB_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnB_CActionPerformed
        moverdeB_C();
    }//GEN-LAST:event_BtnB_CActionPerformed

    private void BtnC_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnC_BActionPerformed
        moverdeC_B();
    }//GEN-LAST:event_BtnC_BActionPerformed

    private void BtnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReiniciarActionPerformed
        reiniciar();
    }//GEN-LAST:event_BtnReiniciarActionPerformed

    private void BtnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIniciarActionPerformed
        iniciar();
    }//GEN-LAST:event_BtnIniciarActionPerformed

    
    private void resolverHanoiRecursivo(int n, Pila origen, Pila destino, Pila auxiliar){
        if(n==1){
            moverPlataforma(origen, destino);
        }else{
            resolverHanoiRecursivo(n-1, origen, auxiliar, destino);
            moverPlataforma(origen, destino);
            resolverHanoiRecursivo(n-1, auxiliar, destino, origen);
        }
    }
    
    private void moverPlataforma(Pila origen, Pila destino){
        if(stop == false){
            Nodo plataforma = new Nodo();
            plataforma.setDato(origen.Peek());
            origen.pop();
            destino.push(plataforma);
            presentarTorreA();
            presentarTorreB();
            presentarTorreC();
            presentarCantidadMovimientos();
            
            JOptionPane pane = new JOptionPane("Paso #"+ LvlNumMov.getText()+"\n\n Continuar?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
            
            JDialog dialog = pane.createDialog("Número de pasos");
            
            dialog.setLocation(600, 400);
            
            dialog.setVisible(true);
            
            int opcion = (int) pane.getValue();
            
            if(opcion == JOptionPane.NO_OPTION){
                stop = true;
            } 
        }
    }
    
    
    private void BtnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResolverActionPerformed
        if(!LblMinMov.getText().equals("") && pilaTorreC.getContadorNodo()!= objetivo){
            reiniciar();
            stop = false;
            resolverHanoiRecursivo(objetivo, pilaTorreA, pilaTorreC, pilaTorreB);
        }
    }//GEN-LAST:event_BtnResolverActionPerformed

    
   
    
    private void BtnA_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnA_BActionPerformed
        moverdeA_B();
    }//GEN-LAST:event_BtnA_BActionPerformed

    private void BtnB_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnB_AActionPerformed
        moverdeB_A();
    }//GEN-LAST:event_BtnB_AActionPerformed

    private void BtnC_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnC_AActionPerformed
        moverdeC_A();
    }//GEN-LAST:event_BtnC_AActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnA_B;
    private javax.swing.JButton BtnA_C;
    private javax.swing.JButton BtnB_A;
    private javax.swing.JButton BtnB_C;
    private javax.swing.JButton BtnC_A;
    private javax.swing.JButton BtnC_B;
    private javax.swing.JButton BtnIniciar;
    private javax.swing.JButton BtnReiniciar;
    private javax.swing.JButton BtnResolver;
    private javax.swing.JComboBox<String> CbNumDiscos;
    private javax.swing.JLabel LblMinMov;
    private javax.swing.JLabel LvlNumMov;
    private javax.swing.JTable TorreA;
    private javax.swing.JTable TorreB;
    private javax.swing.JTable TorreC;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
