package pl.weronikapudlo;

import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text.setBackground( Color.WHITE);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("SansSerif",Font.ROMAN_BASELINE,50));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("O vs X");
        text.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground( Color.BLACK);

        for(int i=0;i<9;i++){

            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("SansSerif",Font.PLAIN,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        title_panel.add(text);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        whoPlay();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i= 0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(Color.LIGHT_GRAY);
                        buttons[i].setText("X");
                        player1_turn=false;
                        text.setText("gra O");
                        game();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(Color.PINK);
                        buttons[i].setText("O");
                        player1_turn=true;
                        text.setText("gra X");
                        game();

                    }
                }
            }
        }
    }
    // czyja kolej
    public void whoPlay(){
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2)==0){
            player1_turn=true;
            text.setText("gra X");
        }
        else{
            player1_turn=true;
            text.setText("gra O");
        }

    }
    //czywygrana
    public void game(){
        //sprawdz czy wygra X
        if(
                (buttons[0].getText()=="X")&&
                (buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")
            ){
                xWon(0,1,2);
        }
        if(
                (buttons[3].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[5].getText()=="X")
        ){
            xWon(3,4,5);
        }if(
                (buttons[6].getText()=="X")&&
                        (buttons[7].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xWon(6,7,8);
        }
        if(
                (buttons[0].getText()=="X")&&
                        (buttons[3].getText()=="X")&&
                        (buttons[6].getText()=="X")
        ){
            xWon(0,3,6);
        }
        if(
                (buttons[1].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[7].getText()=="X")
        ){
            xWon(1,4,7);
        }
        if(
                (buttons[2].getText()=="X")&&
                        (buttons[5].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xWon(2,5,8);
        }
        if(
                (buttons[0].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xWon(0,4,8);
        }
        if(
                (buttons[2].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[6].getText()=="X")
        ){
            xWon(2,4,6);
        }

        //sprawdz czy wygra O
        if(
                (buttons[0].getText()=="O")&&
                        (buttons[1].getText()=="O")&&
                        (buttons[2].getText()=="O")
        ){
            oWon(0,1,2);
        }
        if(
                (buttons[3].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[5].getText()=="O")
        ){
            oWon(3,4,5);
        }if(
                (buttons[6].getText()=="O")&&
                        (buttons[7].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            oWon(6,7,8);
        }
        if(
                (buttons[0].getText()=="O")&&
                        (buttons[3].getText()=="O")&&
                        (buttons[6].getText()=="O")
        ){
            oWon(0,3,6);
        }
        if(
                (buttons[1].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[7].getText()=="O")
        ){
            oWon(1,4,7);
        }
        if(
                (buttons[2].getText()=="O")&&
                        (buttons[5].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            oWon(2,5,8);
        }
        if(
                (buttons[0].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            oWon(0,4,8);
        }
        if(
                (buttons[2].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[6].getText()=="O")
        ){
            oWon(2,4,6);
        }


    }
    //wygra X
    public void xWon(int a, int b, int c){

        buttons[a].setBackground(Color.LIGHT_GRAY);
        buttons[b].setBackground(Color.LIGHT_GRAY);
        buttons[c].setBackground(Color.LIGHT_GRAY);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text.setText("wygrywa X!");
    }
    //wygra O
    public void oWon(int a, int b, int c){
        buttons[a].setBackground(Color.PINK);
        buttons[b].setBackground(Color.PINK);
        buttons[c].setBackground(Color.PINK);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text.setText("wygrywa O!");
    }
}
