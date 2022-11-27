import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//implementing of interface
public class KolkoKrzyzyk implements ActionListener
{
    Random random = new Random();   //wyznacza, kto zaczyna: kółko czy krzyżyk
    JFrame frame = new JFrame();    // JFrame to kontener najwyższego poziomu, który udostępnia okno na ekranie.
                                    // Ramka jest w rzeczywistości podstawowym oknem, na którym opierają się inne
                                    // komponenty, a mianowicie pasek menu, panele, etykiety, pola tekstowe,
                                    // przyciski itp. Prawie każda inna aplikacja Swing zaczyna się od okna JFrame.

    JPanel title_panel = new JPanel(); //
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    //Constructor
    KolkoKrzyzyk()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(Color.PINK);
        textfield.setForeground(Color.BLACK);
        textfield.setFont(new Font("Monospaced", Font.PLAIN, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Kółko i krzyżyk");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.PINK);

        for (int a=0;a<9;a++)
        {
            buttons[a] = new JButton();
            button_panel.add(buttons[a]);
            buttons[a].setFont(new Font("Courier", Font.BOLD, 120));
            buttons[a].setFocusable(false);
            buttons[a].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 9; i++)
        {
            if (e.getSource() == buttons[i])
            {
                if (player1_turn)
                {
                    if (buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(100, 0,255));
                        buttons[i].setText("+");
                        player1_turn = false;
                        textfield.setText("kolej O");
                        check();
                    }
                }
                else {
                    buttons[i].setForeground(new Color(100, 0,255));
                    buttons[i].setText("o");
                    player1_turn = true;
                    textfield.setText("kolej +");
                    check();
                }
            }
        }
    }

    public void firstTurn()
    {
     // 0 - kolej gracza pierwszego; 1 - kolej gracza drugiego
        if (random.nextInt(2) == 0)
        {
            player1_turn = true;
            textfield.setText("Kolej +");
        }
        else
        {
            player1_turn = false;
            textfield.setText("Kolej O");
        }

    }
    public void check()
    {
        //Sprawdzenie wygranej dla krzyżyka
        if ((buttons[0].getText() == "+") &&
                (buttons[1].getText() == "+") &&
                (buttons[2].getText() == "+"))
        {
            xWins(0, 1, 2);
        }

        if ((buttons[3].getText() == "+") &&
                (buttons[4].getText() == "+") &&
                (buttons[5].getText() == "+"))
        {
            xWins(3, 4, 5);
        }

        if ((buttons[6].getText() == "+") &&
                (buttons[7].getText() == "+") &&
                (buttons[8].getText() == "+"))
        {
            xWins(6, 7, 8);
        }

        if ((buttons[0].getText() == "+") &&
                (buttons[3].getText() == "+") &&
                (buttons[6].getText() == "+"))
        {
            xWins(0, 3, 6);
        }

        if ((buttons[1].getText() == "+") &&
                (buttons[4].getText() == "+") &&
                (buttons[7].getText() == "+"))
        {
            xWins(1, 4, 7);
        }

        if ((buttons[2].getText() == "+") &&
                (buttons[5].getText() == "+") &&
                (buttons[8].getText() == "+"))
        {
            xWins(2, 5, 8);
        }

        if ((buttons[0].getText() == "+") &&
                (buttons[4].getText() == "+") &&
                (buttons[8].getText() == "+"))
        {
            xWins(0, 4, 8);
        }

        if ((buttons[2].getText() == "+") &&
                (buttons[4].getText() == "+") &&
                (buttons[6].getText() == "+"))
        {
            xWins(2, 4, 6);
        }

        //Sprawdzenie wygranej dla kółka

        if ((buttons[0].getText() == "o") &&
                (buttons[1].getText() == "o") &&
                (buttons[2].getText() == "o"))
        {
            oWins(0, 1, 2);
        }

        if ((buttons[3].getText() == "o") &&
                (buttons[4].getText() == "o") &&
                (buttons[5].getText() == "o"))
        {
            oWins(3, 4, 5);
        }

        if ((buttons[6].getText() == "o") &&
                (buttons[7].getText() == "o") &&
                (buttons[8].getText() == "o"))
        {
            oWins(6, 7, 8);
        }

        if ((buttons[0].getText() == "o") &&
                (buttons[3].getText() == "o") &&
                (buttons[6].getText() == "o"))
        {
            oWins(0, 3, 6);
        }

        if ((buttons[1].getText() == "o") &&
                (buttons[4].getText() == "o") &&
                (buttons[7].getText() == "o"))
        {
            oWins(1, 4, 7);
        }

        if ((buttons[2].getText() == "o") &&
                (buttons[5].getText() == "o") &&
                (buttons[8].getText() == "o"))
        {
            oWins(2, 5, 8);
        }

        if ((buttons[0].getText() == "o") &&
                (buttons[4].getText() == "o") &&
                (buttons[8].getText() == "o"))
        {
            oWins(0, 4, 8);
        }

        if ((buttons[2].getText() == "o") &&
                (buttons[4].getText() == "o") &&
                (buttons[6].getText() == "o"))
        {
            oWins(2, 4, 6);
        }
    }

    //Za argumenty przyjmuje numer guzików, które tworzą wygraną;
    // pierwszy wygrany guzik zaczyna się w lewym górnym rogu
    public void xWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }

        textfield.setText("Krzyżyk wygrywa!");

    }

    public void oWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }

        textfield.setText("Kółko wygrywa!");
    }
}
