namespace TicTacToe
{
    partial class TicTacToe
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.boardLayout = new System.Windows.Forms.TableLayoutPanel();
            this.button3 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.button5 = new System.Windows.Forms.Button();
            this.button6 = new System.Windows.Forms.Button();
            this.button7 = new System.Windows.Forms.Button();
            this.button8 = new System.Windows.Forms.Button();
            this.button9 = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.btn_reset = new System.Windows.Forms.Button();
            this.rbtn_2Players = new System.Windows.Forms.RadioButton();
            this.rbtn_Easy = new System.Windows.Forms.RadioButton();
            this.rbtn_Hard = new System.Windows.Forms.RadioButton();
            this.playingOptions = new System.Windows.Forms.GroupBox();
            this.boardSize = new System.Windows.Forms.GroupBox();
            this.rbtn_4x4 = new System.Windows.Forms.RadioButton();
            this.rbtn_3x3 = new System.Windows.Forms.RadioButton();
            this.label1 = new System.Windows.Forms.Label();
            this.boardLayout.SuspendLayout();
            this.playingOptions.SuspendLayout();
            this.boardSize.SuspendLayout();
            this.SuspendLayout();
            // 
            // boardLayout
            // 
            this.boardLayout.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.boardLayout.BackColor = System.Drawing.Color.Navy;
            this.boardLayout.CellBorderStyle = System.Windows.Forms.TableLayoutPanelCellBorderStyle.Single;
            this.boardLayout.ColumnCount = 3;
            this.boardLayout.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.boardLayout.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.boardLayout.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.boardLayout.Controls.Add(this.button3, 2, 0);
            this.boardLayout.Controls.Add(this.button4, 0, 1);
            this.boardLayout.Controls.Add(this.button5, 1, 1);
            this.boardLayout.Controls.Add(this.button6, 2, 1);
            this.boardLayout.Controls.Add(this.button7, 0, 2);
            this.boardLayout.Controls.Add(this.button8, 1, 2);
            this.boardLayout.Controls.Add(this.button9, 2, 2);
            this.boardLayout.Controls.Add(this.button1, 0, 0);
            this.boardLayout.Controls.Add(this.button2, 1, 0);
            this.boardLayout.Cursor = System.Windows.Forms.Cursors.Hand;
            this.boardLayout.Font = new System.Drawing.Font("Microsoft Sans Serif", 55.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.boardLayout.ForeColor = System.Drawing.Color.Maroon;
            this.boardLayout.Location = new System.Drawing.Point(163, 179);
            this.boardLayout.Name = "boardLayout";
            this.boardLayout.Padding = new System.Windows.Forms.Padding(3);
            this.boardLayout.RowCount = 3;
            this.boardLayout.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.boardLayout.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.boardLayout.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
            this.boardLayout.Size = new System.Drawing.Size(401, 338);
            this.boardLayout.TabIndex = 0;
            // 
            // button3
            // 
            this.button3.AutoSize = true;
            this.button3.BackColor = System.Drawing.SystemColors.Info;
            this.button3.Location = new System.Drawing.Point(269, 7);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(124, 103);
            this.button3.TabIndex = 2;
            this.button3.UseVisualStyleBackColor = false;
            this.button3.Click += new System.EventHandler(this.button_Click);
            // 
            // button4
            // 
            this.button4.AutoSize = true;
            this.button4.BackColor = System.Drawing.SystemColors.Info;
            this.button4.Location = new System.Drawing.Point(7, 117);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(124, 103);
            this.button4.TabIndex = 3;
            this.button4.UseVisualStyleBackColor = false;
            this.button4.Click += new System.EventHandler(this.button_Click);
            // 
            // button5
            // 
            this.button5.AutoSize = true;
            this.button5.BackColor = System.Drawing.SystemColors.Info;
            this.button5.Location = new System.Drawing.Point(138, 117);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(124, 103);
            this.button5.TabIndex = 4;
            this.button5.UseVisualStyleBackColor = false;
            this.button5.Click += new System.EventHandler(this.button_Click);
            // 
            // button6
            // 
            this.button6.AutoSize = true;
            this.button6.BackColor = System.Drawing.SystemColors.Info;
            this.button6.Location = new System.Drawing.Point(269, 117);
            this.button6.Name = "button6";
            this.button6.Size = new System.Drawing.Size(124, 103);
            this.button6.TabIndex = 5;
            this.button6.UseVisualStyleBackColor = false;
            this.button6.Click += new System.EventHandler(this.button_Click);
            // 
            // button7
            // 
            this.button7.AutoSize = true;
            this.button7.BackColor = System.Drawing.SystemColors.Info;
            this.button7.Location = new System.Drawing.Point(7, 227);
            this.button7.Name = "button7";
            this.button7.Size = new System.Drawing.Size(124, 103);
            this.button7.TabIndex = 6;
            this.button7.UseVisualStyleBackColor = false;
            this.button7.Click += new System.EventHandler(this.button_Click);
            // 
            // button8
            // 
            this.button8.AutoSize = true;
            this.button8.BackColor = System.Drawing.SystemColors.Info;
            this.button8.Location = new System.Drawing.Point(138, 227);
            this.button8.Name = "button8";
            this.button8.Size = new System.Drawing.Size(124, 103);
            this.button8.TabIndex = 7;
            this.button8.UseVisualStyleBackColor = false;
            this.button8.Click += new System.EventHandler(this.button_Click);
            // 
            // button9
            // 
            this.button9.AutoSize = true;
            this.button9.BackColor = System.Drawing.SystemColors.Info;
            this.button9.Location = new System.Drawing.Point(269, 227);
            this.button9.Name = "button9";
            this.button9.Size = new System.Drawing.Size(124, 103);
            this.button9.TabIndex = 8;
            this.button9.UseVisualStyleBackColor = false;
            this.button9.Click += new System.EventHandler(this.button_Click);
            // 
            // button1
            // 
            this.button1.AutoSize = true;
            this.button1.BackColor = System.Drawing.SystemColors.Info;
            this.button1.Location = new System.Drawing.Point(7, 7);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(124, 103);
            this.button1.TabIndex = 0;
            this.button1.UseVisualStyleBackColor = false;
            this.button1.Click += new System.EventHandler(this.button_Click);
            // 
            // button2
            // 
            this.button2.AutoSize = true;
            this.button2.BackColor = System.Drawing.SystemColors.Info;
            this.button2.Location = new System.Drawing.Point(138, 7);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(124, 103);
            this.button2.TabIndex = 1;
            this.button2.UseVisualStyleBackColor = false;
            this.button2.Click += new System.EventHandler(this.button_Click);
            // 
            // btn_reset
            // 
            this.btn_reset.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.btn_reset.AutoSize = true;
            this.btn_reset.BackColor = System.Drawing.SystemColors.Info;
            this.btn_reset.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btn_reset.Font = new System.Drawing.Font("Microsoft Sans Serif", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_reset.ForeColor = System.Drawing.Color.Navy;
            this.btn_reset.Location = new System.Drawing.Point(288, 546);
            this.btn_reset.Name = "btn_reset";
            this.btn_reset.Padding = new System.Windows.Forms.Padding(3);
            this.btn_reset.Size = new System.Drawing.Size(151, 74);
            this.btn_reset.TabIndex = 3;
            this.btn_reset.Text = "RESET";
            this.btn_reset.UseVisualStyleBackColor = false;
            this.btn_reset.Click += new System.EventHandler(this.btn_reset_Click);
            // 
            // rbtn_2Players
            // 
            this.rbtn_2Players.AutoSize = true;
            this.rbtn_2Players.Checked = true;
            this.rbtn_2Players.ForeColor = System.Drawing.Color.Navy;
            this.rbtn_2Players.Location = new System.Drawing.Point(6, 30);
            this.rbtn_2Players.Name = "rbtn_2Players";
            this.rbtn_2Players.Size = new System.Drawing.Size(88, 21);
            this.rbtn_2Players.TabIndex = 4;
            this.rbtn_2Players.TabStop = true;
            this.rbtn_2Players.Text = "2 Players";
            this.rbtn_2Players.UseVisualStyleBackColor = true;
            // 
            // rbtn_Easy
            // 
            this.rbtn_Easy.AutoSize = true;
            this.rbtn_Easy.Location = new System.Drawing.Point(6, 57);
            this.rbtn_Easy.Name = "rbtn_Easy";
            this.rbtn_Easy.Size = new System.Drawing.Size(60, 21);
            this.rbtn_Easy.TabIndex = 5;
            this.rbtn_Easy.Text = "Easy";
            this.rbtn_Easy.UseVisualStyleBackColor = true;
            // 
            // rbtn_Hard
            // 
            this.rbtn_Hard.AutoSize = true;
            this.rbtn_Hard.Location = new System.Drawing.Point(6, 84);
            this.rbtn_Hard.Name = "rbtn_Hard";
            this.rbtn_Hard.Size = new System.Drawing.Size(60, 21);
            this.rbtn_Hard.TabIndex = 6;
            this.rbtn_Hard.Text = "Hard";
            this.rbtn_Hard.UseVisualStyleBackColor = true;
            // 
            // playingOptions
            // 
            this.playingOptions.Controls.Add(this.rbtn_2Players);
            this.playingOptions.Controls.Add(this.rbtn_Hard);
            this.playingOptions.Controls.Add(this.rbtn_Easy);
            this.playingOptions.ForeColor = System.Drawing.Color.Navy;
            this.playingOptions.Location = new System.Drawing.Point(3, 5);
            this.playingOptions.Name = "playingOptions";
            this.playingOptions.Size = new System.Drawing.Size(127, 117);
            this.playingOptions.TabIndex = 7;
            this.playingOptions.TabStop = false;
            this.playingOptions.Text = "Playing Options";
            // 
            // boardSize
            // 
            this.boardSize.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.boardSize.Controls.Add(this.rbtn_4x4);
            this.boardSize.Controls.Add(this.rbtn_3x3);
            this.boardSize.ForeColor = System.Drawing.Color.Navy;
            this.boardSize.Location = new System.Drawing.Point(619, 5);
            this.boardSize.Name = "boardSize";
            this.boardSize.Size = new System.Drawing.Size(104, 88);
            this.boardSize.TabIndex = 8;
            this.boardSize.TabStop = false;
            this.boardSize.Text = "Board Size";
            // 
            // rbtn_4x4
            // 
            this.rbtn_4x4.AutoSize = true;
            this.rbtn_4x4.Location = new System.Drawing.Point(0, 57);
            this.rbtn_4x4.Name = "rbtn_4x4";
            this.rbtn_4x4.Size = new System.Drawing.Size(59, 21);
            this.rbtn_4x4.TabIndex = 1;
            this.rbtn_4x4.Text = "4 x 4";
            this.rbtn_4x4.UseVisualStyleBackColor = true;
            // 
            // rbtn_3x3
            // 
            this.rbtn_3x3.AutoSize = true;
            this.rbtn_3x3.Checked = true;
            this.rbtn_3x3.Location = new System.Drawing.Point(0, 30);
            this.rbtn_3x3.Name = "rbtn_3x3";
            this.rbtn_3x3.Size = new System.Drawing.Size(59, 21);
            this.rbtn_3x3.TabIndex = 0;
            this.rbtn_3x3.TabStop = true;
            this.rbtn_3x3.Text = "3 x 3";
            this.rbtn_3x3.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Maroon;
            this.label1.Location = new System.Drawing.Point(136, 48);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(468, 48);
            this.label1.TabIndex = 9;
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // TicTacToe
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(726, 707);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.boardSize);
            this.Controls.Add(this.playingOptions);
            this.Controls.Add(this.btn_reset);
            this.Controls.Add(this.boardLayout);
            this.Name = "TicTacToe";
            this.Text = "Tic Tac Toe";
            this.boardLayout.ResumeLayout(false);
            this.boardLayout.PerformLayout();
            this.playingOptions.ResumeLayout(false);
            this.playingOptions.PerformLayout();
            this.boardSize.ResumeLayout(false);
            this.boardSize.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel boardLayout;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.Button button6;
        private System.Windows.Forms.Button button7;
        private System.Windows.Forms.Button button8;
        private System.Windows.Forms.Button button9;
        private System.Windows.Forms.Button btn_reset;
        private System.Windows.Forms.RadioButton rbtn_2Players;
        private System.Windows.Forms.RadioButton rbtn_Easy;
        private System.Windows.Forms.RadioButton rbtn_Hard;
        private System.Windows.Forms.GroupBox playingOptions;
        private System.Windows.Forms.GroupBox boardSize;
        private System.Windows.Forms.RadioButton rbtn_4x4;
        private System.Windows.Forms.RadioButton rbtn_3x3;
        private System.Windows.Forms.Label label1;
    }
}

