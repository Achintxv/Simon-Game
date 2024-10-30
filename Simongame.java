import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Simongame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Simon();
            }
        });
    }
}

class Simon extends JFrame implements ActionListener {
    private ArrayList<Integer> sequence;
    private ArrayList<JButton> buttons;
    private int currStep;
    private boolean turn;
    private Timer timer;
    private int currFlash;

    public Simon() {
        setTitle("Simon Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        sequence = new ArrayList<>();
        buttons = new ArrayList<>();
        currStep = 0;
        turn = false;

        for (int i=0; i<4; i++) {
            JButton button = new SimonButton(i);
            button.addActionListener(this);
            buttons.add(button);
            add(button);
        }

        startNewRound();
        setVisible(true);
    }

    private void startNewRound() {
        Random random = new Random();
        sequence.add(random.nextInt(4));
        currStep = 0;
        turn = false;
        playSequence();
    }

    private void playSequence() {
        currFlash = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currFlash < sequence.size()) {
                    buttons.get(sequence.get(currFlash)).setBackground(Color.WHITE);
                    Timer pause = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            buttons.get(sequence.get(currFlash)).setBackground(getButtonColor(sequence.get(currFlash)));
                            currFlash++;
                        }
                    });
                    pause.setRepeats(false);
                    pause.start();
                } else {
                    timer.stop();
                    turn = true;
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    private Color getButtonColor(int index) {
        switch (index) {
            case 0: return Color.RED;
            case 1: return Color.BLUE;
            case 2: return Color.GREEN;
            case 3: return Color.YELLOW;
            default: return Color.BLACK;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!turn) return;

        SimonButton button = (SimonButton) e.getSource();
        if (button.getIndex() == sequence.get(currStep)) {
            currStep++;
            if (currStep == sequence.size()) {
                turn = false;
                startNewRound();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Game Over! Your score is: " + (sequence.size() - 1));
            sequence.clear();
            startNewRound();
        }
    }

    private class SimonButton extends JButton {
        private int index;

        public SimonButton(int index) {
            this.index = index;
            setOpaque(true);
            setBorderPainted(false);
            setBackground(getButtonColor(index));
        }

        public int getIndex() {
            return index;
        }
    }
}
