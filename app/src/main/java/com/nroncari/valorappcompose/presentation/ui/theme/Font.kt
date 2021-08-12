package com.nroncari.valorappcompose.presentation.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.nroncari.valorappcompose.R

val GoogleFontFamily = FontFamily(
    Font(resId = R.font.googlesans_bold, weight = FontWeight.Bold),
    Font(
        resId = R.font.googlesans_bold_italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.googlesans_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(resId = R.font.googlesans_medium, weight = FontWeight.Medium),
    Font(
        resId = R.font.googlesans_medium_italic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),
    Font(resId = R.font.googlesans_regular, weight = FontWeight.Normal),
)