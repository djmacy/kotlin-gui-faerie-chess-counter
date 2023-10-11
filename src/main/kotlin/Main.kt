import java.awt.Dimension

import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JComboBox
import javax.swing.SwingUtilities

enum class pieceWorth(val value: Int) {
    PAWN(1),
    PEASANT(2),
    SOLDIER(3),
    ROOK(9),
    KNIGHT(4),
    BISHOP(6),
    CATAPULT(3),
    CHAMBERLAIN(6),
    COURTESAN(6),
    HERALD(6),
    INQUISITOR(8),
    LANCER(5),
    PONTIFF(8),
    THIEF(5),
    TOWER(10),
    QUEEN(12),
    JESTER(12),
    KING(0),
    REGENT(15)
}

class FaerieChessCounterGUI : JFrame("Faerie Chess Counter") {
    private val rank1Label = JLabel("Rank I Selection")
    private val pawnDropdown = createDropdown(listOf(4, 5, 6, 7, 8))
    private val peasantDropdown = createDropdown(listOf(0, 1, 2))
    private val soldierDropdown = createDropdown(listOf(0, 1, 2))
    private val pawnLabel = JLabel("Pawns:")
    private val peasantLabel = JLabel("Peasants:")
    private val soldierLabel = JLabel("Soldiers:")
    private val rank1PieceCountLabel = JLabel("Rank I Pieces Left: 4")

    private val rank2Label = JLabel("Rank II Selection")
    private val rookDropdown = createDropdown(listOf(0, 1, 2))
    private val knightDropdown = createDropdown(listOf(0, 1, 2))
    private val bishopDropdown = createDropdown(listOf(0, 1, 2))
    private val catapultDropdown = createDropdown(listOf(0, 1))
    private val chamberlainDropdown = createDropdown(listOf(0, 1))
    private val courtesanDropdown = createDropdown(listOf(0, 1))
    private val heraldDropdown = createDropdown(listOf(0, 1))
    private val inquisitorDropdown = createDropdown(listOf(0, 1))
    private val lancerDropdown = createDropdown(listOf(0, 1))
    private val pontiffDropdown = createDropdown(listOf(0, 1))
    private val thiefDropdown = createDropdown(listOf(0, 1))
    private val towerDropdown = createDropdown(listOf(0, 1))
    private val rookLabel = JLabel("Rooks:")
    private val knightLabel = JLabel("Knights:")
    private val bishopLabel = JLabel("Bishop:")
    private val catapultLabel = JLabel("Catapult:")
    private val chamberlainLabel = JLabel("Chamberlain:")
    private val courtesanLabel = JLabel("Courtesan:")
    private val heraldLabel = JLabel("Herald:")
    private val inquisitorLabel = JLabel("Inquisitor:")
    private val lancerLabel = JLabel("Lancer:")
    private val pontiffLabel = JLabel("Pontiff:")
    private val thiefLabel = JLabel("Thief:")
    private val towerLabel = JLabel("Tower:")
    private val rank2PieceCountLabel = JLabel("Rank II Pieces Left: 6")

    private val rank3Label = JLabel("Rank III Selection")
    private val queenOrJesterDropdown = createDropdown(listOf("Queen", "Jester"))
    private val kingOrRegentDropdown = createDropdown(listOf("King", "Regent"))
    private val queenOrJesterLabel = JLabel("Queen or Jester:")
    private val kingOrRegentLabel = JLabel("King or Regent:")
    private val rank3PieceCountLabel = JLabel("Rank II Pieces Left: 0")

    private val difficultyLabel = JLabel("Difficulty: ")
    private val difficultyDropdown = createDropdown(listOf("Beginner", "Intermediate", "Advanced"))
    private val beginnerPoints = 65
    private val intermediatePoints = 70
    private val advancedPoints = 75
    private val resultLabel = JLabel("Total points: 16 Remaining Points: 49")
    private val contentPane = JPanel()

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(800, 600)
        layout = null

        setupUI()
        setupListeners()

        contentPane.preferredSize = Dimension(800, 600)
        contentPane.size = Dimension(800, 600)
        contentPane.layout = null
        setContentPane(contentPane)

        isVisible = true
    }

    private fun setupUI() {
        rank1Label.setBounds(10, 10, 100, 20)

        pawnLabel.setBounds(10, 40, 100, 20)
        pawnDropdown.setBounds(120, 40, 100, 20)

        peasantLabel.setBounds(10, 70, 100, 20)
        peasantDropdown.setBounds(120, 70, 100, 20)

        soldierLabel.setBounds(10, 100, 100, 20)
        soldierDropdown.setBounds(120, 100, 100, 20)

        rank1PieceCountLabel.setBounds(10, 130, 200, 20)

        contentPane.add(rank1Label)
        contentPane.add(rank1PieceCountLabel)
        contentPane.add(pawnLabel)
        contentPane.add(soldierLabel)
        contentPane.add(peasantLabel)
        contentPane.add(pawnDropdown)
        contentPane.add(peasantDropdown)
        contentPane.add(soldierDropdown)
        //Rank II
        rank2Label.setBounds(310, 10, 100, 20)
        rookLabel.setBounds(310, 40, 100, 20)
        rookDropdown.setBounds(390, 40,100,20)
        knightLabel.setBounds(310, 70, 100,20)
        knightDropdown.setBounds(390, 70,100,20)
        bishopLabel.setBounds(310, 100, 100,20)
        bishopDropdown.setBounds(390, 100,100,20)
        catapultLabel.setBounds(310, 130, 100,20)
        catapultDropdown.setBounds(390, 130,100,20)
        courtesanLabel.setBounds(310, 160, 100,20)
        courtesanDropdown.setBounds(390, 160,100,20)
        chamberlainLabel.setBounds(310, 190, 100,20)
        chamberlainDropdown.setBounds(390, 190,100,20)
        heraldLabel.setBounds(310, 220, 100,20)
        heraldDropdown.setBounds(390, 220,100,20)
        inquisitorLabel.setBounds(310, 250, 100,20)
        inquisitorDropdown.setBounds(390, 250,100,20)
        lancerLabel.setBounds(310, 280, 100,20)
        lancerDropdown.setBounds(390, 280,100,20)
        pontiffLabel.setBounds(310, 310, 100,20)
        pontiffDropdown.setBounds(390, 310,100,20)
        thiefLabel.setBounds(310, 340, 100,20)
        thiefDropdown.setBounds(390, 340,100,20)
        towerLabel.setBounds(310, 370, 100,20)
        towerDropdown.setBounds(390, 370,100,20)
        rank2PieceCountLabel.setBounds(310, 400, 200, 20)

        contentPane.add(rank2Label)
        contentPane.add(rank2PieceCountLabel)
        contentPane.add(rookLabel)
        contentPane.add(rookDropdown)
        contentPane.add(knightLabel)
        contentPane.add(knightDropdown)
        contentPane.add(bishopLabel)
        contentPane.add(bishopDropdown)
        contentPane.add(chamberlainDropdown)
        contentPane.add(catapultDropdown)
        contentPane.add(courtesanDropdown)
        contentPane.add(heraldDropdown)
        contentPane.add(inquisitorDropdown)
        contentPane.add(lancerDropdown)
        contentPane.add(pontiffDropdown)
        contentPane.add(thiefDropdown)
        contentPane.add(towerDropdown)
        contentPane.add(chamberlainLabel)
        contentPane.add(courtesanLabel)
        contentPane.add(catapultLabel)
        contentPane.add(heraldLabel)
        contentPane.add(inquisitorLabel)
        contentPane.add(lancerLabel)
        contentPane.add(pontiffLabel)
        contentPane.add(thiefLabel)
        contentPane.add(towerLabel)
        //Rank III
        rank3Label.setBounds(565,10,100,20)
        queenOrJesterLabel.setBounds(565, 40,100,20)
        queenOrJesterDropdown.setBounds(675,40,100,20)
        kingOrRegentLabel.setBounds(565,70,100,20)
        kingOrRegentDropdown.setBounds(675,70,100,20)
        rank3PieceCountLabel.setBounds(565,100,200,20)

        contentPane.add(rank3Label)
        contentPane.add(queenOrJesterLabel)
        contentPane.add(queenOrJesterDropdown)
        contentPane.add(kingOrRegentLabel)
        contentPane.add(kingOrRegentDropdown)
        contentPane.add(rank3PieceCountLabel)

        //Other components
        difficultyLabel.setBounds(10, 240, 100, 20)
        difficultyDropdown.setBounds(120, 240, 100, 20)
        resultLabel.setBounds(10, 300, 220, 20)

        contentPane.add(difficultyLabel)
        contentPane.add(difficultyDropdown)
        contentPane.add(resultLabel)
    }

    private fun setupListeners() {
        pawnDropdown.addActionListener{
            updateRank1PiecesLabel()
            calculatePoints()
        }
        peasantDropdown.addActionListener {
            updateRank1PiecesLabel()
            calculatePoints()
        }
        soldierDropdown.addActionListener {
            updateRank1PiecesLabel()
            calculatePoints()
        }
        rookDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        bishopDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        knightDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        catapultDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        courtesanDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        chamberlainDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        heraldDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        inquisitorDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        lancerDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        pontiffDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        thiefDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        towerDropdown.addActionListener {
            updateRank2PiecesLabel()
            calculatePoints()
        }
        kingOrRegentDropdown.addActionListener {
            calculatePoints()
        }
        difficultyDropdown.addActionListener {
            calculatePoints()
        }
    }
    private fun updateRank1PiecesLabel() {
        val pawnValue = pawnDropdown.selectedItem as Int
        val peasantValue = peasantDropdown.selectedItem as Int
        val soldierValue = soldierDropdown.selectedItem as Int
        val totalRank1Pieces = pawnValue + peasantValue + soldierValue
        rank1PieceCountLabel.text = "Rank I Pieces left: ${8 - totalRank1Pieces}"
    }
    fun updateRank2PiecesLabel() {
        val rookValue = rookDropdown.selectedItem as Int
        val bishopValue = bishopDropdown.selectedItem as Int
        val knightValue = knightDropdown.selectedItem as Int
        val chamberlainValue = chamberlainDropdown.selectedItem as Int
        val courtesanValue = courtesanDropdown.selectedItem as Int
        val catapultValue = catapultDropdown.selectedItem as Int
        val heraldValue = heraldDropdown.selectedItem as Int
        val inquisitorValue = inquisitorDropdown.selectedItem as Int
        val lancerValue = lancerDropdown.selectedItem as Int
        val pontiffValue = pontiffDropdown.selectedItem as Int
        val thiefValue = thiefDropdown.selectedItem as Int
        val towerValue = towerDropdown.selectedItem as Int

        val totalRank1Pieces = rookValue + bishopValue + knightValue + chamberlainValue +
                catapultValue + courtesanValue + heraldValue + inquisitorValue + lancerValue +
                pontiffValue + thiefValue + towerValue
        rank2PieceCountLabel.text = "Rank II Pieces left: ${6 - totalRank1Pieces}"
    }
    fun calculatePoints() {
        var kingOrRegent = if (kingOrRegentDropdown.selectedItem == "King") pieceWorth.KING.value else pieceWorth.REGENT.value
        var queenOrJester = if (queenOrJesterDropdown.selectedItem == "Queen") pieceWorth.QUEEN.value else pieceWorth.JESTER.value
        val totalPoints =
            (pawnDropdown.selectedItem as Int) * pieceWorth.PAWN.value + (peasantDropdown.selectedItem as Int) * pieceWorth.PEASANT.value +
                    (soldierDropdown.selectedItem as Int) * pieceWorth.SOLDIER.value + (rookDropdown.selectedItem as Int) * pieceWorth.SOLDIER.value +
                    (knightDropdown.selectedItem as Int) * pieceWorth.KNIGHT.value + (bishopDropdown.selectedItem as Int) * pieceWorth.BISHOP.value +
                    (catapultDropdown.selectedItem as Int) * pieceWorth.CATAPULT.value + (chamberlainDropdown.selectedItem as Int) * pieceWorth.CHAMBERLAIN.value +
                    (courtesanDropdown.selectedItem as Int) * pieceWorth.COURTESAN.value + (heraldDropdown.selectedItem as Int) * pieceWorth.HERALD.value +
                    (inquisitorDropdown.selectedItem as Int) * pieceWorth.INQUISITOR.value + (lancerDropdown.selectedItem as Int) * pieceWorth.LANCER.value +
                    (pontiffDropdown.selectedItem as Int) * pieceWorth.PONTIFF.value + (thiefDropdown.selectedItem as Int) * pieceWorth.THIEF.value +
                    (towerDropdown.selectedItem as Int) * pieceWorth.TOWER.value + kingOrRegent + queenOrJester

        val difficulties = mapOf(
            "Beginner" to beginnerPoints,
            "Intermediate" to intermediatePoints,
            "Advanced" to advancedPoints
        )

        val selectedDifficulty = difficultyDropdown.selectedItem as String
        val remainingPoints = difficulties[selectedDifficulty]!! - totalPoints
        val result = "Total points: $totalPoints\n Remaining points: $remainingPoints"

        resultLabel.text = result
    }

    private fun createDropdown(items: List<Any>): JComboBox<Any> {
        val comboBox = JComboBox(items.toTypedArray())
        comboBox.selectedIndex = 0
        return comboBox
    }
}

fun main() {
    SwingUtilities.invokeLater {
        FaerieChessCounterGUI()
    }
}