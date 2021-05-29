package com.demo;

import java.awt.*;

public class ViewHistory extends View{

    private HistoryPanel historyPanel;

    public ViewHistory(ElectricityCompany m, Controller c) throws HeadlessException {
        super(m, c);
        historyPanel = new HistoryPanel(m);
        this.add(historyPanel);
    }

    @Override
    public void update() {
        historyPanel.repaint();
    }
}
