package clinicmanagement.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

public class BaseView extends javax.swing.JFrame {
    private final List<Component> repaintComponents = new ArrayList<>();
    public void addRepaintComponent(Component ...components) {
        this.repaintComponents.addAll(List.of(components));
    }

    @Override
    public void setVisible(boolean visible) {
        if (!this.isVisible() && visible) {
            SwingUtilities.invokeLater(() -> {
                repaintComponents.forEach(Component::repaint);
            });
        }
        super.setVisible(visible);
    }
}
