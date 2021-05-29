package com.demo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HistoryPanel extends JPanel {

    private ElectricityCompany m;

    public HistoryPanel(ElectricityCompany m) {
        this.m = m;
    }

    private int historyMax(List<Integer> history) {
        int max = 0;
        for (Integer num : history) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private int historyMin(List<Integer> history) {
        int min = Integer.MAX_VALUE;
        for (Integer num : history) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    private int historyRange(List<Integer> history) {
        return historyMax(history) - historyMin(history);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        List<Integer> history = m.getHistory();

        int min = historyMin(history);
        int range = historyRange(history);
        int maxX = getWidth() - 1;
        int maxY = getHeight() - 1;
        int zero = maxY + min * maxY / range;

        g.setColor(Color.BLUE);
        g.drawLine(0, zero, maxX, zero);

        int oldX = 0;

        int oldY = zero - history.get(0) * maxY / range;

        for (int i = 0; i < history.size(); i++) {
            int x = 10 * i;
            int y = zero - history.get(i) * maxY / range;
            g.setColor(Color.red);
            g.drawLine(oldX, oldY, x, y);
            oldX = x;
            oldY = y;
        }

    }
}
