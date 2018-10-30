using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TicTacToe
{
    public partial class TicTacToe : Form
    {
        bool end = false;
        int turn = 0;
        public TicTacToe()
        {
            InitializeComponent();
        }

        private void button_Click(object sender, EventArgs e)
        {
            Button button = sender as Button;
            if (button.Text == "" & !end)
            {
                button.Text = turn % 2 == 0 ? "X" : "O";
                if (checkForWin())
                    winMessage();
                turn++;
                if (rbtn_Easy.Checked & !end)
                {
                    moveRandom();
                }
            }
        }

        
        private bool checkForWin()
        {
            String[,] buttons = new String[3, 3];
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    buttons[i, j] = boardLayout.GetControlFromPosition(i, j).Text;
                }
            }

            for (int i = 0; i < 3; i++)
            {
                if (buttons[i, 0].Equals(buttons[i, 1])
                        & buttons[i, 0].Equals(buttons[i, 2])
                        & !buttons[i, 0].Equals(""))
                {
                    end = true;
                    return true;
                }
            }

            for (int i = 0; i < 3; i++)
            {
                if (buttons[0, i].Equals(buttons[1, i])
                        & buttons[0, i].Equals(buttons[2, i])
                        & !buttons[0, i].Equals(""))
                {
                    end = true;
                    return true;
                }
            }

            if (buttons[0, 0].Equals(buttons[1, 1])
                        & buttons[0, 0].Equals(buttons[2, 2])
                        & !buttons[0, 0].Equals(""))
            {
                end = true;
                return true;
            }

            if (buttons[0, 2].Equals(buttons[1, 1])
                        & buttons[0, 2].Equals(buttons[2, 0])
                        & !buttons[0, 2].Equals(""))
            {
                end = true;
                return true;
            }
            if (turn == 8)
            {
                label1.Text = "Tie Game";
                end = true;
            }
            return false;
        }

        private void btn_reset_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    boardLayout.GetControlFromPosition(i, j).Text = "";
                }
            }
            label1.Text = "";
            turn = 0;
            end = false;
        }
        private void moveRandom()
        {
            Random r = new Random();
            int i;
            int j;
            do
            {
                r = new Random();
                i = r.Next(3);
                r = new Random();
                j = r.Next(3);
            }
            while (boardLayout.GetControlFromPosition(i, j).Text != "");
            boardLayout.GetControlFromPosition(i, j).Text = turn % 2 == 0 ? "X" : "O";
            if (checkForWin())
                winMessage();
            turn++;
        }
        private void winMessage()
        {
            if (rbtn_Easy.Checked)
                label1.Text = (turn % 2 == 0 ? "You win!" : "I win!");
            else 
                label1.Text = (turn % 2 == 0 ? "Player 1 " : "Player 2 ") + "is the winner!";
        }
    }
}

