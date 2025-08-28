package dev.jolvera.faus.client.viewBuilders

import dev.jolvera.faus.domain.models.Recurrence
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.control.Separator
import javafx.scene.control.SeparatorMenuItem
import javafx.scene.control.TableCell
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.ToolBar
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Region
import javafx.scene.layout.VBox
import javafx.util.Builder
import javafx.util.Callback
import java.math.BigDecimal

class HomeViewBuilder: Builder<Region> {
    override fun build(): Region {
        return BorderPane().apply {
            top = createMenuAndToolbar()
            center = createRecurrenceTable()
        }
    }

    fun createMenuAndToolbar(): Node {
        return VBox().apply {
            children.addAll(
                createMenu(),
                createToolBar()
            )
        }
    }

    fun createRecurrenceTable(): TableView<Recurrence> {
        return TableView<Recurrence>().apply {
            columns.addAll(
                TableColumn<Recurrence, String>("Name").apply {
                    cellValueFactory = PropertyValueFactory("name")
                    prefWidth = 200.0
                },
                TableColumn<Recurrence, String>("Description").apply {
                    cellValueFactory = PropertyValueFactory("description")
                    prefWidth = 200.0
                },
                TableColumn<Recurrence, BigDecimal>("Amount").apply {
                    cellValueFactory = PropertyValueFactory("amount")
                    prefWidth = 100.0
                    cellFactory = Callback {
                        object : TableCell<Recurrence, BigDecimal>() {
                            override fun updateItem(item: BigDecimal?, empty: Boolean) {
                                super.updateItem(item, empty)
                                text = if (empty || item == null) "" else "$${item.setScale(2)}"
                            }
                        }
                    }

                }
            )
        }
    }

    fun createMenu(): MenuBar {
        return MenuBar().apply {
            menus.addAll(
                Menu("User").apply {
                    items.addAll(
                        MenuItem("Overview"),
                        SeparatorMenuItem(),
                        MenuItem("Log Out")
                    )
                },
                Menu("File").apply {
                    items.addAll(
                        MenuItem("Export"),
                        MenuItem("Import")
                    )
                }
            )
        }
    }

    fun createToolBar(): Region {
        return ToolBar().apply {
            items.addAll(
                Button("Add"),
                Button("Edit"),
                Separator(),
                Label("Filter: "),
                ComboBox<String>().apply {
                    items.addAll("All", "Expenses" ,"Income")
                    value = "All"
                }
            )
        }
    }
}