package com.gamovation.core.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.gamovation.core.ui.PreviewDifferentScreenSizes

private val DarkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim
)

@Composable
fun WordefullTheme(
    content: @Composable () -> Unit
) {
    val configuration = LocalConfiguration.current
    val typography = when (configuration.screenWidthDp) {
        412 -> sw412DefaultPangolinTypography
        in 300..319 -> sw300PangolinTypography
        in 320..339 -> sw320PangolinTypography
        in 340..359 -> sw340PangolinTypography
        in 360..379 -> sw360PangolinTypography
        in 380..399 -> sw380PangolinTypography
        in 400..419 -> sw400PangolinTypography
        in 420..439 -> sw420PangolinTypography
        in 440..459 -> sw440PangolinTypography
        in 460..479 -> sw460PangolinTypography
        in 480..499 -> sw480PangolinTypography
        else -> sw412DefaultPangolinTypography
    }

    MaterialTheme(
        colorScheme = DarkColors,
        typography = typography
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@PreviewDifferentScreenSizes
@Composable
fun ThemeP() {
    WordefullTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with displayLarge",
                style = MaterialTheme.typography.displayLarge
            )
            Divider(
                thickness = 16.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with displayMedium",
                style = MaterialTheme.typography.displayMedium
            )
            Divider(
                thickness = 16.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with displaySmall",
                style = MaterialTheme.typography.displaySmall
            )
            Divider(
                thickness = 16.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with headlineLarge",
                style = MaterialTheme.typography.headlineLarge
            )
            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 16.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with headlineMedium",
                style = MaterialTheme.typography.headlineMedium
            )
            Divider(
                thickness = 16.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with headlineSmall",
                style = MaterialTheme.typography.headlineSmall
            )
            Divider(
                thickness = 16.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with titleLarge",
                style = MaterialTheme.typography.titleLarge
            )
            Divider(
                thickness = 16.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with titleMedium",
                style = MaterialTheme.typography.titleMedium
            )
            Divider(
                thickness = 14.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with titleSmall",
                style = MaterialTheme.typography.titleSmall
            )
            Divider(
                thickness = 12.dp
            )
            Text(text = "Example text with bodyLarge", style = MaterialTheme.typography.bodyLarge)
            Divider(
                thickness = 10.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with bodyMedium",
                style = MaterialTheme.typography.bodyMedium
            )
            Divider(
                thickness = 8.dp
            )
            Text(text = "Example text with bodySmall", style = MaterialTheme.typography.bodySmall)
            Divider(
                thickness = 6.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with labelLarge",
                style = MaterialTheme.typography.labelLarge
            )
            Divider(
                thickness = 4.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with labelMedium",
                style = MaterialTheme.typography.labelMedium
            )
            Divider(
                thickness = 2.dp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Example text with labelSmall",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}
