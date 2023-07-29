package com.rendonsoft.beerappdemotest.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rendonsoft.beerappdemotest.R

val Monserrat = FontFamily(
        Font(R.font.montserrat_regular),
        Font(R.font.montserrat_bold, FontWeight.Bold)
)

val typography = Typography(
        displayLarge = TextStyle( //Name channel main
                fontFamily = Monserrat,
                fontWeight =  FontWeight.Normal,
        ),
        headlineMedium = TextStyle( //title Name channel main
                fontFamily = Monserrat,
                fontWeight = FontWeight.Normal,
        ),
        headlineSmall = TextStyle( //Name section
                fontFamily = Monserrat,
                fontWeight = FontWeight.Normal,
        ),
        labelSmall = TextStyle(//channel section
                fontFamily = Monserrat,
                fontWeight =  FontWeight.Normal,
        ),
        bodySmall = TextStyle( //Button text
                fontFamily = Monserrat,
                fontWeight =  FontWeight.Normal,
        )
)