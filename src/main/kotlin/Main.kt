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

fun main() {
    faerieChessCounterGUI()
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
    contentPane.add(rank1PieceCountLabel, createGridBagConstraints(0, 5, 2, 1))

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

    //rank III
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
        //!! will never be null
        val result = "Total points: $totalPoints\n Remaining points: $remainingPoints"

        resultLabel.text = result
    }

    contentPane.add(calculateButton, createGridBagConstraints(0, 16, 2, 1))
    frame.contentPane = contentPane
    frame.pack()
    frame.isVisible = true
}

private fun addLabel(
    container: Container,
    labelText: String,
    gridX: Int,
    gridY: Int
) {
    val label = JLabel(labelText)
    val constraints = createGridBagConstraints(gridX, gridY)
    container.add(label, constraints)
}

private fun createDropdown(items: List<Any>): JComboBox<Any> {
    val comboBox = JComboBox(items.toTypedArray())
    comboBox.selectedIndex = 0
    return comboBox
}

private fun createGridBagConstraints(gridX: Int, gridY: Int, gridWidth: Int = 1, gridHeight: Int = 1): GridBagConstraints {
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
