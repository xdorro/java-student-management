/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.GUI.area;

import coffeeshop.DTO.User;
import coffeeshop.DTO.Area;
import coffeeshop.DTO.Table;
import coffeeshop.DAO.AreaDao;
import coffeeshop.DAO.BillDao;
import coffeeshop.DAO.TableDao;
import coffeeshop.GUI.table.JDTableInfo;
import coffeeshop.Util.WrapLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import coffeeshop.DTO.Bill;
import coffeeshop.GUI.table.JDDeleteTable;
import coffeeshop.GUI.table.JDModifyTable;
import coffeeshop.Util.Common;
import javax.swing.JPanel;

/**
 *
 * @author Minh
 */
public final class PnlArea extends javax.swing.JPanel implements JDModifyArea.CallbackAreaModify, JDDeleteArea.CallbackAreaDelete, JDModifyTable.CallbackTableModify, JDDeleteTable.CallbackTableDelete, JDTableInfo.CallbackTableExit {

    Frame parent;
    JPanel self;
    Area area = null;
    Table table = null;
    User user = null;
    Bill bill = null;

    List<Area> areas = new ArrayList<>();
    List<Table> tables = new ArrayList<>();

    AreaDao areaDao = new AreaDao();
    TableDao tableDao = new TableDao();
    BillDao billDao = new BillDao();

    /**
     * Creates new form PnlCategory
     */
    public PnlArea(Frame parent, User user) {
        initComponents();
        this.parent = parent;
        this.self = this;
        this.user = user;
        loading();

        if (user.getRole() != 1) {
            lblAdd.setVisible(false);
            lblUpdate.setVisible(false);
            lblDelete.setVisible(false);
        }
    }

    public void loading() {
        tabbedPane.removeAll();
        areas = areaDao.getAll();
        tables = tableDao.getAll();

        areas.forEach(objArea -> {
            JComponent panel = makeTextPanel();
            addTab(tabbedPane, objArea.getName(), panel);
            panel.setName(objArea.getName());

            tables.stream().filter(objTable -> (objTable.getArea_id() == objArea.getId())).forEachOrdered(objTable -> {
                JLabel jp = makeTable(panel, objTable);
            });
        });

        String name = tabbedPane.getSelectedComponent().getName();
        area = areaDao.findByName(name);
    }

    public void addTab(JTabbedPane tabbedPane, String title, Component tab) {
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setViewportView(tab);
        tabbedPane.add(jScrollPane);
        tabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        JLabel lbl = new JLabel(title);
        ImageIcon icon = createImageIcon("/coffeeshop/assets/img/icons8_place_marker_50px.png");
        lbl.setIcon(icon);

// Add some spacing between text and icon, and position text to the RHS.
//        lbl.setIconTextGap(5);
        lbl.setHorizontalTextPosition(SwingConstants.CENTER);
        lbl.setVerticalTextPosition(SwingConstants.BOTTOM);

        tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, lbl);
        jScrollPane.setName(title);
    }

    public JComponent makeTextPanel() {
        javax.swing.JPanel panel = new javax.swing.JPanel(false);
        panel.setLayout(new WrapLayout(WrapLayout.LEFT, 35, 5));
        JLabel jl1 = new JLabel();
        jl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffeeshop/assets/img/icons8_add_new_75px.png"))); // NOI18N
        jl1.setText("Thêm bàn mới");
        jl1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jl1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jl1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jl1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JDModifyTable jdma = new JDModifyTable(parent, true, (JDModifyTable.CallbackTableModify) self, null, area);
                jdma.setVisible(true);
            }
        });

        panel.add(jl1);
        return panel;
    }

    public JLabel makeTable(JComponent panel, Table objTable) {
        JLabel jp = new JLabel();
        jp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffeeshop/assets/img/icons8_table_75px.png"))); // NOI18N
        jp.setText(objTable.getName());

        bill = billDao.getBillByTableId(objTable.getId(), false);

        if (Common.isNullOrEmpty(bill)) {
            jp.setForeground(Color.green);
        } else {
            jp.setForeground(Color.red);
        }

        jp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jp.setVisible(true);
        // Bắt sự kiện click vào bàn
        jp.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table = tableDao.getTableByName(objTable.getName());

                JDTableInfo jDTable = new JDTableInfo(parent, true, (JDTableInfo.CallbackTableExit) this, user, table);
                jDTable.setVisible(true);
            }
        });
        panel.add(jp);
        panel.repaint();
        panel.revalidate();
        return jp;
    }

    protected ImageIcon createImageIcon(String path) {
        ImageIcon imageIcon = new javax.swing.ImageIcon(
                getClass().getResource(path)
        );

        return imageIcon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblAdd = new javax.swing.JLabel();
        lblUpdate = new javax.swing.JLabel();
        lblDelete = new javax.swing.JLabel();
        lblRefresh = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 50, 20));

        lblAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffeeshop/assets/img/icons8_add_50px_2.png"))); // NOI18N
        lblAdd.setText("Thêm mới");
        lblAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddMouseClicked(evt);
            }
        });
        jPanel2.add(lblAdd);

        lblUpdate.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffeeshop/assets/img/icons8_update_50px.png"))); // NOI18N
        lblUpdate.setText("Sửa đổi");
        lblUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUpdateMouseClicked(evt);
            }
        });
        jPanel2.add(lblUpdate);

        lblDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffeeshop/assets/img/icons8_delete_50px.png"))); // NOI18N
        lblDelete.setText("Xoá");
        lblDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteMouseClicked(evt);
            }
        });
        jPanel2.add(lblDelete);

        lblRefresh.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblRefresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffeeshop/assets/img/icons8_repeat_50px_1.png"))); // NOI18N
        lblRefresh.setText("Làm mới");
        lblRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshMouseClicked(evt);
            }
        });
        jPanel2.add(lblRefresh);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        tabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneMouseClicked(evt);
            }
        });
        jPanel1.add(tabbedPane, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseClicked
        JDModifyArea jdma = new JDModifyArea(parent, true, this, null);
        jdma.setVisible(true);
    }//GEN-LAST:event_lblAddMouseClicked

    private void lblUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUpdateMouseClicked
        JDModifyArea jdma = new JDModifyArea(parent, true, this, area);
        jdma.setVisible(true);
    }//GEN-LAST:event_lblUpdateMouseClicked

    private void tabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneMouseClicked
        if (tabbedPane.getComponents().length > 0) {
            String name = tabbedPane.getSelectedComponent().getName();
            area = areaDao.findByName(name);
        }
    }//GEN-LAST:event_tabbedPaneMouseClicked

    private void lblDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteMouseClicked
        JDDeleteArea jdda = new JDDeleteArea(parent, true, this, area);
        jdda.setVisible(true);
    }//GEN-LAST:event_lblDeleteMouseClicked

    private void lblRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseClicked
        loading();
    }//GEN-LAST:event_lblRefreshMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblDelete;
    private javax.swing.JLabel lblRefresh;
    private javax.swing.JLabel lblUpdate;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionAreaModify() {
        loading();
    }

    @Override
    public void actionAreaDelete() {
        loading();
    }

    @Override
    public void actionTableModify() {
        loading();
    }

    @Override
    public void actionTableDelete() {
        loading();
    }

    @Override
    public void actionTableExit() {
        loading();
    }
}
