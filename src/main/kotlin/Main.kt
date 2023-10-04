import java.awt.*
import javax.swing.*

/*
class FaerieChessCounterGUI : JFrame("Faerie Chess Counter") {
    private val frame = this
    private val contentPane = JPanel()
    private val rank1PieceCountLabel = JLabel("Rank I Pieces Left: 4")
    private val pawnDropdown = createDropdown(listOf(4, 5, 6, 7, 8))
    private val peasantDropdown = createDropdown(listOf(0, 1, 2))
    private val soldierDropdown = createDropdown(listOf(0, 1, 2))
    private val rank2PieceCountLabel = JLabel("Rank II Pieces Left: 6")
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
    private val rank3PieceCountLabel = JLabel("Rank III Pieces Left: 0")
    private val queenDropdown = createDropdown(listOf("Queen", "Jester"))
    private val kingDropdown = createDropdown(listOf("King", "Regent"))
    private val difficultyDropdown = createDropdown(listOf("Beginner", "Intermediate", "Advanced"))
    private val resultLabel = JLabel()

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        layout = GridLayout(0, 4, 10, 10)
        contentPane.border = BorderFactory.createEmptyBorder(10, 10, 10, 10)
        contentPane.layout = GridBagLayout()

        setupUI()
        setupListeners()

        pack()
        isVisible = true
    }

    private fun setupUI() {
        var gridY = 0
        addLabel(contentPane, "Rank I Pieces:", 0, gridY, 2)
        contentPane.add(rank1PieceCountLabel, createGridBagConstraints(2, gridY, 2, 1))

        addLabel(contentPane, "Pawns:", 0, ++gridY)
        contentPane.add(pawnDropdown, createGridBagConstraints(1, gridY))

        addLabel(contentPane, "Peasants:", 0, ++gridY)
        contentPane.add(peasantDropdown, createGridBagConstraints(1, gridY))

        addLabel(contentPane, "Soldiers:", 0, ++gridY)
        contentPane.add(soldierDropdown, createGridBagConstraints(1, gridY))

        addLabel(contentPane, "Rank II Pieces:", 2, ++gridY, 2)
        contentPane.add(rank2PieceCountLabel, createGridBagConstraints(4, gridY, 2, 1))

        gridY = 0
        addLabel(contentPane, "Rank I selection:", 0, gridY)

        addLabel(contentPane, "Pawns:", 0, ++gridY)
        contentPane.add(pawnDropdown, createGridBagConstraints(1, gridY))

        addLabel(contentPane, "Peasants:", 0, ++gridY)
        contentPane.add(peasantDropdown, createGridBagConstraints(1, gridY))

        addLabel(contentPane, "Soldiers:", 0, ++gridY)
        contentPane.add(soldierDropdown, createGridBagConstraints(1, gridY))

        gridY = 0
        addLabel(contentPane, "Rank II selection:", 2, gridY)

        addLabel(contentPane, "Rooks:", 2, ++gridY)
        contentPane.add(rookDropdown, createGridBagConstraints(3, gridY))

        addLabel(contentPane, "Knights:", 2, ++gridY)
        contentPane.add(knightDropdown, createGridBagConstraints(3, gridY))

        addLabel(contentPane, "Bishops:", 2, ++gridY)
        contentPane.add(bishopDropdown, createGridBagConstraints(3, gridY))

        addLabel(contentPane, "Catapults:", 2, ++gridY)
        contentPane.add(catapultDropdown, createGridBagConstraints(3, gridY))

        addLabel(contentPane, "Chamberlain:", 2, ++gridY)
        contentPane.add(chamberlainDropdown, createGridBagConstraints(3, gridY))

        addLabel(contentPane, "Courtesan:", 2, ++gridY)
        contentPane.add(courtesanDropdown, createGridBagConstraints(3, gridY))

        addLabel(contentPane, "Herald:", 2, ++gridY)
        contentPane.add(heraldDropdown, createGridBagConstraints(3, gridY))

        addLabel(contentPane, "Inquisitor:", 2, ++gridY)
        contentPane.add(inquisitorDropdown, createGridBagConstraints(3, gridY))

        addLabel(contentPane, "Lancer:", 2, ++gridY)
        contentPane.add(lancerDropdown, createGridBagConstraints(3, gridY))

        addLabel(contentPane, "Pontiff:", 2, ++gridY)
        contentPane.add(pontiffDropdown, createGridBagConstraints(3, gridY))

        addLabel(contentPane, "Thief:", 2, ++gridY)
        contentPane.add(thiefDropdown, createGridBagConstraints(3, gridY))

        addLabel(contentPane, "Tower:", 2, ++gridY)
        contentPane.add(towerDropdown, createGridBagConstraints(3, gridY))

        contentPane.add(rank3PieceCountLabel, createGridBagConstraints(4, 5, 2, 1))
        //RANK III
        gridY = 0
        addLabel(contentPane, "Rank III selection:", 4, gridY)

        addLabel(contentPane, "Queen or Jester:", 4, ++gridY)
        contentPane.add(queenDropdown, createGridBagConstraints(5, gridY))

        addLabel(contentPane, "King or Regent:", 4, ++gridY)
        contentPane.add(kingDropdown, createGridBagConstraints(5, gridY))

        //Difficulty
        addLabel(contentPane, "Difficulty:", 0, 15)
        contentPane.add(difficultyDropdown, createGridBagConstraints(1, 15))

        addLabel(contentPane, "Result:", 0, 17, 2)
        contentPane.add(resultLabel, createGridBagConstraints(2, 17, 4, 1))

        val calculateButton = JButton("Calculate Points")
        contentPane.add(calculateButton, createGridBagConstraints(0, 16, 6, 1))
    }

    private fun setupListeners() {
        pawnDropdown.addActionListener{
            updateRank1PiecesLabel()
        }
        peasantDropdown.addActionListener{
            updateRank1PiecesLabel()
        }
        soldierDropdown.addActionListener{
            updateRank1PiecesLabel()
        }
        rookDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        bishopDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        knightDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        catapultDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        courtesanDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        chamberlainDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        heraldDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        inquisitorDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        lancerDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        pontiffDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        thiefDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        towerDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
    }

    private fun updateRank1PiecesLabel() {

    }
    private fun updateRank2PiecesLabel() {
    }

    private fun calculatePoints() {

    }


    //Will create the new JLabel provided a string and coordinates
    private fun addLabel(
        container: Container,
        labelText: String,
        gridX: Int,
        gridY: Int,
        gridWidth: Int = 1
    ) {
        val label = JLabel(labelText)
        val constraints = createGridBagConstraints(gridX, gridY, gridWidth)
        container.add(label, constraints)
    }

    //Will create a dropdown provided a list
    private fun createDropdown(items: List<Any>): JComboBox<Any> {
        val comboBox = JComboBox(items.toTypedArray())
        comboBox.selectedIndex = 0
        return comboBox
    }

    //Allows me to create consistent components to manage the layout of the application
    private fun createGridBagConstraints(
        gridX: Int,
        gridY: Int,
        gridWidth: Int = 1,
        gridHeight: Int = 1
    ): GridBagConstraints {
        val constraints = GridBagConstraints()
        constraints.gridx = gridX
        constraints.gridy = gridY
        constraints.gridwidth = gridWidth
        constraints.gridheight = gridHeight
        constraints.anchor = GridBagConstraints.WEST
        constraints.fill = GridBagConstraints.HORIZONTAL
        constraints.insets = Insets(5, 5, 5, 5)
        return constraints
    }
}
*/
import javax.swing.*
import javax.swing.BorderFactory
import java.awt.Container
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.GridLayout
import java.awt.Insets

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
    private val rookLabel = JLabel("Rooks:")
    private val knightLabel = JLabel("Knights:")
    private val bishopLabel = JLabel("Bishop:")
    private val rank2PieceCountLabel = JLabel("Rank II Pieces Left: 6")

    private val difficultyLabel = JLabel("Difficulty: ")
    private val difficultyDropdown = createDropdown(listOf("Beginner", "Intermediate", "Advanced"))
    private val calculateButton = JButton("Calculate: ")
    private val resultLabel = JLabel("Points Selected: ")
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
        //rank II
        rank2Label.setBounds(250, 10, 100, 20)

        rookLabel.setBounds(250, 40, 100, 20)
        rookDropdown.setBounds(310, 40,100,20)

        knightLabel.setBounds(250, 70, 100,20)
        knightDropdown.setBounds(310, 70,100,20)

        bishopLabel.setBounds(250, 100, 100,20)
        bishopDropdown.setBounds(310, 100,100,20)

        rank2PieceCountLabel.setBounds(250, 300, 200, 20)

        contentPane.add(rank2Label)
        contentPane.add(rank2PieceCountLabel)
        contentPane.add(rookLabel)
        contentPane.add(rookDropdown)
        contentPane.add(knightLabel)
        contentPane.add(knightDropdown)
        contentPane.add(bishopLabel)
        contentPane.add(bishopDropdown)

        difficultyLabel.setBounds(10, 240, 100, 20)
        difficultyDropdown.setBounds(120, 240, 100, 20)
        calculateButton.setBounds(10,270,200,20)
        resultLabel.setBounds(10, 300, 200, 20)

        contentPane.add(resultLabel)
        contentPane.add(calculateButton)
        contentPane.add(difficultyDropdown)
    }

    private fun setupListeners() {
        pawnDropdown.addActionListener{
            updateRank1PiecesLabel()
        }
        peasantDropdown.addActionListener{
            updateRank1PiecesLabel()
        }
        soldierDropdown.addActionListener{
            updateRank1PiecesLabel()
        }
        rookDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        bishopDropdown.addActionListener{
            updateRank2PiecesLabel()
        }
        knightDropdown.addActionListener{
            updateRank2PiecesLabel()
        }

        calculateButton.addActionListener{
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
        /*
        val chamberlainValue = chamberlainDropdown.selectedItem as Int
        val courtesanValue = courtesanDropdown.selectedItem as Int
        val catapultValue = catapultDropdown.selectedItem as Int
        val heraldValue = heraldDropdown.selectedItem as Int
        val inquisitorValue = inquisitorDropdown.selectedItem as Int
        val lancerValue = lancerDropdown.selectedItem as Int
        val pontiffValue = pontiffDropdown.selectedItem as Int
        val thiefValue = thiefDropdown.selectedItem as Int
        val towerValue = towerDropdown.selectedItem as Int
        */

        val totalRank1Pieces = rookValue + bishopValue + knightValue/* + chamberlainValue +
                catapultValue + courtesanValue + heraldValue + inquisitorValue + lancerValue +
                pontiffValue + thiefValue + towerValue*/
        rank2PieceCountLabel.text = "Rank II Pieces left: ${6 - totalRank1Pieces}"
    }
    fun calculatePoints() {

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