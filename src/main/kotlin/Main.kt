import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JComboBox
import java.awt.Container
import java.awt.GridLayout
import java.awt.GridBagLayout
import java.awt.GridBagConstraints
import java.awt.Insets
import javax.swing.SwingUtilities

fun main() {
    //not sure why but the SwingUtilites.invokeLater seems to have solved the initialization bug
    SwingUtilities.invokeLater {
        faerieChessCounterGUI()
    }
}

private fun faerieChessCounterGUI() {
    val frame = JFrame("Faerie Chess Counter")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.layout = GridLayout(0, 4, 10, 10)

    val contentPane = JPanel()
    contentPane.border = BorderFactory.createEmptyBorder(10, 10, 10, 10)
    contentPane.layout = GridBagLayout()

    //rank I
    val rank1PieceCountLabel = JLabel("Rank I Pieces Left: 4")
    contentPane.add(rank1PieceCountLabel, createGridBagConstraints(0, 4, 2, 1))

    var gridY = 0
    addLabel(contentPane, "Rank I selection:", 0, gridY)

    addLabel(contentPane, "Pawns:", 0, ++gridY)
    val pawnDropdown = createDropdown(listOf(4, 5, 6, 7, 8))
    contentPane.add(pawnDropdown, createGridBagConstraints(1, gridY))

    addLabel(contentPane, "Peasants:", 0, ++gridY)
    val peasantDropdown = createDropdown(listOf(0, 1, 2))
    contentPane.add(peasantDropdown, createGridBagConstraints(1, gridY))

    addLabel(contentPane, "Soldiers:", 0, ++gridY)
    val soldierDropdown = createDropdown(listOf(0, 1, 2))
    contentPane.add(soldierDropdown, createGridBagConstraints(1, gridY))

    //updates how many pieces you have left to select for rank I pieces
    fun updateRank1PiecesLabel() {
        val pawnValue = pawnDropdown.selectedItem as Int
        val peasantValue = peasantDropdown.selectedItem as Int
        val soldierValue = soldierDropdown.selectedItem as Int
        val totalRank1Pieces = pawnValue + peasantValue + soldierValue
        rank1PieceCountLabel.text = "Rank I Pieces left: ${8 - totalRank1Pieces}"
    }

    pawnDropdown.addActionListener{
        updateRank1PiecesLabel()
    }
    peasantDropdown.addActionListener{
        updateRank1PiecesLabel()
    }
    soldierDropdown.addActionListener{
        updateRank1PiecesLabel()
    }


    //rank II
    val rank2PieceCountLabel = JLabel("Rank II Pieces Left: 6")
    contentPane.add(rank2PieceCountLabel, createGridBagConstraints(2, 14, 2, 1))

    gridY = 0
    addLabel(contentPane, "Rank II selection:", 2, gridY)

    addLabel(contentPane, "Rooks:", 2, ++gridY)
    val rookDropdown = createDropdown(listOf(0, 1, 2))
    contentPane.add(rookDropdown, createGridBagConstraints(3, gridY))

    addLabel(contentPane, "Knights:", 2, ++gridY)
    val knightDropdown = createDropdown(listOf(0, 1, 2))
    contentPane.add(knightDropdown, createGridBagConstraints(3, gridY))

    addLabel(contentPane, "Bishops:", 2, ++gridY)
    val bishopDropdown = createDropdown(listOf(0, 1, 2))
    contentPane.add(bishopDropdown, createGridBagConstraints(3, gridY))

    addLabel(contentPane, "Catapults:", 2, ++gridY)
    val catapultDropdown = createDropdown(listOf(0, 1))
    contentPane.add(catapultDropdown, createGridBagConstraints(3, gridY))

    addLabel(contentPane, "Chamberlain:", 2, ++gridY)
    val chamberlainDropdown = createDropdown(listOf(0, 1))
    contentPane.add(chamberlainDropdown, createGridBagConstraints(3, gridY))

    addLabel(contentPane, "Courtesan:", 2, ++gridY)
    val courtesanDropdown = createDropdown(listOf(0, 1))
    contentPane.add(courtesanDropdown, createGridBagConstraints(3, gridY))

    addLabel(contentPane, "Herald:", 2, ++gridY)
    val heraldDropdown = createDropdown(listOf(0, 1))
    contentPane.add(heraldDropdown, createGridBagConstraints(3, gridY))

    addLabel(contentPane, "Inquisitor:", 2, ++gridY)
    val inquisitorDropdown = createDropdown(listOf(0, 1))
    contentPane.add(inquisitorDropdown, createGridBagConstraints(3, gridY))

    addLabel(contentPane, "Lancer:", 2, ++gridY)
    val lancerDropdown = createDropdown(listOf(0, 1))
    contentPane.add(lancerDropdown, createGridBagConstraints(3, gridY))

    addLabel(contentPane, "Pontiff:", 2, ++gridY)
    val pontiffDropdown = createDropdown(listOf(0, 1))
    contentPane.add(pontiffDropdown, createGridBagConstraints(3, gridY))

    addLabel(contentPane, "Thief:", 2, ++gridY)
    val thiefDropdown = createDropdown(listOf(0, 1))
    contentPane.add(thiefDropdown, createGridBagConstraints(3, gridY))

    addLabel(contentPane, "Tower:", 2, ++gridY)
    val towerDropdown = createDropdown(listOf(0, 1))
    contentPane.add(towerDropdown, createGridBagConstraints(3, gridY))
    //updates how many pieces you have left to select for rank II pieces
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

    //rank III
    val rank3PieceCountLabel = JLabel("Rank III Pieces Left: 2")
    contentPane.add(rank3PieceCountLabel, createGridBagConstraints(4, 5, 2, 1))

    gridY = 0
    addLabel(contentPane, "Rank III selection:", 4, gridY)

    addLabel(contentPane, "Queen:", 4, ++gridY)
    val queenDropdown = createDropdown(listOf(0, 1))
    contentPane.add(queenDropdown, createGridBagConstraints(5, gridY))

    addLabel(contentPane, "King:", 4, ++gridY)
    val kingDropdown = createDropdown(listOf(0, 1))
    contentPane.add(kingDropdown, createGridBagConstraints(5, gridY))

    addLabel(contentPane, "Jester:", 4, ++gridY)
    val jesterDropdown = createDropdown(listOf(0, 1))
    contentPane.add(jesterDropdown, createGridBagConstraints(5, gridY))

    addLabel(contentPane, "Regent:", 4, ++gridY)
    val regentDropdown = createDropdown(listOf(0, 1))
    contentPane.add(regentDropdown, createGridBagConstraints(5, gridY))
    //updates how many pieces you have left to select for rank III pieces
    fun updateRank3PiecesLabel() {
        val queenValue = queenDropdown.selectedItem as Int
        val kingValue = kingDropdown.selectedItem as Int
        val jesterValue = jesterDropdown.selectedItem as Int
        val regentValue = regentDropdown.selectedItem as Int
        val totalRank1Pieces = queenValue + kingValue + jesterValue + regentValue
        rank3PieceCountLabel.text = "Rank III Pieces left: ${2 - totalRank1Pieces}"
    }

    queenDropdown.addActionListener{
        updateRank3PiecesLabel()
    }
    kingDropdown.addActionListener{
        updateRank3PiecesLabel()
    }
    jesterDropdown.addActionListener{
        updateRank3PiecesLabel()
    }
    regentDropdown.addActionListener{
        updateRank3PiecesLabel()
    }

    //difficulty
    addLabel(contentPane, "Difficulty:", 0, 15)
    val difficultyDropdown = createDropdown(listOf("Beginner", "Intermediate", "Advanced"))
    contentPane.add(difficultyDropdown, createGridBagConstraints(1, 15))

    val resultLabel = JLabel()
    contentPane.add(resultLabel, createGridBagConstraints(0, 17, 2, 1))
    //result label
    frame.contentPane = contentPane
    frame.pack()
    frame.isVisible = true
    //calculate button
    val calculateButton = JButton("Calculate Points")
    calculateButton.addActionListener {
        resultLabel.text = null
        val totalPoints =
            (pawnDropdown.selectedItem as Int) * 1 + (peasantDropdown.selectedItem as Int) * 2 +
                    (soldierDropdown.selectedItem as Int) * 3 + (rookDropdown.selectedItem as Int) * 9 +
                    (knightDropdown.selectedItem as Int) * 4 + (bishopDropdown.selectedItem as Int) * 6 +
                    (catapultDropdown.selectedItem as Int) * 3 + (chamberlainDropdown.selectedItem as Int) * 6 +
                    (courtesanDropdown.selectedItem as Int) * 6 + (heraldDropdown.selectedItem as Int) * 6 +
                    (inquisitorDropdown.selectedItem as Int) * 8 + (lancerDropdown.selectedItem as Int) * 5 +
                    (pontiffDropdown.selectedItem as Int) * 8 + (thiefDropdown.selectedItem as Int) * 5 +
                    (towerDropdown.selectedItem as Int) * 10 + (queenDropdown.selectedItem as Int) * 12 +
                    (kingDropdown.selectedItem as Int) * 0 + (jesterDropdown.selectedItem as Int) * 12 +
                    (regentDropdown.selectedItem as Int) * 15

        val difficulties = mapOf(
            "Beginner" to 65,
            "Intermediate" to 70,
            "Advanced" to 75
        )
        val selectedDifficulty = difficultyDropdown.selectedItem as String
        val remainingPoints = difficulties[selectedDifficulty]!! - totalPoints
        val result = "Total points: $totalPoints\n Remaining points: $remainingPoints"

        resultLabel.text = result
    }

    contentPane.add(calculateButton, createGridBagConstraints(0, 16, 2, 1))
    frame.contentPane = contentPane
    frame.pack()
    frame.isVisible = true
}
//will create the new JLabel provided a string and coordinates
private fun addLabel(
    container: Container,
    labelText: String,
    gridX: Int,
    gridY: Int) {
    val label = JLabel(labelText)
    val constraints = createGridBagConstraints(gridX, gridY)
    container.add(label, constraints)
}
//will create a dropdown provided a list
private fun createDropdown(items: List<Any>): JComboBox<Any> {
    //toTypedArray will convert a list of elements into an array of the right type
    val comboBox = JComboBox(items.toTypedArray())
    comboBox.selectedIndex = 0
    return comboBox
}
//allows me to create consistent components to manage the layout of the application
private fun createGridBagConstraints(gridX: Int, gridY: Int, gridWidth: Int = 1, gridHeight: Int = 1): GridBagConstraints {
    val constraints = GridBagConstraints()
    constraints.gridx = gridX
    constraints.gridy = gridY
    constraints.gridwidth = gridWidth
    constraints.gridheight = gridHeight
    //anchor point set to the left
    constraints.anchor = GridBagConstraints.WEST
    constraints.fill = GridBagConstraints.HORIZONTAL
    //sets padding around the components
    constraints.insets = Insets(5, 5, 5, 5)
    return constraints
}
