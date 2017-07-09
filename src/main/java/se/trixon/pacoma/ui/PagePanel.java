/*
 * Copyright 2017 Patrik Karlsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.trixon.pacoma.ui;

import java.awt.Dimension;
import se.trixon.almond.util.Scaler;
import se.trixon.pacoma.collage.Collage;

/**
 *
 * @author Patrik Karlsson
 */
public class PagePanel extends javax.swing.JPanel {

    private Collage mCollage;

    /**
     * Creates new form PagePanel
     */
    public PagePanel() {
        initComponents();
        init();
    }

    void open(Collage collage) {
        mCollage = collage;
        setBackground(mCollage.getBorderColor());
        resize();

        mCollage.addPropertyChangeListener(() -> {
            setBackground(mCollage.getBorderColor());
            resize();
            repaint();
            revalidate();
        });
    }

    private void init() {
    }

    private void resize() {
        int collageW = mCollage.getWidth();
        int collageH = mCollage.getHeight();
        Dimension collageDimension = new Dimension(collageW, collageH);

        Scaler scaler = new Scaler(collageDimension);

        int parentW = getParent().getWidth();
        int parentH = getParent().getHeight();
        final int MARGIN = 40;
        scaler.setHeight(parentH - MARGIN);
        scaler.setWidth(parentW - MARGIN);

        Dimension scaledDimension = scaler.getDimension();
        setMaximumSize(collageDimension);
        setPreferredSize(scaledDimension);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(100, 100));
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        if (isVisible()) {
            resize();
        }
    }//GEN-LAST:event_formAncestorResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
