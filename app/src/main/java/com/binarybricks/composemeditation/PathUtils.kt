package com.binarybricks.composemeditation

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path

fun Path.standardQuadFromTo(from: Offset, to: Offset) {
    quadraticBezierTo(
        from.x,
        from.y,
        kotlin.math.abs((to.x + from.x) / 2),
        kotlin.math.abs((to.y + from.y) / 2),
    )
}