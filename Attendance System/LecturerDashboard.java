import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LecturerDashboard extends JFrame {

    public LecturerDashboard() {
        // Set up the frame
        setTitle("Lecturer Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create sidebar
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(250, 600));
        sidebar.setBackground(new Color(74, 2, 99));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        // Sidebar title
        JLabel title = new JLabel("Dashboard");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Color.WHITE);
        sidebar.add(title);

        // Sidebar menu items
        String[] menuItems = {"Home", "Classes", "Attendance", "Assessments", "Settings", "Logout"};
        for (String item : menuItems) {
            JButton button = new JButton(item);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setBackground(new Color(74, 2, 99));
            button.setForeground(Color.WHITE);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.setPreferredSize(new Dimension(200, 40));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Action for button click
                    System.out.println(item + " clicked");
                }
            });
            sidebar.add(button);
        }

        // Create main content area
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BorderLayout());
        mainContent.setBackground(Color.LIGHT_GRAY);

        // Header
        JLabel header = new JLabel("Welcome, Lecturer");
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(new Color(51, 51, 51));
        mainContent.add(header, BorderLayout.NORTH);

        // Overview section
        JPanel overview = new JPanel();
        overview.setLayout(new GridLayout(1, 3));
        overview.setBackground(Color.LIGHT_GRAY);

        // Cards for overview
        String[][] cardData = {
            {"Classes", "5 Active"},
            {"Attendance", "85% Recorded"},
            {"Assessments", "3 Pending"}
        };

        for (String[] data : cardData) {
            JPanel card = new JPanel();
            card.setBackground(Color.WHITE);
            card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.add(new JLabel(data[0]));
            card.add(new JLabel(data[1]));
            overview.add(card);
        }

        mainContent.add(overview, BorderLayout.CENTER);

        // Add sidebar and main content to the frame
        add(sidebar, BorderLayout.WEST);
        add(mainContent, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LecturerDashboard dashboard = new LecturerDashboard();
            dashboard.setVisible(true);
        });
    }
}