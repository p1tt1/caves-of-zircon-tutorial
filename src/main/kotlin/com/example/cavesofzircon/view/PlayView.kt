package com.example.cavesofzircon.view

import com.example.cavesofzircon.GameConfig
import org.hexworks.zircon.api.component.ColorTheme
import org.hexworks.zircon.api.grid.TileGrid
import org.hexworks.zircon.api.view.base.BaseView

class PlayView(
    private val grid: TileGrid,
    theme: ColorTheme = GameConfig.THEME
) : BaseView(grid, theme) {

    init {

    }
}