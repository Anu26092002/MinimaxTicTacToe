<h1 style="text-align:center;">Minimax Algorithm Implemetation in Tic Tac Toe by using Java Swings</h1>
<br/>
<p align="center">
  <img src="https://simo.sh/tic-tac-toe-win.gif" width="400" height="400" alt="tic tac toe gif"/>
</p>
<p> Made with love by <a href="https://www.linkedin.com/in/anurag-g-a01531198/" target="_blank">Anurag Ghosh</a></p>
</br>
<p>
  <h2>Documentation</h2>
  <ul>
    <li> <a href="https://anu26092002.github.io/MinimaxTicTacToe/Documentation/Computer%20class%20Document/minimax/package-summary.html">Documentation of the minimax package </a></li>
    <li> <a href="https://anu26092002.github.io/MinimaxTicTacToe/Documentation/Main%20Class%20Documentation/Main.html
">Documentation of the Main Class</a></li>
  </ul>
<p> The player choice by default is <b>'X'</b> and the computer's or AI Agent's choice is <b>'O'</b> by default. The user can only lose or can be tied with the computer, the next move of the computer is predicted by using the minimax algorithm </p>
<p> The computer first prepares all the possible position of the human player to make his/her move and then chooses the most optimal position as per the minimax algorithm </p>
<p>
  <h3>
    The <abbr title="Performance measure, Environment, Actuator, Sensor">PEAS</abbr> Table for this AL Agent is as followed:
  </h3>
  <table style="width:100%; border: 1px solid black;border-collapse: collapse;">
    <tr>
      <th style="border: 1px solid black;border-collapse: collapse;">Agent</th>
      <th style="border: 1px solid black;border-collapse: collapse;">Performance Measure</th>
      <th style="border: 1px solid black;border-collapse: collapse;">Environment</th>
      <th style="border: 1px solid black;border-collapse: collapse;">Actuator</th>
      <th style="border: 1px solid black;border-collapse: collapse;">Sensors</th>
    </tr>
    <tr>
      <td style="border: 1px solid black;border-collapse: collapse;">
        The agent is always playing as <b>'O'</b> and the human player is always playing as <b>'X'</b>
      </td>
      <td style="border: 1px solid black;border-collapse: collapse;">
        <ul>
          <li>The agent can play the game</li>
          <li>The agent has to place three <b>O’s</b> in a row or prevent three <b>X’s</b> from being placed in a row
          <li>The agent can <b>win</b> the game or at least <b>tie/draw</b></li>
        </ul>
      </td>
      <td style="border: 1px solid black;border-collapse: collapse;">
        <ul>
          <li>The Tic Tac Toe interface or 3x3 Grid i.e blank buttons on the GUI</li>
          <li>Game pieces i.e <b>X's</b> and <b>O's</b></li>
          <li>The laptop/computer</li>
        </ul>
      </td>
      <td style="border: 1px solid black;border-collapse: collapse;">
        <ul>
          <li>The Human Player</li>
          <li>The mouse clicks on laptop/computer</li>
        </ul>
      </td>
      <td style="border: 1px solid black;border-collapse: collapse;">
        The Human Player's Moves
     </td>
    </tr>
  </table>
</p>
<p>
  <h3>The classification of the Tic-Tac-Toe task Environment is as followed:</h3>
  <ul>
    <li><b>Fully observable</b>: Nothing is hidden from the agent. The agent can see all parts of the environment at all times.</li>
    <li><b>Deterministic</b>: The next state of the board is completely determined by the move of the agent.</li>
    <li><b>Sequential</b>: Later moves will depend on what moves were taken previously.</li>
    <li><b>Static</b>: The game board remains constant while the agent is determining its next move.</li>
    <li><b>Discrete</b>: Tic-Tac-Toe has a finite state space.</li>
  </ul>
</p>

